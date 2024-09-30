import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {

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
 //           .setDeviceName("Samsung SM-F926B API 34")
               .setDeviceName("Pixel Fold API 34")
 //               .setChromedriverExecutable("//Users//henrynwosu//Documents//chromedriver-mac-arm64//chromedriver")
        .setChromedriverExecutable("//Users//henrynwosu//Documents//113 " +
                        "chromedriver_mac_arm64//ChromeDriver_113")
           // .setApp("/Users/henrynwosu/Documents/MobileAutomation/src/test/resources/ApiDemos-debug.apk");
           .setApp("/Users/henrynwosu/Documents/MobileAutomation/src/test/resources/General-Store.apk");
//       options.setCapability("noReset",true);

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void longPressAction( WebElement ele )
    {
        // Execute a JavaScript function called "mobile: longClickGesture" on the driver object
        (( JavascriptExecutor )driver).executeScript( "mobile: longClickGesture",
                // Pass a map as an argument to the JavaScript function
                // The map contains two key-value pairs: "elementId" and "duration"
                // "elementId" is the ID of the element "ele" and "duration" is the duration of the long press gesture in milliseconds
                ImmutableMap.of("elementId", (( RemoteWebElement )ele).getId( ), "duration", 2000.0));

    }

    public void scrollToEndAction()
    {
        boolean canScrollMore;
	do {
        canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                ImmutableMap.of("left", 100, "top", 100, "width", 200, "height",
                        200, "direction", "down", "percent", 10.0
                ));
        }while (canScrollMore) ;
    }

    public void swipeAction( WebElement ele,String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of
                ("elementId", ((RemoteWebElement) ele).getId(),
                        "direction", direction, "percent", 0.75));




    }
public Double getFormattedAmount(String amountString)
    {
        return Double.parseDouble(amountString.substring(1));
    }


    @AfterClass
    public void tearDownAppium() {
        driver.quit();
        service.stop();
    }
}