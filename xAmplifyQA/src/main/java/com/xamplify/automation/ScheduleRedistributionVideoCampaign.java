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

public class ScheduleRedistributionVideoCampaign {
	
	
	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

	final Logger logger = LogManager.getLogger(ScheduleRedistributionVideoCampaign.class);

	@Test
	
	
	public void redistribute_vschedule() throws InterruptedException, SQLException {
		
		Thread.sleep(4000);
		RedistributeVideoCampaign Re_VSch = new RedistributeVideoCampaign();
		Re_VSch.redistribute_vcampaign();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("red_video_schedule_click"))).click();
		Thread.sleep(4000);
		
		JavascriptExecutor jsh = (JavascriptExecutor) driver; //Scroller
		jsh.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		
		
		  	WebElement re_eschd_dateTable =driver.findElement(By.xpath(properties.getProperty("red_video_schd_date")));
		  	re_eschd_dateTable.click(); 
		  	Thread.sleep(9000);
		  	driver.findElement(By.xpath(properties.getProperty("red_video_sch_date_click"))).click(); 
		  	Thread.sleep(5000);
		 
		
			
			Calendar calendar = Calendar.getInstance();
			
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			System.out.println(hours);
			System.out.println(minutes);
	    	
			if(hours < 12  )
				
			
			{
	    	driver.findElement(By.xpath(properties.getProperty("red_video_sch_date_hour"))).sendKeys("1");
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("red_video_sch_date_min"))).sendKeys("11");
			Thread.sleep(5000);
			}
			else
			{
				driver.findElement(By.xpath(properties.getProperty("red_video_sch_date_hour"))).sendKeys("11");
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("red_video_sch_date_min"))).sendKeys("59");
				Thread.sleep(5000);
			}
			
	    	
		WebElement country_drpdwn=driver.findElement(By.xpath(properties.getProperty("red_vselect_country")));
		Select country1=new Select(country_drpdwn);
		Thread.sleep(5000);
		country1.selectByValue("103");
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("red_video_schedule"))).click(); //scjedule
		Thread.sleep(8000);
		
		String red_v_schedule = driver.findElement(By.xpath(properties.getProperty("re_video_response_message"))).getText(); // response
		// message

		Thread.sleep(5000);

	
	
	String expectedtitle = "Campaign scheduled successfully";

	if (expectedtitle.equals(red_v_schedule)) {
		Thread.sleep(2000);

		System.out.println(" video Campaign scheduled successfully");
	} else {
		Thread.sleep(2000);

		System.out.println(" video Campaign schedule failed");
	}

logger.info("video Campaign Scheduled Successfully");

Thread.sleep(5000);

	
}
}
