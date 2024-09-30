import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends iOSBaseTest
{
    @Test
  public void iOStestApp()
    {
driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")).click();
driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField")).sendKeys("Henry Hill");
driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"OK\"`]")).click();

//iOSNsPredicate uses
//       driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / " +
//               "Cancel'")).click();
//       driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] " +
//               "'Confirm'")).click();
       driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Confirm / Cancel\"")).click();

       String text =driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();
        Assert.assertEquals(text, "A message should be a short, complete sentence.");
        System.out.println(text);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();

  }
}

