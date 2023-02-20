package Utils;

import org.openqa.selenium.WebDriver.TargetLocator;

import SingletonPattern.Singleton;

public class HandlesUtil {

    public static TargetLocator switchTo() {
        return Singleton.Driver().switchTo();
    }
}
