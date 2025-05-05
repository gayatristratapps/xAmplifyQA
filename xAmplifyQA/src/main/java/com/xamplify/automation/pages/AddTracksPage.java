package com.xamplify.automation.pages;

import java.awt.AWTException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.xamplify.util.TracksUtil;

public class AddTracksPage {
	WebDriver driver;
	Properties properties;

	public AddTracksPage(WebDriver driver, Properties properties) {
		this.driver = driver;
		this.properties = properties;
	}

	public void clickContentMenu() throws InterruptedException {
		TracksUtil.clickElementWithWait(driver, properties.getProperty("Content_leftmenu"), 50);
		Thread.sleep(3000);
	}

	public void clickAddTracks() throws InterruptedException {
		TracksUtil.callClickEvent(properties.getProperty("Add_tracks"));
		Thread.sleep(3000);
	}

	public void enterTrackTitle() throws InterruptedException {
		TracksUtil.sendTextWithTimestamp(properties.getProperty("Title_textfield"), "Track", "auto");
		Thread.sleep(2000);
	}

	public void selectFolder(String folderName) throws InterruptedException {
		TracksUtil.callClickEvent(properties.getProperty("folder_dropdown_click1"));
		Thread.sleep(2000);
		WebElement fold_search = driver.findElement(By.xpath(properties.getProperty("folder_Search")));
		fold_search.sendKeys(folderName);
		fold_search.click();
		Thread.sleep(1000);
		TracksUtil.callClickEvent(properties.getProperty("folder_selection1"));
		Thread.sleep(2000);
	}

	public void addtags() throws InterruptedException, AWTException {

		TracksUtil.clickElementWithWait(driver, properties.getProperty("tag_plusicon"), 50);
		Thread.sleep(6000);
		TracksUtil.callClickEvent(properties.getProperty("add_tagbutton"));
		Thread.sleep(5000);
		WebElement enter = driver.findElement(By.xpath(properties.getProperty("tag_text_click")));
		enter.sendKeys(properties.getProperty("tag_name") + "_" + System.currentTimeMillis());
		enter.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		TracksUtil.callClickEvent(properties.getProperty("tag_savebutton"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("tag_select"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("tag_savebutton"));
		Thread.sleep(2000);

		TracksUtil.clickElementWithWait(driver, (properties.getProperty("clickon_add_moretags")), 30);
		Thread.sleep(1000);
		TracksUtil.sendTextEvent(properties.getProperty("clickon_search_under_add_moretags"), "test");
		Thread.sleep(1000);
		TracksUtil.callClickEvent(properties.getProperty("select_searched_tag"));
		Thread.sleep(1000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
		Thread.sleep(1000);

		TracksUtil.callClickEvent(properties.getProperty("next_button")); // click on next button
		Thread.sleep(5000);
	}

	public void addmedia_and_form() throws InterruptedException {

		TracksUtil.callClickEvent(properties.getProperty("add_media"));// click on add media
		Thread.sleep(5000);
		WebElement firstasset = driver.findElement(By.xpath(properties.getProperty("firstasset_click")));
		if (firstasset.isDisplayed()) {
			TracksUtil.callClickEvent(properties.getProperty("firstasset_click"));
			Thread.sleep(5000);
			TracksUtil.sendTextEvent(properties.getProperty("display_text"), ("Asset"));
			Thread.sleep(5000);
			TracksUtil.callClickEvent(properties.getProperty("confirm_button"));
		} else {
			TracksUtil.callClickEvent(properties.getProperty("close_popup_media"));
		}

		Thread.sleep(5000);
		// selecting first form
		TracksUtil.callClickEvent(properties.getProperty("add_forms")); // click on add forms
		Thread.sleep(5000);

		WebElement firstform = driver.findElement(By.xpath(properties.getProperty("firstform_click")));

		if (firstform.isDisplayed()) {

			Thread.sleep(2000);
			TracksUtil.callClickEvent(properties.getProperty("form_Preview"));
			Thread.sleep(2000);
			TracksUtil.callClickEvent(properties.getProperty("form_preview_close"));
			Thread.sleep(2000);
			TracksUtil.callClickEvent(properties.getProperty("firstform_click"));

		} else {
			TracksUtil.callClickEvent(properties.getProperty("close_popup_form"));
			Thread.sleep(5000);

		}

	}

	public void enterDescription(String desc) throws InterruptedException {
		driver.switchTo().frame(0);
		TracksUtil.callClickEvent(properties.getProperty("Description_field"));
		Thread.sleep(2000);
		TracksUtil.sendTextEvent(properties.getProperty("Description_field"), desc);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		TracksUtil.callClickEvent(properties.getProperty("next_button"));
		Thread.sleep(5000);
	}

	public void assetselection() throws InterruptedException {

		

		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("search_txt")); // search with mp4 in search box
		TracksUtil.sendTextEvent(properties.getProperty("search_txt"), ("jpg")); // search with mp4 in search
		Thread.sleep(3000); // box
		TracksUtil.callClickEvent(properties.getProperty("Search_click"));
		Thread.sleep(5000);
		TracksUtil.callClickEvent(properties.getProperty("first_asset_selection")); // select first asset
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("searchtxt_clear"));
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("search_txt")); // search with mp4 in search box
		TracksUtil.sendTextEvent(properties.getProperty("search_txt"), ("pdf")); // search with mp4 in search
		Thread.sleep(3000); // box
		TracksUtil.callClickEvent(properties.getProperty("Search_click"));
		Thread.sleep(5000);
		TracksUtil.callClickEvent(properties.getProperty("first_asset_selection")); // select first asset
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("searchtxt_clear"));
		Thread.sleep(3000);
		
