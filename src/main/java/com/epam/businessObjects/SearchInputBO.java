package com.epam.businessObjects;

import com.epam.pages.MainPage;

public class SearchInputBO {
  private MainPage mainPage;

  public SearchInputBO() {
    mainPage = new MainPage();
  }

  public void setFirstInput(String param){
    mainPage.clickCloseLocation()
        .clickExpandSkillsArrow()
        .clickBySkillsButton()
        .enterSkillsSearchInput(param)
        .clickJavaCheckbox()
        .clikCollapseSkillsArrow();
  }

  public void setSecondInput(String param) {
    mainPage.clickCloseButtonJava()
        .clickExpandSkillsArrow()
        .clickBySkillsButton()
        .enterSkillsSearchInput(param)
        .clickCheckboxChooseAllSkills()
        .clikCollapseSkillsArrow();
  }

  public void setThirdInput(String param) {
    mainPage.clickCloseButtonData()
        .clickExpandSkillsArrow()
        .clickBySkillsButton()
        .enterSkillsSearchInput(param);
  }
}

