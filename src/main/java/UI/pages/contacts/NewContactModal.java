package UI.pages.contacts;

import UI.dto.Contact;
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

    private SelenideElement accountNameToReview = $x("//a[text()='Account Name']");

    @Step("Input required fields for new contact")
    public NewContactModal inputRequiredFieldsOnly(Contact contact) {
        new Input("Last Name").writeForContact(contact.getLastName());
        new InputWithSuggestion("Account Name").inputSuggestionForContact(contact.getAccountName());
        return this;
    }

    @Step("Input main fields for new contact")
    public NewContactModal inputMainFields(Contact contact) {
        new Dropdown("Salutation").selectForContact(contact.getSalutation());
        new Input("First Name").writeForContact(contact.getFirstName());
        new Input("Last Name").writeForContact(contact.getLastName());
        new InputWithSuggestion("Account Name").inputSuggestionForContact(contact.getAccountName());
        new Input("Title").writeForContact(contact.getTitle());
        new Input("Phone").writeForContact(contact.getPhone());
        new Input("Mobile").writeForContact(contact.getMobile());
        new Input("Email").writeForContact(contact.getEmail());
        new InputWithSuggestion("Reports To").inputSuggestionForContact(contact.getReportsTo());
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

    @Step("Check account name field to review presence")
    public NewContactModal checkAccountNameFieldToReviewIsDisplayed() {
        accountNameToReview.shouldBe(visible);
        return this;
    }
}
