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
	import org.testng.annotations.Test;
	
	public class AutoResponsesEventCampaign {
	
		WebDriver driver = Instance.getInstance();
	
		Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\EventCampaign.properties");
	
	final Logger logger = LogManager.getLogger(AutoResponseEmailcampaign.class);
		@Test
	
		public void autoResponsesEvent() throws InterruptedException {
			
		
		//Email Autoresponses
				//Auto response1
				
				driver.findElement(By.xpath(properties.getProperty("eveautoresponse_email1"))).click(); // autoresponse
				Thread.sleep(5000);
	
				WebElement rdrpdwn = driver.findElement(By.xpath(properties.getProperty("event_ar_drop_down_click"))); // select drop
																													// down
				// rdrpdwn.click();
	
				Select reason = new Select(rdrpdwn);
				Thread.sleep(5000);
				reason.selectByValue("13");
				Thread.sleep(7000);
	//			driver.findElement(By.xpath(properties.getProperty("eve_are_xdays1"))).sendKeys("1"); // select x days
	//			Thread.sleep(4000);
				driver.findElement(By.xpath(properties.getProperty("eve_aresubject1"))).sendKeys("....email is opened"); // subject
				Thread.sleep(5000);
	
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("eve_are_frame1")))); // switch
																												// to
																												// frame
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello:email is opened,thanku for opening email");
	
				driver.switchTo().defaultContent();
				Thread.sleep(5000);
	
				//Auto response2
				
				driver.findElement(By.xpath(properties.getProperty("eveautoresponse_email2"))).click(); // autoresponse
				Thread.sleep(5000);
	
				JavascriptExecutor js13 = (JavascriptExecutor) driver;
				js13.executeScript("window.scrollTo(300,document.body.scrollHeight)");
	
				Thread.sleep(5000);
	//			driver.findElement(By.xpath(properties.getProperty("eve_are_xdays2"))).sendKeys("1"); // select x days
	//			Thread.sleep(4000);
	
				driver.findElement(By.xpath(properties.getProperty("eve_are_subject2"))).sendKeys("email not opened---)"); // subject
				Thread.sleep(5000);
	
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("eve_are_frame2")))); // switch the
																												// frame
	
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello:email is not opened;please open the email");
	
				driver.switchTo().defaultContent();
				Thread.sleep(5000);
	
				JavascriptExecutor js14 = (JavascriptExecutor) driver;
				js14.executeScript("window.scrollTo(document.body.scrollHeight,300)");
	
				//Auto response3
				driver.findElement(By.xpath(properties.getProperty("eveautoresponse_email3"))).click(); // auto response
				Thread.sleep(5000);
	
				JavascriptExecutor js15 = (JavascriptExecutor) driver;
				js15.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				WebElement rdrpdwn2 = driver.findElement(By.xpath(properties.getProperty("event_ar_drop_down_click3"))); // select
																													// drop
																													// down
				// rdrpdwn.click();
				Select reason1 = new Select(rdrpdwn2);
				Thread.sleep(5000);
				reason1.selectByValue("16");
				Thread.sleep(8000);
	
				driver.findElement(By.xpath(properties.getProperty("eve_are_subject3")))
						.sendKeys("send immeditely after email is opnd"); // subject
				Thread.sleep(5000);
	
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("eve_are_frame3")))); // switch the
																												// frame
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello:send immeditely after email is opnd,thnku for opening");
				driver.switchTo().defaultContent();
	
				JavascriptExecutor js16 = (JavascriptExecutor) driver;
				js16.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	
				//Auto response4
				driver.findElement(By.xpath(properties.getProperty("eveautoresponse_email4"))).click(); // auto response
				Thread.sleep(5000);
	
				JavascriptExecutor js17 = (JavascriptExecutor) driver;
				js17.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
				Thread.sleep(4000);
				WebElement rdrpdwn11 = driver.findElement(By.xpath(properties.getProperty("event_ar_drop_down_click4"))); // select
																													// drop
																													// down
				// rdrpdwn.click();
				Select reason11 = new Select(rdrpdwn11);
				Thread.sleep(3000);
				reason11.selectByValue("24");
				Thread.sleep(4000);
				
	
				driver.findElement(By.xpath(properties.getProperty("eve_are_subject4"))).sendKeys(" redistribute mail.");
	//			driver.findElement(By.xpath(properties.getProperty("e_are_xdays4"))).sendKeys("1"); // subject
	//			Thread.sleep(5000);
				driver.findElement(By.xpath(properties.getProperty("eve_are_choosetemp"))).click(); // choosing the template
	
				Thread.sleep(6000);
				WebElement e_arv_templatesearch = driver
						.findElement(By.xpath(properties.getProperty("eve_are_template_searchdata")));
				e_arv_templatesearch.sendKeys("basic");
				e_arv_templatesearch.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
	
				driver.findElement(By.xpath(properties.getProperty("eve_are_selecttemplate"))).click();
				Thread.sleep(5000);
		logger.info("Auto responses selected");
	
	
	
				JavascriptExecutor js18 = (JavascriptExecutor) driver;
				js18.executeScript("window.scrollTo(document.body.scrollHeight,300)");
				
				
				////Auto response5
				driver.findElement(By.xpath(properties.getProperty("eveautoresponse_email5"))).click(); // auto response
				Thread.sleep(5000);
				
				JavascriptExecutor js19 = (JavascriptExecutor) driver;
				js19.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				WebElement rdrpdwn5 = driver.findElement(By.xpath(properties.getProperty("event_ar_drop_down_click5"))); // select
																													// drop
																													// down
				// rdrpdwn.click();
				Select reason5 = new Select(rdrpdwn5);
				Thread.sleep(5000);
				reason5.selectByValue("33");
				Thread.sleep(8000);
				
				driver.findElement(By.xpath(properties.getProperty("eve_are_subject5")))
						.sendKeys("Send follow-up email"); // subject
				Thread.sleep(5000);
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("eve_are_frame5")))); // switch the
																												// frame
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello:Send follow-up email");
				driver.switchTo().defaultContent();
				
				JavascriptExecutor js20 = (JavascriptExecutor) driver;
				js20.executeScript("window.scrollTo(document.body.scrollHeight,0)");
				
				Thread.sleep(4000);
	
				
				
				
				////Auto response6
				driver.findElement(By.xpath(properties.getProperty("eveautoresponse_email6"))).click(); // auto response
				Thread.sleep(5000);
				
				JavascriptExecutor js21 = (JavascriptExecutor) driver;
				js21.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				WebElement rdrpdwn6 = driver.findElement(By.xpath(properties.getProperty("event_ar_drop_down_click6"))); // select
																													// drop
																													// down
				// rdrpdwn6.click();
				Select reason6 = new Select(rdrpdwn6);
				Thread.sleep(5000);
				reason6.selectByValue("30");
				Thread.sleep(8000);
				
				driver.findElement(By.xpath(properties.getProperty("eve_are_subject6")))
						.sendKeys("Send reminder id responded YES"); // subject
				Thread.sleep(5000);
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("eve_are_frame6")))); // switch the
																												// frame
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello:Send reminder id responded YES");
				driver.switchTo().defaultContent();
				
				JavascriptExecutor js22 = (JavascriptExecutor) driver;
				js22.executeScript("window.scrollTo(document.body.scrollHeight,0)");
				
				Thread.sleep(4000);
				
				
				
			////Auto response7
				driver.findElement(By.xpath(properties.getProperty("eveautoresponse_email7"))).click(); // auto response
				Thread.sleep(5000);
						
				JavascriptExecutor js23 = (JavascriptExecutor) driver;
				js23.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				WebElement rdrpdwn7 = driver.findElement(By.xpath(properties.getProperty("event_ar_drop_down_click7"))); // select
																															// drop
																															// down
			// rdrpdwn6.click();
				Select reason7 = new Select(rdrpdwn7);
				Thread.sleep(5000);
				reason7.selectByValue("28");
				Thread.sleep(8000);
						
				driver.findElement(By.xpath(properties.getProperty("eve_are_subject7")))
				.sendKeys("Send after event"); // subject
				Thread.sleep(5000);
						
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("eve_are_frame7")))); // switch the
																														// frame
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello:Send after event");
				driver.switchTo().defaultContent();
						
				JavascriptExecutor js24 = (JavascriptExecutor) driver;
				js24.executeScript("window.scrollTo(document.body.scrollHeight,0)");
						
				Thread.sleep(4000);
						
						
						
			////Auto response8
				driver.findElement(By.xpath(properties.getProperty("eveautoresponse_email8"))).click(); // auto response
				Thread.sleep(5000);
									
				JavascriptExecutor js25 = (JavascriptExecutor) driver;
				js25.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				WebElement rdrpdwn8 = driver.findElement(By.xpath(properties.getProperty("event_ar_drop_down_click8"))); // select
																																		// drop
																																		// down
			// rdrpdwn6.click();
				Select reason8 = new Select(rdrpdwn8);
				Thread.sleep(5000);
				reason8.selectByValue("25");
				Thread.sleep(8000);
									
				driver.findElement(By.xpath(properties.getProperty("eve_are_subject8")))
				.sendKeys("Send email if RSVP yes"); // subject
				Thread.sleep(5000);
									
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath(properties.getProperty("eve_are_frame8")))); // switch the
																																	// frame
				driver.findElement(By.xpath("html/body")).click();
				driver.switchTo().activeElement().sendKeys("Hello:Send email if RSVP yes");
				driver.switchTo().defaultContent();
									
				JavascriptExecutor js26 = (JavascriptExecutor) driver;
				js26.executeScript("window.scrollTo(document.body.scrollHeight,0)");
									
				Thread.sleep(4000);
		}
	}
