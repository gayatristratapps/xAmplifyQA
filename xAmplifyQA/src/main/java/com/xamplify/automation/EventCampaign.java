package com.xamplify.automation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EventCampaign {

	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\EventCampaign.properties");

	final Logger logger = LogManager.getLogger(EventCampaign.class);

	@Test
	public void event_campaign() throws InterruptedException, SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 50); // Wait till the element is not visible

		WebElement eve_campele = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("event_campaignhover"))));
		eve_campele.click(); // hover on campaign

		Actions camp_action = new Actions(driver);
		camp_action.moveToElement(eve_campele).perform();
		Thread.sleep(5000);
		WebElement create_campele = driver.findElement(By.xpath(properties.getProperty("event_createcampaign"))); // click
																													// on
																													// create
																													// campaign
		camp_action.moveToElement(create_campele);
		camp_action.click();
		camp_action.perform();
		Thread.sleep(5000);
		WebDriverWait waitc = new WebDriverWait(driver, 40);
		WebElement opencamp = waitc.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("event_opencampaign")))); // select
																														// event
																														// campaign
		opencamp.click();

		logger.info("Selected the Event campaign");
		Thread.sleep(4000);
		
		driver.findElement(By.id(properties.getProperty("event_tittle")))
				.sendKeys(properties.getProperty("eve_name") + "_" + System.currentTimeMillis());

		driver.findElement(By.xpath(properties.getProperty("eve_subjectline"))).sendKeys("subjectLine_eve"); // subjectline
		Thread.sleep(3000);

		/*
		 * Actions a = new Actions(driver); // scroll down a page
		 * a.sendKeys(Keys.PAGE_DOWN).build().perform();
		 * 
		 * Thread.sleep(3000);
		 */

		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		WebElement w3 = wait3
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("eve_through")))); // toggle  through on

		w3.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("eve_selectpublic"))).click(); // select public toggle

		Thread.sleep(4000);

		/*
		 * driver.findElement(By.xpath(properties.getProperty("eve_configurepipeline")))
		 * .click(); // Toggle configure // pipeline ON
		 * 
		 * Thread.sleep(6000);
		 */

		driver.findElement(By.xpath(properties.getProperty("eve_showformsbutton"))).click(); // click on the showforms
																								// button

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("eve_form_preview"))).click(); // preview the form

		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("eve_form_preview_close"))).click(); // close the form
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("eve_selectform"))).click(); // select the form

		Thread.sleep(2000);
		logger.info("Selected the form");
		driver.findElement(By.xpath(properties.getProperty("eve_closeform"))).click(); // close the form
		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("eve_selectdate"))).click(); // select date in calendaar 

		Thread.sleep(7000);

		WebElement w = driver.findElement(By.xpath(properties.getProperty("eve_selected_date"))); // selected date in
																									// the calendar

		w.click();

		Thread.sleep(5000);
		driver.findElement(By.id("allDay")).click();
		logger.info("Selected the Event date ");

		Thread.sleep(4000);
		
		 Actions a = new Actions(driver); // scroll down a page
		 a.sendKeys(Keys.PAGE_DOWN).build().perform();
		 
		  Thread.sleep(3000);

		WebElement drpCountry = driver.findElement(By.xpath(properties.getProperty("timezone_select_country"))); // select
																													// the
																													// country
		// drpCountry.click();
		Select eve_select_country = new Select(drpCountry); // select drop down
		Thread.sleep(5000);
		eve_select_country.selectByValue("103");
		Thread.sleep(4000);
		
		  logger.info("Selected India in the country dropdown ");
		 
		  
		 
			/*
			 * Actions a2 = new Actions(driver);
			 * a2.sendKeys(Keys.PAGE_DOWN).build().perform(); // scroll down a page
			 */
		driver.findElement(By.xpath(properties.getProperty("eve_nextpage"))).click(); // click for the next page
		Thread.sleep(3000);

		Actions a3 = new Actions(driver);
		a3.sendKeys(Keys.PAGE_UP).build().perform(); // scroll up the page

		WebElement w_evedropdown = driver.findElement(By.xpath(properties.getProperty("eve_select_dropdown"))); // drop
																												// down

		Select eve_dropdown1 = new Select(w_evedropdown);
		eve_dropdown1.selectByVisibleText("Created On(ASC)");

		WebDriverWait wait_search = new WebDriverWait(driver, 50);
		WebElement waitsearch_partner = wait_search.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("eve_search_select_partnerlist_click")))); // Search
																														// for
																														// partner
																														// list
		waitsearch_partner.sendKeys("Active Master");

		waitsearch_partner.sendKeys(Keys.ENTER); // Click on search
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("eve_selectpartnerlist_checkbox"))).click(); // select 1st
																										// checkbox

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("eve_partnerlist_preview"))).click(); // preview the partner
																									// list

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("eve_close_partnerlist_preview"))).click(); // close the
																										// partner list

		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("eve_nextpage2"))).click(); // click for the next page

		Thread.sleep(2000);

		WebElement search = driver.findElement(By.xpath(properties.getProperty("eve_template_search"))); // click on the
																											// searchbar
		search.sendKeys("Event");
		search.sendKeys(Keys.ENTER);

		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("eve_select_template"))).click(); // select the template

		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("eve_select_template_preview"))).click();// preview the
																										// template
		
		
		String originalWindow = driver.getWindowHandle();//store the current window handle
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // wait for new tab to open
		Thread.sleep(5000);
			
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //get all windows handle
			
		driver.switchTo().window(tabs.get(1)); //switch to the new tab
			
		Thread.sleep(6000);
			
			/*
			 * WebElement companylogoNewTab =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.
			 * getProperty("")))); companylogoNewTab.click(); //perform actions in new tab
			 */			
		driver.close(); // switch back to original tab and close the new tab
			
		driver.switchTo().window(tabs.get(0));
			
		Thread.sleep(3000);

	
		driver.findElement(By.xpath(properties.getProperty("eve_hover_on_selected_template"))).click(); // close the
																											// preview
																											// of the
																											// template

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("eve_template_editicon"))).click(); // click on the edit icon
																								// of the template

		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("eve_template_editicon_close"))).click(); // close the
																										// template

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("eve_nextpage3"))).click(); // click on the next page

	}

}