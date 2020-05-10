package com.AccionlabsQAAssignment.Pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.AccionlabsQAAssignment.Pages.HelperPage;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends HelperPage {

	@FindBy(id = "logonIdentifier")
	protected WebElement usernameVerify;
	
	@FindBy(id = "password")
	protected WebElement passwordVerify;
	
	@FindBy(id = "next")
	protected WebElement nextVerify;
	
	@FindBy(xpath = "//div[contains(@class,'localAccount')]/div/p[@role='alert']")
	protected WebElement errorMessage;
	
	public LoginPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	@Step("Enetr Invalid username and password")
	public void verifyLoginForException(String Username, String Password) {
		usernameVerify.sendKeys(Username);
		passwordVerify.sendKeys(Password);
		nextVerify.click();
	}
}
