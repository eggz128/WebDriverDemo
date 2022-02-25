package uk.co.edgewords.webdriverdemo.simpletessts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import uk.co.edgewords.webdriverdemo.baseclass.TestBase;

import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static uk.co.edgewords.webdriverdemo.utilities.HelpersStatic.handleAlert;
import static uk.co.edgewords.webdriverdemo.utilities.HelpersStatic.waitForElementToBeClickable;



@TestMethodOrder(OrderAnnotation.class)
public class LoginLogoutTest extends TestBase {

    @Test
    @Order(1)
    void secondTest(){
        System.out.println("====================secondTest");
        //Navigate to URL
        driver.get("https://www.edgewordstraining.co.uk/demo-site/");
    }

    @Test
    @Order(2)
    @Tag("RunThis")
    @Tag("Ignore")
    void firstTest() throws InterruptedException {
        //Log
        System.out.println("====================firstTest");

        //Navigate to a URL
        driver.get("http://www.edgewordstraining.co.uk/webdriver2/");

        //Log
        System.out.println("On home page");
        //Find and click a link all in one step
        driver.findElement(By.linkText("Login To Restricted Area")).click();
        Thread.sleep(10000); //Time to manually log in and hit back
        //Check if we are already logged in
        String bodyText = driver.findElement(By.tagName("body")).getText();

        //Log
        System.out.println("Text on login page : " + bodyText);
        try {
            assertThat("Already logged in - not fatal", bodyText, containsString("User is not Logged in"));
        } catch (AssertionError e)
        {
            verificationErrors.append(e.toString());
        }

        //Fill in username
        WebElement usernameField = waitForElementToBeClickable(driver,
                                    By.id("username"),3);
        usernameField.sendKeys("edgewords");
        //Capture typed in text
        String val = driver.findElement(By.id("username")).getAttribute("value");
        System.out.println("typed username is : " + val);
        driver.getTitle();

        //Fill in password using relative locator
        WebElement passwordField = driver.findElement(
                RelativeLocator.with(By.tagName("input"))
                        .below(usernameField));
        passwordField.sendKeys("edgewords123");

        //Click submit "button"
        driver.findElement(By.linkText("Submit")).click();
        //Wait for Log Out link
//        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement logoutLink = mywait.until(ExpectedConditions
//                .elementToBeClickable(By.linkText("Log Out")));
        WebElement logoutLink = waitForElementToBeClickable(driver,
                By.linkText("Log Out"),5);
        //After clicking Submit and waiting, check for logged in text
        String bodyText2 = driver.findElement(By.tagName("body")).getText();
        System.out.println("Body text is : " + bodyText);
        assertThat("Not Logged in", bodyText2, containsString("User is Logged in"));


        //Click Log Out link
        logoutLink.click();
        handleAlert(driver);
        waitForElementToBeClickable(driver, By.linkText("Register"),10);
    }

    @Test
    void hamcrestTests(){
        System.out.println("====================hamcrestTest");
        // is() is just a sugar wrapper to make these read better
        assertThat("Hello",is(not(equalTo("HELLO"))));
        assertThat("Hello", is(equalToIgnoringCase("Hello")));
        assertThat("Foo", containsString("oo"));
        assertThat("Foo", containsStringIgnoringCase("OO"));
        assertThat("Foo", startsWith("F"));
        assertThat("Foo", endsWith("o"));
        assertThat("Foo", matchesRegex(Pattern.compile("^F.*")));
        String mystring = "Blah";
        assertThat("The string must not be null or empty", mystring, is(not(emptyOrNullString())));

        assertThat(1, is(equalTo(1)));
        assertThat(1, is(not(equalTo(2))));
        assertThat(1.1, is(closeTo(1.0,0.2)));

        assertThat(1, is(lessThan(2)));
        assertThat(1, is(lessThanOrEqualTo(1)));
        assertThat(1, is(greaterThan(0)));
        assertThat(1, is(greaterThanOrEqualTo(1)));

        Assertions.fail("Failiure message");

    }
}
