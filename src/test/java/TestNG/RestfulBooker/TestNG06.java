package TestNG.RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG06 {
    RequestSpecification r;
    ValidatableResponse validatableResponse;
    String payload;
    Integer bookingid;

    @Test
    public void CreateBooking() {

        String payload = "{\n" +
                "    \"firstname\" : \"RajKamal\",\n" +
                "    \"lastname\" : \"Krishnannaidu\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Need dinner\"\n" +
                "}";
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking");
        r.contentType(ContentType.JSON);
        r.body(payload);

        Response response = r.when().post();

        validatableResponse = response.then().log().all();

//       String responsestring = response.asString();
//       System.out.println(responsestring);

        validatableResponse.statusCode(200);



    }
}