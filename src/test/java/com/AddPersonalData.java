package com;

import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddPersonalData extends TestBase {
    private final String CONTACT_NAME = "TestName";

    @BeforeMethod
    public void preCondition() {
        login("milanaed@gmail.com", "Qwertyui1!");
    }

    @Tag("Positive")
    @Test(invocationCount = 1)
    public void addPersonalDataPositiveTest() {
        addNewContactPositiveData(CONTACT_NAME);
        Assert.assertTrue(isContactAdded(CONTACT_NAME), "Contact was not added successfully.");
    }
}
