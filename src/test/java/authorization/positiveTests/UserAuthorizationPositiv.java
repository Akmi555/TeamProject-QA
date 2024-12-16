package authorization.positiveTests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import registration.TestBase;

public class UserAuthorizationPositiv extends TestBase  {

    @Test
public void LoginPositiveTests (){
    driver.findElement(By.xpath("//a[.='Личный кабинет']")).click();
    fillInputField(By.name("email"), "email743111@gmail.com");
    fillInputField(By.name("password"), "Qwerty1!");

    driver.findElement(By.xpath("//button[.='Войти']")).click();
    driver.findElement(By.xpath("//*[.='Выйти из аккаунта']")).click();

}

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}