package dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String accountName;
    private String parentAccount;
    private String phone;
    private String fax;
    private String website;
    private String type;
    private String industry;
    private String employees;
    private String annualRevenue;
    private String description;

    private String billingStreet;
    private String billingCity;
    private String billingZipCode;
    private String billingState;
    private String billingCountry;

    private String shippingStreet;
    private String shippingCity;
    private String shippingZipCode;
    private String shippingState;
    private String shippingCountry;
}
