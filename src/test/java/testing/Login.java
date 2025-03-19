package testing;

import Base.Base;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import util.DataUtil;
import util.MyXLSReader;

import java.util.HashMap;

public class Login extends Base {
    WebDriver driver= null;
    MyXLSReader excelReader = null;
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(dataProvider = "dataProvider")
    public void testLogin(HashMap<String,String> hmap ) throws InterruptedException {
        if (!DataUtil.isRunnable(excelReader,"Login","Testcases" )|| hmap.get("Runmode").equals("N")){
            throw new SkipException("Run mode is set to N, hence not executed");

        }

        driver= openBrowserAndApplication(hmap.get("Browser"));
        HomePage homePage = new HomePage(driver);

        //driver.findElement(By.xpath("//a[@title='My Account']")).click();
        homePage.clickOnMyAccountDropMenu();
        //driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        homePage.selectLoginOption();
       // driver.findElement(By.xpath("//input[@id=('input-email')]")).sendKeys(hmap.get("Username"));
        //LoginPage loginPage = new LoginPage(driver); made in the homepage
        Thread.sleep(3000);
        LoginPage.enterEmailAddress(hmap.get("Username"));
        //driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(hmap.get("Password"));
        LoginPage.enterPassword(hmap.get("Password"));

        //driver.findElement(By.xpath("//input[@value='Login']")).click();
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = loginPage.clickOnLoginButton();

        String expectedResult = hmap.get("ExpectedResult");
        boolean expectedConvertedResult = false;
        if (expectedResult.equalsIgnoreCase("Success")){
            expectedConvertedResult = true;

        } else if (expectedResult.equalsIgnoreCase("Failure")) {
          expectedConvertedResult = false;
        }
        boolean actualResult = false;

            actualResult = accountPage.verifyTheDisplayOfEditYourAccountInformationOption();


        Assert.assertEquals(actualResult, expectedConvertedResult);
        }


        //Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());



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
