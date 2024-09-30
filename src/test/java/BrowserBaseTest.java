import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BrowserBaseTest {

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
  //          .setDeviceName("Pixel Fold API 34")
            .setChromedriverExecutable("//Users//henrynwosu//Documents//chromedriver-mac-arm64//chromedriver");
 //              .setChromedriverExecutable("//Users//henrynwosu//Documents//113 " +
  //      "chromedriver_mac_arm64//ChromeDriver_113");
        options.setCapability("browserName","Chrome");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-popup-blocking");

 //      options.setCapability("noReset",true);

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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