package com.xamplify.automation.tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.pages.ContactsPage;
import com.xamplify.automation.pages.SharedLeadsPage;
import com.xamplify.util.SharedLeadsUtil;
import com.xamplify.util.XamplifyUtil;

public class SharedLeadsTest {

	WebDriver driver;
	SharedLeadsPage sharedLeadsPage;
	SharedLeadsUtil sharedLeadsUtil;
	Properties properties;
	private static final Logger logger = LogManager.getLogger(SharedLeadsTest.class);

	@BeforeClass

	public void setup() {
		
		
		logger.info("Initializing WebDriver and sharedleadspage...");
        driver = Instance.getInstance();
       // props = PropertiesFile.readPropertyFile("src/main/resources/Contacts.properties");
        
		
        properties = PropertiesFile.readPropertyFile("src/main/resources/Sharedleads.properties");

		
		sharedLeadsUtil = new SharedLeadsUtil(driver);
		sharedLeadsPage = new SharedLeadsPage(driver, properties);

	}


	@Test(priority = 0, enabled = true)
    public void testSharedleadsListviewActionsAllTile() throws Exception {
        logger.info("Starting Shared Leads Listview Actions on All Tile.");

        sharedLeadsPage.hoverOnSharedLeads();
       
        sharedLeadsPage.clickInfoIcon();
	 
        sharedLeadsPage.applyAllEditTileSortOptions();

      //  sharedLeadsPage.filterSearch();
        sharedLeadsPage.manageSharedleadsTilesEmailreports();
        sharedLeadsPage.clickMoreLessButton();
        sharedLeadsPage.clickunsubscribeicon();
     
        sharedLeadsPage.applySharedLeadsFilter();
        logger.info("Completed Shared Leads Listview Actions on All Tile.");
    }
		
		
		
		
		
		

	@Test(priority = 1, enabled = true)
	public void SharedleadslistUnsubscribeTile() throws Exception {
		logger.info("Completed Shared Leads Listview Actions on All Tile.");
		sharedLeadsPage.sharedLeadsListUnsubscribeTile();

	}

	@Test(priority = 2, enabled = true)
	public void testSharedLeadsValidTileClick() throws Exception {
		int validTileCount = sharedLeadsPage.getValidTileCount();
		sharedLeadsPage.sharedLeadsEditListValidTile(validTileCount);

	}

	@Test(priority = 3, enabled = true)
	public void testSharedLeadsExcludeTileClick() throws Exception {
		int ExcludeTileCount = sharedLeadsPage.getExcludeTileCount();
		sharedLeadsPage.sharedLeadsEditListExcludeTile(ExcludeTileCount);

	}

	@Test(priority = 4, enabled = true)
	public void testSharedLeadsUndeliverableTileClick() throws Exception {
		int UndeliverableTileCount = sharedLeadsPage.getUndeliverableTileCount();
		sharedLeadsPage.sharedLeadsEditListExcludeTile(UndeliverableTileCount);

	}

	@Test(priority = 5, enabled = true)
	public void testManageAllSharedLeadsTileActions() throws Exception {
		sharedLeadsPage.manageAllSharedLeadsTileActions();
		logger.info("Actions on all Shared Leads tiles completed.");
	}

	@Test(priority = 6, enabled = true)
	public void testManageValidSharedLeadsTileActions() throws Exception {
		sharedLeadsPage.manageValidSharedLeadsTileActions();
	}

	@Test(priority = 7, enabled = true)
	public void testManageExcludeSharedLeadsTileActions() throws Exception {
		sharedLeadsPage.manageExcludeSharedLeadsTileActions();
	}

	@Test(priority = 8, enabled = true)
	public void testManageUndeliverableSharedLeadsTileActions() throws Exception {
		sharedLeadsPage.manageUndeliverableSharedLeadsTileActions();
	}

	@Test(priority = 9, enabled = true)
	public void testManageUnsubscribeSharedLeadsTileActions() throws Exception {
		sharedLeadsPage.manageUnsubscribeSharedLeadsTileActions();
	}

	@Test(priority = 10, enabled = true)
	public void testManageSharedLeadsSort() throws Exception {
		sharedLeadsPage.manageSharedLeadsSort();
	}

	@Test(priority = 11, enabled = true)
	public void testManageSharedLeadsGrid() throws Exception {
		sharedLeadsPage.manageSharedLeadsGrid();
	}

}