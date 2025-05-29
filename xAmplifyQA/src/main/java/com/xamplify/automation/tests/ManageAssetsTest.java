
package com.xamplify.automation.tests;

import com.xamplify.automation.pages.ManageAssetsPage;
import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class ManageAssetsTest {

    WebDriver driver;
    ManageAssetsPage manageAssetsPage;
    Properties props;
    private static final Logger logger = LogManager.getLogger(ManageAssetsTest.class);

    @BeforeClass
    public void beforeClass() {
    	logger.info("Initializing WebDriver and ContentPage...");
        driver = Instance.getInstance();
        props = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Dam.properties");
        manageAssetsPage = new ManageAssetsPage(driver, props);
    }

    @Test(priority = 1, enabled=true)
    public void testcontent_hoverOnContentMenu() throws Exception {
    	  logger.info("Starting test: Hover on content module");
    	  manageAssetsPage.hoverOnContentMenu();
    	  manageAssetsPage.clickManageAssets();
//    	  manageAssetsPage.searchanddownloadAsset("png");
//    	 manageAssetsPage.asset_DownloadandpreviewEditActions("Update_png");
    	  //manageAssetsPage.replace_assets("\"D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\replace_png_file.png\"");
    }
    	  @Test(priority = 2, enabled=true)
    	    public void testcontent_ActionsOnContentMenu() throws Exception {
    		  
        	  manageAssetsPage.searchanddownloadAsset("mp4");
        	  manageAssetsPage.video_asset_Actions();
    		  
	 // manageAssetsPage.asset_filter_png();
 	  manageAssetsPage.views_png();

          logger.info("Finished test: Clicked on manage Assets");
    }
}