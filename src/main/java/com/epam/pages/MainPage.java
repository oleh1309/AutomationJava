package com.epam.pages;

import static com.epam.util.WebDriverConfig.getDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {

  private By bellElement = By.xpath("//div[@class='fa fa-bell-o notifications-count']");
  private By signInButton = By.xpath("//p[@class='header-auth__signin']//span");
  private By languageButton = By.className("location-selector__globe");
  private By expandSkillsArrow  = By.className("filter-toggle__arrow-icon");
  private By bySkillsButton = By.xpath("//div[contains(text(),'By skills')]");
  private By skillsSearchInput = By.xpath("//input[@name='training-filter-input']");
  private By javaCheckbox = By.xpath("//ul[@class = 'location__cities-list-cities location__cities-list-skills']/li[contains(.,'Java')][1]//span");
  private By collapseSkillsArrow = By.xpath("//div[@ng-class = \"{'arrow-icon-rotate' : dropDownActive}\"]");
  private By closeLocation = By.xpath("//span[contains(.,'Lviv')]/span[@class='filter-field__input-item-close-icon']");
  private By closeButtonJava = By.xpath("//span[contains(.,'Java')]//following-sibling::span[@class='filter-field__input-item-close-icon']");
  private By closeButtonData = By.xpath("//span[contains(.,'Data')]/span[@class='filter-field__input-item-close-icon']");
  private By checkboxChooseAllSkills = By.xpath("//div[@class='location__cities location__skills']//following-sibling::div[@class='location__countryCheckBox']//label/span");
  private By listSkills = By.xpath("//div[@class='location__cities location__skills']/ul");
  private By newsPage = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem news click hover'][contains(text(),'News')]");
  private By byLocationButton = By.xpath("//div[contains(text(),'By location')]");
  private By isLocationLviv = By.xpath("//label[@class='location__not-active-label ng-binding location__location-active-label']");
  private By userList = By.xpath("//div[@class='user-info__arrow']");
  private By getApplication = By.xpath("//a[contains(text(),'Applications')]");
  private By clickUkraine = By.xpath("//li[@ng-repeat = 'locations in locationNames']//div[contains(text(),'Ukraine')]");
  private By signInEnglish = By.xpath("//p[@class='header-auth__signin' and contains(.,'Sign in')]");

  public MainPage clickSignIn() {
    clickInVsWait(signInButton,true);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton)).click();
    return this;
  }

  public MainPage checkSignIn() {
    getElement(signInEnglish);
   // wait.until(ExpectedConditions.visibilityOfElementLocated(signInEnglish));
    return this;
  }

  public MainPage clickLanguageButton() {
    clickInVsWait(languageButton,false);
    //wait.until(ExpectedConditions.elementToBeClickable(languageButton)).click();
    return this;
  }

  public MainPage clickExpandSkillsArrow() {
    //WebElement expandSkillsArrowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(expandSkillsArrow));
    //expandSkillsArrowElement.click();
    clickInVsWait(expandSkillsArrow,true);
    return this;
  }

  public MainPage clickCloseLocation(){
    //wait.until(ExpectedConditions.elementToBeClickable(closeLocation)).click();
    clickInVsWait(closeLocation,false);
    return this;
  }

  public MainPage clickBySkillsButton() {
    WebElement bySkillsButtonElement = wait.until(ExpectedConditions.elementToBeClickable(bySkillsButton));
    bySkillsButtonElement.click();
    //clickInVsWait(bySkillsButton,true);
    return this;
  }

  public MainPage enterSkillsSearchInput(String value) {
//    WebElement skillsSearchInputElement = wait.until(ExpectedConditions.elementToBeClickable(skillsSearchInput));
//    skillsSearchInputElement.sendKeys(value);
    setTextVsWait(skillsSearchInput,value);
    return this;
  }

  public MainPage clikCollapseSkillsArrow() {
//    WebElement collapseSkillsArrowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(collapseSkillsArrow));
//    collapseSkillsArrowElement.click();
    clickInVsWait(collapseSkillsArrow,true);
    return this;
  }

  public MainPage clickCloseButtonJava() {
   WebElement closeButtonElement = getDriver().findElement(closeButtonJava);
//    closeButtonElement.click();
    JavascriptExecutor executor = (JavascriptExecutor)getDriver();
    executor.executeScript("arguments[0].click();", closeButtonElement);
   // clickInVsWait(closeButtonJava,false);
    return this;
  }

  public MainPage clickCloseButtonData() {
//    WebElement closeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(closeButtonData));
//    closeButtonElement.click();

    clickInVsWait(closeButtonData,true);
    return this;
  }

  public MainPage clickCheckboxChooseAllSkills() {
//    WebElement checkboxChooseAllSkillsElement = wait.until(ExpectedConditions.elementToBeClickable(checkboxChooseAllSkills));
//    checkboxChooseAllSkillsElement.click();
    clickInVsWait(checkboxChooseAllSkills,true);
    return this;
  }

  public MainPage clickNewsPage() {
//    WebElement newsPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newsPage));
//    newsPageElement.click();
    clickInVsWait(newsPage,true);
    return this;
  }

  public MainPage clickByLocationButton() {
//    WebElement byLocationButtonElement = wait.until(ExpectedConditions.elementToBeClickable(byLocationButton));
//    byLocationButtonElement.click();
    clickInVsWait(byLocationButton,false);
    return this;
  }

  public MainPage clickUkraineButton() {
//    WebElement clickUkraineElement = wait.until(ExpectedConditions.elementToBeClickable(clickUkraine));
//    clickUkraineElement.click();
    clickInVsWait(clickUkraine,false);
    return this;
  }

  public MainPage clickJavaCheckbox(){
//    wait.until(ExpectedConditions.elementToBeClickable(javaCheckbox)).click();
    clickInVsWait(javaCheckbox,false);
    return this;
  }

  public MainPage clickUserListApplication(){
    clickIn(userList);
    clickInVsWait(getApplication,true);
//    getDriver().findElement(userList).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(getApplication)).click();
    return this;
  }

  public List<WebElement> getSkillsSearchResultsList(String arg){
    By skillsSearchResultsList = By.xpath("//a[@class='training-item__title-link ng-binding'][contains(text(),\'"+arg+"\')]");
    List<WebElement> skillsSearchResultsListElement = getDriver().
        findElements(skillsSearchResultsList);
    return skillsSearchResultsListElement;
  }

  public List<WebElement> getListSkills(){
    List<WebElement> skillsSearchResultsListElement = getDriver().
        findElements(listSkills);
    return skillsSearchResultsListElement;
  }

  public String getLocationLviv(){
    return getTextOfElement(isLocationLviv);
  }

  public WebElement getUserInfo(){
    return wait.until(ExpectedConditions.visibilityOfElementLocated(bellElement));
  }

}
