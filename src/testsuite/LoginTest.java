package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";    //Defining variable to store Url

    @Before
    public void setUp() {                            //Method to open browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Adding implicit time
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Finding element and storing to variable for username
        WebElement emailField = dr.findElement(By.id("user-name"));

        //Sending text to username field
        emailField.sendKeys("standard_user");

        //Finding element for password and storing it to variable
        WebElement password = dr.findElement(By.id("password"));

        //Sending text to password field
        password.sendKeys("secret_sauce");

        //Find element using xpath and click on login button
        WebElement loginLink1 = dr.findElement(By.xpath("//input[@id='login-button']"));
        loginLink1.click();

        //Expected text on webpage
        String expectedMessage = "PRODUCTS";

        //Finding the text and storing to variable
        WebElement actualTextElement = dr.findElement(By.xpath("//span[contains(text(), 'Products')]"));

        //Storing value for text to variable from webpage
        String actualMessage = actualTextElement.getText();

        //Comparing both the text and printing result in console
        Assert.assertEquals("Invalid name", expectedMessage, actualMessage);

        dr.close();
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        WebElement emailField = dr.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        WebElement password = dr.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginLink1 = dr.findElement(By.xpath("//input[@id='login-button']"));
        loginLink1.click();
        List<WebElement> sliderElementList = dr.findElements(By.xpath("//div[@class='inventory_item_img']"));
        System.out.println("Total images are : " + sliderElementList.size());

        dr.close();
    }

}
