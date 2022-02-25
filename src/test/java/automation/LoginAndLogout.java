package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAndLogout {
    public static void main(String[] args) {
        //Fetch ChromeDriver
        WebDriverManager.chromedriver().setup();
        //Instantiate browser
        WebDriver driver = new ChromeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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

        //Click submit "button"
        driver.findElement(By.linkText("Submit")).click();
        //Wait for Log Out link
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement logoutLink = mywait.until(ExpectedConditions
                            .elementToBeClickable(By.linkText("Log Out")));
        //Click Log Out link
        logoutLink.click();

        //Close the browser
        driver.quit();
    }
}
