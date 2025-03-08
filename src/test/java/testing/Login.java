package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver= null;
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(dataProvider = "dataProvider")
    public void testLogin(String email, String password){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        //Password- C5PmZ2Qz@DbdYz
        //email - sdfdsf@gamil.com
        driver.findElement(By.xpath("//input[@id=('input-email')]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());



   }
    @DataProvider
    public Object[][] dataProvider(){
        Object[][] data = {{"sdfdsf@gamil.com","C5PmZ2Qz@DbdYz"},
                           {"abcd123465@gamil.com","pAyw@gK4ZbX5M@"},
                           {"hibijoy123@gamil.com","ax@m8RkryPprph"}};
        return data;


    }
}
