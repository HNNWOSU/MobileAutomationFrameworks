import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eComtc_2_enhanced_forLoop extends BaseTest {


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
        driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(0)")).getFirst().click();
        driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample" +
                ".generalstore:id/productAddCart\").instance(1)")).getFirst().click();
        // After adding to cart, click on the cart icon
       WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample" +
               ".generalstore:id/appbar_btn_cart")));cartIcon.click();

        //Thread.sleep(5000);
         // Verify the product added to the cart
        wait.until(ExpectedConditions.attributeContains(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample" +
            ".generalstore:id/toolbar_title\")"), "text", "Cart"));

        List<WebElement> productPrices = driver.findElements(AppiumBy.id("com.androidsample" +
                ".generalstore:id/productPrice"));
        int count = productPrices.size();
        double totalSum =0;
        for (WebElement productPrice : productPrices) {
            String amountString = productPrice.getText();
            double price = Double.parseDouble(amountString.substring(1));
            totalSum = totalSum + price;
            System.out.println(totalSum);
        }
        String displaySum = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum = getFormattedAmount(displaySum);
        Assert.assertEquals(displayFormattedSum, totalSum);

        }


        // Optionally wait for some time before ending the test

    }











