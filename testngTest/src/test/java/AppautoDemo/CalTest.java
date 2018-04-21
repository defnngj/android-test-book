package AppautoDemo;

import Appauto.AppiumEmulator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;


public class CalTest {

    public AppiumEmulator driver;
    public CalPage calPage;

    @BeforeClass
    public void startApp()  throws MalformedURLException{
        driver = new AppiumEmulator();
        this.calPage = new CalPage(driver);
    }

    // 关闭APP
    @AfterClass
    public void closeApp(){
        driver.quit();
    }

    // 清空结果
    @AfterMethod
    public void clearResult(){
        this.calPage.clr();
    }

    @Test
    public void testAdd(){
        this.calPage.number_1();
        this.calPage.add();
        this.calPage.number_1();
        this.calPage.eq();
        String result = this.calPage.result();
        assertEquals(result, "2");
    }

    @Test
    public void testSub(){
        this.calPage.number_5();
        this.calPage.sub();
        this.calPage.number_3();
        this.calPage.eq();
        String result = this.calPage.result();
        assertEquals(result, "2");
    }

    @Test
    public void testMul(){
        this.calPage.number_5();
        this.calPage.mul();
        this.calPage.number_3();
        this.calPage.eq();
        String result = this.calPage.result();
        assertEquals(result, "15");
    }

    @Test
    public void testDiv(){
        this.calPage.number_6();
        this.calPage.div();
        this.calPage.number_3();
        this.calPage.eq();
        String result = this.calPage.result();
        assertEquals(result, "2");
    }
}