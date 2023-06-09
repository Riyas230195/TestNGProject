package org.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter reporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@Override
	public void onStart(ITestContext testContext) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-" +timestamp+".html";
		
		
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportName);
		
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Abi");
		
		reporter.config().setDocumentTitle("DEMO GURU 99 Project");
		reporter.config().setReportName("Functional Testing");
		reporter.config().setTheme(Theme.DARK);
		
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		
		File file = new File(screenshotPath);
		
		if (file.exists()) {
			
			try {
				logger.pass("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenshotPath));
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		}
		
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		
		File file = new File(screenshotPath);
		
		if (file.exists()) {
			
			try {
				logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenshotPath));
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	
	
	
}
