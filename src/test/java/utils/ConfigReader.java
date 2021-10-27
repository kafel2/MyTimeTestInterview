package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static void readProperties(String filepath) {

        try {
            FileInputStream fis = new FileInputStream(filepath);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }
}
