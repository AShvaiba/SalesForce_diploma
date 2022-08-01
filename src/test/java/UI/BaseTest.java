package UI;

import UI.browser.SelenideConfiguration;
import UI.steps.AccountSteps;
import UI.steps.ContactSteps;
import UI.steps.HomePageSteps;
import UI.steps.LoginSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class BaseTest {

    protected LoginSteps loginSteps;
    protected HomePageSteps homePageSteps;
    protected AccountSteps accountSteps;
    protected ContactSteps contactSteps;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        SelenideConfiguration.configureBrowser("chrome");
        loginSteps = new LoginSteps();
        homePageSteps = new HomePageSteps();
        accountSteps = new AccountSteps();
        contactSteps = new ContactSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        closeWebDriver();
    }
}
