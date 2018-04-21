package Appauto;/*
 * Copyright (c) 2015-2016 bugmaster, Inc. and other contributors
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

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Global Settings
 * @author bugmaster
 */
public class GlobalSettings {

    public static Properties prop = getProperties();

    public static String deviceName = prop.getProperty("deviceName", "Android Emulator");
    public static String automationName = prop.getProperty("automationName", "Appium");
    public static String platformName = prop.getProperty("platformName", "Appium");
    public static String platformVersion = prop.getProperty("platformVersion", "7.0");
    public static Boolean noReset = true;
    public static String appPackage = prop.getProperty("appPackage", "");
    public static String appActivity = prop.getProperty("appActivity", "");

    public static String timeout = prop.getProperty("Timeout", "5");

    public static String getProperty(String property) {
        return prop.getProperty(property);
    }

    public static Properties getProperties() {
        Properties prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("prop.properties");
            prop.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}

