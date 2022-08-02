package UI.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {

    private SelenideElement usernameField = $(By.id("username"));
    private SelenideElement passwordField = $(By.id("password"));
    private SelenideElement loginButton = $(By.id("Login"));

    @Step("Opening login page on SalesForce")
    public LoginPage openLoginPage() {
        log.info("Open login page");
        open("");
        log.info("Login page opened");
        return this;
    }

    @Step("Enter username")
    public LoginPage enterUsername(String username) {
        log.info("Enter username: {}", username);
        usernameField.sendKeys(username);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        log.info("Enter password: {}", password);
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click login button")
    public HomePage clickLoginButton() {
        log.info("Click login button");
        loginButton.click();
        return new HomePage();
    }
}
