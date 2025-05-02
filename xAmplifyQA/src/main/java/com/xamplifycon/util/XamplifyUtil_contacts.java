
package com.xamplifycon.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xamplify.automation.Instance;
import com.xamplify.automation.PropertiesFile;

public class XamplifyUtil_contacts {

	public static final int ONE_SECOND = 1000;

	public static void sleepForTenSeconds() throws InterruptedException {
		Thread.sleep(ONE_SECOND);
	}

	public static final int TWO_SECOND = 2000;

	public static void sleepForTwoSeconds() throws InterruptedException {
		Thread.sleep(TWO_SECOND);
	}

	public static final int THREE_SECOND = 3000;

	public static void sleepForThreeSeconds() throws InterruptedException {
		Thread.sleep(THREE_SECOND);
	}

	public static void enterText(String propertyKey, String text) {
		driver.findElement(By.xpath(properties.getProperty(propertyKey))).sendKeys(text);
	}

	public static void sendKeys(String propertyKey, Keys key) {
		driver.findElement(By.xpath(properties.getProperty(propertyKey))).sendKeys(key);
	}


	
	public static void callClickEvent(String xpathExpression) {
	    WebDriverWait wait = new WebDriverWait(driver, 30); // Wait up to 30 seconds
	    try {
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
	        element.click();
	       
	    } catch (TimeoutException e) {
	        System.err.println("Timeout waiting for element to be clickable: " + xpathExpression);
	    } catch (NoSuchElementException e) {
	        System.err.println("Element not found for XPath: " + xpathExpression);
	    } catch (Exception e) {
	        System.err.println("Unexpected error while clicking element: " + xpathExpression);
	        e.printStackTrace();
	    }
	}

	
	
	
	
	
	
	
	public static void selectDropdownOption(String propertyKey, String visibleText, int waitTime)
			throws InterruptedException {
		WebElement dropdown = driver.findElement(By.xpath(properties.getProperty(propertyKey)));
		Select select = new Select(dropdown);
		select.selectByVisibleText(visibleText);

	}

	public static void runT() throws IOException {
		Runtime rt = Runtime.getRuntime();
		String[] commands = { "D:\\git\\xAmplifyQA\\xAmplifyQA\\Uploadcontacts.exe", "-get t" };

		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

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
		String[] commands = { "D:\\git\\xAmplifyQA\\xAmplifyQA\\Uploadcontacts.exe" };

		Process process = runtime.exec(commands);

		BufferedReader lineReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		lineReader.lines().forEach(System.out::println);

		BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		errorReader.lines().forEach(System.out::println);
	}

	static WebDriver driver = Instance.getInstance();
	static Properties properties = PropertiesFile
			.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\ManageContacts.properties");

	public static void commonLines() throws InterruptedException {

		Thread.sleep(2000);

		driver.findElement(By.xpath(properties.getProperty("mc_conjourney_task_calendr"))).click();

		LocalDate tomorrow = LocalDate.now().plusDays(1);
		int day = tomorrow.getDayOfMonth();

		System.out.println(day);
		// Adjust the date format if needed (e.g., for "1", "01", etc.)
		String dayStr = (day < 10) ? "0" + day : String.valueOf(day);
		String tomorrowMonth = tomorrow.getMonth().toString().toLowerCase(); // Get abbreviated month, e.g., "January"
		String tomorrowYear = String.valueOf(tomorrow.getYear());

		// Example: Print out the calculated tomorrow's date (for debugging purposes)
		System.out.println("Tomorrow's Date: " + tomorrowMonth + " " + dayStr + "," + tomorrowYear);

		// Now, select the day for tomorrow
		WebElement tomorrowCell = driver
				.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div/span[text()='" + dayStr + "']"));
		tomorrowCell.click();

		Thread.sleep(4000);

	}
	
	
	
	public static void sendmobileTextEvent(String xpathKey, String newNumber, WebDriver driver, Properties properties) throws InterruptedException {
	    WebElement phoneInput = driver.findElement(By.xpath(properties.getProperty(xpathKey)));

	    // Focus input
	    phoneInput.click();
	    Thread.sleep(500);

	    // Check if country code is present
	    String currentVal = phoneInput.getAttribute("value");
	    boolean hasCountryCode = currentVal != null && currentVal.contains("+");

	    // Extract country code from new number
	    String countryCode = "";
	    if (newNumber.startsWith("+")) {
	        int spaceIdx = newNumber.indexOf(" ");
	        if (spaceIdx != -1) {
	            countryCode = newNumber.substring(0, spaceIdx);
	        } else {
	            // fallback if no space (assumes code is first 2-4 chars)
	            for (int i = 2; i <= 4 && i < newNumber.length(); i++) {
	                if (!Character.isDigit(newNumber.charAt(i))) {
	                    countryCode = newNumber.substring(0, i);
	                    break;
	                }
	            }
	            if (countryCode.isEmpty()) countryCode = newNumber.substring(0, 3); // default length
	        }
	    }

	    // Update flag if needed
	    if (!hasCountryCode || !currentVal.startsWith(countryCode)) {
	        driver.findElement(By.xpath(properties.getProperty("mcon_flag"))).click();
	        Thread.sleep(500);
	        WebElement codeInput = driver.findElement(By.xpath(properties.getProperty("mcon_flagcode")));
	        codeInput.clear();
	        codeInput.sendKeys(countryCode);
	        Thread.sleep(500);
	        driver.findElement(By.xpath(properties.getProperty("mcon_flagcode_select"))).click();
	        Thread.sleep(1000);

	        phoneInput = driver.findElement(By.xpath(properties.getProperty(xpathKey)));
	        phoneInput.click();
	        Thread.sleep(500);

	        currentVal = phoneInput.getAttribute("value");
	    }

	    // Clear existing number
	    int charsToDelete = 0;
	    if (currentVal != null && currentVal.contains(" ")) {
	        String[] parts = currentVal.split(" ");
	        if (parts.length > 1) {
	            charsToDelete = parts[1].length();
	        }
	    }

	    for (int i = 0; i < charsToDelete; i++) {
	        phoneInput.sendKeys(Keys.BACK_SPACE);
	        Thread.sleep(50);
	    }

	    // Type new number (without country code)
	    String numberOnly = newNumber.replace(countryCode + " ", "").replace(countryCode, "");
	    phoneInput.sendKeys(numberOnly);
	    Thread.sleep(500);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
