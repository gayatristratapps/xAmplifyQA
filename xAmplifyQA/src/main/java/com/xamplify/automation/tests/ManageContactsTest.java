package com.xamplify.automation.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.pages.ContactsPage;
import com.xamplify.automation.pages.ManageContactsPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ManageContactsTest {

	WebDriver driver;
	ManageContactsPage manageContactsPage;
	Properties properties;
	private static final Logger logger = LogManager.getLogger(ManageContactsTest.class);

	@BeforeClass
	public void setup() {
		// Initialize WebDriver and load properties
		// driver = DriverFactory.getDriver();
		driver = Instance.getInstance();
		properties = PropertiesFile.readPropertyFile("src\\main\\resources\\ManageContacts.properties");
		manageContactsPage = new ManageContactsPage(driver);

	}

	@Test(priority = 0, enabled = true)
	public void testEditContactOneAtATime() throws Exception {
		logger.info("Starting test: testEditContactOneAtATime");
		manageContactsPage.editContactOneAtATime();
		logger.info("Completed test: testEditContactOneAtATime");
	}

	@Test(priority = 1, enabled = true)
	public void testManageContactsTabs() throws InterruptedException, SQLException {
		logger.info("Starting test: testManageContactsTabs");
		manageContactsPage.manageContactsTabs();
		logger.info("Completed test: testManageContactsTabs");
	}

	@Test(priority = 2, enabled = true)
	public void testEditContactDetails() throws Exception {
		logger.info("Starting test: testEditContactDetails");
		manageContactsPage.editContactDetails();
		logger.info("Completed test: testEditContactDetails");
	}

	@Test(priority = 3, enabled = true)
	public void testViewSortByGrid() throws InterruptedException {
		logger.info("Starting test: testViewSortByGrid");
		manageContactsPage.hoverOnContacts();
		manageContactsPage.viewSortByGrid();
		manageContactsPage.copyAndHandleListName();
		logger.info("Completed test: testViewSortByGrid");
	}

	@Test(priority = 4, enabled = true)
	public void testApplyContactFilter() throws Exception {
		logger.info("Starting test: testApplyContactFilter");
		manageContactsPage.hoverOnContacts();
		manageContactsPage.clickEditAndApplyFilter();
		logger.info("Completed test: testApplyContactFilter");
	}

	@Test(priority = 5, enabled = true)
	public void testDeleteListAndHandleShare() throws Exception {
		logger.info("Starting test: testDeleteListAndHandleShare");
		manageContactsPage.deleteListAndHandleShare();
		logger.info("Completed test: testDeleteListAndHandleShare");
	}

	@Test(priority = 6, enabled = true)
	public void testEditAndShareContact() throws InterruptedException, SQLException, IOException {
		logger.info("Starting test: testEditAndShareContact");
		manageContactsPage.hoverOnContacts();
		manageContactsPage.editAndShareContact();
		logger.info("Completed test: testEditAndShareContact");
	}

	@Test(priority = 7, enabled = true)
	public void testEditTilesAndHandleOperations() throws InterruptedException, SQLException, IOException {
		logger.info("Starting test: testEditTilesAndHandleOperations");
		manageContactsPage.hoverOnContacts();
		manageContactsPage.clickEdit();
		manageContactsPage.clickValidTile();
		manageContactsPage.clickExport();
		manageContactsPage.clickAllTile();
		manageContactsPage.clickUnsubIcon();
		manageContactsPage.clickUnsubReason();
		manageContactsPage.selectUnsubReason();
		manageContactsPage.clickExcludeTile();
		manageContactsPage.clickUndeliverableTile();
		manageContactsPage.handleUnsubTile();
		manageContactsPage.deleteContact();
		logger.info("Completed test: testEditTilesAndHandleOperations");
	}

	@Test(priority = 8, enabled = true)
	public void testEditContactInJourney() throws InterruptedException, SQLException, IOException {
		logger.info("Starting test: testEditContactInJourney");
		manageContactsPage.openContactJourney();
		Thread.sleep(2000);
		manageContactsPage.editContactInJourney();
		logger.info("Completed test: testEditContactInJourney");
	}

	@Test(priority = 9, enabled = true)
	public void testAddNoteToContactJourney() throws InterruptedException, SQLException, IOException {
		logger.info("Starting test: testAddNoteToContactJourney");
		manageContactsPage.openContactJourney();
		manageContactsPage.addNote();
		manageContactsPage.takeScreenshot("Note_created_conjourney.png");
		logger.info("Screenshot captured for Note submission.");
		logger.info("Completed test: testAddNoteToContactJourney");
	}

	@Test(priority = 10, enabled = true)
	public void testSendEmailFromJourney() throws InterruptedException, SQLException, IOException {
		logger.info("Starting test: testSendEmailFromJourney");
		manageContactsPage.sendEmail();
		manageContactsPage.takeScreenshot("Email_sent_successfully_CJ.png");
		logger.info("Screenshot captured for Email.");
		logger.info("Completed test: testSendEmailFromJourney");
	}

	@Test(priority = 11, enabled = true)
	public void testSubmitTaskInJourney() throws InterruptedException, SQLException, IOException {
		logger.info("Starting test: testSubmitTaskInJourney");
		manageContactsPage.clickContactJourneyTask();
		manageContactsPage.contactsTask();
		manageContactsPage.takeScreenshot("Task_Submitted_Successfully_CJ.png");
		logger.info("Completed test: testSubmitTaskInJourney");
	}

	@Test(priority = 12, enabled = true)
	public void testSearchActivityAndApplyFilters() throws InterruptedException, SQLException, IOException {
		logger.info("Starting test: testSearchActivityAndApplyFilters");
		Thread.sleep(2000);
		manageContactsPage.searchActivity("title");
		manageContactsPage.selectFilter("Campaign");
		manageContactsPage.selectFilter("Lead");
		manageContactsPage.selectFilter("Deal");
		manageContactsPage.selectFilter("Note");
		manageContactsPage.selectFilter("Task");
		logger.info("Completed test: testSearchActivityAndApplyFilters");
	}

	@Test(priority = 13, enabled = true)
	public void testUpdateJourneyNotes() throws Exception {
		logger.info("Starting test: testUpdateJourneyNotes");
		manageContactsPage.openJourneyNotesTab();
		manageContactsPage.navigateToNotesTab();
		manageContactsPage.addNote();
		manageContactsPage.applyNoteFilters();
		manageContactsPage.searchAndViewNote();
		manageContactsPage.editNote("U1");
		manageContactsPage.deleteNote();
		logger.info("Completed test: testUpdateJourneyNotes");
	}

	@Test(priority = 14, enabled = true)
	public void testSortJourneyEmails() throws InterruptedException, SQLException, IOException {
		logger.info("Starting test: testSortJourneyEmails");
		manageContactsPage.openJourneyEmailTab();
		manageContactsPage.sendEmail();
		manageContactsPage.sortEmails();
		manageContactsPage.searchEmail("CJ");
		logger.info("Completed test: testSortJourneyEmails");
	}

	@Test(priority = 15, enabled = true)
	public void testSortAndPerformTaskTabOperations() throws InterruptedException, SQLException, IOException {
		logger.info("Starting test: testSortAndPerformTaskTabOperations");
		manageContactsPage.performTaskTabSortAndCRUD();
		logger.info("Completed test: testSortAndPerformTaskTabOperations");
	}

	@Test(priority = 16, enabled = true)
	public void testCompleteTileJourney() throws Exception {
		logger.info("Starting test: testCompleteTileJourney");
		manageContactsPage.hoverOnContacts();
		manageContactsPage.completeAllTileJourney("Conlist1");
		logger.info("Completed test: testCompleteTileJourney");
	}

	@Test(priority = 17, enabled = true)
	public void testPerformTileOperations() throws Exception {
		logger.info("Starting test: testPerformTileOperations");
		manageContactsPage.hoverOnContacts();
		manageContactsPage.clickOnValidTile();
		manageContactsPage.performTileOperations();
		manageContactsPage.clickValidTileEmailId();
		manageContactsPage.openNotesSection();
		manageContactsPage.addContactNote();
		manageContactsPage.sendEmail();
		logger.info("Completed test: testPerformTileOperations");
	}
}
