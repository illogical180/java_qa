package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {

        super(driver);
    }
    public void login(String user, String pass, By xpath, String username, String password) {
        type(By.name(user), username);
        type(By.name(pass), password);
        click(xpath);
    }
}
