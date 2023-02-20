package Pages;

import org.openqa.selenium.By;

import Base.BaseForm;
import Base.ChildElements.Button;
import Base.ChildElements.TextField;

public class HandlesPage extends BaseForm {

    private String browserWindowsBtnLocator = "//span[text()='Browser Windows']";
    private String newTabBtnLocator = "tabButton";
    private String newTabTextFieldLocator = "sampleHeading";
    private String linksBtnLocator = "//span[text()='Links']";
    private String elementsLeftMenuBtnLocator = "//div[contains(@class,'header-text')]";
    private static String handlePageUniqueElementLocator = "messageWindowButton";

    private Button browserWindowsBtn = new Button(By.xpath(browserWindowsBtnLocator), "Browser Windows section button");

    private Button elementsLeftMenuBtn = new Button(By.xpath(elementsLeftMenuBtnLocator),
            "elements button on left menu");

    private Button newTabBtn = new Button(By.id(newTabBtnLocator), "New Tab button element");

    private TextField newTabTextField = new TextField(By.id(newTabTextFieldLocator), "Text in new tab");

    private Button linksBtn = new Button(By.xpath(linksBtnLocator), "Links section button element");

    private static final Button handlePageUniqueElement = new Button(By.id(handlePageUniqueElementLocator),
            "Handles Page unique element");

    public HandlesPage() {
        super(handlePageUniqueElement);
    }

    public void clickOnBrowserWindowsBtn() {
        browserWindowsBtn.waitAndJsClick();
    }

    public void clickOnLeftMenuElementsBtn() {
        elementsLeftMenuBtn.waitAndJsClick();
    }

    public void clickOnNewTabBtn() {
        newTabBtn.waitAndClick();
    }

    public String getNewTabText() {
        String newTabText = newTabTextField.getTextJs();
        return newTabText;
    }

    public void clickOnLinksBtn() {
        linksBtn.waitAndJsClick();
    }

}
