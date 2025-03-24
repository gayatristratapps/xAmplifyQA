
package com.xamplify.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RedistributeEventCampaign  {
	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile(
			"D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");// properties
																											// file
	final Logger logger = LogManager.getLogger(RedistributeEventCampaign.class);
	

	@Test(priority = 1, enabled = true)
	public void hoverRedistributecampaigns_event() throws InterruptedException, AWTException {
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement eve_ele = driver.findElement(By.linkText("Campaign"));
		Actions act = new Actions(driver);
		act.moveToElement(eve_ele).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("partner_eve_redistribute_evehover"))).click(); // hover on
																											// //
																											// campaign
		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("partner_eve_redistribute_eventtab"))).click(); // click on
																											// // event
																											// // tab
		Thread.sleep(10000);
		logger.info("Event tab clicked successfully");

		driver.findElement(By.xpath(properties.getProperty("partner_redistribute_eve_camp_preview"))).click();																						// on //
																												// preview
		Thread.sleep(6000);

		logger.info("Event tab preview clicked successfully");
		
		String originalWindow = driver.getWindowHandle();//store the current window handle
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // wait for new tab to open
		Thread.sleep(5000);
			
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //get all windows handle
			
		driver.switchTo().window(tabs.get(1)); //switch to the new tab
			
		Thread.sleep(6000);	
		driver.close(); // switch back to original tab and close the new tab
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		logger.info("Event tab preview closed successfully");
		
//		 
//	driver.findElement(By.xpath(properties.getProperty("partner_eve_redis_eve_download"))).click(); // click on // // download // //icon
//logger.info("Event download clicked successfully");
//	
//	Thread.sleep(4000);
//		driver.findElement(By.xpath(properties.getProperty("partner_eve_redis_eve_dwnld_html"))).click(); // click on // // download // html // icon 
//	logger.info("Event download html clicked successfully");
//	Thread.sleep(4000); 
//
//	  Robot event_object1=new Robot(); //   Create object of Robot class to handle the download dailog 
//	   event_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter
//	    Thread.sleep(6000);
//	    
	    
		driver.findElement(By.xpath(properties.getProperty("red_event_download_history"))).click(); // click on // // download //history
        logger.info("Email template download_history clicked successfully");
	    Thread.sleep(4000); 
		
	    driver.findElement(By.xpath(properties.getProperty("red_event_download_history_close"))).click(); // click on // // close
        logger.info("Email template download_history clicked successfully");
	    Thread.sleep(4000);
		
		WebElement redistribute_eve_camp = driver.findElement(By.xpath(properties.getProperty("red_event_camp_icon"))); // Redistribute event Campaign
		
		redistribute_eve_camp.click();
		Thread.sleep(6000);
		 

		  logger.info("Click on Search box"); WebElement search_list =
		  driver.findElement(By.xpath(properties.getProperty("click_eve_search_box")));
		  search_list.sendKeys("gayatri");
		  Thread.sleep(6000);
		  
		  
		  driver.findElement(By.xpath(properties.getProperty("click_eve_search_icon"))).
		  click(); 
		  Thread.sleep(6000);
		  
		  WebDriverWait wait1 = new WebDriverWait(driver, 50); // Wait till the element is not visible
		  WebElement eve_select = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("check_contact_list")))); 
		  eve_select.click();
		 Thread.sleep(5000);	
		 
		 
		 
		 
		 
		 
	

	}

}
