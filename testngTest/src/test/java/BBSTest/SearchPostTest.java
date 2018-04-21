package BBSTest;

import bbsPage.SearchPostPage;
import bbsPage.SwitchPlatePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchPostTest {

    private AndroidDriver driver;
    private SearchPostPage page;

    @BeforeClass
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
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.page = new SearchPostPage(this.driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterMethod
    public void returnIndex() throws Exception {
        this.page.returnIndexPage(); // 回到首页
    }

    // 定义对象数组
    @DataProvider(name = "search")
    public Object[][] Keys() {
        return new Object[][] {
                {"Flyme"},{"PRO7"},{"note6"},{"15"},
        };
    }

    //搜索贴子
    @Test(dataProvider = "search")
    public void SearchPostTest(String searchKey) {
        this.page.searchLogo();
        this.page.searchInput(searchKey);
        this.page.searchButton();
        String result = this.page.searchResults();
        System.out.println(result);
        //assertEquals(result, searchKey);
    }

}
