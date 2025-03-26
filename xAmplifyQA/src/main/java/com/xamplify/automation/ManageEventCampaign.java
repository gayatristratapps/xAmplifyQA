
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ManageEventCampaign {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\ManageCampaigns.properties");
	final Logger logger = LogManager.getLogger(ManageEventCampaign.class);

	@Test(priority = 1, enabled = true)

	public void manage_email_camp() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement m_eventcamp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("manage_eve_campaignhover")))); // Hover
		// on
		// campaigns

		Actions m_eventcamp_action = new Actions(driver);
		m_eventcamp_action.moveToElement(m_eventcamp).perform();
		Thread.sleep(5000);
		WebElement manage_eventcamp = driver.findElement(By.xpath(properties.getProperty("manage_eventcampaign"))); // click
																													// on
																													// manage
																													// campaign
		m_eventcamp_action.moveToElement(manage_eventcamp);
		m_eventcamp_action.click();
		m_eventcamp_action.perform();

		Thread.sleep(4000);

		logger.info("Clicked on manage Campaigns");

		WebDriverWait wait_etab = new WebDriverWait(driver, 50);
		WebElement event_tab = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("manage_event_tab"))));

		// WebElement email_tab =
		// driver.findElement(By.xpath(properties.getProperty("manage_email_tab")));
		Actions actions = new Actions(driver);
		actions.moveToElement(event_tab).click().build().perform();
		Thread.sleep(6000);
		// logger.info("Clicked on Email tab");

	}

	@Test(priority = 2, enabled = true)

	public void manage_event_copy() throws InterruptedException, SQLException {

		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("meve_gear_icon"))).click();// click on the gear icon

		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("meve_copycampaign"))).click(); // click on the copy campaign
																							// icon

		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("meve_copy_saveas"))).click(); // click on the save the
																							// copycampaign

		Thread.sleep(8000);
		logger.info("Copied Event campaign successfully");

		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("meve_gear_icon"))).click();// click on the gear icon

		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("meve_editicon"))).click(); // click on the edit icon
		Thread.sleep(5000);

		WebElement launch = driver.findElement(By.xpath("//*[@id=\"event-tabs\"]/div[1]/div[4]"));
		launch.click();
		Thread.sleep(4000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver; // Scroller
		js1.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		driver.findElement(By.xpath(properties.getProperty("eve_now"))).click(); // click NOW
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("eve_launch"))).click(); // click LAUNCH

		Thread.sleep(4000);

	}

	@Test(priority = 3, enabled = true)

	public void manage_event_editdelete() throws InterruptedException, SQLException {

		Thread.sleep(14000);
		driver.findElement(By.xpath(properties.getProperty("manage_event_tab"))).click();// click on the eventtab
		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("meve_gear_icon"))).click(); // click on the gear icon

		Thread.sleep(9000);

		driver.findElement(By.xpath(properties.getProperty("meve_editicon"))).click(); // click on the edit icon
		Thread.sleep(3000);

		WebElement meve_drop = driver.findElement(By.xpath(properties.getProperty("meve_edit_selectfolder"))); // click
																												// on
																												// the
																												// folder

		meve_drop.click();
		driver.findElement(By.xpath(properties.getProperty("meve_edit_selectedfolder"))).click(); // selected the folder
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("meve_updatefolder"))).click(); // click on the update
		Thread.sleep(3000);
		logger.info("Folder updated successfully");

		driver.findElement(By.xpath(properties.getProperty("meve_close"))).click(); // close the window
		Thread.sleep(5000);

	}

	@Test(priority = 4, enabled = true)
