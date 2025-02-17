package com.xamplify.automation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	WebDriver driver = Instance.getInstance();
	 Properties properties = PropertiesFile.readPropertyFile("D:\\git\\xAmplifyQA\\xAmplifyQA\\src\\main\\resources\\Campaign.properties");

	
	public void captureScreenshot(String screenshotName) {
        // Get the current timestamp to avoid overwriting files
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Take a screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Define the destination file path
        String destinationPath = "./screenshots/" + screenshotName + "_" + timestamp + ".png";
        File destinationFile = new File(destinationPath);

        try {
            // Save the screenshot to the destination
            FileUtils.copyFile(sourceFile, destinationFile);
            System.out.println("Screenshot saved: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
        }
        
        
   }

}
