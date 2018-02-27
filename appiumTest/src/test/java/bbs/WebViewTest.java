package bbs;

import bbsPage.SearchPostPage;
import bbsPage.SwitchPlatePage;
import bbsPage.WebViewPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class WebViewTest {

    private AndroidDriver driver;
    private SwitchPlatePage page1;
    private WebViewPage page2;

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

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.page1 = new SwitchPlatePage(this.driver);
        this.page2 = new WebViewPage(this.driver);

    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }


    @Test
    public void testTryPlay() throws InterruptedException {
        this.page1.TryPlayButton();
        // WEBVIEW_com.meizu.mzbbs
        this.page2.switchToContext("WEBVIEW_com.meizu.mzbbs");
        this.page2.viewProduct();
        String title = this.page2.viewProductTitle();
        //System.out.println(title);
        assertEquals(title, "每日试玩_魅玩帮");
    }
}
