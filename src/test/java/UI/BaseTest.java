package UI;

import UI.browser.SelenideConfiguration;
import UI.steps.AccountSteps;
import UI.steps.HomePageSteps;
import UI.steps.LoginSteps;

public abstract class BaseTest {

    protected LoginSteps loginSteps;
    protected HomePageSteps homePageSteps;
    protected AccountSteps accountSteps;

    public BaseTest() {
        SelenideConfiguration.configureBrowser("chrome");
        loginSteps = new LoginSteps();
        homePageSteps = new HomePageSteps();
        accountSteps = new AccountSteps();
    }
}
