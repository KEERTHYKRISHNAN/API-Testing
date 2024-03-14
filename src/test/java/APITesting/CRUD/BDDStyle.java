package APITesting.CRUD;

import io.restassured.RestAssured;

public class BDDStyle {
    public static void main(String[] args) {
        //URL: https://api.zippopotam.us/IN/560037
        //Base URL: https://api.zippopotam.us
        //Base Path:/IN/560037
        //Get Method
        //No Payload
        //No Authentication
        //We can see log by adding.log().all()

        //Validate STATUS CODE, RESPONSE BODY

        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/560037")
                     .when().log().all().get()
                     .then().log().all().statusCode(200);
    }
}
