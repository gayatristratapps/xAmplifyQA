
package com.xamplify.automation.tests;

import com.xamplify.automation.pages.ManageTracksPage;
import com.xamplify.util.DriverFactory;
import com.xamplify.automation.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.AWTException;
import java.util.Properties;

public class ManageTracksTest {

	private WebDriver driver;
	private ManageTracksPage manageTracksPage;
	private Properties props;

	@BeforeClass
	public void setup() {
		// Initialize WebDriver and load properties
		driver = DriverFactory.getDriver();
		props = PropertiesFile
				.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Tracks.properties");
		manageTracksPage = new ManageTracksPage(driver, props);
	}

	@Test(priority = 0, enabled = true)
	public void testManageTrack() throws InterruptedException, AWTException {
		// Step 1: Click on the Content menu to navigate
		manageTracksPage.clickContentMenu();

		// Step 2: Click on Manage Tracks
		manageTracksPage.clickManageTracks();
		// Step 3: Click on edit track
		manageTracksPage.editactions();
		// Step 4: Click on Publish and Unpublish Tracks
		manageTracksPage.unpublishandpublish_track();
		// Step 4: Click on Preview track
		manageTracksPage.preview_track();
		// Step 5: Click on Track Analytics
		manageTracksPage.track_analytics();
		// Step 6: Click on Sort,search and delete Tracks
		manageTracksPage.sortby_search_delete_track();
		// Step 7: Click on Track Views
		manageTracksPage.trackviews();

	}
	
	@AfterClass
	public void tearDown() {
	    if (driver != null) {
	        try {
	            driver.quit();
	        } catch (Exception e) {
	            System.out.println("Exception while quitting driver: " + e.getMessage());
	        }
	    }
	}
}
