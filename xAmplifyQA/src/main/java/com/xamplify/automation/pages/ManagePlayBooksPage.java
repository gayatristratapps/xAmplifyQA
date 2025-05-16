
package com.xamplify.automation.pages;

import java.awt.AWTException;
import java.util.Calendar;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.xamplify.util.PlayBooksUtil;
public class ManagePlayBooksPage {

	WebDriver driver;
	Properties properties;

	public ManagePlayBooksPage(WebDriver driver, Properties properties) {
		this.driver = driver;
		this.properties = properties;
	}

	public void clickContentMenu() throws InterruptedException {
		PlayBooksUtil.clickElementWithWait(driver, properties.getProperty("Content_leftmenu"), 50);
		Thread.sleep(3000);
	}

	public void clickManagePlayBooks() throws InterruptedException {
		PlayBooksUtil.callClickEvent(properties.getProperty("manage_PlayBooks"));
		Thread.sleep(3000);
	}

	public void editactions() throws InterruptedException, AWTException {

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_edit_playbook"));
		Thread.sleep(5000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_enddate_clear"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_playbookenddate"));
		Thread.sleep(4000);

		PlayBooksUtil.callClickEvent(properties.getProperty("select_playbook_enddate"));
		Thread.sleep(4000);

		Calendar calendar = Calendar.getInstance();
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		System.out.println("Selected Time - Hours: " + hours);
		System.out.println("Selected Time - Minutes: " + minutes);

		if (hours < 12)

		{
			PlayBooksUtil.sendTextEvent(properties.getProperty("clickon_playbook_ed_hour"), "1");
			Thread.sleep(2000);
			PlayBooksUtil.sendTextEvent(properties.getProperty("clickon_playbook_ed_min"), "11");
			Thread.sleep(5000);
		} else {
			PlayBooksUtil.sendTextEvent(properties.getProperty("clickon_playbook_ed_hour"), "11");
			Thread.sleep(2000);
			PlayBooksUtil.sendTextEvent(properties.getProperty("clickon_playbook_ed_min"), "59");
			Thread.sleep(5000);
		}
		
		  Actions actions = new Actions(driver);
	        
	        // Scroll up using PAGE_UP key
	        actions.sendKeys(Keys.PAGE_UP).perform();
////		PlayBooksUtil.scrollup();
		Thread.sleep(3000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_PlayBooks_assets_section")); // click on assets section
		Thread.sleep(3000);

		PlayBooksUtil.callClickEvent(properties.getProperty("select_add_on_asset")); // Add extra asset
		Thread.sleep(3000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_share_section")); // click on share
		Thread.sleep(3000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_update_playbook")); // click on update
		Thread.sleep(3000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_refresh"));
		Thread.sleep(5000);

	}

	public void unpublishandpublish_playbook() throws InterruptedException {

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_unpublish_icon"));
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("choose_otherradio_button"));
		Thread.sleep(3000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_unpublish_button"));
		Thread.sleep(3000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_refresh"));
		Thread.sleep(4000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_publish_icon"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_publish_yes"));
		Thread.sleep(2000);
	}

	public void preview_playbook() throws InterruptedException {

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_preview_playbook"));
		Thread.sleep(2000);
//		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_add_playbook_button"));
//		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_preview_playbook"));
		Thread.sleep(7000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_asset_previewclose_playbook"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_playbook_navigation"));
		Thread.sleep(2000);

	}

	public void playbook_analytics() throws InterruptedException {

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_playbook_analytics"));
		Thread.sleep(7000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_company_playbook_analytics"));
		Thread.sleep(5000);

		PlayBooksUtil.sendTextEvent(properties.getProperty("clickon_analytics_company_search"), "Automate");
		Thread.sleep(2000);

		// PlayBooksUtil.clickEvent("clickon_analytics_company_search", driver);
		PlayBooksUtil.sendKeyEvent(properties.getProperty("clickon_analytics_company_search"), Keys.ENTER);
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_partner_playbook_analytics"));
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_partner_playbook_analytics_popupclose"));
		Thread.sleep(5000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_partner_playbook_analytics_close"));
		Thread.sleep(5000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_playbook_navigation"));
		Thread.sleep(2000);

	}

	public void sortby_search_delete_playbook() throws InterruptedException {

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_PlayBooks_sortby"));
		Thread.sleep(2000);

		PlayBooksUtil.selectDropdownByValue(properties.getProperty("clickon_PlayBooks_sortby"), "1: Object");
		Thread.sleep(2000);
		PlayBooksUtil.sendTextEvent(properties.getProperty("clickon_search_playbook"), "playbook");
		Thread.sleep(2000);

		PlayBooksUtil.sendKeyEvent(properties.getProperty("clickon_search_playbook"), Keys.ENTER);
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("click_on_delete+playbook"));
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_yes_del_playbook"));
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("click_search_clear"));
		Thread.sleep(2000);
	}

	public void playbookviews() throws InterruptedException, AWTException {

		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_playbook_views"));
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_gridview_PlayBooks"));
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_Asset"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_grid_edit_playbook"));
		Thread.sleep(5000);

		PlayBooksUtil.callClickEvent(properties.getProperty("Thumbnail")); // click on thumbnail icon
		Thread.sleep(5000);

		WebElement uploadimg = driver.findElement(By.xpath(properties.getProperty("clickon_upload")));
		uploadimg.click(); // click on Browse
		Thread.sleep(5000);
		PlayBooksUtil.imageupload();

		Thread.sleep(5000);

		PlayBooksUtil.callClickEvent(properties.getProperty("Savechanges"));
		Thread.sleep(4000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_share_section")); // click on share
		Thread.sleep(4000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_update_playbook")); // click on update
		Thread.sleep(5000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_refresh"));
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_playbook_views"));
		Thread.sleep(4000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_foldergridview_PlayBooks"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_folder"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_view_folder_PlayBooks"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_goback_arrow_fv"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_playbook_views"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_flv_PlayBooks"));
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_foldercreateddropdown"));
		Thread.sleep(2000);
		PlayBooksUtil.selectDropdownByText(properties.getProperty("clickon_foldercreateddropdown"), "Name(Z-A)");
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_folderdropdown"));
		Thread.sleep(2000);
		PlayBooksUtil.selectDropdownByText(properties.getProperty("clickon_folderdropdown"), "Search In Folder");
		Thread.sleep(2000);

		PlayBooksUtil.sendTextEvent(properties.getProperty("clickon_search_folder"), "default");
		Thread.sleep(2000);

		PlayBooksUtil.sendKeyEvent(properties.getProperty("clickon_search_folder"), Keys.ENTER);
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_goback_arrow_fv"));
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_folder_listview_arrow"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_playbook_views"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_listview_PlayBooks"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("goto_home"));
		Thread.sleep(2000);

	}

}
