package UI.steps;

import UI.dto.SalesforceUser;
import UI.pages.LoginPage;
import io.qameta.allure.Step;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Login to SalesForce")
    public LoginSteps login(SalesforceUser user) {
        loginPage.openLoginPage()
                .enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLoginButton();
        return this;
    }
}
