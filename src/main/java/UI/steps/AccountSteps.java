package UI.steps;

import UI.dto.Account;
import UI.pages.accounts.AccountsPage;
import UI.pages.accounts.NewAccountModal;
import UI.pages.accounts.SingleAccountPage;
import io.qameta.allure.Step;

public class AccountSteps {

    private AccountsPage accountsPage;
    private NewAccountModal newAccountModal;
    private SingleAccountPage singleAccountPage;

    public AccountSteps() {
        accountsPage = new AccountsPage();
        newAccountModal = new NewAccountModal();
        singleAccountPage = new SingleAccountPage();
    }

    @Step("Create account with main info")
    public AccountSteps createAccountWithMainInfo(Account account) {
        newAccountModal = accountsPage.goToNewAccountWindow();
        singleAccountPage = newAccountModal.inputMainInfo(account)
                .saveAccount();
        return this;
    }

    @Step("Check main info of the created account")
    public AccountSteps checkMainInfoOfCreatedAccount(Account expectedAccount) {
        singleAccountPage.checkAccountTitle(expectedAccount.getAccountName())
                .checkAccountIndustry(expectedAccount.getIndustry())
                .checkAccountPhone(expectedAccount.getPhone())
                .checkAccountType(expectedAccount.getType())
                .checkAccountWebsite(expectedAccount.getWebsite());
        return this;
    }

    @Step("Check only title of created account")
    public AccountSteps checkRequiredFields(Account account) {
        singleAccountPage.checkAccountTitle(account.getAccountName());
        return this;
    }

    @Step("Create account with required fields only")
    public AccountSteps createAccountWithRequiredFieldsOnly(Account account) {
        newAccountModal = accountsPage.goToNewAccountWindow();
        singleAccountPage = newAccountModal.inputRequiredFieldsOnly(account.getAccountName())
                .saveAccount();
        return this;
    }

    @Step("Create account with empty fields")
    public AccountSteps createAccountWithEmptyFields() {
        newAccountModal = accountsPage.goToNewAccountWindow();
        newAccountModal.saveAccount();
        return this;
    }

    @Step("Check error messages after creation of account with empty fields")
    public AccountSteps checkErrorMessages() {
        newAccountModal.checkErrorsReviewMessageText()
                .checkFieldsToCheckText();
        return this;
    }
}
