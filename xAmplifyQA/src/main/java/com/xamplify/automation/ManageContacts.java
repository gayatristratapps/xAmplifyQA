										package com.xamplify.automation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ManageContacts {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\ManageContacts.properties");

	final Logger logger = LogManager.getLogger(Contacts.class);

	@Test(priority = 1, enabled = true)

	public void contacts_hover1() throws InterruptedException, SQLException {

		logger.debug("start hover on contacts");

		Thread.sleep(5000);

		WebDriverWait wait_con = new WebDriverWait(driver, 50);

		// Wait till the element is not visible
		WebElement con1 = wait_con.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hovercontacts"))));// hover
																													// on
																													// contacts

		con1.click();
		Actions actions = new Actions(driver);
		WebElement contacts = driver.findElement(By.xpath(properties.getProperty("hovercontacts")));
		actions.moveToElement(contacts).build().perform();
		WebDriverWait wait_acon = new WebDriverWait(driver, 60);

		// Wait till the element is not visible
		WebElement acon1 = wait_acon.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Managecontacts"))));
		acon1.click();

	}

	@Test(priority = 2, enabled = true)

	public void managecontacts_tabs() throws InterruptedException, SQLException {

		logger.debug("Starting click on manage contacts");

		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("mc_formcon_tab"))).click(); // click for formcontacts

		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("mc_compcon_tab"))).click(); // click for company contacts
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("mc_allcon_tab"))).click(); // click for all contacts

		logger.debug("Tabs click done");

	}

	@Test(priority = 3, enabled = false)

	public void managecontacts_view_sortby() throws InterruptedException, SQLException, IOException {

		Thread.sleep(3000);
		logger.debug("clicking for grid view ");

		driver.findElement(By.xpath(properties.getProperty("mc_gridview"))).click(); // click for grid view
		Thread.sleep(2000);

		WebElement search = driver.findElement(By.xpath(properties.getProperty("mc_search"))); // click for search
		search.sendKeys("Auto");
		search.sendKeys(Keys.ENTER); // enter the data through sendkeys and enter through the keyboard.

		Thread.sleep(3000);
		logger.debug("Starting sortby option");

		WebElement dropsort = driver.findElement(By.xpath(properties.getProperty("mc_sortby"))); // click for sort by

		Select dropdown = new Select(dropsort);

		Thread.sleep(5000);

		dropdown.selectByValue("1: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("2: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("3: Object");
		Thread.sleep(5000);
		dropdown.selectByValue("4: Object");
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_copyicon"))).click(); // click for copy icon
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("mc_copy_saveas"))).click(); // click for saveas icon
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mc_delete"))).click(); // click for delete icon
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("mc_yesdelete"))).click(); // click for yes delete
		Thread.sleep(4000);
		logger.debug("Deleted contact list successfully in  manage contacts ");

		dropdown.selectByValue("3: Object");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mc_shareicon"))).click(); // click for share icon
		Thread.sleep(3000);

		try {

			WebElement exc_msg = driver.findElement(By.xpath(properties.getProperty("mc_share_nocampaigns")));

			if (exc_msg.isDisplayed()) {
				System.out.println("No data found on the page.");

				driver.findElement(By.xpath(properties.getProperty("mc_share_nocampaigns_close"))).click(); // click for
																											// close

			}

		} catch (Exception e1) {

			e1.printStackTrace();

			try {

				WebElement exc_msg = driver.findElement(By.xpath(properties.getProperty("mc_share_allcampaigns")));
				exc_msg.click();
				driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns"))).click(); // click for share
																									// campaigns button.
				Thread.sleep(2000);
				driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns_close"))).click(); // click for
																											// close
			} catch (Exception e11) {
				e11.printStackTrace();
			}
		}

	}

	/*
	 * try {
	 * 
	 * WebElement exc_msg =
	 * driver.findElement(By.xpath(properties.getProperty("mc_share_nocampaigns")));
	 * String Actual_res = exc_msg.getText(); String excepted_res =
	 * "No Campaigns Found."; Assert.assertEquals(excepted_res, Actual_res); //
	 * check for validation
	 * 
	 * driver.findElement(By.xpath(properties.getProperty(
	 * "mc_share_nocampaigns_close"))).click(); // click for // close
	 * Thread.sleep(2000);
	 * 
	 * } catch (Exception e1) {
	 * 
	 * e1.printStackTrace();
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * try {
	 * 
	 * 
	 * WebElement exc_msg =
	 * driver.findElement(By.xpath(properties.getProperty("mc_share_camp_header")));
	 * String Actual_res = exc_msg.getText(); String excepted_res = "Campaign Name";
	 * Assert.assertEquals(excepted_res, Actual_res); // check for validation
	 * 
	 * driver.findElement(By.xpath(properties.getProperty("mc_share_allcampaigns")))
	 * .click(); // click for share // icon Thread.sleep(2000);
	 * driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns"))).
	 * click(); // click for share // campaigns button. Thread.sleep(2000);
	 * driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns_close"
	 * ))).click(); // click for close // share // campaigns // button.
	 * 
	 * 
	 * } catch (Exception e1) { e1.printStackTrace();
	 * 
	 * 
	 * } }
	 */
	@Test(priority = 4, enabled = false)

	public void managecontacts_edit_filter() throws InterruptedException, SQLException, IOException {

		contacts_hover1();
		Thread.sleep(4000);

		logger.debug("clicking for edit in manage contacts ");

		driver.findElement(By.xpath(properties.getProperty("mc_edit"))).click(); // click for edit
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_filter"))).click(); // click for filter
		Thread.sleep(2000);

		WebElement fieldsort = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_fieldname"))); // click
																													// for
																													// selecting
																													// fieldname

		Select fieldname = new Select(fieldsort);

		Thread.sleep(3000);
		fieldname.selectByVisibleText("State");
		Thread.sleep(3000);

		WebElement fieldsort2 = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_drop")));

		Select fieldname2 = new Select(fieldsort2);

		Thread.sleep(3000);
		fieldname2.selectByVisibleText("Contains");
		Thread.sleep(3000);

		WebElement fieldsort3 = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_value")));
		fieldsort3.sendKeys("Telegana");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_submit"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkAllExistingContacts")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_newlist"))).click();
		Thread.sleep(2000);

		WebElement mcon_legal = driver.findElement(By.xpath(properties.getProperty("mc_edit_legal")));
		mcon_legal.sendKeys("Legitimate interest - existing customer");// enter data for legal basis field
		mcon_legal.sendKeys(Keys.ENTER);// click enter in the keyboard
		mcon_legal.sendKeys("Legitimate interest - prospect/lead");// enter data for legal basis field
		mcon_legal.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_edit_saveas"))).click();
		Thread.sleep(2000);

	}

	@Test(priority = 5, enabled = false)

	public void managecontacts_edit_share() throws InterruptedException, SQLException, IOException {

		contacts_hover1();

		Thread.sleep(3000);

		logger.debug("clicking for edit in manage contacts ");

		driver.findElement(By.xpath(properties.getProperty("mc_edit"))).click(); // click for edit
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_share"))).click(); // click for filter
		Thread.sleep(2000);

		try {
			// Check for the presence of campaigns
			WebElement noDataElement = driver.findElement(By.xpath(properties.getProperty("mc_edit_share_text")));

			if (noDataElement.isDisplayed()) {
				System.out.println("No data found on the page.");
				driver.findElement(By.xpath(properties.getProperty("mc_edit_shareclose"))).click(); // click for close

			}

		} catch (NoSuchElementException e) {
			// "No campaigns Found" message is not displayed, proceed to select data

			try {

				WebElement dataRow = driver.findElement(By.id("unPublished-campaigns-header-checkbox-id"));
				dataRow.click(); // Select the checkbox

				driver.findElement(By.xpath(properties.getProperty("mc_edit_share_campaigns"))).click(); // click for
																											// share
				driver.findElement(By.xpath(properties.getProperty("mc_edit_share_campaigns_cls"))).click(); // click
																												// for
																												// close

			} catch (NoSuchElementException ex) {
				System.out.println("Data not found or selection failed.");
			}
		}

		/*
		 * driver.findElement(By.xpath(properties.getProperty(
		 * "mc_edit_share_campaigns_cls"))).click(); // click for close
		 * Thread.sleep(2000); // driver.findElement(By.id("cancel_button"));
		 * Thread.sleep(3000);
		 */

	}

	@Test(priority = 6, enabled = true)

	public void managecontacts_edit_tiles() throws InterruptedException, SQLException, IOException {

		contacts_hover1();

		Thread.sleep(3000);

		logger.debug("clicking for edit in manage contacts ");

		driver.findElement(By.xpath(properties.getProperty("mc_edit"))).click(); // click for edit
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_validtile"))).click(); // click for valid tile
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_export"))).click(); // click for export
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("mc_edit_alltile"))).click(); // click for all tile
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_unsub_icon"))).click(); // click for unsubscribe
																							// icon
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_unsub_reason"))).click(); // click for reason
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_unsub_reason_selected"))).click(); // click for
																										// reason
		Thread.sleep(3000);

		WebElement tiles_click = driver.findElement(By.xpath(properties.getProperty("mc_edit_excludetile")));
		if (tiles_click.isEnabled()) {
			tiles_click.click();
		} else {

			logger.debug("Exclude tile is disabled because its count is '0'");

		}
		Thread.sleep(2000);

		WebElement tiles_click2 = driver.findElement(By.xpath(properties.getProperty("mc_edit_undel_tile")));
		if (tiles_click2.isEnabled()) {
			tiles_click2.click();
		} else {

			logger.debug("undeliverable tile is disabled because its count is '0'");

		}

		Thread.sleep(2000);

		WebElement tiles_click3 = driver.findElement(By.xpath(properties.getProperty("mc_edit_unsub_tile")));
		if (tiles_click3.isEnabled()) {
			tiles_click3.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe"))).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe_comm")))
					.sendKeys("test for resubscribing the contact");
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe_comm_submit"))).click();

			Thread.sleep(2000);

			// Use TakesScreenshot method to capture screenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			// Saving the screenshot in desired location
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			// Path to the location to save screenshot
			FileUtils.copyFile(source, new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Resub_contact.png"));
			System.out.println("Screenshot is captured for resubscribed contact");

		} else {
			System.out.println("Unsubscribe tile is disabled because its count is '0'");
			logger.debug("Unsubscribe tile is disabled because its count is '0'");

		}

		
		Thread.sleep(4000);

		
		driver.findElement(By.xpath(properties.getProperty("mc_edit_alltile"))).click(); // click for all tile
		Thread.sleep(3000);

		
		
		driver.findElement(By.xpath(properties.getProperty("mc_edit_deletecon1"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_deleteicon"))).click();
		Thread.sleep(2000);

			
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit_deleted"))).click();
		
		Thread.sleep(2000);

		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source, new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Deletedcon_withinlist.png"));
		System.out.println("Screenshot is captured for deleted contact with in the list");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}