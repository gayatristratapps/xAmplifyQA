package com.xamplify.automation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Templates {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Templates.properties");
	final Logger logger = LogManager.getLogger(Templates.class);

	@Test(priority = 3, enabled = true)
	public void design() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("Designmodule"))).click();// clicking on Design Module
		logger.info("Clicked on Design Module");

		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("DesignTemplates"))).click();// Clicked on Design Templates
		logger.info("Clicked on design Templates");

	}

	@Test(priority = 4, enabled = true)
	public void create_email_template() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("SelectingemailTemplate"))).click(); // selecting email
		logger.info("Select Email Template");

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).click();// clickin on search bar
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).sendKeys("Basic");// Entering Text in
																									// Search bar
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchbutton"))).click();// clicking on Search button after
																						// entering text in search bar

		logger.info("searched Templates");

		Thread.sleep(3000);

		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Templatediv")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("creatediv"))).click(); // Div for create Template
		Thread.sleep(20000);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");

		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename"))).click();// clicking on Template name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename")))
				.sendKeys("harish" + System.currentTimeMillis());// Entering Template Name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savingtemplate"))).click(); // clicking on Save Button
																						// //span[contains(text(),'SAVE')]/..
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();

		Thread.sleep(5000);
		design();

	}

	@Test(priority = 5, enabled = true)
	public void video_template() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("SelectingvideoTemplate"))).click(); // selecting video tab
		logger.info("Select Video Template");

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).click();// clickin on search bar
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).sendKeys("simple");// Entering Text in
																									// Search bar
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchbutton"))).click();// clicking on Search button after
																						// entering text in search bar

		logger.info("searched Templates");

		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Templatediv")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("creatediv"))).click(); // Div for create Template
		Thread.sleep(20000);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button

		logger.info("Clicking on save templates");

		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename"))).click();// clicking on Template name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename")))
				.sendKeys("harish" + System.currentTimeMillis());// Entering Template Name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savingtemplate"))).click(); // clicking on Save Button
																						// //span[contains(text(),'SAVE')]/..
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();

		Thread.sleep(5000);

		design();

	}

	@Test(priority = 6, enabled = true)
	public void emailcobranding() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("SelectingemailcobrandingTemplate"))).click(); // selecting
																											// email co
																											// branding
																											// template
		logger.info("Select email cobranding Template");

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).click();// clickin on search bar
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).sendKeys("newsletter2");// Entering Text
																										// in
																										// Search bar
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchbutton"))).click();// clicking on Search button after
																						// entering text in search bar

		logger.info("searched Templates");

		Thread.sleep(3000);

		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Templatediv")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("creatediv"))).click(); // Div for create Template
		Thread.sleep(20000);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");

		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename"))).click();// clicking on Template name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename")))
				.sendKeys("harish" + System.currentTimeMillis());// Entering Template Name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savingtemplate"))).click(); // clicking on Save Button
																						// //span[contains(text(),'SAVE')]/..
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();

		Thread.sleep(5000);

		design();

	}

//...............................................................................................................................
	@Test(priority = 7, enabled = true)
	public void videocobranding() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("SelectVideocobrandingTemplate"))).click(); // selecting
																										// video
																										// co-branding
																										// template
		logger.info("Select email cobranding Template");

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).click();// clicking on search bar
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).sendKeys("test");// Entering Text in
																								// Search bar
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchbutton"))).click();// clicking on Search button after
																						// entering text in search bar

		logger.info("searched Templates");

		Thread.sleep(3000);

		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Templatediv")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("creatediv"))).click(); // Div for create Template
		Thread.sleep(20000);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");

		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename"))).click();// clicking on Template name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename")))
				.sendKeys("harish" + System.currentTimeMillis());// Entering Template Name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savingtemplate"))).click(); // clicking on Save Button
																						// //span[contains(text(),'SAVE')]/..
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();

		Thread.sleep(5000);

		design();

	}

	// -----------------------------------------------------------------------------------------------------------------------------------
	@Test(priority = 8, enabled = true)
	public void event() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("SelecteventTemplate"))).click(); // selecting video
																								// co-branding template
		logger.info("Select email cobranding Template");

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).click();// clicking on search bar
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).sendKeys("Event");// Entering Text in
																									// Search bar
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchbutton"))).click();// clicking on Search button after
																						// entering text in search bar

		logger.info("searched Templates");

		Thread.sleep(3000);

		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Templatediv")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("creatediv"))).click(); // Div for create Template
		Thread.sleep(20000);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");

		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename"))).click();// clicking on Template name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename")))
				.sendKeys("harish" + System.currentTimeMillis());// Entering Template Name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savingtemplate"))).click(); // clicking on Save Button
																						// //span[contains(text(),'SAVE')]/..
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();

		Thread.sleep(5000);

		design();

	}

