package UI.pages.contacts;

import UI.wrappers.AccountContactInfoValidation;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SingleContactPage {

    private SelenideElement contactFullName = $x("//slot[@name='primaryField']/descendant::span[1]");

    public SingleContactPage checkContactFullName(String expectedContactFullName) {
        new AccountContactInfoValidation("").validateContactTitle(expectedContactFullName);
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
