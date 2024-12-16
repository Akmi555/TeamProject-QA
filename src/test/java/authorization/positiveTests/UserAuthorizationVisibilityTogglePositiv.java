package authorization.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import registration.TestBase;

import static org.testng.AssertJUnit.assertEquals;
import java.time.Duration;

public class UserAuthorizationVisibilityTogglePositiv extends TestBase {

    @Test
    public void LoginPositiveTests() {
        driver.findElement(By.xpath("//a[.='Личный кабинет']")).click();
        fillInputField(By.name("email"), "email743111@gmail.com");
        fillInputField(By.name("password"), "Qwerty1!");

        WebElement passwordField = driver.findElement(By.name("password"));
        assertEquals("Пароль не скрыт.", "password", passwordField.getAttribute("type"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement eyeIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'login_icon__m9SZ6')]")));

        assertEquals("Глазик не видим.", true, eyeIcon.isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", eyeIcon);

        wait.until(ExpectedConditions.attributeToBe(passwordField, "type", "text"));

        assertEquals("Пароль не стал видимым.", "text", passwordField.getAttribute("type"));

        js.executeScript("arguments[0].click();", eyeIcon);

        wait.until(ExpectedConditions.attributeToBe(passwordField, "type", "password"));

        assertEquals("Пароль снова не скрыт.", "password", passwordField.getAttribute("type"));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}