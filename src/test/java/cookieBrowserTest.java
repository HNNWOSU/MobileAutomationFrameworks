import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class cookieBrowserTest extends BrowserBaseTest {

    @Test
    public void moBrowser() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Load the Google page
//        driver.get("https://www.google.com");
//        wait.until(ExpectedConditions.titleContains("Google"));
//        System.out.println(driver.getTitle());
//
//        // Try interacting with the cookie consent page using JavaScript
//        try {
//            WebElement readMore = wait.until(ExpectedConditions.elementToBeClickable(By.id("KByQx")));
//            // Scroll the read more button into view
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", readMore);
//
//            // Click the read more button using JavaScript to avoid multiple clicks
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", readMore);
//
//            // Now click on the reject cookies button
//            WebElement rejectCookie = wait.until(ExpectedConditions.elementToBeClickable(By.id("W0wltc")));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rejectCookie);
//
//            // Alternatively, accept cookies:
//            // WebElement acceptCookie = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb")));
//            // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptCookie);
//        } catch (TimeoutException e) {
//            System.out.println("Cookie consent elements were not found, proceeding with the test.");
//        }
//
//        // Perform search operation
//        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
//        searchBox.sendKeys("appium tutorial");
//        searchBox.sendKeys(Keys.ENTER);
//
//        // Wait for results to load
////        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
//
//        // Press back and return to the native app
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        driver.context("NATIVE_APP");

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        // Ensure page is fully loaded
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.xpath("//a[@routerlink='/products']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
        String text =driver.findElement(By.xpath("//a[normalize-space()='Devops']")).getText();
        Assert.assertEquals(text,"Devops");
    }
}
