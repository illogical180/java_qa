package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private String firstname;
    private String lastname;
    private String address;
    private String phonenumber1;
    private String phonenumber2;
    private String phonenumber3;
    private String email;
    private int id = Integer.MAX_VALUE;
    private String group;
    private String allPhones;

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }



    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withPhonenumber1(String phonenumber1) {
        this.phonenumber1 = phonenumber1;
        return this;
    }

    public ContactData withPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
        return this;
    }

    public ContactData withPhonenumber3(String phonenumber3) {
        this.phonenumber3 = phonenumber3;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
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
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, id);
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
