package com.xamplify.automation;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
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
	static String getMailId ="";
	static String uniquecompany = "";



   @Test(priority=1,enabled=true)
   public void uploadcsv() throws InterruptedException {
	   Thread.sleep(5000);
// Step 1: Hover over the "Partner" section  
	   hoverOnPartners();     
// Step 2: Define test data for CSV file (each row corresponds to the headers)
	  String filePath= CreateCSVFile();
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
       Thread.sleep(3000);
         WebElement acceptTandC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("acceptT&C"))));
         acceptTandC.click();
         Thread.sleep(3000);
         WebElement pcontinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("pContinue"))));
         pcontinue.click();
         Thread.sleep(3000);
         XamplifyUtil.takeScreenshot(driver, "Upload CSV");
        // autoResponseMessage("Your Partner(s) have been saved successfully");
         // Step 7 : verify Csv upload success message validation
		 /* WebElement sucess_msg = driver.findElement(By.xpath(properties.getProperty("con_existname")));
         String expected_msg = "Your Partner(s) have been saved successfully";
		  String Actual_msg = sucess_msg.getText();
		  Assert.assertEquals(Actual_msg, expected_msg);*/  
      }
         
   
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
         Thread.sleep(3000);
         WebElement pcontinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("pContinue"))));
         pcontinue.click();
         Thread.sleep(3000);
         XamplifyUtil.takeScreenshot(driver, "OneataTime");
   }
   
   @Test(priority=3,enabled=true)
   public void searchAndVerifyPartner() throws InterruptedException {
	   hoverOnPartners();
       Thread.sleep(3000);
	// Step 1: Perform search
	   String searchKeyword=getMailId;
       performSearch(searchKeyword);  
    // Step 2: Verify results
       verifySearchResults(searchKeyword);  
       Thread.sleep(2000);
       XamplifyUtil.takeScreenshot(driver, "SearchRecords");
   }
   
   @Test(priority=4,enabled=true)
   public void exportToExcel() throws InterruptedException, AWTException {
	   searchAndVerifyPartner();
       Thread.sleep(3000);
	   XamplifyUtil.callClickEvent(properties.getProperty("action"));
       Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("downloadingpartners"));
		Thread.sleep(2000);
	   XamplifyUtil.excelDownload();
	   Thread.sleep(3000);
	   XamplifyUtil.takeScreenshot(driver, "exportToExcel");	   
   }
     
   
   @Test(priority=5,enabled=true)
   public void exportToEmail() throws InterruptedException {
	   Thread.sleep(3000);
	   searchAndVerifyPartner();
	   Thread.sleep(5000);
	   XamplifyUtil.callClickEvent(properties.getProperty("exportToMail"));
	   Thread.sleep(4000);
	   XamplifyUtil.takeScreenshot(driver, "exportToemail");	   
   }
  
   @Test(priority=6,enabled=true)
   public void createGroup() throws InterruptedException {
	   searchAndVerifyPartner();
	   Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("checkbox1"));
       Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("action"));
       Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("newGroup"));
	   Thread.sleep(2000);
	   driver.findElement(By.xpath(properties.getProperty("nameofthelist"))).clear();
	   XamplifyUtil.sendTextEvent(properties.getProperty("nameofthelist"), "NewGroup"+ System.currentTimeMillis());
	   Thread.sleep(4000);
	   XamplifyUtil.sendTextEvent(properties.getProperty("legalInGroup"), "Legitimate interest - prospect/lead");
	   Thread.sleep(2000);
	   XamplifyUtil.sendKeyEvent(properties.getProperty("legalInGroup"), Keys.ENTER);
	   Thread.sleep(2000);
	   WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("saveNewGroup"))));
	   saveButton.click();
	   Thread.sleep(2000);
	   XamplifyUtil.takeScreenshot(driver, "newgroup");	      
   }
   
   @Test(priority=7,enabled=true)
   public void addToGroup() throws InterruptedException {
	   searchAndVerifyPartner();	   
	   Thread.sleep(5000);
	   XamplifyUtil.callClickEvent(properties.getProperty("checkbox1"));
	   Thread.sleep(2000);
	   XamplifyUtil.callClickEvent(properties.getProperty("action"));
	   Thread.sleep(3000);
	   XamplifyUtil.callClickEvent(properties.getProperty("addToGroup"));
	   Thread.sleep(8000);
	   XamplifyUtil.callClickEvent(properties.getProperty("groupcheckbox"));
	   Thread.sleep(4000);
	   XamplifyUtil.callClickEvent(properties.getProperty("addpartnerToGroup"));
	   Thread.sleep(3000);
	   XamplifyUtil.takeScreenshot(driver, "AddPartnerToGroup");
	   Thread.sleep(3000);
	   XamplifyUtil.callClickEvent(properties.getProperty("modernPopupClose"));
   }  
   
   @Test(priority=8,enabled=true)
   public void deletePartner() throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 0);");
	   searchAndVerifyPartner();
	   Thread.sleep(3000);
	   XamplifyUtil.callClickEvent(properties.getProperty("deletepartneronboard"));
	   Thread.sleep(3000);
	   XamplifyUtil.callClickEvent(properties.getProperty("yesdeleteit"));
	   Thread.sleep(9000);
	   XamplifyUtil.takeScreenshot(driver, "deletePartner");	   
   }
   
	@Test(priority = 9, enabled = true)
	public void pagenation() throws Throwable{
		Thread.sleep(3000);
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
	@Test(priority = 10, enabled = true)
	public void partnerEdit() throws InterruptedException {
		Thread.sleep(3000);
		hoverOnPartners();
		Thread.sleep(5000);
		XamplifyUtil.callClickEvent(properties.getProperty("editpartner"));
		Thread.sleep(4000);
		updatepartnerForm();
		Thread.sleep(3000);        
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("updatepartner2"))));
		element.click();
		//XamplifyUtil.callClickEvent(properties.getProperty("updatepartner2"));
		Thread.sleep(3000);
		XamplifyUtil.takeScreenshot(driver, "updatePartner");		
	} 
	


   
   
