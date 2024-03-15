package APITesting.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

public class NONBDDStylePUT {

    //URL, PAyload, Method, HEaders, auth - bec0ab2c9c9150e, ID - 2023,
    @Test
    public void NONBDDStylePUT(){
        String payload = "{\n" +
                "    \"firstname\" : \"KKeerthy\",\n" +
                "    \"lastname\" : \"Krishnan\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        String token = "6847c01318dc593";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/344");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();

        Response response = r.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname" , Matchers.equalTo("KKeerthy"));

    }
}
