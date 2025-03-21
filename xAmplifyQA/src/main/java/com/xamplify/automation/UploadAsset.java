package com.xamplify.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class UploadAsset {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Dam.properties");
	final Logger logger = LogManager.getLogger(UploadAsset.class);

	@Test
	public void hoverandclickoncontent_module() throws InterruptedException {

		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Content_leftmenu"), 50);

// click on left side content menu
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("DesignUpload")); // click on design/upload
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Upload")); // click on upload
		Thread.sleep(3000);

	}

// uploading png file asset
	@Test(priority = 0, enabled = true)
	public void uploadasset_png() throws InterruptedException, IOException, AWTException {

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton"))); // click on Browse
		browse.click();
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\PNG_file.png"); // create
																												// a
																												// stringselection
// object
// copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null); // here path is avaliable in
																						// clipboard
		Thread.sleep(4000);

		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//		logger.info("png file uploaded using robot class");
		Thread.sleep(3000);

		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\jpg_file.jpg"); // create
																													// a
// stringselection
// object
// copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
																						// clipboard

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("Savechanges")); // click on save changes
		Thread.sleep(2000);
		logger.info("thumbnail uploaded using robot class");

// Runtime.getRuntime().exec("D:\\Selenium\\Thumbnail.exe"); //upload thumbnail
// image using autoit

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "png_name", "asset");
// driver.findElement(By.xpath(properties.getProperty("Name"))).sendKeys(properties.getProperty("png_name")+
// "_" + System.currentTimeMillis());
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("folder_dropdown_click1")); // click on folder dropdown
		Thread.sleep(2000);
		WebElement fold_search = driver.findElement(By.xpath(properties.getProperty("folder_Search")));
		fold_search.sendKeys("xamplify2024-Default-Folder");
		fold_search.click();
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("folder_selection1")); // click on folder dropdown
		Thread.sleep(3000);
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("tag_plusicon"), 50);
// XamplifyUtil.callClickEvent(properties.getProperty("tag_plusicon"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("add_tagbutton"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_text_click"));
		WebElement enter = driver.findElement(By.xpath(properties.getProperty("tag_text_click")));
		enter.sendKeys(properties.getProperty("tag_name") + "_" + System.currentTimeMillis());
		enter.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_savebutton"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_select"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_savebutton"));
		Thread.sleep(1000);

		XamplifyUtil.clickElementWithWait(driver, (properties.getProperty("clickon_add_moretags")), 30);
// XamplifyUtil.callClickEvent(properties.getProperty("clickon_add_moretags"));
		Thread.sleep(1000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "test");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);

		driver.switchTo().frame(0);
// XamplifyUtil.callClickEvent(properties.getProperty("Descriptionclick"));
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description")); // enter
																										// description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		XamplifyUtil.callClickEvent(properties.getProperty("Submit")); // click on submit
		Thread.sleep(2000);
		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			logger.info("Asset file(png)uploaded successfully");
		} else {
			logger.info("Asset file(png) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon
		logger.info("Refresh icon has been clicked");
		Thread.sleep(4000);
	}

//	//uploading xls file
	@Test(priority = 1, enabled = true)
	public void uploadasset_csv() throws InterruptedException, IOException, AWTException {
		hoverandclickoncontent_module();
		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton"))); // click on Browse
		browse.click();
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

// store the path of the file to be uploaded using stringselection class object

// create a stringselection object copy above path to clipboard
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\XLS_file.csv");

// here path is avaliable in clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Thread.sleep(4000);

		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//		logger.info("png file uploaded using robot class");
		Thread.sleep(3000);

		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);

// create a stringselection object copy above path to clipboard
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\jpg_file.jpg");

// here path is avaliable in clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
		Thread.sleep(4000);

		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
		Thread.sleep(3000);

		XamplifyUtil.callClickEvent(properties.getProperty("Savechanges"));
		Thread.sleep(3000);
		logger.info("thumbnail uploaded using robot class");

// Runtime.getRuntime().exec("D:\\Selenium\\Thumbnail.exe");

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "xls_name", "asset");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("folder_dropdown_click1")); // click on folder dropdown
		Thread.sleep(2000);
		WebElement fold_search = driver.findElement(By.xpath(properties.getProperty("folder_Search")));
		fold_search.sendKeys("xamplify2024-Default-Folder");
		fold_search.click();
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("folder_selection1")); // click on folder dropdown
		Thread.sleep(3000);
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("tag_plusicon"), 50);
// XamplifyUtil.callClickEvent(properties.getProperty("tag_plusicon"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("add_tagbutton"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_text_click"));
		WebElement enter = driver.findElement(By.xpath(properties.getProperty("tag_text_click")));
		enter.sendKeys(properties.getProperty("tag_name") + "_" + System.currentTimeMillis());
		enter.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_savebutton"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_select"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_savebutton"));
		Thread.sleep(1000);

		XamplifyUtil.clickElementWithWait(driver, (properties.getProperty("clickon_add_moretags")), 30);
