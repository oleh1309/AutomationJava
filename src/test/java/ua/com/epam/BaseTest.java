package ua.com.epam;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ua.com.epam.core.rest.RestClient;
import ua.com.epam.service.AuthorService;
import ua.com.epam.service.CleanUpService;
import ua.com.epam.utils.DataFactory;
import ua.com.epam.utils.helpers.LocalDateAdapter;

import java.time.LocalDate;
import ua.com.epam.validation.TestValidation;

public class BaseTest {
    //to parse JSON String to needed model (with correct date parsing possibility)
    protected TestValidation testValidation;
    protected Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
    protected AuthorService authorService;
    protected RestClient client = new RestClient();
    protected DataFactory testData = new DataFactory();
    protected CleanUpService clean = new CleanUpService(client);

    //don't delete this!!!
    @BeforeClass
    public void reinitialize() {

        client = new RestClient();
        testData = new DataFactory();
        clean = new CleanUpService(client);
        authorService = new AuthorService();
        testValidation = new TestValidation(client);
    }

    @AfterClass
    public void afterMethod() {
        clean.authors();
        clean.books();
        clean.genres();
    }

}
