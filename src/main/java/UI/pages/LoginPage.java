package UI.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {

    private SelenideElement usernameField = $(By.id("username"));
    private SelenideElement passwordField = $(By.id("password"));
    private SelenideElement loginButton = $(By.id("Login"));
    private PropertyReader propertyReader = new PropertyReader();

    @Step("Opening login page on SalesForce")
    public LoginPage openLoginPage() {
        log.info("Open login page");
        open("");
        log.info("Login page opened");
        return this;
    }

    @Step("Enter username")
    public LoginPage enterUsername() {
        log.info("Enter username");
        usernameField.sendKeys(propertyReader.getUserName());
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword() {
        log.info("Enter password");
        passwordField.sendKeys(propertyReader.getPassword());
        return this;
    }

    @Step("Click login button")
    public HomePage clickLoginButton() {
        log.info("Click login button");
        loginButton.click();
        return new HomePage();
    }
}
