import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddPersonalData extends TestBase {
    private final String CONTACT_NAME = "TestName";


    @BeforeMethod
    public void precondition() {
        login("milanaed@gmail.com", "Qwertyui1!");
    }

    @Tag("Positive")
    @Test(invocationCount = 1)
    public void addPersonalDataPositiveTest() {
        addNewContactPositiveData(CONTACT_NAME);
        Assert.assertTrue(isContactAdded(CONTACT_NAME), "Contact was not added successfully.");
    }

    private boolean isContactAdded(String textToFind) {
        List<WebElement> contacts = driver.findElements(By.xpath("//a[contains(text(),'Назад')]"));
        for (WebElement element : contacts) {
            if (element.getText().contains(textToFind)) {
                return false;
            }
        }
        return true;
    }

        private void addNewContactPositiveData(String name) {
        click(By.className("AccountManagement_editButton__JuMEZ"));
        click(By.xpath("//button[.='Изменить']"));

        click(By.xpath("//tbody/tr[1]/td[1]/input[1]"));
        type((By.xpath("//tbody/tr[1]/td[1]/input[1]")),"Milana");

        click(By.xpath("//table[@class='AccountDetails_table__TnerJ']"));
        type((By.xpath("//tbody/tr[2]/td[1]/input[1]")), "Vitalievna");

        click(By.xpath("//tbody/tr[3]/td[1]/input[1]"));
        type((By.xpath("//tbody/tr[3]/td[1]/input[1]")), "milanaed@gmail.com");

        click(By.xpath("//button[.='Сохранить']"));
        click(By.xpath("//a[.='Назад']"));

    }


}
