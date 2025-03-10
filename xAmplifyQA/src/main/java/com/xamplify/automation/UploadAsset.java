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
@Test(priority = 0, enabled = false)
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

String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("Success"))).getText();
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
@Test(priority = 1, enabled = false)
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
XamplifyUtil.callClickEvent(properties.getProperty("clickon_Saveas_draft")); // click on submit
Thread.sleep(2000);
logger.info("clicked on submit button after filling all mandaoty fields");

String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("Success"))).getText();
Thread.sleep(3000);
String expectedresult_asset = "Uploaded Successfully";
if (expectedresult_asset.equals(actualresult_asset)) {
	logger.info("Asset file(xls)uploaded successfully");
} else {
	logger.info("Asset file(xls) is not uploaded");
}
Thread.sleep(3000);
driver.findElement(By.xpath(properties.getProperty("Refresh"))).click(); // click on refresh icon
logger.info("Refresh icon has been clicked");
	Thread.sleep(4000);
}

//	uploading asset through box account
@Test(priority = 2, enabled = true)
public void assetthroughbox() throws InterruptedException, IOException, AWTException {
	// hoverandclickoncontent_module();
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
		
		//Enter the Name of the Asset
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
		Thread.sleep(2000);

		logger.info("asset(jpeg) has been uploaded from box account");
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Refresh"))).click();
		logger.info("Refresh icon has been clicked");
		logger.info("asset has been published successfully");

			}

		}
	}
}
