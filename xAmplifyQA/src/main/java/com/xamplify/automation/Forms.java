package com.xamplify.automation;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Forms {

	WebDriver driver = Instance.getInstance();
	Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\.metadata\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Forms.properties");
	final Logger logger = LogManager.getLogger(VideoCampaign.class);

	@Test(priority = 3, enabled = false)
	public void design() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("Designmodule"))).click();// clicking on Design Module
		logger.info("Clicked on Design Module");
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("DesignForms"))).click();
		Thread.sleep(5000);
	}

	@Test(priority = 4, enabled = false)
	public void designregularform() throws InterruptedException {

		driver.findElement(By.xpath(properties.getProperty("RegularForm"))).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Hoveringregularform")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("clickoncreatingregularform"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname")))
				.sendKeys("Regularnewform" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformcontinue"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savingregularform"))).click();
		Thread.sleep(5000);
		design();
	}

	@Test(priority = 5, enabled = false)
	public void designquizform() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("quizForm"))).click();
		Thread.sleep(4000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Hoveringquizform")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("clickoncreatingquizform"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("quizformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("quizformname")))
				.sendKeys("quiznewform" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("quizformcontinue"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savingquizform"))).click();
		Thread.sleep(5000);
		design();

	}

	@Test(priority = 6, enabled = false)
	public void designsurveyform() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("surveyForm"))).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("Hoveringsurveyform")));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("clickoncreatingsurveyform"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("surveyformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("surveyformname")))
				.sendKeys("surveynewform" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("surveyformcontinue"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savingsurveyform"))).click();

	}

	@Test(priority = 7, enabled = true)
	public void Manageforms() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(properties.getProperty("Designmodule"))).click();// clicking on Design Module
		logger.info("Clicked on Design Module");
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("Manageforms"))).click();

	}

	@Test(priority = 8, enabled = false)
	public void ManageformsEdit() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath(properties.getProperty("RegularForm"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("EditRegularForm"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("AddFields"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("singlelinetext"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("closeregaddfields"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Designbutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("inputurl"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("inputurl"))).sendKeys("https://www.xamplify.co/");
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("checkbox"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("submitaddedfields"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("submittoupdateregform"))).click();

	}

	@Test(priority = 9, enabled = false)
	public void Manageformsregsaveas() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("EditRegularForm"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("renameicon"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname")))
				.sendKeys("Regularnewform" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformcontinue"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("saveasregform"))).click();

	}

	@Test(priority = 10, enabled = false)
	public void Manageformsregicons() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("copyasregform"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Regularformname")))
				.sendKeys("Regularnewformcopy" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("copiedsave"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("okbuttonreg"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("previewregform"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("closepreviewregform"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Embed"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("Embedclose"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Deleteregform"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("yesdelete"))).click();
	}

	@Test(priority = 11, enabled = false)
	public void Manageformsquiz_Gridview() throws InterruptedException {
		Thread.sleep(8000);

		WebElement ele = driver.findElement(By.xpath(properties.getProperty("gridviewmanageforms")));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("gridviewclick"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("quizfilter"))).click();
		Thread.sleep(3000);

		WebElement ele1 = driver.findElement(By.xpath(properties.getProperty("gridview1")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(ele1).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("gridviewpreview"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("gridviewpreviewclose"))).click();
		Thread.sleep(3000);
		action1.moveToElement(ele1).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("gridviewcopyquizgorm"))).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(properties.getProperty("savechangesgridviewquizform"))).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("copyokquizform"))).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(properties.getProperty("gridviewmanageforms")));
		Actions action6 = new Actions(driver);
		action6.moveToElement(element).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("gridviewclick"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("quizfilter"))).click();
		Thread.sleep(3000);

		WebElement ele12 = driver.findElement(By.xpath(properties.getProperty("gridview1")));
		Actions action12 = new Actions(driver);
		action12.moveToElement(ele12).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("embedgridviewquiz"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("closeembedgridview"))).click();
		Thread.sleep(3000);

		WebElement ele121 = driver.findElement(By.xpath(properties.getProperty("gridview1")));
		Actions action121 = new Actions(driver);
		action121.moveToElement(ele121).perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Editgridviewquiz"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(properties.getProperty("Addfieldsforquiz"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("singlelinetext"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("closeforaddfields"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("updatequizform"))).click();
		Thread.sleep(25000);

	}

	@Test(priority = 12, enabled = false)
	public void Manageformsquiz_Gridview1() throws InterruptedException {
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("gridviewmanageforms1")));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("gridviewclick"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("quizfilter"))).click();
		Thread.sleep(3000);

		WebElement ele3 = driver.findElement(By.xpath(properties.getProperty("gridview1")));
		Actions action3 = new Actions(driver);
		action3.moveToElement(ele3).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Editgridviewquiz"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Renamingquizformicon"))).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(properties.getProperty("Renamequizform"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Renamequizform")))
				.sendKeys("saveasregform" + System.currentTimeMillis());
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("continueafterrename"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("continuetosaveasquiz"))).click();
		Thread.sleep(30000);
		WebElement ele12 = driver.findElement(By.xpath(properties.getProperty("gridviewmanageforms1")));
		Actions action12 = new Actions(driver);
		action12.moveToElement(ele12).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("gridviewclick"))).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("quizfilter"))).click();
		Thread.sleep(3000);
		WebElement ele4 = driver.findElement(By.xpath(properties.getProperty("gridview1")));
		Actions action4 = new Actions(driver);
		action4.moveToElement(ele4).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("deletequizform"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("deleteokgridviewquizform"))).click();

	}
	
	@Test(priority = 12, enabled = true)
	public void Manageformssurvey_Foldergridtview() throws InterruptedException {
		Thread.sleep(8000);
		WebElement ele = driver.findElement(By.xpath(properties.getProperty("FolderGridviewforsurvey")));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("FolderGridview1"))).click();
		Thread.sleep(3000);
		
		WebElement ele1 = driver.findElement(By.xpath(properties.getProperty("FolderGridbar")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(ele1).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("FolderGridviewicon"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("surveyformMange"))).click();
	}
		@Test(priority = 13, enabled = true)
		public void Manageformssurvey_Foldergridviewicons() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath(properties.getProperty("copyassurveyform"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("surveyformname"))).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("surveyformname")))
				.sendKeys("surveynewform" + System.currentTimeMillis());
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("copiedsave"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("okbuttonreg"))).click();
		Thread.sleep(3000);
		Manageformssurvey_Foldergridtview();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("previewsurveyform"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("previewclosesurveyform"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("copyembedsurvey"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("Embedclosesurveyform"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("editiconforsurveyform"))).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath(properties.getProperty("Addfieldsbuttonforsurvey"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("singlelinetext"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("closeaddfieldsforsurvey"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("updatesurveform"))).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath(properties.getProperty("editiconforsurveyform"))).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath(properties.getProperty("renamingicon"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("renameforsurveyform"))).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("renameforsurveyform"))).sendKeys("surveynewform"+System.currentTimeMillis());
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("continuetoupdate"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(properties.getProperty("saveasforsurveyform"))).click();
		Thread.sleep(30000);
		Manageformssurvey_Foldergridtview();
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Deletethesyrveform"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("yesdeletethesurvey")));
		
		
		
		
		
		
		
		
		
		
		/*
		 * driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click()
		 * ; Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("previewregform"))).click(
		 * ); Thread.sleep(5000);
		 * driver.findElement(By.xpath(properties.getProperty("closepreviewregform"))).
		 * click(); Thread.sleep(4000);
		 * driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click()
		 * ; Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("Embed"))).click();
		 * Thread.sleep(4000);
		 * driver.findElement(By.xpath(properties.getProperty("Embedclose"))).click();
		 * Thread.sleep(4000);
		 * driver.findElement(By.xpath(properties.getProperty("regformfilter"))).click()
		 * ; Thread.sleep(3000);
		 * driver.findElement(By.xpath(properties.getProperty("Deleteregform"))).click()
		 * ; Thread.sleep(5000);
		 * driver.findElement(By.xpath(properties.getProperty("yesdelete"))).click();
		 */
		
		
	}
}