package UI.pages.accounts;

import UI.dto.Account;
import UI.wrappers.Dropdown;
import UI.wrappers.Input;
import UI.wrappers.InputWithSuggestion;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class NewAccountModal {

    private SelenideElement saveAccount = $("[title='Save']");

    private SelenideElement accountInfo = $x("//span[text()='Account Information']");

    private SelenideElement errorsReviewMessage = $(By.className("genericNotification"));

    private SelenideElement fieldsToCheck = $x("//ul[@class='errorsList']/li");

    @Step("Input required fields for the new account")
    public NewAccountModal inputRequiredFieldsOnly(String accountName) {
        new Input("Account Name").writeForAccount(accountName);
        return this;
    }

    @Step("Input main fields for the new account")
    public NewAccountModal inputMainInfo(Account account) {
        new Input("Account Name").writeForAccount(account.getAccountName());
        new InputWithSuggestion("Parent Account").inputSuggestionForAccount(account.getParentAccount());
        new Input("Phone").writeForAccount(account.getPhone());
        new Input("Fax").writeForAccount(account.getFax());
        new Input("Website").writeForAccount(account.getWebsite());
        new Dropdown("Type").selectForAccount(account.getType());
        new Dropdown("Industry").selectForAccount(account.getIndustry());
        return this;
    }

    @Step("Click save account")
    public SingleAccountPage saveAccount() {
        accountInfo.shouldBe(visible);
        log.info("Save account");
        saveAccount.click();
        return new SingleAccountPage();
    }

    public NewAccountModal checkErrorsReviewMessageText() {
        errorsReviewMessage.shouldHave(exactText("Review the errors on this page."));
        return this;
    }

    public NewAccountModal checkFieldsToCheckText() {
        fieldsToCheck.shouldHave(exactText("These required fields must be completed: Account Name"));
        return this;
    }
}
