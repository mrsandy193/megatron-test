package com.megatron.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestConfiguration {
	public static WebDriver getDriverInstance()
	{
		String browser = DataHandlers.getDataFromProperties("config", "browser");
		String url = DataHandlers.getDataFromProperties("config", "prod_url");
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "./browser-servers/geckodriver.exe");
			driver = new ChromeDriver();
		}
		else{
			System.err.println("------Provided Browser is not correct. Pleasse check config.properties file-----");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	
	}
}