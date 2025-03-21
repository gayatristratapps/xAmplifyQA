package com.xamplify.automation;

import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SaveEventCampaign {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile(
			"D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\EventCampaign.properties");

	final Logger logger = LogManager.getLogger(SaveEventCampaign.class);

	@Test
	public void event_save() throws InterruptedException, SQLException {
		Thread.sleep(3000);

		EventCampaign eve12 = new EventCampaign();
		eve12.event_campaign();
		Thread.sleep(3000);

		
		/*
		 * AutoResponsesEventCampaign ar_eve1=new AutoResponsesEventCampaign(); //method
		 * call for autoresponses ar_eve1.autoResponsesEvent();
		 * 
		 * Thread.sleep(4000)
		 
			  

		Thread.sleep(3000);*/

		driver.findElement(By.xpath(properties.getProperty("eve_save"))).click();// click on save
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("eve_saved"))).click(); // click on save last button
		Thread.sleep(2000);
		String ev_save = driver.findElement(By.xpath(properties.getProperty("eve_save_response_msg"))).getText(); // response
		// message

		Thread.sleep(2000);

		String expectedtitle = "Campaign saved successfully";

		if (expectedtitle.equals(ev_save)) {
			System.out.println(" Event Campaign saved successfully");
			Thread.sleep(2000);

		} else {
			System.out.println(" Event Campaign failed");
			Thread.sleep(2000);

		}

		logger.info("Event Campaign saved successfully");

	}

}
