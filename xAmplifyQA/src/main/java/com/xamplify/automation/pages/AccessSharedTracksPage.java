
package com.xamplify.automation.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.xamplify.util.TracksUtil;

public class AccessSharedTracksPage {

	WebDriver driver;
	Properties properties;

	public AccessSharedTracksPage(WebDriver driver, Properties properties) {
		this.driver = driver;
		this.properties = properties;
	}

	public void clickContentMenu() throws InterruptedException {
		TracksUtil.clickElementWithWait(driver, properties.getProperty("Content_leftmenu"), 50);
		Thread.sleep(6000);
	}

	public void clickAccesssharedTracks() throws InterruptedException {
		TracksUtil.callClickEvent(properties.getProperty("accessshared_tracks"));
		Thread.sleep(6000);
	}

	public void sortsearch_actions() throws InterruptedException {

		WebElement track_published_sort = driver
				.findElement(By.xpath(properties.getProperty("clickon_track_published_Sort")));
		track_published_sort.click();
		Thread.sleep(3000);

		TracksUtil.selectDropdownByText(properties.getProperty("clickon_track_published_Sort"), "Name(Z-A)");
		Thread.sleep(2000);

		track_published_sort.click();
		Thread.sleep(2000);

		TracksUtil.selectDropdownByText(properties.getProperty("clickon_track_published_Sort"), "Published On(DESC)");
		Thread.sleep(2000);

		TracksUtil.sendTextEvent(properties.getProperty("clickon_accesssharedtracks_search"), "Track");
		Thread.sleep(2000);

		TracksUtil.sendKeyEvent(properties.getProperty("clickon_accesssharedtracks_search"), Keys.ENTER);
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_shared_track_preview"));
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_previewassets1_st"));
		Thread.sleep(3000);
	}

	public void viewTracks() throws InterruptedException {

		try {

			WebElement view_button = driver
					.findElement(By.xpath(properties.getProperty("clickon_view_button_asset_st")));

			if (view_button.isDisplayed()) {
				System.out.println("View and Download buttons are available.");

				view_button.click();
				Thread.sleep(15000);

				TracksUtil.callClickEvent(properties.getProperty("clickon_view_close_asset_st"));
				Thread.sleep(5000);
				WebElement download_button = driver
						.findElement(By.xpath(properties.getProperty("clickon_download_button_asset_st")));
				download_button.click();
				Thread.sleep(3000);
			}

		}

		catch (NoSuchElementException e) {
			System.out.println("View and/or Download buttons not found, clicking on Cross icon.");

			// Click on Cross icon
			WebElement crossIcon = driver.findElement(By.xpath(properties.getProperty("clickon_cross_view_assets")));

			crossIcon.click();

		}

	}

	public void asset2view() throws InterruptedException {

		TracksUtil.callClickEvent(properties.getProperty("clickon_previewassets2_st"));
		Thread.sleep(3000);
		viewTracks();
		Thread.sleep(3000);
	}

	public void asset3view() throws InterruptedException {

		TracksUtil.callClickEvent(properties.getProperty("clickon_previewassets3_st"));
		Thread.sleep(3000);
		viewTracks();
		Thread.sleep(3000);
	}

	public void asset4view() throws InterruptedException {

		TracksUtil.callClickEvent(properties.getProperty("clickon_previewassets4_st"));
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("choosen_answer"));
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_submit"));
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_view_close_asset_st"));
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_sharedtrack_navigation"));
		Thread.sleep(3000);
	
	}

	public void viewtypes_accesssharedtracks() throws InterruptedException {

		TracksUtil.callClickEvent(properties.getProperty("hoveron_track_views_Ast"));
		Thread.sleep(4000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_gridview_tracks_Ast"));
		Thread.sleep(4000);
		TracksUtil.callClickEvent(properties.getProperty("hoveron_track_views_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_foldergridview_tracks_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("hoveron_folder_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_view_folder_tracks_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_goback_arrow_fv_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("hoveron_track_views_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_flv_tracks_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_foldercreateddropdown_Ast"));
		Thread.sleep(2000);
		TracksUtil.selectDropdownByText(properties.getProperty("clickon_foldercreateddropdown_Ast"), "Name(Z-A)");
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_folderdropdown_Ast"));
		Thread.sleep(2000);
		TracksUtil.selectDropdownByText(properties.getProperty("clickon_folderdropdown_Ast"), "Search In Folder");
		Thread.sleep(2000);
		TracksUtil.sendTextEvent(properties.getProperty("clickon_search_folder_Ast"), "default");
		Thread.sleep(2000);
		TracksUtil.sendKeyEvent(properties.getProperty("clickon_search_folder_Ast"), Keys.ENTER);
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_goback_arrow_fv_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_folder_listview_arrow_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("hoveron_track_views_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_listview_tracks_Ast"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("goto_home"));
		Thread.sleep(2000);

	}
}
