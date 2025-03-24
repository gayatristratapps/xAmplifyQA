package com.xamplify.automation;

import java.awt.AWTException;

import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class LaunchRedistributionEventCampaign {
	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

	final Logger logger = LogManager.getLogger(LaunchRedistributionEventCampaign.class);

	@Test
	
	public void redistribute_eventlaunch() throws InterruptedException, SQLException, AWTException {
		
		Thread.sleep(4000);
		RedistributeEventCampaign Rev1 = new RedistributeEventCampaign();
		Rev1.hoverRedistributecampaigns_event();
		Thread.sleep(5000);
	
	
	driver.findElement(By.xpath(properties.getProperty("re_event_now"))).click(); // Select now
	Thread.sleep(3000);
	driver.findElement(By.xpath(properties.getProperty("re_event_launch"))).click(); // Select launch
	Thread.sleep(8000);

	String redistribute_eventlaunch = driver.findElement(By.xpath(properties.getProperty("re_event_launch_response_message"))).getText(); // response
	// message

	Thread.sleep(5000);

	String expectedtitle = "The campaign was successfully deployed. Please wait until the campaign is processed and launched. We will send you email updates in timely manner.";

	if (expectedtitle.equals(redistribute_eventlaunch)) {
		Thread.sleep(2000);

		System.out.println(" Event Campaign Redistributed Successfully");
	} else {
		Thread.sleep(2000);

		System.out.println(" Event Campaign Redistribution is failed because Campaign name is already exists");
		
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("click_navigation_home"));
		Thread.sleep(5000);
	}

	logger.info("Event Campaign Redistributed Successfully");
	
	Thread.sleep(8000);

}
}
