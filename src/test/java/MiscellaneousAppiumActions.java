import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

public class MiscellaneousAppiumActions extends BaseTest {

    @Test
    public void MiscellaneousActions() throws URISyntaxException, MalformedURLException {

        //adb shell dumpsys window | grep -E 'mCurrentFocus|mFocusedApp'
        //App Package and App Activity


       Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference" +
            ".PreferenceDependencies");

               // Navigate to the Preference dependencies screen
               ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
                       "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enable the checkbox
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/checkbox")));
        checkbox.click();

        // Rotate the device

        DeviceRotation landscape = new DeviceRotation(0, 0, 90);
        driver.rotate(landscape);

        //Click on the first RelativeLayout element
       List<WebElement> relativeLayouts = driver.findElements(By.xpath("//android.widget.RelativeLayout"));
       relativeLayouts.get(1).click();

        // Verify the alert title
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        //Copy and Paste From Clipboard
        driver.setClipboardText("HENRY WiFi NETWORK");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        // Enter text in the edit field
        //driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("HN WiFi");

        // Click on the second button (OK button)
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

        //Device rotation Portrait
        DeviceRotation portrait = new DeviceRotation(0, 0, 0);
        driver.rotate(portrait);

    }
}