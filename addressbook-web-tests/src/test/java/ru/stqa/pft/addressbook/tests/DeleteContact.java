package ru.stqa.pft.addressbook.tests;

import static org.testng.Assert.*;
import org.openqa.selenium.*;

import org.testng.annotations.Test;

public class DeleteContact extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();

    }

}
