package org.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/**
	 * @author Vaijeyanthi S
	 * @CreatedDate 23/04/2023
	 * @see To maintain the resuable methods
	 */
	public static WebDriver driver;

	/**
	 * @see getDriver
	 * @param browserType
	 */
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}
	}

	/**
	 * @see browserLaunch
	 * @param url
	 */
	public static void browserLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	/**
	 * @see implicitWait
	 */
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * @see screenshot
	 * @return byte[]
	 */
	public static byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}

	/**
	 * @see getProjectPath
	 * @return
	 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	/**
	 * @see getPropertyFileValue
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	/**
	 * @see findElementId
	 * @param id
	 * @return WebElement
	 */
	public static WebElement findElementId(String id) {
		WebElement elementId = driver.findElement(By.id(id));
		return elementId;
	}

	/**
	 * @see findElementName
	 * @param name
	 * @return WebElement
	 */
	public static WebElement findElementName(String name) {
		WebElement elementName = driver.findElement(By.name(name));
		return elementName;
	}

	/**
	 * @see findElementClassName
	 * @param className
	 * @return WebElement
	 */
	public static WebElement findElementClassName(String className) {
		WebElement elementClassName = driver.findElement(By.className(className));
		return elementClassName;
	}

	/**
	 * @see findElementTagName
	 * @param tagName
	 * @return WebElement
	 */
	public static WebElement findElementTagName(String tagName) {
		WebElement elementTagName = driver.findElement(By.tagName(tagName));
		return elementTagName;
	}

	/**
	 * @see findElementXpath
	 * @param xpath
	 * @return WebElement
	 */
	public static WebElement findElementXpath(String xpath) {
		WebElement elementXpath = driver.findElement(By.xpath(xpath));
		return elementXpath;
	}

	/**
	 * @see findElementCssSelector
	 * @param cssSelector
	 * @return WebElement
	 */
	public static WebElement findElementCssSelector(String cssSelector) {
		WebElement elementCssSelector = driver.findElement(By.cssSelector(cssSelector));
		return elementCssSelector;
	}

	/**
	 * @see findElementLinkText
	 * @param linkText
	 * @return WebElement
	 */
	public static WebElement findElementLinkText(String linkText) {
		WebElement elementLinkText = driver.findElement(By.linkText(linkText));
		return elementLinkText;
	}

	/**
	 * @see findElementPartialLinkText
	 * @param partialLinkText
	 * @return WebElement
	 */
	public static WebElement findElementPartialLinkText(String partialLinkText) {
		WebElement elementLinkText = driver.findElement(By.linkText(partialLinkText));
		return elementLinkText;
	}

	/**
	 * @see sendValues
	 * @param element
	 * @param data
	 */
	public static void sendValues(WebElement element, String data) {
		element.sendKeys(data);
	}

	/**
	 * @see clickBtn
	 * @param element
	 */
	public static void clickBtn(WebElement element) {
		element.click();
	}

	/**
	 * @see closeBrowser
	 */
	public static void closeBrowser() {
		driver.close();
	}

	/**
	 * @see quitBrowser
	 */
	public static void quitBrowser() {
		driver.quit();
	}

	/**
	 * @see findElementsId
	 * @param id
	 * @return List<WebElement>
	 */
	public static List<WebElement> findElementsId(String id) {
		List<WebElement> elementsId = driver.findElements(By.id(id));
		return elementsId;
	}

	/**
	 * @see findElementsName
	 * @param name
	 * @return List<WebElement>
	 */
	public static List<WebElement> findElementsName(String name) {
		List<WebElement> elementsName = driver.findElements(By.name(name));
		return elementsName;
	}

	/**
	 * @see findElementsClassName
	 * @param className
	 * @return List<WebElement>
	 */
	public static List<WebElement> findElementsClassName(String className) {
		List<WebElement> elementsClassName = driver.findElements(By.className(className));
		return elementsClassName;
	}

	/**
	 * @see findElementsTagName
	 * @param tagName
	 * @return List<WebElement>
	 */
	public static List<WebElement> findElementsTagName(String tagName) {
		List<WebElement> elementsTagName = driver.findElements(By.tagName(tagName));
		return elementsTagName;
	}

	/**
	 * @see findElementsXpath
	 * @param xpath
	 * @return List<WebElement>
	 */
	public static List<WebElement> findElementsXpath(String xpath) {
		List<WebElement> elementsXpath = driver.findElements(By.xpath(xpath));
		return elementsXpath;
	}

	/**
	 * @see findElementsCssSelector
	 * @param cssSelector
	 * @return List<WebElement>
	 */
	public static List<WebElement> findElementsCssSelector(String cssSelector) {
		List<WebElement> elementsCssSelector = driver.findElements(By.cssSelector(cssSelector));
		return elementsCssSelector;
	}

	/**
	 * @see findElementsLinkText
	 * @param linkText
	 * @return List<WebElement>
	 */
	public static List<WebElement> findElementsLinkText(String linkText) {
		List<WebElement> elementsLinkText = driver.findElements(By.linkText(linkText));
		return elementsLinkText;
	}

	/**
	 * @see findElementsPartialLinkText
	 * @param partialLinkText
	 * @return List<WebElement>
	 */
	public static List<WebElement> findElementsPartialLinkText(String partialLinkText) {
		List<WebElement> elementspartialLinkText = driver.findElements(By.linkText(partialLinkText));
		return elementspartialLinkText;
	}

	/**
	 * @see getCurrentURL
	 * @return String
	 */
	public static String getCurrentURL() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * @see getPageSourceText
	 * @return String
	 */
	public static String getPageSourceText() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	/**
	 * @see getTitlePage
	 * @return String
	 */
	public static String getTitlePage() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @see navigateForward
	 */
	public static void navigateForward() {
		driver.navigate().forward();
	}

	/**
	 * @see navigateBack
	 */
	public static void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * @see navigateRefresh
	 */
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	/**
	 * @see navigateToUrl
	 * @param url
	 */
	public static void navigateToUrl(String url) {
		driver.navigate().to(url);
	}

	/**
	 * @see getTextValue
	 * @param element
	 * @return String
	 */
	public static String getTextValue(WebElement element) {
		elementVisibilityOf(element);
		String text = element.getText();
		return text;
	}

	public static void elementVisibilityOf(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * @see getAttributeValue
	 * @param element
	 * @return String
	 */
	public static String getAttributeValue(WebElement element) {
		String text = element.getAttribute("value");
		return text;
	}

	/**
	 * @see clearText
	 * @param element
	 */
	public static void clearText(WebElement element) {
		element.clear();
	}

	/**
	 * @see movetoElementAction
	 * @param element
	 */
	public static void moveToElementAction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * @see dragAndDropAction
	 * @param element1
	 * @param element2
	 */
	public static void dragAndDropAction(WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).perform();
	}

	/**
	 * @see doubleClickAction
	 * @param element
	 */
	public static void doubleClickAction(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * @see contextClickAction
	 * @param element
	 */
	public static void contextClickAction(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isDisplayedElement(WebElement element) {
		boolean isDisplayed = element.isDisplayed();
		return isDisplayed;
	}

	/**
	 * @see isEnabledElement
	 * @param element
	 * @return boolean
	 */
	public static boolean isEnabledElement(WebElement element) {
		boolean isEnabled = element.isEnabled();
		return isEnabled;

	}

	/**
	 * @see isSelectedElement
	 * @param element
	 * @return boolean
	 */
	public static boolean isSelectedElement(WebElement element) {
		boolean isSelected = element.isSelected();
		return isSelected;

	}

	/**
	 * @see jsSetAttributeValue
	 * @param element
	 * @param data
	 */
	public static void jsSetAttributeValue(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	/**
	 * @see jsGetAttributeValue
	 * @param element
	 */
	public static void jsGetAttributeValue(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", element);
	}

	/**
	 * @see jsClickBtn
	 * @param element
	 */
	public static void jsClickBtn(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	/**
	 * @see jsScrollDown
	 * @param element
	 */
	public static void jsScrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * @see jsScrollUp
	 * @param element
	 */
	public static void jsScrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	/**
	 * @see acceptAlert
	 */
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * @see dismissAlert
	 */
	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * @see getTextAlert
	 */
	public static void getTextAlert() {
		driver.switchTo().alert().getText();
	}

	/**
	 * @see sendValuesAlert
	 * @param value
	 */
	public static void sendValuesAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/**
	 * @see takeScreenShot
	 * @param destinationPath
	 * @throws IOException
	 */
	public static void takeScreenShot(String destinationPath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(destinationPath);
		FileUtils.copyFile(source, destination);
	}

	/**
	 * @see selectByVisibletext
	 * @param element
	 * @param text
	 */
	public static void selectbyVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @see selectbyValue
	 * @param element
	 * @param text
	 */
	public static void selectbyValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}

	/**
	 * @see selectbyIndex
	 * @param element
	 * @param index
	 */
	public static void selectbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * @see getbyOptions
	 * @param element
	 * @return String
	 */
	public static String getbyOptions(WebElement element) {
		Select select = new Select(element);
		String text = null;
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			text = options.get(i).getText();
		}
		return text;
	}

	/**
	 * @see getbyAllSelectedOptions
	 * @param element
	 * @return String
	 */
	public static String getbyAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		String text = null;
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			text = allSelectedOptions.get(i).getText();
		}
		return text;
	}

	/**
	 * @see getbyFirstSelectedOption
	 * @param element
	 * @return String
	 */
	public static String getbyFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}

	/**
	 * @see isMultiples
	 * @param element
	 * @return boolean
	 */
	public static boolean isMultiples(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	/**
	 * @see deselectByVisibletext
	 * @param element
	 * @param text
	 */
	public static void deselectbyVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	/**
	 * @see deselectbyValue
	 * @param element
	 * @param text
	 */
	public static void deselectbyValue(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByValue(text);
	}

	/**
	 * @see deselectbyIndex
	 * @param element
	 * @param index
	 */
	public static void deselectbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	/**
	 * @see deSelectAll
	 * @param element
	 */
	public static void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * @see switchToFrame
	 * @param frameValue
	 */
	public static void switchToFrame(WebElement frameValue) {
		driver.switchTo().frame(frameValue);
	}

	/**
	 * @see switchToFrameId
	 * @param id
	 */
	public static void switchToFrameId(WebElement id) {
		driver.switchTo().frame(id);
	}

	/**
	 * @see switchToFrameName
	 * @param name
	 */
	public static void switchToFrameName(WebElement name) {
		driver.switchTo().frame(name);
	}

	/**
	 * @see switchToDefaultContent
	 */
	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * @see switchToWindowId
	 * @param windowsId
	 */
	public static void switchToWindowId(String windowsId) {
		driver.switchTo().window(windowsId);
	}

	/**
	 * @see switchToWindowUrl
	 * @param url
	 */
	public static void switchToWindowUrl(String url) {
		driver.switchTo().window(url);
	}

	/**
	 * @see switchToWindowTitle
	 * @param title
	 */
	public static void switchToWindowTitle(String title) {
		driver.switchTo().window(title);
	}

	/**
	 * @see getwindowHandle
	 * @return String
	 */
	public static String getwindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	/**
	 * @see getwindowHandles
	 * @return Set<String>
	 */
	public static Set<String> getwindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
}
	
	

 
 
 
 
 
		
		
		




