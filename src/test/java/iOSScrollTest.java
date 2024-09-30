import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSScrollTest extends iOSBaseTest
{
    @Test
  public void iOSLongpressTest() throws InterruptedException {
        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Web View\"`]"));
        Map <String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) ele).getId());
        params.put("direction", "down");
        ((JavascriptExecutor) driver).executeScript("mobile: scroll", params);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Web View\"`]")).click();
Thread.sleep(5000);
driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"UIKitCatalog\"`]")).click();
driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Picker View\"`]")).click();
driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == \"Red color component value\"`]")).sendKeys("50");
driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == \"Green color component value\"`]")).sendKeys("230");
driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == \"Blue color component value\"`]")).sendKeys("140");
String number = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == \"Blue color component value\"`]")).getText();
System.out.println(number);
        Assert.assertEquals(number, "140");

Thread.sleep(5000);


  }
}

