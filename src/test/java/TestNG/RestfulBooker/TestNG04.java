package TestNG.RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TestNG04 {

    //Get the booking ID
    @Test
    public void GetBookingID() {

        RequestSpecification r;
        ValidatableResponse validatableResponse;
        Integer bookingid;

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking");
        r.contentType(ContentType.JSON);

        Response response = r.when().get();

        validatableResponse = response.then();

        //REst Assured Matchers
        validatableResponse.statusCode(200).extract();
        validatableResponse.body("bookingid", Matchers.notNullValue());
      response.then().log().all().extract().path("bookingid");



    }
}