		WebElement assettypedropdown= driver.findElement(By.xpath(properties.getProperty("selectasset_type_dropdown")));
		assettypedropdown.click();
		Thread.sleep(2000);

		
		TracksUtil.selectDropdownByValue(properties.getProperty("selectasset_type_dropdown"), "11: ppt");
		Thread.sleep(5000);
		TracksUtil.callClickEvent(properties.getProperty("first_asset_selection")); // select first asset
		Thread.sleep(3000);
		
		assettypedropdown.click();
		Thread.sleep(2000);
		TracksUtil.selectDropdownByText(properties.getProperty("selectasset_type_dropdown"), "mp4");
		Thread.sleep(5000);
		TracksUtil.callClickEvent(properties.getProperty("first_asset_selection")); // select first asset
		Thread.sleep(3000);
		
		assettypedropdown.click();
		Thread.sleep(2000);
		TracksUtil.selectDropdownByText(properties.getProperty("selectasset_type_dropdown"), "Select Asset Type");
		Thread.sleep(5000);
		
		// selecting first quiz
				TracksUtil.callClickEvent(properties.getProperty("select_quiz"));// click on select quiz
				Thread.sleep(5000);
				WebElement formsort_by = driver.findElement(By.xpath(properties.getProperty("click_form_Sortby")));
				formsort_by.click();
				Thread.sleep(2000);
				TracksUtil.selectDropdownByText(properties.getProperty("click_form_Sortby"), "Created On (DESC)");
				Thread.sleep(2000);
			
				TracksUtil.callClickEvent(properties.getProperty("Search_form"));
				Thread.sleep(2000);
				TracksUtil.sendTextEvent(properties.getProperty("Search_form"), ("quiz")); // search with quiz in search
				Thread.sleep(3000);
				
				WebElement firstquiz = driver.findElement(By.xpath(properties.getProperty("select_firstquiz_click")));

				if (firstquiz.isDisplayed()) {
					TracksUtil.callClickEvent(properties.getProperty("select_firstquiz_click"));
					Thread.sleep(2000);
					TracksUtil.callClickEvent(properties.getProperty("select_secondquiz_click"));
					Thread.sleep(2000);
					TracksUtil.callClickEvent(properties.getProperty("click_preview_form"));
					Thread.sleep(3000);

					TracksUtil.callClickEvent(properties.getProperty("close_popup_quiz1"));
					Thread.sleep(3000);

					TracksUtil.callClickEvent(properties.getProperty("close_popup_quiz"));
					Thread.sleep(3000);

				} else {

					TracksUtil.callClickEvent(properties.getProperty("close_popup_quiz"));

				}
		
		TracksUtil.callClickEvent(properties.getProperty("click_on_orderassets")); // clickon_orderassets
		Thread.sleep(3000);
		
		
		TracksUtil.callClickEvent(properties.getProperty("orderassets_preview")); 
		Thread.sleep(5000);
		
		TracksUtil.callClickEvent(properties.getProperty("orderassets_preview_close")); 
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("orderassets_remove")); 
		Thread.sleep(3000);
		
		TracksUtil.callClickEvent(properties.getProperty("clickon_followseq_toggle")); 
		Thread.sleep(3000);

		TracksUtil.callClickEvent(properties.getProperty("orderassets_Section_Close")); 
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("next_button")); // click on next button
		// logger.info("mp4 first asset selected");
		Thread.sleep(2000);
	}

	public void publishTrack() throws InterruptedException {

		TracksUtil.sendTextEvent(properties.getProperty("Search_publish"), ("automate")); // select
		// automatedPartner
		// in
		// search
		// field
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Search_publish"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		TracksUtil.callClickEvent(properties.getProperty("arrow_click_track")); // select arrow of partner
// company
		Thread.sleep(5000);
		TracksUtil.callClickEvent(properties.getProperty("partner_select_track")); // select partner
		Thread.sleep(5000);
		TracksUtil.callClickEvent(properties.getProperty("save&publish_button"));
		Thread.sleep(5000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_refresh"));
		Thread.sleep(5000);
	}

	public String getPublishConfirmationMessage() {
		return driver.findElement(By.xpath(properties.getProperty("afterpublish_success"))).getText();

	}

	// Continue implementing additional actions as needed
}
