package com.xamplify.automation.pages;
import java.awt.AWTException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.xamplify.util.XamplifyUtil;

	public class AddTracksPage {
	    WebDriver driver;
	    Properties properties;

	    public AddTracksPage(WebDriver driver, Properties properties) {
	        this.driver = driver;
	        this.properties = properties;
	    }

	    public void clickContentMenu() throws InterruptedException {
	        XamplifyUtil.clickElementWithWait(driver, properties.getProperty("Content_leftmenu"), 50);
	        Thread.sleep(3000);
	    }

	    public void clickAddTracks() throws InterruptedException {
	        XamplifyUtil.callClickEvent(properties.getProperty("Add_tracks"));
	        Thread.sleep(3000);
	    }

	    public void enterTrackTitle() throws InterruptedException {
	        XamplifyUtil.sendTextWithTimestamp(properties.getProperty("Title_textfield"), "Track", "auto");
	        Thread.sleep(2000);
	    }

	    public void selectFolder(String folderName) throws InterruptedException {
	        XamplifyUtil.callClickEvent(properties.getProperty("folder_dropdown_click1"));
	        Thread.sleep(2000);
	        WebElement fold_search = driver.findElement(By.xpath(properties.getProperty("folder_Search")));
	        fold_search.sendKeys(folderName);
	        fold_search.click();
	        Thread.sleep(1000);
	        XamplifyUtil.callClickEvent(properties.getProperty("folder_selection1"));
	        Thread.sleep(2000);
	    }
	    

	    // Add more methods for each section: tag handling, media selection, form selection, quiz selection etc.
	    
	    public void addtags() throws InterruptedException, AWTException {
	    	
	    	
	    	XamplifyUtil.clickElementWithWait(driver, properties.getProperty("tag_plusicon"), 50);
			// XamplifyUtil.callClickEvent(properties.getProperty("tag_plusicon"));
			Thread.sleep(6000);
			XamplifyUtil.callClickEvent(properties.getProperty("add_tagbutton"));
			Thread.sleep(5000);
			//XamplifyUtil.callClickEvent(properties.getProperty("tag_text_click"));
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
			//XamplifyUtil.excelDownload();
			XamplifyUtil.callClickEvent(properties.getProperty("select_searched_tag"));
			Thread.sleep(1000);
			XamplifyUtil.callClickEvent(properties.getProperty("clickon_update_under_add_motetags"));
			Thread.sleep(1000);

			XamplifyUtil.callClickEvent(properties.getProperty("next_button")); // click on next button
			Thread.sleep(5000);
	    }
	    
	    
	    public void addmedia_and_form() throws InterruptedException {
	    	

			XamplifyUtil.callClickEvent(properties.getProperty("add_media"));// click on add media
			Thread.sleep(5000);
			WebElement firstasset = driver.findElement(By.xpath(properties.getProperty("firstasset_click")));
			if (firstasset.isDisplayed()) {
				XamplifyUtil.callClickEvent(properties.getProperty("firstasset_click"));
				Thread.sleep(5000);
				XamplifyUtil.sendTextEvent(properties.getProperty("display_text"),("Asset"));
				Thread.sleep(5000);
				XamplifyUtil.callClickEvent(properties.getProperty("confirm_button"));
			} else {
				XamplifyUtil.callClickEvent(properties.getProperty("close_popup_media"));
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
				//logger.info("form is selected");

				
			} else {
				XamplifyUtil.callClickEvent(properties.getProperty("close_popup_form"));
				//logger.info("no form selected");
				Thread.sleep(5000);

			}

	    }

	    public void enterDescription(String desc) throws InterruptedException {
	        driver.switchTo().frame(0);
	        XamplifyUtil.callClickEvent(properties.getProperty("Description_field"));
	        Thread.sleep(2000);
	        XamplifyUtil.sendTextEvent(properties.getProperty("Description_field"), desc);
	        Thread.sleep(2000);
	        driver.switchTo().defaultContent();
	    	XamplifyUtil.callClickEvent(properties.getProperty("next_button"));
			Thread.sleep(5000);
	    }
	    
	    
	    public void assetselection() throws InterruptedException {
	    	
	    	// selecting first quiz
			XamplifyUtil.callClickEvent(properties.getProperty("select_quiz"));// click on select quiz
			Thread.sleep(5000);
			WebElement firstquiz = driver.findElement(By.xpath(properties.getProperty("firstquiz_click")));

			if (firstquiz.isDisplayed()) {
				XamplifyUtil.callClickEvent(properties.getProperty("firstquiz_click"));
				Thread.sleep(4000);	
				XamplifyUtil.callClickEvent(properties.getProperty("click_preview_form"));
				Thread.sleep(3000);

				XamplifyUtil.callClickEvent(properties.getProperty("close_popup_quiz"));
				Thread.sleep(3000);
				
				XamplifyUtil.callClickEvent(properties.getProperty("close_popup_quiz"));
			
			} else {
				XamplifyUtil.callClickEvent(properties.getProperty("close_popup_quiz"));
				

			}

			Thread.sleep(10000);
			XamplifyUtil.callClickEvent(properties.getProperty("search_txt")); // search with mp4 in search box
			XamplifyUtil.sendTextEvent(properties.getProperty("search_txt"),("mp4")); // search with mp4 in search
			Thread.sleep(3000);																					// box
			XamplifyUtil.callClickEvent(properties.getProperty("Search_click"));
			Thread.sleep(5000);
			XamplifyUtil.callClickEvent(properties.getProperty("first_asset_selection")); // select first asset
			Thread.sleep(3000);
			XamplifyUtil.callClickEvent(properties.getProperty("searchtxt_clear"));
			Thread.sleep(5000);
			
			XamplifyUtil.callClickEvent(properties.getProperty("search_txt")); // search with mp4 in search box
			XamplifyUtil.sendTextEvent(properties.getProperty("search_txt"),("pdf")); // search with mp4 in search
			Thread.sleep(3000);																					// box
			XamplifyUtil.callClickEvent(properties.getProperty("Search_click"));
			Thread.sleep(5000);
			XamplifyUtil.callClickEvent(properties.getProperty("first_asset_selection")); // select first asset
			Thread.sleep(3000);
			XamplifyUtil.callClickEvent(properties.getProperty("searchtxt_clear"));
			Thread.sleep(5000);
			XamplifyUtil.callClickEvent(properties.getProperty("next_button")); // click on next button
			//logger.info("mp4 first asset selected");
			Thread.sleep(5000);
	    }

	    public void publishTrack() throws InterruptedException {
	        XamplifyUtil.callClickEvent(properties.getProperty("save&publish_button"));
	        Thread.sleep(5000);
	        XamplifyUtil.callClickEvent(properties.getProperty("next_button"));
			Thread.sleep(5000);
	    }

	    public String getPublishConfirmationMessage() {
	        return driver.findElement(By.xpath(properties.getProperty("afterpublish_success"))).getText();
	        
	    }

	    // Continue implementing additional actions as needed
	}

