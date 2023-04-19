package browserfactory;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver dr;                              //Defining variable

    public void openBrowser(String baseUrl) {                    //Defined method to Open Url
        dr = new ChromeDriver();                             //Storing the Browser driver to variable
        dr.get(baseUrl);                                     //Get Url
        dr.manage().window().fullscreen();                   //Maximize Screen
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));   //implicit wait
    }
    @After
    public void closeBrowser() {
        dr.quit();                                            //close all browser
    }
}
