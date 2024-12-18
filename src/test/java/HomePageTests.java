
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
    public void isHomeComponentPresentTest () {
        Assert.assertTrue(isHomeComponentPresent(), "HomeComponent is not present");
        System.out.println("isHomeComponentPresent найден на домашней страниц");
    }

    public boolean isHomeComponentPresent() {
        System.out.println("Ищем компонент HomeComponent на домашней странице");
        return isElementPresent(By.xpath("//h2[.='Экскурсии']"));
    }

}