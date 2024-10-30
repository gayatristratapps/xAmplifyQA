package com.xamplify.automation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xamplifycon.util.XamplifyUtil_contacts;

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

	@Test(priority = 2, enabled = true)

	public void con_oneatatime() throws InterruptedException, SQLException {

		WebDriverWait wait_acon = new WebDriverWait(driver, 60);

		// Wait till the element is not visible
		WebElement acon1 = wait_acon
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Addcontacts"))));
		acon1.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("con_oneatatimelist"))).click(); // one at a time click
		Thread.sleep(5000);

		WebElement emailText = driver.findElement(By.xpath(properties.getProperty("con_oat_emailfield")));

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailText.sendKeys("gayatri" + randomInt + "@gmail.com"); // will generate automatic number to append
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("con_legalbasis"))).click(); // click for legal basis
		Thread.sleep(2000);

		WebElement con_legal = driver.findElement(By.xpath(properties.getProperty("con_legalbasis")));
		con_legal.sendKeys("Legitimate interest - existing customer");// enter data for legal basis field
		con_legal.sendKeys(Keys.ENTER);// click enter in the keyboard
		con_legal.sendKeys("Legitimate interest - prospect/lead");// enter data for legal basis field
		con_legal.sendKeys(Keys.ENTER);// click enter in the keyboard

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("con_firstname"))).sendKeys("GAYATRI");  //send firstname data

		driver.findElement(By.xpath(properties.getProperty("con_lastname"))).sendKeys("A");  //send lastname data
		Thread.sleep(3000);

		WebElement drp = driver.findElement(By.xpath(properties.getProperty("con_comp_dropdown"))); 
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(drp).click().sendKeys("xAmplify").perform();
		Thread.sleep(4000);

		driver.findElement(By.id("title")).sendKeys("sse");   //send data for title
		driver.findElement(By.id("address")).sendKeys("sri maartuhi homes, citizens colony, lingampally");
		driver.findElement(By.id("city")).sendKeys("Hyderabad");  //send data for city
		driver.findElement(By.id("state")).sendKeys("Telegana");  //send data for state
		driver.findElement(By.id("zip")).sendKeys("5000S0");  //send data for zipcode
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("con_mobileno"))).sendKeys("9490925098"); // enter for phone number
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("con_addbutton"))).click(); // click for add button
		Thread.sleep(3000);

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
			Assert.assertEquals(excepted_res, Actual_res);                    //check for validation for exisitng list
			driver.findElement(By.xpath(properties.getProperty("con_oat_listfield")))
					.sendKeys("_A1" + "_" + System.currentTimeMillis());
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("con_oat_Save"))).click();  //click for save 
			Thread.sleep(2000);

		} catch (Exception e1) {
			System.out.println("exception occurred in catch block");

		}

		driver.findElement(By.xpath(properties.getProperty("con_accept"))).click(); // click for accept button
		Thread.sleep(2000);
	}

	@Test(priority = 2, enabled = false)

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

	}

}