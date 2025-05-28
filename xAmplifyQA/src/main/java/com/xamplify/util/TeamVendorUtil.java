package com.xamplify.util;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.automation.Instance;


public class TeamVendorUtil {

	static WebDriver driver = Instance.getInstance();
	
	
	public WebElement getElementByXPath(String xpath) {
		return driver.findElement(By.xpath(xpath));
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

	public static void clickElementWithWait(WebDriver driver, String propertyKey, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((propertyKey))));
			element.click();
		} catch (Exception e) {
			System.out.println("Element not found or interaction failed: " + e.getMessage());
		}

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
}






