package com.webst.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CR {

    // Creating properties object
    // Its private to prevent access from outside
    private static Properties properties = new Properties();


    static {

        try {
            //Create FileInputStream object to open file as a stream in Java memory.
            FileInputStream file = new FileInputStream("configuration.properties");
            //Load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND IN: ConfigurationReader class");
            e.printStackTrace();

        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
