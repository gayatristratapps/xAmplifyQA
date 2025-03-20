package com.xamplify.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.http.client.utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.rolling.action.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PartnerManageSurveyCampaign {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile(
			"D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");
	final Logger logger = LogManager.getLogger(PartnerManageSurveyCampaign.class);

	@Test
	public void manage_redsurveycamp() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, 50); // Wait till the element is not visible
		WebElement s_element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("re_Surveycampaignhover")))); // Hover the
																											// Campaign
																											// module
		s_element.click();
		logger.info("Hover the campaign module");
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("click_resurvey_manage_camp"))).click(); // Click on Manage
																									// campaigns
		Thread.sleep(5000);
		logger.info("Click on Manage campaign");

		driver.findElement(By.xpath(properties.getProperty("resurvey_click_survey_tab"))).click(); // Click on SurveyTab
		Thread.sleep(5000);
		logger.info("Click on the Survey tab");

		driver.findElement(By.xpath(properties.getProperty("click_dropdownarrow"))).click(); // Click on Gear icon
		Thread.sleep(3000);
		logger.info("Click on Edit");

		driver.findElement(By.xpath(properties.getProperty("click_rs_edit"))).click(); // Click on Edit
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_rs_edit_update"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_rs_close"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_dropdownarrow"))).click();
		Thread.sleep(3000);

		logger.info("Click on Preview");
		driver.findElement(By.xpath(properties.getProperty("click_rs_preview"))).click(); // Click on Preview
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("click_rs_cross"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_dropdownarrow"))).click();
		Thread.sleep(3000);
		logger.info("Click on Archive");
		driver.findElement(By.xpath(properties.getProperty("click_rs_archieve"))).click(); // Click on Archive under
																							// gear icon
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_rs_archievedcampaigns"))).click(); // Click on
																										// archived
																										// campaign
																										// button
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("drdwn_archd_camp"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_rs_unarchieve"))).click(); // Click on Unarchive under
																								// Archived campaigns
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_active_campaigns"))).click(); // Click on Active
																								// Campaigns
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_survey_tab"))).click(); // Survey tab
		Thread.sleep(5000);

		// Commented out delete functionality
		/*
		 * driver.findElement(By.xpath(properties.getProperty("click_drpdown_to_delete")
		 * )).click(); // delete Thread.sleep(4000);
		 * driver.findElement(By.xpath(properties.getProperty(
		 * "click_re_survey_camp_Delete"))).click(); Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("click_yes_del"))).click()
		 * ; Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("re_survey_tab"))).click()
		 * ; Thread.sleep(5000);
		 */

		logger.info("Click on Analytics icon under manage Campaigns");
		driver.findElement(By.xpath(properties.getProperty("click_re_Survey_Analytics"))).click(); // Click on Analytics
		Thread.sleep(3000);

		logger.info("Click on the Recipients");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementsByClassName('fa fa-user')");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_recepients_click"))).click(); // Click on
																										// Recipients
																										// tile
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_total_recepients_search_box"))) // Search
				.sendKeys("automate");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_total_recepients_search"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_icon_click"))).click(); // Export
																												// to
																												// excel
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_click"))).click();
		Thread.sleep(3000);

		Robot redsurvey_object1 = new Robot(); // Create object of Robot class to handle the download dialog
		redsurvey_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_total_recepients_cross_click"))).click();
		Thread.sleep(3000);

		logger.info("Click on the Total Email sent");
		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_total_email_sent"))).click(); // Total email
																										// sent
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_total_email_search_box")))
				.sendKeys("automated");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_total_emailsent_search"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_icon_click"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_click"))).click();
		Thread.sleep(3000);

		redsurvey_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_total_emailsent_cross_click"))).click();
		Thread.sleep(3000);

		logger.info("Click on the Deliverability");
		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_deliverability"))).click(); // Deliverability
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_delivered_email_search_box")))
				.sendKeys("automated");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_delivered_email_search"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_icon_click"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_click"))).click();
		Thread.sleep(3000);

		redsurvey_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("re_surveycamp_delivered_cross_click"))).click();
		Thread.sleep(3000);

		logger.info("Click on the Open rate");

		WebElement openrat = driver.findElement(By.xpath(properties.getProperty("re_surveycamp_openrate"))); // Open
																												// rate

		if (openrat.isEnabled()) {
			openrat.click();
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_emails_opened_by_recepients_search_box")))
					.sendKeys("automate");
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_emails_opened_by_recepients_search")))
					.click();
			Thread.sleep(3000);

			WebDriverWait wait_time_drdn = new WebDriverWait(driver, 50);
			WebElement w_time = wait_time_drdn.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("re_surveycamp_time_dropdown")))); // Select
																													// dropdown
			Thread.sleep(2000);

			Select w_t1 = new Select(w_time);
			w_t1.selectByValue("1: Object");
			Thread.sleep(2000);

			w_t1.selectByValue("2: Object");
			Thread.sleep(2000);

			w_t1.selectByValue("3: Object");
			Thread.sleep(2000);

			w_t1.selectByValue("4: Object");
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_op_export_excel_click"))).click();
			Thread.sleep(3000);
			redsurvey_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_openrate_cross_click"))).click();
			Thread.sleep(3000);

		} else {
			System.out.println("Openrate count is zero");
		}

		logger.info("Click on Active Recipients");

		WebElement activerec = driver.findElement(By.xpath(properties.getProperty("re_surveycamp_active_recepients"))); // Active
																														// Recipients
		if (activerec.isEnabled()) {

			activerec.click();
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_emails_opened_by_recepients_search_box")))
					.sendKeys("automate");
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_emails_opened_by_recepients_search")))
					.click();
			Thread.sleep(3000);

			WebDriverWait wait_time_drdn_2 = new WebDriverWait(driver, 50);
			WebElement w_time2 = wait_time_drdn_2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("re_surveycamp_time_dropdown")))); // Select
																													// time
																													// dropdown
			Thread.sleep(2000);

			Select w_t2 = new Select(w_time2);
			w_t2.selectByValue("1: Object");
			Thread.sleep(2000);
			w_t2.selectByValue("2: Object");
			Thread.sleep(2000);
			w_t2.selectByValue("3: Object");
			Thread.sleep(2000);
			w_t2.selectByValue("4: Object");

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_active_export_excel_click"))).click();
			Thread.sleep(3000);

			redsurvey_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_active_cross_click"))).click();
			Thread.sleep(3000);

		} else {
			System.out.println("Active recipients count is zero");
		}

		logger.info("Click on the Clicked URL tile");

		WebElement clickedurl = driver.findElement(By.xpath(properties.getProperty("re_surveycamp_clicked_URL"))); // Clicked
																													// URL
		if (clickedurl.isSelected()) {

			clickedurl.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_recepients_clicked_search_box")))
					.sendKeys("automate");
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_recepients_clicked_search"))).click();
			Thread.sleep(3000);

			WebDriverWait wait_time_drdn_3 = new WebDriverWait(driver, 50);
			WebElement w_time3 = wait_time_drdn_3.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("re_surveycamp_time_dropdown1")))); // Select
																													// time
																													// dropdown
			Thread.sleep(2000);

			Select w_t3 = new Select(w_time3);
			w_t3.selectByValue("1: Object");
			Thread.sleep(2000);
			w_t3.selectByValue("2: Object");
			Thread.sleep(2000);
			w_t3.selectByValue("3: Object");
			Thread.sleep(2000);
			w_t3.selectByValue("4: Object");
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_icon_click"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_click"))).click();
			Thread.sleep(3000);

			redsurvey_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_url_cross_click"))).click();
			Thread.sleep(3000);

		} else {
			System.out.println("Clicked URL count is zero");
		}

		logger.info("Click on Hard bounce");

		WebElement hardbounce = driver.findElement(By.xpath(properties.getProperty("re_surveycamp_click_Hardbounce"))); // Hard
																														// bounce
		if (hardbounce.isEnabled()) {
			hardbounce.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_hardbounce_close")));
			Thread.sleep(3000);
		} else {
			System.out.println("Hard bounce value is Zero");
		}

		logger.info("Click on Soft bounce");

		WebElement softbounce = driver.findElement(By.xpath(properties.getProperty("re_surveycamp_click_softbounce"))); // Soft
																														// bounce
		if (softbounce.isEnabled()) {
			softbounce.click();
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_icon_click"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_export_excel_click"))).click();
			Thread.sleep(3000);

			redsurvey_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_softbounce_close")));
			Thread.sleep(3000);
		} else {
			System.out.println("Soft bounce value is Zero");
		}

		logger.info("Click on Unsubscribe");

		WebElement unsubscribe = driver
				.findElement(By.xpath(properties.getProperty("re_surveycamp_click_unsubscribe"))); // Unsubscribe
		if (unsubscribe.isSelected()) {
			unsubscribe.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_surveycamp_unsubscribe_close")));
			Thread.sleep(3000);
		} else {
			System.out.println("Unsubscribe value is Zero");
		}

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);

		WebDriverWait wait_eml_sortby = new WebDriverWait(driver, 50);
		WebElement eml_sort = wait_eml_sortby.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(properties.getProperty("re_surveycamp_total_email_camp_sort_by")))); // Select total email
																								// opened dropdown
		Thread.sleep(2000);

		Select eml_sort1 = new Select(eml_sort);
		eml_sort1.selectByValue("1: Object");
		Thread.sleep(2000);
		eml_sort1.selectByValue("2: Object");
		Thread.sleep(2000);
		eml_sort1.selectByValue("3: Object");
		Thread.sleep(2000);
		eml_sort1.selectByValue("4: Object");
		Thread.sleep(2000);

		WebElement s_analytics_search = driver
				.findElement(By.xpath(properties.getProperty("re_survey_analytics_search"))); // Search
		s_analytics_search.sendKeys("mounika");
		s_analytics_search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		s_analytics_search.clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("re_survey_analytics_cross"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("re_survey_export_excel"))).click();
		Thread.sleep(5000);

		redsurvey_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_on_email_details"))).click();
		Thread.sleep(5000);

		logger.info("Click on Register lead button");
		driver.findElement(By.xpath(properties.getProperty("click_on_register_lead_button"))).click(); // Click on
																										// Register lead
																										// button
		Thread.sleep(5000);

		logger.info("Click on Select pipeline Dropdown");
		WebDriverWait wait_pipeline_dropdwn = new WebDriverWait(driver, 50);
		WebElement sel_pipeline = wait_pipeline_dropdwn.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("click_pipeline_dropdown")))); // Select
																											// pipeline
																											// stage
																											// dropdown

		Select pipeline = new Select(sel_pipeline);

		pipeline.selectByVisibleText("Converted");
		Thread.sleep(2000);

		pipeline.selectByVisibleText("Opened");
		Thread.sleep(2000);
		pipeline.selectByVisibleText("Contacted");
		Thread.sleep(2000);

		logger.info("click on Firstname");
		WebElement lead_firstname = driver.findElement(By.xpath(properties.getProperty("re_survey_leadfirstname"))); // First
		lead_firstname.clear();
		lead_firstname.sendKeys(properties.getProperty("leadfirstname") + "_" + System.currentTimeMillis());// name
		Thread.sleep(3000);

		logger.info("click on Lastname");

		WebElement lead_lastname = driver.findElement(By.xpath(properties.getProperty("re_survey_leadlastname"))); // Lastname

		lead_lastname.clear();
		lead_lastname.sendKeys(properties.getProperty("leadlastname") + "_" + System.currentTimeMillis());// name
		Thread.sleep(3000);

		WebElement companyNameField = driver.findElement(By.xpath(properties.getProperty("leadcompany")));

		// Get the current value of the company name field
		String currentCompanyName = companyNameField.getAttribute("value");

		// Check if the company name is not empty
		if (currentCompanyName != null && !currentCompanyName.isEmpty()) {
			System.out.println("Company name exists: " + currentCompanyName);
		} else {
			// If the company name is empty, fill it with a default company name
			String defaultCompanyName = "Automation Xamplify Company";
			companyNameField.sendKeys(defaultCompanyName);
			System.out.println("Company name filled: " + defaultCompanyName);
		}

		logger.info("click on Address");
		WebElement address = driver.findElement(By.xpath(properties.getProperty("click_on_address"))); // Address
		address.clear();
		Thread.sleep(2000);
		address.sendKeys("Lead_Address");
		Thread.sleep(2000);
		WebElement city = driver.findElement(By.xpath(properties.getProperty("click_on_city"))); // city
		city.clear();
		Thread.sleep(2000);
		city.sendKeys("Hyderabad");
		Thread.sleep(2000);
		WebElement state = driver.findElement(By.xpath(properties.getProperty("click_on_state"))); // State
		state.clear();
		Thread.sleep(2000);
		state.sendKeys("Telangana");
		Thread.sleep(2000);
		WebElement postalcode = driver.findElement(By.xpath(properties.getProperty("click_on_postalcode"))); // postalcode
		postalcode.clear();
		Thread.sleep(2000);
		postalcode.sendKeys("500050");
		WebElement phone = driver.findElement(By.xpath(properties.getProperty("click_on_phonenum"))); // Phone number
		phone.clear();
		Thread.sleep(2000);
		phone.sendKeys("9959710197");
		Thread.sleep(2000);

		WebDriverWait wait_country_dropdwn = new WebDriverWait(driver, 50);
		WebElement country = wait_country_dropdwn.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("click_country"))));
		country.clear();
		Thread.sleep(2000);// Select
		country.sendKeys("India"); // country

		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("click_submit_lead"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("click_lead_Close_button"))).click();
		Thread.sleep(3000);

		logger.info("Click on Leads");

		try {
			WebElement leads = driver.findElement(By.xpath(properties.getProperty("click_leads")));

			// Ensure "Leads" button is enabled before clicking
			if (leads.isEnabled()) {
				leads.click();
				Thread.sleep(3000);

				driver.findElement(By.xpath(properties.getProperty("lead_search_click"))).sendKeys("auto_lead");
				Thread.sleep(3000);
				driver.findElement(By.xpath(properties.getProperty("lead_search_icon_click"))).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(properties.getProperty("lead_clear"))).click();
				Thread.sleep(3000);

				// Check if "Register Deal" button exists
				List<WebElement> registerDeal = driver
						.findElements(By.xpath(properties.getProperty("click_on_register_deal_button")));
				if (!registerDeal.isEmpty()) {
					System.out.println("Clicking on Register Deal button...");
					registerDeal.get(0).click();
					Thread.sleep(3000);

					WebDriverWait waitDealPipeline = new WebDriverWait(driver, 50); // 50 seconds

					WebElement selDealPipeline = waitDealPipeline.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(properties.getProperty("click_pipeline_dropdown"))));
					selDealPipeline.sendKeys("Open");

					Actions keyDown = new Actions(driver);
					keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
					Thread.sleep(3000);

					driver.findElement(By.xpath(properties.getProperty("click_on_deal_name")))
							.sendKeys("Automation_deal_" + System.currentTimeMillis());
					Thread.sleep(3000);

					driver.findElement(By.xpath(properties.getProperty("click_deal_amount"))).sendKeys("1000");
					Thread.sleep(3000);
					driver.findElement(By.xpath(properties.getProperty("click_close_date"))).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath(properties.getProperty("select_close_date"))).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath(properties.getProperty("click_on_save_deal"))).click();
					Thread.sleep(4000);
			
				} 
				
				else {
					System.out.println("Register Deal button not found, proceeding with alternative logic...");
				

				
				
				// Click on Filter
				WebElement filter_lead = driver.findElement(By.xpath(properties.getProperty("re_surv_click_filter")));
				filter_lead.click();
				Thread.sleep(3000);

				// Select "From Date"
				driver.findElement(By.xpath(properties.getProperty("click_From_date_field"))).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(properties.getProperty("Select_Fromdate"))).click();
				Thread.sleep(4000);

				// Select "To Date"
				driver.findElement(By.xpath(properties.getProperty("click_To_date_field"))).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(properties.getProperty("Select_Todate"))).click();
				Thread.sleep(3000);

				// Apply Filters
				System.out.println("Applying Filters...");

				WebElement filter_button = driver.findElement(By.xpath(properties.getProperty("click_filter_button")));
				filter_button.click();
				Thread.sleep(3000);

				

				driver.findElement(By.xpath(properties.getProperty("apply_filter_cross"))).click();
				Thread.sleep(3000);

				WebElement export_Excel = driver
						.findElement(By.xpath(properties.getProperty("click_leads_Export_Excel")));
				export_Excel.click();
				Thread.sleep(5000);

				Robot redsurv_object1 = new Robot(); // Create object of Robot class to handle the download dailog
				redsurv_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
				Thread.sleep(4000);

				// Close Leads Section
				driver.findElement(By.xpath(properties.getProperty("leads_close"))).click();
				Thread.sleep(3000);

			} 
				
				
			}
			
			else {
				System.out.println("Leads count is Zero, skipping further execution.");
			}

		}
		
		catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
		
		
		Thread.sleep(2000);	
		
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(properties.getProperty("leads_close"))));
		Thread.sleep(3000);
		WebElement close_lead = driver.findElement(By.xpath(properties.getProperty("leads_close")));
		close_lead.click();
		Thread.sleep(2000);		
		logger.info("Click on Deals");

		WebElement re_camp_deals = driver.findElement(By.xpath(properties.getProperty("re_survey_camp_click_deals")));

		if (re_camp_deals.isEnabled()) {
			WebDriverWait waitre = new WebDriverWait(driver, 30); // Wait until elements are visible
			waitre.until(ExpectedConditions.elementToBeClickable(re_camp_deals));

			re_camp_deals.click(); // Click on Deal Tile
			
			Thread.sleep(3000);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("re_survey_camp_deal_search_click"))));

			driver.findElement(By.xpath(properties.getProperty("re_survey_camp_deal_search_click")))
					.sendKeys("auto_deal");
			driver.findElement(By.xpath(properties.getProperty("re_survey_camp_deal_search_icon_click"))).click(); // Search
																													// icon
																													// click
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("re_survey_camp_deals_clear_search"))));

			driver.findElement(By.xpath(properties.getProperty("re_survey_camp_deals_clear_search"))).click();

			Thread.sleep(3000);
			logger.info("Click on Deal Preview");
			WebElement deal_preview = driver.findElement(By.xpath(properties.getProperty("re_survey_deal_preview"))); // preview
																														// deal
			deal_preview.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(properties.getProperty("re_survey_deal_preview_close"))));
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("re_survey_deal_preview_close"))).click();
			logger.info("Click on Deal edit");
			
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_survey_deal_click_edit"))).click(); // Edit Deal

			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("re_survey_update_deal"))));
			driver.findElement(By.xpath(properties.getProperty("re_survey_update_deal"))).click(); 
			Thread.sleep(3000);// Update Deal

			logger.info("Click on filter");
			driver.findElement(By.xpath(properties.getProperty("re_survey_click_deal_filter"))).click(); 
			Thread.sleep(3000);// Click on filter

			// Select "From Date"
			driver.findElement(By.xpath(properties.getProperty("click_From_date_field"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("Select_Fromdate_deal"))).click();
			Thread.sleep(4000);

			// Select "To Date"
			driver.findElement(By.xpath(properties.getProperty("click_To_date_field"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("Select_Todate_deal"))).click();
			Thread.sleep(3000);

			logger.info("Click on Deal filter");
			driver.findElement(By.xpath(properties.getProperty("re_survey_click_filter_button"))).click(); // Click on
																											// Deal
																											// filter
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_survey_apply_filter_cross"))).click();
			logger.info("Click on Deal download");
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("re_survey_click_download_deal"))).click();
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("re_survey_deals_close"))));

			driver.findElement(By.xpath(properties.getProperty("re_survey_deals_close"))).click();
			Thread.sleep(3000);
		} else {
			System.out.println("Deals count is Zero");
		}

		logger.info("Click on Navigation Breadcrumb");

		WebElement navigation = driver.findElement(By.xpath(properties.getProperty("click_navigation_breadcrumb"))); // Click
																														// on
																														// Manage
																														// Campaign
																														// navigation
		navigation.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("re_survey_tab"))));
		WebElement Surveytab = driver.findElement(By.xpath(properties.getProperty("re_survey_tab"))); // Survey tab
		Surveytab.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("red_hover_listview"))));

		WebElement hover_views = driver.findElement(By.xpath(properties.getProperty("red_hover_listview")));
		hover_views.click();
		Thread.sleep(3000);

		// Calendar view
		WebElement calendarview = driver.findElement(By.xpath(properties.getProperty("click_calendar_view")));
		calendarview.click();
		Thread.sleep(5000);

		WebElement calendar_Weekview= driver.findElement(By.xpath(properties.getProperty("click_calendar_week_view")));
		calendar_Weekview.click();// Week View
		Thread.sleep(3000);
