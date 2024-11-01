package com.xamplify.automation;

import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SaveRedistributionVideoCampaign {

	
	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

	final Logger logger = LogManager.getLogger(SaveRedistributionVideoCampaign.class);

	@Test

public void redistribute_vsave() throws InterruptedException, SQLException {
		
		Thread.sleep(4000);
		RedistributeVideoCampaign Re_VSav = new RedistributeVideoCampaign();
		Re_VSav.redistribute_vcampaign();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("red_video_testmail"))).click();// click on test mail
		Thread.sleep(5000);
		
		WebElement red_Vsendtextemail=driver.findElement(By.xpath(properties.getProperty("red_video_field")));
		red_Vsendtextemail.sendKeys("chmounika@stratapps.com");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("red_video_field_Submit"))).click();// click on submit
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("red_video_field_Submit_OK"))).click();// click on Ok
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("red_video_Save"))).click();// click on Save
		Thread.sleep(5000);

		String red_video_save = driver.findElement(By.xpath(properties.getProperty("re_video_response_message"))).getText(); // response
		// message
		Thread.sleep(5000);

		String expectedtitle = "Campaign saved successfully";
		Thread.sleep(5000);

		if (expectedtitle.equals(red_video_save)) {
			System.out.println(" video  Campaign saved successfully");
			Thread.sleep(5000);

		} else {
			System.out.println(" video Campaign failed");
		}

		logger.info("video Campaign saved Successfully");
		Thread.sleep(8000);
}
}
