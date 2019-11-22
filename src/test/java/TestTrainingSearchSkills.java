import com.epam.businessObjects.AuthorizationBO;
import com.epam.businessObjects.SearchInputBO;
import com.epam.pages.MainPage;
import com.epam.util.Consts;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTrainingSearchSkills extends MainConf {

  private MainPage mainPage;
  private AuthorizationBO authorizationBO;
  private SearchInputBO searchInputBO;
  @BeforeClass
  public void beforeClass() {
    authorizationBO = new AuthorizationBO();
    mainPage = new MainPage();
    searchInputBO = new SearchInputBO();
  }

  @Test(priority = 1)
  public void checkAuthorization() {
    authorizationBO.getAuthorization(Consts.email, Consts.password);
    Assert.assertTrue(authorizationBO.getCorrectResult().getUserInfo().isDisplayed(),
        "Test failed! User information doesnt displayed!");
  }

  @Test(priority = 2)
  public void searchSkillsJava() {

    searchInputBO.setFirstInput(Consts.firstInputWord);

    List<WebElement> list = mainPage.getSkillsSearchResultsList("Java");
    Assert.assertFalse(list.isEmpty());

  }

  @Test(priority = 3)
    public void searchSkills() {

    searchInputBO.setSecondInput(Consts.secondInputWord);

    List<WebElement> list1 = mainPage.getSkillsSearchResultsList(Consts.secondInputWord);
    Assert.assertFalse(list1.isEmpty());

    searchInputBO.setThirdInput(Consts.thirdInputWord);

      List<WebElement> list2 = mainPage.getListSkills();
      Assert.assertTrue(list2.size()==1);
  }

}
