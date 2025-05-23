package com.xamplify.automation;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//public class ScheduleVideoCampaign extends VideoCampaign {

public class ScheduleVideoCampaign {
	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Campaign.properties");
	
final Logger logger = LogManager.getLogger(ScheduleVideoCampaign.class);

Screenshot scrn = new Screenshot();


	@Test

	public void vschedule() throws InterruptedException, SQLException {

		Thread.sleep(3000);

		VideoCampaign vs = new VideoCampaign();
		vs.vdecampaign();
		Thread.sleep(3000);
		//for autoresponses remove the comments
		/* 
		 * AutoresponsesVideo arv3=new AutoresponsesVideo();
		 *  arv3.autoResponsesVideo();
		 * Thread.sleep(4000);
		 */
		driver.findElement(By.xpath(properties.getProperty("v_schedule_click"))).click();// click on schedule
		Thread.sleep(2000);

		WebElement dateTable = driver.findElement(By.xpath(properties.getProperty("v_schdule_date")));// click on
																										// calendar
		dateTable.click();
		Thread.sleep(3000);

		WebElement we1 = driver.findElement(By.xpath(properties.getProperty("v_schdule_selectdate")));// click on select date
																									
		we1.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver; //Scroller
		js1.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		

		Calendar calendar = Calendar.getInstance();

		int hours = calendar.get(Calendar.HOUR_OF_DAY);

		System.out.println(hours);
		if (hours < 12)

		{
			driver.findElement(By.xpath(properties.getProperty("vschdule_date_hour"))).sendKeys("1"); // send data in
																										// hours
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("vschdule_date_min"))).sendKeys("11"); // send data in
																										// minutes
			Thread.sleep(2000);
		} else {
			driver.findElement(By.xpath(properties.getProperty("vschdule_date_hour"))).sendKeys("11"); // send data in
																										// hours
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("vschdule_date_min"))).sendKeys("59"); // send data in
																										// minutes
			Thread.sleep(2000);
		}

		WebElement country_drpdwn = driver.findElement(By.xpath(properties.getProperty("v_schedule_cntrydrpdwn")));// select
																													// country
																													// drop
																													// down
		Select country1 = new Select(country_drpdwn);
		Thread.sleep(2000);
		country1.selectByValue("103");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("v_schedule"))).click();// click on schedule
		Thread.sleep(2000);

		String v_schedule = driver.findElement(By.xpath(properties.getProperty("e_response_msg"))).getText(); // response
// message

		Thread.sleep(2000);
		
		scrn.captureScreenshot("Videoschedule");


		String expectedtitle = "Campaign scheduled successfully";

		if (expectedtitle.equals(v_schedule)) {
			Thread.sleep(2000);

			System.out.println(" video Campaign scheduled successfully");
		} else {
			Thread.sleep(2000);

			System.out.println(" video Campaign schedule failed");
		}
		
		Thread.sleep(2000);
logger.info("Video Campaign Scheduled Successfully");
	}

}

