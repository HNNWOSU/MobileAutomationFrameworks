import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Map;

public class SwipeAndInteractTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void setUpAppium() throws URISyntaxException, MalformedURLException {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
            .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
            .withIPAddress("127.0.0.1")
            .usingPort(4723);

        service = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        service.start();

        UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName("Samsung SM-F926B API 34")
            .setApp("/Users/henrynwosu/APPIUMTRAINING/Appium/src/test/java/resources/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void swipeLeftAndInteract() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']")).click();

        // First, find the element that we can swipe on
        WebElement elementToSwipe = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));

        // Get the elementId of the elementToSwipe
        String elementId = ((RemoteWebElement) elementToSwipe).getId();

        // Perform the swipe action
        Map<String, Object> params = Map.of(
                "elementId", elementId,
                "direction", "left",
                "percent", 0.75 // Swipe 75% of the screen width
        );
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", params);

        // After swiping, find and interact with the target element
        WebElement targetElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)"));
        targetElement.isDisplayed();
    }


    @AfterClass
    public void tearDownAppium() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
