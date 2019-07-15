package ru.stqa.pft.addressbook.tests;

import static org.testng.Assert.*;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class DeleteContact extends TestBase {

    @Test(enabled = false)
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().gotoNewContactPage();
            app.getContactHelper().createContact(new ContactData("Max","Cher","Address","Number1","Number2","Number3","Email","test7"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();


    }

}
