import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest1() {
        clickLoginLink();
        clickRegistrationButton();

        fillInRegistrationForm("Vikla", "Viktorovich", "or121rrrovishnik@gmail.de", "Qwertyui1!");
        click(By.xpath("//button[.='Зарегистрироваться']"));

        type(By.className("login_input__CsLCQ"), "or121rrrovishnik@gmail.de");
        type(By.name("password"), "Qwertyui1!");
        click(By.xpath("//button[.='Войти']"));
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void createAccountPositiveTest2() {
        register("or121rrovrishnik@gmail.de", "Qwertyui1!");
    }

    @Test
    public void createAccountLoginPositiveTest2() {
        register("or121112rrovrishnik@gmail.de", "Qwertyui1!");
        logout();
        login("or121112rrovrishnik@gmail.de", "Qwertyui1!");
    }

    @Test
    public void createAccountNegativeTest1() {
        SoftAssert softAssert = new SoftAssert();

        clickLoginLink();
        clickRegistrationButton();
        fillInRegistrationForm("Vikla", "Viktorovich", "admintruee6@gmail.de", "Qwertyui1!");
        click(By.xpath("//button[.='Зарегистрироваться']"));

        type(By.className("login_input__CsLCQ"), "admintruee6@gmail.de");
        type(By.name("password"), "Qwertyui1!");
        click(By.xpath("//button[.='Войти']"));

        softAssert.assertFalse(isAlertPresent());
        softAssert.assertTrue(isError409Present());
        softAssert.assertAll();
    }

}
