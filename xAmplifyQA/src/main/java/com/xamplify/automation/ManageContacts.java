package com.xamplify.automation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import com.xamplifycon.util.XamplifyUtil_contacts;

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

	@Test(priority = 2, enabled = false)

	public void managecontacts_tabs() throws InterruptedException, SQLException {

		logger.debug("Starting click on manage contacts");

		Thread.sleep(6000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_formcon_tab"));// click for formcontacts
		XamplifyUtil_contacts.sleepForTwoSeconds();
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_compcon_tab"));// click for company contacts
		XamplifyUtil_contacts.sleepForTwoSeconds();
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_allcon_tab")); // click for all contacts

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

	}

	@Test(priority = 4, enabled = false)

	public void managecontacts__delete_sharecampagins() throws InterruptedException, SQLException, IOException {

		managecontacts_tabs();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mc_delete"))).click(); // click for delete icon
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("mc_yesdelete"))).click(); // click for yes delete
		Thread.sleep(4000);
		logger.debug("Deleted contact list successfully in  manage contacts ");

		WebElement dropsort = driver.findElement(By.xpath(properties.getProperty("mc_sortby"))); // clickfor sort by

		Select dropdown = new Select(dropsort);

		dropdown.selectByValue("3: Object");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mc_shareicon"))).click(); // click for share icon
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
				Thread.sleep(5000);
				// share
				driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns_close"))).click();
				Thread.sleep(3000);

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Test(priority = 5, enabled = false)

	public void managecontacts_edit_filter() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);

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
		Thread.sleep(3000);
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
		Thread.sleep(4000);

	}

	@Test(priority = 6, enabled = false)

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

				WebElement exc_msg2 = driver.findElement(By.xpath(properties.getProperty("mc_share_allcampaigns")));
				exc_msg2.click();
				driver.findElement(By.xpath(properties.getProperty("mc_edit_share_campaigns"))).click(); // click for
				Thread.sleep(4000);
				// share
				driver.findElement(By.xpath(properties.getProperty("mc_edit_share_campaigns_cls"))).click();
				Thread.sleep(4000);

			} catch (NoSuchElementException ex) {
				System.out.println("Data not found or selection failed.");
			}
		}

	}

	@Test(priority = 7, enabled = false)

	public void managecontacts_edit_tiles() throws InterruptedException, SQLException, IOException {
		Thread.sleep(4000);

		WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds

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

	@Test(priority = 8, enabled = false)

	public void manage_contacts_journey() throws InterruptedException, SQLException, IOException {

		contacts_hover1();

		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mc_edit"))).click(); // click for edit
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney"))).click();

		Thread.sleep(2000);
	}

	@Test(priority = 9, enabled = false)

	public void manage_contacts_journey_edit() throws InterruptedException, SQLException, IOException {

		manage_contacts_journey();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit"))).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_lastname"))).sendKeys("-updateln");
		;

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_address"))).sendKeys("-updateadress");

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_update"))).click();

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

	@Test(priority = 10, enabled = false)

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

	@Test(priority = 11, enabled = false)

	public void manage_contacts_journey_email() throws InterruptedException, SQLException, IOException {

		manage_contacts_journey();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_email"))).click();

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

	}

	public void contactsTask() throws InterruptedException {

		Thread.sleep(4000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_title", "Task title in CJ");
		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_assigclck"));

		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", "partner");
		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", "Keys.ENTER");
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_assigclck_selctstatus"));

		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_calendr"));

		Thread.sleep(2000);

		LocalDate tomorrow = LocalDate.now().plusDays(1);
		int day = tomorrow.getDayOfMonth();

		System.out.println(day);
		// Adjust the date format if needed (e.g., for "1", "01", etc.)
		String dayStr = (day < 10) ? "" + day : String.valueOf(day);
		String tomorrowMonth = tomorrow.getMonth().toString().toLowerCase(); // Get abbreviated month, e.g., "January"
		String tomorrowYear = String.valueOf(tomorrow.getYear());

		// Example: Print out the calculated tomorrow's date (for debugging purposes)
		System.out.println("Tomorrow's Date: " + tomorrowMonth + " " + dayStr + "," + tomorrowYear);

		// Now, select the day for tomorrow

		WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds

		// Use explicit wait for the calendar to load and be clickable
		WebElement tomorrowCell = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//html/body/div[2]/div[2]/div/div[2]/div/span[text()='" + dayStr + "']")));

		// Click on the date
		tomorrowCell.click();

		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_selectrem"));

		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_rem"));

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(properties.getProperty("mc_conjourney_task_scroll"))); // find
																												// element

		// Scroll the element to the bottom

		js.executeScript("arguments[0].scrollBy(0, 200);", element);

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

	@Test(priority = 12, enabled = false)

	public void manage_contacts_journey_task() throws InterruptedException, SQLException, IOException {

		manage_contacts_journey();
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task"));

		Thread.sleep(2000);

		contactsTask();

		// Use TakesScreenshot method to capture screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// Saving the screenshot in desired location
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		// Path to the location to save screenshot
		FileUtils.copyFile(source, new File(
				"D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Task Submitted Succesfully._CJ.png"));
		System.out.println("Screenshot is captured for Task Submitted Succesfully. for contact journey");

	}

	@Test(priority = 13, enabled = false)

	public void manage_contacts_journey_meeting() throws InterruptedException, SQLException, IOException {

		manage_contacts_journey();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_meeting"))).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_meeting_sch"))).click();
		Thread.sleep(2000);

	}

	@Test(priority = 14, enabled = false)

	public void manage_contacts_journey_activity_filter_search()
			throws InterruptedException, SQLException, IOException {
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

	@Test(priority = 15, enabled = false)

	public void manage_contacts_journey_notes_update() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);

		manage_contacts_journey();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notestab"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_+"))).click();
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

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_viewmore"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_viewmore_cls"))).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_edit"))).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_note_title"))).sendKeys("U1");
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_savenote"))).click();

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

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_refresh"))).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_del"))).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_del_yes"))).click();

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

	@Test(priority = 16, enabled = false)

	public void manage_contactsjourney_Emailtab_Sort() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);

		manage_contacts_journey();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_emailtab"))).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_email+"))).click();

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

	@Test(priority = 17, enabled = false)

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
	
	
	@Test(priority = 18, enabled = true)

	public void managecontactsAllTilesJourney() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);

		contacts_hover1();
		Thread.sleep(2000);

	XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_alltile"));
	
	
	
	}
	
	
	

}
