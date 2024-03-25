import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class MainTest {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();

    }

    @Test
    //find elements, sendKeys, boolean -column One

    public void testOpenBrowser() throws InterruptedException {

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.findElement(By.name("my-text")).sendKeys("Hello");
        driver.findElement(By.name("my-password")).sendKeys("Here we go");
        Thread.sleep(200);
        driver.findElement(By.name("my-textarea")).sendKeys("Repeat once again");
        Thread.sleep(200);
        boolean enable = driver.findElement(By.name("my-disabled")).isEnabled();
        assertEquals(enable,false);

    }

    @Test
    //select and uploading file

    public void columnTwo() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        Select selection = new Select(driver.findElement(By.cssSelector(".form-select")));
        selection.selectByValue("1");

        List<WebElement> lists = driver.findElements(By.name("my-datalist"));
        for (WebElement list : lists) {
            System.out.println(list.getAttribute("value"));

        }

        WebElement chooseFile = driver.findElement(By.cssSelector("input[type='file']"));
        File uploadFile = new File("src/test/resources/workweek.jpg");
        chooseFile.sendKeys(uploadFile.getAbsolutePath());
    }

    @Test
    //Assert for button Submit

    public void submitButton() {

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        String content = submitButton.getAttribute("textContent");
        assertEquals(content, "Submit");
        String color = submitButton.getCssValue("color");
        assertEquals(color, "rgba(13, 110, 253, 1)");
        System.out.println("Name of the button is " + content + " and the color is " + color);
        submitButton.click();

        System.out.println(driver.findElement(By.className("display-6")).getText());

    }

        @Test
        //Color Picker
        public void colorPicker(){
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            WebElement picker = driver.findElement(By.name("my-colors"));
            picker.click();
            Actions moveSlider = new Actions(driver);
            moveSlider.clickAndHold(picker).moveByOffset(100,50).perform();

        }

    @Test
    public void dataTable() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement editFrank = driver.findElement(By.xpath("//table[@id='table1']//tr[contains(text(), Frank)]/td/a[contains(text(), 'edit')]"));
       // WebElement editFrank = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[6]/a[1]"));
        editFrank.click();
        }

    

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
