package com.megatron.test.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.megatron.lib.utils.TestConfiguration;

public class TestSample {

	WebDriver driver;
	@BeforeMethod
	public void preCondition()
	{
		driver = TestConfiguration.getDriverInstance();
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	@Test
	public void testLoginPageTitle()
	{
		driver.findElement(By.xpath(""));
	}
}
