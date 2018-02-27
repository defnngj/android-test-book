package bbsPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SwitchPlatePage {

    private AndroidDriver driver;
    public static final String BUTTONS = "com.meizu.mzbbs:id/h9";

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
        List<WebElement> button =this.driver.findElements(By
                .id(BUTTONS));
        button.get(1).click();
    }

    public String photographyTitle() {
        String title = this.driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c[1]/android.widget.TextView")).getText();
        return title;
    }

    public void TryPlayButton() {
        List<WebElement> button =this.driver.findElements(By
                .id(BUTTONS));
        button.get(2).click();
    }

    public String TryPlayTitle() {
        String title = driver.findElement(By
                .xpath("//android.widget.LinearLayout/android.support.v7.a.a" +
                ".c/android.widget.TextView")).getText();
        return title;
    }

    public void UserButton() {
        List<WebElement> button =this.driver.findElements(By
                .id(BUTTONS));
        button.get(3).click();
    }

    public String UserName() {
        String username = driver.findElement(By.id("com.meizu.mzbbs:id/ft"))
                .getText();
        return username;
    }

}
