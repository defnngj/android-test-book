package Appauto;/*
 * Copyright (c) 2016-2017 Knife, Inc. and other contributors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

/**
 * knife.BrowserEmulator is based on Selenium3 and adds some enhancements
 *
 * @author bugmaster
 */
public class AppiumEmulator {

    static AndroidDriver driver;
    ChromeDriverService chromeServer;
    JavascriptExecutor javaScriptExecutor;

    int timeout = Integer.parseInt(GlobalSettings.timeout);

    public AppiumEmulator() throws MalformedURLException {

        String deviceName = GlobalSettings.deviceName;
        String automationName = GlobalSettings.automationName;
        String platformName = GlobalSettings.platformName;
        String platformVersion = GlobalSettings.platformVersion;
        String appPackage = GlobalSettings.appPackage;
        String appActivity = GlobalSettings.appActivity;
        Boolean noReset = GlobalSettings.noReset;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("noReset", noReset);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Analyzing targeting elements, and positioning elements
     *
     * @param xpath
     *            the element's
     */
    public WebElement getElement(String xpath) {

        if (xpath.contains("=>") == false) {
            Assert.fail("Positioning syntax errors, lack of '=>'.");
        }

        String by = xpath.split("=>")[0];
        String value = xpath.split("=>")[1];

        if (by.equals("id")) {
            WebElement element = driver.findElement(By.id(value));
            return element;
        } else if (by.equals("class")) {
            WebElement element = driver.findElement(By.className(value));
            return element;
        }  else if (by.equals("xpath")) {
            WebElement element = driver.findElement(By.xpath(value));
            return element;
        } else if (by.equals("aid")) {
            WebElement element = driver.findElementByAccessibilityId(value);
            return element;
        } else if (by.equals("ui")) {
            WebElement element = driver.findElementByAndroidUIAutomator(value);
            return element;
        }else {
            Assert.fail("Please enter the correct targeting elements,'id','class','xpath','accessibilityId','UIAutomator'.");
        }
        return null;

    }

    /**
     * Close the APP
     */
    public void close() {
        driver.close();
    }

    /**
     * Quit the APP
     */
    public void quit() {
        driver.quit();
    }

    /**
     * Click the page element
     *
     * @param xpath
     *  the element's xpath
     */
    public void click(String xpath) {

        WebElement element = getElement(xpath);
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Type text at the page element<br>
     * Before typing, try to clear existed text
     *
     * @param xpath
     *            , the element's xpath
     * @param text
     *            , the input text
     */
    public void type(String xpath, String text) {

        WebElement element = getElement(xpath);

        try {
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Return text from specified web element.
     *
     * @param xpath
     * @return
     */
    public String getText(String xpath) {
        WebElement element = getElement(xpath);
        return element.getText();
    }


}
