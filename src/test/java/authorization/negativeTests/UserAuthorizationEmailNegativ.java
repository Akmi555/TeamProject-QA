package authorization.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import registration.TestBase;

import java.time.Duration;

public class UserAuthorizationEmailNegativ extends TestBase  {

    @Test
public void LoginPositiveTests (){
    driver.findElement(By.xpath("//a[.='Личный кабинет']")).click();

    fillInputField(By.name("email"), "email7@gmail.com");
    fillInputField(By.name("password"), "Qwerty1!");

        driver.findElement(By.xpath("//button[.='Войти']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Неверный email или пароль')]")
        ));

        Assert.assertTrue(errorMessage.isDisplayed(), "Сообщение об ошибке не отображается");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}