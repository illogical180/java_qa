package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ModifyContact extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Max","Cher",null,null,null,null,null,null);
        if (!app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().gotoNewContactPage();
            app.getContactHelper().createContact(contact, true);
        }
        app.getContactHelper().initEditContact();
        app.getContactHelper().fillContactCreation(contact, false);
        app.getContactHelper().submitContactUpdate();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
