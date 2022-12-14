package hybrid_appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class hybrid4_KhanAcdmy {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
		DesiredCapabilities dc =  new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		driver =  new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
		
	   @Test(priority=0,enabled=true)
	   public void sign_in() throws InterruptedException 
	   {	
			Thread.sleep(5000);
			driver.findElement(MobileBy.xpath("//*[@text='Sign in']")).click();
			Thread.sleep(1500);
			driver.findElement(MobileBy.xpath("//*[@text='Continue with Google']")).click();
			Thread.sleep(1500);
			driver.findElement(MobileBy.xpath("//*[@text='vamsi vasireddy']")).click();
			
		}
		
		
		@Test(priority=1,enabled=true)
		public void language() throws InterruptedException 
		{
			Thread.sleep(3000);
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +".scrollIntoView(new UiSelector().text(\"Select language\"))")).click();
			Thread.sleep(1500);
			driver.findElement(MobileBy.xpath("//*[@text='English (default)']")).click();
			Thread.sleep(1500);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}	
		
		@Test(priority=2,enabled=true)
		public void explore() throws InterruptedException 
		{
			driver.findElement(MobileBy.xpath("//*[@text='Explore']")).click();
			Thread.sleep(1500);
			driver.findElement(MobileBy.xpath("//*[@text='Arts and humanities']")).click();
			Thread.sleep(1500);
			driver.findElement(MobileBy.xpath("//*[@text='US history']")).click();
			Thread.sleep(5000);	
			driver.findElement(MobileBy.xpath("//*[@text='Worlds collide (1491-1607)']")).click();
			//driver.findElement(MobileBy.xpath("//*[@text='Thinking like a historian']")).click();
			Thread.sleep(1500);
			driver.findElement(MobileBy.xpath("(//android.widget.Button[@content-desc=\"Add Bookmark\"])[1]/android.widget.ImageView")).click();
			Thread.sleep(1500);
			driver.findElement(MobileBy.id("android:id/button2")).click();
			//System.out.println(driver.findElement(MobileBy.xpath("//android.widget.toast[1]")).getText());
		}
		
		
		@Test(priority=3,enabled=true)
		public void search() throws InterruptedException 
		{
			Thread.sleep(1500);
			driver.findElement(MobileBy.xpath("//*[@text='Explore']")).click();
			Thread.sleep(1500);
			driver.findElement(MobileBy.xpath("//*[@text='Search']")).sendKeys("arts");
			Thread.sleep(2500);
			String ele = driver.findElement(MobileBy.xpath("//*[@text='Why look at art?']")).getText();
			System.out.println(ele);
			
		}
		@Test(priority=4,enabled=true)
		public void Bookmarks() throws InterruptedException 
		{
			driver.findElement(MobileBy.AccessibilityId("Bookmarks tab")).click();
			driver.findElement(MobileBy.xpath("//*[@text='Home']")).click();
		}
		
		@Test(priority=5,enabled=true)
		public void signout() throws InterruptedException 
		{
		   
			driver.findElements(MobileBy.className("android.widget.ImageView")).get(0).click();
			Thread.sleep(1500);
			AndroidElement signout = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Sign out\"))");
			System.out.println(signout.getText());
			signout.click();
			Thread.sleep(1500);
			driver.findElement(MobileBy.id("android:id/button1")).click();
			Thread.sleep(2500);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
			}
				      
	     
}
