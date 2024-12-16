package registrationAndindeElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementMain {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setPosition(new Point(2500, 0));
        driver.manage().window().maximize();
    }

    @Test
    public void findElementsByTagName() {
        WebElement findElementsByXpathFirstName = driver.findElement(new By.ByXPath("//button[.='Хочу тур']"));
        WebElement findElementByTagName = driver.findElement(By.tagName("h2"));
        System.out.println(findElementsByXpathFirstName.getText());
        WebElement driverElementIMG = driver.findElement(By.tagName("img"));
        System.out.println(driverElementIMG.getSize());


        List<WebElement> elementsList = driver.findElements(By.tagName("a"));
        System.out.println("Size of List: " + elementsList.size());
        System.out.println("Text of Element #5: " + elementsList.get(5).getText());
        for (WebElement element : elementsList) {
            System.out.println(element.getAttribute("href"));
            System.out.println(element.getText());
        }
    }

    @Test
    public void testFindElementByLocator() {
    driver.findElement(By.xpath("//*[.='КРИСТАЛЬНАЯ ЧИСТОТА НОМЕРОВ']"));
    }

    @Test
    public void FindElementByXpathBackCool() {
        driver.findElement(By.xpath("//*[.='Обратный звонок']"));
    }
    @Test
    public void siblingTests(){
        driver.findElement(By.xpath("//a[.='ТУРЫ']"));
    }

    @Test
    public void siblingTests2(){
        driver.get("http://localhost:3000/tours");
        driver.findElement(By.xpath("//*[@class='Header_headerBtnLink__Z3Rrs' and text()='Хочу тур']"));
        driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[1]/select[1]"));

        //driver.findElement(By.xpath("//*[.='Рейтинг: по убыванию')]"));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();

    }
}
