package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.security.auth.callback.ConfirmationCallback;

public class RegistrationHelper extends HelperBase {
    private WebDriver driver;

    public RegistrationHelper(ApplicationManager app){
        super(app);
        driver = app.getDriver();
    }

    public void start(String username, String email) {
        driver.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.cssSelector("input[value='Signup']"));
    }

    public void finish(String confirmationLink, String password) {
        driver.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
