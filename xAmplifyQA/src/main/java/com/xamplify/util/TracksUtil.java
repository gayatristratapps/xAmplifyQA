
package com.xamplify.util;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.automation.Instance;


public class TracksUtil {

	static WebDriver driver = Instance.getInstance();
	// static Properties properties = PropertiesFile
	// .readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\ManageContacts.properties");

	public static final int TWO_SECONDS = 2000;

	public static final int THREE_SECONDS = 3000;

	public static final int ONE_SECOND = 1000;

	public static final int SLEEP_TIME = 1000;

	
	
	public WebElement getElementByXPath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement getElementByClassName(String className) {
		return driver.findElement(By.className(className));
	}

	public WebElement getElementByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}

	public List<WebElement> getElementsByXPath(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	public List<WebElement> getElementsByCss(String cssSelector) {
		return driver.findElements(By.cssSelector(cssSelector));
	}

	public static void clickEvent(String key, WebDriver driver) {
		driver.findElement(By.xpath(key)).click();
	}

	public static void sleep(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	public static void callClickEvent(String propertyKey) {
		driver.findElement(By.xpath(propertyKey)).click();
	}

	public static void sendTextEvent(String propertyKey, String text) {
		driver.findElement(By.xpath(propertyKey)).sendKeys(text);
	}

	public static void sendTextWithTimestamp(String elementId, String baseText) {
		driver.findElement(By.id(elementId)).sendKeys(baseText + System.currentTimeMillis());
	}

	public static void sendTextWithTimestamp(String locator, String baseText, String suffix) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(baseText + System.currentTimeMillis() + suffix);
	}
	
	public static void clickElementWithWait(WebDriver driver, String propertyKey, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((propertyKey))));
			element.click();
		} catch (Exception e) {
			System.out.println("Element not found or interaction failed: " + e.getMessage());
		}
// Partners_Vendoraccount
	}

	public static void scrollInsideElement(WebElement element, int pixels) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += arguments[1];", element, pixels);
	}

	public static void selectDropdownByText(String locator, String visibleText) {
		WebElement dropdownElement = driver.findElement(By.xpath(locator));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}

	public static void selectDropdownByValue(String locator, String value) {
		WebElement dropdownValue = driver.findElement(By.xpath(locator));
		Select dropdown = new Select(dropdownValue);
		dropdown.selectByValue(value);
	}

	public static void selectDropdownByIndex(String locator, int index) {
		WebElement dropdownIndex = driver.findElement(By.xpath(locator));
		Select dropdown = new Select(dropdownIndex);
		dropdown.selectByIndex(index);
	}

	public static final String SCREENSHOT_PATH = "D:/git/xAmplifyQA/xAmplifyQA/test-output/screenshots/";

	public static void takeScreenshot(WebDriver driver, String screenshotName) {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = SCREENSHOT_PATH + screenshotName + "_" + timestamp + ".png";

		// Take the screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);

		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Error while saving screenshot: " + e.getMessage());
		}
	}

	public static void waitAndClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, (10)); // Wait for up to 10 seconds
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	// Method to wait until an element is visible
	public static WebElement waitForElementVisibility(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void selectDropdownWithWait(WebDriver driver, String locator, int index) {
		WebDriverWait wait = new WebDriverWait(driver, (30));

		// Wait until the dropdown is visible and clickable
		WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

		// Create Select object and select by index
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByIndex(index);

		// Wait briefly to observe the selection (Optional)
		try {
			Thread.sleep(1000); // 1-second pause to see the data change (not recommended for production)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


public static void scrolldown() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");

}
	public static void sendKeyEvent(String locator, Keys key) {
		driver.findElement(By.xpath(locator)).sendKeys(key);
	}

	public static void scrollInsideElement1(WebElement element, int pixels) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += arguments[1];", element, pixels);
	}
	
	
public static void imageupload() throws AWTException, InterruptedException {
	
	Robot robot = new Robot(); // use robot class to upload file -- create object
	StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\jpg_file.jpg");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
	// create a string selection object copy above path to clipboard // clipboard

	Thread.sleep(2000);
	robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
	robot.keyPress(KeyEvent.VK_V); // press V
	robot.keyRelease(KeyEvent.VK_V); // release V
	robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
	robot.keyPress(KeyEvent.VK_ENTER);// press enter
	robot.keyRelease(KeyEvent.VK_ENTER); // release enter
}
	
	
	

public void enterEmail(String locator, Keys key) {
    driver.findElement(By.xpath(locator)).sendKeys(key);
}

public void selectanswer(String locator) {
    driver.findElement(By.xpath(locator)).click();
}

public void submitForm(String locator) {
    driver.findElement(By.xpath(locator)).click();
}
	

	

}