//		wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("click_calendar_day_view"))));
//		driver.findElement(By.xpath(properties.getProperty("click_calendar_day_view"))).click(); 
//		Thread.sleep(3000);// Day View

		driver.findElement(By.xpath(properties.getProperty("click_navigation_breadcrumb"))).click(); // breadcrumb
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("re_survey_tab"))));
		driver.findElement(By.xpath(properties.getProperty("re_survey_tab"))).click();
		Thread.sleep(3000);// survey tab

		driver.findElement(By.xpath(properties.getProperty("red_hover_listview"))).click();
		Thread.sleep(3000);// Hover on views
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("red_click_grid_view"))));

		logger.info("Click on Grid View");
		driver.findElement(By.xpath(properties.getProperty("red_click_grid_view"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("red_hover_listview"))));

		driver.findElement(By.xpath(properties.getProperty("red_hover_listview"))).click();
		Thread.sleep(3000);// Hover on views
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(properties.getProperty("red_click_folder_grid_view"))));

		logger.info("Click on Folder Grid View");
		driver.findElement(By.xpath(properties.getProperty("red_click_folder_grid_view"))).click();
		Thread.sleep(3000);

		WebElement fgv_search = driver.findElement(By.xpath(properties.getProperty("red_fgv_search")));
		fgv_search.sendKeys("automate"); // click on search bar under folder grid view
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("red_viewsearch_click"))));
		driver.findElement(By.xpath(properties.getProperty("red_viewsearch_click"))).click(); // click on search icon
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("cross_button"))));
		driver.findElement(By.xpath(properties.getProperty("cross_button"))).click();
		

		WebDriverWait wait_f_sortby = new WebDriverWait(driver, 50);
		WebElement w_f_sort = wait_f_sortby
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("ms_f_sortby")))); // select
																														// sort
																														// by
																														// dropdown
		wait.until(ExpectedConditions.elementToBeClickable(w_f_sort));

		Select f_sort1 = new Select(w_f_sort);

		f_sort1.selectByVisibleText("Name (A-Z)");
		wait.until(ExpectedConditions.elementToBeClickable(w_f_sort));
		f_sort1.selectByVisibleText("Name (Z-A)");
		wait.until(ExpectedConditions.elementToBeClickable(w_f_sort));
		f_sort1.selectByVisibleText("Created On (ASC)");
		wait.until(ExpectedConditions.elementToBeClickable(w_f_sort));
		f_sort1.selectByVisibleText("Created On (DESC)");

		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("red_hover_fgview"))).click();
		Thread.sleep(3000);// Hover on views
		logger.info("Click on Folder List View");
		driver.findElement(By.xpath(properties.getProperty("red_click_folder_list_view"))).click(); // Click on folder list view
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("red_flv_search"))));
		driver.findElement(By.xpath(properties.getProperty("red_flv_search"))).sendKeys("automate"); // click on search bar
																									// under folder list
																									// view
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("red_viewsearch_click"))));
		driver.findElement(By.xpath(properties.getProperty("red_viewsearch_click"))).click(); // click on search icon
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("cross_button"))));
		driver.findElement(By.xpath(properties.getProperty("cross_button"))).click();
		Thread.sleep(3000);

		logger.info("Click on Listview");
		driver.findElement(By.xpath(properties.getProperty("red_hover_flview"))).click(); // Click on List View
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("red_hover_listview1"))).click();
		Thread.sleep(3000);// Hover on views
		

		logger.info("Manage Redistributed Survey Campaign Successfully Completed");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(properties.getProperty("click_navigation_home"))).click(); // breadcrumb
		Thread.sleep(3000);
	}

}
