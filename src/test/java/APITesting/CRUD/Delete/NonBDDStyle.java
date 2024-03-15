package APITesting.CRUD.Delete;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyle {

    //URL: https://restful-booker.herokuapp.com/booking/2574
    //No Payload just need ID: 2574
    //Delete REquest
    //Auth token

    String token = "acf1422fa13f968";

    @Test
    public void NONBDDStyle(){
        //Preparation
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/4222");
        r.contentType(ContentType.JSON);
        r.cookie("token" , token);

        //Making - Request
        Response response = r.when().delete();

        //Validation
        ValidatableResponse validatableResponse = response.then();
        String responsestring = response.asString();
        System.out.println(responsestring);

        validatableResponse.statusCode(201);



    }
}
