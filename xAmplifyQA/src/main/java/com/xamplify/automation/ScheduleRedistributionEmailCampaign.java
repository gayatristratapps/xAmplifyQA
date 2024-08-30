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

public class ScheduleRedistributionEmailCampaign {

	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

	final Logger logger = LogManager.getLogger(LaunchRedistributionEmailCampaign.class);

	@Test
	
	
	public void redistribute_eschedule() throws InterruptedException, SQLException {
		
		Thread.sleep(4000);
		RedistributeEmailCampaign Re_Sch = new RedistributeEmailCampaign();
		Re_Sch.redistribute_ecampaign();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("red_email_schedule_click"))).click();
		Thread.sleep(4000);
		
		JavascriptExecutor jsh = (JavascriptExecutor) driver; //Scroller
		jsh.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
	
					/*
					 * List<WebElement> dates =
					 * driver.findElements(By.xpath(properties.getProperty("nxt_mnth_clck"))); //
					 * finding all the available dates in next month
					 * 
					 * int size = dates.size(); //getting the number of available dates.
					 * 
					 * Random random = new Random(); //generating a random number to select a random
					 * date int randomIndex = random.nextInt(size); dates.get(randomIndex).click();
					 * // selecting the random date Thread.sleep(4000);
					 */
		
		
		  	WebElement re_eschd_dateTable =driver.findElement(By.xpath(properties.getProperty("red_email_schd_date")));
		  	re_eschd_dateTable.click(); 
		  	Thread.sleep(9000);
		  	driver.findElement(By.xpath(properties.getProperty("red_email_sch_date_click"))).click(); 
		  	Thread.sleep(5000);
		 
		
			
			Calendar calendar = Calendar.getInstance();
			
			int hours = calendar.get(Calendar.HOUR_OF_DAY);
			int minutes = calendar.get(Calendar.MINUTE);
			System.out.println(hours);
			System.out.println(minutes);
	    	
			if(hours < 12  )
				
			
			{
	    	driver.findElement(By.xpath(properties.getProperty("red_email_sch_date_hour"))).sendKeys("1");
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("red_email_sch_date_min"))).sendKeys("11");
			Thread.sleep(5000);
			}
			else
			{
				driver.findElement(By.xpath(properties.getProperty("red_email_sch_date_hour"))).sendKeys("11");
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("red_email_sch_date_min"))).sendKeys("59");
				Thread.sleep(5000);
			}
			
	    	
		WebElement country_drpdwn=driver.findElement(By.xpath(properties.getProperty("red_eselect_country")));
		Select country1=new Select(country_drpdwn);
		Thread.sleep(5000);
		country1.selectByValue("103");
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("red_email_schedule"))).click(); //scjedule
		Thread.sleep(8000);
		
		String red_e_schedule = driver.findElement(By.xpath(properties.getProperty("re_email_response_message"))).getText(); // response
		// message

		Thread.sleep(5000);

	
	
	String expectedtitle = "Campaign scheduled successfully";

	if (expectedtitle.equals(red_e_schedule)) {
		Thread.sleep(2000);

		System.out.println(" Email Campaign scheduled successfully");
	} else {
		Thread.sleep(2000);

		System.out.println(" Email Campaign schedule failed");
	}

logger.info("Email Campaign Scheduled Successfully");
	
}
}