import com.epam.businessObjects.AuthorizationBO;
import com.epam.pages.MainPage;
import com.epam.util.Consts;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestVerifyLocation extends MainConf {
  private MainPage mainPage;
  private AuthorizationBO authorizationBO;


  @BeforeClass
  public void beforeClass() {
  authorizationBO = new AuthorizationBO();
  mainPage = new MainPage();
}

  @Test(priority = 1)
  public void checkAuthorization() {
    authorizationBO.getAuthorization(Consts.email, Consts.password);
    Assert.assertEquals(authorizationBO.getCorrectResult().getUserInfo().isDisplayed(),true,
        "Test failed! User information doesnt displayed!");
  }
  @Test(priority = 2)
  public void checkLocation() {
    mainPage.clickExpandSkillsArrow()
        .clickByLocationButton()
        .clickUkraineButton();

    Assert.assertEquals(mainPage.getLocationLviv(),"Lviv");
  }

}
