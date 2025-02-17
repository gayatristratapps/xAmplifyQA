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

public class SaveRedistributionEmailCampaign {
	
	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

	final Logger logger = LogManager.getLogger(SaveRedistributionEmailCampaign.class);

	@Test

public void redistribute_esave() throws InterruptedException, SQLException, AWTException {
		
		Thread.sleep(4000);
		RedistributeEmailCampaign Re_Sav = new RedistributeEmailCampaign();
		Re_Sav.redistribute_ecampaign();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("red_email_testmail"))).click();// click on test mail
		Thread.sleep(5000);
		
		WebElement red_sendtextemail=driver.findElement(By.xpath(properties.getProperty("red_email_field")));
		red_sendtextemail.sendKeys("chmounika@stratapps.com");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("red_email_field_Submit"))).click();// click on submit
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("red_email_field_Submit_OK"))).click();// click on Ok
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("red_email_Save"))).click();// click on Save
		Thread.sleep(3000);

		String red_email_save = driver.findElement(By.xpath(properties.getProperty("re_email_response_message"))).getText(); // response
		// message
		Thread.sleep(5000);

		String expectedtitle = "Campaign saved successfully";
		Thread.sleep(5000);

		if (expectedtitle.equals(red_email_save)) {
			System.out.println(" email  Campaign saved successfully");
			Thread.sleep(5000);

		} else {
			System.out.println(" email Campaign failed");
		}

		logger.info("Email Campaign saved Successfully");
		Thread.sleep(8000);
}
}