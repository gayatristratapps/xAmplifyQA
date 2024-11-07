	package com.xamplify.automation;

	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Properties;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	public class RedistributeVideoCampaign {

		WebDriver driver = Instance.getInstance();

		Properties properties = PropertiesFile
				.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

		final Logger logger = LogManager.getLogger(RedistributeEmailCampaign.class);

		
		@Test

		public void redistribute_vcampaign() throws InterruptedException, SQLException, AWTException {

			WebDriverWait wait = new WebDriverWait(driver, 50); // Wait till the element is not visible
			WebElement v_element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("re_vcampaignhover"))));
			v_element.click(); // hover the Campaign
			logger.info("Hover the campaign module");
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("click_vredstribute_campaign"))).click(); // click on
																										// Redistribute
																										// campaign
			Thread.sleep(5000);
			
			driver.findElement(By.xpath(properties.getProperty("re_video_tab"))).click(); // video tab
			Thread.sleep(8000);
			
			logger.info("Click on Preview Icon");
			driver.findElement(By.xpath(properties.getProperty("re_video_preview_icon"))).click(); // Click on Preview Icon
			Thread.sleep(5000);
			
			String originalWindow = driver.getWindowHandle();//store the current window handle
			wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // wait for new tab to open
			Thread.sleep(5000);
				
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //get all windows handle
				
			driver.switchTo().window(tabs.get(1)); //switch to the new tab
				
			Thread.sleep(3000);
				
				/*
				 * WebElement companylogoNewTab =
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.
				 * getProperty("")))); companylogoNewTab.click(); //perform actions in new tab
				 */			
			driver.close(); // switch back to original tab and close the new tab
				
			driver.switchTo().window(tabs.get(0));
				
			Thread.sleep(3000);
			
			
			WebElement v_downloadicon= driver.findElement(By.xpath(properties.getProperty("red_Email_vdownload"))); 
			v_downloadicon.click();  // // download // //icon
		    logger.info("Email template download clicked successfully");
		
		    Thread.sleep(4000);
			driver.findElement(By.xpath(properties.getProperty("red_video_dwnld_html"))).click(); // click on // // download // html // icon 
	        logger.info("Email template download html clicked successfully");
		    Thread.sleep(4000); 
									
		    Robot video_object1=new Robot(); //   Create object of Robot class to handle the download dailog 
		    video_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter
		    Thread.sleep(6000);
		    
		    
		    
		    v_downloadicon.click(); 
		    Thread.sleep(3000);
		    driver.findElement(By.xpath(properties.getProperty("red_video_dwnld_image"))).click(); // click on // // download // image// icon 
	        logger.info("Email template download html clicked successfully");
		    Thread.sleep(9000); 
		    video_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter
			Thread.sleep(3000);
		    
			
			
//			 v_downloadicon.click(); 
//			    Thread.sleep(3000);
//			    driver.findElement(By.xpath(properties.getProperty("red_video_dwnld_pdf"))).click(); // click on // // download //pdf// icon 
//		        logger.info("Email template download html clicked successfully");
//			    Thread.sleep(9000); 
//			    video_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter
//				Thread.sleep(3000);

			
			
			driver.findElement(By.xpath(properties.getProperty("red_video_download_history"))).click(); // click on // // download //history
	        logger.info("Email template download_history clicked successfully");
		    Thread.sleep(4000); 
			
		    driver.findElement(By.xpath(properties.getProperty("red_video_download_history_close"))).click(); // click on // // close
	        logger.info("Email template download_history clicked successfully");
		    Thread.sleep(4000);
			
			
			
			logger.info("click on Redistribute campaign icon");
			WebElement redistribute_vcamp = driver.findElement(By.xpath(properties.getProperty("red_video_camp_icon"))); // Redistribute
																															// Survey
																															// Campaign
			redistribute_vcamp.click();
			Thread.sleep(3000);

			WebElement campaignname = driver.findElement(By.xpath(properties.getProperty("re_video_campaigntitle")));
			campaignname.clear();
			Thread.sleep(3000);
			campaignname.sendKeys(properties.getProperty("re_video_campaignname") + "_" + System.currentTimeMillis());
			Thread.sleep(3000);

			logger.info("click on Subject line");

			WebElement subjectline = driver.findElement(By.xpath(properties.getProperty("re_video_subline"))); // Subject
																												// Line
			subjectline.clear();
			Thread.sleep(3000);
			subjectline.sendKeys("subject for redistributed Video campaign-");
			Thread.sleep(3000);

			/*
			 * driver.findElement(By.xpath(properties.getProperty(
			 * "re_video_template_download_click"))).click(); //Download Thread.sleep(3000);
			 */
			driver.findElement(By.xpath(properties.getProperty("re_video_template_edit_click"))).click(); //Edit click
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_video_template_edit_close"))).click(); //edit close
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_videoclick_on_select_button"))).click(); // click on Select
			Thread.sleep(8000);
	
			WebElement search_contact = driver.findElement(By.xpath(properties.getProperty("re_video_search_contact")));
			search_contact.sendKeys("mounika");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(properties.getProperty("re_video_search_icon"))).click(); // click on Search
			Thread.sleep(3000);
			
			WebDriverWait wait1 = new WebDriverWait(driver, 50); // Wait till the element is not visible
			WebElement v_select = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("re_video_select_contact"))));
			v_select.click();
}
	}
