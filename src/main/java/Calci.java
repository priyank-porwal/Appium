import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

public class Calci {
	WebDriver driver;

	@BeforeTest
	public void startUp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testCalc() {

		WebElement five = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
		WebElement nine = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
		WebElement equalto = driver.findElement(By.id("com.android.calculator2:id/eq"));
		WebElement plus = driver.findElement(By.id("com.android.calculator2:id/op_add"));

		five.click();
		plus.click();
		nine.click();
		equalto.click();
		
		int sum = Integer.parseInt(five.getText())+Integer.parseInt(nine.getText());
		
	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}

	/*
	 * 
	 * 
	 * */
}
