package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import Base.BaseForm;
import Base.ChildElements.Button;
import Base.ChildElements.TextField;
import Utils.AlertsUtil;
import Utils.RandomUtil;
import Utils.TrimUtil;

public class AlertsPage extends BaseForm {

    public static String randomText;

    private static Logger log = Logger.getLogger(AlertsPage.class);

    private String alertFrameWindowsBtnLocator = "//h5[text()='Alerts, Frame & Windows']";
    private String alertBtnLocator = "//span[text()='Alerts']";
    private String seeAlertBtnLocator = "alertButton";
    private String confirmBoxBtnLocator = "confirmButton";
    private String confirmResultLocator = "confirmResult";
    private String promptBtnLocator = "promtButton";
    private String promptResultTextLocator = "promptResult";
    private static String alertsPageUniqueElementLocator = "timerAlertButton";

    private Button alertsFrameWindowsBtn = new Button(By.xpath(alertFrameWindowsBtnLocator),
            "Alerts&&Frame&&Windows button");

    private Button alertBtn = new Button(By.xpath(alertBtnLocator), "Alerts button");

    private Button seeAlertBtn = new Button(By.id(seeAlertBtnLocator), " 'Click me' button to see Alert");

    private Button confirmBoxBtn = new Button(By.id(confirmBoxBtnLocator), " 'Click me' button to see Confirm Box");

    private TextField confirmResult = new TextField(By.id(confirmResultLocator), "Result text of confirm box");

    private Button promptBtn = new Button(By.id(promptBtnLocator), " 'Click me' button to see prompt box alert");

    private TextField promptResultText = new TextField(By.id(promptResultTextLocator),
            "Result TextField element of prompt box");

    private static final Button alertsPageUniqueElement = new Button(By.id(alertsPageUniqueElementLocator),
            "Alerts Page unique element");

    public AlertsPage() {
        super(alertsPageUniqueElement);
    }

    public void clickOnAlertsFrameWindows() {
        alertsFrameWindowsBtn.waitAndJsClick();
    }

    public void clickOnAlertBtn() {
        alertBtn.waitAndJsClick();
    }

    public void clickOnConfirmBox() {
        confirmBoxBtn.click();
    }

    public String getConfirmResultText() {
        return confirmResult.waitAndGetText();
    }

    public void clickOnSeeAlertBtn() {
        seeAlertBtn.waitAndJsClick();
    }

    public void clickOnPromptBtn() {
        promptBtn.click();
    }

    public void sendRandomText() {
        randomText = RandomUtil.generateRandomText();
        AlertsUtil.sendTextToAlert(randomText);
        log.info("Sending random text: " + randomText + " to the alert");
    }

    public String getPromptResultText() {
        String finalText = TrimUtil.trimTheResult(promptResultText.getText());
        log.info("Text entered in prompt box: " + finalText);
        return finalText;
    }

}
