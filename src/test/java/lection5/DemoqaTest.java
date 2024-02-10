package lection5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoqaTest {

    // @BeforeEach
    //  public void setup() {
    //      WebDriver driver = null;
    //      String browser = System.getProperty("browser");

    //     if (browser.equals("chrome")) {
    //         WebDriverManager.chromedriver().setup();
    //         driver = new ChromeDriver();
    //     } else if (browser.equals("firefox")) {
    //          WebDriverManager.firefoxdriver().setup();
    //         driver = new FirefoxDriver();
    //     } else if (browser.equals("edge")) {
    //        WebDriverManager.edgedriver().setup();
    //     driver = new EdgeDriver();
    // }
    //  driver.get("https://demoqa.com/automation-practice-form");
    //  driver.manage().window().maximize();
    //  }

    @Test
    public void sendForm() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Olga");
        Thread.sleep(2000);
        driver.findElement(By.id("lastName")).sendKeys("Antsiferova");
        Thread.sleep(2000);
        driver.findElement(By.id("userEmail")).sendKeys("atlasnsk@mail.ru");
        Thread.sleep(2000);
        driver.findElement(By.id("userNumber")).sendKeys("9231844527");
        Thread.sleep(2000);
       // driver.findElement(By.cssSelector("[class = 'subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys("Chemistry");
        //Thread.sleep(2000);
        driver.findElement(By.id("currentAddress")).sendKeys("Novosibirsk");
        Thread.sleep(2000);
        driver.findElement(By.id("hobbies-checkbox-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("gender-radio-2")).click();
        Thread.sleep(2000);
        driver.quit();
    }

    //  @AfterEach
    //  public void tearDown() {
    //   driver.quit();
    //}
}