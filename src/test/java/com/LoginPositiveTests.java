package com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPositiveTests extends TestBase {

    @Test
    public void loginExistedUserPositiveTest() {
        clickLoginLink();
        login("admintrue@gmail.de", "Qwertyui1!");
        Assert.assertTrue(isSignOutButtonPresent());
        logout();
    }

    @Test
    public void loginExistedUserPositiveTest2() {
        login("admintrue@gmail.de", "Qwertyui1!");
    }
}
