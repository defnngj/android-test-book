package sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataProviderTest {

    @Test(enabled = false)
    @Parameters({"add1","add2","result"})
    public void testAdd(int add1, int add2, int result){
        assertEquals(add1+ add2, result);
    }

    // 定义对象数组
    @DataProvider(name = "add")
    public Object[][] TestsData() {
        return new Object[][] {
                { 3, 2, 5 },
                { 3, 1, 4 },
                { 3, 1, 4 },
                { 3, 1, 4 },
                { 3, 1, 4 },
        };
    }

    @Test(dataProvider="add")
    public void testAdd2(int add1, int add2, int result){
        assertEquals(add1+add2, result);
    }

}
