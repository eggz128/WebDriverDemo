package uk.co.edgewords.webdriverdemo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helpers {
    //Field to hold driver
    WebDriver driver;

    //Constructor to set field - shortcut Alt-Ins
    //Runs when class is instantiated
    public Helpers(WebDriver driver) {
        this.driver = driver;
    }
    //Helper methods
    public WebElement waitForElementToBeClickable(By locator, int timeoutSeconds){
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return mywait.until(ExpectedConditions
                .elementToBeClickable(locator));
    }

    public void handleAlert(){
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println("Accepted alert with text: " + alertText);
    }
}
