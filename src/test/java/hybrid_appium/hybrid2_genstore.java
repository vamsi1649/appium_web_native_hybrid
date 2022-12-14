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
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class hybrid2_genstore {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
		DesiredCapabilities dc =  new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
		driver =  new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(enabled=true)
	public void testcase1() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"American Samoa\"))").click();
	    Thread.sleep(3000);
	    
		driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("vamsi");
		Thread.sleep(1500);
		 
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
	
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(4500);
		
        String product=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))").getText();
		
		System.out.println(product);
		
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(1).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
			
        String price=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productPrice")).getText();

        System.out.println(price);
        
		price=price.substring(1);
		
		Double tprice=Double.parseDouble(price);
		System.out.println(tprice);
		Thread.sleep(5000);
		
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		
		driver.findElement(MobileBy.className("android.widget.Button")).click();
			
	}
}
