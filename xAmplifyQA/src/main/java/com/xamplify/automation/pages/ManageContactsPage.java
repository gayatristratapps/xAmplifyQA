package com.xamplify.automation.pages;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
        WebDriverWait wait = new WebDriverWait(driver, 20);

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_filter")))).click();
        Thread.sleep(2000);

        applyFilterFields();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkAllExistingContacts"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_filter_newlist")))).click();

        WebElement legalField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(properties.getProperty("mc_edit_legal"))
        ));
        Thread.sleep(2000);
        legalField.sendKeys("Legitimate interest - existing customer", Keys.ENTER);
        legalField.sendKeys("Legitimate interest - prospect/lead", Keys.ENTER);

        // Click "Save As"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit_saveas")))).click();

		/*
		 * // Enter initial name WebElement nameInput =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.id("campaignName")));
		 * String initialName = "Autocon_" + System.currentTimeMillis();
		 * nameInput.clear(); nameInput.sendKeys(initialName);
		 */

        Thread.sleep(2000); // Allow validation to happen

        try {
            WebElement errmsg = driver.findElement(By.xpath(properties.getProperty("mconall_errmsg")));
            String actual_res = errmsg.getText();
            String expected_res = "This group name is already taken.";

            if (actual_res.equals(expected_res)) {
                System.out.println("Duplicate list name detected, generating new name...");
                driver.findElement(By.id("campaignName")).sendKeys("_G" + "_" + System.currentTimeMillis());
               
                Thread.sleep(2000);
            }
        } catch (Exception e1) {
            System.out.println("No duplicate name validation error. Proceeding...");
        }

        // Save
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath(properties.getProperty("mc_alltile_gearicon_newlist_legal_save")))).click();
        Thread.sleep(2000);
    }


    
	/*
	 * public void clickEditAndApplyFilter() throws Exception {
	 * XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit"));
	 * Thread.sleep(2000);
	 * XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_filter")
	 * ); Thread.sleep(2000);
	 * 
	 * applyFilterFields(); // method call Thread.sleep(4000);
	 * 
	 * driver.findElement(By.id("checkAllExistingContacts")).click();
	 * Thread.sleep(2000);
	 * XamplifyUtil_contacts.callClickEvent(properties.getProperty(
	 * "mc_edit_filter_newlist")); Thread.sleep(2000);
	 * 
	 * WebElement legalField =
	 * driver.findElement(By.xpath(properties.getProperty("mc_edit_legal")));
	 * legalField.sendKeys("Legitimate interest - existing customer");
	 * legalField.sendKeys(Keys.ENTER);
	 * legalField.sendKeys("Legitimate interest - prospect/lead");
	 * legalField.sendKeys(Keys.ENTER); Thread.sleep(5000);
	 * 
	 * XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_edit_saveas")
	 * ); Thread.sleep(4000); }
	 */

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
    
    
    
    
    
    public void openContactJourney() throws InterruptedException, SQLException {
        Thread.sleep(2000); // Optional: Only if needed for app stability

        // Perform hover - if not already handled globally
        // You might need to pass the hover logic or abstract it elsewhere
        contactsHover1();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_edit")))).click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_conjourney")))).click();
        Thread.sleep(2000);
    }

    public void editContactInJourney() throws InterruptedException, IOException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_conjourney_edit")))).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_lastname"))).sendKeys("-updateln");
        Thread.sleep(2000);

        driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_address"))).sendKeys("-updateadress");
        Thread.sleep(2000);

        XamplifyUtil.sendmobileTextEvent("mcon_mobileno", "+91 9490925009", driver, properties);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("mc_conjourney_edit_update")))).click();
        Thread.sleep(2000);

        // Screenshot
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\conjourney_updatecon.png"));
        System.out.println("Screenshot is captured for updated contact for contact journey");
    }

    public void addContactNote() throws InterruptedException {
    	 Thread.sleep(2000);

        XamplifyUtil_contacts.enterText("mc_conjourney_note_title", "Ntitle1");
        Thread.sleep(4000);

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note_toggle"));
        Thread.sleep(4000);

        XamplifyUtil_contacts.enterText("mc_conjourney_note_textarea",
            "title description for note. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many websites still in their infancy.");

        Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_savenote"));
    }
  
    public void editContact() throws InterruptedException {
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_edit"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_lastname"))).sendKeys("-updateln");
        driver.findElement(By.xpath(properties.getProperty("mc_conjourney_edit_address"))).sendKeys("-updateadress");
        Thread.sleep(2000);
        XamplifyUtil.sendmobileTextEvent("mcon_mobileno", "+91 9490925009", driver, properties);
        Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_edit_update"));
    }

    public void addNote() throws InterruptedException {
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note"));
        Thread.sleep(2000);
        XamplifyUtil_contacts.enterText("mc_conjourney_note_title", "Ntitle1");
        Thread.sleep(4000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_note_toggle"));
        Thread.sleep(4000);
        XamplifyUtil_contacts.enterText("mc_conjourney_note_textarea", "Note content...");
        Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_savenote"));
    }

    public void sendEmail() throws InterruptedException {
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_email"));
        Thread.sleep(2000);
        XamplifyUtil_contacts.enterText("mc_conjourney_email_sub", "subj for email in CJ");
        Thread.sleep(4000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_email_CC"));
        Thread.sleep(2000);
        XamplifyUtil_contacts.enterText("mc_conjourney_email_CCemail", "agayatri@stratapps.com");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("mc_conjourney_email_msg"))));
        driver.findElement(By.xpath("html/body")).click();
        driver.switchTo().activeElement().sendKeys("Hello..Email");
        driver.switchTo().defaultContent();
        Thread.sleep(4000);

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourny_sndtestmail"));
        Thread.sleep(4000);
        XamplifyUtil_contacts.enterText("mc_conjourny_sndtestmail_text", "gayatrialla@tuta.com");
        Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_sndmail_button"));
        Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_sndmail_button_ok"));
        Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjrny_sndmail_sent"));
        Thread.sleep(4000);
    }

    public void takeScreenshot(String filename) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("D:\\git\\xAmplifyQA\\xAmplifyQA\\test-output\\Screenshots\\" + filename));
    }
    
    public void clickContactJourneyTask() throws InterruptedException {
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task"));
        Thread.sleep(2000);
    }
    
    
    
    public void contactsTask() throws InterruptedException {
        Thread.sleep(4000);
        XamplifyUtil_contacts.enterText("mc_conjourney_task_title", "Task title in CJ");
        Thread.sleep(3000);

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_assigclck"));
        Thread.sleep(3000);
        XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", "partner");
        Thread.sleep(2000);
        XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", Keys.ENTER.toString());
        Thread.sleep(2000);

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_assigclck_selctstatus"));
        Thread.sleep(2000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_calendr"));
        Thread.sleep(2000);

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        String dayStr = String.valueOf(tomorrow.getDayOfMonth());
        
        int timeoutInSeconds = 10;

        try {
           
         // FluentWait with Duration
         FluentWait<WebDriver> wait = new FluentWait<>(driver)
                 .withTimeout(Duration.ofSeconds(timeoutInSeconds)) // Duration.ofSeconds for timeout
                 .pollingEvery(Duration.ofMillis(500)) // Polling interval
                 .ignoring(NoSuchElementException.class); // Exception to ignore
            
            
            
            
            
            
            
            
            
            
            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'open')]//span[not(contains(@class, 'disabled')) and text()='"
                        + dayStr + "']")));
            dateElement.click();
            Thread.sleep(2000);
        } catch (TimeoutException e) {
            System.out.println("Date element not found: " + e.getMessage());
            driver.navigate().refresh();
        }

        Thread.sleep(3000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_selectrem"));
        Thread.sleep(4000);
        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_rem"));
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement elementtask = driver.findElement(By.xpath(properties.getProperty("mc_conjourney_task_scroll")));
        js.executeScript("arguments[0].scrollBy(0, 200);", elementtask);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("mc_conjourney_task_textarea"))));
        driver.findElement(By.xpath("html/body")).click();
        driver.switchTo().activeElement().sendKeys("Hello..Tsk assigned to you check it out");
        driver.switchTo().defaultContent();
        Thread.sleep(4000);

        XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", "partner");
        Thread.sleep(2000);
        XamplifyUtil_contacts.enterText("mc_conjourney_task_assigclck_selct", Keys.ENTER.toString());
        Thread.sleep(2000);

        XamplifyUtil_contacts.callClickEvent(properties.getProperty("mc_conjourney_task_save"));
        Thread.sleep(2000);
    }
    
   	

    	    public void searchActivity(String keyword) {
    	        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath(properties.getProperty("mc_conjrny_act_search"))));
    	        searchBox.clear();
    	        searchBox.sendKeys(keyword);
    	        searchBox.sendKeys(Keys.ENTER);
    	    }

    	    public void selectFilter(String filterOption) {
    	        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath(properties.getProperty("mc_conjrny_act_filter"))));
    	        Select select = new Select(dropdownElement);
    	        select.selectByVisibleText(filterOption);
    	    }
    		
    		
    		
    		
    		
    		
    		
    		
    		
    

}