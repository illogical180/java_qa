package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContact extends TestBase {
  Logger logger = LoggerFactory.getLogger(GroupCreationTest.class);
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @DataProvider
  public Iterator<Object[]> contactsFromJson() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("file","src/test/resources/contacts.json"))))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }
  @Test(dataProvider = "contactsFromJson")
  public void testCreateContact(ContactData contact) throws Exception {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    contact.inGroup(groups.iterator().next());
    app.goTo().gotoNewContactPage();
    File photo = new File("src/test/resources/khfno.jpg");
    app.contact().create(contact,true);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId
            (after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    verifyContactListInUI();


  }
@Test(enabled = false)
  public void testCurrentDir(){
    File currentDir = new File(".");
  System.out.println(currentDir.getAbsolutePath());
  File photo = new File("src/test/resources/khfno.jpg");
  System.out.println(photo.getAbsolutePath());
  System.out.println(photo.exists());
  }
}
