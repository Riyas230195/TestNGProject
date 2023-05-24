package org.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL= readconfig.getApplicationUrl();
	public String userName1=readconfig.getUserName();
	public String password1=readconfig.getPassWord();
	
	
	public static WebDriver driver;
	static Logger logger = Logger.getLogger(BaseClass1.class);
	
	@org.testng.annotations.BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		//***
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--remote-allow-origins=*");
		//***
		 driver = new ChromeDriver(o);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);

		 PropertyConfigurator.configure("log4j.properties");
	}
	
	@org.testng.annotations.AfterClass
	public void tearDown() {
          //driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File Destination= new File(System.getProperty("user.dir")+"/Screenshots/" + tname +".png");
		FileUtils.copyFile(source, Destination);
		System.out.println("ScreenShot Taken");
		
		
		
         
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
