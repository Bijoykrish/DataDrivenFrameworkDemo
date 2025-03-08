package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {
    @Test
    public void testLogin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://tutorialsninja.com/demo/");
            driver.findElement(By.xpath("//a[@title='My Account']")).click();
            driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
            driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("sdfdsf@gamil.com");
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("C5PmZ2Qz@DbdYz");
            driver.findElement(By.xpath("//input[@value='Login']")).click();
            Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
            System.out.println("Login test passed!"); // Add logging
        } finally {
            driver.quit();
        }
    }
}
