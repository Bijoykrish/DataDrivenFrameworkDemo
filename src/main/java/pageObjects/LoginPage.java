package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class LoginPage {

    public  WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    private static WebElement emailAddressField;
    @FindBy(xpath = "//input[@id='input-password']")
    private static WebElement passwordField;
    @FindBy(xpath = "//input[@value='Login']")
    private static WebElement LoginButton;


    public static void enterEmailAddress(String emailText){
        emailAddressField.sendKeys(emailText);
    }
    public static void enterPassword(String passwordText){
        passwordField.sendKeys(passwordText);
    }
    public  AccountPage clickOnLoginButton(){
        LoginButton.click();
        return new AccountPage(driver);

    }


}
