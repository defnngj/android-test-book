package PageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalcuatorPage {

    public AndroidDriver driver;

    // 构造方法
    public CalcuatorPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // 加号
    public void add(){
        this.driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
    }

    // 减号
    public void sub(){
        this.driver.findElement(By.id("com.android.calculator2:id/op_sub")).click();
    }

    // 乘号
    public void mul(){
        this.driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
    }

    // 除号
    public void div(){
        this.driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
    }

    // 删除
    public void del(){
        this.driver.findElement(By.id("com.android.calculator2:id/del")).click();
    }

    // 清除结果
    public void clr(){
        this.driver.findElement(By.id("com.android.calculator2:id/clr")).click();
    }

    // 等号
    public void eq(){
        this.driver.findElement(By.id("com.android.calculator2:id/eq")).click();
    }

    // 结果
    public String result(){
        String result = this.driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        return result;
    }
    public void number_1(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
    }

    public void number_2(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
    }
    public void number_3(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();
    }
    public void number_4(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
    }
    public void number_5(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
    }
    public void number_6(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();
    }
    public void number_7(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
    }
    public void number_8(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
    }
    public void number_9(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
    }
    public void number_0(){
        this.driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
    }


}
