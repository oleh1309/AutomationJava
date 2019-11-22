package com.epam.pages;

import static com.epam.util.WebDriverConfig.getDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserApplicationPage extends AbstractPage {

  private By status = By.xpath("//div[@class='status']/div/p[contains(.,'Training in Progress')]");

  public List<WebElement> listStatus(){
    List<WebElement> listStatusElement = getDriver().
        findElements(status);
    return listStatusElement;
  }

}
