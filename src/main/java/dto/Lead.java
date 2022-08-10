package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.testng.Assert;

@Data
@Builder
@EqualsAndHashCode(exclude = {"id", "name", "status"})
public class Lead {
    @SerializedName("Id")
    private String id;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("Salutation")
    private String salutation;
    @SerializedName("Name")
    private String name;
    @SerializedName("Title")
    private String title;
    @SerializedName("Company")
    private String company;
    @SerializedName("Email")
    private String email;
    @SerializedName("Status")
    private String status;
    @SerializedName("Industry")
    private String industry;

    public void compareToExpectedLead(Lead expectedLead) {
        Assert.assertEquals(this, expectedLead);
    }
}
