package API.APIClient;

import API.base.BaseApi;
import API.dto.ContactsList;
import API.dto.PostResponse;
import dto.Contact;
import io.restassured.response.Response;

import java.util.ArrayList;

import static utils.PropertyReader.getContactUri;

public class ContactsApi extends BaseApi {

    public PostResponse createNewContact(Contact contact, int expectedStatusCode) {
        Response response = post(gson.toJson(contact), getContactUri(), expectedStatusCode);
        return gson.fromJson(response.body().asString(), PostResponse.class);
    }

    public ContactsList getContactsList(int expectedStatusCode) {
        Response response = get(getContactUri(), expectedStatusCode);
        return gson.fromJson(response.body().asString(), ContactsList.class);
    }

    public Response deleteContactById(String contactId, int expectedStatusCode) {
        return delete(getContactUri().concat(contactId), expectedStatusCode);
    }

    public void deleteAllContacts() {
        ArrayList<Contact> contactsList = getContactsList(200).getContactsList();
        for (Contact contact : contactsList) {
            deleteContactById(contact.getId(), 204);
        }
    }
}
