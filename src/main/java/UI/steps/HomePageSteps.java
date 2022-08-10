package UI.steps;

import UI.pages.HomePage;
import io.qameta.allure.Step;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage();
    }

    @Step("Go to Sales Console page")
    public HomePageSteps goToSalesConsolePage() {
        homePage.goToSalesConsolePage();
        return this;
    }
}
