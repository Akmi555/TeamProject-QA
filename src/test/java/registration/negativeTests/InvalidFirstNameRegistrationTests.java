package registration.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import registration.TestBase;

public class InvalidFirstNameRegistrationTests extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(InvalidFirstNameRegistrationTests.class);

    private void navigateToRegistration() {
        logger.info("Переход на страницу регистрации");
        driver.findElement(By.xpath("//a[.='Личный кабинет']")).click();
        driver.findElement(By.xpath("//a[.='Регистрация']")).click();
    }

    @Test
    public void testInvalidEmailBrowserValidation() {
        logger.info("Тест: Регистрация с невалидным email и обработка браузерного предупреждения");
        navigateToRegistration();

        fillInputField(By.name("firstName"), "1");
        fillInputField(By.name("lastName"), "Smith");
        fillInputField(By.name("email"), "test@example.com");
        fillInputField(By.name("password"), "Qwerty1!");

        WebElement registerButton = driver.findElement(By.xpath("//button[.='Зарегистрироваться']"));
        registerButton.click();

    }

    @AfterMethod
    public void tearDown() {
        logger.info("Закрытие браузера");
        driver.quit();
    }
}