package UI;

import UI.dto.Account;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest implements ITestData {

    @Test
    public void createAccountWithMainInfo() {
        Account testAccount = ACCOUNT_WITH_MAIN_INFO;

        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToAccountsPage();
        accountSteps.createAccountWithMainInfo(testAccount);

        accountSteps.checkMainInfoOfCreatedAccount(testAccount);
    }

    @Test
    public void createAccountWithOnlyRequiredFields() {
        Account testAccount = ACCOUNT_WITH_REQUIRED_FIELDS_ONLY;

        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToAccountsPage();
        accountSteps.createAccountWithRequiredFieldsOnly(testAccount);

        accountSteps.checkRequiredFields(testAccount);
    }

    @Test
    public void createAccountWithEmptyFields() {
        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToAccountsPage();
        accountSteps.createAccountWithEmptyFields();

        accountSteps.checkErrorMessages();
    }
}
