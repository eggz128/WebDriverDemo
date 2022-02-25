package uk.co.edgewords.webdriverdemo.baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.uri.Uri;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.fail;

public class TestBase {
    protected WebDriver driver; //Class field, accessible to all methods
    protected StringBuffer verificationErrors = new StringBuffer();
//    WebDriverManager wdm;
    @BeforeEach
    void setUp() throws MalformedURLException {
        String browser = System.getProperty("browser");
        System.out.println("Browser from command line: " + browser);
        if(browser==null){ browser = ""; } //Avoid null if not set
        switch (browser){
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            default:
                System.out.println("Warning: no browser set - using chrome");
                driver = WebDriverManager.chromedriver().create();
                break;
        }




        //Remote
        //FirefoxOptions options = new FirefoxOptions();
//        ChromeOptions options = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL("http://172.28.48.205:4444/wd/hub/"), options);

//        driver = WebDriverManager.firefoxdriver()
//                .remoteAddress("http://172.28.48.205:4444/wd/hub/")
//                .create();

//        wdm = WebDriverManager.safaridriver().browserInDocker();
//        driver = wdm.create();


        //Fetch ChromeDriver
        //WebDriverManager.chromedriver().setup();
        //Instantiate browser
        //Manually set chromedriver path if not on path, or using WebDriverManager
        //System.setProperty("webdriver.chrome.driver","c:\\path\\to\\chromedriver\\location");

        //Tell WebDriver which chrome binary to use

        //options.setBinary("C:\\Path\\To\\Specific\\Chrome\\Binary.exe");
        //options.addArguments("headless");
//        ChromeOptions options = new ChromeOptions();
//        Map<String,String> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName","Nexus 5");
//        options.setExperimentalOption("mobileEmulation", mobileEmulation);
//        driver = new ChromeDriver(options);

        //WebDriverManager can be omitted if GeckoDriver is on the path
//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions options = new FirefoxOptions();
//        options.setHeadless(true);
//        driver = new FirefoxDriver(options);


//        WebDriverManager.iedriver().arch32();
//        //If typing is slow force use of 32bit IE Driver on 64bit systems
//        //WebDriverManager.iedriver().arch32().setup();
//        driver = new InternetExplorerDriver();

//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();

    }

    @AfterEach
    void tearDown(){
        driver.quit();
//        wdm.quit();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String verificationErrorsString = verificationErrors.toString();
        if(!verificationErrorsString.isEmpty()){
            fail("Found verification errors : " + verificationErrorsString );
        }
    }
}
