import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v125.css.model.Value;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Vector;

public class LongPress
    extends BaseTest

{
    @Test
    public void longPressGesture()
        throws
        URISyntaxException,
        MalformedURLException,
        InterruptedException
    {
        // Find the element with the accessibility ID "Views" and click on it
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        // Find the element with the text "Expandable Lists" and click on it
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();

        // Find the element with the accessibility ID "1. Custom Adapter" and click on it
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        // Find the element with the text "People Names" and assign it to the variable "ele"
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));

        longPressAction( ele );

//        // Execute a JavaScript function called "mobile: longClickGesture" on the driver object
//        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
//                                                   // Pass a map as an argument to the JavaScript function
//                                                   // The map contains two key-value pairs: "elementId" and "duration"
//                                                   // "elementId" is the ID of the element "ele" and "duration" is the duration of the long press gesture in milliseconds
//                                                   ImmutableMap.of(
//                                                       "elementId", ((RemoteWebElement)ele).getId(),
//                                                       "duration", 2000.0
//                                                                  )
//                                                  );

        String menuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
        Assert.assertEquals(menuText, "Sample menu");

        Assert.assertTrue(driver.findElement( AppiumBy.id( "android:id/title" ) ).isDisplayed( ));


    }
}
