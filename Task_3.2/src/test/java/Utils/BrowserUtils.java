package Utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import Configurations.ConfigFileReader;
import SingletonPattern.Singleton;

public class BrowserUtils {

    private static List<String> browserTabs;
    private static int indexOfCurrentWindowHandle;
    private static ConfigFileReader fileReader;
    private static Logger log = Logger.getLogger(BrowserUtils.class);

    public static void switchTab() {
        log.info("Switching to another tab");
        browserTabs = new ArrayList<String>(Singleton.Driver().getWindowHandles());
        HandlesUtil.switchTo().window(browserTabs.get(1));
        String windowHandle = Singleton.Driver().getWindowHandle();
        indexOfCurrentWindowHandle = browserTabs.indexOf(windowHandle);
    }

    public static void closeTab() {
        log.info("Closing the current tab");
        Singleton.Driver().close();
    }

    public static void ReturnToPreviousTab() {
        log.info("Returning to previous tab");
        HandlesUtil.switchTo().window(browserTabs.get(indexOfCurrentWindowHandle - 1));
    }

    public static void navigateToMainPage() {
        log.info(" Navigating to main page of demoqa.com");
        fileReader = new ConfigFileReader();
        DriverUtil.navigate(fileReader.getUrl());
    }
}
