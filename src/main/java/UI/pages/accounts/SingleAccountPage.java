package UI.pages.accounts;

import UI.wrappers.AccountInfoValidation;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SingleAccountPage {

    private SelenideElement accountTitle = $x("//slot[@name='primaryField']/descendant::lightning-formatted-text");

    public void checkAccountTitle(String expectedTitle) {
        accountTitle.shouldHave(Condition.exactText(expectedTitle));
    }

    public void checkAccountType(String expectedType) {
        new AccountInfoValidation("Type").validateDisplayedText(expectedType);
    }

    public void checkAccountIndustry(String expectedIndustry) {
        new AccountInfoValidation("Industry").validateDisplayedText(expectedIndustry);
    }

    public void checkAccountPhone(String expectedPhone) {
        new AccountInfoValidation("Phone").validateLinkText(expectedPhone);
    }

    public void checkAccountWebsite(String expectedWebsite) {
        new AccountInfoValidation("Website").validateLinkText(expectedWebsite);
    }

    public void checkAccountOwner(String expectedOwner) {
        new AccountInfoValidation("Account Owner").validateLinkText(expectedOwner);
    }
}
