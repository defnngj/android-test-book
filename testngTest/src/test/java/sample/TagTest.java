package sample;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Test(groups = {"功能测试"})
public class TagTest {

    @Test(groups={"高", "正常"})
    public void testCase1(){
        assertEquals(2+2, 4);
        System.out.println("高，正常");
    }

    @Test(groups = {"高", "正常"})
    public void testCase2(){
        assertEquals(5-3, 2);
        System.out.println("高，正常");
    }
    @Test(groups = {"中", "正常"})
    public void testCase3(){
        assertEquals(2/1, 2);
        System.out.println("中，正常");
    }

    @Test(groups = {"低", "异常"})
    public void testCase4(){
        assertEquals(2/0, 1);
        System.out.println("低，异常");
    }

}
