package com.xamplify.automation.tests;

import com.xamplify.automation.pages.AddTracksPage;
import com.xamplify.util.DriverFactory;
import com.xamplify.automation.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.AWTException;
import java.util.Properties;

public class AddTracksTest {

    private WebDriver driver;
    private AddTracksPage addTracksPage;
    private Properties props;

    @BeforeClass
    public void setup() {
        // Initialize WebDriver and load properties
        driver = DriverFactory.getDriver();
        props = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Tracks.properties");
        addTracksPage = new AddTracksPage(driver, props);
        //driver.get("https://your-app-url.com"); // Replace with actual URL of the application
    }

    @Test(priority = 0, enabled = true)
    public void testAddTrack() throws InterruptedException, AWTException {
        // Step 1: Click on the Content menu to navigate
        addTracksPage.clickContentMenu();

        // Step 2: Click on Add Tracks
        addTracksPage.clickAddTracks();

        // Step 3: Enter Track Title
        addTracksPage.enterTrackTitle();

        // Step 4: Select Folder
        addTracksPage.selectFolder("xamplify2024-Default-Folder");

        // Step 5: Add Tags (example)
        addTracksPage.addtags();    
        //step 6: Add Media/forms
        addTracksPage.addmedia_and_form();
        
        // Step 7: Enter Description for the Track
        addTracksPage.enterDescription("Track_Description");
        
        //step 8: Assets Selection
        addTracksPage.assetselection();

        // Step 9: Publish the Track
        addTracksPage.publishTrack();

        // Step 10: Validate Publish Confirmation Message
        String actualMessage = addTracksPage.getPublishConfirmationMessage();
        String expectedMessage = "Track created successfully";

        if (expectedMessage.equals(actualMessage)) {
            System.out.println("Track published successfully!");
        } else {
            System.out.println("Error while publishing the track. Message: " + actualMessage);
        }
        
    }
}


