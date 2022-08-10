package UI;

import dto.Account;
import org.testng.annotations.Test;
import utils.Retry;

public class AccountsTest extends BaseTest {

    @Test(description = "Test creation new account with main info specified",
            retryAnalyzer = Retry.class)
    public void createAccountWithMainInfo() {
        Account testAccount = ACCOUNT_WITH_MAIN_INFO;

        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToSalesConsolePage();
        salesConsolePageSteps.goToAccountsPage();
        accountSteps.createAccountWithMainInfo(testAccount);

        accountSteps.checkMainInfoOfCreatedAccount(testAccount);
    }

    @Test(description = "Test creation new account with only required info specified",
            retryAnalyzer = Retry.class)
    public void createAccountWithOnlyRequiredFields() {
        Account testAccount = ACCOUNT_WITH_REQUIRED_FIELDS_ONLY;

        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToSalesConsolePage();
        salesConsolePageSteps.goToAccountsPage();
        accountSteps.createAccountWithRequiredFieldsOnly(testAccount);

        accountSteps.checkRequiredFields(testAccount);
    }

    @Test(description = "Test creation new account with empty fields",
            retryAnalyzer = Retry.class)
    public void createAccountWithEmptyFields() {
        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToSalesConsolePage();
        salesConsolePageSteps.goToAccountsPage();
        accountSteps.createAccountWithEmptyFields();

        accountSteps.checkErrorMessages();
    }
}
