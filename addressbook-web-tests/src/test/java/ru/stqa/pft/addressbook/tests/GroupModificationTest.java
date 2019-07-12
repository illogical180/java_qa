package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test7",null,null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().SelectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModofication();
        app.getGroupHelper().fillGroupCreation(new GroupData("test7", "test8", "test9"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }
}
