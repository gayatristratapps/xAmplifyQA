package com.xamplify.automation;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//public class ScheduleEmailCampaign extends EmailCampaign {
import org.testng.annotations.Test;

public class ScheduleEmailCampaign{
	
	//@AfterMethod 
	//[for auto responses...comment @AfterTest annotation and use @Aftermethod , extends AutoResponsesEmail]

	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Campaign.properties");
	Screenshot scrn = new Screenshot();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
final Logger logger = LogManager.getLogger(ScheduleEmailCampaign.class);
	
	
	@Test
	public void eschedule() throws InterruptedException, SQLException
	{
		Thread.sleep(5000);
		
		 EmailCampaign e12=new EmailCampaign(); 
		 e12.ecampaign(); 
		  Thread.sleep(5000);
		 
		  
			/*
			 * AutoResponseEmailcampaign ar_e12=new AutoResponseEmailcampaign();
			 * ar_e12.autoResponsesEmail();
			 */
		  
		 //Thread.sleep(3000);
		

		driver.findElement(By.xpath(properties.getProperty("email_schedule_click"))).click();
		Thread.sleep(4000);
		
		JavascriptExecutor jsh = (JavascriptExecutor) driver; //Scroller
		jsh.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
	
		
		  WebElement dateTable =
		  driver.findElement(By.xpath(properties.getProperty("eselect_date")));
		  dateTable.click(); Thread.sleep(9000);
		  
		  
		 
		  driver.findElement(By.xpath(properties.getProperty("evsch_date_click"))).
		  click(); Thread.sleep(5000);
		  
	
	        
	        Calendar calendar = Calendar.getInstance();
	        int hours = calendar.get(Calendar.HOUR_OF_DAY);
	        int minutes = calendar.get(Calendar.MINUTE);
	        System.out.println("Selected Time - Hours: " + hours);
	        System.out.println("Selected Time - Minutes: " + minutes);

			if(hours < 12  )
				
			
			{
	    	driver.findElement(By.xpath(properties.getProperty("evsh_date_hour"))).sendKeys("1");
			Thread.sleep(5000);
			driver.findElement(By.xpath(properties.getProperty("evsh_date_min"))).sendKeys("11");
			Thread.sleep(5000);
			}
			else
			{
				driver.findElement(By.xpath(properties.getProperty("evsh_date_hour"))).sendKeys("11");
				Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("evsh_date_min"))).sendKeys("59");
				Thread.sleep(5000);
			}
			
	    	
		WebElement country_drpdwn=driver.findElement(By.xpath(properties.getProperty("eselect_country")));
		Select country1=new Select(country_drpdwn);
		Thread.sleep(5000);
		country1.selectByValue("103");
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("email_schedulelast"))).click(); //scjedule
		Thread.sleep(8000);
		
		String e_schedule = driver.findElement(By.xpath(properties.getProperty("e_response_msg"))).getText(); // response
		// message

		Thread.sleep(5000);

		scrn.captureScreenshot("Email Schedule");
	
	
	String expectedtitle = "Campaign scheduled successfully";

	if (expectedtitle.equals(e_schedule)) {
		Thread.sleep(2000);

		System.out.println(" Email Campaign scheduled successfully");
	} else {
		Thread.sleep(2000);

		System.out.println(" Email Campaign schedule failed");
	}

logger.info("Email Campaign Scheduled Successfully");
			
		}
	
	
}
