package pageObjects;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

        }
        @FindBy(xpath = "//a[@title='My Account']")
        private WebElement myAccountDropMenu;
        public void clickOnMyAccountDropMenu(){
               myAccountDropMenu.click();
    }

    @FindBy(xpath = "//a[normalize-space()='Login']")
    private WebElement loginOption;
        public LoginPage selectLoginOption(){
            loginOption.click();
            return new LoginPage(driver);

        }

}
