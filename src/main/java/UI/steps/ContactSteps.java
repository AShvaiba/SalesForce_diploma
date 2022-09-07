package UI.steps;

import dto.Contact;
import UI.pages.contacts.ContactsPage;
import UI.pages.contacts.NewContactModal;
import UI.pages.contacts.SingleContactPage;
import io.qameta.allure.Step;

public class ContactSteps {

    private ContactsPage contactsPage;
    private NewContactModal newContactModal;
    private SingleContactPage singleContactPage;

    public ContactSteps() {
        contactsPage = new ContactsPage();
        newContactModal = new NewContactModal();
        singleContactPage = new SingleContactPage();
    }

    @Step("Create contact with main info")
    public ContactSteps createContactWithMainInfo(Contact contact) {
        newContactModal = contactsPage.goToNewContactWindow();
        singleContactPage = newContactModal.inputMainFields(contact)
                .saveContact();
        return this;
    }

    @Step("Check main info of the created contact")
    public ContactSteps checkMainInfoOfCreatedContact(Contact expectedContact) {
        singleContactPage.checkContactFullName(expectedContact.getSalutation() + " " + expectedContact.getFirstName()
                + " " + expectedContact.getLastName())
                .checkContactTitle(expectedContact.getTitle())
                .checkAccountName(expectedContact.getAccountName())
                .checkContactPhone(expectedContact.getPhone())
                .checkContactEmail(expectedContact.getEmail());
        return this;
    }

    @Step("Check data of contact created with only required fields: Last Name and Account Name")
    public ContactSteps checkRequiredFields(Contact expectedContact) {
        singleContactPage.checkContactFullName(expectedContact.getLastName());
//                .checkAccountName(expectedContact.getAccountName());
        return this;
    }

    @Step("Create contact with required fields only")
    public ContactSteps createContactWithRequiredFieldsOnly(Contact contact) {
        newContactModal = contactsPage.goToNewContactWindow();
        singleContactPage = newContactModal.inputRequiredFieldsOnly(contact)
                .saveContact();
        return this;
    }

    @Step("Create contact with empty fields")
    public ContactSteps createContactWithEmptyFields() {
        newContactModal = contactsPage.goToNewContactWindow();
        newContactModal.saveContact();
        return this;
    }

    @Step("Check contents of error messages after creation of contact with empty fields")
    public ContactSteps checkErrorMessages() {
        newContactModal.checkErrorIconIsDisplayed()
                .checkErrorTextIsDisplayed()
                .checkFieldsToReviewTextDisplayed()
                .checkNameFieldToReviewIsDisplayed();
        return this;
    }
}
