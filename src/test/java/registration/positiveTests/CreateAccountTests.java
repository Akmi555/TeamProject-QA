package registration.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import registration.TestBase;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateAccountTests extends TestBase {

    private String generateUniqueEmail() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        return "user_" + timestamp + "@test.com";
    }

    @Test
    public void testSuccessfulRegistration() {
        driver.findElement(By.xpath("//a[.='Личный кабинет']")).click();
        driver.findElement(By.xpath("//a[.='Регистрация']")).click();

        fillInputField(By.name("firstName"), "John");
        fillInputField(By.name("lastName"), "Smith");

        String uniqueEmail = generateUniqueEmail();
        fillInputField(By.name("email"), uniqueEmail);

        fillInputField(By.name("password"), "Qwerty1!");

        driver.findElement(By.xpath("//button[.='Зарегистрироваться']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement forgotPasswordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Забыли пароль?']")));

        Assert.assertTrue(forgotPasswordElement.isDisplayed(), "Элемент 'Забыли пароль?' не найден");
    }


    @AfterMethod(enabled = false)
    public void tearDown() {
            driver.quit();
    }
}