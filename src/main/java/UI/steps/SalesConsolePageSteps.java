package UI.steps;

import UI.pages.SalesConsolePage;
import io.qameta.allure.Step;

public class SalesConsolePageSteps {

    private SalesConsolePage salesConsolePage;

    public SalesConsolePageSteps() {
        salesConsolePage = new SalesConsolePage();
    }

    @Step("Go to accounts page")
    public SalesConsolePageSteps goToAccountsPage() {
        salesConsolePage.goToAccounts();
        return this;
    }

    @Step("Go to contacts page")
    public SalesConsolePageSteps goToContactsPage() {
        salesConsolePage.goToContacts();
        return this;
    }
}
