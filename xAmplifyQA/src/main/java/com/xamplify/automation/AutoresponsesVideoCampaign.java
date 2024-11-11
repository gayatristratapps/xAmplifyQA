package com.xamplify.automation;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AutoresponsesVideoCampaign {
	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Campaign.properties");

final Logger logger = LogManager.getLogger(AutoresponsesVideoCampaign.class);	
	@Test
	
	
	public void autoResponsesVideo() throws InterruptedException {
		
		//Website Auto responses//
		// auto response 1 //
		driver.findElement(By.xpath(properties.getProperty("vautoresponse_website1"))).click(); // auto responses
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(300,document.body.scrollHeight)");

		Thread.sleep(4000);
		WebElement ele_drpdwn = driver.findElement(By.xpath(properties.getProperty("video_arws_whentosendemail_dropdown"))); // select dropdown
																											
		// rdrpdwn.click();
		Select when_to_send_email = new Select(ele_drpdwn);
		Thread.sleep(5000);
		when_to_send_email.selectByValue("20");
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("video_arws_subject"))).sendKeys("send immediately after clicked"); // select "send immediatley after clicked"
		Thread.sleep(5000);
		
		
		WebElement avaiable_dropdown1 = driver.findElement(By.xpath(properties.getProperty("select_video_arws_avaiable_url"))); // select drop down
		avaiable_dropdown1.click();
		Thread.sleep(2000);
		Select url = new Select(avaiable_dropdown1);
		Thread.sleep(5000);
		url.selectByVisibleText("https://www.facebook.com/"); // select facebook link
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_arws_frame1"))));
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement()
				.sendKeys("Hello:send immediately after clicked,thanku for clicking immediately");

		driver.switchTo().defaultContent();
		Thread.sleep(6000);

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		Thread.sleep(5000);
		
		
		// auto response 2 //

		driver.findElement(By.xpath(properties.getProperty("vautoresponse_website2"))).click(); // auto response
		Thread.sleep(5000);

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollTo(300,document.body.scrollHeight)");
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("video_arws_subject2"))).sendKeys("send if not clicked"); // subject
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_arws_frame2")))); // switch
																										// to
																										// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello,send if not clicked:please click the mail");

		driver.switchTo().defaultContent();

		JavascriptExecutor js21 = (JavascriptExecutor) driver;
		js21.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		Thread.sleep(5000);
		
		
		// auto response 3 //

		driver.findElement(By.xpath(properties.getProperty("vautoresponse_website3"))).click(); // auto response
		Thread.sleep(5000);
		JavascriptExecutor js31 = (JavascriptExecutor) driver;
		js31.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		
		
		WebElement ele_drpdwn4 = driver.findElement(By.xpath(properties.getProperty("video_arws_whentosendemail_dropdown3"))); // drop down
		// ele_drpdwn4.click(); // click

		Select when_to_send_email2 = new Select(ele_drpdwn4); // select drop down
		Thread.sleep(5000);
		when_to_send_email2.selectByValue("21");
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("video_arws_subject3"))).sendKeys("schedule"); // subject
		Thread.sleep(5000);
		
//		driver.findElement(By.xpath(properties.getProperty("video_xdays"))).sendKeys("1"); // select x days
//		Thread.sleep(5000);
//		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_ar_frame3")))); // switch
																										// to
																										// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:campgin is scheduled for  day...");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		WebElement avble_drpdwn = driver.findElement(By.xpath(properties.getProperty("select_video_arws_avaiable_url3"))); // select
																														// drop
																														// down
		avble_drpdwn.click();
		Select url3 = new Select(avble_drpdwn);
		Thread.sleep(5000);
		url3.selectByVisibleText("https://instagram.com/");// url.selectByValue(2);
		Thread.sleep(7000);

		JavascriptExecutor js211 = (JavascriptExecutor) driver;
		js211.executeScript("window.scrollTo(document.body.scrollHeight,0)");

		Thread.sleep(5000);
		
		//Email Auto Responses//
		// Auto Response 1//
		driver.findElement(By.xpath(properties.getProperty("vautoresponse_email1"))).click(); // autoresponse
		Thread.sleep(5000);

		WebElement rdrpdwn = driver.findElement(By.xpath(properties.getProperty("video_ar_drop_down_click"))); // select drop
																											// down
		// rdrpdwn.click();

		Select reason = new Select(rdrpdwn);
		Thread.sleep(5000);
		reason.selectByValue("13");
		Thread.sleep(7000);
