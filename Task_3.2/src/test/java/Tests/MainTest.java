package Tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import Configurations.ConfigFileReader;
import Pages.AlertsPage;
import Pages.HandlesPage;
import Pages.IframePage;
import Pages.LinksPage;
import Pages.MainPage;
import Pages.TablesPage;
import Utils.AlertsUtil;
import Utils.BrowserUtils;

public class MainTest extends BaseTest {

    private static ConfigFileReader fileReader;
    private static AlertsPage alertsPage;
    private static MainPage mainPage;
    private static IframePage iframePage;
    private static TablesPage tablesPage;
    private static HandlesPage handlesPage;
    private static LinksPage linksPage;
    private static Logger log = Logger.getLogger(MainTest.class);

    @Test
    void alert() {

        mainPage = new MainPage();

        Assert.assertTrue(mainPage.isFormOpen(), "The Main Page should be visible at this stage");

        alertsPage = new AlertsPage();

        alertsPage.clickOnAlertsFrameWindows();

        log.info("Clicking on the Alert, Frame & Windows section on the left to switch to Alerts Page");

        alertsPage.clickOnAlertBtn();

        Assert.assertTrue(alertsPage.isFormOpen(), "The Alerts form should be visible at this stage");

        alertsPage.clickOnSeeAlertBtn();

        fileReader = new ConfigFileReader();

        Assert.assertEquals(AlertsUtil.getAlertText(), fileReader.getAlertBtnText(),
                "The text on the alertbox doesn't match");

        log.info("Checking if the text retrieved from alert is equal to the expected text");

        AlertsUtil.clickOKBtnOnAlert();

        Assert.assertEquals(AlertsUtil.isAlertPresent(), false, "Alert is still open");

        alertsPage.clickOnConfirmBox();

        Assert.assertEquals(AlertsUtil.getAlertText(), fileReader.getConfirmBtnText(), "Alert text is not displayed");

        log.info("Checking if the text retrieved from confirm box alert is equal to the action that is performed on the page");

        AlertsUtil.clickOKBtnOnAlert();

        Assert.assertEquals(AlertsUtil.isAlertPresent(), false, "Alert is still open");

        Assert.assertEquals(alertsPage.getConfirmResultText(), fileReader.getConfirmResultText(),
                "Result text is not displayed");

        alertsPage.clickOnPromptBtn();

        Assert.assertEquals(AlertsUtil.getAlertText(), fileReader.getPromptBtnText(), "Prompt text is not displayed");

        alertsPage.sendRandomText();

        AlertsUtil.clickOKBtnOnAlert();

        Assert.assertEquals(AlertsPage.randomText,
                alertsPage.getPromptResultText(), "Random text from web page doesn't match to the stored value");

        log.info("Checking if the text retrieved from alert is equal to the randomly generated text");

    }

    @Test
    void iframe() {
        BrowserUtils.navigateToMainPage();
        Assert.assertTrue(mainPage.isFormOpen(), "The Main Page should be visible at this stage");
        alertsPage.clickOnAlertsFrameWindows();
        iframePage = new IframePage();
        log.info("Clicking on the Nested Frames section on the left to switch to the Iframes section");
        iframePage.clickOnNestedFramesBtn();
        Assert.assertTrue(iframePage.isFormOpen(), "The Iframe form should be visible at this stage");
        iframePage.clickOnFramesBtn();
        Assert.assertTrue(iframePage.isFrameTitleDisplayed(), "Frame page title should be visible");
        log.info("Checking if the texts retrieved from both iframes are equal to each other");
        Assert.assertEquals(iframePage.getTextOfLargerFrame(),
                iframePage.getTextOfSmallerFrame(), "Texts from iframes doesn't match each other");
    }

    @Test(dataProvider = "userList", dataProviderClass = DataProviderClass.class)
    void tables(String firstName, String lastName, String email, String age, String salary, String department) {

        BrowserUtils.navigateToMainPage();

        Assert.assertTrue(mainPage.isFormOpen(), "The Main Page should be visible at this stage");

        tablesPage = new TablesPage();

        log.info("Clicking on the Elements section on the left to switch to the Web Tables section");

        tablesPage.clickonElementsBtn();

        tablesPage.clickOnWebTablesBtn();

        Assert.assertTrue(tablesPage.isFormOpen(), "The Tables Page should be visible at this stage");

        tablesPage.clickOnAddNewRecordBtn();

        log.info("Entering user information in the field to register them on the web table");

        tablesPage.enterRegistrationData(firstName, lastName, email, age, salary, department);

        Assert.assertEquals(firstName, tablesPage.getFirstNameOnTable(),"First name from web page doesn't match to expected first name");
        Assert.assertEquals(lastName, tablesPage.getLastNameOnTable(),"Last name from web page doesn't match to expected last name");
        Assert.assertEquals(email, tablesPage.getEmailOnTable(),"Email from web page doesn't match to expected email");
        Assert.assertEquals(age, tablesPage.getAgeOnTable(),"Age from web page doesn't match to expected age");
        Assert.assertEquals(salary, tablesPage.getSalaryOnTable(),"Salary from web page doesn't match to expected salary");
        Assert.assertEquals(department, tablesPage.getDepartmentOnTable(),"Department from web page doesn't match to expected department");

        log.info("Asserting entered data with the retrieved data");

        tablesPage.deleteRegistrationFromTable();

    }

    @Test
    void handles() {

        BrowserUtils.navigateToMainPage();

        Assert.assertTrue(mainPage.isFormOpen(), "The Main Page should be visible at this stage");

        alertsPage.clickOnAlertsFrameWindows();

        handlesPage = new HandlesPage();

        log.info("Clicking on the Browser Windows section on the left to switch to the Handles section");

        handlesPage.clickOnBrowserWindowsBtn();

        Assert.assertTrue(handlesPage.isFormOpen(), "Handles Page is not displayed");

        handlesPage.clickOnNewTabBtn();

        BrowserUtils.switchTab();

        Assert.assertEquals(handlesPage.getNewTabText(), fileReader.getNewTabText(), "Texts Doesn't match");

        BrowserUtils.closeTab();

        BrowserUtils.ReturnToPreviousTab();

        Assert.assertTrue(handlesPage.isFormOpen(), "Handles Page is not displayed");

        handlesPage.clickOnLeftMenuElementsBtn();

        handlesPage.clickOnLinksBtn();

        log.info("Clicking on the Links section on the left to switch to the Links Page");

        linksPage = new LinksPage();

        Assert.assertTrue(linksPage.isFormOpen(), "Links Page is not displayed");

        linksPage.clickOnHomePageLink();

        BrowserUtils.switchTab();

        Assert.assertTrue(mainPage.isFormOpen(), "Main Page is not displayed");

        BrowserUtils.closeTab();

        BrowserUtils.ReturnToPreviousTab();

        Assert.assertTrue(linksPage.isFormOpen(), "Links Page is not displayed");

    }

}
