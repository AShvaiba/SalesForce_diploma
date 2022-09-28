package API;

import API.APIClient.LeadsApi;
import data.ITestData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest implements ITestData {

    LeadsApi leadsApi;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("username", "shvybchk@hell.yes");
        leadsApi = new LeadsApi();
    }

    @AfterTest(alwaysRun = true)
    public void deletePostConditions() {
        new LeadsApi().deleteAllLeads();
    }
}
