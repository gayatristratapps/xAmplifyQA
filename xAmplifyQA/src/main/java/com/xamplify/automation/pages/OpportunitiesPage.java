package com.xamplify.automation.pages;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.automation.tests.ContactsTest;

public class OpportunitiesPage {
	
	private WebDriver driver;
	private Properties props;
	private WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(ContactsPage.class);
	
	// Constructor with WebDriver and Properties
	public OpportunitiesPage(WebDriver driver, Properties props) {
		this.driver = driver;
		this.props = props;
		this.wait = new WebDriverWait(driver, 120);
		//this.contactHelper = new ContactFormHelper(driver, props); // Create an instance of ContactFormHelper
		 logger.info("opportunitiesPage initialized.");

	}
	
	    
	
	    public void userMouseOverOnOpportunities() {
	        logger.info("Hovering over 'opportunities' menu.");
	        WebElement opportunitiesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("hovercontacts"))));
	        new Actions(driver).moveToElement(opportunitiesElement).perform();
	        logger.debug("'Contacts' menu hovered.");
	    }
   
	    
	    
	    
	    
	
	
}
