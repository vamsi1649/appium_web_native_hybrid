package hybrid_appium;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class hybrid1_genstore {
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
		Thread.sleep(1500);
		//toast message
		//System.out.println(driver.findElement(MobileBy.xpath("//android.widget.toast[1]")).getText());
		
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(1500);
		
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(1500);
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		
		String price1 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		price1 = price1.substring(1);
		
		Double firstproduct = Double.parseDouble(price1);
		System.out.println(firstproduct);
		
		String price2 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		price2 = price2.substring(1);
		
		Double secondproduct = Double.parseDouble(price2);
		System.out.println(secondproduct);
		
		Double totalprice = firstproduct + secondproduct;
		System.out.println(totalprice);
		
        String actualprice=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		actualprice=actualprice.substring(1);
		
		double actualprice1=Double.parseDouble(actualprice);
		
		System.out.println(actualprice1);
		
		if(totalprice.equals(actualprice1))
		{
			
			System.out.println("expected price is equal to actual price");
		}
		else
		{
			
			System.out.print("expected price is not equal to actual price");
		}

		Thread.sleep(6000);
		
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		driver.findElement(MobileBy.className("android.widget.Button")).click();
		
}
	
}