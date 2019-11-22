package com.epam.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LanguagePage extends AbstractPage{

  private By itemEnglish = By.xpath("//div[@class='location-selector__item']//a[contains(.,'English')]");

  public LanguagePage chooseItem() {
    clickInVsWait(itemEnglish,true);
    return this;
  }


}
