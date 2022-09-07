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
        salesConsolePage.closeExcessTabs()
                .goToAccounts();
        return this;
    }

    @Step("Go to contacts page")
    public SalesConsolePageSteps goToContactsPage() {
        salesConsolePage.closeExcessTabs()
                .goToContacts();
        return this;
    }
}
