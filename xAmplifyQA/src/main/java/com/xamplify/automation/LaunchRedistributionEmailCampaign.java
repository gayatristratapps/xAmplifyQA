package com.xamplify.automation;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LaunchRedistributionEmailCampaign {
	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

	final Logger logger = LogManager.getLogger(LaunchRedistributionEmailCampaign.class);

	@Test
	
	public void redistribute_elaunch() throws InterruptedException, SQLException, AWTException {
		
		Thread.sleep(4000);
		RedistributeEmailCampaign Re1 = new RedistributeEmailCampaign();
		Re1.redistribute_ecampaign();
		Thread.sleep(5000);
	
	
	driver.findElement(By.xpath(properties.getProperty("re_email_now"))).click(); // Select now
	Thread.sleep(3000);
	driver.findElement(By.xpath(properties.getProperty("re_email_launch"))).click(); // Select launch
	Thread.sleep(3000);

	String redistribute_elaunch = driver.findElement(By.xpath(properties.getProperty("re_email_response_message"))).getText(); // response
	// message

	Thread.sleep(5000);

	String expectedtitle = "The campaign was successfully deployed. Please wait until the campaign is processed and launched. We will send you email updates in timely manner.";

	if (expectedtitle.equals(redistribute_elaunch)) {
		Thread.sleep(2000);

		System.out.println(" Email Campaign Redistributed Successfully");
	} else {
		Thread.sleep(2000);

		System.out.println(" Email Campaign Redistribution is failed");
	}

	logger.info("Email Campaign Redistributed Successfully");
	
	Thread.sleep(8000);

}
}
