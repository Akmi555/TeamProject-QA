package com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
    public void isHomeComponentPresentTest () {
        Assert.assertTrue(isHomeComponentPresent(), "HomeComponent is not present");
        System.out.println("isHomeComponentPresent найден на домашней страниц");
    }

}