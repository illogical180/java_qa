package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StatusFormTest extends TestBase{
    @Test
    public void testEmail(){
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        ContactData contactInfoFromStatusForm = app.contact().infoFromStatusForm(contact);


        assertThat(cleaned2(mergeSome2(contactInfoFromStatusForm)), equalTo(mergeSome(contactInfoFromEditForm)));

    }

    private String mergeSome(ContactData contact) {
        String collect = Arrays.asList(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber1(), contact.getPhoneNumber2(), contact.getPhoneNumber3(), contact.getEmail1(), contact.getEmail2(), contact.getEmail3() )
                .stream().filter((s) -> !s.equals(""))
                .map(StatusFormTest::cleaned)
                .collect(Collectors.joining(" "));
        return collect;
    }
    private String mergeSome2(ContactData contact) {
        String collect = Arrays.asList(contact.getSome())
                .stream().filter((s) -> !s.equals(""))
                .map(StatusFormTest::cleaned)
                .collect(Collectors.joining(" "));
        return collect;
    }


    public static String cleaned(String phone) {
        return phone.replaceAll("[-()]", "");
    }
    public static String cleaned2(String phone) {
        return phone.replaceAll("H: ", "").replaceAll("M: ", "").replaceAll("W: ", "").replaceAll("\n", " ").replaceAll(" +", " ");
    }
}

