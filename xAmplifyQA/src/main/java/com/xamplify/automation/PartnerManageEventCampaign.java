
package com.xamplify.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class PartnerManageEventCampaign {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile(
			"D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\RedistributionCampaign.properties");
	final Logger logger = LogManager.getLogger(PartnerManageEventCampaign.class);

	@Test(priority = 1, enabled = true)
	public void manage_redeventcamp() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, 80); // Wait till the element is not visible
		WebElement event_element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("partner_eve_campaign_evehover")))); // Hover
		// the
		// Campaign
		// module
		event_element.click();
		logger.info("Hover the campaign module");
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("click_reevent_manage_camp"))).click(); // Click on Manage
																									// campaigns
		Thread.sleep(5000);
		logger.info("Click on Manage campaign");

		driver.findElement(By.xpath(properties.getProperty("manage_reevent_click_event_tab"))).click(); // Click on
																										// VideoTAb
		Thread.sleep(5000);

		logger.info("Event tab clicked successfully");

		driver.findElement(By.xpath(properties.getProperty("partner_manage_eve_gearicon"))).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_edit"))).click();
		Thread.sleep(4000);
		logger.info("Clicked on the edit icon successfully");

		WebElement descp = driver.findElement(By.xpath(properties.getProperty("Partneracc_m_eve_description_box")));
		descp.sendKeys("Event Description");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_edit_folder"))).click();
		Thread.sleep(4000);
		logger.info("Clicked on the edit folder successfully");

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_edit_updatefolder"))).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_edit_update"))).click();
		Thread.sleep(4000);
		logger.info("Clicked on the update button successfully");

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_edit_update_close"))).click();
		Thread.sleep(4000);

	}

	@Test(priority = 2, enabled = true)
	public void pac_manage_sendpreviewemail() throws InterruptedException, SQLException {

		driver.findElement(By.xpath(properties.getProperty("partner_manage_eve_gearicon"))).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_sendpreviewemail"))).click();
		Thread.sleep(4000);
		logger.info("Clicked on the send preview email option successfully");

		WebElement sndata = driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_senddata")));
		sndata.sendKeys("chmounika@stratapps.com"); // send data
		sndata.sendKeys(Keys.ENTER);

		Thread.sleep(7000);

		Actions pa = new Actions(driver);
		pa.sendKeys(Keys.PAGE_DOWN).build().perform(); // scroll down the page

		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_sendbutton"))).click(); // click on the
		// send button
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_closebutton"))).click();
		Thread.sleep(9000);

		logger.info("Clicked on the close option successfully");
	}

	@Test(priority = 3, enabled = true)
	public void pac_manage_Inivitemore() throws InterruptedException, SQLException {

		driver.findElement(By.xpath(properties.getProperty("partner_manage_eve_gearicon"))).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invitemore"))).click();
		Thread.sleep(4000);

		logger.info("Clicked on the InviteMore option successfully");

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invite_1stpage"))).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invite_1stpage_send"))).click();
		Thread.sleep(4000);

		logger.info("Clicked on send button for the Invite more contacts  successfully");

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invite_close"))).click();
		Thread.sleep(4000);

		logger.info("Clicked on close button successfully");

		Thread.sleep(7000);

	}

	@Test(priority = 4, enabled = true)
	public void pac_manage_preview_analytics() throws InterruptedException, SQLException, AWTException {

		driver.get("https://xamplify.co/home/campaigns/manage");

		Thread.sleep(7000);

		logger.info("Redirected to ManageCampaign successfully");

		driver.findElement(By.xpath(properties.getProperty("partner_eve_redistribute_eventtab"))).click(); // click on
		// // event
		// // tab
		Thread.sleep(5000);
		logger.info("Event tab clicked successfully");

		driver.findElement(By.xpath(properties.getProperty("partner_manage_eve_gearicon"))).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_preview"))).click();

		logger.info("Clicked on preview successfully");
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_preview_analytics"))).click();

		logger.info("Clicked on analytics icon successfully");

		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_preview_emlinfo"))).click();

		logger.info("Clicked on emailinfo  successfully");
		Thread.sleep(7000);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		String originalWindow = driver.getWindowHandle();// store the current window handle
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // wait for new tab to open
		Thread.sleep(5000);

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab

		Thread.sleep(6000);
		driver.close(); // switch back to original tab and close the new tab
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		logger.info("Event tab preview closed successfully");

//		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_preview_emlinfo_cls"))).click();
//
//		logger.info("emailinfo closed successfully");
//
//		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_preview_listinfo"))).click();

		logger.info("Clicked on listinfo  successfully");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_preview_listinfo_cls"))).click();

		logger.info("listinfo closed successfully");

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites"))).click();

		logger.info("Clicked on invites  successfully");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_opened"))).click();

		logger.info("Clicked on invites opened  successfully");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_whohaventopned"))).click();

		logger.info("Clicked on who havent opened tab  successfully");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_whohaventopned_remainder")))
				.click();

		logger.info("Clicked on remainder icon  successfully");

		Thread.sleep(6000);

		driver.findElement(
				By.xpath(properties.getProperty("partneracc_m_eve_invites_whohaventopned_remainder_subject")))
				.sendKeys("subject");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_whohaventopned_remainder_msg")))
				.sendKeys("Please open the email[Remainder]");
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_whohaventopned_remainder_send")))
				.click();

		logger.info("Clicked on Send Remainderbutton  successfully");

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_Notyet"))).click();
		Thread.sleep(5000);

		WebElement evesearch = driver
				.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_Notyet_search")));
		evesearch.sendKeys("gayatri");
		evesearch.sendKeys(Keys.ENTER);

		Thread.sleep(7000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_Notyet_export"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_Notyet_excel"))).click();
		Thread.sleep(5000);

		Robot m_event_object1 = new Robot(); // Create object of Robot class to handle the download dailog
		m_event_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter
		Thread.sleep(4000);

		logger.info("Export to excel done successfully");

		WebElement invite_yes = driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_yes")));

		if (invite_yes.isEnabled()) {

			logger.info("Yes tile clicked Successfully");

			Thread.sleep(4000);

		}

		else {
			logger.info("Unable to click Yes tile  due to count is '0' ");

		}
		Thread.sleep(5000);

		WebElement invite_leads = driver
				.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_leads")));

		if (invite_leads.isEnabled()) {

			logger.info("Leads tile clicked Successfully");

			Thread.sleep(4000);

		}

		else {
			logger.info("Unable to click leads tile  due to count is '0' ");

		}
		Thread.sleep(5000);

		WebElement invite_total = driver
				.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_total")));

