package registration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://lionfish-app-3k7kf.ondigitalocean.app/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setPosition(new Point(2500, 0));
        driver.manage().window().maximize();
    }

    protected boolean isElementPresent(By locator) {
        System.out.println("Проверка элемента: " + locator);
        return driver.findElements(locator).size() > 0;
    }

    protected void fillInputField(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}