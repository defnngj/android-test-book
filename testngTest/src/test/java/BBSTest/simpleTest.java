package BBSTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

public class simpleTest {

    private static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException{
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

        //论坛贴子搜索
        driver.findElement(By.id("com.meizu.mzbbs:id/j0")).click();
        driver.findElement(By.id("com.meizu.mzbbs:id/p9")).sendKeys("Flyme");
        driver.findElement(By.id("com.meizu.mzbbs:id/tp")).click();

        driver.quit();
    }
}
