package com.xamplify.automation.tests;


import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.xamplify.automation.Instance;
import com.xamplify.automation.pages.ManageContactsPage;

public class ManageContactsTest {

    WebDriver driver = Instance.getInstance();
    ManageContactsPage manageContactsPage = new ManageContactsPage(driver);

    @Test(priority = 0, enabled = false)
    public void manageContactsEditOneAtATime() throws Exception {
        manageContactsPage.editContactOneAtATime();
    }

    @Test(priority = 1, enabled = false)
    public void manageContactsTabs() throws InterruptedException, SQLException {
        manageContactsPage.manageContactsTabs();
    }

    @Test(priority = 2, enabled = false)
    public void manageContactsEditCon() throws Exception {
        manageContactsPage.editContactDetails();
    }
    
    @Test(priority = 3, enabled = false)
    public void managecontactsViewSortby() throws InterruptedException {
        manageContactsPage.hoverOnContacts();
        manageContactsPage.viewSortByGrid();
        manageContactsPage.copyAndHandleListName();
    }

    @Test(priority = 4, enabled = false)
    public void managecontactsEditFilter() throws Exception {
        manageContactsPage.hoverOnContacts();
        manageContactsPage.clickEditAndApplyFilter();
    }

    @Test(priority = 5, enabled = false)
    public void managecontactsDeleteShareCampaigns() throws Exception {
        manageContactsPage.deleteListAndHandleShare();
    }

    @Test(priority = 6, enabled = false)
    public void managecontactsEditShare() throws InterruptedException, SQLException, IOException {
        ManageContactsPage contactsPage = new ManageContactsPage(driver);

        contactsPage.hoverOverContacts();
        Thread.sleep(2000);

     
        contactsPage.clickEditAndShare();

        if (contactsPage.isNoDataDisplayed()) {
            System.out.println("No data found on the page.");
            contactsPage.closeSharePopup();
        } else {
            try {
                contactsPage.selectAndShareCampaigns();
            } catch (Exception e) {
                System.out.println("Data not found ");
            }
        }
     
    }

        @Test(priority = 7, enabled = false)
        public void managecontactsEditTiles() throws InterruptedException, SQLException, IOException {
            
            
           
            
            ManageContactsPage contactsPage = new ManageContactsPage(driver);

            contactsPage.hoverOverContacts();
            
            
            
            manageContactsPage.clickEdit();
           
            manageContactsPage.clickValidTile();
            manageContactsPage.clickExport();
            manageContactsPage.clickAllTile();
            manageContactsPage.clickUnsubIcon();
            manageContactsPage.clickUnsubReason();
            manageContactsPage.selectUnsubReason();
            manageContactsPage.clickExcludeTile();
            manageContactsPage.clickUndeliverableTile();
            manageContactsPage.handleUnsubTile();
            manageContactsPage.deleteContact();
        }
        
        
        public void goToManageContactsJourney() throws InterruptedException, SQLException, IOException {
            //contacts_hover1(); // Assuming this is a utility method
        
        	
                ManageContactsPage mcontactsPage = new ManageContactsPage(driver);

                mcontactsPage.hoverOverContacts();
        	
            
            ManageContactsPage managePage = new ManageContactsPage(driver);
            managePage.openContactJourney();
        }
  
        
        
        @Test(priority = 9, enabled = true)
        public void managecontactsJourneyEdit() throws InterruptedException, SQLException, IOException {
           // contacts_hover1();  // assumed utility for hover
            
            ManageContactsPage mcontactsPage = new ManageContactsPage(driver);

            mcontactsPage.hoverOverContacts();
    	
            
            
            ManageContactsPage managePage = new ManageContactsPage(driver);
            managePage.openContactJourney();
            Thread.sleep(2000);
            managePage.editContactInJourney();
        }

        
       
        public void manage_contacts_notes() throws InterruptedException {
            ManageContactsPage managePage = new ManageContactsPage(driver);
            managePage.addContactNote();
        }

    
        @Test(priority = 10, enabled = false)
        public void managecontactsJourneyNote() throws InterruptedException, SQLException, IOException {
           // ContactJourneyPage journeyPage = new ContactJourneyPage(driver);
            ManageContactsPage managePagejrny = new ManageContactsPage(driver);
       	 managePagejrny.openContactJourney();
       	
       	managePagejrny.openContactJourney();
            managePagejrny.addNote();
            managePagejrny.takeScreenshot("Note_created_conjourney.png");
            System.out.println("Screenshot is captured for Note submission.");
        }
        @Test(priority = 11, enabled = false)
        public void managecontactsJourneyEmail() throws InterruptedException, SQLException, IOException {
            ManageContactsPage managePage = new ManageContactsPage(driver);

            managePage.openContactJourney();
            managePage.sendEmail();
            managePage.takeScreenshot("Email_sent_successfully_CJ.png");

            System.out.println("Screenshot captured for Email.");

            managePage.clickContactJourneyTask();
            
            
            managePage.contactsTask();
            managePage.takeScreenshot("Task_Submitted_Successfully_CJ.png");
        } 
        
       
        @Test(priority = 14,enabled=false)
        public void manageContactsJourneyActivityFilterSearch() throws InterruptedException, SQLException, IOException {
            Thread.sleep(2000); // Replace with page load wait if needed

           goToManageContactsJourney();
            manageContactsPage.searchActivity("title");

            manageContactsPage.selectFilter("Campaign");
            manageContactsPage.selectFilter("Lead");
            manageContactsPage.selectFilter("Deal");
            manageContactsPage.selectFilter("Note");
            manageContactsPage.selectFilter("Task");
        }
        @Test(priority = 15, enabled = true)
        public void manage_contacts_journey_notes_update() throws InterruptedException, IOException {
            ManageContactsPage journeyPage = new ManageContactsPage(driver);

            journeyPage.navigateToNotesTab();
            journeyPage.addNote2();
            journeyPage.applyNoteFilters();
            journeyPage.searchAndViewNote();
            journeyPage.editNote("U1");
            journeyPage.deleteNote();
        }
    
    
}
