package com.xamplify.automation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xamplifycon.util.XamplifyUtil_contacts;

public class ManageContacts {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\ManageContacts.properties");

	final Logger logger = LogManager.getLogger(Contacts.class);

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

	@Test(priority = 0, enabled = true)

	public void managecontacts_edit_oneatatime() throws Exception {

		contacts_hover1();

		Thread.sleep(3000);

		logger.debug("clicking for edit in manage contacts ");

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit")); // click for edit
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_oneatatime"));

		Contacts.oneattime();

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_accept"));

	}

	@Test(priority = 2, enabled = true)

	public void managecontacts_edit_con() throws Exception {

		contacts_hover1();

		Thread.sleep(4000);

		logger.debug("clicking for edit in manage contacts ");

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit")); // click for edit
		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_editicon")); // click for edit
		Thread.sleep(2000);

		driver.findElement(By.id("lastName")).sendKeys("g");
		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_update")); // click for update

	}

	@Test(priority = 1, enabled = true)

	public void managecontactsTabs() throws InterruptedException, SQLException {

		logger.debug("Starting click on manage contacts");

		Thread.sleep(7000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_formcon_tab"));// click for formcontacts
		XamplifyUtil_contacts.sleepForTwoSeconds();
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_compcon_tab"));// click for company contacts
		XamplifyUtil_contacts.sleepForTwoSeconds();
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_allcon_tab")); // click for all contacts

		logger.debug("Tabs click done");

	}

	@Test(priority = 3, enabled = true)

	public void managecontactsViewSortby() throws InterruptedException, SQLException, IOException {

		contacts_hover1();

		// Click for grid view and wait until the search element is visible
		logger.debug("Clicking for grid view");
		Thread.sleep(9000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_gridview"));
		WebDriverWait wait = new WebDriverWait(driver, 60);

		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("mc_search"))));

		// Enter text "Auto" and press ENTER
		search.sendKeys("Auto", Keys.ENTER);

		Thread.sleep(2000);

		WebElement dropsort = driver.findElement(By.xpath(properties.getProperty("mc_sortby"))); // clickfor sort by

		Select dropdown = new Select(dropsort);

		Thread.sleep(5000);

		dropdown.selectByValue("1: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("2: Object");
		Thread.sleep(5000);

		dropdown.selectByValue("3: Object");
		Thread.sleep(5000);
		dropdown.selectByValue("4: Object");
		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_copyicon")); // click for copy icon
		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_copy_saveas")); // click for saveas icon

		Thread.sleep(3000);

		try {

			WebElement errmsg = driver.findElement(By.xpath(properties.getProperty("mc_existing")));
			String Actual_cres = errmsg.getText();
			String excepted_cres = "This list name is already taken.";
			Assert.assertEquals(excepted_cres, Actual_cres); // check for validation for exisitng list

			driver.findElement(By.xpath(properties.getProperty("mcon_listfield")))
					.sendKeys("_A1" + "_" + System.currentTimeMillis());
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("mc_copy_saveas"))).click();
			// click for save Thread.sleep(2000);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Test(priority = 4, enabled = true)

