package AppautoDemo;

import Appauto.AppiumEmulator;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalPage {
    public AppiumEmulator driver;

    // 构造方法
    public CalPage(AppiumEmulator driver) {
        this.driver = driver;
    }

    // 加号
    public void add(){
        this.driver.click("id=>com.android.calculator2:id/op_add");
    }

    // 减号
    public void sub(){
        this.driver.click("id=>com.android.calculator2:id/op_sub");
    }

    // 乘号
    public void mul(){
        this.driver.click("id=>com.android.calculator2:id/op_mul");
    }

    // 除号
    public void div(){
        this.driver.click("id=>com.android.calculator2:id/op_div");
    }

    // 删除
    public void del(){
        this.driver.click("id=>com.android.calculator2:id/del");
    }

    // 清除结果
    public void clr(){
        this.driver.click("id=>com.android.calculator2:id/clr");
    }

    // 等号
    public void eq(){
        this.driver.click("id=>com.android.calculator2:id/eq");
    }

    // 结果
    public String result(){
        String result = this.driver.getText("id=>com.android.calculator2:id/result");
        return result;
    }

    public void number_1(){
        this.driver.click("id=>com.android.calculator2:id/digit_1");
    }
    public void number_2(){
        this.driver.click("id=>com.android.calculator2:id/digit_2");
    }
    public void number_3(){
        this.driver.click("id=>com.android.calculator2:id/digit_3");
    }
    public void number_4(){
        this.driver.click("id=>com.android.calculator2:id/digit_4");
    }

    public void number_5(){
        this.driver.click("id=>com.android.calculator2:id/digit_5");
    }
    public void number_6(){
        this.driver.click("id=>com.android.calculator2:id/digit_6");
    }
    public void number_7(){
        this.driver.click("id=>com.android.calculator2:id/digit_7");
    }
    public void number_8(){
        this.driver.click("id=>com.android.calculator2:id/digit_8");
    }
    public void number_9(){
        this.driver.click("id=>com.android.calculator2:id/digit_9");
    }
    public void number_0(){
        this.driver.click("id=>com.android.calculator2:id/digit_0");
    }

}
