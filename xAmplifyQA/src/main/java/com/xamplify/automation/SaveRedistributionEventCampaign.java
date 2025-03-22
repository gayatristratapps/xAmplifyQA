package com.xamplify.automation;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SaveRedistributionEventCampaign {

	
	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

	final Logger logger = LogManager.getLogger(SaveRedistributionEventCampaign.class);

	@Test

public void redistribute_evesave() throws InterruptedException, SQLException, AWTException {
		
		Thread.sleep(4000);
		RedistributeEventCampaign Re_eve_sav = new RedistributeEventCampaign();
		Re_eve_sav.hoverRedistributecampaigns_event();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("red_event_Spamcheck"))).click();// click on spamcheck
		Thread.sleep(5000);
		
		WebElement red_Vsendtextemail=driver.findElement(By.xpath(properties.getProperty("red_event_email_spamcheck"))); //click within popup
		red_Vsendtextemail.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("red_event_refresh_click"))).click();// click on refresh button
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("red_event_close_Spamcheck"))).click();// click on close button under spamcheck
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("red_event_Save"))).click();// click on Save
		Thread.sleep(8000);

		String red_event_save = driver.findElement(By.xpath(properties.getProperty("re_event_response_message"))).getText(); // response
		// message
		Thread.sleep(5000);

		
		String expectedtitle = "Campaign saved successfully";
		Thread.sleep(5000);

		if (expectedtitle.equals(red_event_save)) {
			System.out.println(" Event  Campaign saved successfully");
			Thread.sleep(5000);

		} else {
			System.out.println(" event Campaign failed");
		}

		logger.info("Event Campaign saved Successfully");
		Thread.sleep(8000);
}
}
