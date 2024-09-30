import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class iOSSlider extends iOSBaseTest
{
    @Test
  public void iOSSliderTest() throws InterruptedException {

        WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"AppElem\"`]"));
slider.sendKeys("0%");
Assert.assertEquals("0%",slider.getAttribute("value"));
Thread.sleep(5000);
slider.sendKeys("1%");
Assert.assertEquals("100%",slider.getAttribute("value"));



  }
}

