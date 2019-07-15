package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String phonenumber1;
    private final String phonenumber2;
    private final String phonenumber3;
    private final String email;
    private final int id;
    private String group;


    public ContactData(int id, String firstname, String lastname, String address, String phonenumber1, String phonenumber2, String phonenumber3, String email, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber1 = phonenumber1;
        this.phonenumber2 = phonenumber2;
        this.phonenumber3 = phonenumber3;
        this.email = email;
        this.group = group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    public ContactData(String firstname, String lastname, String address, String phonenumber1, String phonenumber2, String phonenumber3, String email, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber1 = phonenumber1;
        this.phonenumber2 = phonenumber2;
        this.phonenumber3 = phonenumber3;
        this.email = email;
        this.group = group;
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

    public String getGroup() {
        return group;
    }
    public int getId() {
        return id;
    }

}
