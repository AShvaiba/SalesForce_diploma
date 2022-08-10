package API;

import API.dto.ErrorResponse;
import API.dto.LeadsList;
import API.dto.PostResponse;
import dto.Lead;
import org.testng.annotations.Test;

public class LeadsTest extends BaseApiTest {

    @Test(description = "Test creation new lead with main info specified")
    public void createNewLeadWithMainInfo() {
        Lead testLead = LEAD_WITH_MAIN_INFO;

        PostResponse response = leadsApi.createNewLead(testLead, CODE_201_CREATED);

        response.checkPostSucceed();
        String createdLeadId = response.getId();
        Lead createdLead = leadsApi.getLeadById(createdLeadId, CODE_200_OK);
        createdLead.compareToExpectedLead(testLead);
    }

    @Test(description = "Test creation new lead with only required info specified")
    public void createNewLeadWithOnlyRequiredInfo() {
        Lead testLead = LEAD_WITH_REQUIRED_FIELDS_ONLY;

        PostResponse response = leadsApi.createNewLead(testLead, CODE_201_CREATED);

        response.checkPostSucceed();
        String createdLeadId = response.getId();
        Lead createdLead = leadsApi.getLeadById(createdLeadId, CODE_200_OK);
        createdLead.compareToExpectedLead(testLead);
    }

    @Test(description = "Test update main fields of random lead")
    public void updateMainFieldsOfRandomLead() {
        Lead testLeadForUpdate = LEAD_WITH_MAIN_INFO;

        LeadsList leadsList = leadsApi.getLeadsList(CODE_200_OK);
        Lead leadToUpdate = leadsList.getRandomLeadFromList();
        String leadIdToUpdate = leadToUpdate.getId();
        leadsApi.updateLeadById(testLeadForUpdate, leadIdToUpdate, CODE_204_NO_CONTENT);

        Lead updatedLead = leadsApi.getLeadById(leadIdToUpdate, CODE_200_OK);
        updatedLead.compareToExpectedLead(testLeadForUpdate);
    }

    @Test(description = "Test creation new lead with empty fields")
    public void createNewLeadWithEmptyFields() {
        ErrorResponse[] errorResponse = leadsApi.createLeadWithEmptyFields();

        errorResponse[0].checkErrorCode(ERROR_CODE_MISSED_FIELDS_FOR_LEAD_CREATION);
        errorResponse[0].checkMessage(ERROR_MESSAGE_MISSED_ALL_FIELDS_FOR_LEAD_CREATION);
    }

    @Test(description = "Test delete random lead")
    public void deleteRandomLead() {
        LeadsList leadsList = leadsApi.getLeadsList(CODE_200_OK);

        Lead leadToDelete = leadsList.getRandomLeadFromList();
        String leadIdToDelete = leadToDelete.getId();

        leadsApi.deleteLeadById(leadIdToDelete, CODE_204_NO_CONTENT);

        leadsApi.deleteLeadById(leadIdToDelete, CODE_404_NOT_FOUND);
    }
}
