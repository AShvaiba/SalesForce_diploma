package UI.pages.accounts;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class AccountsPage {

    private SelenideElement newAccountButton = $("a[title=New]");

    @Step("Click create new account button")
    public NewAccountModal goToNewAccountWindow() {
        log.info("Go to New Account modal window");
        newAccountButton.shouldBe(visible)
                .click();
        return new NewAccountModal();
    }
}
