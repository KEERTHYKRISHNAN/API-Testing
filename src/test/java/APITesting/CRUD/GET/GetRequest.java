package APITesting.CRUD.GET;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetRequest {


        @Test
    public void getallbookings_Negative(){

        //URL:https://restful-booker.herokuapp.com/booking/715
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);
    }

    @Test
    public void getallbookings_Positive(){

        //URL:https://restful-booker.herokuapp.com/booking/715
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
    }
}