//	@Test(dependsOnMethods = { "manage_event_editdelete" })
	public void manage_eve_sndpreview_previewdelete() throws InterruptedException, SQLException {

		Thread.sleep(6000);

		driver.findElement(By.xpath(properties.getProperty("meve_gear_icon"))).click(); // click on the gear icon

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("meve_sendpreviewemail"))).click(); // click on the
																								// sendpreview mail

		Thread.sleep(3000);

		WebElement snddata = driver.findElement(By.xpath(properties.getProperty("meve_senddata"))); // click on the
																									// emailid field
		snddata.sendKeys("chmounika@stratapps.com");
		snddata.sendKeys(Keys.ENTER);

		Thread.sleep(4000);

		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_DOWN).build().perform(); // scroll down the page

		driver.findElement(By.xpath(properties.getProperty("meve_sendbutton"))).click(); // click on the send button

		Thread.sleep(3000);

		logger.info("Event Preview email sent successfully");

		driver.findElement(By.xpath(properties.getProperty("meve_closebutton"))).click(); // click on the close button
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("meve_gear_icon"))).click(); // click on the gear icon

		Thread.sleep(3000);

		JavascriptExecutor jsev = (JavascriptExecutor) driver; // Scroller
		jsev.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("meve_preview&delete"))).click(); // click on the
																								// preview&delete icon

		Thread.sleep(3000);

		WebElement we = driver.findElement(By.xpath(properties.getProperty("meve_preview&delete_sortby"))); // click for
																											// sortby
		we.click();
		Thread.sleep(3000);

		Select sort = new Select(we);
		Thread.sleep(3000);

		sort.selectByVisibleText("Email ID(A-Z)");

		Thread.sleep(3000);
		sort.selectByVisibleText("Email ID(Z-A)");

		Thread.sleep(3000);
		sort.selectByVisibleText("First Name(ASC)");

		Thread.sleep(3000);
		sort.selectByVisibleText("First Name(DESC)");

		Thread.sleep(3000);
		sort.selectByVisibleText("Last Name(ASC)");

		Thread.sleep(3000);
		sort.selectByVisibleText("Last Name(DESC)");

		Thread.sleep(3000);
		sort.selectByVisibleText("Company Name (A-Z)");

		Thread.sleep(3000);
		sort.selectByVisibleText("Company Name (Z-A)");

		Thread.sleep(5000);

		/*
		 * driver.findElement(By.xpath(properties.getProperty("meve_preview&delete_del")
		 * )).click(); // delete icon for one // of the partner
		 * 
		 * Thread.sleep(3000);
		 * 
		 * driver.findElement(By.xpath(properties.getProperty("meve_preview&del_yesdel")
		 * )).click(); // click for the yes // delete button
		 * 
		 * Thread.sleep(3000);
		 */

		logger.info("Deleted one of the partner in the  Preview&Delete option successfully");

		driver.findElement(By.xpath(properties.getProperty("meve_navigate_mcam"))).click(); // navigate to manage
																							// campaign

		logger.info("Navigate to Manage Campaigns successfully");

		Thread.sleep(6000);
	}

	@Test(priority = 5, enabled = true)

	public void manage_eve_grid_cancel() throws InterruptedException, SQLException {

		Thread.sleep(5000);

		WebElement hoverviews = driver.findElement(By.xpath(properties.getProperty("hover_on_listview")));
		hoverviews.click();// Hover on views
		Thread.sleep(4000);

		logger.info("Click on Grid View");
		driver.findElement(By.xpath(properties.getProperty("grid_view"))).click();// click on grid view
		Thread.sleep(7000);

//		driver.findElement(By.xpath(properties.getProperty("meve_gridview"))).click(); // click on the grid view
//		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("manage_event_tab"))).click();// click on the eventtab
		Thread.sleep(5000);

		WebElement wp = driver.findElement(By.xpath(properties.getProperty("meve_hover_evecamp"))); // hover to
																									// previewevent
																									// icon

		Actions action = new Actions(driver);
		action.moveToElement(wp).perform();
		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("meve_hover_previewicon"))).click(); // click on the preview
																								// option
		Thread.sleep(5000);

		logger.info("Clicked preview icon in grid view successfully");

		driver.findElement(By.xpath(properties.getProperty("meve_preview_closeicon"))).click(); // click on the close
																								// icon

		Thread.sleep(3000);

		action.moveToElement(wp).perform();

		Thread.sleep(3000);
