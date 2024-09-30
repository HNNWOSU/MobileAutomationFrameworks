import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.Cookie;
import java.time.Duration;

public class MobileBrowserTest extends BrowserBaseTest {

    @Test
    public void mobileBrowser() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        driver.get("https://www.google.com");


        Thread.sleep(3000); // Ensure page is fully loaded
        System.out.println(driver.getTitle());

        WebElement readMore = wait.until(ExpectedConditions.elementToBeClickable(By.id("KByQx")));
        readMore.click();
        WebElement readMore1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("KByQx")));
        readMore1.click();
        WebElement readMore2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("KByQx")));
        readMore2.click();

        WebElement rejectCookie = wait.until(ExpectedConditions.elementToBeClickable(By.id("W0wltc")));
        rejectCookie.click();
//        WebElement acceptCookie = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb")));
//        acceptCookie.click();


        // Perform search operation
        driver.findElement(By.name("q")).sendKeys("appium tutorial");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);


//        // Try setting value using JavaScript as a fallback
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='Kamala Harris';", searchBox);
//
//        // Optionally, dispatch the Enter key event
//        js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', {'key': 'Enter'}));", searchBox);
//        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");


    }
}


