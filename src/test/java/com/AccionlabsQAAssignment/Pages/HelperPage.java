package com.AccionlabsQAAssignment.Pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/* This is a class which have all helper methods
 * for code reusabilty
*/
public abstract class HelperPage {

	protected static Dimension size;

	protected static WebDriver driver;
	public static WebDriverWait wait;
	
	protected JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public HelperPage(WebDriver driver) throws Exception {
		HelperPage.driver = driver;
		PageFactory.initElements(driver, this); 	
	}

	//This is global method which can be used to takescreen shots within in Project
	public static boolean takeScreenshotAs(final String name) {
		String screenshotDirectory = System.getProperty("appium.screenshots.dir",
				System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}

	//Sleep method to be used Project wide 
	public static void sleep(int sleeptime) {
		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
