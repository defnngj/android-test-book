package appiumAPI;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class WebViewTest {

    public static AndroidDriver driver;

    /**
     * Switch to NATIVE_APP or WEBVIEW
     * @param sContext window name
     */
    private static void switchToContext(String sContext) {

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains(sContext)) {
                driver.context(contextName);
                break;
            }
        }
    }


    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.example.anwebview");
        capabilities.setCapability("appActivity", ".MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //获得当前应用的所有上下文,并打印
        Set<String> all_ct = driver.getContextHandles();
        for (String ct : all_ct) {
            System.out.println(ct);
        }

        // 切换WEBVIEW
        switchToContext("WEBVIEW_com.example.anwebview");

        driver.findElement(By.id("index-kw")).sendKeys("appium webView");
        driver.findElement(By.id("index-bn")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
