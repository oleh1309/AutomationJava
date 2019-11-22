package com.epam.util;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
  private static WebDriver driver;

  public static WebDriver getDriver() {

    if(driver==null) {
      String browser = Configuration.getConfiguration().getValue("browser");
      System.setProperty("webdriver.chrome.driver",
          Configuration.getConfiguration().getValue("driver.location"));

      switch (browser) {
        case "Chrome": {
          driver = new ChromeDriver();
          break;
        }
        case "Firefox": {
          driver = new FirefoxDriver();
          break;
        }
        default: {
          driver = new ChromeDriver();
          break;
        }
      }
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    return driver;
  }

  public static void closeDriver(){
    if(driver!=null) {
      driver.quit();
      driver = null;
    }
  }
}
