package com.xamplify.automation;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LaunchRedistributionVideoCampaign {

	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

	final Logger logger = LogManager.getLogger(LaunchRedistributionVideoCampaign.class);

	@Test
	
	
	public void redistribute_vlaunch() throws InterruptedException, SQLException, AWTException {
		
		Thread.sleep(4000);
		RedistributeVideoCampaign Re_v = new RedistributeVideoCampaign();
		Re_v.redistribute_vcampaign();
		Thread.sleep(5000);
	
	
	driver.findElement(By.xpath(properties.getProperty("re_video_now"))).click(); // Select contact list
	Thread.sleep(3000);
	driver.findElement(By.xpath(properties.getProperty("re_video_launch"))).click(); // Select contact list
	Thread.sleep(5000);

	String redistribute_vlaunch = driver.findElement(By.xpath(properties.getProperty("re_video_response_message"))).getText(); // response
	// message

	Thread.sleep(5000);

	String expectedtitle = "The campaign was successfully deployed. Please wait until the campaign is processed and launched. We will send you email updates in timely manner.";

	if (expectedtitle.equals(redistribute_vlaunch)) {
		Thread.sleep(2000);

		System.out.println(" Video Campaign Redistributed Successfully");
	} else {
		Thread.sleep(2000);

		System.out.println(" Video Campaign Redistribution is failed");
	}

	logger.info("Video Campaign Redistributed Successfully");
	
	Thread.sleep(8000);

}
	
	                                                                
	
}





