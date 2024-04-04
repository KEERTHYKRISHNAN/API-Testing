package TestNG.TestNGExamples;

import org.testng.annotations.Test;

public class TestNG09 {

    @Test(groups = {"SANITY"})
    public void SANITY(){
        System.out.println("SANITY");
    }

    @Test (groups = {"e2e", "Regrun"})
    public void REGRUN(){
        System.out.println("REGRUN");
    }
@Test(groups = {"SANITY", "e2e", "Regrun"})
    public void e2e(){
        System.out.println("e2e");
    }


}
