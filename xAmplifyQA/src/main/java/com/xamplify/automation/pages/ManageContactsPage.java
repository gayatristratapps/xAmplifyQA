package com.xamplify.automation.pages;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.xamplify.automation.PropertiesFile;
import com.xamplify.util.ContactFormHelper;
import com.xamplify.util.XamplifyUtil;
import com.xamplifycon.util.XamplifyUtil_contacts;

public class ManageContactsPage {

	WebDriver driver;
	Properties properties;
	final Logger logger = LogManager.getLogger(ManageContactsPage.class);
	private ContactFormHelper contactHelper;
	private WebDriverWait wait;

	// Constructor to load properties
	public ManageContactsPage(WebDriver driver) {
		this.driver = driver;
		this.properties = PropertiesFile.readMultiplePropertyFiles("src/main/resources/ManageContacts.properties",
				"src/main/resources/Contacts.properties");
		this.contactHelper = new ContactFormHelper(driver, properties); // Create an instance of ContactFormHelper
		this.wait = new WebDriverWait(driver, 40);
		logger.info("ManageContactsPage initialized with WebDriver: " + driver);
	}

	// Method to hover over contacts
	public void hoverOnContacts() throws InterruptedException {
		logger.info("Entering hoverOnContacts method");
		try {
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			WebElement con1 = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hovercontacts"))));
			con1.click();
			Actions actions = new Actions(driver);
			actions.moveToElement(con1).build().perform();
			WebElement acon1 = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Managecontacts"))));
			acon1.click();
			logger.info("Successfully hovered and clicked on contacts");
		} catch (Exception e) {
			logger.error("Error in hoverOnContacts method", e);
			throw e;
		}
	}

	// Method to edit contacts one at a time
	public void editContactOneAtATime() throws Exception {
		logger.info("Entering editContactOneAtATime method");
		try {
			hoverOnContacts();
			Thread.sleep(3000);
			logger.debug("Clicking for edit in manage contacts");

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit"));
			Thread.sleep(2000);
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_oneatatime"));
			Thread.sleep(1000);

			contactHelper.fillOneAtATimeForm();

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_accept"));
			logger.info("Successfully edited contact one at a time");
		} catch (Exception e) {
			logger.error("Error in editContactOneAtATime method", e);
			throw e; // Re-throw to allow higher-level handling
		}
	}

	// Method to edit contact details
	public void editContactDetails() throws Exception {
		logger.info("Entering editContactDetails method");
		try {
			hoverOnContacts();
			Thread.sleep(4000);
			logger.debug("Clicking for edit in manage contacts");

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit"));
			Thread.sleep(4000);
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_editicon"));
			Thread.sleep(2000);

			driver.findElement(By.id("lastName")).sendKeys("g");
			Thread.sleep(2000);

			XamplifyUtil.sendmobileTextEvent("mcon_mobileno", "+91 9490925009", driver, properties);
			Thread.sleep(2000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_update"));
			logger.info("Successfully edited contact details");
		} catch (Exception e) {
			logger.error("Error in editContactDetails method", e);
			throw e;
		}
	}

	// Method to click through the contact tabs
	public void manageContactsTabs() throws InterruptedException, SQLException {
		logger.info("Entering manageContactsTabs method");
		try {
			Thread.sleep(7000);
			logger.debug("Clicking on manage contacts tabs");

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_formcon_tab"));
			XamplifyUtil_contacts.sleepForTwoSeconds();
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_compcon_tab"));
			XamplifyUtil_contacts.sleepForTwoSeconds();
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_allcon_tab"));

			logger.info("Successfully clicked through the tabs");
		} catch (InterruptedException e) {
			logger.error("Error in manageContactsTabs method", e);
			throw e;
		}
	}

	public void viewSortByGrid() throws InterruptedException {
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_gridview"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("mc_search"))));
		search.sendKeys("Auto", Keys.ENTER);
		Thread.sleep(2000);

		Select dropdown = new Select(driver.findElement(By.xpath(properties.getProperty("mc_sortby"))));
		dropdown.selectByValue("1: Object");
		dropdown.selectByValue("2: Object");
		dropdown.selectByValue("3: Object");
		dropdown.selectByValue("4: Object");
		Thread.sleep(5000);
	}

	public void copyAndHandleListName() throws InterruptedException {
		// Click on the copy icon
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_copyicon"));
		Thread.sleep(3000);

		// Click on the "Save As" button
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_copy_saveas"));
		Thread.sleep(3000);

		try {
			WebDriverWait wait = new WebDriverWait(driver, (15));
			WebElement errmsg = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("mc_existing"))));

