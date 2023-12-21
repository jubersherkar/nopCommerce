package com.stepDefinitions;

import org.junit.Assert;
import com.cucumber.TestContext;
import com.cucumber.listener.Reporter;
import com.pageObjects.*;
import cucumber.api.java.en.*;
public class LoginSteps 
{
	TestContext testContext;
	LoginPage loginPage;
	
	public LoginSteps(TestContext context)
	{
		this.testContext =  context;
		loginPage =testContext.getPageObjectManager().getLoginPage();
	}
	@Given("^User launch the browser$")
	public void user_launch_the_browser() 
	{ 
		testContext.getWebDriverManager().getDriver();
		Reporter.addStepLog("Browser launched");
	}

	@When("^User opens base url$")
	public void user_opens_base_url() 
	{
		loginPage.enterUrl();
		Reporter.addStepLog("Url entered");
	}

	@When("^User enteres user id as \"([^\"]*)\"$")
	public void user_enteres_user_id_as(String uName) 
	{
		loginPage.enterUsername(uName);
		Reporter.addStepLog("Username entered");
	}

	@When("^User enteres Password as \"([^\"]*)\"$")
	public void user_enteres_Password_as(String password) 
	{
	  loginPage.enterPassword(password);
	  Reporter.addStepLog("Password entered");
	}

	@When("^Click on login$")
	public void click_on_login() 
	{
		loginPage.clickLogin();
		Reporter.addStepLog("Clicked login button");
	}

	@Then("^User should be able to see dashboard$")
	public void user_should_be_able_to_see_dashboard()
	{
		String expectedPageSource = testContext.getWebDriverManager().getDriver().getPageSource();
		Assert.assertEquals(true,expectedPageSource.contains("Dashboard"));
		Reporter.addStepLog("Validated dashboard");
	}
	@Then("^Error messege should be displayed as \"([^\"]*)\"$")
	public void error_messege_should_be_displayed_as(String errorMsg) 
	{
		Assert.assertEquals(errorMsg, loginPage.loginUnsuccessful().getText());
		Reporter.addStepLog("validated error messege");
	}
	
}
