package TestNG.RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestNG10 {

    RequestSpecification r;
    ValidatableResponse validatableResponse;
    String payload = "{\n" +
            "    \"firstname\" : \"Vijay\",\n" +
            "    \"lastname\" : \"SAmpath\"\n" +
            "}";
    String token ="abc123";

        @Test
        public void partialupdate () {

            r = RestAssured.given();
            r.basePath("https://restful-booker.herokuapp.com");
            r.baseUri("booking/719");
            r.body(payload);

            r.cookie(token);
            r.auth().basic("admin","password123");

            Response response = r.when().patch();

            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);


        }
    }

