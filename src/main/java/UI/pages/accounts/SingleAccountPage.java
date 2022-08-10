package UI.pages.accounts;

import UI.wrappers.AccountContactInfoValidation;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SingleAccountPage {

    private SelenideElement accountTitle = $x("//slot[@name='primaryField']/descendant::lightning-formatted-text");

    public SingleAccountPage checkAccountTitle(String expectedTitle) {
        accountTitle.shouldHave(Condition.exactText(expectedTitle));
        return this;
    }

    public SingleAccountPage checkAccountType(String expectedType) {
        new AccountContactInfoValidation("Type").validateDisplayedText(expectedType);
        return this;
    }

    public SingleAccountPage checkAccountIndustry(String expectedIndustry) {
        new AccountContactInfoValidation("Industry").validateDisplayedText(expectedIndustry);
        return this;
    }

    public SingleAccountPage checkAccountPhone(String expectedPhone) {
        new AccountContactInfoValidation("Phone").validateLinkText(expectedPhone);
        return this;
    }

    public SingleAccountPage checkAccountWebsite(String expectedWebsite) {
        new AccountContactInfoValidation("Website").validateLinkText(expectedWebsite);
        return this;
    }
}
