package com.bank.bankdetails.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public static Properties setProperties(String propertiesFilePath) {
        Properties prop = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(propertiesFilePath);
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    public static String getPropertyValue(Properties prop, String key) throws Exception {
        if (prop.containsKey(key)) {
            if (prop.getProperty(key).isEmpty()) {
                throw new Exception("Property (" + key + ") is empty");
            } else {
                return prop.getProperty(key).trim();
            }
        } else {
            throw new Exception("Property (" + key + ") does not exit");
        }
    }
}
