import static com.epam.util.Configuration.getConfiguration;
import static com.epam.util.WebDriverConfig.closeDriver;
import static com.epam.util.WebDriverConfig.getDriver;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MainConf {

  WebDriverWait wait = new WebDriverWait(getDriver(), 30);

  @BeforeTest
  public void beforeSuite() {
    wait.withTimeout(Duration.ofSeconds(30));
    getDriver().get(getConfiguration().getValue("url"));

  }

  @AfterTest
  public void afterSuite() {
    closeDriver();
  }

}
