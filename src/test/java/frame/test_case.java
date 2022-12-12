package frame;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class test_case extends capabilities {
	
	  @BeforeTest
	    public void KillAllProcesses() throws IOException, InterruptedException {
	        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	        Thread.sleep(8000);
	        Runtime.getRuntime().exec(System.getProperty("user.dir")+"//vt.bat");
	    	Thread.sleep(60000);
	}
	
	@Test
	public void tc1() throws IOException, InterruptedException {
		
		service = startServer();
		
		AndroidDriver<AndroidElement> driver = hybrid_capabilities(appActivity, appPackage, deviceName, chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
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
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		service.stop();
	}


	}
	

