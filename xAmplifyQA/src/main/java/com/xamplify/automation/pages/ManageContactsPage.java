package com.xamplify.automation.pages;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.xamplify.automation.PropertiesFile;
import com.xamplify.util.ContactFormHelper;
import com.xamplify.util.XamplifyUtil;
import com.xamplifycon.util.XamplifyUtil_contacts;

public class ManageContactsPage {

    WebDriver driver;
    Properties properties;
    final Logger logger = LogManager.getLogger(ManageContactsPage.class);
	private ContactFormHelper contactHelper;
	private WebDriverWait wait;
    // Constructor to load properties
    public ManageContactsPage(WebDriver driver) {
        this.driver = driver;
       
        this.properties = PropertiesFile.readMultiplePropertyFiles(
        			    "src/main/resources/ManageContacts.properties",
        			    "src/main/resources/Contacts.properties");
        		
        		
        this.contactHelper = new ContactFormHelper(driver, properties);  // Create an instance of ContactFormHelper
        this.wait = new WebDriverWait(driver, 40);		
    }
    

    // Method to hover over contacts
    public void contactsHover1() throws InterruptedException, SQLException {
        logger.debug("Start hover on contacts");
        Thread.sleep(5000);

        WebDriverWait waitCon = new WebDriverWait(driver, 50);
        WebElement con1 = waitCon.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hovercontacts"))));
        con1.click();
        
        Actions actions = new Actions(driver);
        WebElement contacts = driver.findElement(By.xpath(properties.getProperty("hovercontacts")));
        actions.moveToElement(contacts).build().perform();
        
        WebDriverWait waitAcon = new WebDriverWait(driver, 60);
        WebElement acon1 = waitAcon.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Managecontacts"))));
        acon1.click();
    }

    // Method to edit contacts one at a time
    public void editContactOneAtATime() throws Exception {
        contactsHover1();
        Thread.sleep(3000);
        logger.debug("Clicking for edit in manage contacts");

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit"));
        Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_oneatatime"));
        Thread.sleep(1000);

        //Contacts.oneattime();
        
        contactHelper.fillOneAtATimeForm();  
        
        
        
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_accept"));
    }

    // Method to edit contact details
    public void editContactDetails() throws Exception {
        contactsHover1();
        Thread.sleep(4000);
        logger.debug("Clicking for edit in manage contacts");

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit"));
        Thread.sleep(4000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_editicon"));
        Thread.sleep(2000);

        driver.findElement(By.id("lastName")).sendKeys("g");
        Thread.sleep(2000);

        XamplifyUtil.sendmobileTextEvent("mcon_mobileno", "+91 9490925009", driver, properties);
        Thread.sleep(2000);

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_update"));
    }

    // Method to click through the contact tabs
    public void manageContactsTabs() throws InterruptedException, SQLException {
        logger.debug("Starting click on manage contacts");
        Thread.sleep(7000);

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_formcon_tab"));
        XamplifyUtil_contacts.sleepForTwoSeconds();
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_compcon_tab"));
        XamplifyUtil_contacts.sleepForTwoSeconds();
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_allcon_tab"));

        logger.debug("Tabs click done");
    }
    
    
    public void hoverOnContacts() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement con1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hovercontacts"))));
        con1.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(con1).build().perform();
        WebElement acon1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Managecontacts"))));
        acon1.click();
    }

