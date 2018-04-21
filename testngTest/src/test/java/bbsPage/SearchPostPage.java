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
        this.driver.findElement(By.id("com.meizu.mzbbs:id/j2")).click();
    }

    // 搜索输入框
    public void searchInput(String searchKey){
        this.driver.findElement(By.id("com.meizu.mzbbs:id/pf")).sendKeys(searchKey);
    }

    // 搜索按钮
    public void searchButton(){
        this.driver.findElement(By.id("com.meizu.mzbbs:id/us")).click();
    }

    // 返回首页
    public void returnIndexPage(){
        this.driver.pressKeyCode(4);
        this.driver.pressKeyCode(4);
        this.driver.pressKeyCode(4);
    }

    // 搜索结果断言
    public String searchResults(){
        List<WebElement> texts = this.driver.findElements(By.id("com.meizu.mzbbs:id/dv"));
        return texts.get(1).getText();
    }
}
