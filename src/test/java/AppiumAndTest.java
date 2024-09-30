import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class AppiumAndTest extends BaseTest {

    @Test
    public void testAppium1() throws URISyntaxException, MalformedURLException {
        // Navigate to the Preference screen
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        // Navigate to the Preference dependencies screen
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

        // Enable the checkbox
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        // Click on the first RelativeLayout element
        List<WebElement> relativeLayouts = driver.findElements(By.xpath("//android.widget.RelativeLayout"));
        relativeLayouts.get(1).click();

        // Verify the alert title
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        // Enter text in the edit field
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("HN WiFi");

        // Click on the second button (OK button)
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}