//------------------------------------------------------------------------------------------------------------------------------------------------
	@Test(priority = 9, enabled = true)
	public void eventcobranding() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("SelecteventcobrandingTemplate"))).click(); // selecting
																										// video
																										// co-branding
																										// template
		logger.info("Select email cobranding Template");

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).click();// clicking on search bar
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).sendKeys("Event co");// Entering Text in
																									// Search bar
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchbutton"))).click();// clicking on Search button after
																						// entering text in search bar

		logger.info("searched Templates");

		Thread.sleep(3000);

		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Templatediv")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("creatediv"))).click(); // Div for create Template
		Thread.sleep(20000);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");

		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename"))).click();// clicking on Template name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Templatename")))
				.sendKeys("harish" + System.currentTimeMillis());// Entering Template Name
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savingtemplate"))).click(); // clicking on Save Button
																						// //span[contains(text(),'SAVE')]/..
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();

		Thread.sleep(5000);

		design();

	}

	@SuppressWarnings("deprecation")
	@Test(priority = 10, enabled = true)
	public void upload_customtemplate_regular() throws InterruptedException, IOException {
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("uploadcustomtab"))).click(); // Clicking on Upload Custom
																							// Tab
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).click();// clicking on search bar
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).sendKeys("Regular");// Entering Text in
																									// Search bar
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchbutton"))).click();// clicking on Search button after
																						// entering text in search bar

		logger.info("searched Templates");
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Templatediv")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("creatediv"))).click(); // Div for create Template
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("uploadcustomname"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("uploadcustomname")))// Giving a dynamic name for the
																				// template
				.sendKeys("harishuploadcustom" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("clickonbrowse"))).click();// Clicking on the browse button
		Thread.sleep(3000);

		Runtime.getRuntime().exec("D:\\Autoit\\uploadtemplate.exe");// uploading by Auto it

		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("saveuploadcustom"))).click();// Saving the Template

	}

	@SuppressWarnings("deprecation")
	@Test(priority = 11, enabled = true)
	public void upload_customtemplate_Video() throws InterruptedException, IOException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("uploadcustomtab"))).click(); // Clicking on Upload Custom
		// Tab
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).click();// clicking on search bar
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("searchtemplate"))).sendKeys("video");// Entering Text in
		// Search bar
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchbutton"))).click();// clicking on Search button after
// entering text in search bar
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Templatediv")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("creatediv"))).click(); // Div for create Template
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("uploadcustomname"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("uploadcustomname")))// Giving a dynamic name for the
																				// template
				.sendKeys("harishuploadcustom" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("clickonbrowse"))).click();// Clicking on the browse button
		Thread.sleep(3000);

		Runtime.getRuntime().exec("D:\\Autoit\\uploadtemplate.exe");// uploading by Auto it

		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("saveuploadcustom"))).click();// Saving the Template

	}

	@Test(priority = 12, enabled = true)
	public void managetemplates() throws InterruptedException {

		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("Designmodule"))).click();// Click on Design Module
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("managetemplates"))).click();// Click on Manage Templates
	}

	@Test(priority = 13, enabled = true)
	public void managetemplates_Email() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("SelectingemailTemplate"))).click();// Selecting Email
																								// Template
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("previewemailtemplate"))).click();
		Thread.sleep(10000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));

		driver.findElement(By.xpath(properties.getProperty("copy_email_template"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename")))
				.sendKeys("email" + System.currentTimeMillis());
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savechangesforemailtemplate"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("closepopup"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("emailspamscore"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("emailspamcheck"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("emailspamclose"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("emailsendtestmail"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("enteringemail"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringemail")))
				.sendKeys("harish" + System.currentTimeMillis() + "@getnada.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("emailsubjectline"))).sendKeys("New Template created");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("email_send_test"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("sentsuccess"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Edit_email_template"))).click();
		Thread.sleep(15000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();

	}

	@Test(priority = 14, enabled = true)
	public void managetemplates_video() throws InterruptedException {
		Thread.sleep(8000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("view")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("gridview"))).click(); // Div for create Template
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("SelectingvideoTemplate"))).click();
		Thread.sleep(4000);

		WebElement ele1 = driver.findElement(By.xpath(properties.getProperty("videodiv")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action1 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action1.moveToElement(ele1).perform();
		driver.findElement(By.xpath(properties.getProperty("previewofvideotemplate"))).click(); // Div for create
																								// Template
		Thread.sleep(10000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		action1.moveToElement(ele1).perform();
		driver.findElement(By.xpath(properties.getProperty("copyofvideotemplate"))).click(); // Div for create Template
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename")))
				.sendKeys("email" + System.currentTimeMillis());
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savechangesforemailtemplate"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("closepopup"))).click();
		Thread.sleep(2000);

		WebElement ele2 = driver.findElement(By.xpath(properties.getProperty("videodiv")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action2 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action2.moveToElement(ele2).perform();

		driver.findElement(By.xpath(properties.getProperty("spamscoreofvideotemplate"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("spamscoreofvideotemplatebutton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("closespamscorepopup"))).click();
		Thread.sleep(4000);
		action2.moveToElement(ele2).perform();
		driver.findElement(By.xpath(properties.getProperty("sendtestmailvideo"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("videoemail"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("videoemail")))
				.sendKeys("videoharish" + System.currentTimeMillis() + "@getnada.com");//UPDTE EMIL
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("subjlineforvideotemplate")))
				.sendKeys("Videotemplate subject line");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("submitandsend"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("sentandok"))).click();
		Thread.sleep(3000);
		action2.moveToElement(ele2).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("editvideotemplate"))).click();
		Thread.sleep(15000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("SelectingvideoTemplate"))).click();
		Thread.sleep(4000);
		WebElement ele3 = driver.findElement(By.xpath(properties.getProperty("videodiv")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action3 = new Actions(driver);
		action3.moveToElement(ele3).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("deletevideotemplate"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("deletevideotemplateok"))).click();
		Thread.sleep(8000);
		managetemplates();
	}

	@Test(priority = 15, enabled = true)
	public void Email_cobranding() throws InterruptedException {

		Thread.sleep(8000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("view")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("folderlistview"))).click();
		Thread.sleep(5000);

		WebElement ele1 = driver.findElement(By.xpath(properties.getProperty("folderview1")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action1 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action1.moveToElement(ele1).perform();
		driver.findElement(By.xpath(properties.getProperty("viewicon"))).click();
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("folderemailcobranding"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("previewemailtemplate"))).click();
		Thread.sleep(10000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));

		driver.findElement(By.xpath(properties.getProperty("copy_email_template"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename")))
				.sendKeys("email" + System.currentTimeMillis());
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savechangesforemailtemplate"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("closepopup"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("emailspamscore"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("emailspamcheck"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("emailspamclose"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("emailsendtestmail"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("enteringemail"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringemail")))
				.sendKeys("harish" + System.currentTimeMillis() + "@getnada.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("emailsubjectline"))).sendKeys("New Template created");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("email_send_test"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("sentsuccess"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Edit_email_template"))).click();
		Thread.sleep(15000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();
		Thread.sleep(8000);
		managetemplates();

	}

	@Test(priority = 16, enabled = true)
	public void Video_Cobranding() throws InterruptedException {

		Thread.sleep(8000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("view")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath(properties.getProperty("folderlistview"))).click();
		Thread.sleep(5000);

		WebElement ele1 = driver.findElement(By.xpath(properties.getProperty("folderview1")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action1 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action1.moveToElement(ele1).perform();
		driver.findElement(By.xpath(properties.getProperty("viewicon"))).click();
		Thread.sleep(8000);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		// driver.findElement(By.xpath(properties.getProperty("videocobrandingtemplate"))).click();
		WebElement ele3 = driver.findElement(By.xpath(properties.getProperty("view1")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action3 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action3.moveToElement(ele3).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("foldergridviewicon1"))).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("videocobrandingtemplate"))).click();

		Thread.sleep(4000);

		WebElement ele4 = driver.findElement(By.xpath(properties.getProperty("videodiv")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action4 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action4.moveToElement(ele4).perform();
		driver.findElement(By.xpath(properties.getProperty("previewofvideotemplate"))).click(); // Div for create
																								// Template
		Thread.sleep(10000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		action4.moveToElement(ele4).perform();
		driver.findElement(By.xpath(properties.getProperty("copyofvideotemplate"))).click(); // Div for create Template
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename")))
				.sendKeys("email" + System.currentTimeMillis());
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savechangesforemailtemplate"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("closepopup"))).click();
		Thread.sleep(2000);

		WebElement ele2 = driver.findElement(By.xpath(properties.getProperty("videodiv")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action2 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action2.moveToElement(ele2).perform();

		driver.findElement(By.xpath(properties.getProperty("spamscoreofvideotemplate"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("spamscoreofvideotemplatebutton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("closespamscorepopup"))).click();
		Thread.sleep(4000);
		action2.moveToElement(ele2).perform();
		driver.findElement(By.xpath(properties.getProperty("sendtestmailvideo"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("videoemail"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("videoemail")))
				.sendKeys("videoharish" + System.currentTimeMillis() + "@getnada.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("subjlineforvideotemplate")))
				.sendKeys("Videotemplate subject line");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("submitandsend"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("sentandok"))).click();
		Thread.sleep(3000);
		action2.moveToElement(ele2).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("editvideotemplate"))).click();
		Thread.sleep(15000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();
		managetemplates();

	}

	@Test(priority = 17, enabled = true)
	public void folderlistevent() throws InterruptedException {

		Thread.sleep(8000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("view")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("folderlistview1"))).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("openfolder"))).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("eventtemplateflist"))).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("previewemailtemplate"))).click();
		Thread.sleep(10000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));

		driver.findElement(By.xpath(properties.getProperty("copy_email_template"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename")))
				.sendKeys("email" + System.currentTimeMillis());
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savechangesforemailtemplate"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("closepopup"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("emailspamscore"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("emailspamcheck"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("emailspamclose"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("emailsendtestmail"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("enteringemail"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringemail")))
				.sendKeys("harish" + System.currentTimeMillis() + "@getnada.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("emailsubjectline"))).sendKeys("New Template created");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("buttonsent1"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("sentsuccess"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Edit_email_template"))).click();
		Thread.sleep(15000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("openfolder"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("eventtemplateflist"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("deleteeventtemplate"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("deletingok"))).click();

	}

	@Test(priority = 18, enabled = true)
	public void Event_cobranding_manage() throws InterruptedException {

		Thread.sleep(8000);
		managetemplates();
		Thread.sleep(8000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("view")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("folderlistview1"))).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("openfolder"))).click();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Thread.sleep(4000);
		WebElement ele3 = driver.findElement(By.xpath(properties.getProperty("view2")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action3 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action3.moveToElement(ele3).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("folderlist_grid"))).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("eventcobrandingtemplateflist"))).click();

		Thread.sleep(4000);

		WebElement ele4 = driver.findElement(By.xpath(properties.getProperty("videodiv")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action4 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action4.moveToElement(ele4).perform();
		driver.findElement(By.xpath(properties.getProperty("previewofvideotemplate"))).click(); // Div for create
																								// Template
		Thread.sleep(10000);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // get all windows handle

		driver.switchTo().window(tabs.get(1)); // switch to the new tab
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		action4.moveToElement(ele4).perform();
		driver.findElement(By.xpath(properties.getProperty("copyofvideotemplate"))).click(); // Div for create Template
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("enteringthename")))
				.sendKeys("email" + System.currentTimeMillis());
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("savechangesforemailtemplate"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("closepopup"))).click();
		Thread.sleep(2000);

		WebElement ele2 = driver.findElement(By.xpath(properties.getProperty("videodiv")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action2 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action2.moveToElement(ele2).perform();

		driver.findElement(By.xpath(properties.getProperty("spamscoreofvideotemplate"))).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("spamscoreofvideotemplatebutton"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("closespamscorepopup"))).click();
		Thread.sleep(4000);
		action2.moveToElement(ele2).perform();
		driver.findElement(By.xpath(properties.getProperty("sendtestmailvideo"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("videoemail"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("videoemail")))
				.sendKeys("videoharish" + System.currentTimeMillis() + "@getnada.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("subjlineforvideotemplate")))
				.sendKeys("Eventtemplate subject line");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("submitandsendevent"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("sentandok"))).click();
		Thread.sleep(3000);
		action2.moveToElement(ele2).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("editvideotemplate"))).click();
		Thread.sleep(15000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
																					// //span[contains(text(),'SAVE')]/..
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		driver.findElement(By.xpath(properties.getProperty("update"))).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savebutton"))).click(); // clicking on Save Button
		logger.info("Clicking on save templates");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("updateandclose"))).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("openthefolder"))).click();
		Thread.sleep(4000);
		WebElement ele41 = driver.findElement(By.xpath(properties.getProperty("view2")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action41 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action41.moveToElement(ele41).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("openingtheview"))).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("eventcobrandingtemplateflist"))).click();
		Thread.sleep(3000);

		WebElement ele42 = driver.findElement(By.xpath(properties.getProperty("divofthetemplate")));
		Thread.sleep(2000);
		// Creating object of an Actions class
		Actions action42 = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action42.moveToElement(ele42).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("deletetheeventcotemplatebbutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("deletingtheeventco"))).click();
		managetemplates();

	}

	@Test(priority = 19, enabled = true)
	public void searchandsort() throws InterruptedException {
		Thread.sleep(8000);
		managetemplates();
		Thread.sleep(8000);
		Select sortby = new Select(driver.findElement(By.xpath(properties.getProperty("sort"))));
		sortby.selectByVisibleText("Name(A-Z)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("searchbox"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("searchbox"))).sendKeys("email");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("searchbox"))).sendKeys(Keys.ENTER);

	}

}