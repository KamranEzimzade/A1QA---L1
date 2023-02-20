package Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver.Options;

import SingletonPattern.Singleton;

public class DriverUtil {

    private static Logger log = Logger.getLogger(DriverUtil.class);

    public static void navigate(String url) {
        Singleton.Driver().get(url);
    }

    public static Options manage() {
        return Singleton.Driver().manage();
    }

    public static void maximizeWindow() {
        log.info("Maximizing window size");
        manage().window().maximize();
    }

    public static void clearCookies() {
        manage().deleteAllCookies();
    }

    public static void quitDriver() {
        Singleton.Driver().quit();
        Singleton.driverSetToNull();
    }

}