	public void managecontactsDeleteShareCampagins() throws InterruptedException, SQLException, IOException {
		Thread.sleep(3000);

		managecontactsTabs();
		Thread.sleep(3000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_delete"));// click for delete icon
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_yesdelete"));// click for yes delete
		Thread.sleep(4000);

		logger.debug("Deleted contact list successfully in  manage contacts ");

		WebElement dropsort = driver.findElement(By.xpath(properties.getProperty("mc_sortby"))); // clickfor sort by

		Select dropdown = new Select(dropsort);

		dropdown.selectByValue("3: Object");
		Thread.sleep(3000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_shareicon")); // click for share icon
		Thread.sleep(3000);

		// Check if "No Campaigns" message is displayed
		try {

			WebElement noCampaignsMessage = driver
					.findElement(By.xpath(properties.getProperty("mc_share_nocampaigns")));

			if (noCampaignsMessage.isDisplayed()) {
				System.out.println("No campaigns available.");
				// Close the popup if 'No Campaigns' message is displayed
				driver.findElement(By.xpath(properties.getProperty("mc_share_nocampaigns_close"))).click();
			}
		} catch (NoSuchElementException e) {
			// If 'No Campaigns' message is not found, proceed to select campaigns
			try {

				WebElement exc_msg2 = driver.findElement(By.xpath(properties.getProperty("mc_share_allcampaigns")));
				// if (exc_msg2.isDisplayed()) {
				exc_msg2.click();
				driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns"))).click(); // click for
				Thread.sleep(6000);
				// share
				driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns_close"))).click();
				Thread.sleep(3000);

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public static void conFilter() throws Exception {
		Thread.sleep(3000);

		WebElement fieldsort = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_fieldname"))); // click
		// for selecting fieldname

		Select fieldname = new Select(fieldsort);

		Thread.sleep(1000);
		fieldname.selectByVisibleText("City");
		Thread.sleep(1000);

		WebElement fieldsort2 = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_drop")));

		Select fieldname2 = new Select(fieldsort2);

		Thread.sleep(1000);
		fieldname2.selectByVisibleText("Contains");
		Thread.sleep(1000);

		WebElement fieldsort3 = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_value")));
		fieldsort3.sendKeys("HYDerabad");
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_filter_submit"));

		Thread.sleep(3000);

	}

	@Test(priority = 5, enabled = true)

	public void managecontactsEditFilter() throws Exception {
		Thread.sleep(2000);

		contacts_hover1();
		Thread.sleep(4000);

		logger.debug("clicking for edit in manage contacts ");

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit"));// click for edit

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_filter"));// click for filter

		Thread.sleep(2000);

		conFilter();
		Thread.sleep(2000);

		driver.findElement(By.id("checkAllExistingContacts")).click();
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_filter_newlist"));

		Thread.sleep(2000);

		WebElement mcon_legal = driver.findElement(By.xpath(properties.getProperty("mc_edit_legal")));
		mcon_legal.sendKeys("Legitimate interest - existing customer");// enter data for legal basis field
		mcon_legal.sendKeys(Keys.ENTER);// click enter in the keyboard
		mcon_legal.sendKeys("Legitimate interest - prospect/lead");// enter data for legal basis field
		mcon_legal.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(5000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_saveas"));

		Thread.sleep(4000);

	}

	@Test(priority = 6, enabled = true)

	public void managecontactsEditShare() throws InterruptedException, SQLException, IOException {

		contacts_hover1();

		Thread.sleep(3000);

		logger.debug("clicking for edit in manage contacts ");

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit")); // click for edit
		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_share"));
		Thread.sleep(2000);

		try {
			// Check for the presence of campaigns
			WebElement noDataElement = driver.findElement(By.xpath(properties.getProperty("mc_edit_share_text")));

			if (noDataElement.isDisplayed()) {
				System.out.println("No data found on the page.");

				XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_shareclose"));// click for close

			}

		} catch (NoSuchElementException e) {
			// "No campaigns Found" message is not displayed, proceed to select data

			try {

				WebElement exc_msg2 = driver.findElement(By.xpath(properties.getProperty("mc_share_allcampaigns")));
				exc_msg2.click();

				XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_share_campaigns"));

				// click for share
				Thread.sleep(4000);
				XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_share_campaigns_cls"));

				Thread.sleep(4000);

			} catch (NoSuchElementException ex) {
				System.out.println("Data not found or selection failed.");
			}
		}

	}

	@Test(priority = 7, enabled = true)

	public void managecontactsEditTiles() throws InterruptedException, SQLException, IOException {
		Thread.sleep(7000);

		WebDriverWait wait = new WebDriverWait(driver, 40); // Wait for up to 10 seconds

		// Hover and click for edit in manage contacts
		contacts_hover1();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit")))).click();

		logger.debug("clicking for edit in manage contacts ");

		// Wait until the tiles are visible and clickable
		WebElement tiles_click_valid = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_validtile"))));
		if (tiles_click_valid.isEnabled()) {
			tiles_click_valid.click(); // click for valid tile
			Thread.sleep(4000); // Delay for other actions
			// Click for export and other tiles
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_export"))))
					.click();
			Thread.sleep(2000);
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_alltile"))))
				.click();
		Thread.sleep(4000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_icon"))))
				.click();
		Thread.sleep(4000);

		// Similarly for unsubscribe and reason selections
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_reason"))))
				.click();
		Thread.sleep(4000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_reason_selected")))).click();
		Thread.sleep(3000);

		// Exclude tile check
		WebElement tiles_click = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_excludetile"))));
		if (tiles_click.isEnabled()) {
			tiles_click.click();
		} else {
			logger.debug("Exclude tile is disabled because its count is '0'");
		}
		Thread.sleep(2000);

		// Undeliverable tile check
		WebElement tiles_click2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_undel_tile"))));
		if (tiles_click2.isEnabled()) {
			tiles_click2.click();
		} else {
			logger.debug("Undeliverable tile is disabled because its count is '0'");
		}
		Thread.sleep(2000);

		// Unsubscribe tile check and resubscribe actions
		WebElement tiles_click3 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile"))));
		if (tiles_click3.isEnabled()) {
			tiles_click3.click();
			Thread.sleep(2000);

			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe")))).click();
			Thread.sleep(2000);

			WebElement subscribeComment = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe_comm"))));
			subscribeComment.sendKeys("test for resubscribing the contact");
			Thread.sleep(2000);

			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe_comm_submit"))))
					.click();
			Thread.sleep(2000);

			// Take Screenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,
					new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Resub_contact.png"));
			System.out.println("Screenshot is captured for resubscribed contact");
		} else {
			System.out.println("Unsubscribe tile is disabled because its count is '0'");
			logger.debug("Unsubscribe tile is disabled because its count is '0'");
		}

		// Perform deletion actions
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_alltile"))))
				.click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_deletecon1"))))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_deleteicon"))))
				.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_deleted"))))
				.click();
		Thread.sleep(6000);

		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Deletedcon_withinlist.png"));
		System.out.println("Screenshot is captured for deleted contact with in the list");

	}

	// @Test(priority = 8, enabled = true)

	public void manage_contacts_journey() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);

		contacts_hover1();

		Thread.sleep(3000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit")); // click for edit
		Thread.sleep(3000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney"));

		Thread.sleep(2000);
	}

	@Test(priority = 9, enabled = true)

	public void manage_contacts_journey_edit() throws InterruptedException, SQLException, IOException {

		manage_contacts_journey();
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_edit"));

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_lastname"))).sendKeys("-updateln");

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_address"))).sendKeys("-updateadress");

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_edit_update"));

		Thread.sleep(2000);
		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\conjourney_updatecon.png"));
		System.out.println("Screenshot is captured for updated contact for contact journey");

	}

	public void contactsNotes() throws InterruptedException {

		XamplifyUtil_contacts.enterText("mc_conjourney_note_title", "Ntitle1");
		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note_toggle"));
		Thread.sleep(4000);

		XamplifyUtil_contacts.enterText("mc_conjourney_note_textarea",
				"title description for note Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy ");

		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_savenote"));

	}

	@Test(priority = 10, enabled = true)

	public void manage_contactsjourney_note() throws InterruptedException, SQLException, IOException {

		manage_contacts_journey();

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note"));// click for note

		Thread.sleep(2000);

		contactsNotes();

		Thread.sleep(3000);
		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Note created_conjourney.png"));
		System.out.println("Screenshot is captured for Note submitted successfully for contact journey");

	}

	public void contactEmail() throws InterruptedException {

		XamplifyUtil_contacts.enterText("mc_conjourney_email_sub", "subj for email in CJ");
		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_email_CC"));

		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_conjourney_email_CCemail", "agayatri@stratapps.com");
		Thread.sleep(2000);

// to switch the frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("mc_conjourney_email_msg"))));
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello..Email");
		driver.switchTo().defaultContent();
		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourny_sndtestmail"));

		Thread.sleep(4000);

		XamplifyUtil_contacts.enterText("mc_conjourny_sndtestmail_text", "gayatrialla@tuta.com");
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_sndmail_button"));
		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_sndmail_button_ok"));
		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_sndmail_sent"));

		Thread.sleep(4000);
	}

	@Test(priority = 11, enabled = true)

	public void managecontactsjourneyEmail() throws InterruptedException, SQLException, IOException {

		manage_contacts_journey();
		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_email"));

		Thread.sleep(2000);

		contactEmail();

		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Email sent successfully_CJ.png"));
		System.out.println("Screenshot is captured for Email sent successfully for contact journey");

		
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task"));

		Thread.sleep(2000);

		contactsTask();

		Thread.sleep(2000);

		// Use TakesScreenshot method to capture screenshot
				TakesScreenshot screenshot3 = (TakesScreenshot) driver;
				// Saving the screenshot in desired location
				File source3 = screenshot3.getScreenshotAs(OutputType.FILE);
				// Path to the location to save screenshot
				FileUtils.copyFile(source3, new File(
						"D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Task Submitted Succesfully._CJ.png"));
				System.out.println("Screenshot is captured for Task Submitted Succesfully. for contact journey");

		
		
	}

	public void contactsTask() throws InterruptedException {

		// Wait for the page to load
		Thread.sleep(4000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_title", "Task title in CJ");
		Thread.sleep(3000);

		// Click on Assignee dropdown
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_assigclck"));
		Thread.sleep(3000);

		// Select "partner" as the assignee
		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", "partner");
		Thread.sleep(2000);

		// Press ENTER key
		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", Keys.ENTER.toString());
		Thread.sleep(2000);

		// Click on Status dropdown
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_assigclck_selctstatus"));
		Thread.sleep(2000);

		// Open Date Picker
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_calendr"));
		Thread.sleep(2000);
		/*
		 * // Define the target day (24th of the current month) String dayStr = "24";
		 * 
		 * System.out.println("Selecting date: " + dayStr);
		 */

		LocalDate tomorrow = LocalDate.now().plusDays(1);
		int day = tomorrow.getDayOfMonth();

		System.out.println(day);
		// Adjust the date format if needed (e.g., for "1", "01", etc.)
		String dayStr = (day < 10) ? "" + day : String.valueOf(day);
		String tomorrowMonth = tomorrow.getMonth().toString().toLowerCase(); // Get abbreviated month, e.g., "January"
		String tomorrowYear = String.valueOf(tomorrow.getYear());

		// Example: Print out the calculated tomorrow's date (for debugging purposes)
		System.out.println("Tomorrow's Date: " + tomorrowMonth + " " + dayStr + "," + tomorrowYear);

		try {
			// FluentWait to wait until the correct date is available and clickable
			Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

			// Ensure we select the correct 24th within the current month, avoiding disabled
			// dates
			WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[contains(@class,'open')]//span[not(contains(@class, 'disabled')) and text()='"
							+ dayStr + "']")));

			dateElement.click();
			Thread.sleep(2000); // Wait for UI transition

		} catch (TimeoutException e) {
			System.out.println("Date element not found: " + e.getMessage());
			driver.navigate().refresh();
		}

		Thread.sleep(3000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_selectrem"));

		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_rem"));

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elementtask = driver.findElement(By.xpath(properties.getProperty("mc_conjourney_task_scroll"))); // find
		// element

		// Scroll the element to the bottom

		js.executeScript("arguments[0].scrollBy(0, 200);", elementtask);

		// to switch the frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("mc_conjourney_task_textarea"))));
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello..Tsk assigned to you check it out");
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", "partner");
		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", "Keys.ENTER");
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_save"));

		Thread.sleep(2000);

	}



	@Test(priority = 13, enabled = true)

	public void managecontactsJourneyMeeting() throws InterruptedException, SQLException, IOException {

		manage_contacts_journey();
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_meeting"));

		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_meeting_sch"));

		Thread.sleep(2000);

	}

	@Test(priority = 14, enabled = true)

	public void managecontactsJourneyActivityFilterSearch() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);

		manage_contacts_journey();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_act_search"))).sendKeys("title");
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_act_search"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Locate the dropdown element
		WebElement dropdown = driver.findElement(By.xpath(properties.getProperty("mc_conjrny_act_filter"))); // Replace
																												// with
																												// the
																												// actual
																												// ID or
																												// locator
																												// of
																												// your
																												// dropdown

		// Create a Select object
		Select select = new Select(dropdown);

		// Select an option by visible text
		select.selectByVisibleText("Campaign");
		Thread.sleep(3000);

		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Campaign filter_act._CJ.png"));
		System.out.println("Screenshot is captured for Campaign filter in activity-contact journey");
		Thread.sleep(3000);

		select.selectByVisibleText("Lead");
		Thread.sleep(3000);// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot1 = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source1 = screenshot1.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source1,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\lead filter_act._CJ.png"));
		System.out.println("Screenshot is captured for lead filter in activity- contact journey");
		Thread.sleep(3000);

		select.selectByVisibleText("Deal");
		Thread.sleep(3000);
		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot2 = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source2 = screenshot2.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source2,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Deal filter_act._CJ.png"));
		System.out.println("Screenshot is captured for Deal filter in activity-contact journey");
		Thread.sleep(3000);
		select.selectByVisibleText("Note");
		Thread.sleep(3000);
		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot3 = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source3 = screenshot3.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source3,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Note filter_act._CJ.png"));
		System.out.println("Screenshot is captured for  Note filter in activity- contact journey");
		Thread.sleep(3000);
		select.selectByVisibleText("Task");
		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot4 = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source4 = screenshot4.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source4,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Task filter_act._CJ.png"));
		System.out.println("Screenshot is captured for Task filter in activity- contact journey");
		Thread.sleep(3000);

	}

	@Test(priority = 15, enabled = true)

	public void manage_contacts_journey_notes_update() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);

		manage_contacts_journey();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notestab"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_+"));

		Thread.sleep(2000);

		contactsNotes();

		Thread.sleep(3000);

		// Locate the dropdown element
		WebElement dropdown1 = driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_filter")));

		// Create a Select object
		Select select1 = new Select(dropdown1);

		// Select an option by visible text
		select1.selectByVisibleText("Created On(DESC)");
		Thread.sleep(3000);

		select1.selectByVisibleText("Title(Z-A)");
		Thread.sleep(3000);
		select1.selectByVisibleText("Title(A-Z)");
		Thread.sleep(3000);
		select1.selectByVisibleText("Created On(ASC)");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_search"))).sendKeys("title");
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_viewmore"));

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_viewmore_cls"));
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_edit"));
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_note_title"))).sendKeys("U1");
		Thread.sleep(4000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_savenote"));
		Thread.sleep(3000);

		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot4 = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source4 = screenshot4.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source4,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Note updated._CJ.png"));
		System.out.println("Screenshot is captured for Note updated - contact journey");
		Thread.sleep(3000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_refresh"));

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_del"));

		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_del_yes"));

		Thread.sleep(2000);
		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot6 = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source6 = screenshot6.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source6,
				new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Note deleted._CJ.png"));
		System.out.println("Screenshot is captured for Note deleted - contact journey");
		Thread.sleep(3000);

	}

	@Test(priority = 16, enabled = true)

	public void manage_contactsjourney_Emailtab_Sort() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);

		manage_contacts_journey();
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_emailtab"));

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_email+"));

		Thread.sleep(2000);

		contactEmail();

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_emailsort"));

		Thread.sleep(3000);

		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_emailsort", "Subject(A-Z)", 2000);
		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_emailsort", "Created On(ASC)", 2000);
		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_emailsort", "Subject(Z-A)", 3000);

		XamplifyUtil_contacts.enterText("mc_conjrny_email_search", "CJ");

		Thread.sleep(2000);
		// driver.findElement(By.xpath(properties.getProperty("mc_conjrny_email_search"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

	}

	@Test(priority = 17, enabled = true)

	public void manage_contactsjourney_TasktabSort() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);

		manage_contacts_journey();
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_tasktab"));

		Thread.sleep(3000);

		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_tasksort", "Created On(ASC)", 2000);
		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_tasksort", "Name(Z-A)", 3000);
		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_tasksort", "Name(A-Z)", 2000);

		XamplifyUtil_contacts.enterText("mc_conjrny_tasksearch", "cj");

		Thread.sleep(2000);

		// XamplifyUtil_contacts.enterText("mc_conjrny_tasksearch", "Keys.ENTER");

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_tasktab_add"));

		Thread.sleep(2000);

		contactsTask();

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_tasktab_editicon"));

		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_edittitle", "Up");

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_edit_tasktype"));

		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_save"));

		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_tasktab_delicon"));

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_tasktab_del_yes"));

		Thread.sleep(3000);

		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot8 = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source8 = screenshot8.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source8, new File(
				"D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Task Activity deleted Succesfully._CJ.png"));
		System.out.println("Screenshot is captured for Task Activity deleted for contact journey");

	}

	public static void selectDropdownByValueWithRetry(WebDriver driver, By locator, String value) {
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

	public static void tileOperations() throws Exception {

		Thread.sleep(3000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile_sort"));

		Thread.sleep(3000);

		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Assuming your property returns a valid XPath for the dropdown element
			By dropdownLocator = By.xpath(properties.getProperty("mc_alltile_sort"));

			// Wait a bit before the first interaction
			Thread.sleep(3000);

			// Select first option by value
			selectDropdownByValueWithRetry(driver, dropdownLocator, "1: Object");
			Thread.sleep(3000);

			// Select second option by value
			selectDropdownByValueWithRetry(driver, dropdownLocator, "2: Object");
			Thread.sleep(3000);

			selectDropdownByValueWithRetry(driver, dropdownLocator, "3: Object");
			Thread.sleep(3000);

			selectDropdownByValueWithRetry(driver, dropdownLocator, "4: Object");
			Thread.sleep(3000);

			selectDropdownByValueWithRetry(driver, dropdownLocator, "5: Object");
			Thread.sleep(3000);

			selectDropdownByValueWithRetry(driver, dropdownLocator, "6: Object");
			Thread.sleep(4000);

		} catch (InterruptedException e) {
			e.printStackTrace();

			Thread.sleep(2000);

		}

		XamplifyUtil_contacts.enterText("mc_alltile_search", "482");
		Thread.sleep(2000);

		WebElement searchBox = driver.findElement(By.xpath(properties.getProperty("mc_alltile_search")));

		// Send the Enter key to the input element
		searchBox.sendKeys(Keys.ENTER);

		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile_clckforemail"));

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_filter"));

		Thread.sleep(2000);

		conFilter();

		Thread.sleep(2000);

	}

	@Test(priority = 18, enabled = true)

	public void managecontactsAllTiles() throws Exception {

		contacts_hover1();

		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile"));

		Thread.sleep(2000);

		tileOperations();

		driver.findElement(By.id("checkAllExistingContacts")).click();
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile_gearicon"));
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile_gearicon_newlist"));

		Thread.sleep(2000);

		driver.findElement(By.id("campaignName")).sendKeys("Conlist1");
		Thread.sleep(3000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile_gearicon_newlist_legal"));
		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_alltile_gearicon_newlist_legal", "Legitimate interest - existing customer");
		Thread.sleep(3000);

		WebElement legal = driver.findElement(By.xpath(properties.getProperty("mc_alltile_gearicon_newlist_legal")));

		legal.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile_gearicon_newlist_legal_save"));
		Thread.sleep(3000);

		try {

			WebElement errmsg = driver.findElement(By.xpath(properties.getProperty("mconall_errmsg")));
			String Actual_res = errmsg.getText();
			String excepted_res = "This list name is already taken.";
			Assert.assertEquals(excepted_res, Actual_res); // check for validation for exisitng list

			driver.findElement(By.id("campaignName")).sendKeys("_G" + "_" + System.currentTimeMillis());
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("mc_alltile_gearicon_newlist_legal_save"))).click(); // click
																													// for
																													// save
			Thread.sleep(2000);

		} catch (Exception e1) {
			e1.printStackTrace();

		}

	}

	@Test(priority = 19, enabled = true)

	public void managecontactsAllTilesJourney() throws InterruptedException, SQLException, IOException {

		// driver.navigate().refresh();
		Thread.sleep(2000);
		contacts_hover1();

		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile"));

		Thread.sleep(4000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile_emailid"));
		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note"));

		Thread.sleep(2000);

		contactsNotes();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notestab"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_+"))).click();
		Thread.sleep(2000);
		contactsNotes();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_email"))).click();

		Thread.sleep(2000);

		contactEmail();

		Thread.sleep(2000);

		/*
		 * XamplifyUtil_contacts.callClickEvent(properties.getProperty(
		 * "mc_conjourney_task"));
		 * 
		 * Thread.sleep(2000);
		 * 
		 * contactsTask(); Thread.sleep(2000);
		 */

	}

	@Test(priority = 20, enabled = true)

	public void managecontactsTilesJourney() throws Exception {

		contacts_hover1();
		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_validtile"));

		tileOperations();
		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_validtile_emailid"));
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note"));// click for note

		Thread.sleep(2000);

		contactsNotes();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notestab"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_+"))).click();
		Thread.sleep(2000);
		contactsNotes();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_email"))).click();

		Thread.sleep(2000);

		contactEmail();

	}

}
