package registration.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import registration.TestBase;

public class InvalidEmailRegistrationTests extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(InvalidEmailRegistrationTests.class);

    private void navigateToRegistration() {
        logger.info("Переход на страницу регистрации");
        driver.findElement(By.xpath("//a[.='Личный кабинет']")).click();
        driver.findElement(By.xpath("//a[.='Регистрация']")).click();
    }

    @Test
    public void testInvalidEmailBrowserValidation() {
        logger.info("Тест: Регистрация с невалидным email и обработка браузерного предупреждения");
        navigateToRegistration();

        fillInputField(By.name("firstName"), "John");
        fillInputField(By.name("lastName"), "Smith");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.clear();
        emailField.sendKeys("invalid_email");

        WebElement registerButton = driver.findElement(By.xpath("//button[.='Зарегистрироваться']"));
        registerButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String emailValidity = (String) js.executeScript("return arguments[0].validationMessage;", emailField);

        logger.info("Сообщение браузера: {}", emailValidity);

        Assert.assertTrue(emailValidity.contains("должен содержать символ \"@\""), "Сообщение браузера о некорректном email отсутствует или некорректно.");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Закрытие браузера");
        driver.quit();
    }
}