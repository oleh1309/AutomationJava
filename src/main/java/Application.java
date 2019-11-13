import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Application {

  private static ChromeDriverService service;
  private WebDriver driver;


  @BeforeTest
  public void createDriver() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://training.by");

  }

  @Test(description = "task1(correct authorization)")
  public void testAuthorization() {
    //change language
    changeLanguage();

    String mailCorrect = "oleg.martsiniuk@gmail.com";
    String passwordCorrect = "manjak13--09";
    WebDriverWait wait = new WebDriverWait(driver, 40);


    WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.xpath("//p[@class='header-auth__signin']//span")));
    signInButton.click();
    WebElement mailInput = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.id("signInEmail")));
    mailInput.sendKeys(mailCorrect);
    WebElement passwordInput = driver.findElement(By.id("signInPassword"));
    passwordInput.sendKeys(passwordCorrect);
    WebElement signIn = driver.findElement(By.className("popup-reg-sign-in-form__sign-in"));
    signIn.click();
    WebElement userInfo = wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.className("user-info__name")));
    Assert.assertEquals(userInfo.getText(),"Martsiniuk Oleh","Test failed");
  }
  @Test(description = "task2(Incorrect authorization)")
  public void testFailedAuthorization() {
    //change language
    changeLanguage();

    String mailCorrect = "olertsiniuk@gmail.com";
    String passwordCorrect = "manjak09";
    WebDriverWait wait = new WebDriverWait(driver, 40);
    WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.xpath("//p[@class='header-auth__signin']//span")));
    signInButton.click();
    WebElement mailInput = driver.findElement(By.id("signInEmail"));
    mailInput.sendKeys(mailCorrect);
    WebElement passwordInput = driver.findElement(By.id("signInPassword"));
    passwordInput.sendKeys(passwordCorrect);
    WebElement signIn = driver.findElement(By.className("popup-reg-sign-in-form__sign-in"));
    signIn.click();
    WebElement takeException =wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.className("popup__error-message")));
    //if(takeException.getText() == "Ошибка авторизации. Пожалуйста, попробуйте еще раз."){
     Assert.assertEquals(takeException.getText(),"Ошибка авторизации. Пожалуйста, попробуйте еще раз.");
  }
  public void changeLanguage(){
    WebDriverWait wait = new WebDriverWait(driver, 40);
    WebElement ckickChangeLanguageButton = driver.findElement(By.className
        ("location-selector__globe"));
    ckickChangeLanguageButton.click();
    WebElement itemEnglish = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.xpath("//div[@class='location-selector__item']//a[@class='active' and contains(.,'English')]")));
    itemEnglish.click();
    WebElement checkEnstring = driver.findElement(By.className("header-auth__signin"));
    Assert.assertEquals(checkEnstring.getText(),"Sign in","Test failed!");
  }

  @Test(description = "task3(training search skills)")
  public void testSearchingSkil() {
    WebDriverWait wait = new WebDriverWait(driver, 40);

    testAuthorization();

    WebElement  expandSkillsArrow  = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.className("filter-toggle__arrow-icon")));
    expandSkillsArrow.click();

    WebElement bySkillsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[contains(text(),'By skills')]")));
    bySkillsButton.click();

    WebElement skillsSearchInputFirst = driver
        .findElement(By.xpath("//input[@name='training-filter-input']"));
    skillsSearchInputFirst.sendKeys("Java");

    WebElement javaCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//label[contains(.,'Java')]//span")));
    javaCheckbox.click();
    WebElement collapseSkillsArrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
        ("//div[@class='filter-toggle__arrow-icon arrow-icon-rotate']")));
    collapseSkillsArrow.click();

    List<WebElement> skillsSearchResultsList = driver.
        findElements(By.xpath("//div[@class='training-list__container training-list__desktop']//a"));
    skillsSearchResultsList.forEach(element -> Assert.assertTrue(element.getText().contains("JAVA"),
        String.format("Element %s does not contain 'Java' word.",element)));

    WebElement closeButton = driver.findElement(By.className("filter-field__input-item-close-icon"));
    closeButton.click();
    WebElement skillsSearchInputSecond = driver
        .findElement(By.xpath("//input[@name='training-filter-input']"));
    skillsSearchInputSecond.sendKeys("DATA");
    WebElement checkboxChooseAllSkills = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//span[@class = checkmark and contains(.,'Choose all skills')]")));
    checkboxChooseAllSkills.click();

    List<WebElement> skillsSearchResultsListSecond = driver.
        findElements(By.xpath("//div[@class='training-list__container training-list__desktop']//a"));
    skillsSearchResultsListSecond.forEach(element -> Assert.assertTrue(element.getText().contains("Data"),
        String.format("Element %s does not contain 'Data' word.",element)));

    WebElement collapseSkillsArrowSecond = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
        ("//div[@class='filter-toggle__arrow-icon arrow-icon-rotate']")));
    collapseSkillsArrowSecond.click();

    WebElement skillsSearchInput3dt = driver
        .findElement(By.xpath("//input[@name='training-filter-input']"));
    skillsSearchInput3dt.sendKeys("Pascal");

    List<WebElement> skillsSearchResultsList3d= driver.
        findElements(By.xpath("//div[@class='location__cities-list-cities location__cities-list-skills']//li"));
    skillsSearchResultsList3d.forEach(element -> Assert.assertTrue(element.getText().contains("Pascal"),
        String.format("Element %s does not contain 'Pascal' word.",element)));
  }

  @Test(description = "task4(Verify News page)")
  public void testVerifyNewsPage() {
    WebDriverWait wait = new WebDriverWait(driver, 40);
    testAuthorization();
    WebElement clickNewsPage = driver
        .findElement(By.className("main-nav__item activeItem"));
    clickNewsPage.click();
    WebElement mainTextNewsPage = driver
        .findElement(By.xpath("//span[contains(text(),'News')]"));
    Assert.assertEquals(mainTextNewsPage.getText(),"News","Test failed!");
    WebElement mainTextNewsPage2 = driver
        .findElement(By.xpath("//span[contains(text(),'Success Stories')]"));
    Assert.assertEquals(mainTextNewsPage2.getText(),"Success Stories","Test failed!");
    WebElement mainTextNewsPage3 = driver
        .findElement(By.xpath("//span[contains(text(),'Materials')]"));
    Assert.assertEquals(mainTextNewsPage3.getText(),"Materials","Test failed!");
    WebElement mainTextNewsPage4 = driver
        .findElement(By.xpath("//span[contains(text(),'Videos')]"));
    Assert.assertEquals(mainTextNewsPage4.getText(),"Videos","Test failed!");
    mainTextNewsPage3.click();
    List<WebElement> skillsSearchResultsList3d= driver.
        findElements(By.xpath("//div[@class='news-page-item__title']//a[@class='ng-binding' and contains(.,'materials'|'useful')]"));
    skillsSearchResultsList3d.forEach(element -> Assert.assertTrue(element.isDisplayed(),
        String.format("Element %s does not contain 'Pascal' word.",element)));
  }
  @Test(description = "task5(Verify Training page)")
  public void testVerifyTrainingPage() {
    WebDriverWait wait = new WebDriverWait(driver, 40);
    testAuthorization();

    WebElement  expandSkillsArrow  = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.className("filter-toggle__arrow-icon")));
    expandSkillsArrow.click();

    WebElement byLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[contains(text(),'By location')]")));
    byLocationButton.click();

    WebElement clickUkraine = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[@class='location__not-active-label city-name ng-binding'][contains(text(),'Ukraine')]")));
      clickUkraine.click();

    List<WebElement> trainingByLocationList= driver.
        findElements(By.xpath("//div[@class='training-item__location ng-binding' and contains(.,'Lviv, Ukraine')]"));
    Assert.assertEquals(trainingByLocationList.size(),1,"Test failed!");
  }
  @AfterTest
  public void quitDriver() {
    driver.quit();
  }

}
