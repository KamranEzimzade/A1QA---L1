package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import Base.BaseForm;
import Base.ChildElements.Button;
import Base.ChildElements.Iframe;
import Base.ChildElements.TextField;
import Utils.HandlesUtil;

public class IframePage extends BaseForm {
    private String nestedFramesBtnLocator = "//span[text()='Nested Frames']";
    private String framesBtnLocator = "//span[text()='Frames']";
    private String frameTitleLocator = "//div[text()='Frames']";
    private String largerFrameLocator = "sampleHeading";
    private String smallerFrameLocator = "sampleHeading";
    private static String iframePageUniqueElementLocator = "frame1Wrapper";
    private static Logger log = Logger.getLogger(IframePage.class);


    private Button nestedFramesBtn = new Button(By.xpath(nestedFramesBtnLocator), "Nested Frames button element");
    private Button framesBtn = new Button(By.xpath(framesBtnLocator), "Frames button element");
    private TextField frameTitle = new TextField(By.xpath(frameTitleLocator), "frame page title element");
    private Iframe largerFrame = new Iframe(By.id(largerFrameLocator), "larger frame element");
    private Iframe smallerFrame = new Iframe(By.id(smallerFrameLocator), "smaller frame element");
    private static final Button iframePageUniqueElement = new Button(By.id(iframePageUniqueElementLocator),
            "Iframe Page unique element");

    public IframePage() {
        super(iframePageUniqueElement);
    }

    public String getTextOfLargerFrame() {
        log.info("Swithcing to the larger frame");
        HandlesUtil.switchTo().frame("frame1");
        return largerFrame.getText();
    }

    public String getTextOfSmallerFrame() {
        log.info("Swithcing to the smaller frame");
        HandlesUtil.switchTo().parentFrame();
        HandlesUtil.switchTo().frame("frame2");
        return smallerFrame.getText();
    }

    public boolean isFrameTitleDisplayed() {
        return frameTitle.waitAndCheckIsDisplayed();
    }

    public void clickOnNestedFramesBtn() {
        nestedFramesBtn.waitAndJsClick();
    }

    public void clickOnFramesBtn() {
        framesBtn.waitAndJsClick();
    }

}
