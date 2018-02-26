package bbsPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class SwitchPlatePage {

    private AndroidDriver driver;

    public SwitchPlatePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String bbsTitle() {
        String title = this.driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c[1]/android.widget.TextView")).getText();
        return title;
    }

    public void photographyButton() {
        this.driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.widget"+
                        ".FrameLayout[2]")).click();
    }

    public String photographyTitle() {
        String title = this.driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c[1]/android.widget.TextView")).getText();
        return title;
    }

    public void TryPlayButton() {
        this.driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.widget."
                        +".FrameLayout[3]")).click();
    }

    public String TryPlayTitle() {
        String title = driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c/android.widget.TextView")).getText();
        return title;
    }

    public void UserButton() {
        this.driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.widget"+
                        ".FrameLayout[4]")).click();
    }

    public String UserName() {
        String username = driver.findElement(By.id("com.meizu.mzbbs:id/ft"))
                .getText();
        return username;
    }

}
