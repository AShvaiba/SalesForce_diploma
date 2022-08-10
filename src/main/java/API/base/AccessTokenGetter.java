package API.base;

import com.google.gson.Gson;
import io.restassured.response.Response;
import lombok.Builder;
import lombok.Data;

import static io.restassured.RestAssured.given;
import static utils.PropertyReader.*;

@Data
@Builder
public class AccessTokenGetter {
    private String access_token;
    private String instance_url;
    private String id;
    private String token_type;
    private String issued_at;
    private String signature;

    public static String getAccessToken() {
        Gson gson = new Gson();
        Response response =
        given()
                .contentType("multipart/form-data")
                .multiPart("username", getUserName())
                .multiPart("password", getPassword() + getSecurityToken())
                .multiPart("grant_type", getGrantType())
                .multiPart("client_id", getClientId())
                .multiPart("client_secret", getClientSecret()).
                log().all().
                post(getAccessTokenEndpoint()).
        then()
                .statusCode(200).
                extract().response();

        AccessTokenGetter accessTokenResponse = gson.fromJson(response.asString(), AccessTokenGetter.class);

        return accessTokenResponse.getAccess_token();
    }
}
