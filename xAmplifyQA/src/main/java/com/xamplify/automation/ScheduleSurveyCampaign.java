package com.xamplify.automation;


import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ScheduleSurveyCampaign {
	
	WebDriver driver = Instance.getInstance();
	Properties properties= PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Campaign.properties");
final Logger logger = LogManager.getLogger(ScheduleSurveyCampaign.class);

Screenshot scrn = new Screenshot();


	@Test


	public void sSchedule() throws InterruptedException, SQLException

	{
		Thread.sleep(3000);
		SurveyCampaign s1=new SurveyCampaign();
	 	s1.scampaign();// method calling
	 	Thread.sleep(3000);
	 	
	 // AutoResponsesSurveyCampaign ar_s=new AutoResponsesSurveyCampaign();
	 		 //ar_s.autoResponsesSurvey();
	 	
	 	driver.findElement(By.xpath(properties.getProperty("s_schedule"))).click(); //Click on Schedule
	 	Thread.sleep(2000);
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");// scroll down
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(properties.getProperty("s_date_field"))).click();// click on date field
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("s_date_select"))).click();// Select date
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		scrn.captureScreenshot("Survey Schedule_date_calendar");

	
		
		
		
		
		/*
		 * Calendar calendar = Calendar.getInstance();
		 * 
		 * int hours = calendar.get(Calendar.HOUR_OF_DAY); int minutes =
		 * calendar.get(Calendar.MINUTE); System.out.println(hours);
		 * System.out.println(minutes);
		 * 
		 * 
		 * if(hours < 12 ) {
		 * driver.findElement(By.xpath(properties.getProperty("s_date_hour_select"))).
		 * sendKeys("1"); Thread.sleep(5000);
		 * driver.findElement(By.xpath(properties.getProperty("s_date_minute_select"))).
		 * sendKeys("11"); Thread.sleep(5000); } else {
		 * driver.findElement(By.xpath(properties.getProperty("s_date_hour_select"))).
		 * sendKeys("11"); Thread.sleep(5000);
		 * driver.findElement(By.xpath(properties.getProperty("s_date_minute_select"))).
		 * sendKeys("59"); Thread.sleep(5000); }
		 */
		WebElement country_drpdwn=driver.findElement(By.xpath(properties.getProperty("s_country")));
		Select country1=new Select(country_drpdwn);
		Thread.sleep(2000);
		country1.selectByVisibleText("India");// Select India
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("s_schedule_click"))).click();
		Thread.sleep(2000);
		
		scrn.captureScreenshot("Survey Schedule");
		String s_schedule = driver.findElement(By.xpath(properties.getProperty("s_response_msg"))).getText(); // response
		// message

		Thread.sleep(2000);
		
		scrn.captureScreenshot("Survey Schedule message");
		
logger.info("Survey Campaign Scheduled Successfully");	 	
	 	String Result1 = "Campaign scheduled successfully";
	 	
	 	if(Result1.equals(s_schedule)) {
	 		//Thread.sleep(2000);
	 		System.out.println("Survey Campaign Scheduled Successfully");
	 	} 
	 	else {
	 		Thread.sleep(2000);

	 		System.out.println("Survey Campaign Scheduled failed");
	 		}
		
		


}
	
}

