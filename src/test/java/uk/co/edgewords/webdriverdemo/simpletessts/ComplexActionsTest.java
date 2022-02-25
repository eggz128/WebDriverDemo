package uk.co.edgewords.webdriverdemo.simpletessts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import uk.co.edgewords.webdriverdemo.baseclass.TestBase;

import java.time.Duration;

public class ComplexActionsTest extends TestBase {
    @Test
    void dragdrop() throws InterruptedException {
        driver.get("https://edgewordstraining.co.uk/webdriver2/docs/cssXPath.html");
        WebElement gripper = driver.findElement(By.cssSelector(".ui-slider-handle"));

        Actions dragDrop = new Actions(driver);
        Action action = dragDrop.moveToElement(gripper)
                .clickAndHold() //hold left button on gripper
                .moveByOffset(100,0)
                .release()//release the mouse button
                .build();//

        action.perform();


        Thread.sleep(3000);
    }
}
