import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.*;

public class SetUp {
    WebDriver driver = null;
    Properties prop;
    String configPath = "configuration.properties";
    SearchPage searchPage = new SearchPage();
    RelatedActions relatedActions = new RelatedActions();

    @BeforeTest
    //@Parameters("browser") /* If you want to use testng.xml file pass browser argument in open()
    // ,in switch() and comment the reading from config file lines (25-27)
    public void Open() throws Exception {
        prop = new Properties();
        InputStream input = new FileInputStream(configPath);
        prop.load(input);

        switch (prop.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
            driver.manage().window().maximize();
            driver.navigate().to(relatedActions.readFile(0, 0));
            searchPage.SearchText(driver, relatedActions.readFile(1, 0));
            searchPage.clickSearchIcon(driver);


    }

    @AfterTest
    //@Parameters("browser")
    public void Close() throws IOException {
        prop = new Properties();
        InputStream input = new FileInputStream(configPath);
        prop.load(input);
        relatedActions.screenShots(driver, prop.getProperty("browser"));
        driver.close();
    }
}
