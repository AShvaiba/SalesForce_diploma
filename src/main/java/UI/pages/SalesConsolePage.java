package UI.pages;

import UI.pages.accounts.AccountsPage;
import UI.pages.contacts.ContactsPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class SalesConsolePage {

    private SelenideElement navigationMenuButton = $x("//button[@title='Show Navigation Menu']");
    private SelenideElement accounts = $x("//span[text()='Accounts']");
    private SelenideElement contacts = $x("//span[text()='Contacts']");
    private ElementsCollection closeButtons = $$x("//button[contains(@title, 'Close')]");

    @Step("Go to accounts page")
    public AccountsPage goToAccounts() {
        log.info("Go to accounts");
        navigationMenuButton.shouldBe(visible)
                .click();
        accounts.shouldBe(visible)
                .click();
        return new AccountsPage();
    }

    @Step("Go to contacts page")
    public ContactsPage goToContacts() {
        log.info("Go to contacts");
        navigationMenuButton.shouldBe(visible)
                .click();
        contacts.shouldBe(visible)
                .click();
        return new ContactsPage();
    }

    @Step("Close all excess tabs")
    public SalesConsolePage closeExcessTabs() {
        for(SelenideElement element : closeButtons) {
            element.click();
        }
        return this;
    }
}
