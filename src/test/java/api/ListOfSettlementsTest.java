package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ListOfSettlementsTest extends BaseApiTest {
    String apiKey = "949dc28aff7ca1f60f40a3c75ca7eebc";
    Map<String, Object> reqBody;

    @BeforeEach
    public void setRequestBody() {
        reqBody = new HashMap<>();
        reqBody.put("apiKey", apiKey);
        reqBody.put("modelName", "Address");
        reqBody.put("calledMethod", "getCities");
        reqBody.put("Limit", "5");
    }

    @Test
    public void testCities() {
        Response response = RestAssured
                .given()
                .spec(requestSpecification)
                .body(reqBody)
                .post("")
                .then()
                .spec(responseSpecification)
                .extract().response();

        List<Map<String, Object>> cities = response.jsonPath().getList("data");
        List<String> actualCities = cities.stream().map(city -> (String) city.get("Description")).collect(Collectors.toList());
        List<String> expectedCities = Arrays.asList("Абазівка (Полтавський р-н, Полтавська обл)", "Абранка", "Абрикосівка", "Авангард", "Августинівка");
        Assertions.assertTrue(actualCities.containsAll(expectedCities));
    }
}