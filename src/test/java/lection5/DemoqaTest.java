package lection5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
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
        driver.manage().window().maximize();


        driver.get("https://demoqa.com/automation-practice-form");

        WebElement selectState = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]").);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",selectState);
        selectState.click();
        selectState.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.id("firstName")).sendKeys("Olga");
        Thread.sleep(2000);
        driver.findElement(By.id("lastName")).sendKeys("Antsiferova");
        Thread.sleep(2000);
        driver.findElement(By.id("userEmail")).sendKeys("atlasnsk@mail.ru");
        Thread.sleep(2000);
        WebElement radioGender = driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[2]/label"));
        radioGender.click();
        Thread.sleep(2000);
        driver.findElement(By.id("userNumber")).sendKeys("9231844527");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).sendKeys(Keys.chord(Keys.SHIFT, Keys.CONTROL + "a"));
        Thread.sleep(2000);
        WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
        dateOfBirth.sendKeys("26 Nov 1983");
        dateOfBirth.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement hobbiesCheckbox = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
        hobbiesCheckbox.click();
        Thread.sleep(2000);
        WebElement sendSubject = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div"));
        sendSubject.click();
        sendSubject.sendKeys("Chemistry");
        sendSubject.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("[class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys("Chemistry");
        driver.findElement(By.className("ui-menu-item")).click();
        Thread.sleep(2000);




        driver.quit();
    }

    //  @AfterEach
    //  public void tearDown() {
    //   driver.quit();
    //}
}