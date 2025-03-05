package com.xamplify.automation;

import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;
import com.xamplify.util.XamplifyUtil;


public class TeamVendor {

		static WebDriver driver = Instance.getInstance();
		static Properties properties = PropertiesFile
				.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\TeamVendor.properties");
		final Logger logger = LogManager.getLogger(TeamVendor.class);

		@Test (priority = 1, enabled = true)
		public void addTeammember() throws InterruptedException, AWTException {
			
			WebDriverWait wait_team = new WebDriverWait(driver,50); //wait till the element is visible
			WebElement team = wait_team.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hoveronTeam"))));
			
			team.click();
			Thread.sleep(2000);
	
		
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_add_button"));
			Thread.sleep(1000);
			
			XamplifyUtil.sendTextEvent(properties.getProperty("clickon_firstname_field"), "CMR_FN");
			Thread.sleep(1000);
			XamplifyUtil.sendTextEvent(properties.getProperty("clickon_lastname_field"), "LN");
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_emailid_field"));
			Thread.sleep(1000);
			
			WebElement emailTextBx = driver.findElement(By.xpath(properties.getProperty("clickon_emailid_field")));
			
			//emailTextBx.click();  
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000);  
			emailTextBx.sendKeys("mounika"+ randomInt +"@gmail.com");  
			Thread.sleep(3000);
			
			WebElement TM_grpdropdown = driver.findElement(By.xpath(properties.getProperty("clickon_TMGroup")));
			TM_grpdropdown.click();
			Thread.sleep(1000);
			
			XamplifyUtil.selectDropdownByValue(properties.getProperty("clickon_TMGroup"), "2: 7180");
			XamplifyUtil.selectDropdownByValue(properties.getProperty("clickon_TMGroup"), "1: 7179");
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_view_available_modules"));
			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_close_available_modules"));
			Thread.sleep(1000);
			
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_saveTM"));
			Thread.sleep(1000);
		
		}
			
			
		
		@Test (priority =2, enabled = true)
		
		public void search_filter_export_TM() throws Throwable {
			
			
			XamplifyUtil.sendTextEvent(properties.getProperty("clickon_Search_tm"), "mounika3");
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_Searchicon_tm"));
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_tm_exportexcel"));
			Thread.sleep(1000);
			
			Robot Team_Expo = new Robot(); // Create object of Robot class to handle the download dailog
			Team_Expo.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(2000);
			
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_refreshtm"));
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_filtertm"));
			Thread.sleep(1000);
			
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_selectdate_field"));
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("select_from_date"));
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_todate_field"));
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("select_to_date"));
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_apply_button"));
			Thread.sleep(1000);
			
			
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_filtertm"));
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_clear_filter"));
			Thread.sleep(1000);
			
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_downarrow"));
			Thread.sleep(1000);
					
			
		}
		
		
		@Test (priority =3, enabled = true)
		public void actions_teammember() {
			
			
			
			
			
		}
		
			
		}
		

		
		




