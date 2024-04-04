package TestNG.RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TestNg03 {
    //Create Token Request Separate
    RequestSpecification r;
    ValidatableResponse validatableResponse;
    String token;

  @Test
    public void gettoken() {
        r = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        Response response = r.post();

        validatableResponse = response.then().log().all();

        //REst Assured Matchers
        validatableResponse.statusCode(200);
        validatableResponse.body("token", Matchers.notNullValue());
      //String responsestring = response.asString();
      //System.out.println(responsestring);



        token = response.then().log().all().extract().path("token");
        System.out.println(token);
    }
}