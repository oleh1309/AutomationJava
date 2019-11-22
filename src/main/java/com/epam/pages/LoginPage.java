package com.epam.pages;

import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {

  private By mailInput = By.xpath(" //input[@id='signInEmail']");
  private By passwordInput = By.id("signInPassword");
  private By loginButton = By.className("popup-reg-sign-in-form__sign-in");
  private By exceptionIncorrectData = By.xpath("//div[@class='popup__error-message ng-binding']");

  public LoginPage enterUserName(String mail) {
    setTextVsWait(mailInput,mail);
    return this;
  }

  public LoginPage enterPassword(String password) {
    setText(passwordInput,password);
    return this;
  }

  public LoginPage clickLogin() {
    clickIn(loginButton);
    return this;
  }

  public boolean getError(){
    return getElementDisplayedVsWait(exceptionIncorrectData);
  }

}
