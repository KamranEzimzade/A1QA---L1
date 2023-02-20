package Tests;

import Utils.BrowserUtils;
import Utils.DriverUtil;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    private static Logger log = Logger.getLogger(BaseTest.class);

    @BeforeTest
    void setup() {
        BrowserUtils.navigateToMainPage();
        DriverUtil.maximizeWindow();
    }

    @AfterTest
    void clearCookies() {
        log.info("It's clearing cookies");
        DriverUtil.clearCookies();
    }

    @AfterTest
    void tearDown() {
        log.info("Closing the driver");
        DriverUtil.quitDriver();

    }

}
