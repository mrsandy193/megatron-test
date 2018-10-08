package com.megatron.test.regression;

import org.testng.annotations.Test;
import com.megatron.lib.ui.LoginPage;
import com.megatron.lib.utils.DataHandlers;
import com.megatron.lib.utils.TestConfiguration;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestLoginU13856 {
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	  public void preCondition() {
		driver = TestConfiguration.getDriverInstance();
		login = new LoginPage(driver);
	  }
	@Test
	public void TC156786_testInvalidLogin() {
		login.waitForLoginPageToLoad();
		
		String userName = DataHandlers.getDataFromExcel("tdata", "TC156786", 1, 0);
		
		String pwd = DataHandlers.getDataFromExcel("tdata", "TC156786", 1, 1);
		login.getUserNameTextbox().sendKeys(userName);
		login.getPasswordTextbox().sendKeys(pwd);
		login.getLoginButton().click();
		
		String actualErrMsg = login.getInvalidLoginErrMsg().getText();
		String expectedErrMsg = DataHandlers.getDataFromExcel("tdata", "TC156786", 1, 2);
		
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}
  

	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}