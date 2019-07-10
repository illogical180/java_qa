package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends TestBase {


  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().SelectGroup();
    app.getGroupHelper().DeleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
