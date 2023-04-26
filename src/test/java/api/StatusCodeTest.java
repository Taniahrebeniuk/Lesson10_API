package api;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusCodeTest extends BaseApiTest {

    @Test
    public void testGetCitiesStatus () {

        String apiKey = "949dc28aff7ca1f60f40a3c75ca7eebc";

        Response response = RestAssured
                .given()
                .queryParams("apiKey", apiKey, "modelName", "Address", "calledMethod", "getCities")
                .get("")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

    }
}