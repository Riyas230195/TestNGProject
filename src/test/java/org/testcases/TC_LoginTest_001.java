package org.testcases;

import java.io.IOException;
import java.time.Duration;

import org.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass1{
	
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL is opened");
		driver.manage().window().maximize();
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.setUserName(userName1);
		logger.info("Entered username");
		
		loginpage.setPassword(password1);
		logger.info("Entered password");
		loginpage.submitButton();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		
		else {
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	
	
	}


	
}
