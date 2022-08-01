package UI.pages;

import UI.pages.accounts.AccountsPage;
import UI.pages.contacts.ContactsPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.ClickOptions.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class HomePage {

    private SelenideElement accounts = $x("//a[@title='Accounts']");
    private SelenideElement contacts = $x("//a[@title='Contacts']");

    @Step("Go to accounts page")
    public AccountsPage goToAccounts() {
        log.info("Go to accounts");
        accounts.shouldBe(visible)
                .click(usingJavaScript());
        return new AccountsPage();
    }

    @Step("Go to contacts page")
    public ContactsPage goToContacts() {
        log.info("Go to contacts");
        contacts.shouldBe(visible)
                .click(usingJavaScript());
        return new ContactsPage();
    }
}
