package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.managers.FileReaderManager;

public class LoginPage
{
	public WebDriver driver;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txt_userId;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txt_password;

	@FindBy(xpath= "//button[normalize-space()='Log in']")
	WebElement btn_submit;

	@FindBy(xpath = "//div[contains(text(),'Login was unsuccessful. Please correct the errors ')]")
	WebElement lbl_loginFailure;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterUrl()
	{
		driver.get(FileReaderManager.getInstance().getConfigReader().getBaseUrl());
	}
	public void enterUsername(String username)
	{
		txt_userId.clear();
		txt_userId.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		txt_password.clear();
		txt_password.sendKeys(password);
	}
	public void clickLogin()
	{
		btn_submit.click();
	}

	public WebElement loginUnsuccessful()
	{
		return lbl_loginFailure;
	}
}
