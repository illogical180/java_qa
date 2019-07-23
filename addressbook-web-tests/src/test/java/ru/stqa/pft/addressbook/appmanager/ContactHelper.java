package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;


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
if(contactData.getGroups().size() > 0) {
    Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }
    //public void uploadContactPhoto(ContactData contactData) {
    //    attach(By.name("photo"), contactData.getPhoto());
    //}

    public void selectContact(int id) {
        driver.findElement(By.cssSelector("input[id='" + id + "']")).click();
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

    public void create(ContactData contactData, boolean b) {
        fillContactCreation(contactData, b);
        //uploadContactPhoto(contactData);
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
    public void moveToGroup(ContactData contact) {
        selectContact(contact.getId());
        driver.findElement(By.name("to_group")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::option[1]")).click();
        driver.findElement(By.name("add")).click();
        driver.findElement(By.linkText("group page \"test 2\"")).click();
        driver.findElement(By.name("group")).click();
        new Select(driver.findElement(By.name("group"))).selectByVisibleText("[all]");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='last 11'])[1]/preceding::option[129]")).click();
    }
    public void checkGroup(ContactData contact) {
        driver.findElement(By.name("group")).click();
        new Select(driver.findElement(By.name("group"))).selectByVisibleText("test 2");

        if(!isElementPresent(By.name("selected[]"))){
            driver.findElement(By.name("group")).click();
            new Select(driver.findElement(By.name("group"))).selectByVisibleText("[all]");
            moveToGroup(contact);
            driver.findElement(By.name("group")).click();
            new Select(driver.findElement(By.name("group"))).selectByVisibleText("test 2");
        }
    }
    public void removeFromGroup(ContactData contact) {
        checkGroup(contact);
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("remove")).click();
        driver.findElement(By.linkText("group page \"test 2\"")).click();
        driver.findElement(By.name("group")).click();
        new Select(driver.findElement(By.name("group"))).selectByVisibleText("[all]");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='last 7'])[1]/preceding::option[2]")).click();
    }
}
//*[@id="right"]/select/option[1]

