package UI.pages.contacts;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ContactsPage {

    private SelenideElement newContactButton = $("a[title=New]");

    @Step("Click create new contact button")
    public NewContactModal goToNewContactWindow() {
        log.info("Go to New Contact modal window");
        newContactButton.shouldBe(visible)
                .click();
        return new NewContactModal();
    }
}
