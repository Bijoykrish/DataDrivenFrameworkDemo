package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Base {
    WebDriver driver= null;
    public Properties properties;
    public WebDriver openBrowserAndApplication(String browserName){
        properties = new Properties();
        File ProFile = new File("src/test/resources/data.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(ProFile);
            properties.load(fileInputStream);
        }catch (Throwable e){
            e.printStackTrace();
        }

        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
            
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();

            
        }else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
             driver = new EdgeDriver();

        }
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();

        return driver;


    }
}
