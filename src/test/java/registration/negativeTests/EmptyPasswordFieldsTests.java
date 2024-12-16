package registration.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import registration.TestBase;

public class EmptyPasswordFieldsTests extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(EmptyPasswordFieldsTests.class);

    private void navigateToRegistration() {
        logger.info("Переход на страницу регистрации");
        driver.findElement(By.xpath("//a[.='Личный кабинет']")).click();
        driver.findElement(By.xpath("//a[.='Регистрация']")).click();
    }

    @Test
    public void testEmptyFieldsRegistration() {
        logger.info("Тест: Регистрация с пустыми полями");
        navigateToRegistration();

        fillInputField(By.name("firstName"), "Smith");
        fillInputField(By.name("lastName"), "Smith");
        fillInputField(By.name("email"), "test@example.com");

        driver.findElement(By.xpath("//button[.='Зарегистрироваться']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String errorMessage = (String) js.executeScript("return document.querySelector('input:invalid') ? document.querySelector('input:invalid').validationMessage : '';");

        logger.info("Сообщение об ошибке: {}", errorMessage);
        Assert.assertTrue(errorMessage.contains("Заполните это поле"), "Сообщение об ошибке не найдено или некорректно.");

    }

    @AfterMethod
    public void tearDown() {
        logger.info("Закрытие браузера");
        driver.quit();
    }
}