package com.xamplify.util;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Robot;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;



public class DamUtil {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private Actions action;

    public DamUtil(WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, 120);
        this.action = new Actions(driver);
    }

    public void hover(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        action.moveToElement(element).build().perform();
    }

    public static void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void verifyText(By locator, String expectedText) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String actualText = element.getText().trim();
        org.testng.Assert.assertEquals(actualText, expectedText, "Text does not match!");
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static void sendText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //element.clear();
        element.sendKeys(text);
    }
       
	public static void callClickEvent(String propertyKey) {
		driver.findElement(By.xpath(propertyKey)).click();
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

	
	public static void clickElementWithWait(WebDriver driver, String propertyKey, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((propertyKey))));
			element.click();
		} catch (Exception e) {
			System.out.println("Element not found or interaction failed: " + e.getMessage());
		}
	}

    public void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
	public static void selectDropdownByText(String locator, String visibleText) {
		WebElement dropdownElement = driver.findElement(By.xpath(locator));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}
	
	
	public static void imageupload(String filepath) throws AWTException, InterruptedException {
		
		Robot robot = new Robot(); // use robot class to upload file -- create object
		StringSelection filepath1 = new StringSelection(filepath);
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
		
    public boolean isElementVisible(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText().trim();
    }
}
