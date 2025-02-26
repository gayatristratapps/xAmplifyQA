package com.xamplify.automation;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import com.xamplify.util.XamplifyUtil;
import com.xamplifycon.util.XamplifyUtil_contacts;

public class Shareleads {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Shareleads.properties");
	final Logger logger = LogManager.getLogger(Shareleads.class);

	public void hoverOnShareLeads() throws InterruptedException {

		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "add_shareleads");
		// Step 1: Contact List Creation
		XamplifyUtil.sendTextWithTimestamp("contactListName", "AutoSlist");
	}

	public void manageHoverShareLeads() throws InterruptedException {

		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "manage_shareleads");

	}

	@Test(priority = 1, enabled = false)
	public void shareLeadsOneAtATime() throws InterruptedException {

		hoverOnShareLeads();

		logger.debug("Starting creating partner using One at a time");

		// Click on 'One at a Time' option
		XamplifyUtil.callClickEvent(properties.getProperty("sh_oneattime"));

		// Step 2: Enter Personal Details
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("sh_emailid"), "Gayatri_automate", "@getnada.com");
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_firstname"), "Gayatri");
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_lastname"), "autosharelead");

		// Step 3: Enter Company Details
		XamplifyUtil.getElementById("company").sendKeys("Gcompany");
		Thread.sleep(1000);

		// Step 4: Legal Basis Selection
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_legalbasis"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(properties.getProperty("sh_legalbasis"), Keys.ENTER);

		// Step 5: Job Details
		XamplifyUtil.getElementById("title").sendKeys("Software Engineer");

		// Step 6: Address Information
		XamplifyUtil.getElementById("address").sendKeys("Sri maaruthi homes");
		XamplifyUtil.getElementById("city").sendKeys("Hyderabad");
		XamplifyUtil.getElementById("state").sendKeys("Andhra pradesh");
		XamplifyUtil.getElementById("zip").sendKeys("534342");

		// Step 7: Scroll Inside Modal
		WebElement scrollableDiv = driver.findElement(By.xpath(properties.getProperty("sh_scroll")));
		XamplifyUtil.scrollInsideElement(scrollableDiv, 500);

		// Step 8: Mobile & Country Selection
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_mobileno"), "9490925009");
		XamplifyUtil.selectDropdownByText(properties.getProperty("sh_country"), "India");

		// Step 9: Submit the sharelead
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_add"));
		Thread.sleep(1000);

		// Step 10:Save the list
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_save"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));

		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "OneatatimeCreation_Shareleads");

	}

	@Test(priority = 2, enabled = false)
	public void shareleadsUploadCSV() throws InterruptedException {
		// Step 1: Hover over the "Share Leads" section

		hoverOnShareLeads();

		// Step 2: Define test data for CSV file (each row corresponds to the headers)
		List<String[]> userData = Arrays.asList(
				new String[] { "Gayatri", "Doe", "ABC Corp", "Manager", "gayatri.doe@getnada.com", "123 Street",
						"New York", "NY", "10001", "USA", "1234567890" },
				new String[] { "lucky", "Smith", "XYZ Ltd", "Software Engineer", "lucky.smith@getnada.com",
						"456 Avenue", "San Francisco", "CA", "94105", "USA", "9876543210" });

		// Step 3: Generate CSV dynamically and get the file path
		String filePath = XamplifyUtil.generateCSV(userData);

		Thread.sleep(4000);

		// Step 4:Locate file input and upload CSV
		WebElement uploadElement = driver.findElement(By.xpath(properties.getProperty("sh_csvclick")));

		uploadElement.sendKeys(filePath);
		// Step 5: Legal Basis Selection

		XamplifyUtil.sendTextEvent(properties.getProperty("sh_legalbasis"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(properties.getProperty("sh_legalbasis"), Keys.ENTER);

		// Step 6:Save the list
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_save"));

		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));
		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "UploadCSVCreation_Shareleads");

	}

	@Test(priority = 3, enabled = false)
	public void shareleadsSearch() throws InterruptedException {
		Thread.sleep(2000);

		manageHoverShareLeads();
		Thread.sleep(3000);

		/*
		 * // Step 2: Click on the Share Leads grid
		 * 
		 * XamplifyUtil.callClickEvent(properties.getProperty("mshareleads_grid"));
		 */

		// Step 3: Enter search text in the Search Bar

		XamplifyUtil.sendTextEvent(properties.getProperty("mshareleads_search"), "Auto");

		XamplifyUtil.sendKeyEvent(properties.getProperty("mshareleads_search"), Keys.ENTER);

		Thread.sleep(3000);

	}

	@Test(priority = 4, enabled = false)
	public void shareleadsDropdown() throws InterruptedException {
		Thread.sleep(2000);

//Selecting multiple indices with a wait
		int[] indices = { 1, 2, 3, 6, 5, 4 };
		for (int index : indices) {
			XamplifyUtil.selectDropdownWithWait(driver, properties.getProperty("mshareleads_drpdwn"), index);
		}

		Thread.sleep(2000);

		XamplifyUtil.sendTextEvent(properties.getProperty("mshareleads_search"), Keys.chord(Keys.CONTROL, "a"));
		XamplifyUtil.sendKeyEvent(properties.getProperty("mshareleads_search"), Keys.BACK_SPACE);

	}

	@Test(priority = 5, enabled = false)
	public void shareleadsPublishDownload() throws InterruptedException, AWTException {
		Thread.sleep(4000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_publishicon"));
		Thread.sleep(2000);

		XamplifyUtil.sendTextEvent(properties.getProperty("manageshare_publish_search"), "Partner");

		XamplifyUtil.sendKeyEvent(properties.getProperty("manageshare_publish_search"), Keys.ENTER);
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_expand"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_selectcheckbox"));

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_submit"));
		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "Published_Shareleads");
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_submit_close"));
		Thread.sleep(7000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_aftrpublish_preview"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_aftrpublish_preview_close"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_download"));
		Thread.sleep(2000);
		Robot robot = new Robot();

		// Press "Ctrl"
		robot.keyPress(KeyEvent.VK_CONTROL);
		// Press "S"
		robot.keyPress(KeyEvent.VK_ENTER);
		// Release "S"
		robot.keyRelease(KeyEvent.VK_S);
		// Release "Ctrl"
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	@Test(priority = 6, enabled = false)
	public void shareleadsCopy() throws InterruptedException, AWTException {

		manageHoverShareLeads();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			// Wait until the element is located and visible
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("manageshare_copy"))));

			// Interact with the element (e.g., click)
			element.click();
		} catch (Exception e) {
			System.out.println("Element not found or interaction failed: " + e.getMessage());
		}

		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_copy_saveas"));
		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "Saveascopy_ListCreated");

		WebDriverWait wait3 = new WebDriverWait(driver, 30);

		try {
			// Wait until the element is located and visible
			WebElement element2 = wait3.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("manageshare_searchicon"))));

			// Interact with the element (e.g., click)
			element2.click();
		} catch (Exception e2) {
			System.out.println("Element not found or interaction failed: " + e2.getMessage());
		}

		WebDriverWait wait2 = new WebDriverWait(driver, 30);

		try {
			// Wait until the element is located and visible
			WebElement element2 = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("manageshare_delete"))));

			// Interact with the element (e.g., click)
			element2.click();
		} catch (Exception e2) {
			System.out.println("Element not found or interaction failed: " + e2.getMessage());
		}
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_delete_yes"));

	}

	public static void shareleadsFilter() throws Exception {

		XamplifyUtil.selectDropdownByText(properties.getProperty("managesh_filter_fieldname"), "City");

		Thread.sleep(1000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("managesh_filter_drop"), "Contains");
		Thread.sleep(1000);

		XamplifyUtil.sendTextEvent(properties.getProperty("managesh_filter_value"), "HYDerabad");

		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_submit"));

		Thread.sleep(2000);

	}

	@Test(priority = 7, enabled = true)
	public void shareleadsAlltiles() throws Exception {

		manageHoverShareLeads();
		Thread.sleep(7000);
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_all"));

		/*
		 * WebDriverWait wait4 = new WebDriverWait(driver, 60);
		 * 
		 * try { // Wait until the element is located and visible WebElement element4 =
		 * wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties
		 * .getProperty(""))));
		 * 
		 * // Interact with the element (e.g., click) element4.click(); } catch
		 * (Exception e4) {
		 * System.out.println("Element not found or interaction failed: " +
		 * e4.getMessage()); }
		 */
		Thread.sleep(3000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshareall_filter"));

		shareleadsFilter();
		Thread.sleep(3000);

		XamplifyUtil.sendTextEvent(properties.getProperty("managesh_filter_search"), "43");
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(properties.getProperty("managesh_filter_search"), Keys.ENTER);
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_sort"));

		XamplifyUtil.selectDropdownByText("managesh_filter_sort", "Email (A-Z)");
		Thread.sleep(2000);

		XamplifyUtil.selectDropdownByText("managesh_filter_sort", "Email (Z-A)");
		Thread.sleep(2000);

		// XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_select"));

	}

}
