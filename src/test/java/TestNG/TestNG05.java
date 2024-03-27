package TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestNG05 {
    //Get Single booking ID

    @Test
    public void getsinglebookingID(){

        RequestSpecification r;
        ValidatableResponse validatableResponse;
        Integer bookingid;

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/719");
        r.contentType(ContentType.JSON);

        Response response = r.when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



    }
}
