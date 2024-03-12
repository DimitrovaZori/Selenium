import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSite {

    @Test
    public void login(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();

        WebElement tshirt = driver.findElement(By.xpath("//*[contains(text(), 'Sauce Labs Backpack')]"));
        tshirt.click();
        WebElement button = driver.findElement(By.cssSelector("button[class ='btn_primary btn_inventory']"));
        button.click();
        WebElement path = driver.findElement(By.cssSelector("path[fill='currentColor']"));
        path.click();

        WebElement checkout = driver.findElement(By.cssSelector("a[class*='checkout']"));
        checkout.click();

        //Page details

        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipCode = driver.findElement(By.id("postal-code"));
        firstName.sendKeys("Zori");
        lastName.sendKeys("Dimitrova");
        zipCode.sendKeys("9000");

        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        submit.click();

        WebElement finish = driver.findElement(By.cssSelector("a[href*='checkout']"));
        finish.click();
    }
}
