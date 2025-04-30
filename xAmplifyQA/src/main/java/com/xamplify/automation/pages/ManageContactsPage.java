package com.xamplify.automation.pages;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import com.xamplify.automation.Contacts;
import com.xamplify.util.ContactFormHelper;
import com.xamplifycon.util.XamplifyUtil_contacts;

public class ManageContactsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Properties props;
    private final Logger logger = LogManager.getLogger(Contacts.class);
    private ContactFormHelper contactHelper;

    
    
    
    
    public ManageContactsPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;
        this.wait = new WebDriverWait(driver, 120);
        this.contactHelper = new ContactFormHelper(driver, props);  // Create an instance of ContactFormHelper

    }

    private void waitAndClick(String xpathKey) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty(xpathKey)))).click();
    }

    private void waitAndSendKeys(String xpathKey, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(xpathKey))));
        element.clear();
        element.sendKeys(text);
    }

    private void waitAndSendKeysWithoutClear(String xpathKey, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(xpathKey))));
        element.sendKeys(text);
    }

    private void safeClick(String xpathKey) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty(xpathKey))));
        if (element.isEnabled()) {
            element.click();
        }
    }

    public void hoverOverContacts() {
        logger.debug("start hover on contacts");
        WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("hovercontacts"))));
        new Actions(driver).moveToElement(hoverElement).perform();
        waitAndClick("Managecontacts");
    }

    public void clickForEdit() {
        By editButtonLocator = By.xpath(props.getProperty("mc_edit"));
        wait.until(ExpectedConditions.elementToBeClickable(editButtonLocator)).click();
    }

    public void clickTab(String tabName) {
        By tabLocator = By.xpath(props.getProperty(tabName));
        wait.until(ExpectedConditions.elementToBeClickable(tabLocator)).click();
    }
    public void applyFilter(String field, String condition, String value) {
        By fieldLocator = By.xpath(props.getProperty(field));
        By conditionLocator = By.xpath(props.getProperty(condition));
        By valueLocator = By.xpath(props.getProperty(value));
        By submitButtonLocator = By.xpath(props.getProperty("mc_edit_filter_submit"));

        Select fieldSelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(fieldLocator)));
        fieldSelect.selectByVisibleText(field);

        Select conditionSelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(conditionLocator)));
        conditionSelect.selectByVisibleText(condition);

        WebElement valueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(valueLocator));
        valueElement.clear();
        valueElement.sendKeys(value);

        wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator)).click();
    }

    public void clickSaveAs() {
        By saveAsButtonLocator = By.xpath(props.getProperty("mc_copy_saveas"));
        wait.until(ExpectedConditions.elementToBeClickable(saveAsButtonLocator)).click();
    }

    public void deleteContactList() {
        By deleteButtonLocator = By.xpath(props.getProperty("mc_delete"));
        By confirmDeleteLocator = By.xpath(props.getProperty("mc_yesdelete"));

        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteLocator)).click();
    }

    public void shareContactList() {
        By shareIconLocator = By.xpath(props.getProperty("mc_shareicon"));
        By noCampaignsMessageLocator = By.xpath(props.getProperty("mc_share_nocampaigns"));
        By closeNoCampaignsLocator = By.xpath(props.getProperty("mc_share_nocampaigns_close"));

        wait.until(ExpectedConditions.elementToBeClickable(shareIconLocator)).click();

        WebElement noCampaignsMessage = wait.until(ExpectedConditions.presenceOfElementLocated(noCampaignsMessageLocator));
        if (noCampaignsMessage.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(closeNoCampaignsLocator)).click();
        }
    }


    public void hoverAndClickForEdit() {
        hoverOverContacts();
        clickForEdit();
    }

    public void applyLegalBasis() {
        WebElement mcon_legal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("mc_edit_legal")))) ;
        mcon_legal.sendKeys("Legitimate interest - existing customer", Keys.ENTER);
        mcon_legal.sendKeys("Legitimate interest - prospect/lead", Keys.ENTER);
    }

    public void editTiles() {
        safeClick("mc_edit_validtile");
        safeClick("mc_edit_export");
        safeClick("mc_edit_alltile");
        safeClick("mc_edit_unsub_icon");
        safeClick("mc_edit_unsub_reason");
        safeClick("mc_edit_unsub_reason_selected");
        safeClick("mc_edit_excludetile");
        safeClick("mc_edit_undel_tile");

        safeClick("mc_edit_unsub_tile");
        safeClick("mc_edit_unsub_tile_subscribe");

        waitAndSendKeys("mc_edit_unsub_tile_subscribe_comm", "test for resubscribing the contact");
        waitAndClick("mc_edit_unsub_tile_subscribe_comm_submit");
    }

    public void deleteContact() {
        safeClick("mc_edit_alltile");
        safeClick("mc_edit_deletecon1");
        safeClick("mc_edit_deleteicon");
        safeClick("mc_edit_deleted");
    }

    public void applyAndSelectContacts() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkAllExistingContacts"))).click();
        XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_edit_filter_newlist"));
    }

    public void editContactJourney() {
        waitAndSendKeysWithoutClear("mc_conjourney_edit_lastname", "-updateln");
        waitAndSendKeysWithoutClear("mc_conjourney_edit_address", "-updateadress");
        try {
			XamplifyUtil_contacts.sendmobileTextEvent("mcon_mobileno", "+91 9490925009", driver, props);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void updateContactJourney() {
        XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_conjourney_edit_update"));
    }

    public void manageContactsJourney() {
        hoverOverContacts();
        XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_edit"));
        XamplifyUtil_contacts.callClickEvent(props.getProperty("mc_conjourney"));
    }

    public void contactsNotes() {
        waitAndSendKeys("mc_conjourney_note_title", "Ntitle1");
        waitAndClick("mc_conjourney_note_toggle");
        waitAndSendKeys("mc_conjourney_note_textarea", "title description for note Lorem Ipsum dummy text");
        waitAndClick("mc_conjourney_savenote");
    }

    public void contactEmail() {
        waitAndSendKeys("mc_conjourney_email_sub", "subj for email in CJ");
        waitAndClick("mc_conjourney_email_CC");
        waitAndSendKeys("mc_conjourney_email_CCemail", "agayatri@stratapps.com");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("mc_conjourney_email_msg")))));
        driver.findElement(By.xpath("html/body")).click();
        driver.switchTo().activeElement().sendKeys("Hello..Email");
        driver.switchTo().defaultContent();

        waitAndClick("mc_conjourny_sndtestmail");
        waitAndSendKeys("mc_conjourny_sndtestmail_text", "gayatrialla@tuta.com");
        waitAndClick("mc_conjrny_sndmail_button");
        waitAndClick("mc_conjrny_sndmail_button_ok");
        waitAndClick("mc_conjrny_sndmail_sent");
    }

    public void contactsTask() {
        waitAndSendKeys("mc_conjourney_task_title", "Task title in CJ");

        waitAndClick("mc_conjourney_task_assigclck");
        waitAndSendKeys("mc_conjourney_task_assigclck_selct", "partner");
        waitAndSendKeys("mc_conjourney_task_assigclck_selct", Keys.ENTER.toString());

        waitAndClick("mc_conjourney_task_assigclck_selctstatus");
        waitAndClick("mc_conjourney_task_calendr");

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        int day = tomorrow.getDayOfMonth();

        WebElement dateElement = new FluentWait<>(driver)
            .withTimeout(10, TimeUnit.SECONDS)
            .pollingEvery(java.time.Duration.ofMillis(300))
            .ignoring(NoSuchElementException.class)
            .until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'open')]//span[not(contains(@class, 'disabled')) and text()='" + day + "']")));

        dateElement.click();

        waitAndClick("mc_conjourney_task_selectrem");
        waitAndClick("mc_conjourney_task_rem");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement elementtask = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("mc_conjourney_task_scroll")))) ;
        js.executeScript("arguments[0].scrollBy(0, 200);", elementtask);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("mc_conjourney_task_textarea")))));
        driver.findElement(By.xpath("html/body")).click();
        driver.switchTo().activeElement().sendKeys("Hello..Task assigned to you");
        driver.switchTo().defaultContent();

        waitAndSendKeys("mc_conjourney_task_assigclck_selct", "partner");
        waitAndSendKeys("mc_conjourney_task_assigclck_selct", Keys.ENTER.toString());

        waitAndClick("mc_conjourney_task_save");
    }
}
