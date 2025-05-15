package com.xamplify.automation.pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.xamplify.util.PlayBooksUtil;

public class AccessSharedPlayBooksPage {

	WebDriver driver;
	Properties properties;

	public AccessSharedPlayBooksPage(WebDriver driver, Properties properties) {
		this.driver = driver;
		this.properties = properties;
	}

	public void clickContentMenu() throws InterruptedException {
		PlayBooksUtil.clickElementWithWait(driver, properties.getProperty("Content_leftmenu"), 50);
		Thread.sleep(6000);
	}

	public void clickAccesssharedPlayBooks() throws InterruptedException {
		PlayBooksUtil.callClickEvent(properties.getProperty("accessshared_playbooks"));
		Thread.sleep(6000);
	}

	public void sortsearch_actions() throws InterruptedException {

		WebElement playbook_published_sort = driver
				.findElement(By.xpath(properties.getProperty("clickon_playbook_published_Sort")));
		playbook_published_sort.click();
		Thread.sleep(3000);

		PlayBooksUtil.selectDropdownByText(properties.getProperty("clickon_playbook_published_Sort"), "Name(Z-A)");
		Thread.sleep(2000);

		playbook_published_sort.click();
		Thread.sleep(2000);

		PlayBooksUtil.selectDropdownByText(properties.getProperty("clickon_playbook_published_Sort"), "Published On(DESC)");
		Thread.sleep(2000);

		PlayBooksUtil.sendTextEvent(properties.getProperty("clickon_accesssharedPlayBooks_search"), "playbook");
		Thread.sleep(2000);

		PlayBooksUtil.sendKeyEvent(properties.getProperty("clickon_accesssharedPlayBooks_search"), Keys.ENTER);
		Thread.sleep(2000);

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_shared_playbook_preview"));
		Thread.sleep(3000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_previewassets1_st"));
		Thread.sleep(3000);
	}

	public void viewPlayBooks() throws InterruptedException {

		try {

			WebElement view_button = driver
					.findElement(By.xpath(properties.getProperty("clickon_view_button_asset_st")));

			if (view_button.isDisplayed()) {
				System.out.println("View and Download buttons are available.");

				view_button.click();
				Thread.sleep(15000);

				PlayBooksUtil.callClickEvent(properties.getProperty("clickon_view_close_asset_st"));
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

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_previewassets2_st"));
		Thread.sleep(3000);
		viewPlayBooks();
		Thread.sleep(3000);
	}

	public void asset3view() throws InterruptedException {

		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_previewassets3_st"));
		Thread.sleep(3000);
		viewPlayBooks();
		Thread.sleep(3000);
	}

//	public void asset4view() throws InterruptedException {
//
//		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_previewassets4_st"));
//		Thread.sleep(3000);
//		PlayBooksUtil.callClickEvent(properties.getProperty("choosen_answer"));
//		Thread.sleep(3000);
//		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_submit"));
//		Thread.sleep(3000);
//		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_view_close_asset_st"));
//		Thread.sleep(3000);
//		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_sharedplaybook_navigation"));
//		Thread.sleep(3000);
//	
//	}

	public void viewtypes_accesssharedPlayBooks() throws InterruptedException {

		
	
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_sharedplaybook_navigation"));
		Thread.sleep(3000);
		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_playbook_views_Ast"));
		Thread.sleep(4000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_gridview_PlayBooks_Ast"));
		Thread.sleep(4000);
		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_playbook_views_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_foldergridview_PlayBooks_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_folder_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_view_folder_PlayBooks_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_goback_arrow_fv_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_playbook_views_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_flv_PlayBooks_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_foldercreateddropdown_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.selectDropdownByText(properties.getProperty("clickon_foldercreateddropdown_Ast"), "Name(Z-A)");
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_folderdropdown_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.selectDropdownByText(properties.getProperty("clickon_folderdropdown_Ast"), "Search In Folder");
		Thread.sleep(2000);
		PlayBooksUtil.sendTextEvent(properties.getProperty("clickon_search_folder_Ast"), "default");
		Thread.sleep(2000);
		PlayBooksUtil.sendKeyEvent(properties.getProperty("clickon_search_folder_Ast"), Keys.ENTER);
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_goback_arrow_fv_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_folder_listview_arrow_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("hoveron_playbook_views_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("clickon_listview_PlayBooks_Ast"));
		Thread.sleep(2000);
		PlayBooksUtil.callClickEvent(properties.getProperty("goto_home"));
		Thread.sleep(2000);

	}
}
