package testTopic;

import extentreports.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import logs.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void setUp(){
        // Driver Chrome
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        Log.info("Setup the browser");
        // Start in Chrome
        ChromeOptions chrome = new ChromeOptions();
        chrome.setAcceptInsecureCerts(true);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chrome);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log.info("Browser is opening");
        driver.get("https://bspdev.adlsandbox.com/auth/login");
        driver.manage().window().maximize();
    }

   // @AfterClass
    //public void getResult(){
    //    driver.quit();
    //}

    @AfterSuite
    public void tearDown(){
        ExtentManager.extentReports.flush();
    }
}
