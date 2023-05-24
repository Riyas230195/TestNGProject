package org.testcases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utility.XLUtility;

public class TC_LoginTest_DDT_002 extends BaseClass1{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String username1, String password1) throws InterruptedException, IOException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username1);
		logger.info("username entered");
		loginPage.setPassword(password1);
		logger.info("password entered");
		loginPage.submitButton();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			
			captureScreen(driver, "loginddt");
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			loginPage.logOutButton();
			
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
			
		} catch (NoAlertPresentException e) {
			
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/org/testdata/LoginData.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1",1);
		
		String LoginData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				LoginData[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return LoginData;
	}
	

//	@DataProvider(name="UserNames")
//	public String[] getUserNames() throws IOException
//	{
//		String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";
//		XLUtility xl=new XLUtility(path);
//		
//		int rownum=xl.getRowCount("Sheet1");
//		
//		String apidata[]=new String[rownum];
//		for(int i=1;i<=rownum;i++)
//		{
//			apidata[i-1]=xl.getCellData("Sheet1", i, 1);
//		}
//
//		return apidata;
//
//	}

}
