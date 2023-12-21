package com.managers;

import org.openqa.selenium.WebDriver;

import com.pageObjects.LoginPage;

public class PageObjectManager 
{
	private WebDriver driver;
	private LoginPage login_pg;

	public PageObjectManager(WebDriver driver) 
	{
		this.driver = driver;
	}

	public LoginPage getLoginPage()
	{
		//		 return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
		if(login_pg == null)
		{
			login_pg = new LoginPage(driver);
			return login_pg;
		}
		else
		{
			return login_pg;
		}

	}
}
