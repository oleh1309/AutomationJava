package com.epam.businessObjects;

import com.epam.pages.LanguagePage;
import com.epam.pages.LoginPage;
import com.epam.pages.MainPage;
import org.testng.Assert;

public class AuthorizationBO {

  MainPage mainPage;
  LanguagePage languagePage;
  LoginPage loginPage;

  public AuthorizationBO() {
    mainPage = new MainPage();
    languagePage = new LanguagePage();
    loginPage = new LoginPage();
  }

  public void getAuthorization(String name, String password){
    mainPage.clickLanguageButton();

    languagePage.chooseItem();

    mainPage.checkSignIn()
        .clickSignIn();

    loginPage.enterUserName(name)
        .enterPassword(password)
        .clickLogin();
  }

  public MainPage getCorrectResult(){
    Assert.assertEquals(mainPage.getUserInfo().isDisplayed(),true,
        "Test failed! User information doesnt displayed!");
    return  mainPage;
  }

  public LoginPage getIncorrectResult(){
    Assert.assertEquals(loginPage.getError(),true,
        "Test failed! User information is displayed!");
    return  loginPage;
  }

}
