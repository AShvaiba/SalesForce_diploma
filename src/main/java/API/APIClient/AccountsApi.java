package API.APIClient;

import API.base.BaseApi;
import API.dto.AccountsList;
import API.dto.PostResponse;
import dto.Account;
import io.restassured.response.Response;

import java.util.ArrayList;

import static utils.PropertyReader.getAccountUri;

public class AccountsApi extends BaseApi {

    public PostResponse createNewAccount(Account account, int expectedStatusCode) {
        Response response = post(gson.toJson(account), getAccountUri(), expectedStatusCode);
        return gson.fromJson(response.body().asString(), PostResponse.class);
    }

    public AccountsList getAccountsList(int expectedStatusCode) {
        Response response = get(getAccountUri(), expectedStatusCode);
        return gson.fromJson(response.body().asString(), AccountsList.class);
    }

    public Response deleteAccountById(String contactId, int expectedStatusCode) {
        return delete(getAccountUri().concat(contactId), expectedStatusCode);
    }

    public void deleteAllAccounts() {
        ArrayList<Account> accountList = getAccountsList(200).getAccountList();
        for (Account account : accountList) {
            deleteAccountById(account.getId(), 204);
        }
    }
}
