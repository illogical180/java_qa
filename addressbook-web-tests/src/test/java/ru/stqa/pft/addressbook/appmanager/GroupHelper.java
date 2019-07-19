package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.util.List;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupCreation(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void DeleteSelectedGroups() {
        click(By.name("delete"));
    }


    private void SelectGroup() {
        driver.findElement(By.name("selected[]")).click();

    }
    private void SelectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();

    }
    public void initGroupModofication() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupCreation(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }
    public void modify(GroupData group) {
        SelectGroup();
        initGroupModofication();
        fillGroupCreation(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }
    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache!=null){
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void delete(GroupData group) {
        SelectGroupById(group.getId());
        DeleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }


}
