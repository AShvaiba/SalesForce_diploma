package API;

import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    LeadsApi leadsApi;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        leadsApi = new LeadsApi();
    }
}
