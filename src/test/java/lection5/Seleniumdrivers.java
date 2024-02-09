package lection5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager

public class Seleniumdrivers {

   @Test
    public void openHerokuChromeTest {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        driver.quit();
    }

    @Test
    public void HerokuChromeTest {
     WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();

     driver.get("https://the-internet.herokuapp.com/");
     driver.manage().window().maximize();
    }
}

