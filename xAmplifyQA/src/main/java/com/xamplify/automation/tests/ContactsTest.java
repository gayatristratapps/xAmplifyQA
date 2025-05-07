package com.xamplify.automation.tests;

import com.xamplify.automation.pages.ContactsPage;
import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class ContactsTest {

    WebDriver driver;
    ContactsPage contactsPage;
    Properties props;
    private static final Logger logger = LogManager.getLogger(ContactsTest.class);

    @BeforeClass
    public void beforeClass() {
    	logger.info("Initializing WebDriver and ContactsPage...");
        driver = Instance.getInstance();
        props = PropertiesFile.readPropertyFile("src/main/resources/Contacts.properties");
        contactsPage = new ContactsPage(driver, props);
    }

    @Test(priority = 1, enabled=true)
    public void testAddContact_OneAtATime() throws Exception {
    	  logger.info("Starting test: Add Contact One At A Time");
          contactsPage.hoverContacts();
          contactsPage.clickAddContacts();
          contactsPage.completeOneAtATimeFlow();
          logger.info("Finished test: Add Contact One At A Time");
    }

    @Test(priority = 2, enabled=true)
    public void testUploadContacts_CSV() throws Exception {
    	 logger.info("Starting test: Upload Contacts via CSV");
         contactsPage.hoverContacts();
         contactsPage.clickAddContacts();
         contactsPage.uploadCSVAndHandle();
         logger.info("Finished test: Upload Contacts via CSV");
    }

	/*
	 * @AfterClass public void tearDown() { Instance.quitInstance();
	 * logger.info("Quitting WebDriver..."); }
	 */
}
