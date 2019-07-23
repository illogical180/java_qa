package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteContactFromGroup extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().contacts().size() == 0){
            app.goTo().gotoHomePage();
            app.contact().create(new ContactData().withFirstname("Max").withLastname("Cher").withAddress("Address").withPhonenumber1("Number1").withPhonenumber2("Number2").withPhonenumber3("Number3").withEmail1("Email"), true);
        }
    }
    @Test
    public void testContactToGroup() {
        app.goTo().gotoHomePage();
        Contacts before = app.db().contacts();
        ContactData removedContact = before.iterator().next();
        app.contact().removeFromGroup(removedContact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(removedContact).withAdded(removedContact)));
        verifyContactListInUI();
    }
}
