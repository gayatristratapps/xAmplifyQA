package com.xamplify.automation.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.pages.TeamVendorPage;

public class TeamVendorTest {

	private WebDriver driver;
	private TeamVendorPage teamVendorPage;

	private Properties props;
	private static final Logger logger = LogManager.getLogger(TeamVendorTest.class);

	@BeforeClass
	public void setup() {
		// Initialize WebDriver and load properties
		driver = Instance.getInstance();
		props = PropertiesFile
				.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\TeamVendor.properties");
		teamVendorPage = new TeamVendorPage(driver, props);
	}

	@Test(priority = 1)
	public void addTeamMemberTest() throws InterruptedException {

		logger.info("Starting test: Clicking on Hover Team module to Add a Team member");
		teamVendorPage.hoverTeam();
		teamVendorPage.addTeammember();
		logger.info("Finished test: Clicking on Add Team member");
	}

	@Test(priority = 2)
	public void inviteTeammemberTest() throws InterruptedException, AWTException {
		logger.info("Starting test: Clicking on Hover Team module to Invite a Team member");
		teamVendorPage.inviteTeammember();
		logger.info("Finished test: Clicking on Invite Team member");

	}

	@Test(priority = 3)
	public void testFileUpload() throws InterruptedException {
		logger.info("Starting test: Upload a Team member");

		teamVendorPage.testFileUpload();
		logger.info("Finished test: Uploaded a CSV file");
	}

	@Test(priority = 4)
	public void searchTeamMemberTest() throws InterruptedException {
		logger.info("Starting test: Search a Team member");
		teamVendorPage.searchTeamMember();
		logger.info("Finished test: Searched a Team member");
	}

	@Test(priority = 5)
	public void deleteUploadedMemberTest() throws InterruptedException {
		logger.info("Starting test: Deleting a Searched Team member");
		teamVendorPage.deleteSearchedMember();
		logger.info("Finished test: Deleted a Searched Team member");
	}

	@Test(priority = 6)
	public void exportTeamMembersTest() throws InterruptedException {
		logger.info("Starting test: Export Team members");
		teamVendorPage.exportTeamMembers();
		logger.info("Finished test: Exported Team members");
	}

	@Test(priority = 7)
	public void filterTeamMembersTest() throws InterruptedException {
		logger.info("Starting test: Appliying filter Team members");
		teamVendorPage.filterByEmailAndDate("automation.vendor2024@gmail.com");
		logger.info("Finished test: Applied filter Team members");
	}

	@Test(priority = 8)
	public void previewTeamMemberTest() throws InterruptedException {
		logger.info("Starting test: Previewing a Team members");
		teamVendorPage.PreviewTeamMember();
		logger.info("Finished test: previewed a Team members");
	}

	@Test(priority = 9)
	public void editTeamMemberTest() throws InterruptedException {
		logger.info("Starting test: Editing a Team members");
		teamVendorPage.editTeammember("Mounika_edited");
		logger.info("Finished test: Edited a Team members");
	}

	@Test(priority = 10)
	public void resendEmailTest() throws InterruptedException {
		logger.info("Starting test: Sending a notification to a Team members");
		teamVendorPage.resendEmailNotification();
		logger.info("Finished test: Sent a notification to a Team members");
	}

	@Test(priority = 11)
	public void deleteTeamMemberTest() throws InterruptedException {
		logger.info("Starting test: Deleting a Team member");
		teamVendorPage.deleteTeammember();
		logger.info("Starting test: Deleted a Team member");
	}

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
}
