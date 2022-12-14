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
public class nativeapp2_appium {
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
	
	@Test(enabled=true)
	public void testcase1() throws InterruptedException 
	{
		driver.openNotifications();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Open settings.")).click();
		Thread.sleep(2000);		
        //scroll
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"System\"))").click();
		Thread.sleep(2000);	
		driver.findElementByAndroidUIAutomator("text(\"About emulated device\")").click();
		Thread.sleep(2000);
         //Turning on Developer options
		AndroidElement tap = driver.findElementByAndroidUIAutomator("text(\"Build number\")");
        TouchAction ta = new TouchAction(driver);
		ta.tap(tapOptions().withElement(element(tap))).perform();
		ta.tap(tapOptions().withElement(element(tap))).perform();
		ta.tap(tapOptions().withElement(element(tap))).perform();
		ta.tap(tapOptions().withElement(element(tap))).perform();
		ta.tap(tapOptions().withElement(element(tap))).perform();
		ta.tap(tapOptions().withElement(element(tap))).perform();
		ta.tap(tapOptions().withElement(element(tap))).perform();
        //Turning off Developer options
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("text(\"Developer options\")").click();
		Thread.sleep(4000);
		driver.findElementByAndroidUIAutomator("text(\"ON\")").click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //changing ringtone
		driver.findElementByAndroidUIAutomator("text(\"Sound\")").click();
		Thread.sleep(4000);
		driver.findElementByAndroidUIAutomator("text(\"Phone ringtone\")").click();
		Thread.sleep(4000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add ringtone\"))").click();
		Thread.sleep(4000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElementByAndroidUIAutomator("text(\"CANCEL\")").click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
			
	}    
			
}
