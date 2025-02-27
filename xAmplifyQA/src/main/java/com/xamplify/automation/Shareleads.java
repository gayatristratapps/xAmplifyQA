package com.xamplify.automation;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;
import com.xamplify.util.XamplifyUtil;

public class Shareleads {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Shareleads.properties");
	final Logger logger = LogManager.getLogger(Shareleads.class);

	public void hoverOnShareLeads() throws InterruptedException {

		// Hover and click on the Share Leads section

		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "add_shareleads");

		XamplifyUtil.sendTextWithTimestamp("contactListName", "AutoSlist");
	}

	// Navigate to Manage Share Leads section
	public void manageHoverShareLeads() throws InterruptedException {

		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "manage_shareleads");

	}

	public static void shareleadsFilter() throws Exception {

		Thread.sleep(1000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("managesh_filter_fieldname"), "City");

		Thread.sleep(1000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("managesh_filter_drop"), "Contains");
		Thread.sleep(1000);

		XamplifyUtil.sendTextEvent(properties.getProperty("managesh_filter_value"), "HYDerabad");

		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_submit"));

		Thread.sleep(2000);

	}

	// Test case for creating a share lead one at a time
	@Test(priority = 1, enabled = true)
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

	// Test case for uploading a CSV file to Share Leads
	@Test(priority = 2, enabled = true)
	public void shareleadsUploadCSV() throws InterruptedException {
		// Hover over the "Share Leads" section
		Thread.sleep(2000);
		hoverOnShareLeads();
		Thread.sleep(2000);
		// Define test data for CSV file (each row corresponds to the headers)
		List<String[]> userData = Arrays.asList(
				new String[] { "Gayatri", "Doe", "ABC Corp", "Manager", "gayatri.doe@getnada.com", "123 Street",
						"New York", "NY", "10001", "USA", "1234567890" },
				new String[] { "lucky", "Smith", "XYZ Ltd", "Software Engineer", "lucky.smith@getnada.com",
						"456 Avenue", "San Francisco", "CA", "94105", "USA", "9876543210" });

		// Generate CSV dynamically and get the file path
		String filePath = XamplifyUtil.generateCSV(userData);

		Thread.sleep(4000);

		// Locate file input and upload CSV
		WebElement uploadElement = driver.findElement(By.xpath(properties.getProperty("sh_csvclick")));

		uploadElement.sendKeys(filePath);
		// Legal Basis Selection

		XamplifyUtil.sendTextEvent(properties.getProperty("sh_legalbasis"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(properties.getProperty("sh_legalbasis"), Keys.ENTER);

		// Save the list
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_save"));

		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));
		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "UploadCSVCreation_Shareleads");

	}

