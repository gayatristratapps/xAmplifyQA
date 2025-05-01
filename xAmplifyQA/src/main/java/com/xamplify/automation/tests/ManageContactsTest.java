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

    @Test(priority = 0, enabled = true)
    public void manageContactsEditOneAtATime() throws Exception {
        manageContactsPage.editContactOneAtATime();
    }

    @Test(priority = 1, enabled = true)
    public void manageContactsTabs() throws InterruptedException, SQLException {
        manageContactsPage.manageContactsTabs();
    }

    @Test(priority = 2, enabled = true)
    public void manageContactsEditCon() throws Exception {
        manageContactsPage.editContactDetails();
    }
    
    @Test(priority = 3, enabled = true)
    public void managecontactsViewSortby() throws InterruptedException {
        manageContactsPage.hoverOnContacts();
        manageContactsPage.viewSortByGrid();
        manageContactsPage.copyAndHandleListName();
    }

    @Test(priority = 4, enabled = true)
    public void managecontactsEditFilter() throws Exception {
        manageContactsPage.hoverOnContacts();
        manageContactsPage.clickEditAndApplyFilter();
    }

    @Test(priority = 5, enabled = true)
    public void managecontactsDeleteShareCampaigns() throws Exception {
        manageContactsPage.deleteListAndHandleShare();
    }

    @Test(priority = 6, enabled = true)
    public void managecontactsEditShare() throws InterruptedException, SQLException, IOException {
        ManageContactsPage contactsPage = new ManageContactsPage(driver);

        contactsPage.hoverOverContacts();
        Thread.sleep(5000);

     
        contactsPage.clickEditAndShare();

        if (contactsPage.isNoDataDisplayed()) {
            System.out.println("No data found on the page.");
            contactsPage.closeSharePopup();
        } else {
            try {
                contactsPage.selectAndShareCampaigns();
            } catch (Exception e) {
                System.out.println("Data not found or selection failed.");
            }
        }
     
    }

        @Test(priority = 7, enabled = true)
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
        
        
        
  
        
        
        
       
    
    
    
    
}
