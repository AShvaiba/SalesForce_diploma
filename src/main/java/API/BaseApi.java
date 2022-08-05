package API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static API.AccessTokenGetter.getAccessToken;
import static io.restassured.RestAssured.*;
import static utils.PropertyReader.getApiUrl;

public class BaseApi {

    protected Gson gson;

    RequestSpecification requestSpecification;

    public BaseApi() {
        gson = new GsonBuilder().create();

        requestSpecification = given().
                header("Content-Type","application/json").
                header("Authorization", "Bearer " + getAccessToken()).
                log().all();
    }

    public Response get(String uri, int expectedStatusCode) {
        return requestSpecification.
                when().
                        get(getApiUrl().concat(uri)).
                then().
                        statusCode(expectedStatusCode).
                        log().all().
                        extract().response();
    }

    protected Response post(String body, String uri, int expectedStatusCode) {
        return
                requestSpecification.
                        body(body).
                        log().all().
                when().
                        post(getApiUrl().concat(uri)).
                then().
                        statusCode(expectedStatusCode).
                        extract().response();
    }

    protected Response patch(String body, String uri, int expectedStatusCode) {
        return
                requestSpecification.
                        body(body).
                        log().all().
                when().
                        patch(getApiUrl().concat(uri)).
                then().
                        statusCode(expectedStatusCode).
                        extract().response();
    }

    protected Response delete(String uri, int expectedStatusCode) {
        return
                requestSpecification.
                        delete(getApiUrl().concat(uri)).
                then().
                        statusCode(expectedStatusCode).
                        extract().response();
    }
}
