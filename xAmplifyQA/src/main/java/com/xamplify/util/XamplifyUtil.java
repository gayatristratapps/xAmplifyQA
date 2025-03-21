

package com.xamplify.util;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.automation.Instance;

public class XamplifyUtil {
	
	static WebDriver driver = Instance.getInstance();
	//static Properties properties = PropertiesFile
			//.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\ManageContacts.properties");
	
	
	
	public static final int TWO_SECONDS = 2000;
	
	public static final int THREE_SECONDS = 3000;
	
	public static final int ONE_SECOND = 1000;
	
	
	 public static final int SLEEP_TIME = 1000;
	
	


	public static WebElement getElementById(String id) {
        return driver.findElement(By.id(id));
    }

    
	
    public WebElement getElementByName(String name) {
        return driver.findElement(By.name(name));
    }

   
    public WebElement getElementByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

   
 
   
    public WebElement getElementByClassName(String className) {
        return driver.findElement(By.className(className));
    }

 
    

   
    public WebElement getElementByTagName(String tagName) {
        return driver.findElement(By.tagName(tagName));
    }

   
    public List<WebElement> getElementsByXPath(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

   
    public List<WebElement> getElementsByCss(String cssSelector) {
        return driver.findElements(By.cssSelector(cssSelector));
    }
	
	
	
	
    
    public static void hoverAndClick(String hoverElement, String clickElement) {
        WebElement ele = driver.findElement(By.xpath(hoverElement));
        new Actions(driver).moveToElement(ele).perform();
        XamplifyUtil.clickEvent(clickElement, driver);
    }


	public static void clickEvent(String key,WebDriver driver) {
		driver.findElement(By.xpath(key)).click();
	}
    
    
    
    
    
    
    public static void sleep(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

  

	
	
	
	
	 public static void callClickEvent(String propertyKey) {
	        driver.findElement(By.xpath(propertyKey)).click();
	 }
	
	
	 

	    

		public static void sendTextEvent(String propertyKey, String text) {
		    driver.findElement(By.xpath(propertyKey)).sendKeys(text);
		}
	    
	 
		public static void sendTextWithTimestamp(String elementId, String baseText) {
		    driver.findElement(By.id(elementId)).sendKeys(baseText + System.currentTimeMillis());
		}

	 
		public static void sendTextWithTimestamp(String locator, String baseText, String suffix) {
		    WebElement element = driver.findElement(By.xpath(locator));
		    element.sendKeys(baseText + System.currentTimeMillis() + suffix);
		}
		
	
		public static void scrollInsideElement(WebElement element, int pixels) {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += arguments[1];", element, pixels);
		}

		
		public static void selectDropdownByText(String locator, String visibleText) {
		    WebElement dropdownElement = driver.findElement(By.xpath(locator));
		    Select dropdown = new Select(dropdownElement);
		    dropdown.selectByVisibleText(visibleText);
		}
	

		public static void selectDropdownByValue(String locator, String value) {
			  WebElement dropdownValue = driver.findElement(By.xpath(locator));
		    Select dropdown = new Select(dropdownValue);
		    dropdown.selectByValue(value);
		}

		public static void selectDropdownByIndex(String locator, int index) {
			  WebElement dropdownIndex = driver.findElement(By.xpath(locator));
		    Select dropdown = new Select(dropdownIndex);
		    dropdown.selectByIndex(index);
		}
		
	   
		 public static void excelDownload() throws AWTException, InterruptedException {
		        Robot robot = new Robot();
		        robot.keyPress(KeyEvent.VK_CONTROL);
		        robot.keyPress(KeyEvent.VK_ENTER);
		        robot.keyRelease(KeyEvent.VK_S);
		        robot.keyRelease(KeyEvent.VK_ENTER);
		        Thread.sleep(SLEEP_TIME);
		    }
	
		
		
		
		
		
		
		
	
		public static final String SCREENSHOT_PATH = "D:/git/xAmplifyQA/xAmplifyQA/test-output/screenshots/";

	
	public static void takeScreenshot(WebDriver driver, String screenshotName) {
       
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = SCREENSHOT_PATH + screenshotName + "_" + timestamp + ".png";


        // Take the screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
        }
    }
	
	 public static void waitAndClick(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, (10)); // Wait for up to 10 seconds
	        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	    }
	
	
	
	// Method to wait until an element is visible
	    public static WebElement waitForElementVisibility(By locator, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	
	  
	  
	  
 
	  public static void selectDropdownWithWait(WebDriver driver, String locator, int index) {
	        WebDriverWait wait = new WebDriverWait(driver, (30));

	        // Wait until the dropdown is visible and clickable
	        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

	        // Create Select object and select by index
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByIndex(index);

	        // Wait briefly to observe the selection (Optional)
	        try {
	            Thread.sleep(1000); // 1-second pause to see the data change (not recommended for production)
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	  
	
	  
	  
	  public static void clickElementWithWait(WebDriver driver, String propertyKey, int waitTime) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, waitTime);
	            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((propertyKey))));
	            element.click();
	        } catch (Exception e) {
	            System.out.println("Element not found or interaction failed: " + e.getMessage());
	        }
	    }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  
	
  
  public static void hoverAndClick(WebDriver driver, Properties properties, String hoverElementKey, String clickElementKey) {
      Actions actions = new Actions(driver);
      WebElement hoverElement = driver.findElement(By.xpath(properties.getProperty(hoverElementKey)));
      WebElement clickElement = driver.findElement(By.xpath(properties.getProperty(clickElementKey)));
      actions.moveToElement(hoverElement).perform();
      clickElement.click();
  }
	
	
	
	
	
	
	
	
	public static void runT() throws IOException {
		Runtime rt = Runtime.getRuntime();
		String[] commands = {"D:\\git\\xAmplifyQA\\xAmplifyQA\\Uploadshareleads.exe", "-get t"};
		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new 
		     InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new 
		     InputStreamReader(proc.getErrorStream()));

		// Read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
		    System.out.println(s);
		}

		// Read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
		    System.out.println(s);
		}
	}
	
	public static void executeRuntimeProcess() throws IOException {

        Runtime runtime = Runtime.getRuntime();
        String[] commands  = {"D:\\git\\xAmplifyQA\\xAmplifyQA\\Uploadshareleads.exe"};
        Process process = runtime.exec(commands);

        BufferedReader lineReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        lineReader.lines().forEach(System.out::println);

        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        errorReader.lines().forEach(System.out::println);
    }



	public static void sendKeyEvent(String locator, Keys key) {
	    driver.findElement(By.xpath(locator)).sendKeys(key);
	}

	
	
	
	
	
    public static String generateCSV(List<String[]> userData) {
        // Generate unique filename using timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "test_data_" + timestamp + ".csv";
        File csvFile = new File(filePath);

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            // Writing headers
            writer.println("FIRSTNAME,LASTNAME,COMPANY,JOBTITLE,EMAILID,ADDRESS,CITY,STATE,ZIP CODE,COUNTRY,MOBILE NUMBER");

            // Writing data rows
            for (String[] user : userData) {
                writer.println(String.join(",", user));
            }

            System.out.println("CSV File Generated: " + csvFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvFile.getAbsolutePath(); // Return the file path for test usage
    }
	
	
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, (timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	
}
