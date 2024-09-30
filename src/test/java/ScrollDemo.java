import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class ScrollDemo
	extends BaseTest

{
	@Test
	public void scrollDemo()
		throws
		URISyntaxException,
		MalformedURLException,
		InterruptedException
	{

		// Find the element with the accessibility ID "Views" and click on it
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement( AppiumBy.androidUIAutomator( "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))" ) );

//		boolean canScrollMore;
//		do
//		{
//
//            canScrollMore = ( Boolean ) ( ( JavascriptExecutor ) driver ).executeScript( "mobile: scrollGesture",
//					ImmutableMap.of( "left", 100, "top", 100, "width", 200, "height",
//							200, "direction", "down", "percent", 10.0
//					));
//        }while (  canScrollMore );
//		Thread.sleep( 3000 );

	}
	}

