package BBSTest;

import PageObject.CalcuatorPage;
import PageObject.NumberPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Sample {

    public static class CalcuatorTest {

        public static void main(String[] args) throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "PRO5");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "7.0");
            capabilities.setCapability("appPackage", "com.meizu.mzbbs");
            capabilities.setCapability("appActivity", "com.meizu.mzbbs.ui.LoadingActivity");
            capabilities.setCapability("noReset", true);

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                    capabilities);
        }
    }
}
