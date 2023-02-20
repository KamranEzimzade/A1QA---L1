package SingletonPattern;

import org.openqa.selenium.WebDriver;

import BrowserFactory.BrowserFactory;

public class Singleton {

    private static WebDriver driver;

    public static WebDriver Driver() {

        if (driver == null) {

            driver = BrowserFactory.createDriver();
        }

        return driver;
    }

    public static void driverSetToNull() {
        driver = null;
    }

}
