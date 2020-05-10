package com.AccionlabsQAAssignment.Tests.TestFooters;

import org.testng.annotations.Test;

import com.AccionlabsQAAssignment.Pages.Landing.LandingPage;
import com.AccionlabsQAAssignment.Tests.TestBase;

import org.testng.annotations.BeforeTest;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class TestContactAndSupport extends TestBase {

	public TestContactAndSupport() throws Exception {
		super();
	}

	@BeforeTest
	public void setUpPage() throws Exception {
		landingPage = new LandingPage(driver);
	}

	/* This is a assginment test to add a 
	*  essential item to cart
	*/
	@Severity(SeverityLevel.CRITICAL)
	@Test
	@Description("This is coding demonstration test")
	public void automationAssignment() {
		landingPage.clickingContactAndSupport();
		landingPage.verifyContactSupportTitle();
		landingPage.verifyTechnicalSupportButton();
	}
}
