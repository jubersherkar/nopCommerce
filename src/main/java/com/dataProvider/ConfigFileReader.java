package com.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.enums.DriverType;
import com.enums.EnvironmentType;

public class ConfigFileReader 
{
	private Properties prop;
	private final String propertyFilePath = "Config//configuration.properties";

	public ConfigFileReader()
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			prop = new Properties();
			try {
				prop.load(reader);
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties file not found at " + propertyFilePath);
		} 
	}
	public String getReportConfigPath()
	{
		String configPath = prop.getProperty("Report_Config_Path");
		if(configPath != null)
		{
			return configPath;
		}
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}
	public String getChromeDriverPath()
	{
		String chromeDriverPath = prop.getProperty("Chrome_Driver_Path");
		if(chromeDriverPath != null)
			return chromeDriverPath;
		else
			throw new RuntimeException("Chrome driver path not found in the configuration file");
	}
	public String getFirefoxDriverPath()
	{
		String firefoxDriverPath = prop.getProperty("Firefox_Driver_Path");
		if(firefoxDriverPath != null)
			return firefoxDriverPath;
		else
			throw new RuntimeException("Firefox driver path not found in the configuration file");
	}
	public String getIEDriverPath()
	{
		String iEDriverPath = prop.getProperty("Internet_Explorer_Driver_Path");
		if(iEDriverPath != null)
			return iEDriverPath;
		else
			throw new RuntimeException("IE driver path not found in the configuration file");
	}
	public int getWaitTime()
	{
		String waitTime = prop.getProperty("Implicit_Wait");
		if(waitTime != null)
		{
			try
			{
				return Integer.parseInt(waitTime);
			}
			catch(NumberFormatException e)
			{
				throw new RuntimeException("Time for inplicit wait is not provided in configuration file");
			}
		}
		return 30;

	}
	public String getBaseUrl()
	{
		String baseUrl = prop.getProperty("Base_Url");
		if(baseUrl != null)
		{
			return baseUrl;
		}
		else
			throw new RuntimeException("Base Url not found in the configuration file");
	}
	public DriverType getBrowser()
	{
		String browserName = prop.getProperty("Browser");
		if(browserName == null || browserName.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if(browserName.equalsIgnoreCase("Internet explorer") || browserName.equalsIgnoreCase("IE"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched");

	}
	public EnvironmentType getEnvironment() 
	{
		String environmentName = prop.getProperty("Environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) 
			return EnvironmentType.LOCAL;
		else if(environmentName.equalsIgnoreCase("remote")) 
			return EnvironmentType.REMOTE;
		else 
			throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}
	public boolean getBrowserWindowSize()
	{
		String windowSize = prop.getProperty("Window_Maximize");
		if(windowSize != null)
			return Boolean.valueOf(windowSize);
		else
			return true;
	}
}
