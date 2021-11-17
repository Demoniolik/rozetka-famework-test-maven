package SmokeTestSuite.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;

@Guice
public class BaseTest {

    private static final String HOME_PAGE_URL = "https://rozetka.com.ua/";
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        ChromeOptions caps = new ChromeOptions();
        caps.setCapability("browser", "chrome");
        driver = new RemoteWebDriver(new URL("http://192.168.0.108:4444/wd/hub"), caps);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 10000;
        open(HOME_PAGE_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
