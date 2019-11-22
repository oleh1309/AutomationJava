package com.epam.pages;

import static com.epam.util.WebDriverConfig.getDriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage extends AbstractPage{

  private By mainTextNewsPage = By.xpath("//span[contains(text(),'News')]");
  private By listNews = By.xpath("//span[contains(text(),'News')]|//span[contains(text(),'Success Stories')]|//span[contains(text(),'Materials')]|//span[contains(text(),'Videos')]");
  private By clickMaterials = By.xpath("//span[contains(text(),'Materials')]");
  private By listMaterials = By.xpath("//div[@class='news-page-item__title']/a[contains(.,'Materials')]|//div[@class='news-page-item__title']/a[contains(.,'Useful')]");

  public String getMainTextNewsPage() {
    String res = wait.until(ExpectedConditions.visibilityOfElementLocated(mainTextNewsPage)).getText();
    return res;
  }

  public List<WebElement> getListNews(){
    List<WebElement> listNewsElement = getDriver().findElements(listNews);
    wait.until(ExpectedConditions.visibilityOfAllElements(listNewsElement));
    return listNewsElement;
  }

  public NewsPage clickNewsMaterial(){
    getDriver().findElement(clickMaterials).click();
    return this;
  }
  public List<WebElement> getListMaterials(){
    List<WebElement> listMaterialsElement = getDriver().findElements(listMaterials);
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listMaterials));
    return listMaterialsElement;
  }



}
