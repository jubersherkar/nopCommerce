package com.cucumber;

import com.managers.PageObjectManager;
import com.managers.WebDriverManager;

public class TestContext 
{
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;

	public TestContext()
	{
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}

	public WebDriverManager getWebDriverManager()
	{
		return webDriverManager;
	}
	public PageObjectManager getPageObjectManager()
	{
		return pageObjectManager;
	}
}