//		WebElement wue = driver.findElement(By.xpath(properties.getProperty("meve_hover_updateevent_icon"))); // hover
//																												// to
//																												// update
//																												// event
//																												// icon
//
//		Actions action_wue = new Actions(driver);
//		action_wue.moveToElement(wue).perform();
//		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("meve_hover_updateevent_icon"))).click(); // click on the
																										// update event
																										// option
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("meve_message"))).sendKeys("update for the message field");
		Thread.sleep(3000);
		logger.info("Added Message successfully by clicking on the update event icon");

		JavascriptExecutor jsev = (JavascriptExecutor) driver; // Scroller
		jsev.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("meve_update_button"))).click(); // click on the update
																							// button

		Thread.sleep(5000);
		logger.info("Event has been updated successfully");

		WebElement hoverviews1 = driver.findElement(By.xpath(properties.getProperty("hover_on_listview")));
		hoverviews1.click();// Hover on views
		Thread.sleep(4000);

		logger.info("Click on Grid View");
		driver.findElement(By.xpath(properties.getProperty("grid_view"))).click();// click on grid view
		Thread.sleep(7000);
		driver.findElement(By.xpath(properties.getProperty("manage_event_tab"))).click();// click on the eventtab
		Thread.sleep(7000);

		/*
		 * WebElement w2 =
		 * driver.findElement(By.xpath(properties.getProperty("meve_hover_evecamp")));
		 * 
		 * Actions action1 = new Actions(driver); action1.moveToElement(w2).perform();
		 * Thread.sleep(6000);
		 * 
		 * 
		 * WebElement w = driver.findElement(By.xpath(properties.getProperty(
		 * "meve_hover_canceleventicon"))); // hover to // cancelevent // icon
		 * 
		 * Actions action21 = new Actions(driver); action21.moveToElement(w).perform();
		 * Thread.sleep(8000);
		 * 
		 * driver.findElement(By.xpath(properties.getProperty(
		 * "meve_hover_canceleventicon"))).click(); Thread.sleep(5000);
		 * 
		 * logger.info("Clicked Cancel event icon in grid view successfully");
		 * 
		 * driver.findElement(By.xpath(properties.getProperty("meve_cancel_emailsubject"
		 * ))) .sendKeys("event cancelled subject"); // enter the data for the subject
		 * field Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("meve_cancel_message")))
		 * .sendKeys("event cancelled due to some reasons"); Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("meve_cancel_event"))).
		 * click(); // click on the cancel event // button Thread.sleep(6000);
		 * logger.info("Event has been cancelled successfully");
		 */

	}

	@Test(priority = 7, enabled = false)
	// @Test(dependsOnMethods = { "manage_eve_grid_cancel" })
	public void manage_eve_archieve() throws InterruptedException, SQLException {

		Thread.sleep(7000);
		driver.navigate().to("https://xamplify.co/home/campaigns/manage");
		Thread.sleep(6000);

//		driver.findElement(By.xpath(properties.getProperty("meve_gridview"))).click(); // click on the grid view
//		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("manage_event_tab"))).click();// click on the eventtab
		Thread.sleep(8000);

		WebElement w2 = driver.findElement(By.xpath(properties.getProperty("meve_hover_evecamp"))); // hover to
																									// cancelevent
																									// icon

		Actions action3 = new Actions(driver);
		action3.moveToElement(w2).perform();
		Thread.sleep(9000);
		driver.findElement(By.xpath(properties.getProperty("meve_hover_archieve_icon"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("meve_archievecampaigns_button"))).click(); // clcik on the
																										// archieve
																										// button
		Thread.sleep(6000);
		logger.info("archived campaigns button clicked successfully");

		driver.findElement(By.xpath(properties.getProperty("meve_gridview"))).click(); // click on the grid view

		logger.info("clicked on the grid view");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("manage_event_tab"))).click();// click on the eventtab
		Thread.sleep(11000);

		WebElement w3 = driver.findElement(By.xpath(properties.getProperty("meve_hover_grid_delete_active"))); // hover
																												// to
																												// icon

		Actions action4 = new Actions(driver);
		action4.moveToElement(w3).perform();
		Thread.sleep(9000);

		driver.findElement(By.xpath(properties.getProperty("meve_hover_grid_delete_active"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("meve_hover_grid_delete_yes"))).click();

		Thread.sleep(7000);
		logger.info("Deleted archived campaign ");
		driver.findElement(By.xpath(properties.getProperty("meve_hover_grid_activecam_button"))).click();

		Thread.sleep(7000);
		logger.info("Back to active campaigns page ");

	}

	@Test(priority = 6, enabled = true)
	public void manage_eve_analyticsreports() throws InterruptedException, SQLException, AWTException {

		{

			WebDriverWait wait = new WebDriverWait(driver, 50);

			/// driver.navigate().to("https://xamplify.co/home/campaigns/manage");

			WebElement hoverfloderlistview = driver.findElement(By.xpath(properties.getProperty("hover_gridview")));
			hoverfloderlistview.click();
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("meve_list_view"))).click(); // Click on List View
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("manage_event_tab"))).click();// click on the eventtab
																								// Thread.sleep(5000);

			Thread.sleep(4000);

			driver.findElement(By.xpath(properties.getProperty("meve_cbreports"))).click(); // click on campaign based
																							// reports icon

			Thread.sleep(7000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_preview_emlinfo"))).click();

			logger.info("Clicked on emailinfo  successfully");
			Thread.sleep(7000);

			String originalWindow = driver.getWindowHandle();// store the current window handle
			wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // wait for new tab to open
			Thread.sleep(5000);

			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

			driver.switchTo().window(tabs.get(1)); // switch to the new tab

			Thread.sleep(3000);

			/*
			 * WebElement companylogoNewTab =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.
			 * getProperty("")))); companylogoNewTab.click(); //perform actions in new tab
			 */
			driver.close(); // switch back to original tab and close the new tab

			driver.switchTo().window(tabs.get(0));

			Thread.sleep(3000);

			// driver.findElement(By.xpath(properties.getProperty("m_eve_preview_emlinfo_cls"))).click();

			logger.info("emailinfo closed successfully");

			Thread.sleep(6000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_preview_listinfo"))).click();

			logger.info("Clicked on listinfo  successfully");

			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_preview_listinfo_cls"))).click();

			logger.info("listinfo closed successfully");

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites"))).click();

			logger.info("Clicked on invites  successfully");

			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_opened"))).click();

			logger.info("Clicked on invites opened  successfully");

			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_whohaventopned"))).click();

			logger.info("Clicked on who havent opened tab  successfully");

			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_whohaventopned_remainder"))).click();

			logger.info("Clicked on remainder icon  successfully");

			Thread.sleep(6000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_whohaventopned_remainder_subject"))) // enter
																													// the
																													// subject
																													// data
					.sendKeys("subject");

			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_whohaventopned_remainder_msg")))
					.sendKeys("Please open the email[Remainder from vendor]"); // send the data for the remainder
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_whohaventopned_remainder_send"))).click();

			logger.info("Clicked on Send Remainderbutton  successfully");

			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_Notyet"))).click(); // click on the not
																									// yet tile
			Thread.sleep(5000);

			WebElement evesearch = driver.findElement(By.xpath(properties.getProperty("m_eve_invites_Notyet_search")));
			evesearch.sendKeys("automate");
			evesearch.sendKeys(Keys.ENTER);

			Thread.sleep(7000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_Notyet_export"))).click(); // click on
																											// gear icon
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_Notyet_excel"))).click();
			Thread.sleep(5000);

			Robot evnt_object1 = new Robot(); // Create object of Robot class to handle the download dailog
			evnt_object1.keyPress(KeyEvent.VK_ENTER); // Press Enter to handle download popup
			Thread.sleep(4000);

			logger.info("Export to excel done successfully");

			Thread.sleep(5000);

			WebElement invite_yes = driver.findElement(By.xpath(properties.getProperty("m_eve_invites_yes")));

			if (invite_yes.isEnabled()) { // if enabled click on the yes tile

				logger.info("Yes tile clicked Successfully");

				Thread.sleep(4000);

			}

			else {
				logger.info("Unable to click Yes tile  due to count is '0' ");

			}
			Thread.sleep(5000);

			WebElement invite_leads = driver.findElement(By.xpath(properties.getProperty("m_eve_invites_leads")));

			if (invite_leads.isEnabled()) { // if enabled click on the leads tile

				logger.info("Leads tile clicked Successfully");

				Thread.sleep(4000);

			}

			else {
				logger.info("Unable to click leads tile  due to count is '0' ");

			}
			Thread.sleep(5000);

			WebElement invite_total = driver.findElement(By.xpath(properties.getProperty("m_eve_invites_total")));

//System.out.println(invite_total.isEnabled());

			if (invite_total.isEnabled()) { // if enabled click on the total tile

				logger.info("Total tile clicked Successfully");

				Thread.sleep(4000);

				driver.findElement(By.xpath(properties.getProperty("m_eve_invites_total_download"))).click();
				Thread.sleep(5000);

				evnt_object1.keyPress(KeyEvent.VK_ENTER); // handle the download POPUP screen
				Thread.sleep(3000);
				logger.info("Download icon successfully in Total tile");

				WebElement eve_tot_search = driver
						.findElement(By.xpath(properties.getProperty("m_eve_invites_total_search"))); // search
				eve_tot_search.sendKeys("automate");
				eve_tot_search.sendKeys(Keys.ENTER);

				Thread.sleep(7000);

				driver.findElement(By.xpath(properties.getProperty("m_eve_invites_total_cls"))).click(); // click on x
																											// icon
				Thread.sleep(5000);

			}

			else {
				logger.info("Unable to click Total tile due to count is '0' ");

			}
			Thread.sleep(1000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_invites_total_cls"))).click(); // click on x icon
			Thread.sleep(5000);

			JavascriptExecutor jspev = (JavascriptExecutor) driver;
			jspev.executeScript("window.scrollTo(document.body.scrollHeight,200)");
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_urpartner"))).click();
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_urpartner_invites"))).click(); // click on invites
																										// tile
			Thread.sleep(5000);

//			

			JavascriptExecutor jse = (JavascriptExecutor) driver; // Scroller
			jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");
			Thread.sleep(3000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_urpartner_cls"))).click();
			Thread.sleep(5000);

			WebElement eve_prca_search = driver
					.findElement(By.xpath(properties.getProperty("m_eve_Partner_redis_camp_analytics")));
			eve_prca_search.sendKeys("automate");
			eve_prca_search.sendKeys(Keys.ENTER);
			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_Partner_redis_camp_analytics_excel"))).click();
			Thread.sleep(5000);

			evnt_object1.keyPress(KeyEvent.VK_ENTER); // handle the download POPUP screen
			Thread.sleep(3000);

			logger.info("Export to Excel done successfully in 'Partner REDISTRIBUTED CAMPAIGN ANALYTICS' section");

			driver.findElement(By.xpath(properties.getProperty("m_eve_Partner_redis_camp_analytics_yes"))).click();
			Thread.sleep(5000);

			Actions a = new Actions(driver); // scroll up the page
			a.sendKeys(Keys.PAGE_UP).build().perform();

			Thread.sleep(5000);

			driver.findElement(By.xpath(properties.getProperty("m_eve_Partner_redis_camp_analytics_cls"))).click(); // click
																													// on
																													// the
																													// x
																													// icon
			Thread.sleep(5000);

			WebElement prca_leads = driver
					.findElement(By.xpath(properties.getProperty("m_eve_Partner_redis_camp_analytics_leads")));
			Thread.sleep(5000);

			if (prca_leads.isEnabled()) {

				logger.info("Totalleads tile clicked Successfully in Your Partner tile");

				prca_leads.click();
				Thread.sleep(4000);

			}

			else {
				logger.info(
						"Unable to click leads tile  due to count is '0' in Partner REDISTRIBUTED CAMPAIGN ANALYTICS' section");
				System.out.println(
						"leads tile  due to count is '0' in Partner REDISTRIBUTED CAMPAIGN ANALYTICS' section ");

			}

		}

		driver.findElement(By.xpath(properties.getProperty("goto_home"))).click(); // Click on HOME
		Thread.sleep(5000);

		logger.info("Export to Excel done successfully in ' YOUR LEAD DETAILS ( Total Lead count # 0 )' section");

	}
}
