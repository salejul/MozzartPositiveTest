package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseClass {
	
	// WebDriver driver;
	// AndroidDriver driver;
	protected AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setUp() throws Exception {
		

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "HUAWEI P9 lite 2017");
		caps.setCapability("udid", "9DC7N17711004538");
		caps.setCapability("platformName", "Android");
		caps.setCapability("app", "https://static.mozzartbet.com/android/sr/beta/Mozzart-beta.apk");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("appWaitPackage", "com.mozzartbet.beta");
		caps.setCapability("appWaitActivity", "com.mozzartbet.ui.acivities.HomeScreenActivity");
		caps.setCapability("appWaitDuration", 20000);
		caps.setCapability("noReset", "true");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver<MobileElement>(url, caps);

		
	}
	
	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
	
	
}
