package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;
@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String firstname;
    @Expose
    @Column(name = "lastname")
    private String lastname;
    @Transient
    private String address;
    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String phonenumber1;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String phonenumber2;
    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String phonenumber3;
    @Expose
    @Transient
    private String email1;
    @Expose
    @Transient
    private String email2;
    @Expose
    @Transient
    private String email3;
    @Transient
    private String group;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;
    @Transient
    private String some;
    @Expose
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    public String getSome() {
        return some;
    }

    public ContactData withSome(String some) {
        this.some = some;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
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

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
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

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }
}


