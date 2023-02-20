package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import Base.BaseForm;
import Base.ChildElements.Link;

public class LinksPage extends BaseForm {

    private static String homePageLinkLocator = "simpleLink";
    private static Logger log = Logger.getLogger(LinksPage.class);


    private static final Link homePageLink = new Link(By.id(homePageLinkLocator), " Links Page unique element");

    public LinksPage() {
        super(homePageLink);
    }

    public void clickOnHomePageLink() {
        log.info("Clicking on Home Page Link");
        homePageLink.waitAndClick();
    }

}
