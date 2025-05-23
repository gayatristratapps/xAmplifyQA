package com.xamplify.automation;

import java.sql.SQLException;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class LaunchEventCampaign {

	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile.readPropertyFile(
			"D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\EventCampaign.properties");

	final Logger logger = LogManager.getLogger(LaunchEventCampaign.class);
	Screenshot scrn = new Screenshot();


	@Test
	public void event_launch() throws InterruptedException, SQLException

	{
		Thread.sleep(3000);
		EventCampaign eve1 = new EventCampaign();
		eve1.event_campaign();
		Thread.sleep(3000);

		
		/*
		 * AutoResponsesEventCampaign ar_eve1=new AutoResponsesEventCampaign(); //method
		 * call for autoresponses ar_eve1.autoResponsesEvent();
		 * 
		 * Thread.sleep(4000);
		 */
		  
		
		
		driver.findElement(By.xpath(properties.getProperty("eve_now"))).click(); // click NOW
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("eve_launch"))).click(); // click LAUNCH

		Thread.sleep(3000);

		String eve_launch = driver.findElement(By.xpath(properties.getProperty("eve_response_msg"))).getText(); 
		// response
		// message

		scrn.captureScreenshot("event launch");
		Thread.sleep(2000);

		String expectedtitle = "The campaign was successfully deployed. Please wait until the campaign is processed and launched. We will send you email updates in timely manner.";

		if (expectedtitle.equals(eve_launch)) {
			System.out.println(" Event Campaign launched successfully");
		} else {
			System.out.println(" Event Campaign failed");
		}

		logger.info("Event Campaign Launched Successfully");
		
		Thread.sleep(3000);

	}
}