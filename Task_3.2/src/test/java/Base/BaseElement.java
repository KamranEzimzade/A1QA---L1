package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SingletonPattern.Singleton;
import Utils.JavaScriptUtil;
import Utils.WaitUtil;

public abstract class BaseElement {

    private By uniqueLocator;
    private String elementName;
    private static WebDriverWait waits;
    private static Logger log = Logger.getLogger(BaseElement.class);

    protected BaseElement(By locator, String name) {
        uniqueLocator = locator;
        elementName = name;
        waits = WaitUtil.getWaits();
    }

    public boolean isDisplayed() {
        boolean isPagePresent = Singleton.Driver().findElement(uniqueLocator).isDisplayed();
        log.debug("Showing if the element: " + elementName + " is displayed: " + isPagePresent);
        return isPagePresent;
    }

    public boolean waitAndCheckIsDisplayed() {
        waits.until(ExpectedConditions.visibilityOfElementLocated(uniqueLocator));
        boolean isPagePresent = Singleton.Driver().findElement(uniqueLocator).isDisplayed();
        log.debug("Waiting for visibility of element and Showing if the element: " + elementName + " is displayed: "
                + isPagePresent);
        return isPagePresent;
    }

    public void jsClick() {
        log.debug("JavaScript Clicking on element: " + elementName);
        JavaScriptUtil.executeJsScript(JavaScriptUtil.clickScript, getElement());
    }

    public void waitAndJsClick() {
        waits.until(ExpectedConditions.presenceOfElementLocated(uniqueLocator));
        log.debug("Waiting for the presence of element and JavaScript Clicking on element: " + elementName);
        JavaScriptUtil.executeJsScript(JavaScriptUtil.clickScript, getElement());
    }

    public WebElement getElement() {
        return Singleton.Driver().findElement(uniqueLocator);
    }

    public void click() {
        log.debug("Clicking on element: " + elementName);
        getElement().click();
    }

    public void waitAndClick() {
        waits.until(ExpectedConditions.presenceOfElementLocated(uniqueLocator));
        waits.until(ExpectedConditions.elementToBeClickable(uniqueLocator));
        log.debug("Wait for the presence and clickability and click on element: " + elementName);
        getElement().click();
    }

    public String getText() {
        String text = Singleton.Driver().findElement(uniqueLocator).getText();
        log.debug("Retreiving text from element: " + elementName + ": " + text);
        return text;
    }

    public String waitAndGetText() {
        waits.until(ExpectedConditions.visibilityOfElementLocated(uniqueLocator));
        String text = Singleton.Driver().findElement(uniqueLocator).getText();
        log.debug(
                "Waiting for the visibility of element and retreiving text from element: " + elementName + ": " + text);
        return text;
    }

    public String getTextJs() {
        String text = JavaScriptUtil.executeJsScriptToGetText(JavaScriptUtil.retrieveTextScript, getElement());
        log.debug("Retreiving text with JavaScript Executor from element: " + elementName + ": " + text);
        return text;
    }

    public String waitAndGetTextJs() {
        waits.until(ExpectedConditions.visibilityOfElementLocated(uniqueLocator));
        String text = JavaScriptUtil.executeJsScriptToGetText(JavaScriptUtil.retrieveTextScript, getElement());
        log.debug("Waiting for the visibility of element and retreiving text with JavaScript Executor from element: "
                + elementName + ": " + text);
        return text;
    }

    public void sendKeys(String data) {
        Singleton.Driver().findElement(uniqueLocator).sendKeys(data);
        log.debug("Sending text: " + data);
    }

    public void waitAndSendKeys(String data) {
        waits.until(ExpectedConditions.visibilityOfElementLocated(uniqueLocator));
        Singleton.Driver().findElement(uniqueLocator).sendKeys(data);
        log.debug("Waiting for the visibility of element and sending text: " + data);
    }

}