    public void viewSortByGrid() throws InterruptedException {
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_gridview"));
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("mc_search"))));
        search.sendKeys("Auto", Keys.ENTER);
        Thread.sleep(2000);

        Select dropdown = new Select(driver.findElement(By.xpath(properties.getProperty("mc_sortby"))));
        dropdown.selectByValue("1: Object");
        dropdown.selectByValue("2: Object");
        dropdown.selectByValue("3: Object");
        dropdown.selectByValue("4: Object");
        Thread.sleep(5000);
    }

    public void copyAndHandleListName() throws InterruptedException {
        // Click on the copy icon
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_copyicon"));
        Thread.sleep(3000);

        // Click on the "Save As" button
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_copy_saveas"));
        Thread.sleep(3000);

        try {
            WebDriverWait wait = new WebDriverWait(driver, (15));
            WebElement errmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(properties.getProperty("mc_existing"))));

            String actualError = errmsg.getText().trim();
            String expectedError = "This list name is already taken.";

            Assert.assertEquals(actualError, expectedError, "Validation message mismatch");

       
            String uniqueListName = "Autocon_1_A1_" + System.currentTimeMillis();
            WebElement listField = driver.findElement(By.xpath(properties.getProperty("mcon_listfield")));
            listField.clear();
            listField.sendKeys(uniqueListName);

            // Click Save again
            XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_copy_saveas"));
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            logger.info("No duplicate list name error. Proceeding normally.");
        } catch (AssertionError ae) {
            logger.error("Expected validation error not matched: " + ae.getMessage());
            throw ae;
        }
    }

    
        public void clickEditAndApplyFilter() throws Exception {
            XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit"));
            Thread.sleep(2000);
            XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_filter"));
            Thread.sleep(2000);

            applyFilterFields();  // method call
            Thread.sleep(4000);

            driver.findElement(By.id("checkAllExistingContacts")).click();
            Thread.sleep(2000);
            XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_filter_newlist"));
            Thread.sleep(2000);

            WebElement legalField = driver.findElement(By.xpath(properties.getProperty("mc_edit_legal")));
            legalField.sendKeys("Legitimate interest - existing customer");
            legalField.sendKeys(Keys.ENTER);
            legalField.sendKeys("Legitimate interest - prospect/lead");
            legalField.sendKeys(Keys.ENTER);
            Thread.sleep(5000);

            XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_saveas"));
            Thread.sleep(4000);
        }

        //  Must also be outside other methods
        private void applyFilterFields() throws InterruptedException {
            WebElement field = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_fieldname")));
            new Select(field).selectByVisibleText("City");
            Thread.sleep(1000);

            WebElement condition = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_drop")));
            new Select(condition).selectByVisibleText("Contains");
            Thread.sleep(1000);

            WebElement value = driver.findElement(By.xpath(properties.getProperty("mc_edit_filter_value")));
            value.sendKeys("HYDerabad");
            Thread.sleep(2000);

            XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_filter_submit"));
            Thread.sleep(3000);
        }
    
    
    
    
    
    
 
    
    
    public void deleteListAndHandleShare() throws InterruptedException {
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_delete"));
        Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_yesdelete"));
        Thread.sleep(4000);

        Select dropdown = new Select(driver.findElement(By.xpath(properties.getProperty("mc_sortby"))));
        dropdown.selectByValue("4: Object");
        Thread.sleep(25000);

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_shareicon"));
        Thread.sleep(3000);

        try {
            WebElement noCampaignsMsg = driver.findElement(By.xpath(properties.getProperty("mc_share_nocampaigns")));
            if (noCampaignsMsg.isDisplayed()) {
                driver.findElement(By.xpath(properties.getProperty("mc_share_nocampaigns_close"))).click();
                return;
            }
        } catch (NoSuchElementException e) {
            // fallback if no-campaigns element is not present
        }

        try {
            WebElement allCampaigns = driver.findElement(By.xpath(properties.getProperty("mc_share_allcampaigns")));
            allCampaigns.click();
            driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns"))).click();
            Thread.sleep(8000);
            driver.findElement(By.xpath(properties.getProperty("mc_share_campaigns_close"))).click();
            Thread.sleep(3000);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    
    
    
    public void hoverOverContacts() throws InterruptedException {
        // Implement hover action here or call an existing utility
        Thread.sleep(2000); // placeholder
    }

    public void clickEditAndShare() throws InterruptedException {
    	Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent("mc_edit");
        Thread.sleep(4000);
        XamplifyUtil_contacts.callClickEvent("mc_edit_share");
        Thread.sleep(2000);
    }

    public boolean isNoDataDisplayed() {
        try {
            WebElement noDataElement = driver.findElement(By.xpath("mc_edit_share_text"));
            return noDataElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void closeSharePopup() throws InterruptedException {
        XamplifyUtil_contacts.callClickEvent("mc_edit_shareclose");
    }

    public void selectAndShareCampaigns() throws InterruptedException {
        WebElement allCampaigns = driver.findElement(By.xpath("mc_share_allcampaigns"));
        allCampaigns.click();
        XamplifyUtil_contacts.callClickEvent("mc_edit_share_campaigns");
        Thread.sleep(4000);
        XamplifyUtil_contacts.callClickEvent("mc_edit_share_campaigns_cls");
        Thread.sleep(4000);
    }
    
    
    public void clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit")))).click();
    }

    public void clickValidTile() throws InterruptedException {
        WebElement tile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_validtile"))));
        if (tile.isEnabled()) {
            tile.click();
            Thread.sleep(4000);
        }
    }

    public void clickExport() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_export")))).click();
        Thread.sleep(2000);
    }

    public void clickAllTile() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_alltile")))).click();
        Thread.sleep(4000);
    }

    public void clickUnsubIcon() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_icon")))).click();
        Thread.sleep(4000);
    }

    public void clickUnsubReason() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_reason")))).click();
        Thread.sleep(4000);
    }

    public void selectUnsubReason() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_reason_selected")))).click();
        Thread.sleep(3000);
    }

    public void clickExcludeTile() throws InterruptedException {
        WebElement tile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_excludetile"))));
        if (tile.isEnabled()) {
            tile.click();
            Thread.sleep(2000);
        }
    }

    public void clickUndeliverableTile() throws InterruptedException {
        WebElement tile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_undel_tile"))));
        if (tile.isEnabled()) {
            tile.click();
            Thread.sleep(2000);
        }
    }

    public void handleUnsubTile() throws InterruptedException, IOException {
        WebElement tile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile"))));
        if (tile.isEnabled()) {
            tile.click();
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe")))).click();
            Thread.sleep(2000);

            WebElement commentBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe_comm"))));
            commentBox.sendKeys("test for resubscribing the contact");
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_unsub_tile_subscribe_comm_submit")))).click();
            Thread.sleep(2000);

            captureScreenshot("Resub_contact.png");
        }
    }

    public void deleteContact() throws InterruptedException, IOException {
        clickAllTile();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_deletecon1")))).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_deleteicon")))).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_deleted")))).click();
        Thread.sleep(6000);

        captureScreenshot("Deletedcon_withinlist.png");
    }

    private void captureScreenshot(String fileName) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\" + fileName));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}