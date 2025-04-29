package com.xamplify.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    public static Properties readPropertyFile(String filePath) {
        Properties prop = new Properties();
        File file = new File(filePath);
        try (FileInputStream fileInput = new FileInputStream(file)) {
            // Load properties file
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
