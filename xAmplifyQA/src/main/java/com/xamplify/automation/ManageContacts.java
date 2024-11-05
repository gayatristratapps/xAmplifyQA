package com.xamplify.automation;

import java.sql.SQLException;
import java.util.Properties;

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
import org.testng.annotations.Test;

public class ManageContacts {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\ManageContacts.properties");
	
	final Logger logger = LogManager.getLogger(Contacts.class);
	

	@Test(priority = 1, enabled = true)

	public void contacts_hover1() throws InterruptedException, SQLException {

		logger.debug("start hover on contacts");

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

		logger.debug("Starting click on manage contacts");
		WebDriverWait wait_acon = new WebDriverWait(driver, 60);

		// Wait till the element is not visible
		WebElement acon1 = wait_acon
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Managecontacts"))));
		acon1.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("mc_formcon_tab"))).click(); //click for formcontacts 
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("mc_compcon_tab"))).click(); //click for company contacts 
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("mc_allcon_tab"))).click();  //click for all contacts 
		
		logger.debug("Tabs click done");

	}
	
	
	
	@Test(priority = 3, enabled = true)

	public void managecontacts_view_sortby() throws InterruptedException, SQLException {

		Thread.sleep(3000);
		logger.debug("clicking for grid view ");

		driver.findElement(By.xpath(properties.getProperty("mc_gridview"))).click();  //click for grid view 
		Thread.sleep(2000);
		
		WebElement search=driver.findElement(By.xpath(properties.getProperty("mc_search"))); //click for search
		search.sendKeys("Auto");
		search.sendKeys(Keys.ENTER);  //enter the data through sendkeys and enter through the keyboard.
		
		Thread.sleep(5000);
		logger.debug("Starting sortby option");

		WebElement dropsort=driver.findElement(By.xpath(properties.getProperty("mc_sortby"))); //click for sort by

        Select dropdown = new Select(dropsort);

		Thread.sleep(5000);
		 
		dropdown.selectByValue("1: Object");
		Thread.sleep(5000);
		
		dropdown.selectByValue("2: Object");
		Thread.sleep(5000);
		
		dropdown.selectByValue("3: Object");
		Thread.sleep(5000);
		dropdown.selectByValue("4: Object");
		Thread.sleep(2000);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	}