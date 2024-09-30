import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerceMultiTests extends BaseTest {

    @BeforeMethod
    public void preSetUp() {
        // Check if already on the home screen
        if (!isHomeScreen()) {
            Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
            ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", activity.getAppPackage() + "/" + activity.getAppActivity()));
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
    }

    private boolean isHomeScreen() {
        // Implement logic to check if on home screen, e.g., checking for the presence of a unique element
        return driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/nameField")).size() > 0;
    }


    @Test
    public void FillForm() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        // Wait for the name field to be visible and then send keys
        // Commented out because this test expects no name input
        // WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
        // nameField.sendKeys("Henry Of Ashford");

        driver.hideKeyboard();

        // Click on the male radio button
        WebElement maleRadio = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")")));
        maleRadio.click();

        // Open the country dropdown
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")));
        countryDropdown.click();

        // Scroll to and select "Aruba"
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));"));
// Alternative way to locate the element (if UiSelector is causing issues)
        WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Aruba']")));
        countryOption.click();


        // Click the 'Let's Shop' button
        WebElement letsShopButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")));
        letsShopButton.click();

        // Handle Toast message
        String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(toastMessage);
        Assert.assertEquals(toastMessage, "Please enter your name");
    }

    @Test
    public void FillForm_PositiveFlow() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Fill in the name field
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
        nameField.sendKeys("Henry Of Ashford");
        driver.hideKeyboard();

        // Select the male radio button
        WebElement maleRadio = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")")));
        maleRadio.click();

        // Open the country dropdown
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")));
        countryDropdown.click();

        // Scroll to and select "Aruba"
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));"));
        WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Aruba\")")));
        countryOption.click();

        // Click the 'Let's Shop' button
        WebElement letsShopButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")));
        letsShopButton.click();

        // Verify that the toast message does not appear
        Assert.assertTrue(driver.findElements(AppiumBy.xpath("//android.widget.Toast[1]")).size() < 1);
    }

}
