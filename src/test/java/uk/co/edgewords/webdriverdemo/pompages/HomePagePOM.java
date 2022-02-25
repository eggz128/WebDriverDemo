package uk.co.edgewords.webdriverdemo.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
    //1 - Declare Field to work with webdriver in this class
    private WebDriver driver;
    //2 - Declare constructor to receive driver from test and set field
    public HomePagePOM(WebDriver driver) {
        this.driver = driver;
        //3 - Initialise Page Factory with the driver and this class
        PageFactory.initElements(driver, this);
    }
    //4 - Locators (Object Repository)
    @FindBy (linkText = "Login To Restricted Area")
    WebElement loginLink;

    //5 - Service Methods (/How/ to use the locators)
    public void goLogin(){
        loginLink.click();
    }
}
