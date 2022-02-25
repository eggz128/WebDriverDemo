package uk.co.edgewords.webdriverdemo.pompages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {
    //1 - Declare Field to work with webdriver in this class
    private WebDriver driver;
    //2 - Declare constructor to receive driver from test and set field
    public LoginPagePOM(WebDriver driver) {
        this.driver = driver;
        //3 - Initialise Page Factory with the driver and this class
        PageFactory.initElements(driver, this);
    }
    //4 - Locators (Object Repository)
    @FindBy (id = "username") WebElement usernameField;
    @FindBy (id = "password") WebElement passwordField;
    @FindBy (linkText = "Submit") WebElement submitButton;
    //5 - Service Methods (/How/ to use the locators)
    public void setUsernameField(String username){
        usernameField.sendKeys(username);
    }
    public void setPasswordField(String password){
        passwordField.sendKeys(password);
    }
    public void submitForm(){
        submitButton.click();
    }
    //5b - Create convenient helper methods
    public void loginExpectSuccess(String username, String password){
        setUsernameField(username);
        setPasswordField(password);
        submitForm();
    }
    public boolean loginExpectFail(String username, String password){
        setUsernameField(username);
        setPasswordField(password);
        submitForm();
        //if there is alert login failed
        boolean alertPresent = false;
        try {
            driver.switchTo().alert(); //Try to switch. Will throw here if no alert
            alertPresent = true; //If we get here there was an alert
        } catch (NoAlertPresentException e) {
            //Catch the exception if there is no alert
            //to avoid stopping the test here
        }
        return alertPresent; //Returns true if we did not login (i.e. alert present)
    }
}
