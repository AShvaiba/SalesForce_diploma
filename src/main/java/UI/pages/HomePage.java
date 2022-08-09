package UI.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class HomePage {

    private SelenideElement appLauncher = $(By.className("salesforceIdentityAppLauncherHeader"));
    private SelenideElement salesConsoleApp = $x("//p[text()='Sales Console']");

    @Step("Go to Sales Console page")
    public SalesConsolePage goToSalesConsolePage() {
        log.info("Click app launcher button");
        appLauncher.shouldBe(visible)
                .click();
        log.info("Go to Sales Console page");
        salesConsoleApp.shouldBe(visible)
                .click();
        return new SalesConsolePage();
    }
}
