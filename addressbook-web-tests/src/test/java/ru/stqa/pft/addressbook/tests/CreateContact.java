package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class CreateContact extends TestBase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @Test
  public void testCreateContact() throws Exception {
    app.getNavigationHelper().gotoNewContactPage();
    app.getContactHelper().fillContactCreation(new ContactData("Max","Cher","Address","Number1","Number2","Number3","Email","test7"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();


  }
}
