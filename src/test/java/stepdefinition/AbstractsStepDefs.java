package stepdefinition;

import com.mycompany.Environment;
import com.mycompany.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractsStepDefs {
    private static final int WAIT_TIME = 10;

    static WebDriver driver;

    protected static HomePage homePage;

    static  {
        driver = Environment.initializeDriver("chrome", "WIN10");
        homePage = new HomePage(driver);
    }
}
