package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public void testDbConnection(){
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                            "addressbook?user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select firstname,lastname from addressbook");
            Contacts contacts = new Contacts();
            while(rs.next()){
                contacts.add(new ContactData().withLastname(rs.getString("lastname")).withFirstname(rs.getString("firstname")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(contacts);
            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
