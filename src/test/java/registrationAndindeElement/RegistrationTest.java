package registrationAndindeElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/registration");
        driver.manage().window().setPosition(new Point(2500, 0));
                driver.manage().window().maximize();
    }

    @Test
    public void testSuccessfulRegistration() {
        // Проверка открытия страницы
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
            driver.quit();

        }

}