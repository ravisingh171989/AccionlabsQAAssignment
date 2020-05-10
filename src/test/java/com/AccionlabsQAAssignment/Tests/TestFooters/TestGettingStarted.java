package com.AccionlabsQAAssignment.Tests.TestFooters;

import org.testng.annotations.Test;

import com.AccionlabsQAAssignment.Pages.Landing.LandingPage;
import com.AccionlabsQAAssignment.Pages.Login.LoginPage;
import com.AccionlabsQAAssignment.Tests.TestBase;

import org.testng.annotations.BeforeTest;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class TestGettingStarted extends TestBase {

	public TestGettingStarted() throws Exception {
		super();
	}
	
	String username = testDataReading.getCellData("Assignment", "Username", 2);
	String password = testDataReading.getCellData("Assignment", "Password", 2);

	@BeforeTest
	public void setUpPage() throws Exception {
		landingPage = new LandingPage(driver);
		isatPrepage = new LoginPage(driver);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test
	@Description("This is coding demonstration test two")
	public void automationAssignmentTwo() {
		landingPage.clickGettingStartedPrep();
		isatPrepage.verifyLoginForException(username, password);
	}
}