// XamplifyUtil.callClickEvent(properties.getProperty("clickon_add_moretags"));
		Thread.sleep(1000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "test");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);

		driver.switchTo().frame(0);
// XamplifyUtil.callClickEvent(properties.getProperty("Descriptionclick"));
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description")); // enter
																										// description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_Saveas_draft")); // click on submit
		Thread.sleep(2000);
		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage"))).getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			logger.info("Asset file(xls)uploaded successfully");
		} else {
			logger.info("Asset file(xls) is not uploaded");
		}
		Thread.sleep(5000);
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30); // click on refresh icon
		logger.info("Refresh icon has been clicked");
		Thread.sleep(4000);
	}

//	uploading asset through box account
	@Test(priority = 2, enabled = true)
	public void videoasset() throws InterruptedException, IOException, AWTException {
		 hoverandclickoncontent_module();
		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath(properties.getProperty("boxicon_click"))).click(); // click on upload
		Thread.sleep(5000);
		for (String windowHandle : driver.getWindowHandles()) {
			if (!parentWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				XamplifyUtil.sendTextEvent(properties.getProperty("box_email"), "arohith@stratapps.com"); // entering
																											// email id
				Thread.sleep(2000);
				logger.info("email id has been entered");
				XamplifyUtil.callClickEvent(properties.getProperty("box_next_button")); // click on next button
				Thread.sleep(2000);
				XamplifyUtil.sendTextEvent(properties.getProperty("box_password"), "Xamplify@11"); // entering password
				Thread.sleep(2000);
				logger.info("password has been entered");
				XamplifyUtil.callClickEvent(properties.getProperty("box_login_button")); // click on login button
				Thread.sleep(2000);
				logger.info("login button has been clicked");
				XamplifyUtil.callClickEvent(properties.getProperty("box_select_document")); // select document from box
																							// account
				Thread.sleep(2000);
				logger.info("document has been selected");
				XamplifyUtil.callClickEvent(properties.getProperty("box_uploadbutton")); // click on upload after
																							// selecting document
				Thread.sleep(2000);
				logger.info("document has been uploaded");
				driver.switchTo().window(parentWindow);
				Thread.sleep(1000);

				// Enter the Name of the Asset
				XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "box_document", "Asset");
				Thread.sleep(2000);
				XamplifyUtil.callClickEvent(properties.getProperty("folder_dropdown_click1")); // click on folder
																								// dropdown
				Thread.sleep(2000);
				WebElement fold_searchb = driver.findElement(By.xpath(properties.getProperty("folder_Search")));
				fold_searchb.sendKeys("xamplify2024-Default-Folder");
				fold_searchb.click();
				Thread.sleep(1000);
				XamplifyUtil.callClickEvent(properties.getProperty("folder_selection1")); // click on folder dropdown
				Thread.sleep(3000);
				XamplifyUtil.clickElementWithWait(driver, properties.getProperty("tag_plusicon"), 50);

				Thread.sleep(1000);
				XamplifyUtil.callClickEvent(properties.getProperty("add_tagbutton"));
				Thread.sleep(2000);
				XamplifyUtil.callClickEvent(properties.getProperty("tag_text_click"));
				WebElement enter = driver.findElement(By.xpath(properties.getProperty("tag_text_click")));
				enter.sendKeys(properties.getProperty("tag_name") + "_" + System.currentTimeMillis());
				enter.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				XamplifyUtil.callClickEvent(properties.getProperty("tag_savebutton"));
				Thread.sleep(2000);
				XamplifyUtil.callClickEvent(properties.getProperty("tag_select"));
				Thread.sleep(2000);
				XamplifyUtil.callClickEvent(properties.getProperty("tag_savebutton"));
				Thread.sleep(1000);

				XamplifyUtil.clickElementWithWait(driver, (properties.getProperty("clickon_add_moretags")), 30);
				Thread.sleep(1000);
				XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "test");
				Thread.sleep(1000);
				XamplifyUtil.excelDownload();
				XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
				Thread.sleep(1000);
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
				Thread.sleep(1000);

				driver.switchTo().frame(0);
				// XamplifyUtil.callClickEvent(properties.getProperty("Descriptionclick"));
				XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description")); // enter
																												// description
				Thread.sleep(2000);
				driver.switchTo().defaultContent();

				XamplifyUtil.sendTextEvent(properties.getProperty("clickon_selectpartner_search"), "PartnerAuto");
				Thread.sleep(2000);
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_selectpartner_search_icon"));
				Thread.sleep(5000);
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_selectedpartner_rightarrow"));
				Thread.sleep(2000);
				XamplifyUtil.callClickEvent(properties.getProperty("clickon_entity_info_checkbox"));
				Thread.sleep(2000);

				XamplifyUtil.callClickEvent(properties.getProperty("clickon_saveandpublish"));
				Thread.sleep(5000);

				logger.info("asset(jpeg) has been uploaded from box account");

				XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 50);
				logger.info("Refresh icon has been clicked");
				logger.info("asset has been published successfully");

			}

		}
	}

