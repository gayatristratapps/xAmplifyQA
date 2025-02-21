package com.xamplify.automation;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class Shareleads {

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Shareleads.properties");
	final Logger logger = LogManager.getLogger(Shareleads.class);

	
	
	public void hoverOnShareLeads() throws InterruptedException {

		XamplifyUtil.hoverAndClick(driver, properties, "hovershareleads", "add_shareleads");
		//Step 1: Contact List Creation
				XamplifyUtil.sendTextWithTimestamp("contactListName", "AutoSlist");
	}

	@Test(priority = 1, enabled = false)
	public void shareLeadsOneAtATime() throws InterruptedException {

		hoverOnShareLeads();

		logger.debug("Starting creating partner using One at a time");

		
		// Click on 'One at a Time' option
		XamplifyUtil.callClickEvent(properties.getProperty("sh_oneattime"));

		
		// Step 2: Enter Personal Details
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("sh_emailid"), "Gayatri_automate", "@getnada.com");
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_firstname"), "Gayatri");
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_lastname"), "autosharelead");
		
		//Step 3: Enter Company Details
		XamplifyUtil.getElementById("company").sendKeys("Gcompany");
		Thread.sleep(1000);
		
		 //Step 4: Legal Basis Selection
		XamplifyUtil.sendTextEvent(properties.getProperty("sh_legalbasis"), "Legitimate interest - prospect/lead");
		XamplifyUtil.sendKeyEvent(properties.getProperty("sh_legalbasis"), Keys.ENTER);

	    //  Step 5: Job Details
		XamplifyUtil.getElementById("title").sendKeys("Software Engineer");
		
	    //  Step 6: Address Information
		XamplifyUtil.getElementById("address").sendKeys("Sri maaruthi homes");
		XamplifyUtil.getElementById("city").sendKeys("Hyderabad");
		XamplifyUtil.getElementById("state").sendKeys("Andhra pradesh");
		XamplifyUtil.getElementById("zip").sendKeys("534342");
		
		// Step 7: Scroll Inside Modal
		WebElement scrollableDiv = driver.findElement(By.xpath(properties.getProperty("sh_scroll")));
		XamplifyUtil.scrollInsideElement(scrollableDiv, 500);
		
	    //  Step 8: Mobile & Country Selection
	    XamplifyUtil.sendTextEvent(properties.getProperty("sh_mobileno"), "9490925009");
	    XamplifyUtil.selectDropdownByText(properties.getProperty("sh_country"), "India");

	    // Step 9: Submit Lead
	    XamplifyUtil.callClickEvent(properties.getProperty("shareleads_add"));
	    Thread.sleep(1000);
	    XamplifyUtil.callClickEvent(properties.getProperty("shareleads_save"));
	    Thread.sleep(1000);

	    XamplifyUtil.callClickEvent(properties.getProperty("shareleads_accept"));
	    
	    Thread.sleep(1000);

	  
	    XamplifyUtil.takeScreenshot(driver, "Shareleads_oneatatimeCreation");

	}

	
	@Test(priority = 2, enabled = true)
	public void shareLeadsUploadacsv() throws InterruptedException {

		
		hoverOnShareLeads();
		  Thread.sleep(1000);
		  
		  WebElement button = driver.findElement(By.xpath(properties.getProperty("sh_uploadcsv"))); // Replace with your element's locator
		  XamplifyUtil.waitAndClick(driver, button);

		   //XamplifyUtil.callClickEvent(properties.getProperty("sh_uploadcsv"));
		    
			  
		
		
	}
	
	
}
