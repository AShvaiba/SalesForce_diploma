package UI.pages.accounts;

import dto.Account;
import UI.wrappers.Dropdown;
import UI.wrappers.Input;
import UI.wrappers.InputWithSuggestion;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class NewAccountModal {

    private SelenideElement saveAccount = $x("//button[text()='Save']");

    private SelenideElement accountInfo = $x("//span[text()='Account Information']");

    private SelenideElement errorIcon = $x("//button[@id='window']");

    //error message contents
    private SelenideElement errorText = $x("//h2[text()='We hit a snag.']");

    private SelenideElement fieldsReview = $x("//strong[text()='Review the following fields']");

    private SelenideElement accountNameToReview = $x("//a[text()='Account Name']");

    @Step("Input required fields for the new account")
    public NewAccountModal inputRequiredFieldsOnly(Account account) {
        new Input("Account Name").write(account.getAccountName());
        return this;
    }

    @Step("Input main fields for the new account")
    public NewAccountModal inputMainInfo(Account account) {
        accountInfo.shouldBe(visible);
        new Input("Account Name").write(account.getAccountName());
        new InputWithSuggestion("Parent Account").inputSuggestion(account.getParentAccount());
        new Input("Phone").write(account.getPhone());
        new Input("Fax").write(account.getFax());
        new Input("Website").write(account.getWebsite());
        new Dropdown("Type").select(account.getType());
        new Dropdown("Industry").select(account.getIndustry());
        return this;
    }

    @Step("Click save account")
    public SingleAccountPage saveAccount() {
        accountInfo.shouldBe(visible);
        log.info("Save account");
        saveAccount.click();
        return new SingleAccountPage();
    }

    @Step("Check error icon presence")
    public NewAccountModal checkErrorIconIsDisplayed() {
        errorIcon.shouldBe(visible);
        return this;
    }

    @Step("Check error text presence")
    public NewAccountModal checkErrorTextIsDisplayed() {
        errorText.shouldBe(visible);
        return this;
    }

    @Step("Check fields to review text presence")
    public NewAccountModal checkFieldsToReviewTextDisplayed() {
        fieldsReview.shouldBe(visible);
        return this;
    }

    @Step("Check account name field to review presence")
    public NewAccountModal checkAccountNameFieldToReviewIsDisplayed() {
        accountNameToReview.shouldBe(visible);
        return this;
    }
}
