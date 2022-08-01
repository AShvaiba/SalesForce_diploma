package UI.wrappers;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;

public class AccountContactInfoValidation extends BaseWrapper{

    public AccountContactInfoValidation(String label) {
        super(label);
    }

    public void validateDisplayedText(String text) {
        $x(String.format("//p[text()='%s']/following-sibling::p/descendant::lightning-formatted-text", label))
                .shouldHave(exactText(text));
    }

    public void validateLinkText(String text) {
        if(label.equals("Account Name")) {
            $x(String.format("//p[text()='%s']/following-sibling::p/descendant::a/descendant::span", label))
                    .shouldHave(exactText(text));
            return;
        }

        $x(String.format("//p[text()='%s']/following-sibling::p/descendant::a", label))
                .shouldHave(exactText(text));
    }
}