//Methods..............................................................................................
	public void hoverOnPartners() throws InterruptedException {  
       WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("hoverpartner")))); 
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 0);");
        XamplifyUtil.hoverAndClick(driver, properties, "hoverpartner", "Onboarding");             
	}

	public void autoResponseMessage(String xpathProperty, String responseMessage) {		
	    WebElement messageElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("xpathProperty"))));    
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
    public static void verifySearchResults(String searchKeyword) {
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
        Thread.sleep(2000);		
  	    getMailId="user" + System.currentTimeMillis() + "@gmail.com";
    	uniquecompany = "company" + System.nanoTime();

        XamplifyUtil.sendTextEvent(properties.getProperty("emailid_1"), getMailId);
        XamplifyUtil.sendTextEvent(properties.getProperty("companyname"), uniquecompany);
        XamplifyUtil.sendTextEvent(properties.getProperty("firstname"), "firstname"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("lastname"), "lastname"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("jobtitle"), "jobtitle"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("address"), "address"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("city"), "city"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("state"), "state"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("zipcode"), "123456"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("vertical"), "vertical"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("Region"), "Region"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("category"), "category"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("Partnertype"), "Partnertype"); 
        XamplifyUtil.sendTextEvent(properties.getProperty("legall"), "Legitimate interest - prospect/lead");
        XamplifyUtil.sendKeyEvent(properties.getProperty("legall"), Keys.ENTER);
        Thread.sleep(2000);		
	} 
    public static void updatepartnerForm() throws InterruptedException {
        Thread.sleep(2000);		
  	   // driver.findElement(By.xpath(properties.getProperty("emailid_1"))).isDisplayed();
       // XamplifyUtil.sendTextEvent(properties.getProperty("companyname"), uniquecompany);
 	   driver.findElement(By.xpath(properties.getProperty("firstname"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("firstname"), "firstname7"); 
 	   driver.findElement(By.xpath(properties.getProperty("lastname"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("lastname"), "lastname7"); 
 	   driver.findElement(By.xpath(properties.getProperty("jobtitle"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("jobtitle"), "jobtitle7"); 
 	   driver.findElement(By.xpath(properties.getProperty("address"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("address"), "address7"); 
 	   driver.findElement(By.xpath(properties.getProperty("city"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("city"), "city7"); 
 	   driver.findElement(By.xpath(properties.getProperty("state"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("state"), "state7"); 
 	   driver.findElement(By.xpath(properties.getProperty("zipcode"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("zipcode"), "1234567"); 
 	   driver.findElement(By.xpath(properties.getProperty("vertical"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("vertical"), "vertical7"); 
 	   driver.findElement(By.xpath(properties.getProperty("Region"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("Region"), "Region7"); 
 	   driver.findElement(By.xpath(properties.getProperty("category"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("category"), "category7"); 
 	   driver.findElement(By.xpath(properties.getProperty("Partnertype"))).clear();
        XamplifyUtil.sendTextEvent(properties.getProperty("Partnertype"), "Partnertype7");

       // XamplifyUtil.sendTextEvent(properties.getProperty("legall"), "Legitimate interest - prospect/lead");
       // XamplifyUtil.sendKeyEvent(properties.getProperty("legall"), Keys.ENTER);
        Thread.sleep(2000);		
	}

    public static String CreateCSVFile() {
    	getMailId="user" + System.currentTimeMillis() + "@gmail.com";
    	uniquecompany = "company" + System.nanoTime();
        List<String[]> partnerUserData = Arrays.asList(
                new String[] { "FIRSTNAME","LASTNAME","ACCOUNT NAME","ACCOUNT OWNER","ACCOUNT SUB TYPE","cm1"+uniquecompany,"COMPANY DOMAIN",
               		 "JOBTITLE","us1"+getMailId,"","VERTICAL,REGION","TERRITORY","TYPE,CATEGORY","ADDRESS","CITY","STATE","ZIP",
               		"COUNTRY","MOBILE NUMBER" },
                new String[] { "FIRSTNAME","LASTNAME","ACCOUNT NAME","ACCOUNT OWNER","ACCOUNT SUB TYPE","cm2"+uniquecompany,"COMPANY DOMAIN",
                		 "JOBTITLE","us2"+getMailId,"","VERTICAL,REGION","TERRITORY","TYPE,CATEGORY","ADDRESS","CITY","STATE","ZIP",
                		"COUNTRY","MOBILE NUMBER" });       
 // Step 3: Generate CSV dynamically and get the file path
        String filePath = XamplifyUtil.generatePartnerCSV(partnerUserData);
		return filePath;  
	}
    

}
