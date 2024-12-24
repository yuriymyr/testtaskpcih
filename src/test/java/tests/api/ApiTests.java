package tests.api;

import api.client.ApiClient;
import api.dao.PostEndpoints;
import api.model.PostPayload;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ApiTests extends BaseApiTest {

    @Test(description = "Verify GET /posts/{id} returns 200 and contains a title field")
    public void testGetPostById() {
        var response = ApiClient.get(PostEndpoints.GET_POST.getEndpoint(), Map.of("id", 1));

        assertEquals(response.getStatusCode(), 200, "Expected status code 200");
        assertNotNull(response.jsonPath().getString("title"), "Title field should not be null");
    }

    @Test(description = "Validate POST /posts creates a new resource with status code 201")
    public void testCreatePost() {
        var payload = PostPayload.builder()
                .title("foo")
                .body("bar")
                .userId(1)
                .build();

        Response response = ApiClient.post(PostEndpoints.CREATE_POST.getEndpoint(), payload);

        assertEquals(response.getStatusCode(), 201, "Expected status code 201");
        assertNotNull(response.jsonPath().getString("id"), "Response should contain an ID");
    }
}
