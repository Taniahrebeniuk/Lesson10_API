package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityIdTest extends BaseApiTest {
    String apiKey = "949dc28aff7ca1f60f40a3c75ca7eebc";
    String cityId = "2554";

    @Test
    public void testCityIdInArray() {
        ApiWithPojo response = given()
                .header("Content-Type", "application/json")
                .param("apiKey", apiKey)
                .param("modelName", "AddressGeneral")
                .param("calledMethod", "getCities")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(ApiWithPojo.class);

        List<ApiWithPojo.Data> dataList = response.getData();
        boolean found = false;
        for (ApiWithPojo.Data data : dataList) {
            if (data.getCityID().equals(cityId)) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }
}