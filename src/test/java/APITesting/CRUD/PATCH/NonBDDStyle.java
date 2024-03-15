package APITesting.CRUD.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyle {
    //URL:
    //Token
    //Auth
    //Payload

    String payload = "{\n" +
            "    \"firstname\" : \"VVVijay\",\n" +
            "    \"lastname\" : \"Sampath\"\n" +
            "}";

    String token = "a6bf65b9f7e1605";

    @Test
    public void NonBDDSTYLEPatch(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/4022");
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payload);

        Response response = r.when().patch();


        ValidatableResponse validatableResponse = response.then();
        String responsestring = response.asString();
        System.out.println(responsestring);

        validatableResponse.statusCode(200);



    }
}
