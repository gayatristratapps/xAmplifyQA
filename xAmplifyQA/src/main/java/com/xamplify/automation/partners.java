package com.xamplify.automation;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.xamplify.util.XamplifyUtil;

public class partners {
	WebDriverWait wait = new WebDriverWait(driver, 50);
	static WebDriver driver = Instance.getInstance();
    static Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\partners.properties");
	static String uniqueEmail = "user" + System.currentTimeMillis() + "@gmail.com";
	static String uniquecompany = "company" + System.nanoTime();

	
   @Test(priority=1,enabled=true)
   public void uploadcsv() throws InterruptedException {
	   Thread.sleep(5000);
// Step 1: Hover over the "Partner" section  
	   hoverOnPartners();
      
// Step 2: Define test data for CSV file (each row corresponds to the headers)
       List<String[]> partnerUserData = Arrays.asList(
               new String[] { "FIRSTNAME","LASTNAME","ACCOUNT NAME","ACCOUNT OWNER","ACCOUNT SUB TYPE","cm1"+uniquecompany,"COMPANY DOMAIN",
              		 "JOBTITLE","us1"+uniqueEmail,"","VERTICAL,REGION","TERRITORY","TYPE,CATEGORY","ADDRESS","CITY","STATE","ZIP",
              		"COUNTRY","MOBILE NUMBER" },
               new String[] { "FIRSTNAME","LASTNAME","ACCOUNT NAME","ACCOUNT OWNER","ACCOUNT SUB TYPE","cm2"+uniquecompany,"COMPANY DOMAIN",
               		 "JOBTITLE","us2"+uniqueEmail,"","VERTICAL,REGION","TERRITORY","TYPE,CATEGORY","ADDRESS","CITY","STATE","ZIP",
               		"COUNTRY","MOBILE NUMBER" });
       
// Step 3: Generate CSV dynamically and get the file path
       String filePath = XamplifyUtil.generatePartnerCSV(partnerUserData);        
// Step 4:Locate file input and upload CSV
       WebElement uploadElement = driver.findElement(By.xpath(properties.getProperty("uploadcsv1")));
       uploadElement.sendKeys(filePath);     
// Step 5: Select Legal Basis Selection  
       String legalBasisXPath = properties.getProperty("legall");        
       XamplifyUtil.sendTextEvent(properties.getProperty("legall"), "Legitimate interest - prospect/lead");
       XamplifyUtil.sendKeyEvent(properties.getProperty("legall"), Keys.ENTER);
       Thread.sleep(5000);         
// Step 6: Click on save button and accept t&c then continue to upload
       XamplifyUtil.callClickEvent(properties.getProperty("csvparnersave"));
         WebElement acceptTandC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("acceptT&C"))));
         acceptTandC.click();
         WebElement pcontinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("pContinue"))));
         pcontinue.click();
         XamplifyUtil.takeScreenshot(driver, "Upload CSV");
        // autoResponseMessage("Your Partner(s) have been saved successfully");
         // Step 7 : verify Csv upload success message validation
		 /* WebElement sucess_msg = driver.findElement(By.xpath(properties.getProperty("con_existname")));
         String expected_msg = "Your Partner(s) have been saved successfully";
		  String Actual_msg = sucess_msg.getText();
		  Assert.assertEquals(Actual_msg, expected_msg);*/  
      }
       
   static String getMailId ="";
   @Test(priority=2,enabled=true)
   public void OnboardPartnerOneAtaTime() throws InterruptedException {
	   //Step 1: Hover over the "Partner" section  
	   Thread.sleep(5000);
	   hoverOnPartners();
	   Thread.sleep(5000);

	   //Step 2:  
 	   XamplifyUtil.callClickEvent(properties.getProperty("oneatatime"));
	   Thread.sleep(2000);
	   onboardpartnerForm();
    // Step 3: Click on proceed button and accept t&c then continue to upload
       XamplifyUtil.callClickEvent(properties.getProperty("oneatatimeproceed"));
         WebElement acceptTandC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("acceptT&C"))));
         acceptTandC.click();
         WebElement pcontinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("pContinue"))));
         pcontinue.click();
         XamplifyUtil.takeScreenshot(driver, "OneataTime");
   }
   
   @Test(priority=3,enabled=true)
   public void searchAndVerifyPartner() throws InterruptedException {
	   hoverOnPartners();
	// Step 1: Perform search
	   String searchKeyword=getMailId;
       performSearch(searchKeyword);  
    // Step 2: Verify results
       verifySearchResults(searchKeyword);  
       XamplifyUtil.takeScreenshot(driver, "SearchRecords");
   }
   
   @Test(priority=4,enabled=true)
   public void exportToExcel() throws InterruptedException, AWTException {
	   searchAndVerifyPartner();
	   XamplifyUtil.callClickEvent(properties.getProperty("action"));
	   XamplifyUtil.callClickEvent(properties.getProperty("downloadingpartners"));
		Thread.sleep(1000);
	   XamplifyUtil.excelDownload();
	   Thread.sleep(1000);
	   XamplifyUtil.takeScreenshot(driver, "exportToExcel");	   
   }
   
   @Test(priority=5,enabled=false)
   public void exportToEmail() throws InterruptedException {
	   searchAndVerifyPartner();
	   Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("exportToMail"));
	   Thread.sleep(1000);
	   XamplifyUtil.takeScreenshot(driver, "exportToemail");	   

   }
  
   @Test(priority=6,enabled=false)
   public void createGroup() throws InterruptedException {
	   searchAndVerifyPartner();
	   Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("checkbox1"));
	   XamplifyUtil.callClickEvent(properties.getProperty("action"));
	   XamplifyUtil.callClickEvent(properties.getProperty("newGroup"));
	   Thread.sleep(2000);
	   driver.findElement(By.xpath(properties.getProperty("nameofthelist"))).clear();
	   XamplifyUtil.sendTextEvent(properties.getProperty("nameofthelist"), "NewGroup"+ System.currentTimeMillis());
	   Thread.sleep(2000);
	   
	    // Send legal basis text and press Enter
	    XamplifyUtil.sendTextEvent(properties.getProperty("legalInGroup"), "Legitimate interest - prospect/lead");
	    XamplifyUtil.sendKeyEvent(properties.getProperty("legalInGroup"), Keys.ENTER);

	    // Wait for the save button to be clickable, then click to save the new group
	    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("saveNewGroup"))));
	    saveButton.click();
		   XamplifyUtil.takeScreenshot(driver, "newgroup");	      
   }
   
   @Test(priority=7,enabled=true)
   public void addToGroup() throws InterruptedException {
	   searchAndVerifyPartner();
	   Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("checkbox1"));
	   XamplifyUtil.callClickEvent(properties.getProperty("action"));
	   Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("addToGroup"));
	   Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("groupcheckbox"));
	   XamplifyUtil.callClickEvent(properties.getProperty("addpartnerToGroup"));
	   Thread.sleep(2000);
	   XamplifyUtil.takeScreenshot(driver, "AddPartnerToGroup");
   }
   
   
   @Test(priority=8,enabled=false)
   public void deletePartner() throws InterruptedException {
	   searchAndVerifyPartner();
	   XamplifyUtil.callClickEvent(properties.getProperty("deletepartneronboard"));
	   XamplifyUtil.callClickEvent(properties.getProperty("yesdeleteit"));
	   Thread.sleep(3000);
	   XamplifyUtil.takeScreenshot(driver, "deletePartner");	   
   }
   
	@Test(priority = 9, enabled = false)
	public void pagenation() throws Throwable{
		hoverOnPartners();
		Thread.sleep(2000);
	    WebElement pagination2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("pagenation2"))));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", pagination2);
	    // Wait until the element is clickable and then click it
	    wait.until(ExpectedConditions.elementToBeClickable(pagination2)).click();
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "pagination2");
	    /*WebElement paginationLast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("pagenation_last"))));
	    wait.until(ExpectedConditions.elementToBeClickable(paginationLast)).click();
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "paginationlast");
	    WebElement paginationfirst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("pagenation_first"))));
	    wait.until(ExpectedConditions.elementToBeClickable(paginationfirst)).click();	
		Thread.sleep(3000);
	    XamplifyUtil.takeScreenshot(driver, "paginationfirst");*/
	}
   
   
   
   
   
   
   