//	Test case for searching within Share Leads
	@Test(priority = 3, enabled = true)
	public void shareleadsSearch() throws InterruptedException {
		Thread.sleep(2000);

		manageHoverShareLeads();
		Thread.sleep(3000);

		/*
		 * // Step 2: Click on the Share Leads grid
		 * 
		 * XamplifyUtil.callClickEvent(properties.getProperty("mshareleads_grid"));
		 */

		// Enter search text in the Search Bar

		XamplifyUtil.sendTextEvent(properties.getProperty("mshareleads_search"), "Auto");

		XamplifyUtil.sendKeyEvent(properties.getProperty("mshareleads_search"), Keys.ENTER);

		Thread.sleep(3000);

	}

	@Test(priority = 4, enabled = true)
	public void shareleadsDropdown() throws InterruptedException {
		Thread.sleep(2000);

//Selecting multiple indices with a wait
		int[] indices = { 1, 2, 3, 6, 5, 4 };
		for (int index : indices) {
			XamplifyUtil.selectDropdownWithWait(driver, properties.getProperty("mshareleads_drpdwn"), index);
		}

		Thread.sleep(2000);
		// Clearing search input field

		XamplifyUtil.sendTextEvent(properties.getProperty("mshareleads_search"), Keys.chord(Keys.CONTROL, "a"));
		XamplifyUtil.sendKeyEvent(properties.getProperty("mshareleads_search"), Keys.BACK_SPACE);

	}

	@Test(priority = 5, enabled = true)
	public void shareleadsPublishDownload() throws InterruptedException, AWTException {
		Thread.sleep(5000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_publishicon"));
		Thread.sleep(2000);
		// Searching for "Partner" in publish search

		XamplifyUtil.sendTextEvent(properties.getProperty("manageshare_publish_search"), "Partner");

		XamplifyUtil.sendKeyEvent(properties.getProperty("manageshare_publish_search"), Keys.ENTER);
		Thread.sleep(1000);
		// Expanding and selecting the checkbox

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_expand"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_selectcheckbox"));

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_submit"));
		Thread.sleep(1000);
		// Taking screenshot

		XamplifyUtil.takeScreenshot(driver, "Published_Shareleads");
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_submit_close"));
		Thread.sleep(7000);
		// Preview after publishing

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_aftrpublish_preview"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_aftrpublish_preview_close"));
		Thread.sleep(1000);
		// Download the file

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_download"));
		Thread.sleep(2000);

		XamplifyUtil.excelDownload();
	}

	@Test(priority = 6, enabled = true)
	public void shareleadsCopy() throws InterruptedException, AWTException {

		manageHoverShareLeads();

		// Click "Copy" with wait
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("manageshare_copy"), 30);
		Thread.sleep(1000);

		// Click "Save As"
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_copy_saveas"));
		Thread.sleep(1000);

		// Take screenshot
		XamplifyUtil.takeScreenshot(driver, "Saveascopy_ListCreated");

		// Click "Search Icon" with wait
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("manageshare_searchicon"), 30);

		// Click "Delete" with wait
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("manageshare_delete"), 30);
		Thread.sleep(2000);

		// Confirm delete
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_delete_yes"));
		
		XamplifyUtil.takeScreenshot(driver, "Deleted_shareleadlist");
		Thread.sleep(4000);

	}

	@Test(priority = 7, enabled = true)
	public void shareleadsAlltilesFilterSearch() throws Exception {

		manageHoverShareLeads();
		Thread.sleep(9000);
		// Click "All" Share Leads

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_all"));

		Thread.sleep(3000);
		// Open filter and apply filtering

		XamplifyUtil.callClickEvent(properties.getProperty("manageshareall_filter"));

		shareleadsFilter();
		Thread.sleep(4000);
		// Search and apply filter
		XamplifyUtil.sendTextEvent(properties.getProperty("managesh_filter_search"), "43");
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(properties.getProperty("managesh_filter_search"), Keys.ENTER);
		Thread.sleep(2000);

	}

	@Test(priority = 8, enabled = true)
	public void shareleadsAlltilesSortEmailreports() throws Exception {

		// List of sorting options
		List<String> sortOptions = Arrays.asList("Email (A-Z)", "Email (Z-A)", "First name (ASC)", "First name (DESC)",
				"Last name (ASC)");

		// Iterate through the list and select each option
		for (String option : sortOptions) {
			XamplifyUtil.selectDropdownByText(properties.getProperty("managesh_filter_sort"), option);
			Thread.sleep(2000); // Sleep after each selection
		}

		Thread.sleep(1000);

		// Generate email report and take a screenshot

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_emailreport"));

		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "Emailreport_allTile_shareleads");

	}

	@Test(priority = 9, enabled = true)
	public void shareleadsAlltilesNewlist() throws Exception {

		// Select and download data

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_select"));

		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_gearicon"));
		Thread.sleep(1000);

		XamplifyUtil.getElementById("delete_button").click();
		Thread.sleep(2000);

		XamplifyUtil.excelDownload();
		// Create a new list

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_gearicon"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_createlist"));
		Thread.sleep(1000);
		// Enter contact list details

		XamplifyUtil.getElementById("campaignName").sendKeys("AutoSlist");

		XamplifyUtil.sendTextWithTimestamp("campaignName", "AutoSlist");

		Thread.sleep(1000);
		// Select legal basis

		XamplifyUtil.sendTextEvent(properties.getProperty("sh_legalbasis"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(properties.getProperty("sh_legalbasis"), Keys.ENTER);

		Thread.sleep(1000);
		// Save the created list

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_createlist_saveas"));
		Thread.sleep(1000);
		
		XamplifyUtil.takeScreenshot(driver, "NewlistCreatedAllTile_Shareleads");


	}

}
