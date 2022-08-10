package API;

import API.APIClient.LeadsApi;
import data.ITestData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseApiTest implements ITestData {

    LeadsApi leadsApi;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        leadsApi = new LeadsApi();
    }

    @AfterTest(alwaysRun = true)
    public void deletePostConditions() {
        leadsApi.deleteAllLeads();
    }
}
