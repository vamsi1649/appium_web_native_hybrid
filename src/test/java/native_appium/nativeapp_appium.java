package native_appium;

import java.net.MalformedURLException;



import java.net.URL;
import static java.time.Duration.ofSeconds;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class nativeapp_appium {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
		DesiredCapabilities dc =  new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		driver =  new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	}
	
	@Test(enabled=false)
	public void testcase1() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(MobileBy.AccessibilityId("Animation")).click();
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(2000);
		//driver.findElements(MobileBy.className("android.widget.TextView")).get(5).click();
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		Thread.sleep(2000);
		//driver.findElement(MobileBy.id("io.appium.android.apis:id/startButton")).click();
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("vamsi");
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("android:id/button2")).click();
		driver.hideKeyboard();
		driver.navigate().back();
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Reversing\")")).click();
	}   
	
	//open notifications
	
	@Test(enabled=false)
	public void testcase2() throws InterruptedException 
	{
		driver.openNotifications();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(2).click();
		Thread.sleep(2000);
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(3).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Battery Saver")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Open settings.")).click();
		Thread.sleep(2000);		
}
	
	//tap and long press (touch actions)
	
	@Test(enabled=false)
	public void testcase3() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(2000);
		
		AndroidElement size = driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		
		System.out.println(size.getSize());
		
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		Thread.sleep(4000);	
		
	                                                                                                          	AndroidElement tp = driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter"));
			
		TouchAction ta = new TouchAction(driver);
		
		ta.tap(tapOptions().withElement(element(tp))).perform();
		Thread.sleep(4000);	
		AndroidElement lp = driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
		
		ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
		
		driver.findElementByAndroidUIAutomator("text(\"Sample action\")").click();

}
	
	//scroll and app switch, back, home
	
	@Test(enabled=false)
	public void scroll() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
		Thread.sleep(4000);	
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}
	
	//swipe actions
	
	@Test(enabled=false)
	public void swipeActions() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		driver.findElement(MobileBy.AccessibilityId("12")).click();
		
		AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("15"));
		AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("5"));
		
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		driver.findElementByAndroidUIAutomator("text(\"AM\")").click();
	
	}
	
	//drag and drop
	
	@Test(enabled=false)
	public void dragAndDrop() throws InterruptedException {
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3330);
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();

		AndroidElement ele1 = driver.findElements(MobileBy.className("android.view.View")).get(0);
		AndroidElement ele2 = driver.findElements(MobileBy.className("android.view.View")).get(1);
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	}
	
	//appswitch
	@Test(enabled=true)
	public void d() throws InterruptedException {
		
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		Thread.sleep(3330);
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		Thread.sleep(5330);
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(555) 521-5554");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("hi hola hello");
		driver.findElement(MobileBy.AccessibilityId("Send")).click();
		Thread.sleep(3330);
		driver.activateApp("com.google.android.apps.messaging");
		AndroidElement rkv = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet"));
		rkv.getText();
        System.out.println(rkv);
	    driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	    Thread.sleep(3330);
	    driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	    Thread.sleep(3330);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
	}

}
