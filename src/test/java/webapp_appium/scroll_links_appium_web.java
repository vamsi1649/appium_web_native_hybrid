package webapp_appium;

import java.net.MalformedURLException;


import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class scroll_links_appium_web{
	
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
		DesiredCapabilities dc =  new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C://Users//LENOVO//Documents//workspace-spring-tool-suite-4-4.16.0.RELEASE//appium_vamsi//chromedriver.exe");
		//dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		driver =  new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	}
	
	@Test
	public void testcase() 
	{
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("moolyaed");
		Actions ele = new Actions(driver);
		ele.sendKeys(Keys.ENTER).build().perform();
		
		List<AndroidElement> li = driver.findElements(By.tagName("a"));
        System.out.println("total links "+ li.size());
         for (int i=0; i<li.size(); i++)
        {
			System.out.println(li.get(i).getText());
	       
        }
         
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'MoolyaEd - LinkedIn')]"));
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		//js.executeScript("document.getElementsByClassName('oewGkc LeUQr MUxGbd v0nnCb')[1].scrollIntoView();");
     	//js.executeScript("document.getElementsByClassName('oewGkc LeUQr MUxGbd v0nnCb')[1].click();");
		System.out.println(driver.getTitle());
	}

}








