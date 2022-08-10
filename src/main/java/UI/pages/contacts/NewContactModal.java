package UI.pages.contacts;

import dto.Contact;
import UI.wrappers.Dropdown;
import UI.wrappers.Input;
import UI.wrappers.InputWithSuggestion;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class NewContactModal {

    private SelenideElement saveContact = $x("//button[text()='Save']");

    private SelenideElement contactInfo = $x("//span[text()='Contact Information']");

    private SelenideElement errorIcon = $x("//button[@id='window']");

    //error message contents
    private SelenideElement errorText = $x("//h2[text()='We hit a snag.']");

    private SelenideElement fieldsReview = $x("//strong[text()='Review the following fields']");

    private SelenideElement nameFieldToReview = $x("//a[text()='Name']");

    @Step("Input required fields for new contact")
    public NewContactModal inputRequiredFieldsOnly(Contact contact) {
        contactInfo.shouldBe(visible);
        new Input("Last Name").write(contact.getLastName());
        return this;
    }

    @Step("Input main fields for new contact")
    public NewContactModal inputMainFields(Contact contact) {
        contactInfo.shouldBe(visible);
        new Dropdown("Salutation").select(contact.getSalutation());
        new Input("First Name").write(contact.getFirstName());
        new Input("Last Name").write(contact.getLastName());
        new InputWithSuggestion("Account Name").inputSuggestion(contact.getAccountName());
        new Input("Title").write(contact.getTitle());
        new Input("Phone").write(contact.getPhone());
        new Input("Mobile").write(contact.getMobile());
        new Input("Email").write(contact.getEmail());
        new InputWithSuggestion("Reports To").inputSuggestion(contact.getReportsTo());
        return this;
    }

    @Step("Click save contact")
    public SingleContactPage saveContact() {
        contactInfo.shouldBe(visible);
        log.info("Save contact");
        saveContact.click();
        return new SingleContactPage();
    }

    @Step("Check error icon presence")
    public NewContactModal checkErrorIconIsDisplayed() {
        errorIcon.shouldBe(visible);
        return this;
    }

    @Step("Check error text presence")
    public NewContactModal checkErrorTextIsDisplayed() {
        errorText.shouldBe(visible);
        return this;
    }

    @Step("Check fields to review text presence")
    public NewContactModal checkFieldsToReviewTextDisplayed() {
        fieldsReview.shouldBe(visible);
        return this;
    }

    @Step("Check name field to review presence")
    public NewContactModal checkNameFieldToReviewIsDisplayed() {
        nameFieldToReview.shouldBe(visible);
        return this;
    }
}
