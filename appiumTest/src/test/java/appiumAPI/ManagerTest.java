package appiumAPI;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ManagerTest {
    public static AndroidDriver driver;


    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.android.dialer");
        capabilities.setCapability("appActivity", ".DialtactsActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //进入联系人界面
        driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout[3]")).click();
        driver.findElement(By.id("com.android.dialer:id/emptyListViewAction")).click();

        // 添加联系人
        driver.findElementByAndroidUIAutomator("text(\"Name\")").sendKeys("Tom");
        driver.findElementByAndroidUIAutomator("text(\"Phone\")").sendKeys("18611001100");

        // 保存联系人
        driver.findElement(By.id("com.android.contacts:id/menu_save")).click();

        driver.quit();
    }

}
