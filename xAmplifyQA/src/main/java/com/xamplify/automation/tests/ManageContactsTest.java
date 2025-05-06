package com.xamplify.automation.tests;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.xamplify.automation.Instance;
import com.xamplify.automation.pages.ManageContactsPage;

public class ManageContactsTest {

	WebDriver driver = Instance.getInstance();
	ManageContactsPage manageContactsPage = new ManageContactsPage(driver);
	

	@Test(priority = 0, enabled = true)
	public void manageContactsEditOneAtATime() throws Exception {
		manageContactsPage.editContactOneAtATime();
	}

	@Test(priority = 1, enabled = true)
	public void manageContactsTabs() throws InterruptedException, SQLException {
		manageContactsPage.manageContactsTabs();
	}

	@Test(priority = 2, enabled = true)
	public void manageContactsEditCon() throws Exception {
		manageContactsPage.editContactDetails();
	}

	@Test(priority = 3, enabled = true)
	public void managecontactsViewSortby() throws InterruptedException {
		manageContactsPage.hoverOnContacts();
		manageContactsPage.viewSortByGrid();
		manageContactsPage.copyAndHandleListName();
	}

	@Test(priority = 4, enabled = true)
	public void managecontactsEditFilter() throws Exception {
		manageContactsPage.hoverOnContacts();
		manageContactsPage.clickEditAndApplyFilter();
	}

	@Test(priority = 5, enabled = true)
	public void managecontactsDeleteShareCampaigns() throws Exception {
		manageContactsPage.deleteListAndHandleShare();
	}

	@Test(priority = 6, enabled = true)
	public void managecontactsEditShare() throws InterruptedException, SQLException, IOException {
		manageContactsPage.hoverOnContacts();
		manageContactsPage.editAndShareContact();

	}

	@Test(priority = 7, enabled = true)
	public void managecontactsEditTiles() throws InterruptedException, SQLException, IOException {

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
	}

	@Test(priority = 8, enabled = true)
	public void managecontactsJourneyEdit() throws InterruptedException, SQLException, IOException {

		// manageContactsPage.contactsHover1();

		manageContactsPage.openContactJourney();
		Thread.sleep(2000);
		manageContactsPage.editContactInJourney();
	}

	@Test(priority = 9, enabled = true)
	public void managecontactsJourneyNote() throws InterruptedException, SQLException, IOException {

		manageContactsPage.openContactJourney();

		manageContactsPage.addNote();
		manageContactsPage.takeScreenshot("Note_created_conjourney.png");
		System.out.println("Screenshot is captured for Note submission.");
	}

	@Test(priority = 10, enabled = true)
	public void managecontactsJourneyEmail() throws InterruptedException, SQLException, IOException {

		manageContactsPage.sendEmail();
		manageContactsPage.takeScreenshot("Email_sent_successfully_CJ.png");

		System.out.println("Screenshot captured for Email.");

	}

	@Test(priority = 11, enabled = true)
	public void managecontactsJourneyTask() throws InterruptedException, SQLException, IOException {

		manageContactsPage.clickContactJourneyTask();

		manageContactsPage.contactsTask();
		manageContactsPage.takeScreenshot("Task_Submitted_Successfully_CJ.png");
	}

	@Test(priority = 12, enabled = true)
	public void manageContactsJourneyActivityFilterSearch() throws InterruptedException, SQLException, IOException {
		Thread.sleep(2000);
		manageContactsPage.searchActivity("title");

		manageContactsPage.selectFilter("Campaign");
		manageContactsPage.selectFilter("Lead");
		manageContactsPage.selectFilter("Deal");
		manageContactsPage.selectFilter("Note");
		manageContactsPage.selectFilter("Task");
	}

	@Test(priority = 13, enabled = true)
	public void manageContactsJourneyNotesUpdate() throws Exception {

		manageContactsPage.openJourneyNotesTab();
		manageContactsPage.navigateToNotesTab();

		manageContactsPage.addNote();
		manageContactsPage.applyNoteFilters();
		manageContactsPage.searchAndViewNote();
		manageContactsPage.editNote("U1");
		manageContactsPage.deleteNote();
	}

	@Test(priority = 14, enabled = true)
	public void manageContactsJourneyEmailtabSort() throws InterruptedException, SQLException, IOException {

		manageContactsPage.openJourneyEmailTab();
		manageContactsPage.sendEmail();
		manageContactsPage.sortEmails();
		manageContactsPage.searchEmail("CJ");

	}

	@Test(priority = 15, enabled = true)
	public void manageContactsJourneyTasktabSort() throws InterruptedException, SQLException, IOException {

		// manageContactsPage.openContactJourney();

		manageContactsPage.performTaskTabSortAndCRUD();
	}

	@Test(priority = 16, enabled = true)
	public void managecontactsAllTiles() throws Exception {

		manageContactsPage.hoverOnContacts();
		manageContactsPage.completeAllTileJourney("Conlist1");
	}

	@Test(priority = 17, enabled = true)
	public void managecontactsTilesJourney() throws Exception {

		manageContactsPage.hoverOnContacts();
		manageContactsPage.clickOnValidTile();
		manageContactsPage.performTileOperations();
		manageContactsPage.clickValidTileEmailId();
		manageContactsPage.openNotesSection();
		manageContactsPage.addContactNote();
		manageContactsPage.sendEmail();
	}

}
