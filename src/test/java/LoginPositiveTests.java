import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPositiveTests extends TestBase {

    @Test
    public void loginExistedUserPositiveTest() {
        clickLoginLink();
        login("or121rrovishnik@gmail.de", "Qwertyui1!");
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginExistedUserPositiveTest2() {
        login("or121rrovishnik@gmail.de", "Qwertyui1!");
    }
}
