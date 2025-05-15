package com.xamplify.automation.tests;



import com.xamplify.automation.pages.AddPlayBooksPage;
import com.xamplify.util.DriverFactory;
import com.xamplify.automation.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.AWTException;
import java.util.Properties;

public class AddPlayBooksTest {

    private WebDriver driver;
    private AddPlayBooksPage addPlayBooksPage;
    private Properties props;

    @BeforeClass
    public void setup() {
        // Initialize WebDriver and load properties
        driver = DriverFactory.getDriver();
        props = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\PlayBooks.properties");
        addPlayBooksPage = new AddPlayBooksPage(driver, props);
        //driver.get("https://your-app-url.com"); // Replace with actual URL of the application
    }

    @Test(priority = 0, enabled = true)
    public void testAddPlayBook() throws InterruptedException, AWTException {
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

