package com.xamplify.automation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VideoCampaign {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Campaign.properties");
	final Logger logger = LogManager.getLogger(VideoCampaign.class);

	@Test(priority = 1, enabled = true)

	public void vdecampaign() throws InterruptedException, SQLException {

		WebDriverWait waitv = new WebDriverWait(driver, 80);

		// Wait till the element is not visible
		WebElement campele = waitv.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("campaign_hover_v"))));// hover
																														// on
																														// Campaigns
		campele.click();

		Actions camp_action = new Actions(driver);
		camp_action.moveToElement(campele).perform();
		Thread.sleep(5000);
		WebElement create_campele = driver.findElement(By.xpath(properties.getProperty("vcreatecampaign"))); // click on
																												// create
		logger.info("Click on create Campaign"); // campaign

		camp_action.moveToElement(create_campele);
		camp_action.click();
		camp_action.perform();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("openvideocampaign"))).click();// open campagin
		Thread.sleep(3000);

		WebElement campname1 = waitv.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("vcampaignName"))));
		campname1.sendKeys("video Campaign" + "_" + System.currentTimeMillis());

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("vcampaign_through"))).click();// through toggle on
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("vsubjectline"))).sendKeys("Video Campaign subjectLine***");// enter
																														// data
		// for subject
		// line

		Thread.sleep(2000);

		driver.findElement(By.name(properties.getProperty("vpreheader"))).sendKeys("Video Campaign preHeader***");// enter
																													// data
																													// for
																													// pre
		// header
		Thread.sleep(4000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver; // Scroller
		js1.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		/*
		 * driver.findElement(By.xpath(properties.getProperty("vnotifyme_partners"))).
		 * click();// notify partners Thread.sleep(3000);
		 */
		driver.findElement(By.xpath(properties.getProperty("vnotifyme_workflows"))).click();// notify workflows
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("vnotifyme_email"))).click();// notify email opened
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("vnotifyme_link"))).click();// notify link opened
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("vnotifyme_video"))).click();// notify video is played
		Thread.sleep(2000);

		JavascriptExecutor js100 = (JavascriptExecutor) driver; // Scroller
		js100.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		WebElement vdropdown_sort = driver.findElement(By.xpath(properties.getProperty("v_dropdown_sort")));// select
																											// sort
		Thread.sleep(3000);
		Select vds = new Select(vdropdown_sort);
		vds.selectByValue("3: Object");
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("v_search_video"))).sendKeys("video");// enter the data in
																									// Search bar
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("v_search_video_click"))).click();// after data entered click
		Thread.sleep(3000);

		WebElement vdropdown = driver.findElement(By.xpath(properties.getProperty("video_category")));// select category
		Thread.sleep(3000);

		Select vd = new Select(vdropdown);
		Thread.sleep(3000);
		vd.selectByValue("108");

		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("select_video1"))).click(); // Selected the video
		Thread.sleep(2000);
		logger.info("Selected the Video");

		WebElement v7 = driver.findElement(By.xpath(properties.getProperty("search_template"))); // search
		v7.sendKeys("video");// send data through search bar in template
		v7.sendKeys(Keys.ENTER);

		WebDriverWait waitv71 = new WebDriverWait(driver, 50);
		WebElement v71 = waitv71.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("search_template_click"))));// click on
																										// search after
																										// data entered
		v71.click();

		WebDriverWait waitv10 = new WebDriverWait(driver, 60);
		WebElement v10 = waitv10.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("select_template")))); // select
																														// template
		v10.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("vclick_sendtext_email"))).click();
		Thread.sleep(5000);

		WebElement stext_email = driver.findElement(By.xpath(properties.getProperty("vsendtext_email")));// search email
																											// fileds
		stext_email.sendKeys("chmounika@stratapps.com");
		stext_email.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		WebElement stext_email_subject = driver
				.findElement(By.xpath(properties.getProperty("vsendtext_email_subject")));// subject fileds
		stext_email_subject.sendKeys("Please check the Template");
		stext_email_subject.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		WebElement stext_email_button1 = driver.findElement(By.xpath(properties.getProperty("v_sendemail_button")));// send
																													// email
																													// button
		stext_email_button1.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("vemailsent_popup"))).click();
		Thread.sleep(5000);

		WebDriverWait waitv11 = new WebDriverWait(driver, 50);
		WebElement v11 = waitv11.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("email_template_preview")))); // select
																											// template
		v11.click();
		Thread.sleep(2000);

		String originalWindow = driver.getWindowHandle();// store the current window handle
		waitv.until(ExpectedConditions.numberOfWindowsToBe(2)); // wait fornew tab to open
		Thread.sleep(5000);

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab

		Thread.sleep(5000);

		/*
		 * WebElement companylogoNewTab =
		 * waitv.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * properties. getProperty("")))); companylogoNewTab.click(); //perform actions
		 * in new tab
		 */
		driver.close(); // switch back to original tab and close the new tab

		driver.switchTo().window(tabs.get(0));

		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("email_template_next"))).click(); // click on Next
		Thread.sleep(5000);
		logger.info("Selected the Template");

		WebDriverWait wait_vdropdown = new WebDriverWait(driver, 50);
		WebElement w_vdropdown = wait_vdropdown.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("v_select_dropdown"))));

		Select dropdown = new Select(w_vdropdown);
		dropdown.selectByVisibleText("Count(DESC)");

		Thread.sleep(4000);

		WebDriverWait waitv12 = new WebDriverWait(driver, 50);
		WebElement v12 = waitv12.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("search_select_partnerlist"))));
		v12.sendKeys("Active");// Search for partner list Active Master Partner Group
		v12.sendKeys(Keys.ENTER); // Click on search
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("search_select_partnerlist_click"))).click(); // Select the
																											// searched
																											// data

		driver.findElement(By.xpath(properties.getProperty("select_partner_preview"))).click();// click on preview
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("close_partner_preview"))).click();// close partner preview
		Thread.sleep(4000);

		logger.info("Selected the Partnerlist");

	}

}
