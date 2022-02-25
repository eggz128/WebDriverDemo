package uk.co.edgewords.webdriverdemo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelpersStatic {

    //Helper methods
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutSeconds){
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return mywait.until(ExpectedConditions
                .elementToBeClickable(locator));
    }

    public static void handleAlert(WebDriver driver){
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println("Accepted alert with text: " + alertText);
    }
}
