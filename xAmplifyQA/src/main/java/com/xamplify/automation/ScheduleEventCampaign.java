package com.xamplify.automation;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ScheduleEventCampaign {

	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile.readPropertyFile(
			"D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\EventCampaign.properties");

	final Logger logger = LogManager.getLogger(ScheduleEventCampaign.class);

	@Test
	public void event_schedule() throws InterruptedException, SQLException {

		Thread.sleep(3000);

		EventCampaign eve123 = new EventCampaign(); 
		eve123.event_campaign();  
		Thread.sleep(3000);
		
		
		/*
		 * AutoResponsesEventCampaign ar_eve1=new AutoResponsesEventCampaign(); //method
		 * call for autoresponses ar_eve1.autoResponsesEvent();
		 * 
		 * Thread.sleep(4000);
		 */
			  

		driver.findElement(By.xpath(properties.getProperty("eve_schedule"))).click(); //click on the schedule button
		Thread.sleep(3000);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollTo(3000,document.body.scrollHeight)");//
		 * scroll down Thread.sleep(5000);
		 */

		WebElement dateTable = driver.findElement(By.xpath(properties.getProperty("eve_sch_click"))); // click on the
																										// calendar
		dateTable.click();

		Thread.sleep(3000);

		logger.info("Clicked the date section");

		driver.findElement(By.xpath(properties.getProperty("eve_sch_date_click"))).click(); // clicked the date
		Thread.sleep(3000);
		
		  
			
			/*Date gd =	Calendar.getInstance().getTime();
			
			String newString = new SimpleDateFormat("H:mm").format(gd);
			System.out.println(newString);*/
			
			Calendar calendar = Calendar.getInstance();
			
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			System.out.println(hours);
			System.out.println(minutes);
	    	
			if(hours < 12  )
				
			
			{
	    	driver.findElement(By.xpath(properties.getProperty("ev_date_hour"))).sendKeys("1");
			Thread.sleep(2000);
			driver.findElement(By.xpath(properties.getProperty("ev_date_min"))).sendKeys("11");
			Thread.sleep(2000);
			}
			else
			{
				driver.findElement(By.xpath(properties.getProperty("ev_date_hour"))).sendKeys("11");
				Thread.sleep(2000);
				driver.findElement(By.xpath(properties.getProperty("ev_date_min"))).sendKeys("59");
				Thread.sleep(2000);
			}
			
	    	
		WebElement pcountry_drpdwn = driver.findElement(By.xpath(properties.getProperty("eve_sch_select_country")));// select
																													// country
		Select pcountry1 = new Select(pcountry_drpdwn);
		Thread.sleep(2000);
		pcountry1.selectByValue("103");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("eve_schedulelast"))).click();// schedule
		Thread.sleep(3000);

		String s = driver.findElement(By.xpath(properties.getProperty("eve_sch_response_msg"))).getText(); // response
		
		String expectedtitle = "Campaign scheduled successfully";
		Thread.sleep(3000);
		if (expectedtitle.equals(s))
		{
			System.out.println(" Event Campaign Scheduled successfully");
			Thread.sleep(2000);

		} else
		{
			System.out.println(" Event Campaign failed");
			Thread.sleep(2000);

		}
		
		logger.info("Event Campaign Scheduled Successfully");

	}

}