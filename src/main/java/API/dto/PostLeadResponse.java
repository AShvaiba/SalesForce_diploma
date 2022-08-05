package API.dto;

import lombok.Builder;
import lombok.Data;
import org.testng.Assert;

import java.util.ArrayList;

@Data
@Builder
public class PostLeadResponse {
    private String id;
    private boolean success;
    private ArrayList<Object> errors;

    public void checkPostSucceed() {
        Assert.assertTrue(success);
    }
}
