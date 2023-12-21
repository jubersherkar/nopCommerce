package com.stepDefinitions;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.TestContext;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks 
{
	TestContext testContext;
	public Hooks(TestContext context)
	{
		this.testContext = context;
	}
	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		Reporter.assignAuthor("Parasad More");
	}
	@After(order = 1)
	public void afterScenario(Scenario scenario) throws Exception
	{
		if(scenario.isFailed())
		{
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			try
			{
				File sourcePath = ((TakesScreenshot)testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/screenshots/" + screenShotName + ".png");
				Files.copy(sourcePath, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());	
			}
			catch(IOException e)
			{
				
			}
		}
	}
	@After(order = 0)
	public void afterSteps()
	{
		testContext.getWebDriverManager().closeDriver();
	}
}
