package example;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class CalculatorTest {

    public static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElementByAndroidUIAutomator("text(\"1\")").click();
        driver.findElementByAndroidUIAutomator("text(\"5\")").click();
        driver.findElementByAndroidUIAutomator("text(\"9\")").click();
        driver.findElementByAndroidUIAutomator("text(\"DEL\")").click();
        driver.findElementByAndroidUIAutomator("text(\"+\")").click();
        driver.findElementByAndroidUIAutomator("text(\"6\")").click();
        driver.findElementByAndroidUIAutomator("text(\"=\")").click();

        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/result"))
                .getText();
        System.out.println(result);

        driver.quit();
    }

}
