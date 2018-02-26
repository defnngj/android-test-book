package bbs;

import bbsPage.SwitchPlatePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SwitchPlatePageTest {

    private AndroidDriver driver;
    private SwitchPlatePage page;

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "PRO5");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("appPackage", "com.meizu.mzbbs");
        capabilities.setCapability("appActivity",
                "com.meizu.mzbbs.ui.LoadingActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.page = new SwitchPlatePage(this.driver);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    //论坛板块
    @Test
    public void SwitchToABBS() {
        String title = this.page.bbsTitle();
        assertEquals(title, "精选");
    }

    // 切换摄影板块
    @Test
    public void SwitchToPhotography() {
        this.page.photographyButton();
        String title = this.page.photographyTitle();
        assertEquals(title, "推荐");

    }

    //切换试玩板块
    @Test
    public void SwitchToTryPlay() {
        this.page.TryPlayButton();
        String title = this.page.TryPlayTitle();
        assertEquals(title, "试玩");
    }

    //切换用户板块
    @Test
    public void SwitchToUser() {
        this.page.UserButton();
        String username = this.page.UserName();
        assertEquals(username, "用户28424440");
    }
}
