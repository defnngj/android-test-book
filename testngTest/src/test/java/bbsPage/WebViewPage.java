package bbsPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class WebViewPage {
    private AndroidDriver driver;

    public WebViewPage(AndroidDriver driver) {
        this.driver = driver;
    }

    /**
     * Switch to NATIVE_APP or WEBVIEW
     * @param sContext window name
     */
    public void switchToContext(String sContext) {

        Set<String> contextNames = this.driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains(sContext)) {
                this.driver.context(contextName);
                break;
            }
        }
    }

    // https://wan.meizu.com/products/activities
    public void viewProduct(){
        List<WebElement> link = this.driver.findElements(By.linkText("查看产品"));
        link.get(0).click();
    }

    public String viewProductTitle(){
        String title = this.driver.getTitle();
        return title;
    }

}
