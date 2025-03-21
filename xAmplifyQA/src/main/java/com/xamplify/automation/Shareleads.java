package com.xamplify.automation;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public static final By SH_LEGALBASIS = By.xpath(properties.getProperty("sh_legalbasis"));

	// Hover and click on the Share Leads section
	public void hoverOnShareLeads() throws InterruptedException {
		Thread.sleep(1000);
		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "add_shareleads");
		XamplifyUtil.sendTextWithTimestamp("contactListName", "AutoSlist");
	}

	// Navigate to Manage Share Leads section
	public void manageHoverShareLeads() throws InterruptedException {
		Thread.sleep(1000);
		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "manage_shareleads");
	}

	// Open filter and apply filtering
	public static void shareleadsFilter() throws Exception {

		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("manageshareall_filter"));
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

	public static void oneatatimeShareleads() throws Exception {

		// Enter Personal Details
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("sh_emailid"), "Gayatri_automate", "@getnada.com");
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_firstname"), "Gayatri");
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_lastname"), "autosharelead");

		// Enter Company Details
		XamplifyUtil.getElementById("company").sendKeys("Gcompany");
		Thread.sleep(2000);

		// Legal Basis Selection
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_legalbasis"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(properties.getProperty("sh_legalbasis"), Keys.ENTER);

		// Job Details
		XamplifyUtil.getElementById("title").sendKeys("Software Engineer");

		// Address Information
		XamplifyUtil.getElementById("address").sendKeys("Sri maaruthi homes");
		XamplifyUtil.getElementById("city").sendKeys("Hyderabad");
		XamplifyUtil.getElementById("state").sendKeys("Andhra pradesh");
		XamplifyUtil.getElementById("zip").sendKeys("534342");

		// Scroll Inside Modal
		WebElement scrollableDiv = driver.findElement(By.xpath(properties.getProperty("sh_scroll")));
		XamplifyUtil.scrollInsideElement(scrollableDiv, 500);

		// Mobile & Country Selection
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_mobileno"), "9490925009");
		XamplifyUtil.selectDropdownByText(properties.getProperty("sh_country"), "India");

		// Submit the sharelead
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_add"));

	}

	// Test case for creating a share lead one at a time
	@Test(priority = 1, enabled = true)
	public void shareLeadsOneAtATime() throws Exception {

		hoverOnShareLeads();
		logger.debug("Starting creating sharelead using One at a time");

		// Click on 'One at a Time' option
		XamplifyUtil.callClickEvent(properties.getProperty("sh_oneattime"));
		oneatatimeShareleads();

		// Save the list
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_save"));
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));

		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "OneatatimeCreation_Shareleads");
		logger.debug("Done creation sharelead using One at a time");

	}

	public static void uploadcsvShareleads() throws Exception {

		// Define test data for CSV file (each row corresponds to the headers)
		List<String[]> userData = Arrays.asList(
				new String[] { "Gayatri", "A", "ABC Corp", "Manager", "gayatri.A@getnada.com", "123 Street", "New York",
						"NY", "10001", "USA", "1234567890" },
				new String[] { "lucky", "Smith", "XYZ Ltd", "Software Engineer", "lucky.smith@getnada.com",
						"456 Avenue", "San Francisco", "CA", "94105", "USA", "9876543210" });

		// Generate CSV dynamically and get the file path
		String filePath = XamplifyUtil.generateCSV(userData);
		Thread.sleep(3000);

		// Locate file input and upload CSV
		WebElement uploadElement = driver.findElement(By.xpath(properties.getProperty("sh_csvclick")));

		uploadElement.sendKeys(filePath);
		// Legal Basis Selection

		XamplifyUtil.sendTextEvent(properties.getProperty("sh_legalbasis"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(properties.getProperty("sh_legalbasis"), Keys.ENTER);

	}

	// Test case for uploading a CSV file to Share Leads
	@Test(priority = 2, enabled = true)
	public void shareleadsUploadCSV() throws Exception {
		// Hover over the "Share Leads" section
		Thread.sleep(2000);
		hoverOnShareLeads();
		Thread.sleep(2000);

		uploadcsvShareleads();

		// Save the list
		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_save"));

		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));
		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "UploadCSVCreation_Shareleads");
		logger.debug("Done creation sharelead using upload csv");

	}

	@Test(priority = 3, enabled = true)
	public void manageshareleadsEditAddsharelead() throws Exception {

		manageHoverShareLeads();

		WebElement editButton = XamplifyUtil.waitForElementVisibility(By.xpath(properties.getProperty("managesh_edit")),40);
		editButton.click();
		Thread.sleep(2000);
		
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_edit_details"));
		Thread.sleep(1000);
		XamplifyUtil.getElementById("lastName").sendKeys("1");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_edit_details_update"));
		Thread.sleep(2000);
		
		
		
		uploadcsvShareleads();
		Thread.sleep(1000);

		XamplifyUtil.getElementById("save&delete_button").click();
		XamplifyUtil.getElementById("save_button").click();
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));

		Thread.sleep(1000);
		logger.debug("Done creation sharelead using edit option through csv");

	}

