import com.epam.businessObjects.AuthorizationBO;
import com.epam.util.Consts;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestIncorrectAuthorization extends MainConf {
  AuthorizationBO authorizationBO;

  @BeforeClass
  public void beforeClass() {
    authorizationBO = new AuthorizationBO();
  }

  @Test(priority = 2)
  public void checkAuthorization() {
    authorizationBO.getAuthorization(Consts.emailIncorrect, Consts.passwordIncorrect);
    authorizationBO.getIncorrectResult();

  }
}
