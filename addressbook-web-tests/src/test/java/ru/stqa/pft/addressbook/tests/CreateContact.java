package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;


import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class CreateContact extends TestBase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @Test
  public void testCreateContact() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().gotoNewContactPage();
    ContactData contact = new ContactData().withFirstname("Max").withLastname("Cher");
    app.contact().createContact(contact,true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId
            (after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));



  }
}
