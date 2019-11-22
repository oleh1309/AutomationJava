package com.epam.util;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {

  private static Configuration instance = new Configuration();

  private Properties properties;

  private Configuration() {

    properties = new Properties();
    try {
      properties.load(new FileInputStream("src/main/resources/configurationFile.properties"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static Configuration getConfiguration() {
    return instance;
  }

  public String getValue(String key) {
    return properties.getProperty(key);
  }
}
