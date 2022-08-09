package UI.wrappers;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AccountContactInfoValidation extends BaseWrapper{

    public AccountContactInfoValidation(String label) {
        super(label);
    }

    public void validateDisplayedText(String text) {
        $x(String.format("//p[text()='%s']/following-sibling::p/descendant::lightning-formatted-text", label))
                .shouldBe(visible)
                .shouldHave(exactText(text));
    }

    public void validateLinkText(String text) {
        if(label.equals("Account Name")) {
            $x(String.format("//p[text()='%s']/following-sibling::p/descendant::a/descendant::span", label))
                    .shouldBe(visible)
                    .shouldHave(exactText(text));
            return;
        }

        $x(String.format("//p[text()='%s']/following-sibling::p/descendant::a", label))
                .shouldBe(visible)
                .shouldHave(exactText(text));
    }

    public void validateContactTitle(String text) {
        $x(String.format("//span[text()='%s']", text)).shouldBe(visible);
    }
}
