package PageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NumberPage {
    public AndroidDriver driver;

    // 构造方法
    public NumberPage(AndroidDriver driver) {
        this.driver = driver;
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

    public void result(String res){
        System.out.print(res);
    }

    public void login(String usernam,String password){

    }
}
