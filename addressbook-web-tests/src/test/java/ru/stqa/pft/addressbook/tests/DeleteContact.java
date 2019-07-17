package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteContact extends TestBase {

    @BeforeMethod
            public void ensurePreconditions() {
        app.goTo().gotoHomePage();
        if (!app.contact().isThereAContact()) {
            app.goTo().gotoNewContactPage();
            app.contact().createContact(new ContactData().withFirstname("Max").withLastname("Cher").withAddress("Address").withPhonenumber1("Number1").withPhonenumber2("Number2").withPhonenumber3("Number3").withEmail("Email").withGroup("test7"), true);
        }
    }

    @Test
    public void testContactDeletion() {

        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().gotoHomePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedContact)));



    }

}
