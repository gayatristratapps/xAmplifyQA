package com.xamplify.automation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RedistributeSurveyCampaign {
	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");

	final Logger logger = LogManager.getLogger(RedistributeSurveyCampaign.class);

	@Test

	public void redistribute_scampaign() throws InterruptedException, SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 50); // Wait till the element is not visible
		WebElement s_element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("re_Surveycampaignhover"))));
		s_element.click(); // hover the Campaign
		logger.info("Hover the campaign module");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_redstribute_campaign"))).click(); // click on
																									// Redistribute
																									// campaign
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("re_survey_tab"))).click(); // Survey tab
		Thread.sleep(5000);
		logger.info("Click on Preview Icon");
		driver.findElement(By.xpath(properties.getProperty("re_survey_preview_icon"))).click(); // Click on Preview Icon
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
		/*
		 * driver.findElement(By.xpath(properties.getProperty("re_survey_preview_close")
		 * )).click(); Thread.sleep(3000);
		 */
		logger.info("click on Redistribute campaign icon");
		WebElement redistribute_camp = driver.findElement(By.xpath(properties.getProperty("red_survey_camp_icon"))); // Redistribute
																														// Survey
																														// Campaign
		redistribute_camp.click();
		Thread.sleep(3000);

		WebElement campaignname = driver.findElement(By.xpath(properties.getProperty("re_survey_campaigntitle")));
		campaignname.clear();
		Thread.sleep(3000);
		campaignname.sendKeys(properties.getProperty("re_survey_campaignname") + "_" + System.currentTimeMillis());
		Thread.sleep(3000);

		logger.info("click on Subject line");

		WebElement subjectline = driver.findElement(By.xpath(properties.getProperty("re_survey_subline"))); // Subject
																											// Line
		subjectline.clear();
		Thread.sleep(3000);
		subjectline.sendKeys("subject for redistributed survey campaign-");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);

		
		driver.findElement(By.xpath(properties.getProperty("select_contact_list"))).click(); // click on select
		Thread.sleep(8000);
		logger.info("Click on Search box");
		WebElement search_list = driver.findElement(By.xpath(properties.getProperty("click_search_box")));
		search_list.sendKeys("mounika");
		Thread.sleep(6000);
		
		
		  driver.findElement(By.xpath(properties.getProperty("click_search_icon"))).
		  click();
		  Thread.sleep(6000);
			
		  WebDriverWait wait1 = new WebDriverWait(driver, 50); // Wait till the element is not visible
			WebElement s_select = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("check_contact_list"))));
			s_select.click();
			

	}
}