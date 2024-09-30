import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class eComHybridExtentReport extends BaseTest
{
    ExtentReports extent;

    @BeforeTest
    public void config()
{
    //Extent Report Configuration - ExtentReports and ExtentSparkReporter
String path = System.getProperty("user.dir")+"/src/main/Reports/report2/index.html";

    ExtentSparkReporter reporter = new ExtentSparkReporter(path);

    reporter.config().setReportName("Mobile Automation Test Results");
    reporter.config().setDocumentTitle("CreateFuture Test Results");


    extent = new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("Tester","Henry CreateFuture");



}
    @Test
    public void FillForm() throws InterruptedException
    {

        ExtentTest test =extent.createTest("FillForm");
        //Create an explicit wait instance with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the name field to be visible and then send keys
//                WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
//                nameField.sendKeys("Henry Of Ashford");
        driver.hideKeyboard();
        // Wait for the male radio button to be visible and then click
        WebElement maleRadio = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")")));
        maleRadio.click();
        // Wait for the dropdown to be clickable
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")));
        countryDropdown.click();
        // Scroll and click on Nigeria
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Aruba\"));"));
        WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Aruba\")")));
        countryOption.click();
        // Wait for the 'Let's Shop' button to be clickable and then click
        WebElement letsShopButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")));
        letsShopButton.click();

        //Toast Message Handling
        String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(toastMessage);
        Assert.assertEquals(toastMessage, "Please enter your name");
        test.addScreenCaptureFromPath("FillForm");

        extent.flush();

    }
@Test
    public void FillFormPositiveFlow() throws InterruptedException
{
    ExtentTest test =extent.createTest("FillFormPositiveFlow");
        //Create an explicit wait instance with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the name field to be visible and then send keys
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
        nameField.sendKeys("Henry Of Ashford");
        driver.hideKeyboard();
        // Wait for the male radio button to be visible and then click
        WebElement maleRadio = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")")));
        maleRadio.click();
        // Wait for the dropdown to be clickable
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")));
        countryDropdown.click();
        // Scroll and click on Nigeria
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Aruba\"));"));
        WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator
                ("new UiSelector().text(\"Aruba\")")));
        countryOption.click();
        // Wait for the 'Let's Shop' button to be clickable and then click
        WebElement letsShopButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")));
        letsShopButton.click();

        //Toast Message Handling
        Assert.assertTrue( driver.findElements(AppiumBy.xpath("//android.widget.Toast[1]")).size()<1);;
    test.addScreenCaptureFromPath("FillFormPositiveFlow");
        extent.flush();
    }

}













