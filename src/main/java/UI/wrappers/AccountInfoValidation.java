package UI.wrappers;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class AccountInfoValidation extends BaseWrapper{

    public AccountInfoValidation(String label) {
        super(label);
    }

    public void validateDisplayedText(String text) {
        $x(String.format("//p[text()='%s']/following-sibling::p/descendant::lightning-formatted-text", label))
                .shouldHave(Condition.exactText(text));
    }

    public void validateLinkText(String text) {
        $x(String.format("//p[text()='%s']/following-sibling::p/descendant::a", label))
                .shouldHave(Condition.exactText(text));
    }
}
