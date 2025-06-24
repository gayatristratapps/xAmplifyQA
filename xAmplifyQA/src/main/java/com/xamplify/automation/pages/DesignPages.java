package com.xamplify.automation.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.partners;
import com.xamplify.util.XamplifyUtil;

public class DesignPages {
	
	static WebDriver driver = Instance.getInstance();
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	static Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Pages.properties");
	static Actions action = new Actions(driver);

// Open design module and design page
	public static void designDesignPage() throws InterruptedException {
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("Designmodule"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("DesignPages"));
		Thread.sleep(2000);		
	}
	
// Click on Regular tab
	public static void RegularTab() throws InterruptedException {
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("Regular"));
		Thread.sleep(2000);
	}
	
// Create regular/Cobranded page
	public static void createPage() throws InterruptedException {
		Thread.sleep(2000);
		WebElement hoveringregularpage = driver.findElement(By.xpath(properties.getProperty("Templatediv")));
		// Performing the mouse hover action on the target element.
		action.moveToElement(hoveringregularpage).perform();
		XamplifyUtil.callClickEvent(properties.getProperty("creatediv"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Openlinkinnewtab"))));
		XamplifyUtil.callClickEvent(properties.getProperty("Openlinkinnewtab"));
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("savebutton"))));
		XamplifyUtil.callClickEvent(properties.getProperty("savebutton"));
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
	}

// Create regular private page
	public static void regularPrivatePageSaveandClose() throws InterruptedException {

		Thread.sleep(5000);
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("nameoftheregularpage"), "Regularprivatepage", "new");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("saveandclose"));
		Thread.sleep(8000);
		XamplifyUtil.takeScreenshot(driver, "Regular private page");
	}

// Create Regular public page
	public static void regularpublicPageSaveandClose() throws InterruptedException {
		Thread.sleep(3000);
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("nameoftheregularpage"), "Regularpublicpage", "new");
		Thread.sleep(2000);
		XamplifyUtil.selectDropdownByIndex(properties.getProperty("pagetypedropdown"), 1);
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("saveandclose"));
		Thread.sleep(8000);
		XamplifyUtil.takeScreenshot(driver, "Regular public page");
	}
	
// Click on Cobranded tab
	public static void cobrandedTab() throws InterruptedException {
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("cobrandedtab"));
		Thread.sleep(2000);
	}
	
// Create cobranded private  page
	public static void cobrandedprivatepagecreation() throws InterruptedException {
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("nameoftheregularpage"), "cobrandedprivatepage", "new");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("saveandclose"));
		Thread.sleep(6000);
		XamplifyUtil.takeScreenshot(driver, "Cobranded private page");
	}

// Create cobranded public  page
	public static void cobrandedpublicpagecreation() throws InterruptedException {
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("nameoftheregularpage"), "cobrandedpublicpage", "new");
		Thread.sleep(2000);
		XamplifyUtil.selectDropdownByIndex(properties.getProperty("pagetypedropdown"), 1);
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("saveandclose"));
		Thread.sleep(6000);
		XamplifyUtil.takeScreenshot(driver, "Cobranded public page");
	}
	
// Open design module and Manage pages
	public static void designManagePage() throws InterruptedException {
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("Designmodule"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("ManagePages"));
		Thread.sleep(2000);
	}
	
// Select page tab
	public static void PageTab(String selectTab) {
		if(selectTab == "RegularPublic") {
			XamplifyUtil.callClickEvent(properties.getProperty("tabRegularPublic"));
		}
		else if(selectTab == "RegularPrivate") {
			XamplifyUtil.callClickEvent(properties.getProperty("tabRegularPrivate"));
		}
		else if(selectTab == "CoBrandedPublic") {
			XamplifyUtil.callClickEvent(properties.getProperty("tabCoBrandedPublic"));
		}
		else if(selectTab == "CoBrandedPrivate") {
			XamplifyUtil.callClickEvent(properties.getProperty("tabCoBrandedPrivate"));
		}
		else if(selectTab == "All") {
			XamplifyUtil.callClickEvent(properties.getProperty("tabAll"));
		}	
	}

// Copy the page
	public static void copyPage() throws InterruptedException {
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("copypage"));
		Thread.sleep(2000);
//		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("copiedname"), "Copiedregularpublicpage");
		XamplifyUtil.callClickEvent(properties.getProperty("savingcopiedregpublicpage"));
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("okbutton1"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "Copy page");
	}
	
