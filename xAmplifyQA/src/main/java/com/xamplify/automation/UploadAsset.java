package com.xamplify.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	
	public void publish_to_partner() throws InterruptedException {
		
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

		
	}

// UPLOAD PNG FILE

	@Test(priority = 0, enabled = true)
	public void uploadasset_png() throws InterruptedException, IOException, AWTException {
		
		WebElement browse = driver.findElement(By.xpath(properties.getProperty("clicktouploadbutton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);
		Robot robot = new Robot(); // use robot class to upload file -- create object

// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\PNG_file.png");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
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
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\jpg_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "png_name", "asset");
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
		enter.sendKeys(properties.getProperty("png_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "png");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		
		Thread.sleep(2000);
		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			System.out.println("Asset file(png)uploaded successfully");
			logger.info("Asset file(png)uploaded successfully");
		} else {
			System.out.println("Asset file(png) not uploaded");
			logger.info("Asset file(png) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon
		Thread.sleep(4000);
	}

//	UPLOAD CSV FILE

	@Test(priority = 1, enabled = false)
	public void uploadasset_csv() throws InterruptedException, IOException, AWTException {
		hoverandclickoncontent_module();
		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton"))); // click on Browse
		browse.click();
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

// store the path of the file to be uploaded using string selection class object

		// create a strings election object copy above path to clipboard
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

// create a string selection object copy above path to clipboard
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
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("add_tagbutton"));
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("tag_text_click"));
		WebElement enter = driver.findElement(By.xpath(properties.getProperty("tag_text_click")));
		enter.sendKeys(properties.getProperty("csvtag_name") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "csv");
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
		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("clickon_Saveas_draft")); // click on submit
		Thread.sleep(2000);
		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			System.out.println("Asset file(xls/csv)uploaded successfully");
			logger.info("Asset file(xls/csv)uploaded successfully");
		} else {
			System.out.println("Asset file(xls/csv) not uploaded");
			logger.info("Asset file(xls/csv) is not uploaded");
		}
		Thread.sleep(5000);
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 30); // click on refresh icon
		Thread.sleep(4000);
	}

//UPLOAD ASSET THROUGH BOX ACCOUNT

	@Test(priority = 2, enabled = false)
	public void videoasset() throws InterruptedException, IOException, AWTException {
		hoverandclickoncontent_module();
		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath(properties.getProperty("boxicon_click"))).click(); // click on upload
		Thread.sleep(5000);
		for (String windowHandle : driver.getWindowHandles()) {
			if (!parentWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				XamplifyUtil.sendTextEvent(properties.getProperty("box_email"), "arohith@stratapps.com");
				// entering email id
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
				XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "box");
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

				publish_to_partner();//publish to a partner
				Thread.sleep(2000);

				logger.info("asset(jpeg) has been uploaded from box account");

				XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Refresh"), 50);
				logger.info("asset has been published successfully through box account");

			}

		}
	}

//UPLOAD VIDEO ASSET

	@Test(priority = 3, enabled = false)
	public void uploadasset_video() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton"))); // click on Browse
		browse.click();
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\mp4_file.mp4");
// create a string selection object copy above path to clipboard
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
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\jpg_file.jpg");
		// create a string selection object copy above path to clipboard

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);
		// here path is avaliable in clipboard

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
		enter.sendKeys(properties.getProperty("vtag_name") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "video");
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
		Thread.sleep(20000);

