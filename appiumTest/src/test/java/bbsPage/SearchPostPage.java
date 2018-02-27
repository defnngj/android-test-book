package bbsPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPostPage {

    private AndroidDriver driver;

    public SearchPostPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // 搜索图标
    public void searchLogo(){
        this.driver.findElement(By.id("com.meizu.mzbbs:id/j0")).click();
    }

    // 索索输入框
    public void searchInput(String searchKey){
        this.driver.findElement(By.id("com.meizu.mzbbs:id/p9")).sendKeys(searchKey);
    }

    // 搜索按钮
    public void searchButton(){
        this.driver.findElement(By.id("com.meizu.mzbbs:id/tp")).click();
    }

    // 返回首页
    public void returnIdexPage(){
        this.driver.pressKeyCode(4);
        this.driver.pressKeyCode(4);
        this.driver.pressKeyCode(4);
    }

    // 搜索结果断言
    public String searchResults(){
        List<WebElement> texts = this.driver.findElements(By.id("com.meizu.mzbbs:id/dt"));
        return texts.get(0).getText();
    }
}
