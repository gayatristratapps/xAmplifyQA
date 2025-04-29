package com.xamplify.automation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xamplifycon.util.XamplifyUtil_contacts;
import org.openqa.selenium.JavascriptExecutor;

public class Contacts {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Contacts.properties");
	final Logger logger = LogManager.getLogger(Contacts.class);

	@Test(priority = 1, enabled = true)

	public void contacts_hover() throws InterruptedException, SQLException {

		logger.debug("Creating contact using one ata time");

		Thread.sleep(5000);

		WebDriverWait wait_con = new WebDriverWait(driver, 50);

		// Wait till the element is not visible
		WebElement con1 = wait_con.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hovercontacts"))));// hover
																													// on
																													// contacts

		con1.click();
		Actions actions = new Actions(driver);
		WebElement contacts = driver.findElement(By.xpath(properties.getProperty("hovercontacts")));
		actions.moveToElement(contacts).build().perform();

	}

	
	
	
	
	
	    public static String generateUniqueCompanyName() {
	        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	        return "AutoTestCompany_" + timeStamp;
	    }
	
	
	
	
	
	
	
	public static void oneattime() throws Exception {
		WebElement emailText = driver.findElement(By.xpath(properties.getProperty("con_oat_emailfield")));

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailText.sendKeys("gayatri" + randomInt + "@gmail.com");
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("con_legalbasis"))).click();
		Thread.sleep(2000);

		WebElement con_legal = driver.findElement(By.xpath(properties.getProperty("con_legalbasis")));
		con_legal.sendKeys("Legitimate interest - existing customer");
		con_legal.sendKeys(Keys.ENTER);
		con_legal.sendKeys("Legitimate interest - prospect/lead");
		con_legal.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("con_firstname"))).sendKeys("GAYATRI");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("con_lastname"))).sendKeys("A");
		Thread.sleep(2000);

		driver.findElement(By.id("title")).sendKeys("sse");
		driver.findElement(By.id("address")).sendKeys("sri maartuhi homes, citizens colony, lingampally");
		driver.findElement(By.id("city")).sendKeys("Hyderabad");
		driver.findElement(By.id("state")).sendKeys("Telegana");
		driver.findElement(By.id("zip")).sendKeys("5000S0");

		/*
		 * driver.findElement(By.xpath(properties.getProperty("con_flag"))).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath(properties.getProperty("con_flagcode"))).sendKeys
		 * ("+91"); Thread.sleep(2000);
		 * driver.findElement(By.xpath(properties.getProperty("con_flagcode_select"))).
		 * click(); Thread.sleep(2000);
		 * driver.findElement(By.xpath(properties.getProperty("con_mobileno"))).sendKeys
		 * ("9490925098"); Thread.sleep(2000);
		 */
		System.out.println("test1");

		// Click the "+" button using JS
		WebElement addCompBtn = driver.findElement(By.xpath(properties.getProperty("con_addcompbutton")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addCompBtn);

		// Wait for the modal and input field
		WebDriverWait wait = new WebDriverWait(driver, (10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addCompanyModal")));

		WebElement popupInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));

		// Scroll into view and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popupInput);
		popupInput.click();
		Thread.sleep(500); // Optional safety

		
	
		
			
		
		// Use Actions class to simulate real typing
		Actions actions = new Actions(driver);
		actions.moveToElement(popupInput).click().sendKeys("AutoTestCompany").perform();

		Thread.sleep(3000);
		
		
		driver.findElement(By.id("website")).sendKeys("www.automate.com");

		
		Thread.sleep(2000);
		

		driver.findElement(By.xpath(properties.getProperty("con_addcompbutton_Add"))).click();
		
		
		
		try {
		    WebDriverWait waitMsg = new WebDriverWait(driver, (15));
		    WebElement errorMsg = waitMsg.until(ExpectedConditions.visibilityOfElementLocated(By.id("responseMessage")));

		    if (errorMsg.getText().contains("Duplicate Entry for Company Name")) {
		        // Retry with unique name
		        String uniqueCompanyName = generateUniqueCompanyName();
		        driver.findElement(By.id("name")).clear();
		        driver.findElement(By.id("name")).sendKeys(uniqueCompanyName);
		        driver.findElement(By.xpath(properties.getProperty("con_addcompbutton_Add"))).click();
		    }
		} catch (Exception e) {
		    System.out.println("No error message displayed — assuming no duplicate.");
		}

		
			    Thread.sleep(2000); // Optional: pause before continuing
			    driver.findElement(By.xpath(properties.getProperty("con_addbutton"))).click();
			    Thread.sleep(3000); // Wait for the form to complete submission
	
	}

	@Test(priority = 2, enabled = true)

	public void con_oneatatime() throws Exception {

		WebDriverWait wait_acon = new WebDriverWait(driver, 60);

		// Wait till the element is not visible
		WebElement acon1 = wait_acon
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Addcontacts"))));
		acon1.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("con_oneatatimelist"))).click(); // one at a time click
		Thread.sleep(5000);

		oneattime();

		driver.findElement(By.xpath(properties.getProperty("con_oat_listfield"))).click(); // click for list name
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("con_oat_listfield"))).sendKeys("Autocon_1"); // enter the
																											// listname
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("con_oat_Save"))).click(); // click for save
		Thread.sleep(2000);
		try {

			WebElement errmsg = driver.findElement(By.xpath(properties.getProperty("con_existname")));
			String Actual_res = errmsg.getText();
			String excepted_res = "Contact List name already exists";
			Assert.assertEquals(excepted_res, Actual_res); // check for validation for exisitng list
			driver.findElement(By.xpath(properties.getProperty("con_oat_listfield")))
					.sendKeys("_A1" + "_" + System.currentTimeMillis());
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("con_oat_Save"))).click(); // click for save
			Thread.sleep(2000);

		} catch (Exception e1) {
			e1.printStackTrace();

		}

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("con_accept"))).click(); // click for accept button
		Thread.sleep(2000);

	}

	@Test(priority = 2, enabled = true)

	public void con_uploadcsv() throws InterruptedException, SQLException, IOException {

		logger.debug("Starting creating contact using upload a csv");
		contacts_hover();
		WebDriverWait wait_acon = new WebDriverWait(driver, 60);

		// Wait till the element is not visible
		WebElement acon1 = wait_acon
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Addcontacts"))));
		acon1.click();
		driver.findElement(By.id("uploadCSV")).click(); // click on the upload csv
		Thread.sleep(5000);
		XamplifyUtil_contacts.executeRuntimeProcess();
		Thread.sleep(2000);

		WebElement con_upload_legal = driver.findElement(By.xpath(properties.getProperty("con_upload_legalbasis")));
		con_upload_legal.sendKeys("Legitimate interest - existing customer");// enter data for legal basis field
		con_upload_legal.sendKeys(Keys.ENTER);// click enter in the keyboard
		con_upload_legal.sendKeys("Legitimate interest - prospect/lead");// enter data for legal basis field
		con_upload_legal.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("con_csv_save"))).click(); // click for save
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("con_csv_verify"))).click(); // click for accept button
		Thread.sleep(2000);

		try {

			WebElement errmsg = driver.findElement(By.xpath(properties.getProperty("con_csv_errmsg")));
			String Actual_res = errmsg.getText();
			String excepted_res = "list name already exists";
			Assert.assertEquals(excepted_res, Actual_res); // check for validation for exisitng list
			driver.findElement(By.xpath(properties.getProperty("con_csv_listname")))
					.sendKeys("_G" + "_" + System.currentTimeMillis());
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("con_csv_save"))).click(); // click for save
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("con_csv_verify"))).click(); // click for accept button
			Thread.sleep(2000);

		} catch (Exception e1) {
			e1.printStackTrace();

		}

	}
}
