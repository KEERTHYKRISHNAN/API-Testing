package APITesting.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDD {

    public void NonBDDPost(){
        //PreParation
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        //Making - Request

        Response response = r.when().post();

        //Validation

        ValidatableResponse validatableResponse = response.then();
        String responsestring = response.asString();
        System.out.println(responsestring);

        validatableResponse.statusCode(200);



    }
}
