package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ModifyContact extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initEditContact();
        app.getContactHelper().fillContactCreation(new ContactData("Max","Cher","Address","Number1","Number2","Number3","Email",null), false);
        app.getContactHelper().submitContactUpdate();
    }
}
