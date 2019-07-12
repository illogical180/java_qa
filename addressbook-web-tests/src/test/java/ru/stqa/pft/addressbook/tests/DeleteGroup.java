package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class DeleteGroup extends TestBase {


  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test7",null,null));
    }
    app.getGroupHelper().SelectGroup();
    app.getGroupHelper().DeleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
