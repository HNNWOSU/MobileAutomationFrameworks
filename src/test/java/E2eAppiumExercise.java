import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertListContains;

public class E2eAppiumExercise
	extends BaseTest {
	@Test
	public void E2eExercise()
			throws
			URISyntaxException,
			MalformedURLException,
			InterruptedException {

		// Find the element with the accessibility ID "Views" and click on it
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Alert Dialogs\")")).click();

		//clicking on the button Text Entry
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/text_entry_button\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android" +
				".apis:id/username_edit\")")).sendKeys("Henry Hill");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android" +
				".apis:id/password_edit\")")).sendKeys("123456789");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();


	}

	@Test
	public void E2eExercise1() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Alert Dialogs\")")).click();

		//clicking on the button 1st Assertion
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons")).click();
		String targetElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId" +
				"(\"android:id/alertTitle\")")).getText();

		//Assertions
		Assert.assertEquals(targetElement, "Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop.");
	}

	@Test
	public void E2eExercise2() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Alert Dialogs\")")).click();

		//clicking on the button 2nd Assertion
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/select_button\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Command one\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/message\")")).click();
		String listElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/message\")")).getText();

		//Assertions
		Assert.assertEquals(listElement, "You selected: 0 , Command one");

	}

	@Test
	public void E2eExercise3() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Alert Dialogs\")")).click();

		//Radio Button
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/radio_button\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Traffic\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();


	}

	@Test
	public void E2eExercise4() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Alert Dialogs\")")).click();

		//Checkbox
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/checkbox_button\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Monday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Tuesday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Wednesday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Thursday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Friday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Saturday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Sunday\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();
	}

	@Test
	public void E2eExercise5() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Alert Dialogs\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/two_buttons2ultra\")")).click();
		String longElement =driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId" +
				"(\"android:id/message\")")).getText();
		assertEquals(longElement, "Plloaso mako nuto siwuf cakso dodtos anr koop a cupy uf cak vux noaw yerw phuno. Whag schengos, uf efed, quiel " +
				"ba mada su otrenzr.\n\nSwipontgwook proudgs hus yag su ba dagarmidad. Plasa maku noga wipont trenzsa schengos ent kaap zux comy.\n\nWipont " +
				"trenz kipg naar mixent phona. Cak pwico siructiun ruous nust apoply tyu cak Uhex sisulutiun munityuw uw dseg\n\n Plloaso mako nuto siwuf cakso " +
				"dodtos anr koop a cupy uf cak vux noaw yerw phuno. Whag schengos, uf efed, quiel ba mada su otrenzr.\n\nSwipontgwook proudgs hus yag su ba dagarmidad. " +
				"Plasa maku noga wipont trenzsa schengos ent kaap zux comy.\n\nWipont trenz kipg naar mixent phona. Cak pwico siructiun ruous nust apoply tyu cak Uhex " +
				"sisulutiun munityuw uw dseg\n\n Plloaso mako nuto siwuf cakso dodtos anr koop a cupy uf cak vux noaw yerw phuno. Whag schengos, uf efed, quiel ba mada su " +
				"otrenzr.\n\nSwipontgwook proudgs hus yag su ba dagarmidad. Plasa maku noga wipont trenzsa schengos ent kaap zux comy.\n\nWipont trenz kipg naar mixent phona. " +
				"Cak pwico siructiun ruous nust apoply tyu cak Uhex sisulutiun munityuw uw dseg\n\n Plloaso mako nuto siwuf cakso dodtos anr koop a cupy uf cak vux noaw yerw phuno. " +
				"Whag schengos, uf efed, quiel ba mada su otrenzr.\n\nSwipontgwook proudgs hus yag su ba dagarmidad. Plasa maku noga wipont trenzsa schengos ent kaap zux comy." +
				"\n\nWipont trenz kipg naar mixent phona. Cak pwico siructiun ruous nust apoply tyu cak Uhex sisulutiun munityuw uw dseg\n\n Plloaso mako nuto siwuf cakso dodtos " +
				"anr koop a cupy uf cak vux noaw yerw phuno. Whag schengos, uf efed, quiel ba mada su otrenzr.\n\nSwipontgwook proudgs hus yag su ba dagarmidad. Plasa maku noga wipont " +
				"trenzsa schengos ent kaap zux comy.\n\nWipont trenz kipg naar mixent phona. Cak pwico siructiun ruous nust apoply tyu cak Uhex sisulutiun munityuw uw dseg\n\n Plloaso " +
				"mako nuto siwuf cakso dodtos anr koop a cupy uf cak vux noaw yerw phuno. Whag schengos, uf efed, quiel ba mada su otrenzr.\n\nSwipontgwook proudgs hus yag su ba dagarmidad. " +
				"Plasa maku noga wipont trenzsa schengos ent kaap zux comy.\n\nWipont trenz kipg naar mixent phona. Cak pwico siructiun ruous nust apoply tyu cak Uhex sisulutiun munityuw uw dseg\n\n");

		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();
	}

}
