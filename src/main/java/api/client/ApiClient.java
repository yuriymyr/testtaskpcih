package api.client;

import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import util.LoggerUtil;

import java.util.Map;

import static io.restassured.RestAssured.given;

@UtilityClass
public class ApiClient {

    public Response get(String endpoint, Map<String, Object> pathParams) {
        LoggerUtil.info("Sending GET request to: " + endpoint + " with params: " + pathParams);

        var response = given()
                .pathParams(pathParams)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();

        LoggerUtil.info("Response received: " + response.getBody().asString());

        return response;
    }

    public Response post(String endpoint, Object payload) {
        LoggerUtil.info("Sending POST request to: " + endpoint + " with payload: " + payload);

        var response = given()
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();

        LoggerUtil.info("Response received: " + response.getBody().asString());

        return response;
    }
}
