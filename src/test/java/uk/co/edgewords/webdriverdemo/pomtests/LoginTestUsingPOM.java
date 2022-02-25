package uk.co.edgewords.webdriverdemo.pomtests;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import uk.co.edgewords.webdriverdemo.baseclass.TestBase;
import uk.co.edgewords.webdriverdemo.pompages.HomePagePOM;
import uk.co.edgewords.webdriverdemo.pompages.LoginPagePOM;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class LoginTestUsingPOM extends TestBase {
    @Test
    void LoginWithValidData() {
        System.out.println("====================loginpom1");
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        HomePagePOM home = new HomePagePOM(driver);
        home.goLogin();

        LoginPagePOM login = new LoginPagePOM(driver);
        login.setUsernameField("edgewords");
        login.setPasswordField("edgewords123");
        login.submitForm();
        //Or use helper method
        //login.loginExpectSuccess("edgewords","edgewords123");
    }

    @Test
    void AttemptLoginWithInvalidData() throws InterruptedException {
        System.out.println("====================loginpom2");
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        HomePagePOM home = new HomePagePOM(driver);
        home.goLogin();
        LoginPagePOM login = new LoginPagePOM(driver);
        boolean failalert = login.loginExpectFail("notreal", "notreal");
        Thread.sleep(1000); //just for us to see the alert
        MatcherAssert.assertThat("No alert - we logged in!?", failalert, is(not(false)));
    }
}
