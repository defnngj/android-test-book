package sample;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OtherTest {

    // 该条用例跳过执行
    @Test(enabled = false)
    public void testCase1(){
        assertEquals(2+2, 4);
    }

    // 设定用例超时时间
    @Test(timeOut = 3000)
    public void testCase2() throws InterruptedException {
        Thread.sleep(3001);
    }

    // 预设用例抛出的异常类型
    @Test(expectedExceptions = ArithmeticException.class)
    public void testCase3(){
        assertEquals(2/0,1);
    }

}
