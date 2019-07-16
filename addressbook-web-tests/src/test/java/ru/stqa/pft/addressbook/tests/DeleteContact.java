package ru.stqa.pft.addressbook.tests;

import static org.testng.Assert.*;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class DeleteContact extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        if (!app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().gotoNewContactPage();
            app.getContactHelper().createContact(new ContactData("Max","Cher","Address","Number1","Number2","Number3","Email","test7"), true);
        }
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);


        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);


    }

}