//Methods..............................................................................................
	public void hoverOnPartners() throws InterruptedException {  
       WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hoverpartner"))));        
           XamplifyUtil.hoverAndClick(driver, properties, "hoverpartner", "Onboarding");             
	}

	public void autoResponseMessage(String responseMessage) {		
	    WebElement messageElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='responseMessage']")));    
	    String actualMessage = messageElement.getText();
	    System.out.println(actualMessage);
	    Assert.assertEquals("The response message does not match.", responseMessage, actualMessage);
	}
	//Search functionality 
    public void performSearch(String searchKeyword) throws InterruptedException {
        Thread.sleep(2000);
        XamplifyUtil.sendTextEvent(properties.getProperty("searchh"), searchKeyword);
        Thread.sleep(2000);
        XamplifyUtil.sendKeyEvent(properties.getProperty("searchh"), Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Email Id:']/..")));
    }
    //verify search result record contain search word
    public void verifySearchResults(String searchKeyword) {
        // Find all records that contain the email ID using XPath
        List<WebElement> emailRecords = driver.findElements(By.xpath("//b[text()='Email Id:']/.."));
        // Verify that each of the email records contains the search keyword
        for (WebElement record : emailRecords) {
            String emailText = record.getText();
            System.out.println("Search record : "+ emailText + " = searchkeyword : " + searchKeyword);
            // Assert that the email text contains the search keyword
            Assert.assertTrue(emailText.contains(searchKeyword),"Search keyword does not match with the record: " + emailText);
        }
    }
        public void SearchPartnerDelete(String searchKeyword) {
            // Find all records that contain the email ID using XPath
            List<WebElement> emailRecords = driver.findElements(By.xpath("//b[text()='Email Id:']/.."));
            List<WebElement> DeleteRecords = driver.findElements(By.xpath("//b[text()='Email Id:']/.."));
            // Verify that each of the email records contains the search keyword
            for (WebElement record : emailRecords) {
                String emailText = record.getText();
                System.out.println("Search record : "+ emailText + " = searchkeyword : " + searchKeyword);
                // Assert that the email text contains the search keyword
                if(emailText.equals(searchKeyword)) {
                	
                	break;
                } 
                
            }           
    }
    public static void onboardpartnerForm() throws InterruptedException {
  	    getMailId=uniqueEmail;
        XamplifyUtil.sendTextEvent(properties.getProperty("emailid_1"), getMailId);
        XamplifyUtil.sendTextEvent(properties.getProperty("companyname"), uniquecompany);
        XamplifyUtil.sendTextEvent(properties.getProperty("firstname"), "firstname"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("lastname"), "lastname"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("jobtitle"), "jobtitle"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("address"), "address"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("city"), "city"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("state"), "state"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("zipcode"), "123456"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("city"), "city"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("vertical"), "vertical"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("Region"), "Region"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("category"), "category"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("Partnertype"), "Partnertype"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("city"), "city"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("legall"), "Legitimate interest - prospect/lead");
        XamplifyUtil.sendKeyEvent(properties.getProperty("legall"), Keys.ENTER);
        Thread.sleep(2000);		
	}
}
