package Utils;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import SingletonPattern.Singleton;

public class WaitUtil {

    public static WebDriverWait getWaits() {
        return new WebDriverWait(Singleton.Driver(), Duration.ofSeconds(5));
    }

}
