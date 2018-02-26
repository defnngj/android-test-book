package appiumAPI;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesktopCopy {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Android Emulator");
        desiredCapabilities.setCapability("automationName", "Appium");
        desiredCapabilities.setCapability("platformVersion", "6.0");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", ".Calculator");
        desiredCapabilities.setCapability("platformName", "Android");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        (new TouchAction(driver)).tap(66, 579).perform();
        (new TouchAction(driver)).tap(402, 716).perform();
        (new TouchAction(driver)).tap(174, 577).perform();
        (new TouchAction(driver)).tap(280, 712).perform();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

