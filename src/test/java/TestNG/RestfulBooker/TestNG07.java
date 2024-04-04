package TestNG.RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG07 {
    //PartialUpdate with Patch

    RequestSpecification r;
    ValidatableResponse validatableResponse;
    String payload = "{\n" +
            "    \"firstname\" : \"Vijay\",\n" +
            "    \"lastname\" : \"SAmpath\"\n" +
            "}";
    String token;


   @BeforeTest

    public void Token(){

        r = RestAssured.given();
       String jsonString  = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


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
        @Test
        public void partialupdate () {

            r = RestAssured.given();
            r.basePath("https://restful-booker.herokuapp.com");
            r.baseUri("booking/719");
            r.body(payload);
            r.contentType(ContentType.JSON);
            r.cookie(token);
            r.auth().basic("admin","password123");

          Response responseasstring = r.when().patch();

            validatableResponse = responseasstring.then().log().all();
            validatableResponse.statusCode(200);


        }
    }
