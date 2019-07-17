package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ModifyContact extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHomePage();
        if (!app.contact().isThereAContact()) {
            app.goTo().gotoNewContactPage();
            app.contact().createContact(new ContactData().withFirstname("Max").withLastname("Cher").withAddress("Address").withPhonenumber1("Number1").withPhonenumber2("Number2").withPhonenumber3("Number3").withEmail("Email").withGroup("test7"), true);
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Max").withLastname("Cher");
        app.contact().initEditContact();
        app.contact().fillContactCreation(contact, false);
        app.contact().submitContactUpdate();
        app.goTo().gotoHomePage();
        Assert.assertEquals(app.contact().count(), before.size() -1);
        Set<ContactData> after = app.contact().all();
        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before,after);

    }
}
