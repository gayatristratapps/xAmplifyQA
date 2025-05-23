package com.xamplify.automation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Keymap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailCampaign {

	WebDriver driver = Instance.getInstance();

	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Campaign.properties");

	final Logger logger = LogManager.getLogger(EmailCampaign.class);

	@Test
	public void ecampaign() throws InterruptedException, SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 90); // Wait till the element is not visible

		WebElement campele = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("e_campaignhover"))));
		campele.click(); // hover on campaign

		Actions camp_action = new Actions(driver);
		camp_action.moveToElement(campele).perform();
		Thread.sleep(3000);
		WebElement create_campele = driver.findElement(By.xpath(properties.getProperty("e_createcampaign"))); // click
																												// on
																												// create
																												// campaign
		camp_action.moveToElement(create_campele);
		camp_action.click();

		camp_action.perform();
		Thread.sleep(3000);
		WebDriverWait waitc = new WebDriverWait(driver, 40);
		WebElement opncamp = waitc.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("e_openecampaign")))); // select
																														// email
																														// campaign
		opncamp.click();

		logger.info("Choose the Email campaign");

		logger.info("Choose the Email campaign");

		WebElement campname = waitc.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("ecampaignName"))));
		campname.sendKeys("Email Campaign" + "_" + System.currentTimeMillis());

		Thread.sleep(2000);

		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		WebElement w2 = wait2.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("e_through_partner")))); // toggle
																														// through
																														// partner
		w2.click();// through partner//

		driver.findElement(By.xpath(properties.getProperty("esubjectline"))).sendKeys("Email Campaign subject"); // subjectline
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("epreheader"))).sendKeys("email campaign preheader"); // preheader
		Thread.sleep(1000);

		/*
		 * driver.findElement(By.xpath(properties.getProperty("pnotify"))).click();
		 * //notify partner Thread.sleep(3000);
		 */

		driver.findElement(By.xpath(properties.getProperty("wnotify"))).click(); // notify workflows
		Thread.sleep(1000);

		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		WebElement w3 = wait3
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("enotify")))); // notify
																													// me
																													// email
																													// is
																													// opened

		w3.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("lnotify"))).click(); // notify me when link is clicked
		Thread.sleep(1000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver; // Scroller
		js1.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		logger.info("Choose the Email Template");

		WebElement template_search = driver.findElement(By.xpath(properties.getProperty("esearch_template")));// search
																												// for
																												// template
		template_search.sendKeys("email");
		template_search.sendKeys(Keys.ENTER); // for clicking on the search

		WebDriverWait wait8 = new WebDriverWait(driver, 50);

		WebElement w8 = wait8.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("esearch_template_select")))); // select
																											// template
		w8.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("click_sendtext_email"))).click();
		Thread.sleep(1000);

		WebElement stext_email = driver.findElement(By.xpath(properties.getProperty("esendtext_email")));// search email
																											// fileds
		stext_email.sendKeys("chmounika@stratapps.com");
		stext_email.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		WebElement stext_email_subject = driver
				.findElement(By.xpath(properties.getProperty("esendtext_email_subject")));// subject fileds
		stext_email_subject.sendKeys("Please check the Template");
		stext_email_subject.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		WebElement stext_email_button = driver.findElement(By.xpath(properties.getProperty("e_sendemail_button")));// send
																													// email
																													// button
		stext_email_button.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("emailsent_popup"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("etemplate_preview"))).click();
		Thread.sleep(2000);

		String originalWindow = driver.getWindowHandle();// store the current window handle
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // wait for new tab to open
		Thread.sleep(2000);

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab

		Thread.sleep(2000);

		/*
		 * WebElement companylogoNewTab =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.
		 * getProperty("")))); companylogoNewTab.click(); //perform actions in new tab
		 */
		driver.close(); // switch back to original tab and close the new tab

		driver.switchTo().window(tabs.get(0));

		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("enext"))).click(); // next page
		Thread.sleep(1000);

		logger.info("Selected the Email Template");

		logger.info("Choose the Partner list");

		WebDriverWait wait_edropdown = new WebDriverWait(driver, 50);
		WebElement w_edropdown = wait_edropdown.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("e_select_dropdown"))));
		Thread.sleep(2000);

		Select dropdown = new Select(w_edropdown); // dropdowm
		dropdown.selectByVisibleText("Count(DESC)");

		WebDriverWait wait6 = new WebDriverWait(driver, 50);
		WebElement w6 = wait6.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("esearch_select_partnerlist_click"))));
		w6.sendKeys("Active");// Search for partner list
		w6.sendKeys(Keys.ENTER); // Click on search
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("epartnerlist_preview"))).click(); // preview of selected
																								// partner list
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("eclose_partnerpreview"))).click(); // close the selected
																								// partner preview list
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("eselect_partnergroup"))).click(); // select the partner list
		Thread.sleep(1000);

		logger.info("Selected the Partner list");

		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(document.body.scrollHeight,0)");

		Thread.sleep(1000);

	}

}

/*
 * WebElement
 * c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation"
 * )));
 * 
 * for(int a=0;a<=6;a++) {
 * driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation")))
 * .click(); Thread.sleep(3000); }
 */

/*
 * WebElement eg =
 * driver.findElement(By.xpath(properties.getProperty("eplist")));
 * List<WebElement> links = eg.findElements(By.tagName("li")); for (int i = 0; i
 * <= links.size()+2; i++) { System.out.println(i); //
 * System.out.println(links.size()); //
 * System.out.println(links.get(i).getText());
 * 
 * 
 * WebElement
 * c1=driver.findElement(By.xpath(properties.getProperty("eprtnr_prvwpagenation"
 * ))); c1.click(); Thread.sleep(2000); System.out.println(i +"clicked");
 * 
 * 
 * }
 * 
 * 
 * Thread.sleep(5000);
 */

/*
 * WebElement eg1 =
 * driver.findElement(By.xpath(properties.getProperty("eplist2")));
 * List<WebElement> links1 = eg1.findElements(By.tagName("li")); for (int j = 1;
 * j <= links1.size()-2; j++) { System.out.println(j);
 * System.out.println(links1.size());
 * System.out.println(links1.get(j).getText());
 * 
 * 
 * WebElement
 * c2=driver.findElement(By.xpath(properties.getProperty("epagenation")));
 * Thread.sleep(10000); c2.click(); Thread.sleep(9000); System.out.println(j
 * +"clicked");
 * 
 * 
 * }
 */
