package api.confg;

import io.restassured.RestAssured;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiConfig {

    public void setupBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public void setupHeaders() {
        RestAssured.requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json");
    }
}
