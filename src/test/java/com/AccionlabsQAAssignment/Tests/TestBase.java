package com.AccionlabsQAAssignment.Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import ru.yandex.qatools.allure.annotations.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import com.AccionlabsQAAssignment.Pages.TestDataReading;
import com.AccionlabsQAAssignment.Pages.Landing.LandingPage;
import com.AccionlabsQAAssignment.Pages.Login.LoginPage;
import com.AccionlabsQAAssignment.platform.Android;
import com.AccionlabsQAAssignment.platform.IOS;
import com.google.inject.internal.util.ImmutableMap;

public abstract class TestBase {

	private final static String URL_STRING = "http://127.0.0.1:4723/wd/hub";

	public static WebDriver driver;

	public static final String File_TestData = "AccionlabsQAAssignment.xlsx";
	
	protected TestDataReading testDataReading = new TestDataReading(File_TestData);

	public TestBase() throws Exception {
	
	}
	
	protected LandingPage landingPage;
	protected LoginPage isatPrepage;

	@BeforeTest
	public abstract void setUpPage() throws Exception;

	/* This is to select which Platform against this testcase
	 * is going to run.
	 */
	@Parameters("platform")
	@BeforeTest
	public static void initAppium(String platform) throws MalformedURLException {

		URL url = new URL(URL_STRING);
		
		if(platform.equalsIgnoreCase("Android")) {
			DesiredCapabilities capabilitiesAndroid = new DesiredCapabilities();
			capabilitiesAndroid.setCapability(MobileCapabilityType.PLATFORM_NAME, Android.platformName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.PLATFORM_VERSION, Android.platformVersion);
			capabilitiesAndroid.setCapability(MobileCapabilityType.AUTOMATION_NAME, Android.automationName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.BROWSER_NAME, Android.browserNameChrome);
			capabilitiesAndroid.setCapability(MobileCapabilityType.DEVICE_NAME, Android.deviceName);
			capabilitiesAndroid.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			capabilitiesAndroid.setCapability("appActivity", Android.appActivity);

			driver = new AppiumDriver<WebElement>(url, capabilitiesAndroid);
			driver.get("http://familiar.lsac.org/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if(platform.equalsIgnoreCase("iOS")) {
			DesiredCapabilities capabilitiesIOS = new DesiredCapabilities();
			capabilitiesIOS.setCapability(MobileCapabilityType.PLATFORM_NAME, IOS.platformName);
			capabilitiesIOS.setCapability(MobileCapabilityType.PLATFORM_VERSION, IOS.platformVersion);
			capabilitiesIOS.setCapability(MobileCapabilityType.AUTOMATION_NAME, IOS.automationName);
			capabilitiesIOS.setCapability(MobileCapabilityType.BROWSER_NAME, IOS.browserNameSafari);
			capabilitiesIOS.setCapability(MobileCapabilityType.DEVICE_NAME, IOS.deviceName);
			
			driver = new AppiumDriver<WebElement>(url, capabilitiesIOS);
			driver.get("http://familiar.lsac.org/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if(platform.equalsIgnoreCase("Chrome")) {
	        driver = new ChromeDriver();
	        driver.get("http://familiar.lsac.org/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if(platform.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
	        driver.get("http://familiar.lsac.org/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

	@Step("Closing the test")
	@AfterSuite
	public void tearDownAppium() {
		if (driver != null) {
			driver.quit();
		}
	}
}