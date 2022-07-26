package UI.steps;

import UI.pages.LoginPage;
import io.qameta.allure.Step;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Login to SalesForce")
    public LoginSteps login() {
        loginPage.openLoginPage()
                .enterUsername()
                .enterPassword()
                .clickLoginButton();
        return this;
    }
}
