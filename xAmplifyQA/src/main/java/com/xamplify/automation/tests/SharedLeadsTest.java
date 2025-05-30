package com.xamplify.automation.tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.pages.SharedLeadsPage;
import com.xamplify.util.SharedLeadsUtil;

public class SharedLeadsTest {

    WebDriver driver;
    SharedLeadsPage sharedLeadsPage;
    SharedLeadsUtil sharedLeadsUtil;
    Properties props;
    private static final Logger logger = LogManager.getLogger(SharedLeadsTest.class);

    @BeforeClass
    public void beforeClass() {
        logger.info("Initializing WebDriver and SharedLeadsPage...");
        driver = Instance.getInstance();
        props = PropertiesFile.readPropertyFile("src/main/resources/Contacts.properties");
        sharedLeadsPage = new SharedLeadsPage();
        sharedLeadsUtil = new SharedLeadsUtil(driver);
    }

    @Test(priority = 0,enabled=true)
    public void testSharedLeadsListviewActions() throws Exception {
        sharedLeadsPage.hoverOnSharedLeads();

        Thread.sleep(5000);
        sharedLeadsUtil.clickInfoIcon();
        sharedLeadsUtil.clickEditSortDropdown();
        sharedLeadsUtil.selectSortOptions();

        sharedLeadsPage.searchWithFilter();
        sharedLeadsPage.emailReports();

        sharedLeadsUtil.clickMoreLessButton();
        sharedLeadsPage.unsubscribeLead();
        sharedLeadsPage.applyFilter();
    }
    @Test(dependsOnMethods = { "testSharedLeadsListviewActions" }, enabled=true)
    public void SharedleadslistUnsubscribeTile() throws Exception {
        sharedLeadsUtil.unsubscribeTileAction();
    }

	/*
	 * @Test(priority = 2, enabled = false) public void
	 * SharedleadsEditlistValidTile() throws Exception { int count = 1; // Replace
	 * with actual logic to fetch count if dynamic
	 * sharedLeadsUtil.clickValidTileIfPresent(count); }
	 */

    
	
	  @Test(priority = 2, enabled = true) public void
	  SharedleadsEditlistValidTile() throws Exception {
	  logger.info("Starting Valid Tile test.");
	    int count = sharedLeadsUtil.getTileCount("sharedlead_edit_valid");

	  sharedLeadsUtil.clickTileIfEnabled("sharedlead_edit_valid", "Valid", count);
	  }
	 

    @Test(priority = 3, enabled = true)
    public void SharedleadsEditlistExcludeTile() throws Exception {
        logger.info("Starting Exclude Tile test.");
        int count2 = sharedLeadsUtil.getTileCount("sharedlead_edit_exclude");

        sharedLeadsUtil.clickTileIfEnabled("sharedlead_edit_exclude", "Exclude", count2);
    }

    @Test(priority = 4, enabled = true)
    public void SharedleadsEditlistUndeliverableTile() throws Exception {
        logger.info("Starting Undeliverable Tile test.");
        int count3 = sharedLeadsUtil.getTileCount("sharedlead_edit_Undeliverable");

        sharedLeadsUtil.clickTileIfEnabled("sharedlead_edit_Undeliverable", "Undeliverable", count3);
    }

    @Test(priority = 5, enabled = true)
    public void manageSharedLeadsAllTileActions() throws Exception {
        logger.info("Starting All Tile Actions test.");
        sharedLeadsUtil.performAllTileActions();
        logger.info("All Tile actions completed.");
    }

    @Test(priority = 6, enabled = true)
    public void manageSharedLeadsValidTileActions() throws Exception {
        logger.info("Starting Valid Tile Actions test.");
        sharedLeadsUtil.performValidTileActions();
        logger.info("Valid Tile actions completed.");
    }
}
