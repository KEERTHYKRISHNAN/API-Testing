package APITesting.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {
    //Given when then() - builder pattern

    public static void main(String[] args) {

        //URL:https://restful-booker.herokuapp.com/booking/715
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/715").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);

    }
}
