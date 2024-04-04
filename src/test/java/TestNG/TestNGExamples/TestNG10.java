package TestNG.TestNGExamples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG10 {
        //DataProvider - Test Data

    @DataProvider
    public Object[][]getdata() {
        return new Object[][]{
                new Object[]{"admin", "Password"},
                new Object[]{"admin1", "Password1"},
                new Object[]{"admin2", "Password3"}


        };
    }
    @Test(dataProvider =  "getdata")
    public void loginTEst(String Username, String Password){
        System.out.println(Username);
        System.out.println(Password);

    }
}