//System.out.println(invite_total.isEnabled());

		if (invite_total.isEnabled()) {

			logger.info("Total tile clicked Successfully");

			Thread.sleep(4000);

			driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_total_download"))).click();
			Thread.sleep(5000);
			m_event_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter
			Thread.sleep(4000);

			logger.info("Download icon successfully in Total tile");

			WebElement eve_tot_search = driver
					.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_total_search")));
			eve_tot_search.sendKeys("gayatri");
			eve_tot_search.sendKeys(Keys.ENTER);

			Thread.sleep(7000);

			driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_total_cls"))).click();
			Thread.sleep(5000);

		}

		else {
			logger.info("Unable to click Total tile due to count is '0' ");

		}
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_invites_total_cls"))).click();
		Thread.sleep(5000);

		WebElement eve_analytics = driver
				.findElement(By.xpath(properties.getProperty("partneracc_m_eve_Campaignanalytics_search")));
		eve_analytics.sendKeys("gayatri");
		eve_analytics.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_Campaignanalytics_gearicon_excel")))
				.click();
		Thread.sleep(5000);

		m_event_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter
		Thread.sleep(4000);

		logger.info("Download excel successfully in Campaign Analytics section");

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_emailid_click"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("partneracc_m_eve_emailid_registerlead"))).click();
		Thread.sleep(5000);

		WebElement Fname = driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_firstname")));
		Fname.clear();
		Fname.sendKeys(" " + " FName"); // first
		// name
		WebElement Lname = driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_lastname")));
		Lname.clear();
		Lname.sendKeys(" " + " LName"); // last
		// name
		Thread.sleep(2000);

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
		WebElement phone = driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_phoneno")));
		phone.clear();
		phone.sendKeys(" " + " 912345678"); // phone
		// number
		Thread.sleep(5000);

		Select drpstage = new Select(
				driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_selectstage")))); // select stage
		drpstage.selectByValue("88675");

		Thread.sleep(5000);

		WebElement addr = driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_address")));
		addr.clear();
		addr.sendKeys(" " + " Address"); // address
		Thread.sleep(1000);

		WebElement city = driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_city")));
		city.clear();
		city.sendKeys(" " + " city"); // city
		Thread.sleep(1000);

		WebElement stat = driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_state")));
		stat.clear();
		stat.sendKeys(" " + " state"); // state
		Thread.sleep(1000);

		WebElement pin = driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_postalcode")));
		pin.clear();
		pin.sendKeys(" " + " 534342"); // zipcode
		Thread.sleep(1000);

		WebElement country = driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_selectcountry")));
		country.clear();
		country.sendKeys(" " + "India"); // country

		driver.findElement(By.xpath(properties.getProperty("mevec_registerlead_submit"))).click(); // submit

		logger.info("Event Lead submitted Successfully");

		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("mevec_lead_page_close")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("mevec_opportunities"))).click(); // hover to opportunities
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mevec_oppo_manageleads"))).click(); // redirect to manage
// leads
		Thread.sleep(5000);
		
		
		WebElement reg_deal_button = driver.findElement(By.xpath(properties.getProperty("mevec_oppo_manageleads_registerdealclick")));
		
		if (reg_deal_button.isDisplayed())
		{
			reg_deal_button.click(); // Register deal
			
		Thread.sleep(4000);

		logger.info("Register deal button clicked Successfully");

		WebElement eve_selectstage = driver
				.findElement(By.xpath(properties.getProperty("mevec_oppo_mleads_rdeal_selectstage"))); // select stage
		eve_selectstage.sendKeys("Opened");
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();

		Thread.sleep(3000);
		logger.info("Selected stage in dropdown Successfully");

		driver.findElement(By.xpath(properties.getProperty("mevec_oppo_mleads_rdeal_name"))).sendKeys("Deal_auto"); // title
		// field

		Thread.sleep(3000);
		

		driver.findElement(By.xpath(properties.getProperty("mevec_oppo_mleads_rdeal_amount"))).sendKeys("2345"); // amount
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("mevec_oppo_mleads_rdeal_calendar"))).click(); // select
		// calendar

		Thread.sleep(7000);


			driver.findElement(By.xpath(properties.getProperty("mevec_oppo_mleads_rdeal_selectdate"))).click();
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("mevec_oppo_mleads_register_deal"))).click(); // click
			// for
			// register
			// deal
			// button
			Thread.sleep(5000);
			
		}
		
		else {
		

		driver.findElement(By.xpath(properties.getProperty("click_navigation_home"))).click(); // breadcrumb
		Thread.sleep(3000);
		
		}

	}

}