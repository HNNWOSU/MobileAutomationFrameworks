import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eCommerce_tc_1 extends BaseTest {


    @Test
    public void FillForm1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Test against screen unfolded

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField"))); // Replace with actual element

        // Interactions in unfolded mode
        // Example: Validate the unfolded state
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
        nameField.sendKeys("Henry Of Ashford");
        driver.hideKeyboard();

        // Test against screen folded


        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector()" +
                ".resourceId(\"com.androidsample.generalstore:id/radioMale\")")));
        // ; // Replace with actual element

        // Wait for and interact with the male radio button
        WebElement maleRadio = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")")));
        maleRadio.click();

        // Wait for the dropdown to be clickable
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"android:id/text1\")")));countryDropdown.click();

        // Scroll and click on Aruba
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Aruba\"));"));
        WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Aruba\")")));countryOption.click();

        // Wait for the 'Let's Shop' button to be clickable and then click
        WebElement letsShopButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")));
        letsShopButton.click();

        //Scrolling in Product list
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));"));


// Get the list of product names and their corresponding 'Add to Cart' buttons
        List<WebElement> products = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"));
        List<WebElement> addToCartButtons = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart"));

        int productCount = ((java.util.List<?>) products).size();

        for (int i = 0; i < productCount; i++) {
            String productName = products.get(i).getText();  // Access the product name at index 'i'

            if (productName.equals("Jordan 6 Rings")) {
                addToCartButtons.get(i).click();  // Click the 'Add to Cart' button corresponding to the product

            }
        }

// After adding to cart, click on the cart icon
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();


        //Thread.sleep(5000);

         // Verify the product added to the cart
        wait.until(ExpectedConditions.attributeContains(AppiumBy.id("com.androidsample" +
                ".generalstore:id/toolbar_title"), "text", "Cart"));
        String lastPageProduct = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
        }


        // Optionally wait for some time before ending the test

    }











