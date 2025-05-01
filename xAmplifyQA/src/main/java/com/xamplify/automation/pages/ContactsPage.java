package com.xamplify.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.util.ContactFormHelper;
import com.xamplify.util.Contactsutil;
import com.xamplifycon.util.XamplifyUtil_contacts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class ContactsPage {
	private WebDriver driver;
	private Properties props;
	private WebDriverWait wait;
    private ContactFormHelper contactHelper;

	// Constructor with WebDriver and Properties
	public ContactsPage(WebDriver driver, Properties props) {
		this.driver = driver;
		this.props = props;
		this.wait = new WebDriverWait(driver, 120);
        this.contactHelper = new ContactFormHelper(driver, props);  // Create an instance of ContactFormHelper

	}

	// Hover on the Contacts menu
	public void hoverContacts() {
		WebElement hoverElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("hovercontacts"))));
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverElement).perform();
	}

	// Click on Add Contacts from the submenu
	public void clickAddContacts() {
		WebElement addBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("Addcontacts"))));
		addBtn.click();
	}
	
	
	
	
	
	public void fillContactForm() {
        contactHelper.fillOneAtATimeForm();  // Call the method via the instance
    }
	
	
	
	
	
	/*
	 * 
	 * 
	 * public void fillOneAtATimeForm() throws InterruptedException { WebElement
	 * emailText = wait.until(
	 * ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty(
	 * "con_oat_emailfield")))); emailText.sendKeys("gayatri" + new
	 * Random().nextInt(1000) + "@gmail.com");
	 * 
	 * driver.findElement(By.xpath(props.getProperty("con_legalbasis"))).click();
	 * WebElement legal =
	 * driver.findElement(By.xpath(props.getProperty("con_legalbasis")));
	 * legal.sendKeys("Legitimate interest - existing customer", Keys.ENTER);
	 * legal.sendKeys("Legitimate interest - prospect/lead", Keys.ENTER);
	 * 
	 * driver.findElement(By.xpath(props.getProperty("con_firstname"))).sendKeys(
	 * "GAYATRI");
	 * driver.findElement(By.xpath(props.getProperty("con_lastname"))).sendKeys("A")
	 * ;
	 * 
	 * driver.findElement(By.id("title")).sendKeys("sse");
	 * driver.findElement(By.id("address")).
	 * sendKeys("sri maartuhi homes, citizens colony, lingampally");
	 * driver.findElement(By.id("city")).sendKeys("Hyderabad");
	 * driver.findElement(By.id("state")).sendKeys("Telegana");
	 * driver.findElement(By.id("zip")).sendKeys("5000S0");
	 * 
	 * // Add company logic WebElement addCompanyBtn =
	 * driver.findElement(By.xpath(props.getProperty("con_addcompbutton")));
	 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
	 * addCompanyBtn);
	 * 
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
	 * "addCompanyModal"))); WebElement popupInput =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
	 * 
	 * new
	 * Actions(driver).moveToElement(popupInput).click().sendKeys("AutoTestCompany")
	 * .perform();
	 * driver.findElement(By.id("website")).sendKeys("www.automate.com");
	 * driver.findElement(By.xpath(props.getProperty("con_addcompbutton_Add"))).
	 * click();
	 * 
	 * try { WebElement errorMsg =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
	 * "responseMessage"))); if (errorMsg.getText().contains("Duplicate Entry")) {
	 * String uniqueName = "AutoTestCompany_" + new
	 * SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	 * driver.findElement(By.id("name")).clear();
	 * driver.findElement(By.id("name")).sendKeys(uniqueName);
	 * driver.findElement(By.xpath(props.getProperty("con_addcompbutton_Add"))).
	 * click(); } } catch (Exception ignored) { }
	 * 
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty
	 * ("con_addbutton")))).click(); }
	 */
	public void completeOneAtATimeFlow() throws InterruptedException {
		// Wait for and click the "One at a time" option
		WebElement oneAtATimeOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_oneatatimelist"))));
		oneAtATimeOption.click();

		fillContactForm(); // This method already has its own waits

		// Wait for and enter the list name
		WebElement listField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("con_oat_listfield"))));
		listField.sendKeys("Autocon_1");

		// Wait for and click the Save button
		WebElement saveButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_oat_Save"))));
		saveButton.click();

		try {
			WebElement errMsg = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("con_existname"))));
			if (errMsg.getText().contains("already exists")) {
				WebElement listNameRetry = driver.findElement(By.xpath(props.getProperty("con_oat_listfield")));
				listNameRetry.sendKeys("_A1" + "_" + System.currentTimeMillis());

				WebElement retrySaveBtn = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_oat_Save"))));
				retrySaveBtn.click();
			}
		} catch (Exception ignored) {
		}

		// Wait for and click the Accept/Confirm button
		WebElement acceptButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_accept"))));
		acceptButton.click();
	}

	public void uploadCSVAndHandle() throws InterruptedException, IOException {
		hoverContacts();
		clickAddContacts();

		// Wait and click Upload CSV
		WebElement uploadCSVBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadCSV")));
		uploadCSVBtn.click();
		Thread.sleep(2000);

		Contactsutil.executeRuntimeProcess();
		Thread.sleep(2000);

		// Wait and set legal basis
		WebElement legal = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_upload_legalbasis"))));
		legal.sendKeys("Legitimate interest - existing customer", Keys.ENTER);
		legal.sendKeys("Legitimate interest - prospect/lead", Keys.ENTER);

		// Wait and click Save
		WebElement saveBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_save"))));
		saveBtn.click();

		// Wait and click Verify
		WebElement verifyBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_verify"))));
		verifyBtn.click();

		// Handle duplicate list name if needed
		try {
			WebElement errmsg = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("con_csv_errmsg"))));
			if (errmsg.getText().contains("already exists")) {
				WebElement listName = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_listname"))));
				listName.sendKeys("_G" + "_" + System.currentTimeMillis());

				WebElement retrySave = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_save"))));
				retrySave.click();

				WebElement retryVerify = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath(props.getProperty("con_csv_verify"))));
				retryVerify.click();
			}
		} catch (Exception ignored) {
		}
	}

}
