package com.stepDefinitions;

import com.cucumber.TestContext;
import com.managers.FileReaderManager;
import cucumber.api.java.en.*;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Demo 
{	
	TestContext testContext;
	
	public Demo(TestContext context)
	{
		this.testContext = context;
	}
	
	@Given("^User opens browser$")
	public void user_opens_browser()
	{
		testContext.getWebDriverManager().getDriver();
	}

	@When("^User enters URL$")
	public void user_enters_URL() 
	{
		testContext.getWebDriverManager().getDriver().get(FileReaderManager.getInstance().getConfigReader().getBaseUrl());
	}

	@Then("^User should be able to see title as \"([^\"]*)\"$")
	public void user_should_be_able_to_see_title_as(String expectedtTitle) 
	{
		String actualTitle = testContext.getWebDriverManager().getDriver().getTitle();
		Assert.assertEquals(expectedtTitle, actualTitle);
	}
}
