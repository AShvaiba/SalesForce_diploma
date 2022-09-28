package UI;

import API.APIClient.AccountsApi;
import API.APIClient.ContactsApi;
import UI.browser.SelenideConfiguration;
import UI.steps.*;
import data.ITestData;
import org.testng.annotations.*;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class BaseTest implements ITestData {

    protected LoginSteps loginSteps;
    protected HomePageSteps homePageSteps;
    protected SalesConsolePageSteps salesConsolePageSteps;
    protected AccountSteps accountSteps;
    protected ContactSteps contactSteps;

    private AccountsApi accountsApi;
    private ContactsApi contactsApi;

    @BeforeSuite(alwaysRun = true)
    public void setPreconditions() {
        accountsApi = new AccountsApi();
        contactsApi = new ContactsApi();

        accountsApi.deleteAllAccounts();
        contactsApi.deleteAllContacts();
        accountsApi.createNewAccount(PRECONDITIONS_ACCOUNT, CODE_201_CREATED);
        contactsApi.createNewContact(PRECONDITIONS_CONTACT, CODE_201_CREATED);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String browser = Optional.ofNullable(System.getProperty("browser")).orElse("Chrome");
        SelenideConfiguration.configureBrowser(browser);
        loginSteps = new LoginSteps();
        homePageSteps = new HomePageSteps();
        salesConsolePageSteps = new SalesConsolePageSteps();
        accountSteps = new AccountSteps();
        contactSteps = new ContactSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        closeWebDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void deletePostConditions() {
        accountsApi.deleteAllAccounts();
        contactsApi.deleteAllContacts();
    }
}
