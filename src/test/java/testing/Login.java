package testing;

import Base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.DataUtil;
import util.MyXLSReader;

import java.io.IOException;
import java.util.HashMap;

public class Login extends Base {
    WebDriver driver= null;
    MyXLSReader excelReader = null;
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(dataProvider = "dataProvider")
    public void testLogin(HashMap<String,String> hmap ){
        if (!DataUtil.isRunnable(excelReader,"Login","Testcases" )|| hmap.get("Runmode").equals("N")){
            throw new SkipException("Run mode is set to N, hence not executed");

        }

        driver= openBrowser(hmap.get("Browser"));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        //Password- C5PmZ2Qz@DbdYz
        //email - sdfdsf@gamil.com
        driver.findElement(By.xpath("//input[@id=('input-email')]")).sendKeys(hmap.get("Username"));
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(hmap.get("Password");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());



   }
    @DataProvider
    public Object[][] dataProvider() {

        Object[][] data = null;
        try {
            excelReader = new MyXLSReader("src/test/resources/TutorialsNinja.xlsx");
            data = DataUtil.getTestData(excelReader, "Login", "Data");
        } catch (Throwable e) {
            e.printStackTrace();
        }


        return data;
    }
}