//		JavascriptExecutor js23 = (JavascriptExecutor) driver; // Scroller
//		js23.executeScript("window.scrollTo(100,document.body.scrollHeight)");
//		Thread.sleep(4000);
//		
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_selectpartner_search"), "active");
		Thread.sleep(2000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_selectpartner_search_icon"));
		Thread.sleep(5000);
		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("clickon_groupofpartner_rightarrow"), 50);
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

		System.out.println("Asset file(Video)uploaded successfully");

	}

	// UPLOAD PPT FILE

	@Test(priority = 4, enabled = false)
	public void uploadasset_ppt() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\PPT_file.ppt");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//			logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "ppt_name", "asset");
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
		enter.sendKeys(properties.getProperty("ppt_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "PPT");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			System.out.println("Asset file(ppt)uploaded successfully");
			logger.info("Asset file(ppt)uploaded successfully");
		} else {
			System.out.println("Asset file(ppt) not uploaded");
			logger.info("Asset file(ppt) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon
		logger.info("PPT asset uploaded successfully");
		Thread.sleep(4000);
	}

	// UPLOAD PPTX FILE

	@Test(priority = 5, enabled = false)
	public void uploadasset_pptx() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		Thread.sleep(3000);
		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\PPTX_file.pptx");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//				logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "pptx_name", "asset");
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
		enter.sendKeys(properties.getProperty("pptx_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "PPTX");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			System.out.println("Asset file(pptx)uploaded successfully");
			logger.info("Asset file(pptx)uploaded successfully");
		} else {
			System.out.println("Asset file(pptx) not uploaded");
			logger.info("Asset file(pptx) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon
		Thread.sleep(4000);
	}

// UPLOAD DOC FILE

	@Test(priority = 6, enabled = false)
	public void uploadasset_doc() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		Thread.sleep(3000);

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\DOC_file.doc");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//				logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "doc_name", "asset");
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
		enter.sendKeys(properties.getProperty("doc_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "DOC");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			System.out.println("Asset file(doc)uploaded successfully");
			logger.info("Asset file(doc)uploaded successfully");
		} else {
			System.out.println("Asset file(doc) not uploaded");
			logger.info("Asset file(doc) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon
		Thread.sleep(4000);
	}

	// UPLOAD DOCX FILE

	@Test(priority = 7, enabled = false)
	public void uploadasset_docx() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		Thread.sleep(3000);

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\DOCX_file.docx");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//					logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "docx_name", "asset");
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
		enter.sendKeys(properties.getProperty("docx_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "DOCX");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			System.out.println("Asset file(docx)uploaded successfully");
			logger.info("Asset file(docx)uploaded successfully");
		} else {
			System.out.println("Asset file(docx) not uploaded");
			logger.info("Asset file(docx) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon
		Thread.sleep(4000);
	}

// UPLOAD PDF FILE

	@Test(priority = 8, enabled = false)
	public void uploadasset_pdf() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		Thread.sleep(3000);

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\PDF_file.pdf");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//					logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "pdf_name", "asset");
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
		enter.sendKeys(properties.getProperty("pdf_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "PDF");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

//		XamplifyUtil.callClickEvent(properties.getProperty("Submit")); // click on submit
//		Thread.sleep(2000);
		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			System.out.println("Asset file(pdf)uploaded successfully");
			logger.info("Asset file(pdf)uploaded successfully");
		} else {
			System.out.println("Asset file(pdf) not uploaded");
			logger.info("Asset file(pdf) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon
		Thread.sleep(4000);
	}

	// UPLOAD JPG FILE

	@Test(priority = 9, enabled = false)
	public void uploadasset_jpg() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		Thread.sleep(3000);

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\jpg_file.jpg");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//							logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "jpg_name", "asset");
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
		enter.sendKeys(properties.getProperty("jpg_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "JPG");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {

			System.out.println("Asset file(jpg)uploaded successfully");
			logger.info("Asset file(jpg)uploaded successfully");
		} else {
			System.out.println("Asset file(jpg) not uploaded");
			logger.info("Asset file(jpg) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon
		Thread.sleep(4000);
	}

// UPLOAD GIF FILE

	@Test(priority = 10, enabled = false)
	public void uploadasset_gif() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		Thread.sleep(3000);

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\GIF_file.gif");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//							logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "GIF_name", "asset");
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
		enter.sendKeys(properties.getProperty("gif_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "gif");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {

			System.out.println("Asset file(gif)uploaded successfully");
			logger.info("Asset file(gif)uploaded successfully");
		} else {
			System.out.println("Asset file(gif) not uploaded");
			logger.info("Asset file(gif) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon
		Thread.sleep(4000);
	}

	// UPLOAD HTML FILE

	@Test(priority = 11, enabled = false)
	public void uploadasset_html() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		Thread.sleep(3000);

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\HTML_file.html");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//										logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "HTML_name", "asset");
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
		enter.sendKeys(properties.getProperty("HTML_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "html");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {

			System.out.println("Asset file(HTML)uploaded successfully");
			logger.info("Asset file(HTML)uploaded successfully");
		} else {
			System.out.println("Asset file(HTML) not uploaded");
			logger.info("Asset file(HTML) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon

		Thread.sleep(4000);
	}

	// UPLOAD TXT FILE

	@Test(priority = 12, enabled = false)
	public void uploadasset_txt() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		Thread.sleep(3000);

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\txt_file.txt");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//										logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "TXT_name", "asset");
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
		enter.sendKeys(properties.getProperty("TXT_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "txt");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {

			System.out.println("Asset file(TXT)uploaded successfully");
			logger.info("Asset file(TXT)uploaded successfully");
		} else {
			System.out.println("Asset file(TXT) not uploaded");
			logger.info("Asset file(TXT) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon

		Thread.sleep(4000);
	}

	
	
	@Test(priority = 13, enabled = false)
	public void uploadasset_zip() throws InterruptedException, IOException, AWTException {

		hoverandclickoncontent_module();
		Thread.sleep(3000);

		WebElement browse = driver.findElement(By.xpath(properties.getProperty("BrowseButton")));
		browse.click(); // click on Browse
		Thread.sleep(3000);

		Robot robot = new Robot(); // use robot class to upload file -- create object

		// store the path of the file to be uploaded using stringselection class object
		StringSelection filepath = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\zip_file.zip");
		// create a string selection object copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// here path is avaliable in clipboard
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);// press ctrl
		robot.keyPress(KeyEvent.VK_V); // press V
		robot.keyRelease(KeyEvent.VK_V); // release V
		robot.keyRelease(KeyEvent.VK_CONTROL);// relase ctrl
		robot.keyPress(KeyEvent.VK_ENTER);// press enter
		robot.keyRelease(KeyEvent.VK_ENTER); // release enter
//										logger.info("png file uploaded using robot class");
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(2000);
		StringSelection filepath1 = new StringSelection("D:\\git\\xAmplifyQA\\xAmplifyQA\\files\\Thumbnail_file.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null); // here path is avaliable in
		// create a string selection object copy above path to clipboard // clipboard

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

		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Name"), "ZIP_name", "asset");
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
		enter.sendKeys(properties.getProperty("ZIP_tag") + "_" + System.currentTimeMillis());
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
		XamplifyUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "txt");
		Thread.sleep(1000);
		XamplifyUtil.excelDownload();
		XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		XamplifyUtil.sendTextEvent(properties.getProperty("Descriptionclick"), ("Asset_Description"));
		// enter description
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		publish_to_partner();//publish to a partner
		Thread.sleep(2000);

		logger.info("clicked on submit button after filling all mandaoty fields");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("asset_Successmessage")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Uploaded Successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {

			System.out.println("Asset file(TXT)uploaded successfully");
			logger.info("Asset file(TXT)uploaded successfully");
		} else {
			System.out.println("Asset file(TXT) not uploaded");
			logger.info("Asset file(TXT) is not uploaded");
		}
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Refresh")); // click on refresh icon

		Thread.sleep(4000);
	}

}


