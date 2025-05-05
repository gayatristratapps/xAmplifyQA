
package com.xamplify.automation.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	public void editactions() throws InterruptedException, AWTException {

		TracksUtil.callClickEvent(properties.getProperty("clickon_edit_track"));
		Thread.sleep(5000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_enddate_clear"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_trackenddate"));
		Thread.sleep(4000);

		TracksUtil.callClickEvent(properties.getProperty("select_track_enddate"));
		Thread.sleep(4000);

		Calendar calendar = Calendar.getInstance();
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		System.out.println("Selected Time - Hours: " + hours);
		System.out.println("Selected Time - Minutes: " + minutes);

		if (hours < 12)

		{
			TracksUtil.sendTextEvent(properties.getProperty("clickon_track_ed_hour"), "1");
			Thread.sleep(2000);
			TracksUtil.sendTextEvent(properties.getProperty("clickon_track_ed_min"), "11");
			Thread.sleep(2000);
		} else {
			TracksUtil.sendTextEvent(properties.getProperty("clickon_track_ed_hour"), "11");
			Thread.sleep(2000);
			TracksUtil.sendTextEvent(properties.getProperty("clickon_track_ed_min"), "59");
			Thread.sleep(2000);
		}

		TracksUtil.callClickEvent(properties.getProperty("clickon_tracks_assets_section")); // click on assets section
		Thread.sleep(3000);

		TracksUtil.callClickEvent(properties.getProperty("select_add_on_asset")); // Add extra asset
		Thread.sleep(3000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_share_section")); // click on share
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_update_track")); // click on update
		Thread.sleep(3000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_refresh"));
		Thread.sleep(5000);

	}

	public void unpublishandpublish_track() throws InterruptedException {

		TracksUtil.callClickEvent(properties.getProperty("clickon_unpublish_icon"));
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("choose_otherradio_button"));
		Thread.sleep(3000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_unpublish_button"));
		Thread.sleep(3000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_refresh"));
		Thread.sleep(1000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_publish_icon"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_publish_yes"));
		Thread.sleep(2000);
	}

	public void preview_track() throws InterruptedException {

		TracksUtil.callClickEvent(properties.getProperty("clickon_preview_track"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_add_playbook_button"));
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_preview_track"));
		Thread.sleep(7000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_asset_previewclose_Track"));
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_track_navigation"));
		Thread.sleep(2000);

	}

	public void track_analytics() throws InterruptedException {

		TracksUtil.callClickEvent(properties.getProperty("clickon_track_analytics"));
		Thread.sleep(7000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_company_track_analytics"));
		Thread.sleep(5000);

		TracksUtil.sendTextEvent(properties.getProperty("clickon_analytics_company_search"), "Automate");
		Thread.sleep(2000);

		// TracksUtil.clickEvent("clickon_analytics_company_search", driver);
		TracksUtil.sendKeyEvent(properties.getProperty("clickon_analytics_company_search"), Keys.ENTER);
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_partner_track_analytics"));
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_partner_track_analytics_popupclose"));
		Thread.sleep(5000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_partner_track_analytics_close"));
		Thread.sleep(5000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_track_navigation"));
		Thread.sleep(2000);

	}

	public void sortby_search_delete_track() throws InterruptedException {

		TracksUtil.callClickEvent(properties.getProperty("clickon_tracks_sortby"));
		Thread.sleep(2000);

		TracksUtil.selectDropdownByValue(properties.getProperty("clickon_tracks_sortby"), "1: Object");
		Thread.sleep(2000);
		TracksUtil.sendTextEvent(properties.getProperty("clickon_search_track"), "track");
		Thread.sleep(2000);

		TracksUtil.sendKeyEvent(properties.getProperty("clickon_search_track"), Keys.ENTER);
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("click_on_delete+track"));
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_yes_del_track"));
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("click_search_clear"));
		Thread.sleep(2000);
	}

	public void trackviews() throws InterruptedException, AWTException {

		TracksUtil.callClickEvent(properties.getProperty("hoveron_track_views"));
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_gridview_tracks"));
		Thread.sleep(2000);

		TracksUtil.callClickEvent(properties.getProperty("hoveron_Asset"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_grid_edit_track"));
		Thread.sleep(5000);

		TracksUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(5000);

		WebElement uploadimg = driver.findElement(By.xpath(properties.getProperty("clickon_upload")));
		uploadimg.click(); // click on Browse
		Thread.sleep(5000);
		TracksUtil.imageupload();

		Thread.sleep(5000);

		TracksUtil.callClickEvent(properties.getProperty("Savechanges"));
		Thread.sleep(3000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_share_section")); // click on share
		Thread.sleep(4000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_update_track")); // click on update
		Thread.sleep(3000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_refresh"));
		Thread.sleep(2000);
		
		TracksUtil.callClickEvent(properties.getProperty("hoveron_track_views"));
		Thread.sleep(4000);

		TracksUtil.callClickEvent(properties.getProperty("clickon_foldergridview_tracks"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("hoveron_folder"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_view_folder_tracks"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_goback_arrow_fv"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("hoveron_track_views"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_flv_tracks"));
		Thread.sleep(2000);
		
		TracksUtil.callClickEvent(properties.getProperty("clickon_foldercreateddropdown"));
		Thread.sleep(2000);
		TracksUtil.selectDropdownByText(properties.getProperty("clickon_foldercreateddropdown"), "Name(Z-A)");
		Thread.sleep(2000);
		
		TracksUtil.callClickEvent(properties.getProperty("clickon_folderdropdown"));
		Thread.sleep(2000);
		TracksUtil.selectDropdownByText(properties.getProperty("clickon_folderdropdown"), "Search In Folder");
		Thread.sleep(2000);
		
		TracksUtil.sendTextEvent(properties.getProperty("clickon_search_folder"), "default");
		Thread.sleep(2000);

		TracksUtil.sendKeyEvent(properties.getProperty("clickon_search_folder"), Keys.ENTER);
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_goback_arrow_fv"));
		Thread.sleep(2000);
		
		TracksUtil.callClickEvent(properties.getProperty("clickon_folder_listview_arrow"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("hoveron_track_views"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("clickon_listview_tracks"));
		Thread.sleep(2000);
		TracksUtil.callClickEvent(properties.getProperty("goto_home"));
		Thread.sleep(2000);

	}

}
