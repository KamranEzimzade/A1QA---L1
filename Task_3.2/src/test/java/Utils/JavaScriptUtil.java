package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import SingletonPattern.Singleton;

public class JavaScriptUtil {

    public static final String clickScript = "arguments[0].click();";
    public static final String retrieveTextScript = "return arguments[0].innerHTML;";

    public static void executeJsScript(String script, WebElement element) {

        JavascriptExecutor executor = (JavascriptExecutor) Singleton.Driver();
        executor.executeScript(script, element);
    }

    public static String executeJsScriptToGetText(String script, WebElement element) {
        return ((JavascriptExecutor) Singleton.Driver()).executeScript(script, element).toString();
    }
}
