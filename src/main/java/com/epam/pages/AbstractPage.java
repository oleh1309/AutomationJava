package com.epam.pages;

import static com.epam.util.WebDriverConfig.getDriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

  private  WebElement el;
  WebDriverWait wait = new WebDriverWait(getDriver(), 30);

  public void setText(By locator, String text) {
     getDriver().findElement(locator).sendKeys(text);
  }

  public void setTextVsWait(By locator, String text) {
    el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    el.sendKeys(text);
  }

  public void getElement(By locator){
     wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public boolean getElementDisplayedVsWait(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
  }

  public String getTextOfElement(By locator) {
    return getDriver().findElement(locator).getText();
  }

  public String getTextOfElementVsWait(By locator) {
    el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return el.getText();
  }

  public void clickIn(By locator) {
    getDriver().findElement(locator).click();
  }

  public void clickInVsWait(By locator, boolean visibil){
    if(visibil) {
       el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }else{
       el = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    el.click();
  }

  public List<WebElement> getListResult(By locator){
    return  getDriver().findElements(locator);
  }

  public List<WebElement> getListResultVsWait(By locator){

    return  getDriver().findElements(locator);
  }

}
