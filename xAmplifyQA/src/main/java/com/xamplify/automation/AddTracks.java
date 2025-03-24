
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

public class AddTracks {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Tracks.properties");
	final Logger logger = LogManager.getLogger(AddTracks.class);

	@Test(priority = 0, enabled = true)
	public void add_tracks() throws InterruptedException, AWTException {

		XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Content_leftmenu"), 50); // click on left side
		// content menu
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("Add_tracks")); // click on add tracks
		Thread.sleep(3000);
		XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Title_textfield"), "Track", "auto");

		Thread.sleep(2000);

		XamplifyUtil.callClickEvent(properties.getProperty("folder_dropdown_click1")); // click on folder dropdown
		Thread.sleep(2000);
		WebElement fold_search = driver.findElement(By.xpath(properties.getProperty("folder_Search")));
		fold_search.sendKeys("xamplify2024-Default-Folder");
		fold_search.click();
		Thread.sleep(1000);
		XamplifyUtil.callClickEvent(properties.getProperty("folder_selection1")); // click on folder dropdown
		Thread.sleep(2000);

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
		Thread.sleep(2000);

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

		XamplifyUtil.callClickEvent(properties.getProperty("next_button")); // click on next button
		Thread.sleep(5000);

		
		XamplifyUtil.callClickEvent(properties.getProperty("add_media"));// click on add media
		Thread.sleep(5000);
		WebElement firstasset = driver.findElement(By.xpath(properties.getProperty("firstasset_click")));
		if (firstasset.isDisplayed()) {
			XamplifyUtil.callClickEvent(properties.getProperty("firstasset_click"));
			Thread.sleep(5000);
			XamplifyUtil.sendTextEvent(properties.getProperty("display_text"),("Asset"));
			Thread.sleep(5000);
			XamplifyUtil.callClickEvent(properties.getProperty("confirm_button"));
			logger.info("asset is selected");
		} else {
			XamplifyUtil.callClickEvent(properties.getProperty("close_popup_media"));
			logger.info("no asset selected");
		}

		Thread.sleep(5000);
		// selecting first form
		XamplifyUtil.callClickEvent(properties.getProperty("add_forms")); // click on add forms
		Thread.sleep(5000);

		WebElement firstform = driver.findElement(By.xpath(properties.getProperty("firstform_click")));

		if (firstform.isDisplayed()) {
		
			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("form_Preview"));
			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("form_preview_close"));
			Thread.sleep(2000);
			XamplifyUtil.callClickEvent(properties.getProperty("firstform_click"));
			logger.info("form is selected");

			
		} else {
			XamplifyUtil.callClickEvent(properties.getProperty("close_popup_form"));
			logger.info("no form selected");

		}

		Thread.sleep(5000);
		driver.switchTo().frame(0);
		XamplifyUtil.callClickEvent(properties.getProperty("Description_field"));
		Thread.sleep(5000);
		XamplifyUtil.sendTextEvent(properties.getProperty("Description_field"),("Track_Description")); // enter
																													// description
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		XamplifyUtil.callClickEvent(properties.getProperty("next_button"));
		Thread.sleep(5000);
		logger.info("description is entered");

		// selecting first quiz
		XamplifyUtil.callClickEvent(properties.getProperty("select_quiz"));// click on select quiz
		Thread.sleep(5000);
		WebElement firstquiz = driver.findElement(By.xpath(properties.getProperty("firstquiz_click")));

		if (firstquiz.isDisplayed()) {
			XamplifyUtil.callClickEvent(properties.getProperty("firstquiz_click"));
			Thread.sleep(5000);

			XamplifyUtil.callClickEvent(properties.getProperty("close_popup_quiz"));
			logger.info("quiz form is selected");
		} else {
			XamplifyUtil.callClickEvent(properties.getProperty("close_popup_quiz"));
			logger.info("no quiz form selected");

		}

		Thread.sleep(10000);
		XamplifyUtil.callClickEvent(properties.getProperty("search_txt")); // search with mp4 in search box
		XamplifyUtil.sendTextEvent(properties.getProperty("search_txt"),("mp4")); // search with mp4 in search
		Thread.sleep(3000);																					// box
		XamplifyUtil.callClickEvent(properties.getProperty("Search_click"));
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("first_asset_selection")); // select first asset
		Thread.sleep(3000);
		XamplifyUtil.callClickEvent(properties.getProperty("next_button")); // click on next button
		logger.info("mp4 first asset selected");
		Thread.sleep(5000);
		XamplifyUtil.sendTextEvent(properties.getProperty("Search_publish"), ("automatedPartner")); // select
																												// automatedPartner
																												// in
																												// search
																												// field
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Search_publish"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("arrow_click_track")); // select arrow of partner
																							// company
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("partner_select_track")); // select partner
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("save&publish_button")); // click on save&publish
																								// button
		Thread.sleep(5000);
		logger.info("clicked on save&publish button");

		String actualresult_asset = driver.findElement(By.xpath(properties.getProperty("afterpublish_success")))
				.getText();
		Thread.sleep(3000);
		String expectedresult_asset = "Track created successfully";
		if (expectedresult_asset.equals(actualresult_asset)) {
			logger.info("Track published to partner successfully");
		} else {
			logger.info("Error while publishing the track to partner");
		}
		Thread.sleep(3000);




	}

}