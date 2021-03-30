package com.bbc.automation;

import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private static ConfigProperties instance = null;
    private Properties properties;
    
    public ConfigProperties() throws IOException{

        properties = new Properties();
        properties.load(getClass().getResourceAsStream("/config.properties"));
    }

    public static ConfigProperties getInstance() {
        if(instance == null) {
            try {
                instance = new ConfigProperties();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return instance;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

}
