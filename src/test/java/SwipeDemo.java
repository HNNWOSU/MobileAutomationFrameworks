import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;

public class SwipeDemo
	extends BaseTest

{
	@Test
	public void swipeDemo()
		throws
		URISyntaxException,
		MalformedURLException,
		InterruptedException
	{

		// Find the element with the accessibility ID "Views" and click on it
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget" +
				".ImageView\")" + ".instance(0)")).getAttribute("focusable").equals("true"), true);
		//swipe

// First, find the element that we can swipe on
		WebElement elementToSwipe = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));

		swipeAction( elementToSwipe,"left");

		// After swiping, find and interact with the target element
		WebElement targetElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)"));
		targetElement.isDisplayed();
	}


	}


