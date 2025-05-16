
package com.xamplify.automation.tests;

import com.xamplify.automation.pages.AccessSharedTracksPage;
import com.xamplify.util.DriverFactory;
import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.awt.AWTException;
import java.util.Properties;

public class AccessSharedTracksTest {

	private WebDriver driver;
	private AccessSharedTracksPage accessSharedTracksPage;
	private Properties props;
    private static final Logger logger = LogManager.getLogger(AccessSharedTracksTest.class);

	@BeforeClass
	public void setup() {
		// Initialize WebDriver and load properties
		driver = Instance.getInstance();
		props = PropertiesFile
				.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\AccessSharedTracks.properties");
		accessSharedTracksPage = new AccessSharedTracksPage(driver, props);
	}

	@Test(priority = 0, enabled = true)
	public void testAccessSharedTrack() throws InterruptedException, AWTException {
		// Step 1: Click on the Content menu to navigate
		
    	logger.info("Starting test: Clicking on content module to Add a Track");

		accessSharedTracksPage.clickContentMenu();

		// Step 2: Click on Access shared Tracks
		accessSharedTracksPage.clickAccesssharedTracks();
		
		
		// Step 3: click on sort_search actions
		accessSharedTracksPage.sortsearch_actions();
		
		// Step 4: Clickon View Tracks
		
		  accessSharedTracksPage.viewTracks();
		  
		  // Step 5: Click on asset2 view
		  accessSharedTracksPage.asset2view();
		  // Step 6: Click on asset3 view
		  accessSharedTracksPage.asset3view();
		  
		  // Step 7: Click on asset3 view 
		  accessSharedTracksPage.asset4view();
		 
		// Step 8: Clickon View Types
		  accessSharedTracksPage.viewtypes_accesssharedtracks();
	}
	
	
	
//	@AfterClass
//	public void tearDown() {
//	    if (driver != null) {
//	        try {
//	            driver.quit();
//	        } catch (Exception e) {
//	            System.out.println("Exception while quitting driver: " + e.getMessage());
//	        }
//	    }
//	}
}
