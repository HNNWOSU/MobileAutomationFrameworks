import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSLongpress extends iOSBaseTest
{
    @Test
  public void iOSLongpressTest()
    {
driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Steppers\"`]")).click();
WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][3]"));
        Map <String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) ele).getId());
        params.put("duration", 5.0);
        ((JavascriptExecutor) driver).executeScript("mobile: touchAndHold", params);


  }
}

