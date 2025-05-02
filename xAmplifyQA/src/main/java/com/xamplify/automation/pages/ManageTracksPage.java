

	package com.xamplify.automation.pages;

	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import com.xamplify.util.TracksUtil;
import com.xamplify.util.XamplifyUtil;

	public class ManageTracksPage {

		WebDriver driver;
		Properties properties;

		public ManageTracksPage(WebDriver driver, Properties properties) {
			this.driver = driver;
			this.properties = properties;
		}

		public void clickContentMenu() throws InterruptedException {
			TracksUtil.clickElementWithWait(driver, properties.getProperty("Content_leftmenu"), 50);
			Thread.sleep(3000);
		}

		public void clickManageTracks() throws InterruptedException {
			TracksUtil.callClickEvent(properties.getProperty("manage_tracks"));
			Thread.sleep(3000);
		}

		public void actions() throws InterruptedException, AWTException {
			
			TracksUtil.callClickEvent(properties.getProperty("clickon_edit_track"));
			Thread.sleep(2000);
			
			
			Robot robot = new Robot(); // use robot class to upload file -- create object
			XamplifyUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
			Thread.sleep(2000);
			
			WebElement browse = driver.findElement(By.xpath(properties.getProperty("clickon_upload")));
			browse.click(); // click on Browse
			Thread.sleep(3000);
			
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
			//logger.info("thumbnail uploaded using robot class");
			
		}
}
