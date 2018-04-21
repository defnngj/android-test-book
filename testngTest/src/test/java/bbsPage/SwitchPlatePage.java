package bbsPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SwitchPlatePage {

    private AndroidDriver driver;
    public static final String BUTTONS = "com.meizu.mzbbs:id/ha";

    public SwitchPlatePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // 首页按钮
    public void indexButton() {
        List<WebElement> button =this.driver.findElements(By.id(BUTTONS));
        button.get(0).click();
    }

    public String bbsTitle() {
        String title = this.driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c[1]/android.widget.TextView")).getText();
        return title;
    }

    // 摄影按钮
    public void photographyButton() {
        List<WebElement> button =this.driver.findElements(By.id(BUTTONS));
        button.get(1).click();
    }

    public String photographyTitle() {
        String title = this.driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c[1]/android.widget.TextView")).getText();
        return title;
    }

    // 板块按钮
    public void TryPlayButton() {
        List<WebElement> button =this.driver.findElements(By.id(BUTTONS));
        button.get(2).click();
    }

    public String TryPlayTitle() {
        String title = driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c/android.widget.TextView")).getText();
        return title;
    }

    // 个人中心
    public void UserButton() {
        List<WebElement> button =this.driver.findElements(By.id(BUTTONS));
        button.get(3).click();
    }

    // 个人昵称
    public String UserName() {
        String username = driver.findElement(By.id("com.meizu.mzbbs:id/fv"))
                .getText();
        return username;
    }

}
