import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest1() {
        clickLoginLink();
        clickRegistrationButton();

        String email = generateEmail("user@gmail.de");
        fillInRegistrationForm("Vikla", "Viktorovich", email, "Qwertyui1!");
        click(By.xpath("//button[.='Зарегистрироваться']"));

        type(By.className("login_input__CsLCQ"), email);
        type(By.name("password"), "Qwertyui1!");
        click(By.xpath("//button[.='Войти']"));
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void createAccountNegativeTest1() {
        SoftAssert softAssert = new SoftAssert();

        clickLoginLink();
        clickRegistrationButton();
        String email = generateEmail("user@gmail.de");
        fillInRegistrationForm("Vikla", "Viktorovich", email, "Qwertyui1!");
        click(By.xpath("//button[.='Зарегистрироваться']"));

        type(By.className("login_input__CsLCQ"), email);
        type(By.name("password"), "Qwertyui1!");
        click(By.xpath("//button[.='Войти']"));

        softAssert.assertFalse(isAlertPresent());
        softAssert.assertTrue(isError409Present());
        softAssert.assertAll();
    }

}