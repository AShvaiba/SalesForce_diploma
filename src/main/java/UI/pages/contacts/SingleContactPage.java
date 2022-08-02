package UI.pages.contacts;

import UI.wrappers.AccountContactInfoValidation;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;

public class SingleContactPage {

    private SelenideElement contactFullName = $x("//div[text()='Contact']/following::span[@data-aura-class='uiOutputText'][1]");

    public SingleContactPage checkContactFullName(String expectedContactFullName) {
        contactFullName.shouldHave(exactText(expectedContactFullName));
        return this;
    }

    public SingleContactPage checkContactTitle(String expectedType) {
        new AccountContactInfoValidation("Title").validateDisplayedText(expectedType);
        return this;
    }

    public SingleContactPage checkAccountName(String expectedAccountName) {
        new AccountContactInfoValidation("Account Name").validateLinkText(expectedAccountName);
        return this;
    }

    public SingleContactPage checkContactPhone(String expectedPhone) {
        new AccountContactInfoValidation("Phone").validateLinkText(expectedPhone);
        return this;
    }

    public SingleContactPage checkContactEmail(String expectedEmail) {
        new AccountContactInfoValidation("Email").validateLinkText(expectedEmail);
        return this;
    }
}
