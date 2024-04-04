package TestNG.RestfulBooker;

import groovyjarjarantlr4.runtime.Token;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestNG02 {
    //PUT request
    //before running a test we need a token
    //headers, payload, token , ID

    RequestSpecification r;
    ValidatableResponse validatableResponse;
    String token;

    @BeforeTest
    public void gettoken(){
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


       token = response.then().log().all().extract().path("token");


        //TestNG Assertion
//          Assert.assertNotNull(token);
//          System.out.println(token);

        //AssertJ
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();
        System.out.println(token);
    }

    @Test
    public void nonbddstyle_putrequest(){
        String jsonString = "{\n" +
                "    \"firstname\" : \"RajKamal\",\n" +
                "    \"lastname\" : \"Krishnan\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Need dinner\"\n" +
                "}";


        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/829");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(jsonString).log().all();

        Response response = r.when().put();
        System.out.println(response.asString());

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
       // validatableResponse.body("firstname" , Matchers.equalTo("KKeerthy"));

    }
}
