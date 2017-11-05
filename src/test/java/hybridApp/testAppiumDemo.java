package hybridApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public class testAppiumDemo {
	AndroidDriver driver;
	@BeforeTest
	
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0");
		cap.setCapability("appPackage", "com.example.android.apis");
		cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");
		
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
  @Test
  public void f() throws InterruptedException {
	  WebElement view = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")"));
	  WebElement view1 = driver.findElement(By.id("android:id/text1"));
	  
	  TouchAction tap = new TouchAction(driver);
	  TouchAction tap1 = new TouchAction(driver);
	  tap.tap(view).perform();
//	  System.out.println("Tapped on :" +view.getText());
	  
	  Thread.sleep(5000);
	  
	  tap1.tap(view1).perform();
//	  System.out.println("Tapped on :" +view1.getText());
	  
	  
//	  tap1.press(view).waitAction(Duration.ofSeconds(5)).moveTo(view1).release().perform();
	  
	  ((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK); 
	  ((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.HOME);
	  
  }
}
