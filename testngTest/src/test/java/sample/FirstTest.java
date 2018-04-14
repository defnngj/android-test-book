package sample;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class FirstTest {

    //在当前测试类开始时运行。
    @BeforeClass
    public static void beforeClass(){
        System.out.println("-------------------beforeClass");
    }

    //在当前测试类结束时运行。
    @AfterClass
    public static void afterClass(){
        System.out.println("-------------------afterClass");
    }

    //每个测试方法运行之前运行
    @BeforeMethod
    public void before(){
        System.out.println("=====beforeMethod");
    }

    //每个测试方法运行之后运行
    @AfterMethod
    public void after(){
        System.out.println("=====afterMethod");
    }

    @Test
    public void testCase1(){
        assertEquals(2+1,3);
    }

    @Test
    public void testCase2(){
        assertEquals(5-2,3);
    }

}
