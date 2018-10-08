package com.megatron.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForLoginPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("whiteBoxWithLogoBody"))));
	}
	
	public WebElement getUserNameTextbox()
	{
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("pwd"));
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(By.id("loginButton"));
	}
	
	public WebElement getInvalidLoginErrMsg()
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Username or Password is')]"));
	}
}
