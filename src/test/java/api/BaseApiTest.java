package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.devtools.v102.network.model.Request;

import static io.opentelemetry.api.internal.ValidationUtil.log;

public class BaseApiTest {

    protected RequestSpecification requestSpecification;
    protected ResponseSpecification responseSpecification;

    @BeforeEach
    public void setSpecs() {
        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri("https://api.novaposhta.ua/v2.0/json/")
                .build();
        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}