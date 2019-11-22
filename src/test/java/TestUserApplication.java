import com.epam.businessObjects.AuthorizationBO;
import com.epam.pages.MainPage;
import com.epam.pages.UserApplicationPage;
import com.epam.util.Consts;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUserApplication extends MainConf {
  private UserApplicationPage userApplicationPage;
  private MainPage mainPage;
  private AuthorizationBO authorizationBO;

  @BeforeClass
  public void beforeClass() {
    authorizationBO = new AuthorizationBO();
    mainPage = new MainPage();
    userApplicationPage = new UserApplicationPage();
  }

  @Test(priority = 1)
  public void checkAuthorization() {
    authorizationBO.getAuthorization(Consts.email, Consts.password);
    Assert.assertEquals(authorizationBO.getCorrectResult().getUserInfo().isDisplayed(),true,
        "Test failed! User information doesnt displayed!");
  }

  @Test(priority = 2)
  public void checkUserApplication() {
    mainPage.clickUserListApplication();
    List<WebElement> list = userApplicationPage.listStatus();
    list.forEach(webElement -> Assert.assertTrue(webElement.getText().contains("Training in Progress"),
        String.format("Element %s does not contain 'Training in Progress' word.", webElement)));

  }

}