//		driver.findElement(By.xpath(properties.getProperty("v_are_xdays1"))).sendKeys("1"); // select x days
//		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("v_aresubject1"))).sendKeys("email is opened"); // subject
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_are_frame4")))); // switch
																										// to
																										// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:email is opened,thanku for opening email");

		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		// Auto Response 2//
		driver.findElement(By.xpath(properties.getProperty("vautoresponse_email2"))).click(); // autoresponse
		Thread.sleep(5000);

		JavascriptExecutor js13 = (JavascriptExecutor) driver;
		js13.executeScript("window.scrollTo(300,document.body.scrollHeight)");

		Thread.sleep(5000);
//		driver.findElement(By.xpath(properties.getProperty("v_are_xdays2"))).sendKeys("1"); // select x days
//		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("v_are_subject2"))).sendKeys("email not opened---)"); // subject
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_are_frame5")))); // switch the
																										// frame

		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:email is not opened;please open the email");

		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		JavascriptExecutor js14 = (JavascriptExecutor) driver;
		js14.executeScript("window.scrollTo(document.body.scrollHeight,300)");

		driver.findElement(By.xpath(properties.getProperty("vautoresponse_email3"))).click(); // auto response
		Thread.sleep(5000);

		JavascriptExecutor js15 = (JavascriptExecutor) driver;
		js15.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		// Auto Response 3//
		WebElement rdrpdwn2 = driver.findElement(By.xpath(properties.getProperty("video_ar_drop_down_click3"))); // select
																											// drop
																											// down
		// rdrpdwn.click();
		Select reason1 = new Select(rdrpdwn2);
		Thread.sleep(5000);
		reason1.selectByValue("16");
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("v_are_subject3")))
				.sendKeys("send immeditely after email is opnd"); // subject
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_are_frame6")))); // switch the
																										// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:send immeditely after email is opnd,thnku for opening");
		driver.switchTo().defaultContent();

		JavascriptExecutor js16 = (JavascriptExecutor) driver;
		js16.executeScript("window.scrollTo(document.body.scrollHeight,0)");

		driver.findElement(By.xpath(properties.getProperty("vautoresponse_email4"))).click(); // auto response
		Thread.sleep(5000);

		JavascriptExecutor js17 = (JavascriptExecutor) driver;
		js17.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Thread.sleep(4000);
		
		// Auto Response 4//
		WebElement rdrpdwn11 = driver.findElement(By.xpath(properties.getProperty("video_ar_drop_down_click4"))); // select
																											// drop
																											// down
		// rdrpdwn.click();
		Select reason11 = new Select(rdrpdwn11);
		Thread.sleep(3000);
		reason11.selectByValue("1");
		Thread.sleep(4000);

		driver.findElement(By.xpath(properties.getProperty("v_are_subject4"))).sendKeys(" video is played");
//		driver.findElement(By.xpath(properties.getProperty("v_are_xdays4"))).sendKeys("1"); // subject
//		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("v_are_choosetemp"))).click(); // choosing the template

		Thread.sleep(6000);
		WebElement e_arv_templatesearch = driver
				.findElement(By.xpath(properties.getProperty("v_are_template_searchdata")));
		e_arv_templatesearch.sendKeys("basic");
		e_arv_templatesearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("v_are_selecttemplate"))).click();
		Thread.sleep(5000);
