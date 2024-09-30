import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iOSSwipeTest extends iOSInBuiltBaseTest
{
    @Test
  public void iOSSwipeTest()
    {
        Map <String, String> params = new HashMap<String, String>();
        params.put("bundleId","com.apple.mobileslideshow");
driver.executeScript("mobile: launchApp",params);
driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"All Photos\"`]")).click();
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(allPhotos.size());

        driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[1]")).click();
        for (int i=0;i<allPhotos.size();i++)
        {
            System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
            Map<String, Object> params1 = new HashMap<String, Object>();
            //params1.put("elementId", ((RemoteWebElement) allPhotos.get(1)).getId());
            params1.put("direction", "left");
            ((JavascriptExecutor) driver).executeScript("mobile: swipe", params1);
        }

        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Albums")).click(); //cleanup
  }
}

