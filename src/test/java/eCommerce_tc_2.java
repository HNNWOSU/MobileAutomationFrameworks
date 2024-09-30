import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class eCommerce_tc_2 extends BaseTest {


    @Test
    public void eCommerce() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        // Interactions in the app before switching to the WebView
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
        nameField.sendKeys("Henry Of Ashford");
        driver.hideKeyboard();

        WebElement maleRadio = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")")));
        maleRadio.click();

        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"android:id/text1\")")));
        countryDropdown.click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Aruba\"));"));
        WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Aruba\")")));
        countryOption.click();

        WebElement letsShopButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")));
        letsShopButton.click();
        driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(0)")).get(0).click();
        driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample" +
                ".generalstore:id/productAddCart\").instance(1)")).get(0).click();

        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")));
        cartIcon.click();

        wait.until(ExpectedConditions.attributeContains(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/toolbar_title\")"), "text", "Cart"));

        List<WebElement> productPrices = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++) {
            String amountString = productPrices.get(i).getText();
            double price = getFormattedAmount(amountString);
            totalSum = totalSum + price;
            System.out.println(totalSum);
        }

        String displaySum = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum = getFormattedAmount(displaySum);
        Assert.assertEquals(displayFormattedSum, totalSum);

        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/termsButton\"]"));
        longPressAction(ele);

        String targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/alertTitle"))).getText();
        Assert.assertEquals(targetElement, "Terms Of Conditions");

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnProceed\")")).click();
 //       Thread.sleep(5000);

        // Switch to WebView context

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
Thread.sleep(5000);
        try {
            WebElement readMore = wait.until(ExpectedConditions.elementToBeClickable(By.id("KByQx")));
            // Scroll the read more button into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", readMore);

            // Click the read more button using JavaScript to avoid multiple clicks
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", readMore);

            // Now click on the reject cookies button
            WebElement rejectCookie = wait.until(ExpectedConditions.elementToBeClickable(By.id("W0wltc")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rejectCookie);

            // Alternatively, accept cookies:
            // WebElement acceptCookie = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb")));
            // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptCookie);
        } catch (TimeoutException e) {
            System.out.println("Cookie consent elements were not found, proceeding with the test.");
        }

        // Perform search operation
  driver.findElement(By.name("q")).sendKeys("Kamala Harris");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        // Go back to the native app context
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }
}








