package registration.negativeTests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import registration.TestBase;

import java.time.Duration;

public class DuplicateEmailTests extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(DuplicateEmailTests.class);

    private void navigateToRegistration() {
        logger.info("Переход на страницу регистрации");
        driver.findElement(By.xpath("//a[.='Личный кабинет']")).click();
        driver.findElement(By.xpath("//a[.='Регистрация']")).click();
    }

    @Test
    public void testDuplicateEmailRegistration() {
        logger.info("Тест: Регистрация с дублирующим email");
        navigateToRegistration();

        fillInputField(By.name("firstName"), "John");
        fillInputField(By.name("lastName"), "Smith");
        fillInputField(By.name("email"), "email7431@gmail.com");
        fillInputField(By.name("password"), "Qwerty1!");

        driver.findElement(By.xpath("//button[.='Зарегистрироваться']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Email уже зарегистрирован')]")
        ));
        Assert.assertTrue(errorMessage.isDisplayed(), "Сообщение об ошибке для дублирующего email отсутствует");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Закрытие браузера");
        driver.quit();
    }
}
