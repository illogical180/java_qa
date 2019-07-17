package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {
    private boolean acceptNextAlert = true;

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }
    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void fillContactCreation(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhoneNumber1());
        type(By.name("mobile"), contactData.getPhoneNumber2());
        type(By.name("work"), contactData.getPhoneNumber3());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        if (creation) {

            {
                new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("test1");
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContact(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
    public void deleteSelectedContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void initEditContact() {
        click(By.xpath(".//*[@title='Edit']"));
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void createContact(ContactData contactData, boolean b) {
        fillContactCreation(contactData, b);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }


    public Contacts all() {
        Contacts contacts = new Contacts();
            List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
            for (WebElement row : rows) {
                String name = row.findElement(By.cssSelector("td:nth-child(3)")).getText();
                String surname = row.findElement(By.cssSelector("td:nth-child(2)")).getText();
                int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
                String allEmails = row.findElement(By.cssSelector("td:nth-child(5)")).getText();
                String allPhones = row.findElement(By.cssSelector("td:nth-child(6)")).getText();
                contacts.add(new ContactData().withId(id).withFirstname(name).withLastname(surname)
                        .withAllPhones(allPhones).withAllEmails(allEmails));

            }
            return contacts;
        }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        String email1 = driver.findElement(By.name("email")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");
        driver.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withPhonenumber1(home).withPhonenumber2(mobile).withPhonenumber3(work).withEmail1(email1).withEmail2(email2).withEmail3(email3);

    }
    public ContactData infoFromStatusForm(ContactData contact) {
        initContactStatusById(contact.getId());
        String some = driver.findElement(By.xpath("//*[@id=\"content\"]")).getText();
        driver.navigate().back();
        return new ContactData().withId(contact.getId()).withSome(some);

    }

    private void initContactModificationById(int id){
        WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("//tr[@name='entry']"));
        List<WebElement> cells = row.findElements(By.tagName(
                "td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
    private void initContactStatusById(int id){
        WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("//tr[@name='entry']"));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(6).findElement(By.tagName("a")).click();
    }
    public void delete(ContactData contact) {
        selectContact(contact.getId());
        deleteSelectedContact();
    }
}

