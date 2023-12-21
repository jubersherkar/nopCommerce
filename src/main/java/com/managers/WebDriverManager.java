package com.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.enums.DriverType;
import com.enums.EnvironmentType;

public class WebDriverManager 
{
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";

	public WebDriverManager()
	{
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
	public WebDriver getDriver()
	{
		if(driver == null)
		{
			driver = createDriver();
		}
		return driver;
	}
	public WebDriver createDriver()
	{
		switch (environmentType)
		{
		case LOCAL : driver = createLocalDriver();
		break;
		case REMOTE : driver = createRemoteDriver();
		break;
		}
		return driver;
	}
	public WebDriver createLocalDriver()
	{
		switch(driverType)
		{
		case CHROME : 
			System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getChromeDriverPath()); 
			driver = new ChromeDriver();
			break;
		case FIREFOX :
			System.setProperty(FIREFOX_DRIVER_PROPERTY, System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getFirefoxDriverPath());
			driver = new FirefoxDriver();
			break;
		case INTERNETEXPLORER :
			System.setProperty(IE_DRIVER_PROPERTY, System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getIEDriverPath());
			driver = new InternetExplorerDriver();
			break;
		}
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
		{
			driver.manage().window().maximize();
		}
		return driver;
	}
	public WebDriver createRemoteDriver()
	{
		throw new RuntimeException("Remote driver is not yet implemented");
	}
	public void closeDriver()
	{
		driver.close();
		driver.quit();
	}
}
