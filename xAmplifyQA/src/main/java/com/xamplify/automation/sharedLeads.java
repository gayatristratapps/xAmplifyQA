package com.xamplify.automation;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class sharedLeads {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Sharedleads.properties");
	final static Logger logger = LogManager.getLogger(sharedLeads.class);
	int count = getCountValue();

	// Hover and click on the Shared Leads section
	public void hoverOnSharedLeads() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("Hovering on Shared Leads section.");
		XamplifyUtil.callClickEvent(properties.getProperty("sharedleads"));
		Thread.sleep(2000);
		logger.info("Hovered and clicked on Shared Leads section.");
	}

	// Open filter and apply filter
	public static void sharedleadsFilter() throws Exception {
		logger.info("Applying filter on Shared Leads.");

		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter"));
		Thread.sleep(1000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_fieldname"), "City");
		Thread.sleep(1000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_drop"), "Contains");
		Thread.sleep(1000);
		XamplifyUtil.sendTextEvent(properties.getProperty("sharedAll_filter_value"), "HYDerabad");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_submit"));
		Thread.sleep(2000);
		logger.info("Filter applied successfully.");
	}

	public static void closefilter() throws Exception {
		// close filter
		logger.info("Closing the filter.");
		XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter"));
		Thread.sleep(1000);
		logger.info("Filter closed.");
	}

	public static void filterSearch() throws Exception {
		// Search and apply filter

		logger.info("Searching with filter.");

		XamplifyUtil.sendTextEvent(properties.getProperty("sharedAll_filter_search"), "4");
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(properties.getProperty("sharedAll_filter_search"), Keys.ENTER);
		Thread.sleep(1000);
		logger.info("Filter search applied.");

	}

	public static void clearSearch() throws Exception {
		// clear
		logger.info("Clearing search filter.");

		XamplifyUtil.sendKeyEvent(properties.getProperty("sharedAll_filter_search"), Keys.BACK_SPACE);
		Thread.sleep(2000);
		XamplifyUtil.sendKeyEvent(properties.getProperty("sharedAll_filter_search"), Keys.ENTER);
		Thread.sleep(2000);
		logger.info("Search filter cleared.");
	}

	public void manageSharedleadsTilesSort() throws Exception {
		logger.info("Managing Shared Leads tiles sorting.");
		Thread.sleep(2000);
		// List of sorting options
		List<String> sortOptions = Arrays.asList("Email (A-Z)", "Email (Z-A)", "First name (ASC)", "First name (DESC)",
				"Last name (ASC)");

		// Iterate through the list and select each option
		for (String option : sortOptions) {
			XamplifyUtil.selectDropdownByText(properties.getProperty("sharedAll_filter_sort"), option);
			Thread.sleep(3000); // Sleep after each selection
		}

		Thread.sleep(1000);
		logger.info("Shared Leads tiles sorting completed.");
	}

	// Handle email reports for Shared Leads tiles
	public void manageSharedleadsTilesEmailreports() throws Exception {
		logger.info("Managing email reports for Shared Leads tiles.");
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("sharedAll_filter_emailreport"));
		logger.info("Email report triggered.");
	}

	// Manage sorting on Shared Leads edit tiles with retries
	public static void manageSharedleadsEditTilesSort(WebDriver driver, By locator, String value) {
		logger.info("Managing sorting on Shared Leads edit tiles.");

		int maxAttempts = 3;
		for (int attempt = 0; attempt < maxAttempts; attempt++) {
			try {
				// Re-find the dropdown element fresh from the DOM
				WebElement dropdownElement = driver.findElement(locator);
				Select dropdown = new Select(dropdownElement);
				dropdown.selectByValue(value);

				// Verify that the selected value is correct
				String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
				if (selectedValue.equals(value)) {

					System.out.println("Selected value: " + dropdown.getFirstSelectedOption().getText());
					return; // Successfully selected, exit the method
				} else {
					System.out.println("Selection did not register correctly. Attempt " + (attempt + 1));
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException caught. Retrying... Attempt " + (attempt + 1));
			}
			// Wait briefly before trying again
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				// Restore interrupted state...
				Thread.currentThread().interrupt();
			}
		}
		throw new RuntimeException("Failed to select value '" + value + "' after " + maxAttempts
				+ " attempts due to stale element reference.");
	}

	@Test(priority = 1, enabled = true)
	public void SharedleadsListviewActionsAllTile() throws Exception {
		logger.info("Starting Shared Leads Listview Actions on All Tile.");

		Thread.sleep(2000);

		hoverOnSharedLeads();
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("sharedleads_infoicon"));
		Thread.sleep(1000);

		sharedleadsFilter();

		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("sharedleads_edit_sort"));
		Thread.sleep(3000);

		try {
			logger.info("Starting sort tests for Shared Leads edit tiles.");

			Thread.sleep(3000);

			// Attempting sorting with multiple values
			By dropdownLocator1 = By.xpath(properties.getProperty("sharedleads_edit_sort"));

			// Wait a bit before the first interaction
			Thread.sleep(3000);

			// Select first option by value

			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "1: Object");
			Thread.sleep(3000);

			// Select second option by value
			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "2: Object");
			Thread.sleep(3000);

			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "3: Object");
			Thread.sleep(3000);

			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "4: Object");
			Thread.sleep(3000);

			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "5: Object");
			Thread.sleep(3000);

			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "6: Object");
			Thread.sleep(4000);

		} catch (InterruptedException e) {
			logger.error("Error occurred during sort tests: ", e);

			e.printStackTrace();

			Thread.sleep(2000);

		}

		Thread.sleep(1000);

		filterSearch();

		Thread.sleep(1000);

		manageSharedleadsTilesEmailreports();
		Thread.sleep(1000);

		XamplifyUtil.getElementById("more_less_button_0");

		XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsUnsub"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsUnsubReason"));
		Thread.sleep(1000);

		XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsUnsubSubmit"));
		Thread.sleep(1000);
		logger.info("Completed Shared Leads Listview Actions on All Tile.");
	}

	// @Test(dependsOnMethods = { "SharedleadsListviewActionsAllTile" })

	@Test(priority = 2, enabled = true)
	public void SharedleadslistUnsubscribeTile() throws Exception {
		logger.info("Starting Unsubscribe action on Shared Leads tile.");

		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 20); // Wait for up to 10 seconds

		// Unsubscribe tile check

		WebElement unsubscribeSh = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(properties.getProperty("sharedlead_edit_Unsubscribed"))));
		if (unsubscribeSh.isEnabled()) {
			unsubscribeSh.click();

		} else {
			System.out.println("Sharedleads-Unsubscribe tile is disabled because its count is '0'");

			logger.debug(" Sharedleads-Unsubscribe tile is disabled because its count is '0'");
		}

		filterSearch();

		Thread.sleep(1000);

		manageSharedleadsTilesEmailreports();
		Thread.sleep(1000);
		logger.info("Resubscribing sharedlead.");

		XamplifyUtil.callClickEvent(properties.getProperty("sharedlead_edit_Subscribe"));
		Thread.sleep(1000);
		WebElement reason = XamplifyUtil.getElementById("comment");
		reason.sendKeys("Resubscribe sharedlead 123");

		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("sharedlead_edit_Resubscribe"));
		Thread.sleep(1000);

		XamplifyUtil.takeScreenshot(driver, "Resubscribed sharedlead");
		logger.info("Resubscribe action completed and screenshot taken.");

	}

	@Test(priority = 2, enabled = true)
	public void SharedleadsEditlistValidTile() throws Exception {
		logger.info("Starting Valid Tile action on Shared Leads edit list.");

		WebDriverWait wait = new WebDriverWait(driver, 30); // Wait for up to 10 seconds
		WebElement validtileSh = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("sharedlead_edit_valid"))));

		// Check if the valid tile is enabled and displayed

		if (count > 0 && validtileSh.isEnabled()) {

			validtileSh.click();

		} else {
			logger.debug("Sharedleads-Valid tile is disabled because its count is '0' or it's not visible.");
		}

	}

	@Test(priority = 3, enabled = true)
	public void SharedleadsEditlistExcludeTile() throws Exception {
		logger.info("Starting Exclude Tile action on Shared Leads edit list.");

		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		// Wait for the exclude tile to be clickable
		WebElement excludetileSh = wait2.until(
				ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("sharedlead_edit_exclude"))));

		if (count > 0 && excludetileSh.isEnabled()) {
			excludetileSh.click();
		} else {
			System.out
					.println("Sharedleads-edit-exclude tile is disabled because its count is '0' or it's not visible.");
		}

	}

	@Test(priority = 4, enabled = true)
	public void SharedleadsEditlistUndeliverableTile() throws Exception {
		logger.info("Starting Undeliverable Tile action on Shared Leads edit list.");

		WebDriverWait wait3 = new WebDriverWait(driver, 30);
		// Wait for the exclude tile to be clickable
		WebElement Undeliverablesh = wait3.until(ExpectedConditions
				.elementToBeClickable(By.xpath(properties.getProperty("sharedlead_edit_Undeliverable"))));

		if (count > 0 && Undeliverablesh.isEnabled()) {
			Undeliverablesh.click();
		} else {
			System.out.println(
					"Sharedleads-edit-Undeliverable tile is disabled because its count is '0' or it's not visible.");
		}

	}

	@Test(priority = 5, enabled = true)
	public void manageSharedLeadsAllTileActions() throws Exception {
		logger.info("Starting actions on all Shared Leads tiles.");

		hoverOnSharedLeads();
		logger.debug("Clicking on shared lead in partner account.");
		Thread.sleep(9000);
		XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsAll"));
		Thread.sleep(2000);

		sharedleadsFilter();
		Thread.sleep(1000);

		filterSearch();
		Thread.sleep(1000);

		manageSharedleadsTilesSort();
		Thread.sleep(1000);

		manageSharedleadsTilesEmailreports();

		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "EmailReportForAllTileSharedleads");
		Thread.sleep(2000);
		closefilter();
		Thread.sleep(1000);

		logger.info("Actions on all Shared Leads tiles completed.");
	}

	@Test(priority = 6, enabled = true)
	public void manageSharedLeadsValidTileActions() throws Exception {

		/*
		 * hoverOnSharedLeads();
		 * logger.debug("clicking on sharedlead in partner account.");
		 * Thread.sleep(9000);
		 */
		Thread.sleep(3000);
		logger.info("Starting actions on Valid Shared Leads tile.");

		XamplifyUtil.callClickEvent(properties.getProperty("sharedleadsValid"));
		Thread.sleep(3000);

		sharedleadsFilter();
		Thread.sleep(2000);

		manageSharedleadsTilesSort();
		Thread.sleep(2000);

		manageSharedleadsTilesEmailreports();
		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "EmailReportForValidTileSharedleads");
		logger.info("Email report for Valid Tile Shared Leads captured.");

		Thread.sleep(2000);

	}

	@Test(priority = 7, enabled = true)
	public void manageSharedLeadsExcludeTileActions() throws Exception {
		logger.info("Starting actions on Exclude Shared Leads tile.");

		Thread.sleep(2000);

		// Click "exclude" Share Leads

		WebDriverWait waitexcludetile = new WebDriverWait(driver, 30);
		// Wait for the exclude tile to be clickable
		WebElement excludetile = waitexcludetile.until(
				ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("sharedleads_exclude"))));

		int count = getCountValue();

		if (count > 0 && excludetile.isEnabled()) {
			excludetile.click();

			Thread.sleep(2000);

			sharedleadsFilter();
			Thread.sleep(2000);

			manageSharedleadsTilesSort();
			Thread.sleep(1000);

			manageSharedleadsTilesEmailreports();
			Thread.sleep(1000);
			XamplifyUtil.takeScreenshot(driver, "EmailReportForExcludeTileSharedleads");
			closefilter();
			Thread.sleep(1000);
		} else {
			System.out.println(
					"Sharedleads-exclude[from All] tile is disabled because its count is '0' or it's not visible.");
			logger.debug(
					"Sharedleads-exclude[from All] tile is disabled because its count is '0' or it's not visible.");

		}

	}

	@Test(priority = 8, enabled = true)
	public void manageSharedLeadsUndeliverableTileActions() throws Exception {
		logger.info("Starting actions on Undeliverable Shared Leads tile.");

		WebDriverWait waitundeliverabletile = new WebDriverWait(driver, 30);
		// Wait for the exclude tile to be clickable
		WebElement undeliverabletile = waitundeliverabletile.until(
				ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("sharedleads_undeliverable"))));

		if (count > 0 && undeliverabletile.isEnabled()) {
			logger.info("Undeliverable tile is enabled, clicking.");
			undeliverabletile.click();

			Thread.sleep(2000);

			sharedleadsFilter();
			Thread.sleep(2000);

			manageSharedleadsTilesSort();
			Thread.sleep(1000);

			manageSharedleadsTilesEmailreports();
			Thread.sleep(1000);

			XamplifyUtil.takeScreenshot(driver, "EmailReportForUndeliverableTile");
			logger.info("Email report for Undeliverable Tile Shared Leads captured.");

		} else {
			System.out.println("Undeliverabletile count is 0 & button is disabled, cannot click for shared leads.");
			logger.debug("Undeliverabletile count is 0 & button is disabled, cannot click for shared leads.");
		}
	}

	@Test(priority = 9, enabled = true)
	public void manageSharedLeadsUnsubscribeTileActions() throws Exception {
		logger.info("Starting Unsubscribe action on Shared Leads tile.");

		// Click "exclude" Share Leads

		WebDriverWait waitUnsubscribetile = new WebDriverWait(driver, 30);
		// Wait for the Unsubscribe tile to be clickable
		WebElement unUnsubscribetile = waitUnsubscribetile.until(
				ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("sharedleads_unsubscribe"))));

		int count = getCountValue();

		if (count > 0 && unUnsubscribetile.isEnabled()) {
			logger.info("Unsubscribe tile is enabled, proceeding to click.");
			unUnsubscribetile.click();

			Thread.sleep(2000);

			sharedleadsFilter();
			Thread.sleep(2000);

			manageSharedleadsTilesSort();
			Thread.sleep(1000);

			manageSharedleadsTilesEmailreports();
			Thread.sleep(1000);

			XamplifyUtil.takeScreenshot(driver, "EmailReportForUndeliverableTile");
			logger.info("Captured Email report for Unsubscribe Tile Shared Leads.");

		} else {
			System.out.println(
					"unsubscribetile[from All]  count is 0 & button is disabled, cannot click for shared leads.");
			logger.debug("Unsubscribe tile is either disabled or count is 0. Skipping click.");

		}
	}

	private int getCountValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Test(priority = 10, enabled = true)
	public void manageSharedLeadsSort() throws Exception {
		logger.info("Starting sorting actions on Shared Leads.");

		hoverOnSharedLeads();
		Thread.sleep(3000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageSharedSort"));
		Thread.sleep(3000);

		try {

			Thread.sleep(3000);

			// Assuming your property returns a valid XPath for the dropdown element
			By dropdownLocator1 = By.xpath(properties.getProperty("manageSharedSort"));

			// Wait a bit before the first interaction
			Thread.sleep(2000);

			// Select first option by value
			logger.info("Selecting sorting option '1: Object'");

			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "1: Object");
			Thread.sleep(2000);

			logger.info("Selecting sorting option '2: Object'");

			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "2: Object");
			Thread.sleep(1000);
			logger.info("Selecting sorting option '3: Object'");

			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "3: Object");
			Thread.sleep(1000);
			logger.info("Selecting sorting option '4: Object'");

			manageSharedleadsEditTilesSort(driver, dropdownLocator1, "4: Object");
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("Sorting action interrupted: " + e.getMessage());

			Thread.sleep(3000);

		}
	}

	@Test(priority = 11, enabled = true)
	public void manageSharedleadsGrid() throws Exception {
		logger.info("Managing Shared Leads Grid actions.");

		Thread.sleep(3000);

		XamplifyUtil.callClickEvent(properties.getProperty("manageSharedGrid"));

		Thread.sleep(2000);

		// WebDriverWait waitgrid = new WebDriverWait(driver, 20); // Wait for up to 20
		// seconds

		// WebElement shgrid = waitgrid.until(
		// ExpectedConditions.visibilityOfElementLocated(By.xpath()));
		// shgrid.click();

		// Handling grid element interaction
		WebElement shgrid = driver.findElement(By.xpath(properties.getProperty("manageSharedGridInfoicon")));

		Thread.sleep(2000);

		Actions grid = new Actions(driver);
		grid.moveToElement(shgrid).perform();
		Thread.sleep(3000);

		shgrid.click();
		Thread.sleep(2000);

		sharedleadsFilter();
		Thread.sleep(1000);

		manageSharedleadsTilesEmailreports();
		Thread.sleep(1000);

		filterSearch();
		Thread.sleep(1000);
		XamplifyUtil.takeScreenshot(driver, "GridforSharedLeads");
		logger.info("Grid management actions completed.");

	}

	@Test(priority = 12, enabled = true)
	public void manageSharedleadsSearch() throws Exception {

		hoverOnSharedLeads();
		Thread.sleep(3000);

		logger.info("Starting search action on Shared Leads.");

		XamplifyUtil.sendTextEvent(properties.getProperty("manageSharedSearch"), "Auto");
		Thread.sleep(1000);

		XamplifyUtil.sendKeyEvent(properties.getProperty("manageSharedSearch"), Keys.ENTER);
		Thread.sleep(2000);
		logger.info("Search for 'Auto' in Shared Leads executed.");

	}

}
