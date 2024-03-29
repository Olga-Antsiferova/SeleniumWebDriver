package lection5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DemoqaTest {

    @BeforeEach
    public void setUp() {
        WebDriver driver = null;
        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @Test
    public void sendForm() {
        // WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        // driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("firstName")).sendKeys("Olga");
        driver.findElement(By.id("lastName")).sendKeys("Antsiferova");
        driver.findElement(By.id("userEmail")).sendKeys("atlasnsk@mail.ru");
        WebElement radioGender = driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[2]/label"));
        radioGender.click();
        driver.findElement(By.id("userNumber")).sendKeys("9231844527");
        driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).sendKeys(Keys.chord(Keys.SHIFT, Keys.CONTROL + "a"));
        WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
        dateOfBirth.sendKeys("26 Nov 1983");
        dateOfBirth.sendKeys(Keys.ENTER);
        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.sendKeys("Chemistry");
        subject.sendKeys(Keys.ENTER);
        WebElement hobbiesCheckbox = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
        hobbiesCheckbox.click();
        new File("src/2.jpg");
        driver.findElement(By.cssSelector("#uploadPicture")).sendKeys((new File("src/2.jpg").getAbsolutePath()));
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Novosibirsk");
        WebElement selectState = driver.findElement(By.id("react-select-3-input"));
        selectState.sendKeys("NCR");
        selectState.sendKeys(Keys.ENTER);
        WebElement selectCity = driver.findElement(By.id("react-select-4-input"));
        selectCity.sendKeys("Noida");
        selectCity.sendKeys(Keys.ENTER);
        driver.findElement(By.id("submit")).click();

        WebElement studentName = driver.findElement(By.xpath("//div[4]//tr[1]/td[2]"));
        String name = studentName.getText();
        Assertions.assertEquals("Olga Antsiferova", name);
        WebElement studentEmail = driver.findElement(By.xpath("//div[4]//tr[2]/td[2]"));
        String email = studentEmail.getText();
        Assertions.assertEquals("atlasnsk@mail.ru", email);
        WebElement studentGender = driver.findElement(By.xpath("//div[4]//tr[3]/td[2]"));
        String gender = studentGender.getText();
        Assertions.assertEquals("Female", gender);
        WebElement studentPhone = driver.findElement(By.xpath("//div[4]//tr[4]/td[2]"));
        String phone = studentPhone.getText();
        Assertions.assertEquals("9231844527", phone);
        WebElement studentBirth = driver.findElement(By.xpath("//div[4]//tr[5]/td[2]"));
        String birth = studentBirth.getText();
        Assertions.assertEquals("26 November,1983", birth);
        WebElement studentSubject = driver.findElement(By.xpath("//div[4]//tr[6]/td[2]"));
        String subjects = studentSubject.getText();
        Assertions.assertEquals("Chemistry", subjects);
        WebElement studentHobbie = driver.findElement(By.xpath("//div[4]//tr[7]/td[2]"));
        String hobbie = studentHobbie.getText();
        Assertions.assertEquals("Sports", hobbie);
        WebElement studentPicture = driver.findElement(By.xpath("//div[4]//tr[8]/td[2]"));
        String picture = studentPicture.getText();
        Assertions.assertEquals("2.jpg", picture);
        WebElement studentAdress = driver.findElement(By.xpath("//div[4]//tr[9]/td[2]"));
        String adress = studentAdress.getText();
        Assertions.assertEquals("Novosibirsk", adress);
        WebElement studentStateCity = driver.findElement(By.xpath("//div[4]//tr[10]/td[2]"));
        String stateCity = studentStateCity.getText();
        Assertions.assertEquals("NCR Noida", stateCity);
        //driver.quit();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}