//		uploading asset through box account
	@Test(priority = 3, enabled = true)
	public void uploadasset_video() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton"))); // click on Browse
		browse.click();
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\mp4_file.mp4"); // create
																												// a
																												// stringselection
// object
// copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null); // here path is avaliable in
																						// clipboard
		Thread.sleep(4000);

		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//		logger.info("png file uploaded using robot class");
		Thread.sleep(3000);

		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\jpg_file.jpg"); // create
																													// a
// stringselection
// object
// copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
																						// clipboard

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("Savechanges")); // click on save changes
		Thread.sleep(2000);
		logger.info("thumbnail uploaded using robot class");

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "mp4_name", "asset");

		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("folder_dropdown_click1")); // click on folder dropdown
		Thread.sleep(2000);
		WebElement fold_search = driver.findElement(By.xpath(properties.getProperty("folder_Search")));
		fold_search.sendKeys("xamplify2024-Default-Folder");
		fold_search.click();
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("folder_selection1")); // click on folder dropdown
		Thread.sleep(3000);
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("tag_plusicon"), 50);
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("add_tagbutton"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_text_click"));
		WebElement enter = driver.findElement(By.xpath(properties.getProperty("tag_text_click")));
		enter.sendKeys(properties.getProperty("tag_name") + "_" + System.currentTimeMillis());
		enter.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_savebutton"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_select"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_savebutton"));
		Thread.sleep(1000);

		XamplifyUtil.clickElementWithWait(driver, (properties.getProperty("clickon_add_moretags")), 30);
		Thread.sleep(1000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "test");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);

		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description")); // enter
																										// description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_groupofpartner"));
		Thread.sleep(8000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_selectpartner_search"), "PartnerAuto");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_selectpartner_search_icon"));
		Thread.sleep(5000);
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("clickon_groupofpartner_rightarrow"), 50);
		// XamplifyUtil.callClickEvent(properties.getProperty("clickon_groupofpartner_rightarrow"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_groupof_partner_entityinfo"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_previewof_partnerlist"));
		Thread.sleep(5000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_previewpartner"), ("mounika"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_searchicon_previewpartner"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_close_previewpartner"));
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_saveandpublish"));
		Thread.sleep(5000);
		logger.info("MP4 asset has been published successfully");

		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 50);
		logger.info("Refresh icon has been clicked");
		Thread.sleep(4000);

	}
	
	@Test(priority = 4, enabled = true)
	public void video_asset_Actions() throws InterruptedException, AWTException {
		
		Thread.sleep(5000);		
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30);
		Thread.sleep(3000);	
		logger.info("Refresh icon has been clicked");
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30);
		Thread.sleep(6000);	

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_edit_video_asset"));
		Thread.sleep(6000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_replace_button"));
		Thread.sleep(4000);
		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton"))); // click on Browse
		browse.click();
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\replace_mp4_file.mp4"); // create
																												// a
																												// stringselection
// object
// copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null); // here path is avaliable in
																						// clipboard
		Thread.sleep(4000);

		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//		logger.info("png file uploaded using robot class");
		Thread.sleep(5000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_replace_update"));
		Thread.sleep(2000);
		
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30);
		Thread.sleep(5000);
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30);
		Thread.sleep(8000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_preview_videoasset"));
		Thread.sleep(7000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_manageasset_breadcrumb"));
		Thread.sleep(5000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_videoasset_Analytics"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_videoasset_Analytics"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_videoasset_Analytics"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_manageasset_breadcrumb"));
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_asset_delete"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_yesdelete"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "Asset Deleted Successfully");
	}

	@Test(priority = 5, enabled = true)

	public void assetsort_search_edit_download_analtics_actions_png() throws InterruptedException, IOException, AWTException {

		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30);
		logger.info("Refresh icon has been clicked");

		// XamplifyUtil.callClickEvent(properties.getProperty("ManageMyAssets"));
		// //click on manage assets
		Thread.sleep(6000);
		// click on sorting dropdown and sort by values

		WebElement sort_Asset = driver.findElement(By.xpath(properties.getProperty(("Clickondropdown"))));
		sort_Asset.click();
		Thread.sleep(2000);

		XamplifyUtil.selectDropdownByText(properties.getProperty("Clickondropdown"), "Created On(ASC)");
		Thread.sleep(4000);
		

		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_Asset_search"), "png");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_Asset_searchicon"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_edit_asset"));
		Thread.sleep(2000);

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton"))); // click on Browse
		browse.click();
		Thread.sleep(3000);
		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\replace_png_file.png"); // create
		// a
		// stringselection
		// object
		// copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null); // here path is avaliable in
																						// clipboard
		Thread.sleep(4000);

		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//				logger.info("png file uploaded using robot class");
		Thread.sleep(3000);

		XamplifyUtil.callClickEvent(properties.getProperty("click_update_asset"));
		Thread.sleep(5000);

		XamplifyUtil.takeScreenshot(driver, "Asset updated successfully");
		logger.info("clicked on update button");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);

		String expectedresult_asset = "Updated Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			logger.info("Assetfile-png updated successfully with replacing asset");
		} else {
			logger.info("Error while updating asset file");
		}

		Thread.sleep(2000);

		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_Asset_search"), "png");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_Asset_searchicon"));
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_download_asset"));
		Thread.sleep(2000);
		XamplifyUtil.excelDownload();
		Thread.sleep(1000);
		logger.info("Assetfile downloaded successfully");

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_asset_analytics"));
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_asset_analytics_close"));
		Thread.sleep(4000);
		logger.info("analytics icon has been clicked-but no parnter details avaliable");

		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_Asset_search"), "png");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_Asset_searchicon"));
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_asset_delete"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_yesdelete"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "Asset Deleted Successfully");

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_Asset_searchclear"));
		Thread.sleep(2000);

	}

	// grid and list view
	@Test(priority = 6, enabled = true)
	public void views_png() throws InterruptedException {
		

		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("hoveron_listview"), 30);
		Thread.sleep(1000);
		// clicking on grid view
		WebElement gridview = driver.findElement(By.xpath(properties.getProperty("clickon_gridview")));
		gridview.click();
		Thread.sleep(9000);
		
		logger.info("assets viewed in grid view");
		
		XamplifyUtil.callClickEvent(properties.getProperty("hoveron_asset_gv"));
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_Asset_preview"));
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
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
		
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("hoveron_gridview"), 30);
		Thread.sleep(1000);

		// clickng on folder list view
		WebElement foldergridview = driver.findElement(By.xpath(properties.getProperty("clickon_foldergridview")));
		foldergridview.click();
			Thread.sleep(3000);
			XamplifyUtil.callClickEvent(properties.getProperty("hoveron_asset_fgv"));
			Thread.sleep(3000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_folderasset_preview_fgv"));
			Thread.sleep(3000);
			
		logger.info("assets viewed in foldergrid view");
		
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_fv_uparrow"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("hoveron_fgv"));
		Thread.sleep(3000);
	

		// clickng on folder grid view
		WebElement folderlistview = driver.findElement(By.xpath(properties.getProperty("clickon_folderlistview")));
		folderlistview.click();
		Thread.sleep(3000);
		
		WebElement search_dropdown = driver.findElement(By.xpath(properties.getProperty("clickon_searchdropdown_flv")));
		search_dropdown.click();
		Thread.sleep(3000);
		
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_searchdropdown_flv"), "Search In Folder");
		Thread.sleep(3000);
		
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_asset_flv"),"png");
		Thread.sleep(3000);
		
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_searchicon_asset_flv"));
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_asset_delete"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_yesdelete"));
		Thread.sleep(2000);
		XamplifyUtil.takeScreenshot(driver, "Asset Deleted Successfully");
		
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_fv_uparrow"));
		Thread.sleep(3000);

		XamplifyUtil.callClickEvent(properties.getProperty("hoveron_flv"));
		Thread.sleep(3000);
		// clickng on list view
		WebElement listview = driver.findElement(By.xpath(properties.getProperty("clickon_listview")));
		listview.click();
		Thread.sleep(3000);
	}

	// search asset and view asset and download asset --succesfull
	@Test(priority = 7, enabled = true)
	public void asset_filter_png() throws InterruptedException {

		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("clickon_filter_icon"), 30);
		//XamplifyUtil.callClickEvent(properties.getProperty("clickon_filter_icon"));
		Thread.sleep(3000);
		WebElement fieldname_drpdown = driver.findElement(By.xpath(properties.getProperty("clickon_fieldname_dropdown")));
		fieldname_drpdown.click();
		Thread.sleep(3000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown"), "Asset Name");
		Thread.sleep(2000);
		
		WebElement condition_drpdown = driver.findElement(By.xpath(properties.getProperty("clickon_condition_dropdown")));
		condition_drpdown.click();
		Thread.sleep(3000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_condition_dropdown"), "Contains");
		Thread.sleep(2000);
	
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_value_field"),"png");
		Thread.sleep(3000);
		
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_selectdate_field"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("select_from_date"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_todate_field"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("select_to_date"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
		Thread.sleep(4000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_addacondition_icon_filter"));
		Thread.sleep(1000);
		fieldname_drpdown.click();
		Thread.sleep(3000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown2"), "Folder");
		Thread.sleep(2000);
		condition_drpdown.click();
		Thread.sleep(3000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_condition_dropdown2"), "Contains");
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_value_field2"),"default");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
		Thread.sleep(4000);
		
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_addacondition_icon_filter"));
		Thread.sleep(1000);
		fieldname_drpdown.click();
		Thread.sleep(3000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown3"), "Type");
		Thread.sleep(2000);
		
		WebElement assettype_drpdown = driver.findElement(By.xpath(properties.getProperty("clickon_Assettype_drpdown")));
		assettype_drpdown.click();
		Thread.sleep(1000);
		
		XamplifyUtil.selectDropdownByValue(properties.getProperty("clickon_Assettype_drpdown"), "png");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
		Thread.sleep(4000);
		
		
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_addacondition_icon_filter"));
		Thread.sleep(1000);
		fieldname_drpdown.click();
		Thread.sleep(3000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown4"), "Tags");
		Thread.sleep(2000);
		condition_drpdown.click();
		Thread.sleep(3000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_condition_dropdown4"), "Contains");
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_value_field3"),"re");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
		Thread.sleep(4000);
		
		
		
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_addacondition_icon_filter"));
		Thread.sleep(1000);
		fieldname_drpdown.click();
		Thread.sleep(3000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_fieldname_dropdown5"), "Created By");
		Thread.sleep(2000);
		XamplifyUtil.selectDropdownByText(properties.getProperty("clickon_condition_dropdown5"), "=");
		Thread.sleep(2000);
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_value_field4"),"vendor automate");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_submit_filter"));
		Thread.sleep(4000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver; // Scroller
		js1.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(4000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_remove_filter"));
		Thread.sleep(4000);
		
		
	}

	
	

	
	

	

}
