package com;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(2500, 0));
        driver.get("https://lionfish-app-3k7kf.ondigitalocean.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By locator) {
        System.out.println("Проверка элемента [" + locator + "] на странице");
        return driver.findElements(locator).size() > 0;
    }

    protected void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void login(String email, String password) {
        click(By.xpath("//a[.='Личный кабинет']"));
        type(By.className("login_input__CsLCQ"), email);
        type(By.name("password"), password);
        click(By.xpath("//button[.='Войти']"));
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='Выйти из аккаунта']")));
    }

    protected void register(String email, String password) {
        click(By.xpath("//a[.='Личный кабинет']"));
        click(By.xpath("//a[.='Регистрация']"));

        type(By.name("firstName"), "Vikla");
        type(By.name("lastName"), "Viktorovich");
        type(By.name("email"), email);
        type(By.name("password"), password);
        click(By.xpath("//button[.='Зарегистрироваться']"));

        type(By.className("login_input__CsLCQ"), "or121rrovishnik@gmail.de");
        type(By.name("password"), "Qwertyui1!");
        click(By.xpath("//button[.='Войти']"));

        Assert.assertTrue(isElementPresent(By.xpath("//a[.='Выйти из аккаунта']")));
    }

    protected void logout() {
        click(By.xpath("//a[.='Выйти из аккаунта']"));
    }

    protected void fillInRegistrationForm(User user) {
        type(By.name("firstName"), user.firstName());
        type(By.name("lastName"), user.lastName());
        type(By.name("email"), user.email());
        type(By.name("password"), user.password());
    }

    protected void clickRegistrationButton() {
        click(By.xpath("//a[.='Регистрация']"));
    }

    protected void clickLoginLink() {
        click(By.xpath("//a[.='Личный кабинет']"));
    }

    protected boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//a[.='Выйти из аккаунта']"));
    }

    protected void clickOnLoginButton() {
        click(By.xpath("//button[.='Войти']"));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    protected boolean isError409Present() {
        return isElementPresent(By.xpath("//h2[.='Управление аккаунтом']"));
    }

    protected boolean isAlertPresent() {
        try {
            Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
            if (alert == null) {
                return false;
            } else {
                driver.switchTo().alert().accept();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isContactAdded(String textToFind) {
        List<WebElement> contacts = driver.findElements(By.xpath("//a[contains(text(),'Назад')]"));
        for (WebElement element : contacts) {
            if (element.getText().contains(textToFind)) {
                return false;
            }
        }
        return true;
    }

    protected void addNewContactPositiveData(String name) {
        clickAddLink();
        fillInNewContactForm(
                "Vitalievna",
                "Milana",
                "milanaed@gmail.com");
        clickSaveContact();

    }

    private void clickSaveContact() {
        click(By.xpath("//button[.='Сохранить']"));
        click(By.xpath("//a[.='Назад']"));
    }

    private void clickAddLink() {
        click(By.className("AccountManagement_editButton__JuMEZ"));
        click(By.xpath("//button[.='Изменить']"));
    }

    private void fillInNewContactForm(String firstName, String lastName, String email) {
        click(By.xpath("//tbody/tr[1]/td[1]/input[1]"));
        type((By.xpath("//tbody/tr[1]/td[1]/input[1]")), firstName);

        click(By.xpath("//table[@class='AccountDetails_table__TnerJ']"));
        type((By.xpath("//tbody/tr[2]/td[1]/input[1]")), lastName);

        click(By.xpath("//tbody/tr[3]/td[1]/input[1]"));
        type((By.xpath("//tbody/tr[3]/td[1]/input[1]")), email);
    }

    protected void eddFildFirstName() {
        login("admintrue@gmail.de", "Qwertyui1!");
        click(By.className("AccountManagement_editButton__JuMEZ"));
        click(By.xpath("//button[.='Изменить']"));
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).clear();
        click(By.xpath("//button[.='Сохранить']"));
        click(By.xpath("//a[.='Назад']"));
    }
    protected String generateEmail(String baseEmail) {
        long timestamp = Instant.now().toEpochMilli();
        return baseEmail.replace("@", "+" + timestamp + "@");
    }

    public boolean isHomeComponentPresent() {
        System.out.println("Ищем компонент HomeComponent на домашней странице");
        return isElementPresent(By.xpath("//h2[.='Экскурсии']"));
    }
}