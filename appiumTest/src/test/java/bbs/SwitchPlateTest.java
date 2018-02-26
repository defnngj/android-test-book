package bbs;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class SwitchPlateTest {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "PRO5");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appPackage", "com.meizu.mzbbs");
        capabilities.setCapability("appActivity",
                "com.meizu.mzbbs.ui.LoadingActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    //论坛板块
    @Test
    public void SwitchToABBS() {
        String title = driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c[1]/android.widget.TextView")).getText();
        assertEquals(title, "精选");
    }

    // 切换摄影板块
    @Test
    public void SwitchToPhotography() {
        driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.widget" +
                        ".FrameLayout[2]")).click();
        String title = driver.findElement(By.
                xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c[1]/android.widget.TextView")).getText();
        assertEquals(title, "推荐");

    }

    //切换试玩板块
    @Test
    public void SwitchToTryPlay() {
        driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.widget" +
                        ".FrameLayout[3]")).click();
        String title = driver.findElement(By.
                xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c/android.widget.TextView")).getText();
        assertEquals(title, "试玩");
    }

    //切换用户板块
    @Test
    public void SwitchToUser() {
        driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.widget" +
                        ".FrameLayout[4]")).click();
        String user = driver.findElement(By.id("com.meizu.mzbbs:id/ft")).getText();
        assertEquals(user, "用户28424440");
    }


}
