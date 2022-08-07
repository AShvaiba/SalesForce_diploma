package API.dto;

import lombok.Data;
import org.testng.Assert;

@Data
public class ErrorResponse {
    private String message;
    private String errorCode;

    public void checkMessage(String expectedMessage) {
        Assert.assertEquals(message, expectedMessage);
    }

    public void checkErrorCode(String expectedErrorCode) {
        Assert.assertEquals(errorCode, expectedErrorCode);
    }
}
