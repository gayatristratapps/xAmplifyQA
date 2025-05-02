
	package com.xamplify.automation.tests;

	import com.xamplify.automation.pages.AddTracksPage;
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
	        props = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Tracks.properties");
	        manageTracksPage = new ManageTracksPage(driver, props);
	        //driver.get("https://your-app-url.com"); // Replace with actual URL of the application
	    }

	    @Test(priority = 0, enabled = true)
	    public void testAddTrack() throws InterruptedException, AWTException {
	        // Step 1: Click on the Content menu to navigate
	    	manageTracksPage.clickContentMenu();

	        // Step 2: Click on Add Tracks
	    	manageTracksPage.clickManageTracks();
	    	manageTracksPage.actions();

}
	}
