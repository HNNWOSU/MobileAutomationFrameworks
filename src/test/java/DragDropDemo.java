import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class DragDropDemo
	extends BaseTest

{
	@Test
	public void dragDropTest()
		throws
		URISyntaxException,
		MalformedURLException,
		InterruptedException
	{

		// Find the element with the accessibility ID "Views" and click on it
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Drag and Drop\")")).click();
		WebElement source =driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) source).getId(),
				"endX", 712,
				"endY", 586
		));
		Thread.sleep(3000);
		String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");

	}


	}