logger.info("Auto responses selected");



		JavascriptExecutor js18 = (JavascriptExecutor) driver;
		js18.executeScript("window.scrollTo(document.body.scrollHeight,300)");
		
		driver.findElement(By.xpath(properties.getProperty("vautoresponse_email5"))).click(); // auto response
		Thread.sleep(5000);
		
		JavascriptExecutor js19 = (JavascriptExecutor) driver;
		js19.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		// Auto Response 5//
		WebElement rdrpdwn5 = driver.findElement(By.xpath(properties.getProperty("video_ar_drop_down_click5"))); // select
																											// drop
																											// down
		// rdrpdwn.click();
		Select reason5 = new Select(rdrpdwn5);
		Thread.sleep(5000);
		reason5.selectByValue("33");
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(properties.getProperty("v_are_subject5")))
				.sendKeys("Send follow-up email"); // subject
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_are_frame7")))); // switch the
																										// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:Send follow-up email");
		driver.switchTo().defaultContent();
		
		JavascriptExecutor js20 = (JavascriptExecutor) driver;
		js20.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		Thread.sleep(4000);

		// Auto Response 6//
		driver.findElement(By.xpath(properties.getProperty("vautoresponse_email6"))).click(); // auto response
		Thread.sleep(5000);
		
		JavascriptExecutor js22 = (JavascriptExecutor) driver;
		js22.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement rdrpdwn6 = driver.findElement(By.xpath(properties.getProperty("video_ar_drop_down_click6"))); // select
																											// drop
																											// down
		// rdrpdwn.click();
		Select reason6 = new Select(rdrpdwn6);
		Thread.sleep(5000);
		reason6.selectByValue("17");
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(properties.getProperty("v_are_subject6")))
				.sendKeys("Send immediately after video is played"); // subject
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_are_frame8")))); // switch the
																										// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:Send immediately after video is played");
		driver.switchTo().defaultContent();
		
		JavascriptExecutor js23 = (JavascriptExecutor) driver;
		js23.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		Thread.sleep(4000);

	
		// Auto Response 7//
		
		driver.findElement(By.xpath(properties.getProperty("vautoresponse_email7"))).click(); // auto response
		Thread.sleep(5000);
		
		JavascriptExecutor js24 = (JavascriptExecutor) driver;
		js24.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement rdrpdwn7 = driver.findElement(By.xpath(properties.getProperty("video_ar_drop_down_click7"))); // select
																											// drop
																											// down
		// rdrpdwn.click();
		Select reason8 = new Select(rdrpdwn7);
		Thread.sleep(5000);
		reason8.selectByValue("18");
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(properties.getProperty("v_are_subject7")))
				.sendKeys("Video is not played"); // subject
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_are_frame9")))); // switch the
																										// frame
		driver.findElement(By.xpath("html/body")).click();
		driver.switchTo().activeElement().sendKeys("Hello:Video is not played");
		driver.switchTo().defaultContent();
		
		JavascriptExecutor js25 = (JavascriptExecutor) driver;
		js25.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		Thread.sleep(4000);
		
		// Auto Response 8//
		
				driver.findElement(By.xpath(properties.getProperty("vautoresponse_email8"))).click(); // auto response
				Thread.sleep(5000);
				
				JavascriptExecutor js26 = (JavascriptExecutor) driver;
				js26.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				WebElement rdrpdwn8= driver.findElement(By.xpath(properties.getProperty("video_ar_drop_down_click8"))); // select
																													// drop
																													// down
				// rdrpdwn.click();
				Select reason9 = new Select(rdrpdwn8);
				Thread.sleep(5000);
				reason9.selectByValue("23");
				Thread.sleep(8000);
				
				driver.findElement(By.xpath(properties.getProperty("v_are_subject8")))
						.sendKeys("Video is not redistributed"); // subject
				Thread.sleep(5000);
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("v_are_frame10")))); // switch the
																												// frame
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello:Video is not redistributed");
				driver.switchTo().defaultContent();
				
				JavascriptExecutor js27 = (JavascriptExecutor) driver;
				js27.executeScript("window.scrollTo(document.body.scrollHeight,0)");
				
				Thread.sleep(4000);
		
	
logger.info("Auto responses selected");
	}
	
}