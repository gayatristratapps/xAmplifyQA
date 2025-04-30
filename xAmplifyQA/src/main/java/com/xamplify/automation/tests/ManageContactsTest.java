package com.xamplify.automation.tests;

import org.testng.annotations.*;

import com.xamplify.automation.Contacts;
import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.pages.ManageContactsPage;
import com.xamplify.util.ContactFormHelper;
import com.xamplify.util.XamplifyUtil;
import com.xamplifycon.util.XamplifyUtil_contacts;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageContactsTest {

	private WebDriver driver;
	private ManageContactsPage manageContactsPage;
	private WebDriverWait wait;

	private Properties props;

	@BeforeClass
	public void beforeClass() {
		driver = Instance.getInstance();
		props = PropertiesFile.readPropertyFile("src/main/resources/Contacts.properties");
		manageContactsPage = new ManageContactsPage(driver, props);
		wait = new WebDriverWait(driver, (120));

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	// Utility method for explicit wait on element
	private void waitForElement(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Optional reusable screenshot method
	private void captureScreenshot(String filePath) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(filePath));
	}

	@Test(priority = 0)
	public void testManageContactsEditOneAtATime() throws Exception {
		manageContactsPage.hoverOverContacts();
		manageContactsPage.clickForEdit();
		XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_edit_oneatatime"));

		
		
		
		
		ContactFormHelper contactHelper = new ContactFormHelper(driver, props);
		contactHelper.fillOneAtATimeForm();

		
		
		
		XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_accept"));
	}

	@Test(priority = 1)
	public void testManageContactsTabs() throws InterruptedException {
		manageContactsPage.hoverOverContacts();
		manageContactsPage.clickTab("mc_formcon_tab");
		manageContactsPage.clickTab("mc_compcon_tab");
		manageContactsPage.clickTab("mc_allcon_tab");
	}

	@Test(priority = 2)
	public void testManageContactsEdit() throws Exception {
		manageContactsPage.hoverOverContacts();
		manageContactsPage.clickForEdit();

		XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_editicon"));
		waitForElement(By.id("lastName"));
		driver.findElement(By.id("lastName")).sendKeys("g");

		XamplifyUtil_contacts.sendmobileTextEvent("mcon_mobileno", "+91 9490925009", driver, props);

		XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_edit_update"));
	}

	@Test(priority = 3)
	public void testManageContactsDeleteAndShare() throws InterruptedException {
		manageContactsPage.hoverOverContacts();
		manageContactsPage.deleteContactList();
		manageContactsPage.shareContactList();
	}

	@Test(priority = 4)
	public void manageContactsEditFilter() throws Exception {
		manageContactsPage.hoverAndClickForEdit();
		XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_edit_filter"));
		manageContactsPage.applyFilter("City", "Contains", "HYDerabad");
		manageContactsPage.applyAndSelectContacts();
		manageContactsPage.applyLegalBasis();
		XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_edit_saveas"));
	}

	@Test(priority = 6)
	public void manageContactsEditShare() throws SQLException, IOException, InterruptedException {
		manageContactsPage.hoverAndClickForEdit();
		manageContactsPage.shareContactList();
	}

	@Test(priority = 7)
	public void manageContactsEditTiles() throws SQLException, IOException, InterruptedException {
		manageContactsPage.hoverAndClickForEdit();
		manageContactsPage.editTiles();
		manageContactsPage.deleteContact();
	}

	@Test(priority = 9)
	public void manageContactsJourneyEdit() throws SQLException, IOException, InterruptedException {
		manageContactsPage.manageContactsJourney();
		waitForElement(By.xpath(props.getProperty("mc_conjourney_edit")));
		XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_conjourney_edit"));

		manageContactsPage.editContactJourney();
		manageContactsPage.updateContactJourney();
	}

	@Test(priority = 10)
	public void manageContactsJourneyNote() throws SQLException, IOException, InterruptedException {
		manageContactsPage.manageContactsJourney();
		manageContactsPage.contactsNotes();
	}

	@Test(priority = 11)
	public void manageContactsJourneyEmail() throws SQLException, IOException, InterruptedException {
		manageContactsPage.manageContactsJourney();
		manageContactsPage.contactEmail();
	}

	@Test(priority = 12)
	public void manageContactsJourneyTask() throws SQLException, IOException, InterruptedException {
		manageContactsPage.manageContactsJourney();
		manageContactsPage.contactsTask();
	}
}
