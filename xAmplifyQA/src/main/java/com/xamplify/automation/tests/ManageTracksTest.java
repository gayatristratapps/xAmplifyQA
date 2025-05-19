
package com.xamplify.automation.tests;

import com.xamplify.automation.pages.ManageTracksPage;
import com.xamplify.util.DriverFactory;
import com.xamplify.automation.PropertiesFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.AWTException;
import java.util.Properties;

public class ManageTracksTest {
	private WebDriver driver;
	private ManageTracksPage manageTracksPage;
	private Properties props;
	private static final Logger logger = LogManager.getLogger(ManageTracksTest.class);

	@BeforeClass
	public void setup() {
		// Initialize WebDriver and load properties
		driver = DriverFactory.getDriver();
		props = PropertiesFile
				.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Tracks.properties");
		manageTracksPage = new ManageTracksPage(driver, props);

	}

	@Test(priority = 0, enabled = true)
	public void testclickManageTrack() throws InterruptedException, AWTException {
		logger.info("Starting test: testClicking on Content module");
		manageTracksPage.clickContentMenu();
		manageTracksPage.clickManageTracks();
		logger.info("Completed test: testClicked on manage tracks");

	}

	@Test(priority = 1, enabled = true)
	public void testedit_publishandunpublish_ManageTrack() throws InterruptedException, AWTException {
		logger.info("Starting test: testedit_publishandunpublish_ManageTrack");
		manageTracksPage.editactions();
		manageTracksPage.unpublishandpublish_track();
		logger.info("Completed test: testedit_publishandunpublish_ManageTrack");

	}

	@Test(priority = 2, enabled = true)
	public void testPreview_analytics_Track() throws InterruptedException, AWTException {
		logger.info("Starting test: testview_analytics_Track");
		manageTracksPage.preview_track();
		manageTracksPage.track_analytics();
		logger.info("Completed test: testPreview_analytics_Track");
	}
	
	@Test(priority = 3, enabled = true)
	public void testSortandView_analytics_Track() throws InterruptedException, AWTException {
		logger.info("Starting test: testSortandView_analytics_Track");
		manageTracksPage.sortby_search_delete_track();
		manageTracksPage.trackviews();
		logger.info("Completed test: testSortandView_analytics_Track");

	}

	
	   
	}


