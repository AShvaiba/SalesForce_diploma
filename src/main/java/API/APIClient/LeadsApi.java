package API.APIClient;

import API.base.BaseApi;
import API.dto.ErrorResponse;
import API.dto.LeadsList;
import API.dto.PostResponse;
import dto.Lead;
import io.restassured.response.Response;

import java.util.ArrayList;

import static utils.PropertyReader.getLeadUri;

public class LeadsApi extends BaseApi {

    public PostResponse createNewLead(Lead lead, int expectedStatusCode) {
        Response response = post(gson.toJson(lead), getLeadUri(), expectedStatusCode);
        return gson.fromJson(response.body().asString(), PostResponse.class);
    }

    public ErrorResponse[] createLeadWithEmptyFields() {
        Response response = post("{}", getLeadUri(), 400);
        return gson.fromJson(response.body().asString(), ErrorResponse[].class);
    }

    public Lead getLeadById(String leadId, int expectedStatusCode) {
        Response response = get(getLeadUri().concat(leadId), expectedStatusCode);
        return gson.fromJson(response.body().asString(), Lead.class);
    }

    public Response updateLeadById(Lead fieldsToUpdate, String leadId, int expectedStatusCode) {
        return patch(gson.toJson(fieldsToUpdate), getLeadUri().concat(leadId), expectedStatusCode);
    }

    public Response deleteLeadById(String leadId, int expectedStatusCode) {
        return delete(getLeadUri().concat(leadId), expectedStatusCode);
    }

    public LeadsList getLeadsList(int expectedStatusCode) {
        Response response = get(getLeadUri(), expectedStatusCode);
        return gson.fromJson(response.body().asString(), LeadsList.class);
    }

    public void deleteAllLeads() {
        ArrayList<Lead> leadsList = getLeadsList(200).getLeadsList();
        for (Lead lead : leadsList) {
            deleteLeadById(lead.getId(), 204);
        }
    }
}
