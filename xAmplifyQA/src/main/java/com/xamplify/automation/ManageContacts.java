package com.xamplify.automation;

import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ManageContacts {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\ManageContacts.properties");
	
	final Logger logger = LogManager.getLogger(Contacts.class);
	

	@Test(priority = 1, enabled = true)

	public void contacts_hover1() throws InterruptedException, SQLException {

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

	public void managecontacts_tabs() throws InterruptedException, SQLException {

		logger.debug("Starting creating contact using upload a csv");
		WebDriverWait wait_acon = new WebDriverWait(driver, 60);

		// Wait till the element is not visible
		WebElement acon1 = wait_acon
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Managecontacts"))));
		acon1.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_formcon_tab"))).click(); 
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("mc_compcon_tab"))).click(); 
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("mc_allcon_tab"))).click(); 
		
		
	}
	
	
	
	@Test(priority = 3, enabled = true)

	public void managecontacts_view_sortby() throws InterruptedException, SQLException {

		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mc_gridview"))).click(); 
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("mc_compcon_tab"))).click(); 
		Thread.sleep(3000);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	}