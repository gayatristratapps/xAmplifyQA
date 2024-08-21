package com.xamplify.automation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class partners_onboard_comma {
	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Partners.properties");
	final Logger logger = LogManager.getLogger(partners_onboard_comma.class);

	@Test(priority = 3, enabled = true)
	public void Signinprocess() throws InterruptedException, SQLException {

		logger.info("Moving to onboarding partners");
		WebElement partners = driver.findElement(By.xpath(properties.getProperty("hoverpartner")));// hover to partners
																									// module in left
																									// menu
		Actions actions = new Actions(driver);
		actions.moveToElement(partners).perform();
		Thread.sleep(6000);
		logger.info("Moved to onboarding partners");
		driver.findElement(By.xpath(properties.getProperty("Onboarding"))).click();// click "onboarding partners"
	}

	@Test(priority = 4, enabled = true)
	public void One_At_A_Time() throws InterruptedException, SQLException, IOException {

		// logger.debug("Starting creating partner using one at time");
		Thread.sleep(10000);
		driver.findElement(By.xpath(properties.getProperty("oneatatime"))).click();// click "one at a time"
		Thread.sleep(2000);
		System.out.println("partners123");
		logger.info("clicked on one at a time");

		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis"))).click();// click legal basis field to get the
																					// list
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("legalbasis")))
				.sendKeys("Legitimate interest - prospect/lead");// enter data for legal basis field
		Thread.sleep(1000);
		WebElement textbox = driver.findElement(By.xpath(properties.getProperty("legalbasis")));
		textbox.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis")))
				.sendKeys("Legitimate interest - existing customer");// enter data for legal basis field
		Thread.sleep(1000);
		textbox.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis"))).sendKeys("Legitimate interest - other");// enter
																													// data
																													// for
																													// legal
																													// basis
																													// field
		Thread.sleep(1000);
		textbox.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis"))).sendKeys("Performance of a contract");// enter
																													// data
																													// for
																													// legal
																													// basis
																													// field
		Thread.sleep(1000);
		textbox.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis")))
				.sendKeys("Freely given consent from contact");// enter data for legal basis field
		Thread.sleep(1000);
		textbox.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis"))).click();//clicked on legal basis dropdown
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("legalbasis"))).sendKeys("Not applicable");// enter data for
																										// legal basis
																										// field
		Thread.sleep(1000);
		textbox.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("vertical"))).sendKeys("vertical");// enter data for vertical
																								// field
		driver.findElement(By.xpath(properties.getProperty("Region"))).sendKeys("Region");// enter data for Region field
		driver.findElement(By.xpath(properties.getProperty("Partnertype"))).sendKeys("Partnertype");// enter data for
																									// Partnertype field
		driver.findElement(By.xpath(properties.getProperty("category"))).sendKeys("category");// enter data for category
																								// field

		driver.findElement(By.xpath(properties.getProperty("firstname"))).sendKeys("First name");// enter data for
																									// firstname field
		driver.findElement(By.xpath(properties.getProperty("lastname"))).sendKeys("Last Name");// enter data for
																								// lastname field
		driver.findElement(By.xpath(properties.getProperty("companyname")))
				.sendKeys("Company" + System.currentTimeMillis());// enter data for
		// companyname field
		driver.findElement(By.xpath(properties.getProperty("jobtitle"))).sendKeys("Job Title");// enter data for
																								// jobtitle field
		Thread.sleep(2000);

		driver.findElement(By.id(properties.getProperty("emailid_1")))
				.sendKeys(properties.getProperty("oneatatimeemailid"));
		Thread.sleep(5000);
		driver.findElement(By.id(properties.getProperty("emailid_1"))).clear();
		driver.findElement(By.id(properties.getProperty("emailid_1"))).sendKeys(System.currentTimeMillis() + "_");// enter
																													// dynamic
																													// email
																													// id
																													// for
																													// email
																													// id
																													// field
		driver.findElement(By.id(properties.getProperty("emailid_1")))
				.sendKeys(properties.getProperty("oneatatimeemailid"));//entering emailid 

		driver.findElement(By.xpath(properties.getProperty("address"))).sendKeys("Address");// enter data for Address
																							// field
		driver.findElement(By.xpath(properties.getProperty("city"))).sendKeys("City");// enter data for City field
		driver.findElement(By.xpath(properties.getProperty("state"))).sendKeys("State");// enter data for State field
		driver.findElement(By.xpath(properties.getProperty("zipcode"))).sendKeys("Zip code");// enter data for Zip code
																								// field
		Select countries = new Select(driver.findElement(By.xpath(properties.getProperty("country"))));// enter data for
																										// country field
		countries.selectByValue("India");

		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("countrycode"))).sendKeys("+1 551-227-8922");// enter data
																										// for
																										// mobilenumber
																										// and country
																										// code fields
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("savepartner"))).click();// click save button
		Thread.sleep(8000);

		driver.findElement(By.xpath(properties.getProperty("acceptT&C"))).click();// Accept terms and conditions
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("contactslimit"))).sendKeys("100");// sending contacts limit
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("signupnotification"))).click();// Toggling signup
																							// notification
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("teammembergroup"))).click(); // Clicking Team member group
		Thread.sleep(5000);

		Select objSelect = new Select(driver.findElement(By.xpath(properties.getProperty("option"))));
		objSelect.selectByIndex(1); // selecting Team Member Group
		driver.findElement(By.xpath(properties.getProperty("option"))).click();
		Thread.sleep(2000); // Selecting Team Member

		driver.findElement(By.xpath(properties.getProperty("checkbox"))).click();//selected a specific Team member 

		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("continue"))).click();//clicked on to submit Button
		Thread.sleep(8000);
		logger.info("partner onboarded through one at a time successfully");


	}

	@Test(priority = 5, enabled = true)
	public void copy_from_clipboard_comma() throws InterruptedException, SQLException, IOException

	{

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("copyFromClipBoard")));
		// logger.debug("Starting creating partner using copy from clipboard - comma
		// separated");

		driver.findElement(By.id("copyFromClipBoard")).click();// click copy from clipboard
		Select delimiter = new Select(
				driver.findElement(By.xpath("//div[@class='col-xs-6']//select[@class='opts form-control']")));
		delimiter.selectByValue("CommaSeperated");//selecting the delimiter
		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Legitimate interest - prospect/lead");// enter
																														// data
																														// for
																														// legal
																														// basis
																														// field
		Thread.sleep(1000);

		WebElement textbox1 = driver.findElement(By.xpath(properties.getProperty("drop")));
		textbox1.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop")))
				.sendKeys("Legitimate interest - existing customer");// enter data for legal basis field
		Thread.sleep(1000);
		textbox1.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Legitimate interest - other");// enter
																												// data
																												// for
																												// legal
																												// basis
																												// field
		Thread.sleep(1000);
		textbox1.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Performance of a contract");// enter data
																											// for legal
																											// basis
																											// field
		Thread.sleep(1000);
		textbox1.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Freely given consent from contact");// enter
																													// data
																													// for
																													// legal
																													// basis
																													// field
		Thread.sleep(1000);
		textbox1.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Not applicable");// enter data for legal
																								// basis field
		Thread.sleep(1000);
		textbox1.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("clip"))).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("clip"))).sendKeys(properties.getProperty("cffielddata"));

		driver.findElement(By.xpath(properties.getProperty("clip")))
				.sendKeys(properties.getProperty("cffielddata0") + System.currentTimeMillis());

		driver.findElement(By.xpath(properties.getProperty("clip")))
				.sendKeys(properties.getProperty("cffielddata_1") + System.currentTimeMillis());

		driver.findElement(By.xpath(properties.getProperty("clip"))).sendKeys(properties.getProperty("cffielddata1"));

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='col-xs-6']//select[@class='opts form-control']")).click();

		// driver.findElement(By.xpath(properties.getProperty("clip"))).sendKeys(properties.getProperty("cffielddata2"));
		// Thread.sleep(2000);
		Select delimiter1 = new Select(
				driver.findElement(By.xpath("//div[@class='col-xs-6']//select[@class='opts form-control']")));
		delimiter1.selectByIndex(1);//slecting the delimiter by index
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("verifying"))).click();//clicking on verify button
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("verify1"))).click();//clicking on accept

		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("verify2"))).click();
		Thread.sleep(2000);

		/*
		 * driver.findElement(By.xpath(properties.getProperty("actions"))).click();
		 * 
		 * Thread.sleep(2000);
		 */driver.findElement(By.xpath(properties.getProperty("limit"))).sendKeys("100");//entering the no of contacts 
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Not"))).click();//Toggle button for signup
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("team_member_group"))).click();//clicking on Team Member Group 
		Thread.sleep(4000);

		Select objSelect = new Select(driver.findElement(By.xpath(properties.getProperty("option")))); //
		objSelect.selectByIndex(1); //Selecting a Team Member by index
		/*
		 * driver.findElement(By.xpath(properties.getProperty("option"))).click();
		 * Thread.sleep(2000);
		 */
		Thread.sleep(3000);
		driver.findElement(By.xpath(properties.getProperty("checkbox"))).click();//clicking on the Team member check box
		Thread.sleep(5000);

		driver.findElement(By.xpath(properties.getProperty("proceed"))).click();//Selecting on proceed
		Thread.sleep(10000);
		logger.info("Onboarded Partner through copy listfrom clipboard with comma delimiter");

		// driver.findElement(By.xpath(properties.getProperty("continue2"))).click();

	}

	@Test(priority = 6, enabled = true)
	public void copy_from_clipboard_tab() throws InterruptedException, SQLException, IOException

	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300)");

		driver.findElement(By.xpath("//*[@id='copyFromClipBoard']/span/..")).click();// click copy from clipboard

		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Legitimate interest - prospect/lead");// enter
																														// data
																														// for
																														// legal
																														// basis
																														// field
		Thread.sleep(1000);

		WebElement textbox2 = driver.findElement(By.xpath(properties.getProperty("drop")));
		textbox2.sendKeys(Keys.ENTER);// click enter in the keyboard
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("drop")))
				.sendKeys("Legitimate interest - existing customer");// enter data for legalbasis field
		Thread.sleep(1000);
		textbox2.sendKeys(Keys.ENTER);// click entering the keyboard

		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Legitimate interest - other");
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Performance of a contract");// enter data
																											
		Thread.sleep(1000);
		textbox2.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Freely given consent from contact");
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("drop"))).sendKeys("Not applicable");// enter data for legal
																								// // basis field
		Thread.sleep(1000);
		textbox2.sendKeys(Keys.ENTER);// click enter in thekeyboard
		Thread.sleep(1000);
		driver.findElement(By.xpath(properties.getProperty("clip"))).click();
		Thread.sleep(1000);

		String data = "firstname	lastname	accountname	accowner	acctype	companyname"
				+ System.currentTimeMillis() + "	company" + "	AE" + "	harry" + System.currentTimeMillis()
				+ "@gmail.com	";// Data stored in String 

		System.out.println(data);

		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('copyFromclipTextArea').value=arguments[0];", data);

		Thread.sleep(2000);
		driver.findElement(By.id(properties.getProperty("cfcfieldid")))
				.sendKeys("www.vertical" + System.currentTimeMillis() + ".com");//entering the website(dynamic)
		Thread.sleep(2000);

		Select delimiter = new Select(
				driver.findElement(By.xpath("//div[@class='col-xs-6']//select[@class='opts form-control']")));
		delimiter.selectByValue("TabSeperated");//Selecting Tab Seperated 

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("verifying"))).click(); //Click on Verify

		driver.findElement(By.xpath(properties.getProperty("saving"))).click();//Click on Save

		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("saving1"))).click();//Selecting the Toggle to send Signup

		driver.findElement(By.xpath(properties.getProperty("limit"))).sendKeys("100");//Entering number of contacts 
		Thread.sleep(2000);
		driver.findElement(By.xpath(properties.getProperty("Not"))).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(properties.getProperty("option"))).click(); // Clicking Team Member 
		Thread.sleep(2000);

		Select delimiter2 = new Select(driver.findElement(By.xpath("//select[@id='partner-tm-group-0']")));
		delimiter2.selectByIndex(1);//Selecting Team member group by index
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("selectedteammeber"))).click();// Selected team member 
		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("continuetoadd"))).click();// continue to add a Partner 
		Thread.sleep(8000);
		logger.info("Onboarded Partner through copy listfrom clipboard with Tab delimiter");


	}

}
