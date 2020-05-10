package com.AccionlabsQAAssignment.Pages.Landing;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.AccionlabsQAAssignment.Pages.HelperPage;
import ru.yandex.qatools.allure.annotations.Step;

public class LandingPage extends HelperPage {
	
	@FindBy(id = "CybotCookiebotDialogBodyLevelButtonAcceptWrapper")
	protected WebElement okButton;
	
	@FindBy(xpath  = "//div[contains(@class,'field field-body')]/p/a[contains(@class,'contact-support')]")
	protected WebElement contactAndSupport;
	
	@FindBy(xpath = "//div[contains(@class,'paragraph-link-image__caption-title-wrapper')]/span")
	protected WebElement technicalSupportButton;
	
	@FindBy(xpath  = "//button[contains(@class,'js-accordion__header')]")
	protected WebElement firstOptionTechnicalSupport;
	
	@FindBy(xpath  = "//div[contains(@class,'banner-text')]/div[contains(@class,'responsive-text-center')]/a")
	protected WebElement GettingStartedPrepButton;

	public LandingPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	@Step("Click on Getting Started button to navigate to Login Page")
	public void clickGettingStartedPrep() {
		okButton.click();
		try {
			js.executeScript("arguments[0].scrollIntoView();", GettingStartedPrepButton);
		} catch (Exception e) {
		}
		GettingStartedPrepButton.sendKeys(Keys.ENTER);
	}
	
	@Step("Click on Contact and Support")
	public void clickingContactAndSupport() {
		okButton.click();
		try {
			js.executeScript("arguments[0].scrollIntoView();", contactAndSupport);
		} catch (Exception e) {
		}
		contactAndSupport.sendKeys(Keys.ENTER);
		takeScreenshotAs("login2");
	}
	
	@Step("Verify Contact Support page title")
	public void verifyContactSupportTitle() {
		try {
			HelperPage.sleep(10);
			String title = js.executeScript("return document.title").toString();
			Assert.assertEquals(title, "Contact & Support | The Law School Admission Council");
		} catch (Exception e) {
		}
		takeScreenshotAs("login2");
	}
	
	@Step("Click on Technical Support Button")
	public void verifyTechnicalSupportButton() {
		try {
			js.executeScript("arguments[0].scrollIntoView();", technicalSupportButton);
			technicalSupportButton.click();
			js.executeScript("arguments[0].scrollIntoView();", firstOptionTechnicalSupport);
			String buttonName = firstOptionTechnicalSupport.getText();
			Assert.assertEquals(buttonName, "I cannot remember my username and/or password.");
		} catch (Exception e) {
		}
		takeScreenshotAs("login2");
	}
}
