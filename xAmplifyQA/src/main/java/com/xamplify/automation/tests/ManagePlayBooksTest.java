
package com.xamplify.automation.tests;

import com.xamplify.automation.pages.ManagePlayBooksPage;
import com.xamplify.util.DriverFactory;
import com.xamplify.automation.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.AWTException;
import java.util.Properties;

public class ManagePlayBooksTest {

	private WebDriver driver;
	private ManagePlayBooksPage managePlayBooksPage;
	private Properties props;

	@BeforeClass
	public void setup() {
		// Initialize WebDriver and load properties
		driver = DriverFactory.getDriver();
		props = PropertiesFile
				.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\PlayBooks.properties");
		managePlayBooksPage = new ManagePlayBooksPage(driver, props);
	}

	@Test(priority = 0, enabled = true)
	public void testManageplaybook() throws InterruptedException, AWTException {
		// Step 1: Click on the Content menu to navigate
		managePlayBooksPage.clickContentMenu();

		// Step 2: Click on Manage PlayBooks
		managePlayBooksPage.clickManagePlayBooks();
		// Step 3: Click on edit playbook
		managePlayBooksPage.editactions();
		// Step 4: Click on Publish and Unpublish PlayBooks
		managePlayBooksPage.unpublishandpublish_playbook();
		// Step 4: Click on Preview playbook
		managePlayBooksPage.preview_playbook();
		// Step 5: Click on playbook Analytics
		managePlayBooksPage.playbook_analytics();
		// Step 6: Click on Sort,search and delete PlayBooks
		managePlayBooksPage.sortby_search_delete_playbook();
		// Step 7: Click on playbook Views
		managePlayBooksPage.playbookviews();

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