//Edit and update the page
	public static void editpage() throws InterruptedException {
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("Editregpublicpage"));
		Thread.sleep(7000);
		driver.switchTo().frame(0);
		Thread.sleep(4000);
		XamplifyUtil.callClickEvent(properties.getProperty("savebutton"));
		Thread.sleep(8000);
		driver.switchTo().defaultContent();
		XamplifyUtil.callClickEvent(properties.getProperty("editupdateandclose"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "update page");
		Thread.sleep(2000);
	}
	
// Preview the page
	public static void PreviewPage() throws InterruptedException {
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("previewtheregpublicpage"));	
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle
		driver.switchTo().window(tabs.get(1)); // switch to the new tab
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "Preview page");
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));
	}

// Delete the page in manage pages	
	public static void DeletePage() throws InterruptedException {
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("DeletePage"));
		XamplifyUtil.callClickEvent(properties.getProperty("yesDelete"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "Delete page");
		Thread.sleep(2000);
	}
	
// Copy and embedded the page
	public static void CopyAndEmbeddedPage() throws InterruptedException, UnsupportedFlavorException, IOException {
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("CopyOrEmbed"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("embedButton"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "copyEmbedPage");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("copylinkButton"));
		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "copyPageLink");
		Thread.sleep(2000);
        // Get content from system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String copiedText = (String) clipboard.getData(DataFlavor.stringFlavor);
        String originalWindow = driver.getWindowHandle();
		openNewWindow(driver, copiedText);
		Thread.sleep(4000);
		XamplifyUtil.takeScreenshot(driver, "OpenPageURL");
		driver.close();
        driver.switchTo().window(originalWindow);
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("closeCopyOrEmbedPopup"));
		Thread.sleep(2000);
	}

// page analytics
	public static void PageAnalytics() throws InterruptedException {
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("searchSubmit"));
		Thread.sleep(2000);
		String getAnlaytics = driver.findElement(By.xpath("//tr[1]//a[@title='Analytics']")).getText();
        //String numericValue = getAnlaytics.replaceAll("[^0-9]", "");  // Remove any non-digit characters if needed (optional)
        //int analyticsValue = Integer.parseInt(numericValue);
       // System.out.println(analyticsValue + ":" + getAnlaytics);
		System.out.println(getAnlaytics);
		if(getAnlaytics == "0") {
			System.out.println("Zero Analytics for selected page");
		}
		else {
			XamplifyUtil.callClickEvent(properties.getProperty("pageAnalytics"));
			Thread.sleep(2000);
			XamplifyUtil.takeScreenshot(driver, "PageAnalytics");
			XamplifyUtil.callClickEvent(properties.getProperty("managePageBreadcrumb"));
			Thread.sleep(2000);
		}		
	}
	
// move to new Window
	public static void openNewWindow(WebDriver driver, String url) {
	        // This opens a new tab/window
	        ((JavascriptExecutor) driver).executeScript("window.open('" + url + "','_blank');");

	        // Switch to the new tab (the last handle)
	        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(tabs.size() - 1));
	    }
	       
// Sort the pages
	public static void sortAndNoOfRecordPage() throws InterruptedException {
		System.out.println(" ");
		DesignPages.designManagePage();
		XamplifyUtil.selectDropdownByIndex(properties.getProperty("sortPages"), 1);
		Thread.sleep(2000);
		XamplifyUtil.selectDropdownByIndex(properties.getProperty("sortPages"), 2);
		Thread.sleep(2000);
		XamplifyUtil.selectDropdownByIndex(properties.getProperty("sortPages"), 3);
		Thread.sleep(2000);
		XamplifyUtil.selectDropdownByIndex(properties.getProperty("sortPages"), 4);
		Thread.sleep(2000);
		XamplifyUtil.selectDropdownByIndex(properties.getProperty("sortPages"), 5);
		Thread.sleep(2000);
	}
	
// Search the pages
	public static void searchPage() throws InterruptedException {
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(properties.getProperty("pageSearch"), "page");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("searchSubmit"));
		XamplifyUtil.takeScreenshot(driver, "SearchPage");
	}
	
// Page Views
	public static void PageView() throws InterruptedException {
		Thread.sleep(2000);
		XamplifyUtil.hoverAndClick(driver, properties, "viewType", "gridView");
		XamplifyUtil.callClickEvent(properties.getProperty("viewType"));	
		XamplifyUtil.takeScreenshot(driver, "view page");
	}
}
