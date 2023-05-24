package org.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	 public LoginPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		
	}
	
	@CacheLookup
	@FindBy(name = "uid")
	WebElement txtUserName;
	
	@CacheLookup
	@FindBy(name="password")
	WebElement txtPassword;
	
	@CacheLookup
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	
	@CacheLookup
	@FindBy(xpath="//a[text()='Log out']")
	WebElement LogoutBtn;
	
	
	public void setUserName(String userName1) {
		txtUserName.sendKeys(userName1);	
	}
	
	public void setPassword(String password1) {
		txtPassword.sendKeys(password1);	
	}
	public void submitButton() {
     btnLogin.click();
	}
	
	public void logOutButton() {
		LogoutBtn.click();
	}
	
	
	
	
	
	
	
	

}
