package UI;

import UI.dto.Account;
import org.testng.annotations.Test;
import utils.AccountUtils;

public class AccountsTest extends BaseTest {

    @Test
    public void createAccountWithMainInfo() {
        Account testAccount = AccountUtils.createAccountWithMainInfo();

        loginSteps.login();
        homePageSteps.goToAccountsPage();
        accountSteps.createAccountWithMainInfo(testAccount);

        accountSteps.checkMainInfoOfCreatedAccount(testAccount);
    }

    @Test
    public void createAccountWithOnlyRequiredFields() {
        Account testAccount = AccountUtils.createAccountWithOnlyRequiredFields();

        loginSteps.login();
        homePageSteps.goToAccountsPage();
        accountSteps.createAccountWithRequiredFieldsOnly(testAccount);

        accountSteps.checkRequiredFields(testAccount);
    }

    @Test
    public void createAccountWithEmptyFields() {
        loginSteps.login();
        homePageSteps.goToAccountsPage();
        accountSteps.createAccountWithEmptyFields();

        accountSteps.checkErrorMessages();
    }
}
