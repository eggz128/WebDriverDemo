package uk.co.edgewords.webdriverdemo.simpletessts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SelIDEJunit5 {

    WebDriver driver;
    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
    @Test
    void selIDETest(){
        // Test name: SelIDEDemo
        // Step # | name | target | value
        // 1 | open | /webdriver2/ |
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        // 2 | setWindowSize | 974x1003 |
        driver.manage().window().setSize(new Dimension(974, 1003));
        driver.manage().window().maximize();
        // 3 | click | css=.last span |
        driver.findElement(By.cssSelector(".last span")).click();
        // 4 | click | css=li:nth-child(3) span |
        driver.findElement(By.cssSelector("li:nth-child(3) span")).click();
        // 5 | click | id=textInput |
        driver.findElement(By.id("textInput")).click();
        // 6 | type | id=textInput | steve powell
        driver.findElement(By.id("textInput")).sendKeys("steve powell");
        // 7 | click | id=textArea |
        driver.findElement(By.id("textArea")).click();
        // 8 | click | id=textArea |
        driver.findElement(By.id("textArea")).click();
        // 9 | type | id=textArea | was\nhere\n
        driver.findElement(By.id("textArea")).sendKeys("was\nhere\n");
        // 10 | click | id=checkbox |
        driver.findElement(By.id("checkbox")).click();
        // 11 | click | id=select |
        driver.findElement(By.id("select")).click();
        // 12 | select | id=select | label=Selection Two
        {
            WebElement dropdown = driver.findElement(By.id("select"));
            dropdown.findElement(By.xpath("//option[. = 'Selection Two']")).click();
        }
        // 13 | click | id=two |
        driver.findElement(By.id("two")).click();
        // 14 | click | linkText=Submit |
        driver.findElement(By.linkText("Submit")).click();
        // 15 | click | css=tr:nth-child(2) > td:nth-child(3) |
        driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).click();
        // 16 | assertText | id=textInputValue | steve powell
        assertThat(driver.findElement(By.id("textInputValue")).getText(), is("steve powell"));
        // 17 | click | css=tr:nth-child(3) > td:nth-child(3) |
        driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(3)")).click();
        // 18 | verifyText | id=textAreaValue | was here
        assertThat(driver.findElement(By.id("textAreaValue")).getText(), is("was here"));
    }
}
