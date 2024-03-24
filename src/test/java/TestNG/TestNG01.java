package TestNG;

import org.testng.annotations.*;

public class TestNG01 {

    @BeforeSuite
    public void beforesuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void beforetest(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void beforeclass(){
        System.out.println("Beforeclass");
    }

   @BeforeMethod
   public void BF(){
       //why? - we can read Excel files, Json Files, CSV, DB
       //Config Files, other scenarios like datasetup
       System.out.println("Before Method");
   }


    @Test
    public void demo1 (){
        System.out.println("TEStng1");
    }



    @AfterMethod
    public void Af(){
       //Why? - we can close the files
        System.out.println("After Method");
    }

    @AfterClass
    public void afterclass(){
        System.out.println("Afterclass");
    }

    @AfterTest
    public void aftertest(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("AfterSuite");
    }

}
