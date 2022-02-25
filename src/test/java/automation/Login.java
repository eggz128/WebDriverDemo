package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Login {
    public static void main(String[] args) {
        //Fetch ChromeDriver
        WebDriverManager.chromedriver().setup();
        //Instantiate browser
        WebDriver driver = new ChromeDriver();
        //Navigate to a URL
        driver.get("http://www.edgewordstraining.co.uk/webdriver2/");

        //Find and click a link all in one step
        driver.findElement(By.linkText("Login To Restricted Area")).click();



        //Fill in username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("edgewords");
        //Fill in password using relative locator
        WebElement passwordField = driver.findElement(
                RelativeLocator.with(By.tagName("input"))
                        .below(usernameField));
        passwordField.sendKeys("edgewords123");
        //Close the browser
        driver.quit();
    }
}
