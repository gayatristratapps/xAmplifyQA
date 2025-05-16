package com.xamplify.automation.tests;



import com.xamplify.automation.pages.AddPlayBooksPage;
import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.AWTException;
import java.util.Properties;

public class AddPlayBooksTest {

    private WebDriver driver;
    private AddPlayBooksPage addPlayBooksPage;
    private Properties props;
    private static final Logger logger = LogManager.getLogger(AddPlayBooksTest.class);

    @BeforeClass
    public void setup() {
        // Initialize WebDriver and load properties
		driver = Instance.getInstance();
        props = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\PlayBooks.properties");
        addPlayBooksPage = new AddPlayBooksPage(driver, props);
    }

    @Test(priority = 0, enabled = true)
    public void testAddPlayBook() throws InterruptedException, AWTException {
    	logger.info("Starting test: Clicking on content module to Add a PlayBook");

        // Step 1: Click on the Content menu to navigate
        addPlayBooksPage.clickContentMenu();

        // Step 2: Click on Add PlayBooks
        addPlayBooksPage.clickAddPlayBooks();

        // Step 3: Enter PlayBook Title
        addPlayBooksPage.enterPlayBookTitle();

        // Step 4: Select Folder
        addPlayBooksPage.selectFolder("xamplify2024-Default-Folder");

        // Step 5: Add Tags (example)
        addPlayBooksPage.addtags();    
        //step 6: Add Media/forms
        addPlayBooksPage.addmedia_and_form();
        
        // Step 7: Enter Description for the PlayBook
        addPlayBooksPage.enterDescription("PlayBook_Description");
        
        //step 8: Assets Selection
        addPlayBooksPage.assetselection();

        // Step 9: Publish the PlayBook
        addPlayBooksPage.publishPlayBook();
        
    	logger.info("Completed test: PlayBook Published Successfully");


        // Step 10: Validate Publish Confirmation Message
        String actualMessage = addPlayBooksPage.getPublishConfirmationMessage();
        String expectedMessage = "PlayBook created successfully";

        if (expectedMessage.equals(actualMessage)) {
            System.out.println("PlayBook published successfully!");
        } else {
            System.out.println("Error while publishing the PlayBook. Message: " + actualMessage);
        }
    }


//    @AfterClass
//	public void tearDown() {
//	    if (driver != null) {
//	        try {
//	            driver.quit();
//	        } catch (Exception e) {
//	            System.out.println("Exception while quitting driver: " + e.getMessage());
//	        }
//	    }
	}

