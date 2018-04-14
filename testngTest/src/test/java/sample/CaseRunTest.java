package sample;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class CaseRunTest {

    @Test
    public void testCase1(){
        assertEquals(1+1, 2);
        System.out.println("testCase1");
    }

    @Test
    public void testCase2(){
        assertEquals(2+2, 4);
        System.out.println("testCase2");
    }

    @Test
    public void testCase3(){
        assertEquals(4+2, 6);
        System.out.println("testCase3");
    }

}
