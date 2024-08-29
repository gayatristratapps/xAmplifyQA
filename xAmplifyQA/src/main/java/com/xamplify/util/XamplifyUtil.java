package com.xamplify.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XamplifyUtil {
	
	public static final int TWO_SECONDS = 2000;
	
	public static final int THREE_SECONDS = 3000;
	
	public static final int ONE_SECOND = 1000;
	
	public static void sleepForTenSeconds() throws InterruptedException {
		Thread.sleep(ONE_SECOND);
	}



	public static void clickEvent(String key,WebDriver driver) {
		driver.findElement(By.xpath(key)).click();
	}

	
	public static void sendClickEvent(String key,WebDriver driver,String sendKey) {
		driver.findElement(By.xpath(key)).sendKeys(sendKey);
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
}
