package Appauto;

import io.appium.java_client.android.AndroidDriver;

public class PressKeyClass {

    public void press(AndroidDriver driver, String key){
        if(key.equals("0")){
            driver.pressKeyCode(7);
        }
        else if(key.equals("1")){
            driver.pressKeyCode(8);
        }
        else if(key.equals("2")){
            driver.pressKeyCode(9);
        }
        else if(key.equals("3")){
            driver.pressKeyCode(10);
        }
        else if(key.equals("4")){
            driver.pressKeyCode(11);
        }
        else if(key.equals("5")){
            driver.pressKeyCode(12);
        }
        else if(key.equals("6")){
            driver.pressKeyCode(13);
        }
        else if(key.equals("7")){
            driver.pressKeyCode(14);
        }
        else if(key.equals("8")){
            driver.pressKeyCode(15);
        }
        else if(key.equals("9")){
            driver.pressKeyCode(16);
        }
        else {
            // ...
        }
    }
}
