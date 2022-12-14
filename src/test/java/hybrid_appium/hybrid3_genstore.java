package hybrid_appium;

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
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class hybrid3_genstore {
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
		
		//getting count of products and scrolling into specific product and adding to cart
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"))"));
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\").instance(0))"));
		//driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		Thread.sleep(1500);
		
		int count=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/rvProductList")).size();
		for(int i=0;i<count;i++)
		{
			String pr=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productName")).getText();
			System.out.println(pr);
			
			if(pr.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElementsByAndroidUIAutomator("text(\"ADD TO CART\")").get(i).click();
			}
			break;
		}
		
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		String price1 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		price1 = price1.substring(1);
		Double intprice1 = Double.parseDouble(price1);
		System.out.println(intprice1);
		Thread.sleep(3000);
		
		String price2= driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		price2 = price2.substring(1);
		Double intprice2 = Double.parseDouble(price2);
		System.out.println(intprice2);
		Thread.sleep(4000);
		
		TouchAction ta1=new TouchAction(driver);
		ta1.longPress(PointOption.point(769,1386)).moveTo(PointOption.point(769,1169)).release().perform();
		Thread.sleep(4000);
		TouchAction ta2=new TouchAction(driver);
		ta2.longPress(PointOption.point(769,1371)).moveTo(PointOption.point(769,833)).release().perform();
		
		String price3= driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(2).getText();
		price3=price3.substring(1);
		Double intprice3=Double.parseDouble(price3);
		System.out.println(intprice3);
		Thread.sleep(2000);
		
		Double Totalprice=intprice1+intprice2+intprice3;
		System.out.println(Totalprice);
		
		String expprice=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		expprice=expprice.substring(1);
		Double intexpprice=Double.parseDouble(expprice);
		System.out.println(intexpprice);
		
		if(Totalprice.equals(intexpprice)) {
			
			System.out.println("expected price is equal to actual price");
		}
		else
		{
			System.out.print("expected price is not equal to actual price");
		}

		Thread.sleep(2000);
		AndroidElement ele= driver.findElement(MobileBy.id("com.androidsample.generalstore:id/termsButton"));
		TouchAction ta=new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(5))).release().perform();
		Thread.sleep(2000);
		System.out.println(driver.findElement(MobileBy.id("android:id/message")).getText());
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("android:id/button1")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.className("android.widget.Button")).click();
		Thread.sleep(2000);
	}

}





