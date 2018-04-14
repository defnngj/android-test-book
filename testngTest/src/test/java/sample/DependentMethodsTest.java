package sample;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DependentMethodsTest {

    @Test
    public void testAdd1(){
        assertEquals(5, 5);
    }

    @Test(dependsOnMethods = {"testAdd1"})
    public void testAdd2(){
        assertEquals(3+2, 5);
    }

}
