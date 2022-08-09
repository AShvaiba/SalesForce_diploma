package UI;

import API.APIClient.AccountsApi;
import API.APIClient.ContactsApi;
import UI.browser.SelenideConfiguration;
import UI.steps.*;
import data.ITestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class BaseTest implements ITestData {

    protected LoginSteps loginSteps;
    protected HomePageSteps homePageSteps;
    protected SalesConsolePageSteps salesConsolePageSteps;
    protected AccountSteps accountSteps;
    protected ContactSteps contactSteps;

    private AccountsApi accountsApi;
    private ContactsApi contactsApi;

    @BeforeTest(alwaysRun = true)
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
        SelenideConfiguration.configureBrowser("chrome");
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

    @AfterTest(alwaysRun = true)
    public void deletePostConditions() {
        accountsApi.deleteAllAccounts();
        contactsApi.deleteAllContacts();
    }
}
