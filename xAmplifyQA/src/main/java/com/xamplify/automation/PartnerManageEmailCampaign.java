
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

public class PartnerManageEmailCampaign {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile(
			"D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");
	final Logger logger = LogManager.getLogger(PartnerManageEmailCampaign.class);

	@Test
	public void manage_redemailcamp() throws InterruptedException, AWTException {

		WebDriverWait wait_me = new WebDriverWait(driver, 80); // Wait till the element is not visible
		WebElement email_element = wait_me.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("re_ecampaignhover")))); // Hover
																														// the
																														// Campaign
																														// module
		email_element.click();
		logger.info("Hover the campaign module");
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("click_reemail_manage_camp"))).click(); // Click on Manage
																									// campaigns
		Thread.sleep(5000);
		logger.info("Click on Manage campaign");

		driver.findElement(By.xpath(properties.getProperty("manage_reemail_click_email_tab"))).click(); // Click on
																										// EmailTAb
		Thread.sleep(5000);
		logger.info("Click on the Email tab");

		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_dropdownarrow"))).click(); // Click on
																											// Gear icon
		Thread.sleep(3000);
		logger.info("Click on Edit");

		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_edit"))).click(); // Click on Edit
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_edit_update"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_close"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_dropdownarrow"))).click();
		Thread.sleep(3000);

		logger.info("Click on Preview");
		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_preview"))).click(); // Click on Preview
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_cross"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_dropdownarrow"))).click();
		Thread.sleep(3000);
		logger.info("Click on Archive");
		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_archieve"))).click(); // Click on
																										// Archive under
		// gear icon
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_archievedcampaigns"))).click(); // Click
																												// on
		// archived
		// campaign
		// button
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemail_drdwn_archd_camp"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_unarchieve"))).click(); // Click on
																										// Unarchive
																										// under
		// Archived campaigns
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_active_campaigns"))).click(); // Click
																												// on
																												// Active
		// Campaigns
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemail_tab"))).click(); // Email tab
		Thread.sleep(5000);

		// Commented out delete functionality
		/*
		 * driver.findElement(By.xpath(properties.getProperty(
		 * "clickmanage_reemail_drpdown_to_delete") )).click(); // delete
		 * Thread.sleep(4000); driver.findElement(By.xpath(properties.getProperty(
		 * "clickmanage_reemail_Delete"))).click(); Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty(
		 * "clickmanage_reemail_yes_del"))).click() ; Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("manage_reemail_tab"))).
		 * click() ; Thread.sleep(5000);
		 */

		logger.info("Click on Analytics icon under manage Campaigns");
		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_Analytics"))).click(); // Click on
																										// Analytics
		Thread.sleep(3000);

		logger.info("Click on the Recipients");

		JavascriptExecutor jsem = (JavascriptExecutor) driver;
		jsem.executeScript("document.getElementsByClassName('fa fa-user')");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_recepients_click"))).click(); // Click on
		// Recipients
		// tile
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_total_recepients_search_box"))) // Search
				.sendKeys("automate");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_total_recepients_search"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_icon_click"))).click(); // Export
		// to
		// excel
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_click"))).click();
		Thread.sleep(3000);

		Robot redm_email_object1 = new Robot(); // Create object of Robot class to handle the download dialog
		redm_email_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_total_recepients_cross_click"))).click();
		Thread.sleep(3000);

		logger.info("Click on the Total Email sent");
		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_total_email_sent"))).click(); // Total
																												// email
		// sent
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_total_email_search_box")))
				.sendKeys("automated");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_total_emailsent_search"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_icon_click"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_click"))).click();
		Thread.sleep(3000);

		redm_email_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_total_emailsent_cross_click"))).click();
		Thread.sleep(3000);

		logger.info("Click on the Deliverability");
		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_deliverability"))).click(); // Deliverability
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_delivered_email_search_box")))
				.sendKeys("automated");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_delivered_email_search"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_icon_click"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_click"))).click();
		Thread.sleep(3000);

		redm_email_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_delivered_cross_click"))).click();
		Thread.sleep(3000);

		logger.info("Click on the Open rate");

		WebElement openrat = driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_openrate"))); // Open
																													// rate

		if (openrat.isEnabled()) {
			openrat.click();
			Thread.sleep(3000);

			driver.findElement(
					By.xpath(properties.getProperty("manage_reemailcamp_emails_opened_by_recepients_search_box")))
					.sendKeys("automate");
			Thread.sleep(3000);

			driver.findElement(
					By.xpath(properties.getProperty("manage_reemailcamp_emails_opened_by_recepients_search"))).click();
			Thread.sleep(3000);

			WebDriverWait wait_time_drdn1 = new WebDriverWait(driver, 50);
			WebElement w_etime = wait_time_drdn1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("manage_reemailcamp_time_dropdown")))); // Select
			// dropdown
			Thread.sleep(2000);

			Select w_tme = new Select(w_etime);
			w_tme.selectByValue("1: Object");
			Thread.sleep(2000);

			w_tme.selectByValue("2: Object");
			Thread.sleep(2000);

			w_tme.selectByValue("3: Object");
			Thread.sleep(2000);

			w_tme.selectByValue("4: Object");
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_op_export_excel_click"))).click();
			Thread.sleep(3000);
			redm_email_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_openrate_cross_click"))).click();
			Thread.sleep(3000);

		} else {
			System.out.println("Openrate count is zero");
		}

		logger.info("Click on Active Recipients");

		WebElement activerec = driver
				.findElement(By.xpath(properties.getProperty("manage_reemailcamp_active_recepients"))); // Active
		// Recipients
		if (activerec.isEnabled()) {

			activerec.click();
			Thread.sleep(3000);

			driver.findElement(
					By.xpath(properties.getProperty("manage_reemailcamp_emails_opened_by_recepients_search_box")))
					.sendKeys("automate");
			Thread.sleep(3000);

			driver.findElement(
					By.xpath(properties.getProperty("manage_reemailcamp_emails_opened_by_recepients_search"))).click();
			Thread.sleep(3000);

			WebDriverWait wait_time_drdn_2 = new WebDriverWait(driver, 50);
			WebElement w_time2 = wait_time_drdn_2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("manage_reemailcamp_time_dropdown")))); // Select
			// time
			// dropdown
			Thread.sleep(2000);

			Select w_t2me = new Select(w_time2);
			w_t2me.selectByValue("1: Object");
			Thread.sleep(2000);
			w_t2me.selectByValue("2: Object");
			Thread.sleep(2000);
			w_t2me.selectByValue("3: Object");
			Thread.sleep(2000);
			w_t2me.selectByValue("4: Object");

			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_active_export_excel_click")))
					.click();
			Thread.sleep(3000);

			redm_email_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_active_cross_click"))).click();
			Thread.sleep(3000);

		} else {
			System.out.println("Active recipients count is zero");
		}

		logger.info("Click on the Clicked URL tile");

		WebElement clickedurl = driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_clicked_URL"))); // Clicked
		// URL
		if (clickedurl.isSelected()) {

			clickedurl.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_recepients_clicked_search_box")))
					.sendKeys("automate");
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_recepients_clicked_search")))
					.click();
			Thread.sleep(3000);

			WebDriverWait wait_time_drdn_3me = new WebDriverWait(driver, 50);
			WebElement w_time3me = wait_time_drdn_3me.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(properties.getProperty("manage_reemailcamp_time_dropdown1")))); // Select
			// time
			// dropdown
			Thread.sleep(2000);

			Select w_t3me = new Select(w_time3me);
			w_t3me.selectByValue("1: Object");
			Thread.sleep(2000);
			w_t3me.selectByValue("2: Object");
			Thread.sleep(2000);
			w_t3me.selectByValue("3: Object");
			Thread.sleep(2000);
			w_t3me.selectByValue("4: Object");
			Thread.sleep(2000);

			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_icon_click"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_click"))).click();
			Thread.sleep(3000);

			redm_email_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_url_cross_click"))).click();
			Thread.sleep(3000);

		} else {
			System.out.println("Clicked URL count is zero");
		}

		logger.info("Click on Hard bounce");

		WebElement hardbounce = driver
				.findElement(By.xpath(properties.getProperty("manage_reemailcamp_click_Hardbounce"))); // Hard
		// bounce
		if (hardbounce.isEnabled()) {
			hardbounce.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_hardbounce_close")));
			Thread.sleep(3000);
		} else {
			System.out.println("Hard bounce value is Zero");
		}

		logger.info("Click on Soft bounce");

		WebElement softbounce = driver
				.findElement(By.xpath(properties.getProperty("manage_reemailcamp_click_softbounce"))); // Soft
		// bounce
		if (softbounce.isEnabled()) {
			softbounce.click();
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_icon_click"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_export_excel_click"))).click();
			Thread.sleep(3000);

			redm_email_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_softbounce_close")));
			Thread.sleep(3000);
		} else {
			System.out.println("Soft bounce value is Zero");
		}

		logger.info("Click on Unsubscribe");

		WebElement unsubscribe = driver
				.findElement(By.xpath(properties.getProperty("manage_reemailcamp_click_unsubscribe"))); // Unsubscribe
		if (unsubscribe.isSelected()) {
			unsubscribe.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("manage_reemailcamp_unsubscribe_close")));
			Thread.sleep(3000);
		} else {
			System.out.println("Unsubscribe value is Zero");
		}

		JavascriptExecutor js1me = (JavascriptExecutor) driver;
		js1me.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);

		WebDriverWait wait_eml_sortby = new WebDriverWait(driver, 50);
		WebElement eml_sort = wait_eml_sortby.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(properties.getProperty("manage_reemailcamp_total_email_camp_sort_by")))); // Select total email
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

		WebElement memaill_analytics_search = driver
				.findElement(By.xpath(properties.getProperty("manage_reemail_analytics_search"))); // Search
		memaill_analytics_search.sendKeys("mounika");
		memaill_analytics_search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		memaill_analytics_search.clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("manage_reemail_analytics_cross"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("manage_reemail_export_excel"))).click();
		Thread.sleep(5000);

		redm_email_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_on_manage_reemail_email_details"))).click();
		Thread.sleep(5000);

		logger.info("Click on Register lead button");
		driver.findElement(By.xpath(properties.getProperty("click_on_manage_reemail_register_lead_button"))).click(); // Click
																														// on
		// Register lead
		// button
		Thread.sleep(5000);

		logger.info("Click on Select pipeline Dropdown");
		WebDriverWait wait_pipeline_dropdwn = new WebDriverWait(driver, 50);
		WebElement sel_pipeline = wait_pipeline_dropdwn.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(properties.getProperty("click_manage_reemail_pipeline_dropdown")))); // Select
		// pipeline
		// stage
		// dropdown

		Select me_leadpipeline = new Select(sel_pipeline);

		me_leadpipeline.selectByVisibleText("Converted");
		Thread.sleep(2000);

		me_leadpipeline.selectByVisibleText("Opened");
		Thread.sleep(2000);
		me_leadpipeline.selectByVisibleText("Contacted");
		Thread.sleep(2000);

		logger.info("click on Firstname");
		WebElement lead_firstname = driver
				.findElement(By.xpath(properties.getProperty("manage_reemail_leadfirstname"))); // First
		lead_firstname.clear();
		lead_firstname.sendKeys(properties.getProperty("leadfirstname") + "_" + System.currentTimeMillis());// name
		Thread.sleep(3000);

		logger.info("click on Lastname");

		WebElement lead_lastname = driver.findElement(By.xpath(properties.getProperty("manage_reemail_leadlastname"))); // Lastname

		lead_lastname.clear();
		lead_lastname.sendKeys(properties.getProperty("leadlastname") + "_" + System.currentTimeMillis());// name
		Thread.sleep(3000);

		WebElement companyNameField = driver
				.findElement(By.xpath(properties.getProperty("manage_reemail_leadcompany")));

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
		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_submit_lead"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_lead_Close_button"))).click();
		Thread.sleep(3000);

		logger.info("Click on Leads");

		try {
			WebElement me_leads = driver.findElement(By.xpath(properties.getProperty("clickmanage_reemail_leads")));

			// Ensure "Leads" button is enabled before clicking
			if (me_leads.isEnabled()) {
				me_leads.click();
				Thread.sleep(3000);

				driver.findElement(By.xpath(properties.getProperty("manage_reemail_lead_search_click")))
						.sendKeys("auto_lead");
				Thread.sleep(3000);
				driver.findElement(By.xpath(properties.getProperty("manage_reemail_lead_search_icon_click"))).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(properties.getProperty("manage_reemail_lead_clear"))).click();
				Thread.sleep(3000);

				// Check if "Register Deal" button exists
				List<WebElement> registerDeal = driver
						.findElements(By.xpath(properties.getProperty("click_on_manage_reemail_register_deal_button")));
				if (!registerDeal.isEmpty()) {
					System.out.println("Clicking on Register Deal button...");
					registerDeal.get(0).click();
					Thread.sleep(3000);

					WebDriverWait waitDealPipeline = new WebDriverWait(driver, 50); // 50 seconds

					WebElement selDealPipeline = waitDealPipeline.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(properties.getProperty("click_manage_reemail_pipeline_dropdown"))));
					selDealPipeline.sendKeys("Open");

					Actions keyDown = new Actions(driver);
					keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
					Thread.sleep(3000);

					driver.findElement(By.xpath(properties.getProperty("click_on_manage_reemail_deal_name")))
							.sendKeys("Automation_deal_" + System.currentTimeMillis());
					Thread.sleep(3000);

					driver.findElement(By.xpath(properties.getProperty("click_deal_amount"))).sendKeys("1000");
					Thread.sleep(8000);
					driver.findElement(By.xpath(properties.getProperty("click_close_date"))).click();
					Thread.sleep(7000);
					driver.findElement(By.xpath(properties.getProperty("select_close_date"))).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath(properties.getProperty("click_on_save_deal"))).click();
					Thread.sleep(5000);

				}

				else {
					System.out.println("Register Deal button not found, proceeding with alternative logic...");
				}

				// Click on Filter
				WebElement filter_lead = driver
						.findElement(By.xpath(properties.getProperty("manage_reemail_lead_click_filter")));
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

				WebElement filter_button = driver
						.findElement(By.xpath(properties.getProperty("click_lead_filter_button")));
				filter_button.click();
				Thread.sleep(3000);

				driver.findElement(By.xpath(properties.getProperty("apply_lead_filter_cross"))).click();
				Thread.sleep(5000);

				WebElement emailcamp_leads_export_Excel = driver
						.findElement(By.xpath(properties.getProperty("click_leads_Export_Excel")));
				emailcamp_leads_export_Excel.click();
				Thread.sleep(5000);

				Robot redemail_m_object1 = new Robot(); // Create object of Robot class to handle the download dailog
				redemail_m_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
				Thread.sleep(4000);

				// Close Leads Section
				driver.findElement(By.xpath(properties.getProperty("manage_emailleads_close"))).click();
				Thread.sleep(3000);

			} else {
				System.out.println("Leads count is Zero, skipping further execution.");
			}

		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}

		logger.info("Click on Deals");

		WebElement reemail_camp_deals = driver
				.findElement(By.xpath(properties.getProperty("manage_reemail_camp_click_deals")));

		if (reemail_camp_deals.isEnabled()) {
			WebDriverWait waitre = new WebDriverWait(driver, 30); // Wait until elements are visible
			waitre.until(ExpectedConditions.elementToBeClickable(reemail_camp_deals));

			reemail_camp_deals.click(); // Click on Deal Tile

			Thread.sleep(3000);
			wait_me.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(properties.getProperty("manage_reemail_camp_deal_search_click"))));

			driver.findElement(By.xpath(properties.getProperty("manage_reemail_camp_deal_search_click")))
					.sendKeys("auto_deal");
			driver.findElement(By.xpath(properties.getProperty("manage_reemail_camp_deal_search_icon_click"))).click(); // Search
			// icon
			// click
			wait_me.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(properties.getProperty("manage_reemail_camp_deals_clear_search"))));

			driver.findElement(By.xpath(properties.getProperty("manage_reemail_camp_deals_clear_search"))).click();

			Thread.sleep(3000);
			logger.info("Click on Deal Preview");
			WebElement me_deal_preview = driver
					.findElement(By.xpath(properties.getProperty("manage_reemail_deal_preview"))); // preview
																									// deal
			me_deal_preview.click();
			Thread.sleep(3000);
			wait_me.until(ExpectedConditions
					.elementToBeClickable(By.xpath(properties.getProperty("manage_reemail_deal_preview_close"))));
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("manage_reemail_deal_preview_close"))).click();
			logger.info("Click on Deal edit");

			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("manage_reemail_deal_click_edit"))).click(); // Edit Deal

			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();

			wait_me.until(ExpectedConditions
					.elementToBeClickable(By.xpath(properties.getProperty("manage_reemail_update_deal"))));
			driver.findElement(By.xpath(properties.getProperty("manage_reemail_update_deal"))).click();
			Thread.sleep(3000);// Update Deal

			logger.info("Click on filter");
			driver.findElement(By.xpath(properties.getProperty("manage_reemail_click_deal_filter"))).click();
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
			driver.findElement(By.xpath(properties.getProperty("manage_reemail_click_filter_button"))).click(); // Click
																												// on
			// Deal
			// filter
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("manage_reemail_apply_filter_cross"))).click();
			logger.info("Click on Deal download");
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("manage_reemail_click_download_deal"))).click();
			wait_me.until(ExpectedConditions
					.elementToBeClickable(By.xpath(properties.getProperty("manage_reemail_deals_close"))));

			driver.findElement(By.xpath(properties.getProperty("manage_reemail_deals_close"))).click();
			Thread.sleep(3000);
		} 
		
		else {
			System.out.println("Deals count is Zero");
		}

		logger.info("Click on Navigation Breadcrumb");

		WebElement me_navigation = driver.findElement(By.xpath(properties.getProperty("click_navigation_breadcrumb"))); // Click
																														// on
																														// Manage
																														// Campaign
																														// navigation
		me_navigation.click();
		Thread.sleep(3000);
		wait_me.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("manage_reemail_tab"))));
		WebElement Surveytab = driver.findElement(By.xpath(properties.getProperty("manage_reemail_tab"))); // Email tab
		Surveytab.click();
		Thread.sleep(3000);
		wait_me.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("red_hover_listview"))));

		WebElement me_hover_views = driver.findElement(By.xpath(properties.getProperty("red_hover_listview")));
		me_hover_views.click();
		Thread.sleep(3000);

		// Calendar view
		WebElement calendarview = driver.findElement(By.xpath(properties.getProperty("click_calendar_view")));
		calendarview.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("click_calendar_week_view"))).click(); // Week View
		Thread.sleep(3000);
//			wait.until(
//					ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("click_calendar_day_view"))));
//			driver.findElement(By.xpath(properties.getProperty("click_calendar_day_view"))).click(); 
//			Thread.sleep(3000);// Day View

		driver.findElement(By.xpath(properties.getProperty("click_navigation_home"))).click(); // breadcrumb
		Thread.sleep(3000);

	}

}
