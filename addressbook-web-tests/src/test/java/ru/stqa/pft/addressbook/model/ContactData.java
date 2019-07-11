package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String phonenumber1;
    private final String phonenumber2;
    private final String phonenumber3;
    private final String email;

    public ContactData(String firstname, String lastname, String address, String phonenumber1, String phonenumber2, String phonenumber3, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber1 = phonenumber1;
        this.phonenumber2 = phonenumber2;
        this.phonenumber3 = phonenumber3;
        this.email = email;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }
    public String getPhoneNumber1() {
        return phonenumber1;
    }
    public String getPhoneNumber2() {
        return phonenumber2;
    }
    public String getPhoneNumber3() {
        return phonenumber3;
    }
    public String getEmail() {
        return email;
    }
}
