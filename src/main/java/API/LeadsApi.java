package API;

import API.dto.ErrorResponse;
import API.dto.Lead;
import API.dto.LeadsList;
import API.dto.PostLeadResponse;
import io.restassured.response.Response;

import static utils.PropertyReader.*;

public class LeadsApi extends BaseApi {

    public PostLeadResponse createNewLead(Lead lead, int expectedStatusCode) {
        Response response = post(gson.toJson(lead), getLeadUri(), expectedStatusCode);
        return gson.fromJson(response.body().asString(), PostLeadResponse.class);
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
}
