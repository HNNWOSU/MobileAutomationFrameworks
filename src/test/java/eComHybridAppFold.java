import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class eComHybridAppFold extends BaseTest {
//    @BeforeClass
//    public void setup() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("adb_shell", true);
        // other capabilities

    //}

    // Method to set device to folded mode
    public void setFoldedMode() {
        driver.executeScript("mobile: shell", ImmutableMap.of("command", "am broadcast -a android.intent.action.SET_FOLDED_STATE --ez state true"));
    }

    // Method to set device to unfolded mode
    public void setUnfoldedMode() {
        driver.executeScript("mobile: shell", ImmutableMap.of("command", "am broadcast -a android.intent.action.SET_FOLDED_STATE --ez state false"));
    }

    @Test
    public void FillForm1() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Unfold device and interact
        setUnfoldedMode();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));

        // Interact with the form in unfolded mode
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
        nameField.sendKeys("Henry Of Ashford");
        driver.hideKeyboard();

        // Fold device and interact
        setFoldedMode();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")")));

        // Interact with the elements in folded mode
        WebElement maleRadio = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")")));
        maleRadio.click();

        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")));
        countryDropdown.click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nigeria\"));"));
        WebElement nigeriaOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Nigeria\")")));
        nigeriaOption.click();

        WebElement letsShopButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")));
        letsShopButton.click();

        Thread.sleep(5000); // Wait for the action to complete
    }
}
