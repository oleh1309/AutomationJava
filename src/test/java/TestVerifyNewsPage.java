import com.epam.businessObjects.AuthorizationBO;
import com.epam.pages.MainPage;
import com.epam.pages.NewsPage;
import com.epam.util.Consts;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestVerifyNewsPage extends MainConf {
  private NewsPage newsPage;
  private MainPage mainPage;
  private AuthorizationBO authorizationBO;


  @BeforeClass
  public void beforeClass() {
    authorizationBO = new AuthorizationBO();
    mainPage = new MainPage();
    newsPage = new NewsPage();
  }

  @Test(priority = 1)
  public void checkAuthorization() {
    authorizationBO.getAuthorization(Consts.email, Consts.password);
    Assert.assertEquals(authorizationBO.getCorrectResult().getUserInfo().isDisplayed(),true,
        "Test failed! User information doesnt displayed!");
  }

  @Test(priority = 2)
  public void checkNewsPage() {
    mainPage.clickNewsPage();
    Assert.assertEquals(newsPage.getMainTextNewsPage(),"NEWS","Test failed!");
    List<WebElement> listAllNews = newsPage.getListNews();
    listAllNews.forEach(element -> Assert.assertTrue(element.getText().contains("NEWS")||
            element.getText().contains("SUCCESS STORIES")||element.getText().contains("MATERIALS")||element.getText().contains("VIDEOS"),
        String.format("Element %s does not contain list of words.", element)));
    newsPage.clickNewsMaterial();
    List<WebElement> listMaterials = newsPage.getListMaterials();
    listMaterials.forEach(element -> Assert.assertTrue(element.getText().contains("Materials")||
            element.getText().contains("Useful"),
        String.format("Element %s does not contain list of word.", element)));
  }



}
