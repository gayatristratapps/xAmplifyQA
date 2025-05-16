
package com.xamplify.automation.tests;

import com.xamplify.automation.pages.ManagePlayBooksPage;
import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.AWTException;
import java.util.Properties;

public class ManagePlayBooksTest {

	private WebDriver driver;
	private ManagePlayBooksPage managePlayBooksPage;
	private Properties props;
	private static final Logger logger = LogManager.getLogger(ManagePlayBooksTest.class);

	@BeforeClass
	public void setup() {
		// Initialize WebDriver and load properties
		driver = Instance.getInstance();
		props = PropertiesFile
				.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\PlayBooks.properties");
		managePlayBooksPage = new ManagePlayBooksPage(driver, props);
	}

	@Test(priority = 0, enabled = true)
	public void testManageplaybook() throws InterruptedException, AWTException {
		logger.info("Starting test: testClicking on Content module");
		managePlayBooksPage.clickContentMenu();
		managePlayBooksPage.clickManagePlayBooks();
		logger.info("Completed test: testClicking on Content module");

	}
		@Test(priority = 1, enabled = true)
		public void testedit_publishandunpublish_playbook() throws InterruptedException, AWTException {	
			logger.info("Starting test: testedit_publishandunpublish_playbook");
		managePlayBooksPage.editactions();
		managePlayBooksPage.unpublishandpublish_playbook();
		logger.info("Completed test: testedit_publishandunpublish_playbook");

		}
		
		@Test(priority = 2, enabled = true)
		public void testpreview_analytics_playbook() throws InterruptedException, AWTException {	
		logger.info("Starting test: testpreview_analytics_playbook");
		managePlayBooksPage.preview_playbook();
		managePlayBooksPage.playbook_analytics();
		logger.info("Completed test: testpreview_analytics_playbook");
		}
		
		
		@Test(priority = 3, enabled = true)
		public void testSort_views_playbook() throws InterruptedException, AWTException {	
			logger.info("Starting test: testSort_views_playbook");
		managePlayBooksPage.sortby_search_delete_playbook();
		managePlayBooksPage.playbookviews();
		logger.info("Completed test: testSort_views_playbook");


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
	
}
