import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
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
import java.util.HashMap;
import java.util.Map;

public class iOSInBuiltBaseTest {

    public IOSDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void setUpAppium() throws URISyntaxException, MalformedURLException {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
            .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
            .withIPAddress("127.0.0.1")
            .usingPort(4723);

        service = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        service.start();

        XCUITestOptions options = new XCUITestOptions()
            .setDeviceName("iPhone 15 Pro Max")
            .setPlatformName("iOS")
            .setPlatformVersion("17.5");

        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

public void iOSlongPressAction(WebElement ele)
{
    Map<String, Object> params = new HashMap<>();
    params.put("elementId", ((RemoteWebElement) ele).getId());
    params.put("duration", 5.0);
    ((JavascriptExecutor) driver).executeScript("mobile: touchAndHold", params);
}

public void iOSScrollAction(WebElement scroll){

    Map <String, Object> params = new HashMap<>();
    params.put("elementId", ((RemoteWebElement) scroll).getId());
    params.put("direction", "down");
    ((JavascriptExecutor) driver).executeScript("mobile: scroll", params);


}
    @AfterClass
    public void tearDownAppium() {
        driver.quit();
        service.stop();
    }
}