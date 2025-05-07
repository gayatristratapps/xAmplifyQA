package com.xamplify.automation.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.util.ContactFormHelper;
import com.xamplify.util.Contactsutil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.util.Properties;

public class ContactsPage {
	private WebDriver driver;
	private Properties props;
	private WebDriverWait wait;
	private ContactFormHelper contactHelper;
	private static final Logger logger = LogManager.getLogger(ContactsPage.class);
	
	// Constructor with WebDriver and Properties
	public ContactsPage(WebDriver driver, Properties props) {
		this.driver = driver;
		this.props = props;
		this.wait = new WebDriverWait(driver, 120);
		this.contactHelper = new ContactFormHelper(driver, props); // Create an instance of ContactFormHelper
		 logger.info("ContactsPage initialized.");

	}

	public void hoverContacts() {
        logger.info("Hovering over 'Contacts' menu.");
        WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("hovercontacts"))));
        new Actions(driver).moveToElement(hoverElement).perform();
        logger.debug("'Contacts' menu hovered.");
    }

    public void clickAddContacts() {
        logger.info("Clicking 'Add Contacts' button.");
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("Addcontacts"))));
        addBtn.click();
        logger.debug("'Add Contacts' button clicked.");
    }

    public void fillContactForm() {
        logger.info("Filling out contact form.");
        contactHelper.fillOneAtATimeForm();
        logger.debug("Contact form filled.");
    }

    public void completeOneAtATimeFlow() throws InterruptedException {
        logger.info("Starting 'One at a Time' contact creation flow.");
        WebElement oneAtATimeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_oneatatimelist"))));
        oneAtATimeOption.click();
        logger.debug("'One at a Time' option selected.");

        fillContactForm();

        WebElement listField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("con_oat_listfield"))));
        listField.sendKeys("Autocon_1");
        logger.debug("List name entered: Autocon_1");

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_oat_Save"))));
        saveButton.click();
        logger.info("Clicked Save button for 'One at a Time' flow.");

        try {
            WebElement errMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("con_existname"))));
            if (errMsg.getText().contains("already exists")) {
                logger.warn("List name already exists. Attempting retry with unique name.");
                WebElement listNameRetry = driver.findElement(By.xpath(props.getProperty("con_oat_listfield")));
                listNameRetry.sendKeys("_A1" + "_" + System.currentTimeMillis());

                WebElement retrySaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_oat_Save"))));
                retrySaveBtn.click();
                logger.info("Retried saving with new list name.");
            }
        } catch (Exception e) {
            logger.debug("No duplicate list name error found.");
        }

        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_accept"))));
        acceptButton.click();
        logger.info("Confirmed contact creation.");
    }

    public void uploadCSVAndHandle() throws InterruptedException, IOException {
        logger.info("Starting CSV contact upload flow.");

        hoverContacts();
        clickAddContacts();

        WebElement uploadCSVBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadCSV")));
        uploadCSVBtn.click();
        logger.debug("'Upload CSV' button clicked.");
        Thread.sleep(2000);

        Contactsutil.executeRuntimeProcess();
        logger.debug("CSV file selection triggered via runtime process.");
        Thread.sleep(2000);

        WebElement legal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_upload_legalbasis"))));
        legal.sendKeys("Legitimate interest - existing customer", Keys.ENTER);
        legal.sendKeys("Legitimate interest - prospect/lead", Keys.ENTER);
        logger.debug("Legal basis entered.");

        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_save"))));
        saveBtn.click();
        logger.info("Clicked Save on CSV upload.");

        WebElement verifyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_verify"))));
        verifyBtn.click();
        logger.info("Clicked Verify on CSV upload.");

        try {
            WebElement errmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("con_csv_errmsg"))));
            if (errmsg.getText().contains("already exists")) {
                logger.warn("CSV list name already exists. Retrying with unique name.");
                WebElement listName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_listname"))));
                listName.sendKeys("_G" + "_" + System.currentTimeMillis());

                WebElement retrySave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_save"))));
                retrySave.click();

                WebElement retryVerify = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_verify"))));
                retryVerify.click();
                logger.info("Retried CSV upload with new list name.");
            }
        } catch (Exception e) {
            logger.debug("No duplicate list name issue during CSV upload.");
        }
    }
}
