package com.xamplify.automation.tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.pages.OpportunitiesPage;

public class OpportunitesTest {
	WebDriver driver;
	OpportunitiesPage opportunitiesPage;
    Properties props;
    private static final Logger logger = LogManager.getLogger(OpportunitesTest.class);

    @BeforeClass
    public void beforeClass() {
    	logger.info("Initializing WebDriver and opportuntiespage...");
        driver = Instance.getInstance();
        props = PropertiesFile.readPropertyFile("src/main/resources/Opportunities.properties");
        opportunitiesPage = new OpportunitiesPage(driver, props);
    }
	

	    @Test(priority = 1)
	    public void testValidateOpportunitiesManageLeadsDetails() {
	       // OpportunitiesPage opportunitiesPage = new OpportunitiesPage(null, null);
			// Step 1: Hover on Opportunities
	    	opportunitiesPage.userMouseOverOnOpportunities();

	       /* // Step 2: Hover on Manage Leads
	        OpportunitiesPage.userMouseOverOnManageLeads();

	        // Step 3: Click on Add Lead
	        OpportunitiesPage.clickAddLead();

	        // Step 4: Select company, pipeline, and stages
	        OpportunitiesPage.selectTheValuesOfCompanyPipelineandStages();

	        // Step 5: Fill the Add Lead details
	        OpportunitiesPage.fillTheAddLeadDetails();

	        // Step 6: Save lead
	        OpportunitiesPage.SaveLeadButton();

	        // Step 7: Click the leads tile (Won, Lost, Converted, Total)
	        OpportunitiesPage.clickTheLeadsTile();

	        // Step 8: Switch to Campaign View
	        OpportunitiesPage.listViewToCampaignView();

	        // Step 9: Preview view lead
	        OpportunitiesPage.clickViewLeadIcon();

	        // Step 10: Comment on campaign lead
	        OpportunitiesPage.clickCommentLeadIcon();

	        // Step 11: Edit campaign lead
	        OpportunitiesPage.clickEditLeadIcon();

	        // Step 12: Delete campaign lead
	        OpportunitiesPage.clickDeleteLeadIcon();

	        // Repeat Leads Tile Click
	        OpportunitiesPage.clickTheLeadsTile();

	        // Step 13: Switch back to List View
	        OpportunitiesPage.campaignViewToListView();

	        // Step 14: View Lead again
	        OpportunitiesPage.clickViewLeadIcon();

	        // Step 15: Edit Lead again
	        OpportunitiesPage.clickEditLeadIcon();

	        // Step 16: Comment again
	        OpportunitiesPage.clickCommentLeadIcon();

	        // Step 17: Delete again
	        OpportunitiesPage.clickDeleteLeadIcon();
*/
	        // Step 18: Click page dropdown (method to be implemented)
	        // OpportunitiesPage.clickPageDropDown(); // Implement this if needed
	    }
	}

	
	
	
	
	
	
	
	
	
	