//	Test case for searching within Share Leads
	@Test(priority = 4, enabled = true)
	public void manageShareleadsSearch() throws InterruptedException {
		Thread.sleep(2000);

		manageHoverShareLeads();
		Thread.sleep(3000);

		/*
		 * // Step 2: Click on the Share Leads grid
		 * XamplifyUtil.callClickEvent(properties.getProperty("mshareleads_grid"));
		 */

		// Enter search text in the Search Bar

		XamplifyUtil.sendTextEvent(properties.getProperty("mshareleads_search"), "Auto");
		XamplifyUtil.sendKeyEvent(properties.getProperty("mshareleads_search"), Keys.ENTER);
		Thread.sleep(3000);

	}

	@Test(priority = 5, enabled = true)
	public void shareleadsDropdown() throws InterruptedException {
		Thread.sleep(3000);

//Selecting multiple indices with a wait
		int[] indices = { 6, 5, 4 };
		for (int index : indices) {
			XamplifyUtil.selectDropdownWithWait(driver, properties.getProperty("mshareleads_drpdwn"), index);
		}

		Thread.sleep(2000);
		// Clearing search input field

		/*
		 * XamplifyUtil.sendTextEvent(properties.getProperty("mshareleads_search"),
		 * Keys.chord(Keys.CONTROL, "a"));
		 * XamplifyUtil.sendKeyEvent(properties.getProperty("mshareleads_search"),
		 * Keys.BACK_SPACE); Thread.sleep(2000);
		 */
	}

	@Test(priority = 6, enabled = true)
	public void manageShareleadsPublishDownload() throws InterruptedException, AWTException {
		
		Thread.sleep(20000);
	
		
	
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, (60)); WebElement element =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.
		 * getProperty("manageshare_publishicon")))); element.click();
		 */

		
		
		
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_publishicon"));
		
		
		Thread.sleep(3000);
		
		
		// Searching for "Partner" in publish search

		XamplifyUtil.sendTextEvent(properties.getProperty("manageshare_publish_search"), "PartnerAuto");
		Thread.sleep(2000);
		
		XamplifyUtil.sendKeyEvent(properties.getProperty("manageshare_publish_search"), Keys.ENTER);
		Thread.sleep(2000);
		
		// Expanding and selecting the checkbox

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_expand"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_selectcheckbox"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_submit"));
		Thread.sleep(1000);
		
		// Taking screenshot

		XamplifyUtil.takeScreenshot(driver, "Published_Shareleads");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_submit_close"));
		
		// Preview after publishing
		
		  Thread.sleep(20000);
		  
		  XamplifyUtil.callClickEvent(properties.getProperty("manageshare_aftrpublish_preview")); Thread.sleep(1000);
		 
		
			/*
			 * // Use WebDriverWait for the first element to be clickable WebDriverWait wait
			 * = new WebDriverWait(driver, (160));
			 * 
			 * // Wait until the element is clickable WebElement previewButton =
			 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.
			 * getProperty("manageshare_aftrpublish_preview")))); previewButton.click();
			 * 
			 * Thread.sleep(2000);
			 */
		  Thread.sleep(2000);
		
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_aftrpublish_preview_close"));
		Thread.sleep(2000);
		
		// Download the file

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_download"));
		Thread.sleep(2000);

		XamplifyUtil.excelDownload(); 
	}

	@Test(priority = 7, enabled = true)
	public void manageShareleadsCopy() throws InterruptedException, AWTException {

		manageHoverShareLeads();

		// Click "Copy" with wait
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("manageshare_copy"), 30);
		Thread.sleep(1000);

		// Click "Save As"
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_copy_saveas"));
		Thread.sleep(1000);

		// Take screenshot
		XamplifyUtil.takeScreenshot(driver, "Saveascopy_ListCreated");
		Thread.sleep(1000);

		

	}

	@Test(priority = 8, enabled = true)
	public void manageShareleadsDelete() throws InterruptedException, AWTException {

		// Click "Search Icon" with wait
		// XamplifyUtil.clickElementWithWait(driver,
		// properties.getProperty("manageshare_searchicon"), 30);

		// Click "Delete" with wait
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("manageshare_delete"), 30);
		Thread.sleep(2000);

		// Confirm delete
		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_delete_yes"));
		XamplifyUtil.takeScreenshot(driver, "Deleted_shareleadlist");
		Thread.sleep(4000);

	}

	public static void filterSearch() throws Exception {
		// Search and apply filter
		XamplifyUtil.sendTextEvent(properties.getProperty("managesh_filter_search"), "43");
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(properties.getProperty("managesh_filter_search"), Keys.ENTER);
		Thread.sleep(2000);

	}

	@Test(priority = 9, enabled = true)
	public void manageShareleadsAlltilesFilterSearch() throws Exception {

		manageHoverShareLeads();
		Thread.sleep(20000);
		// Click "All" Share Leads

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_all"));
		Thread.sleep(3000);

		//shareleadsFilter();
		
		Thread.sleep(4000);

		filterSearch();

	}

	public void manageSleadsTilesSortEmailreports() throws Exception {

		// List of sorting options
		List<String> sortOptions = Arrays.asList("Email (A-Z)", "Email (Z-A)", "First name (ASC)", "First name (DESC)",
				"Last name (ASC)");

		// Iterate through the list and select each option
		for (String option : sortOptions) {
			XamplifyUtil.selectDropdownByText(properties.getProperty("managesh_filter_sort"), option);
			Thread.sleep(2000); // Sleep after each selection
		}

		Thread.sleep(1000);

		// Generate email report

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_emailreport"));

	}

	@Test(priority = 10, enabled = true)
	public void manageShareleadsAlltilesSortEmailreports() throws Exception {

		manageSleadsTilesSortEmailreports();
		XamplifyUtil.takeScreenshot(driver, "Allreport_ValidTile_shareleads");

	}

	public void manageShareleadstilesExportexcel() throws Exception {
		
		// Select the gear icon and download data

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_gearicon"));
		Thread.sleep(1000);

		XamplifyUtil.getElementById("delete_button").click();
		Thread.sleep(2000);

		XamplifyUtil.excelDownload();

	}

	@Test(priority = 11, enabled = true)
	public void manageShareleadsAlltilesNewlist() throws Exception {

		// Select and download data

		XamplifyUtil.callClickEvent(properties.getProperty("managesh_filter_select"));

		Thread.sleep(1000);
		manageShareleadstilesExportexcel();

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

		// manageShareleadsDelete();

	}

	@Test(priority = 12, enabled = true)
	public void manageShareleadsValidtiles() throws Exception {

		manageHoverShareLeads();
		Thread.sleep(18000);

		// Click "valid" Share Leads

		XamplifyUtil.callClickEvent(properties.getProperty("manageshare_valid"));

		Thread.sleep(3000);
		shareleadsFilter();
		Thread.sleep(4000);
		filterSearch();
		Thread.sleep(2000);
		manageSleadsTilesSortEmailreports();
		XamplifyUtil.takeScreenshot(driver, "Emailreport_ValidTile_shareleads");

		Thread.sleep(1000);
		manageShareleadstilesExportexcel();
		Thread.sleep(1000);
		

	}

	@Test(priority = 13, enabled = true)
	public void manageShareleadsExcludetiles() throws Exception {

		manageHoverShareLeads();
		Thread.sleep(9000);

		// Click "exclude" Share Leads

		WebElement excludetile = driver.findElement(By.xpath(properties.getProperty("manageshare_exclude")));

		// Click only if button is enabled
		if (excludetile.isEnabled()) {
			excludetile.click();

			Thread.sleep(3000);
			shareleadsFilter();
			Thread.sleep(4000);

			filterSearch();
			Thread.sleep(2000);
			manageSleadsTilesSortEmailreports();
			XamplifyUtil.takeScreenshot(driver, "Emailreport_ExcludeTile_shareleads");

			Thread.sleep(1000);
			manageShareleadstilesExportexcel();

		} else {
			System.out.println("Excluded count is 0 & button is disabled, cannot click.");
		}
	}

	@Test(priority = 14, enabled = true)
	public void manageShareleadsUndeliverabletiles() throws Exception {

		manageHoverShareLeads();
		Thread.sleep(9000);

		// Click "undeliverable" Share Leads

		WebElement undeliverabletile = driver.findElement(By.xpath(properties.getProperty("manageshare_exclude")));

		// Click only if button is enabled
		if (undeliverabletile.isEnabled()) {
			undeliverabletile.click();

			Thread.sleep(2000);
			shareleadsFilter();
			Thread.sleep(2000);

			filterSearch();
			Thread.sleep(2000);
			manageSleadsTilesSortEmailreports();
			XamplifyUtil.takeScreenshot(driver, "Emailreport_undeliverabletile_shareleads");

			Thread.sleep(1000);
			manageShareleadstilesExportexcel();

		} else {
			System.out.println("undeliverabletile count is 0 & button is disabled, cannot click.");
		}
	}

	@Test(priority = 15, enabled = true)
	public void manageShareleadsUnubscribetiles() throws Exception {

		manageHoverShareLeads();
		Thread.sleep(9000);

		// Click "unsubscribe" Share Leads

		WebElement unsubscribetile = driver.findElement(By.xpath(properties.getProperty("manageshare_unsubscribe")));

		// Click only if button is enabled
		if (unsubscribetile.isEnabled()) {
			unsubscribetile.click();

			Thread.sleep(2000);
			shareleadsFilter();
			Thread.sleep(2000);

			filterSearch();
			Thread.sleep(2000);
			manageSleadsTilesSortEmailreports();
			XamplifyUtil.takeScreenshot(driver, "Emailreport_unsubscribetile_shareleads");

			Thread.sleep(1000);
			manageShareleadstilesExportexcel();

		} else {
			System.out.println("unsubscribetile count is 0 & button is disabled, cannot click.");
		}
		
		
	}

}
