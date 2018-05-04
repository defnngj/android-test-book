package Appauto;/*
 * Copyright (c) 2016-2018 Appauto, Inc. and other contributors
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
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;


/**
 * knife.BrowserEmulator is based on Selenium3 and adds some enhancements
 *
 * @author bugmaster
 */
public class AppiumEmulator {

    static AndroidDriver driver;

    int timeout = Integer.parseInt(GlobalSettings.timeout);

    public AppiumEmulator() {

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
     * @param xpath: the element's
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
     * @param xpath: the element's xpath
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
     * @param xpath: the element's xpath
     * @param text: the input text
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
     * @return text
     */
    public String getText(String xpath) {
        WebElement element = getElement(xpath);
        return element.getText();
    }

    /**
     * install App
     *
     * @param app:app path
     */
    public void installApp(String app){
        driver.installApp(app);
    }

    /**
     * uninstall App
     *
     * @param packageName: package name.
     */
    public void removeApp(String packageName){
        driver.removeApp(packageName);
    }

    /**
     * is App installed
     *
     * @param packageName: package name.
     */
    public void isAppInstalled(String packageName){
        driver.isAppInstalled(packageName);
    }

    /**
     * Close the current open App
     *
     * @param
     */
    public void closeApp(){
        driver.closeApp();
    }

    /**
     * Restart the App
     *
     * @param
     */
    public void launchApp(){
        driver.launchApp();
    }

    /**
     * Run App in background
     *
     * @param timing: seconds.
     */
    public void runAppInBackground(Duration timing){
        driver.runAppInBackground(timing);
    }

    /**
     * Reset App
     *
     * @param
     */
    public void resetApp(){
        driver.resetApp();
    }

    /**
     * get context
     *
     * @param
     */
    public void getContext(){
        driver.getContext();
    }

    /**
     * get all context
     *
     * @param
     */
    public void getContextHandles(){
        driver.getContextHandles();
    }

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

    /**
     * Keyboard entry
     * @param key: keyboard name
     */
    public void pressKey(String key){
        PressKeyClass p = new PressKeyClass();
        p.press(driver, key);
    }

}