			String actualError = errmsg.getText().trim();
			String expectedError = "This list name is already taken.";

			Assert.assertEquals(actualError, expectedError, "Validation message mismatch");

			String uniqueListName = "Autocon_1_A1_" + System.currentTimeMillis();
			WebElement listField = driver.findElement(By.xpath(properties.getProperty("mcon_listfield")));
			listField.clear();
			listField.sendKeys(uniqueListName);

			// Click Save again
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_copy_saveas"));
			Thread.sleep(3000);

		} catch (TimeoutException e) {
			logger.info("No duplicate list name error. Proceeding normally.");
		} catch (AssertionError ae) {
			logger.error("Expected validation error not matched: " + ae.getMessage());
			throw ae;
		}
	}

	public void clickEditAndApplyFilter() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_filter")))).click();
		Thread.sleep(2000);

		applyFilterFields();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkAllExistingContacts"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_filter_newlist"))))
				.click();

		WebElement legalField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("mc_edit_legal"))));
		Thread.sleep(2000);
		legalField.sendKeys("Legitimate interest - existing customer", Keys.ENTER);
		legalField.sendKeys("Legitimate interest - prospect/lead", Keys.ENTER);

		// Click "Save As"
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_saveas")))).click();
		Thread.sleep(2000); // Allow validation to happen

		try {
			WebElement errmsg = driver.findElement(By.xpath(properties.getProperty("mconall_errmsg")));
			String actual_res = errmsg.getText();
			String expected_res = "This group name is already taken.";

			if (actual_res.equals(expected_res)) {
				System.out.println("Duplicate list name detected, appending timestamp...");

				WebElement nameField = driver.findElement(By.id("campaignName"));
				String originalName = nameField.getAttribute("value");
				String newName = originalName + "_" + System.currentTimeMillis();

				nameField.clear();
				nameField.sendKeys(newName);
				Thread.sleep(1000);

				// Retry Save As
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_saveas"))))
						.click();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException e) {
			System.out.println("No duplicate name validation error. Proceeding...");
		}

	}

	// Method to apply filter fields in contact management
	public void applyFilterFields() throws InterruptedException {
		logger.info("Entering applyFilterFields method");
		try {
			WebElement field = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_fieldname")));
			new Select(field).selectByVisibleText("City");
			Thread.sleep(1000);

			WebElement condition = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_drop")));
			new Select(condition).selectByVisibleText("Contains");
			Thread.sleep(1000);

			WebElement value = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_value")));
			value.sendKeys("HYDerabad");
			Thread.sleep(2000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_filter_submit"));
			Thread.sleep(3000);
			logger.info("Successfully applied filter fields");
		} catch (Exception e) {
			logger.error("Error in applyFilterFields method", e);
			throw e;
		}
	}

	// Method to delete a list and handle share operations
	public void deleteListAndHandleShare() throws InterruptedException {
		logger.info("Entering deleteListAndHandleShare method");
		try {
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_delete"));
			Thread.sleep(2000);
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_yesdelete"));
			Thread.sleep(4000);

			Select dropdown = new Select(driver.findElement(By.xpath(properties.getProperty("mc_sortby"))));
			dropdown.selectByValue("4: Object");
			Thread.sleep(2000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_shareicon"));
			Thread.sleep(3000);

			try {
				WebElement noCampaignsMsg = driver
						.findElement(By.xpath(properties.getProperty("mc_share_nocampaigns")));
				if (noCampaignsMsg.isDisplayed()) {
					driver.findElement(By.xpath(properties.getProperty("mc_share_nocampaigns_close"))).click();
					logger.info("No campaigns to share, operation completed");
					return;
				}
			} catch (NoSuchElementException e) {
				// fallback if no-campaigns element is not present
			}

			WebElement allCampaigns = driver.findElement(By.xpath(properties.getProperty("mc_share_allcampaigns")));
			allCampaigns.click();
			driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns"))).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns_close"))).click();
			logger.info("Successfully handled share operation");
		} catch (Exception e) {
			logger.error("Error in deleteListAndHandleShare method", e);
			throw e;
		}
	}

	public void goToManageContactsJourney() throws InterruptedException, SQLException, IOException {
		logger.info("Navigating to Manage Contacts Journey.");

		try {
			hoverOnContacts();
			openContactJourney();
		} catch (Exception e) {
			logger.info("Failed to navigate to Manage Contacts Journey: " + e.getMessage());
			throw e;
		}
	}

	public void editAndShareContact() throws InterruptedException, SQLException, IOException {
		logger.info("Editing and sharing contact.");

		try {
			clickEdit();
			Thread.sleep(3000);
			clickShare();

			WebElement noDataElement = driver.findElement(By.xpath(properties.getProperty("mc_edit_share_text")));
			String messageText = noDataElement.getText().trim();

			if (messageText.equalsIgnoreCase("No Campaigns Found.")) {
				logger.warn("No campaigns found to share. Closing popup.");
				Thread.sleep(2000);
				closeSharePopup();
				return;
			}
		} catch (NoSuchElementException e) {
			logger.info("No 'No Campaigns Found' message. Proceeding...");
		}

		try {
			selectCampaignAndShare();
		} catch (NoSuchElementException e) {
			logger.warn("Campaign selection elements not found.");
		}
	}

	private void clickShare() throws InterruptedException {
		logger.info("Starting the clickShare method.");

		try {
			logger.debug("Sleeping for 2 seconds before clicking share.");
			Thread.sleep(2000);

			logger.debug("Clicking the share element.");
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_share"));

			logger.debug("Sleeping for 2 seconds after clicking share.");
			Thread.sleep(2000);

			logger.info("clickShare method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in clickShare: ", e);
			throw e; // Rethrow exception after logging
		}
	}

	private void selectCampaignAndShare() throws InterruptedException {
		logger.info("Starting the selectCampaignAndShare method.");

		try {
			WebElement allCampaigns = driver.findElement(By.xpath(properties.getProperty("mc_share_allcampaigns")));
			logger.debug("Clicking on all campaigns.");
			allCampaigns.click();

			logger.debug("Clicking on share campaigns.");
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_share_campaigns"));
			Thread.sleep(4000);

			logger.debug("Clicking on close share campaigns.");
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_share_campaigns_cls"));
			Thread.sleep(4000);

			logger.info("selectCampaignAndShare method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in selectCampaignAndShare: ", e);
			throw e; // Rethrow exception after logging
		}
	}

	public void closeSharePopup() throws InterruptedException {
		logger.info("Starting the closeSharePopup method.");

		logger.debug("Clicking on the close share popup.");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_shareclose"));

		logger.info("closeSharePopup method completed successfully.");
	}

	public void selectAndShareCampaigns() throws InterruptedException {
		logger.info("Starting the selectAndShareCampaigns method.");

		try {
			logger.debug("Finding and clicking the 'All Campaigns' element.");
			WebElement allCampaigns = driver.findElement(By.xpath("mc_share_allcampaigns"));
			allCampaigns.click();

			logger.debug("Clicking on share campaigns.");
			XamplifyUtil_contacts.callClickEvent("mc_edit_share_campaigns");
			Thread.sleep(4000);

			logger.debug("Clicking on close share campaigns.");
			XamplifyUtil_contacts.callClickEvent("mc_edit_share_campaigns_cls");
			Thread.sleep(4000);

			logger.info("selectAndShareCampaigns method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in selectAndShareCampaigns: ", e);
			throw e;
		}
	}

	public void clickEdit() {
		logger.info("Starting the clickEdit method.");

		try {
			logger.debug("Waiting for the 'Edit' button to be clickable.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit")))).click();

			logger.info("clickEdit method completed successfully.");
		} catch (Exception e) {
			logger.error("Exception occurred in clickEdit: ", e);
		}
	}

	public void clickValidTile() throws InterruptedException {
		logger.info("Starting the clickValidTile method.");

		try {
			logger.debug("Waiting for the valid tile element to be clickable.");
			WebElement tile = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_validtile"))));

			if (tile.isEnabled()) {
				logger.debug("Valid tile is enabled, clicking the tile.");
				tile.click();
				Thread.sleep(4000);
			} else {
				logger.warn("Valid tile is not enabled.");
			}

			logger.info("clickValidTile method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in clickValidTile: ", e);
			throw e;
		}
	}

	public void clickExport() throws InterruptedException {
		logger.info("Starting the clickExport method.");

		try {
			logger.debug("Waiting for the 'Export' button to be clickable.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_export"))))
					.click();
			Thread.sleep(2000);

			logger.info("clickExport method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in clickExport: ", e);
			throw e;
		}
	}

	public void clickAllTile() throws InterruptedException {
		logger.info("Starting the clickAllTile method.");

		try {
			logger.debug("Waiting for the 'All Tile' element to be clickable.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_alltile"))))
					.click();
			Thread.sleep(4000);

			logger.info("clickAllTile method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in clickAllTile: ", e);
			throw e;
		}
	}

	public void clickUnsubIcon() throws InterruptedException {
		logger.info("Starting the clickUnsubIcon method.");

		try {
			logger.debug("Waiting for the 'Unsub Icon' element to be clickable.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_icon"))))
					.click();
			Thread.sleep(4000);

			logger.info("clickUnsubIcon method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in clickUnsubIcon: ", e);
			throw e;
		}
	}

	public void clickUnsubReason() throws InterruptedException {
		logger.info("Starting the clickUnsubReason method.");

		try {
			logger.debug("Waiting for the 'Unsub Reason' element to be clickable.");
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_reason"))))
					.click();
			Thread.sleep(4000);

			logger.info("clickUnsubReason method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in clickUnsubReason: ", e);
			throw e;
		}
	}

	public void selectUnsubReason() throws InterruptedException {
		logger.info("Starting the selectUnsubReason method.");

		try {
			logger.debug("Waiting for the 'Unsub Reason Selected' element to be clickable.");
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_reason_selected")))).click();
			Thread.sleep(3000);

			logger.info("selectUnsubReason method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in selectUnsubReason: ", e);
			throw e;
		}
	}

	public void clickExcludeTile() throws InterruptedException {
		logger.info("Starting the clickExcludeTile method.");

		try {
			logger.debug("Waiting for the 'Exclude Tile' element to be clickable.");
			WebElement tile = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_excludetile"))));
			if (tile.isEnabled()) {
				tile.click();
				Thread.sleep(2000);
				logger.info("Exclude tile clicked successfully.");
			} else {
				logger.warn("Exclude tile is not enabled and could not be clicked.");
			}

			logger.info("clickExcludeTile method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in clickExcludeTile: ", e);
			throw e;
		}
	}

	public void clickUndeliverableTile() throws InterruptedException {
		logger.info("Starting the clickUndeliverableTile method.");

		try {
			logger.debug("Waiting for the 'Undeliverable Tile' element to be clickable.");
			WebElement tile = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_undel_tile"))));
			if (tile.isEnabled()) {
				tile.click();
				Thread.sleep(2000);
				logger.info("Undeliverable tile clicked successfully.");
			} else {
				logger.warn("Undeliverable tile is not enabled and could not be clicked.");
			}

			logger.info("clickUndeliverableTile method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("InterruptedException occurred in clickUndeliverableTile: ", e);
			throw e;
		}
	}

	public void handleUnsubTile() throws InterruptedException, IOException {
		logger.info("Starting the handleUnsubTile method.");

		try {
			logger.debug("Waiting for the 'Unsub Tile' element to be clickable.");
			WebElement tile = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile"))));
			if (tile.isEnabled()) {
				tile.click();
				logger.info("Unsub tile clicked.");
				Thread.sleep(2000);

				logger.debug("Waiting for the 'Subscribe' option to be clickable.");
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe"))))
						.click();
				Thread.sleep(2000);

				logger.debug("Waiting for the 'Comment Box' to be clickable.");
				WebElement commentBox = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe_comm"))));
				commentBox.sendKeys("test for resubscribing the contact");
				Thread.sleep(2000);

				logger.debug("Waiting for the 'Submit Comment' button to be clickable.");
				wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe_comm_submit")))).click();
				Thread.sleep(2000);

				logger.info("Capturing screenshot after resubscription.");
				captureScreenshot("Resub_contact.png");

				logger.info("handleUnsubTile method completed successfully.");
			} else {
				logger.warn("Unsub tile is not enabled and could not be clicked.");
			}
		} catch (InterruptedException | IOException e) {
			logger.error("Error occurred in handleUnsubTile: ", e);
			throw e;
		}
	}

	public void deleteContact() throws InterruptedException, IOException {
		logger.info("Starting the deleteContact method.");

		try {
			logger.debug("Clicking on 'All Tile' option.");
			clickAllTile();

			logger.debug("Waiting for 'Delete Contact' option to be clickable.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_deletecon1"))))
					.click();
			Thread.sleep(2000);

			logger.debug("Waiting for 'Delete Icon' to be clickable.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_deleteicon"))))
					.click();
			Thread.sleep(2000);

			logger.debug("Confirming contact deletion.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_deleted"))))
					.click();
			Thread.sleep(6000);

			logger.info("Capturing screenshot after contact deletion.");
			captureScreenshot("Deletedcon_withinlist.png");

			logger.info("deleteContact method completed successfully.");
		} catch (InterruptedException | IOException e) {
			logger.error("Error occurred in deleteContact: ", e);
			throw e;
		}
	}

	public void openContactJourney() throws InterruptedException, SQLException {
		logger.info("Starting the openContactJourney method.");

		try {
			Thread.sleep(2000);

			// contactsHover1();
			hoverOnContacts();

			logger.debug("Waiting for 'Edit' option to be clickable.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit")))).click();
			Thread.sleep(3000);

			logger.debug("Waiting for 'Contact Journey' option to be clickable.");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_conjourney"))))
					.click();
			Thread.sleep(2000);

			logger.info("openContactJourney method completed successfully.");
		} catch (InterruptedException e) {
			logger.error("Error occurred in openContactJourney: ", e);
			throw e;
		}
	}

	private void captureScreenshot(String fileName) throws IOException {
		try {
			logger.info("Capturing screenshot: {}", fileName);
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,
					new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\" + fileName));
			logger.info("Screenshot captured successfully: {}", fileName);
		} catch (IOException e) {
			logger.error("Error capturing screenshot: {}", fileName, e);
			throw e;
		}
	}

	public void editContactInJourney() throws InterruptedException, IOException {
		logger.info("Starting editContactInJourney method.");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_conjourney_edit"))))
					.click();
			logger.info("Clicked on 'Edit' for contact journey.");
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_lastname"))).sendKeys("-updateln");
			logger.info("Entered new last name: -updateln");
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_address")))
					.sendKeys("-updateadress");
			logger.info("Entered new address: -updateadress");
			Thread.sleep(2000);

			XamplifyUtil.sendmobileTextEvent("mcon_mobileno", "+91 9490925009", driver, properties);
			logger.info("Entered mobile number: +91 9490925009");
			Thread.sleep(2000);

			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(properties.getProperty("mc_conjourney_edit_update")))).click();
			logger.info("Clicked on 'Update' button.");
			Thread.sleep(2000);

			captureScreenshot("conjourney_updatecon.png");
		} catch (IOException | InterruptedException e) {
			logger.error("Error editing contact in journey.", e);
			throw e;
		}
		logger.info("editContactInJourney method completed successfully.");
	}

	public void addContactNote() throws InterruptedException {
		logger.info("Starting addContactNote method.");
		try {
			Thread.sleep(2000);
			XamplifyUtil_contacts.enterText("mc_conjourney_note_title", "Ntitle1");
			logger.info("Entered note title: Ntitle1");
			Thread.sleep(4000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note_toggle"));
			logger.info("Toggled note visibility.");
			Thread.sleep(4000);

			XamplifyUtil_contacts.enterText("mc_conjourney_note_textarea",
					"title description for note. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many websites still in their infancy.");
			logger.info("Entered note content.");
			Thread.sleep(2000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_savenote"));
			logger.info("Clicked on 'Save Note'.");
		} catch (InterruptedException e) {
			logger.error("Error adding contact note.", e);
			throw e;
		}
		logger.info("addContactNote method completed successfully.");
	}

	public void editContact() throws InterruptedException {
		logger.info("Starting editContact method.");
		try {
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_edit"));
			logger.info("Clicked on 'Edit' button for contact.");
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_lastname"))).sendKeys("-updateln");
			logger.info("Entered updated last name: -updateln");
			driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_address")))
					.sendKeys("-updateadress");
			logger.info("Entered updated address: -updateadress");
			Thread.sleep(2000);

			XamplifyUtil.sendmobileTextEvent("mcon_mobileno", "+91 9490925009", driver, properties);
			logger.info("Entered mobile number: +91 9490925009");
			Thread.sleep(2000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_edit_update"));
			logger.info("Clicked on 'Update' button for edited contact.");
		} catch (InterruptedException e) {
			logger.error("Error editing contact.", e);
			throw e;
		}
		logger.info("editContact method completed successfully.");
	}

	public void sendEmail() throws InterruptedException {
		logger.info("Starting sendEmail method.");
		try {
			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_email"));
			logger.info("Clicked on 'Email' in contact journey.");
			Thread.sleep(2000);

			XamplifyUtil_contacts.enterText("mc_conjourney_email_sub", "subj for email in CJ");
			logger.info("Entered subject for email: subj for email in CJ");
			Thread.sleep(4000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_email_CC"));
			logger.info("Clicked on CC button.");
			Thread.sleep(2000);

			XamplifyUtil_contacts.enterText("mc_conjourney_email_CCemail", "agayatri@stratapps.com");
			logger.info("Entered CC email: agayatri@stratapps.com");

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("mc_conjourney_email_msg"))));
			driver.findElement(By.xpath("html/body")).click();
			driver.switchTo().activeElement().sendKeys("Hello..Email");
			driver.switchTo().defaultContent();
			logger.info("Entered email body text: Hello..Email");
			Thread.sleep(4000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourny_sndtestmail"));
			Thread.sleep(4000);

			XamplifyUtil_contacts.enterText("mc_conjourny_sndtestmail_text", "gayatrialla@tuta.com");
			logger.info("Entered test email recipient: gayatrialla@tuta.com");
			Thread.sleep(2000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_sndmail_button"));
			logger.info("Clicked on 'Send Email' button.");
			Thread.sleep(2000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_sndmail_button_ok"));
			logger.info("Clicked on 'OK' button after sending the email.");
			Thread.sleep(2000);

			XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_sndmail_sent"));
			logger.info("Clicked on 'Sent' button after email was sent.");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			logger.error("Error sending email.", e);
			throw e;
		}
		logger.info("sendEmail method completed successfully.");
	}

	public void addNote() throws InterruptedException {
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note"));
		Thread.sleep(2000);
		XamplifyUtil_contacts.enterText("mc_conjourney_note_title", "Ntitle1");
		Thread.sleep(4000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note_toggle"));
		Thread.sleep(2500);
		XamplifyUtil_contacts.enterText("mc_conjourney_note_textarea", "Note content...");
		Thread.sleep(1500);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_savenote"));
	}

	public void takeScreenshot(String filename) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\" + filename));
	}

	public void clickContactJourneyTask() throws InterruptedException {
		logger.info("Clicking on the Contact Journey Task...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task"));
		logger.info("Contact Journey Task clicked.");
		Thread.sleep(2000);
	}

	public void contactsTask() throws InterruptedException {
		logger.info("Starting the contacts task...");

		Thread.sleep(4000);
		XamplifyUtil_contacts.enterText("mc_conjourney_task_title", "Task title in CJ");
		logger.info("Entered task title in CJ.");
		Thread.sleep(3000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_assigclck"));
		logger.info("Clicked on the task assignee.");
		Thread.sleep(3000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", "partner");
		logger.info("Assigned task to partner.");
		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", Keys.ENTER.toString());
		logger.info("Pressed Enter to confirm assignment.");
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_assigclck_selctstatus"));
		logger.info("Clicked on status selection.");
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_calendr"));
		logger.info("Clicked on calendar.");
		Thread.sleep(2000);

		LocalDate tomorrow = LocalDate.now().plusDays(1);
		String dayStr = String.valueOf(tomorrow.getDayOfMonth());

		int timeoutInSeconds = 10;

		try {
			logger.info("Selecting tomorrow's date...");
			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
					.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

			WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[contains(@class,'open')]//span[not(contains(@class, 'disabled')) and text()='"
							+ dayStr + "']")));
			dateElement.click();
			logger.info("Date selected: " + dayStr);
			Thread.sleep(2000);
		} catch (TimeoutException e) {
			logger.error("Date element not found: " + e.getMessage());
			driver.navigate().refresh();
		}

		Thread.sleep(3000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_selectrem"));
		logger.info("Clicked on select reminder.");
		Thread.sleep(4000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_rem"));
		logger.info("Clicked on reminder.");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elementtask = driver.findElement(By.xpath(properties.getProperty("mc_conjourney_task_scroll")));
		js.executeScript("arguments[0].scrollBy(0, 200);", elementtask);
		logger.info("Scrolled to the task element.");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("mc_conjourney_task_textarea"))));
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello..Tsk assigned to you check it out");
		driver.switchTo().defaultContent();
		logger.info("Entered text in the task comment.");
		Thread.sleep(4000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", "partner");
		logger.info("Re-assigned task to partner.");
		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", Keys.ENTER.toString());
		logger.info("Pressed Enter to confirm re-assignment.");
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_save"));
		logger.info("Clicked on Save to save the task.");
		Thread.sleep(2000);

		logger.info("Contacts task completed.");
	}

	public void searchActivity(String keyword) {
		logger.info("Searching for activity with keyword: {}", keyword);
		WebElement searchBox = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_conjrny_act_search"))));
		searchBox.clear();
		searchBox.sendKeys(keyword);
		searchBox.sendKeys(Keys.ENTER);
		logger.info("Search executed for keyword: {}", keyword);
	}

	public void selectFilter(String filterOption) throws InterruptedException {
		logger.info("Selecting filter option: {}", filterOption);
		WebElement dropdownElement = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_conjrny_act_filter"))));
		Select select = new Select(dropdownElement);
		Thread.sleep(2000);
		select.selectByVisibleText(filterOption);
		logger.info("Filter option selected: {}", filterOption);
	}

	public void openJourneyNotesTab() throws InterruptedException {
		logger.info("Opening Journey Notes tab...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notestab"));
		Thread.sleep(2000);
		logger.info("Journey Notes tab opened.");
	}

	public void navigateToNotesTab() throws InterruptedException {
		logger.info("Navigating to Notes tab...");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notestab"))).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		logger.info("Navigated to Notes tab.");
	}

	public void addNote2() throws InterruptedException {
		logger.info("Adding a new note...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_+"));
		Thread.sleep(1000);
		addNote();
		Thread.sleep(2000);
		logger.info("New note added.");
	}

	public void applyNoteFilters() throws InterruptedException {
		logger.info("Applying note filters...");
		Select select = new Select(driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_filter"))));
		select.selectByVisibleText("Created On(DESC)");
		select.selectByVisibleText("Title(Z-A)");
		select.selectByVisibleText("Title(A-Z)");
		select.selectByVisibleText("Created On(ASC)");
		logger.info("Note filters applied.");
		Thread.sleep(2000);
	}

	public void searchAndViewNote() throws InterruptedException {
		logger.info("Searching for note with keyword: 'title'...");
		driver.findElement(By.xpath(properties.getProperty("mc_conjrny_notes_search"))).sendKeys("title");
		Thread.sleep(1000);

		logger.info("Viewing more notes...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_viewmore"));
		Thread.sleep(1000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_viewmore_cls"));
		Thread.sleep(1000);
		logger.info("Finished viewing note.");
	}

	public void editNote(String updatedTitle) throws IOException, InterruptedException {
		logger.info("Editing note with updated title: {}", updatedTitle);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_edit"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_note_title"))).sendKeys(updatedTitle);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_savenote"));
		captureScreenshot("Note updated._CJ.png");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_refresh"));
		Thread.sleep(1000);
		logger.info("Note updated and refreshed.");
	}

	public void deleteNote() throws IOException, Exception {
		logger.info("Deleting note...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_del"));
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_notes_del_yes"));
		captureScreenshot("Note deleted._CJ.png");
		Thread.sleep(1000);
		logger.info("Note deleted.");
	}

	public void openJourneyEmailTab() throws InterruptedException {
		logger.info("Opening Journey Email tab...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_emailtab"));
		Thread.sleep(2000);
		logger.info("Journey Email tab opened.");
	}

	public void clickEmailPlus() throws InterruptedException {
		logger.info("Clicking on Email+...");
		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_email+"));
		Thread.sleep(2000);
		logger.info("Clicked on Email+.");
	}

	public void sortEmails() throws InterruptedException {
		logger.info("Sorting emails...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_emailsort"));
		Thread.sleep(3000);

		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_emailsort", "Subject(A-Z)", 2000);
		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_emailsort", "Created On(ASC)", 2000);
		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_emailsort", "Subject(Z-A)", 3000);
		logger.info("Emails sorted.");
	}

	public void searchEmail(String keyword) throws InterruptedException {
		logger.info("Searching for email with keyword: {}", keyword);
		XamplifyUtil_contacts.enterText("mc_conjrny_email_search", keyword);
		Thread.sleep(2000);
		logger.info("Email search completed.");
	}

	public void performTaskTabSortAndCRUD() throws InterruptedException, IOException {
		logger.info("Performing Task Tab sort and CRUD operations...");
		Thread.sleep(2000);
		XamplifyUtil_contacts.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_conjrny_tasktab"));
		Thread.sleep(3000);

		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_tasksort", "Created On(ASC)", 2000);
		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_tasksort", "Name(Z-A)", 3000);
		XamplifyUtil_contacts.selectDropdownOption("mc_conjrny_tasksort", "Name(A-Z)", 2000);

		XamplifyUtil_contacts.enterText("mc_conjrny_tasksearch", "cj");
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_conjrny_tasktab_add"));
		Thread.sleep(2000);

		// Assuming contactsTask() is reusable and present elsewhere
		new ManageContactsPage(driver).contactsTask();

		XamplifyUtil_contacts
				.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_conjrny_tasktab_editicon"));
		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_conjourney_task_edittitle", "Up");
		Thread.sleep(2000);

		XamplifyUtil_contacts
				.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_conjourney_task_edit_tasktype"));
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_conjourney_task_save"));
		Thread.sleep(2000);

		XamplifyUtil_contacts
				.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_conjrny_tasktab_delicon"));
		Thread.sleep(2000);

		XamplifyUtil_contacts
				.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_conjrny_tasktab_del_yes"));
		Thread.sleep(3000);

		// Screenshot
		TakesScreenshot screenshot8 = (TakesScreenshot) driver;
		File source8 = screenshot8.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source8, new File(
				"D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\Task Activity deleted Succesfully._CJ.png"));
		logger.info("Screenshot captured for Task Activity deleted successfully.");
	}

	public void openAllTiles() throws InterruptedException {
		logger.info("Opening All Tiles...");
		Thread.sleep(8000);
		XamplifyUtil_contacts.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_alltile"));
		Thread.sleep(2000);
		logger.info("All Tiles opened.");
	}

	public void createNewList(String baseListName) throws InterruptedException {
		logger.info("Creating new list with base name: {}", baseListName);
		driver.findElement(By.id("checkAllExistingContacts")).click();
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_alltile_gearicon"));
		Thread.sleep(2000);

		XamplifyUtil_contacts
				.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_alltile_gearicon_newlist"));
		Thread.sleep(2000);

		driver.findElement(By.id("campaignName")).sendKeys(baseListName);
		Thread.sleep(3000);

		XamplifyUtil_contacts
				.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_alltile_gearicon_newlist_legal"));
		Thread.sleep(2000);

		XamplifyUtil_contacts.enterText("mc_alltile_gearicon_newlist_legal", "Legitimate interest - existing customer");
		Thread.sleep(3000);

		WebElement legal = driver.findElement(
				By.xpath(XamplifyUtil_contacts.properties.getProperty("mc_alltile_gearicon_newlist_legal")));
		legal.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		XamplifyUtil_contacts
				.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_alltile_gearicon_newlist_legal_save"));
		Thread.sleep(3000);
		logger.info("New list created.");
	}

	public void validateOrCreateUniqueList(String baseListName) throws InterruptedException {
		try {
			logger.info("Validating or creating unique list...");
			WebElement errmsg = driver
					.findElement(By.xpath(XamplifyUtil_contacts.properties.getProperty("mconall_errmsg")));
			String actual = errmsg.getText();
			String expected = "This list name is already taken.";

			Assert.assertEquals(actual, expected); // validation check

			driver.findElement(By.id("campaignName")).sendKeys("_G" + "_" + System.currentTimeMillis());
			Thread.sleep(2000);
			driver.findElement(
					By.xpath(XamplifyUtil_contacts.properties.getProperty("mc_alltile_gearicon_newlist_legal_save")))
					.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			logger.error("Error occurred while validating or creating unique list", e);
		}
	}

	public void performTileOperations() throws Exception {
		logger.info("Performing Tile operations...");
		Thread.sleep(3000);
		XamplifyUtil_contacts.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_alltile_sort"));

		Thread.sleep(3000);
		try {
			Thread.sleep(3000);

			By dropdownLocator = By.xpath(XamplifyUtil_contacts.properties.getProperty("mc_alltile_sort"));

			// Select multiple options by value
			for (int i = 1; i <= 6; i++) {
				XamplifyUtil_contacts.selectDropdownByValueWithRetry(driver, dropdownLocator, i + ": Object");
				Thread.sleep(3000);
			}

		} catch (InterruptedException e) {
			logger.error("Error while performing Tile operations", e);
			e.printStackTrace();
			Thread.sleep(2000);
		}

		// Search and open email preview
		XamplifyUtil_contacts.enterText("mc_alltile_search", "482");
		Thread.sleep(2000);

		WebElement searchBox = driver
				.findElement(By.xpath(XamplifyUtil_contacts.properties.getProperty("mc_alltile_search")));
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(4000);

		XamplifyUtil_contacts.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_alltile_clckforemail"));
		Thread.sleep(2000);

		XamplifyUtil_contacts.callClickEvent(XamplifyUtil_contacts.properties.getProperty("mc_filter"));
		Thread.sleep(2000);

		applyFilterFields();
		Thread.sleep(2000);
		logger.info("Tile operations completed.");
	}

	public void completeAllTileJourney(String baseListName) throws Exception {
		logger.info("Completing All Tile Journey...");
		openAllTiles();
		XamplifyUtil_contacts.tileOperations();
		createNewList(baseListName);
		validateOrCreateUniqueList(baseListName);
		logger.info("All Tile Journey completed.");
	}

	public void clickValidTileEmailId() throws InterruptedException {
		logger.info("Clicking on Valid Tile Email ID...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_validtile_emailid"));
		Thread.sleep(2000);
		logger.info("Valid Tile Email ID clicked.");
	}

	public void clickOnValidTile() throws InterruptedException {
		logger.info("Clicking on Valid Tile...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_validtile"));
		Thread.sleep(4000);
		logger.info("Valid Tile clicked.");
	}

	public void openNotesSection() throws InterruptedException {
		logger.info("Opening Notes Section...");
		XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note"));
		Thread.sleep(2000);
		logger.info("Notes Section opened.");
	}

}
