package com.xamplify.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contactsutil {


    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

   

    
    public static void executeRuntimeProcess() throws IOException {

		Runtime runtime = Runtime.getRuntime();
		String[] commands = { "D:\\git\\xAmplifyQA\\xAmplifyQA\\Uploadshareleads.exe" };
		Process process = runtime.exec(commands);

		BufferedReader lineReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		lineReader.lines().forEach(System.out::println);

		BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		errorReader.lines().forEach(System.out::println);
	}

    
    
    
    
    
    
    
    
    
    
    
    
}
