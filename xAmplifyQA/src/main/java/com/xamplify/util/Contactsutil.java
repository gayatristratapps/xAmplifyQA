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

   
    public static void executeRuntimeProcess(String... command) throws IOException {
        Process process = new ProcessBuilder(command).start();

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {

            inputReader.lines().forEach(System.out::println);
            errorReader.lines().forEach(System.out::println);

        } // both readers are automatically closed here
    }

    
}
