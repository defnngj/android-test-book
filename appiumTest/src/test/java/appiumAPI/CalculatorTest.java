package appiumAPI;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class CalculatorTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(By.id("com.android.calculator2:id/del")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        //android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button
        //android.widget.Button[@text,7]
        //android.view.ViewGroup[1]/android.widget.Button[7]

        (new TouchAction(driver)).tap(69, 579).perform();
        (new TouchAction(driver)).tap(401, 724).perform();
        (new TouchAction(driver)).tap(175, 579).perform();
        (new TouchAction(driver)).tap(277, 708).perform();


        driver.findElementByAccessibilityId("plus").click();

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"clr\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"8\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"plus\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"5\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"equals\")").click();

        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        System.out.println(result);

        driver.quit();
    }

}