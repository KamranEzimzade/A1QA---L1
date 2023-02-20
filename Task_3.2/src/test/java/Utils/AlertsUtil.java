package Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class AlertsUtil {

    private static Logger log = Logger.getLogger(AlertsUtil.class);


    public static Alert switchToAlert() {
        return HandlesUtil.switchTo().alert();
    }

    public static String getAlertText() {
        log.info("Retrieving text from alert");
        return switchToAlert().getText();
    }

    public static void clickOKBtnOnAlert() {
        log.info("Clicking OK button on alert");
        switchToAlert().accept();
    }

    public static boolean isAlertPresent() {
        log.info("Checking if alert is open");
        try {
            switchToAlert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void sendTextToAlert(String text) {
        log.info("Sending text to alert");
        switchToAlert().sendKeys(text);

    }
}
