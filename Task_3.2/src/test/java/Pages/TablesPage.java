package Pages;

import org.openqa.selenium.By;

import Base.BaseForm;
import Base.ChildElements.Button;
import Base.ChildElements.TextField;

public class TablesPage extends BaseForm {

    private String elementsBtnLocator = "//h5[text()='Elements']";
    private String webTablesButtonLocator = "item-3";
    private String addNewRecordBtnLocator = "addNewRecordButton";
    private String firstNameFieldLocator = "firstName";
    private String lastNameFieldLocator = "lastName";
    private String emailFieldLocator = "userEmail";
    private String ageFieldLocator = "age";
    private String salaryFieldLocator = "salary";
    private String departmentFieldLocator = "department";
    private String submitBtnLocator = "submit";
    private String deleteBtnLocator = "delete-record-4";

    private String firstNameOnTableLocator = "//*[@id='app']//div//div//div[2]//div[2]//div[2]//div[3]//div[1]//div[2]//div[4]//div//div[1]";
    private String lastNameOnTableLocator = "//*[@id='app']//div//div//div[2]//div[2]//div[2]//div[3]//div[1]//div[2]//div[4]//div//div[2]";
    private String ageOnTableLocator = "//*[@id='app']//div//div//div[2]//div[2]//div[2]//div[3]//div[1]//div[2]//div[4]//div//div[3]";
    private String emailOnTableLocator = "//*[@id='app']//div//div//div[2]//div[2]//div[2]//div[3]//div[1]//div[2]//div[4]//div//div[4]";
    private String salaryOnTableLocator = "//*[@id='app']//div//div//div[2]//div[2]//div[2]//div[3]//div[1]//div[2]//div[4]//div//div[5]";
    private String departmentOnTableLocator = "//*[@id='app']//div//div//div[2]//div[2]//div[2]//div[3]//div[1]//div[2]//div[4]//div//div[6]";

    private static String tablesPageUniqueElementLocator = "searchBox";

    private Button elementsBtn = new Button(By.xpath(elementsBtnLocator), "Element card button");
    private Button webTablesButton = new Button(By.id(webTablesButtonLocator), "web tables button");
    private Button addNewRecordBtn = new Button(By.id(addNewRecordBtnLocator), "Add new record button");

    private TextField firstNameField = new TextField(By.id(firstNameFieldLocator), "first name field");
    private TextField lastNameField = new TextField(By.id(lastNameFieldLocator), "last name field");
    private TextField emailField = new TextField(By.id(emailFieldLocator), "email field");
    private TextField ageField = new TextField(By.id(ageFieldLocator), "age field");
    private TextField salaryField = new TextField(By.id(salaryFieldLocator), "salary field");
    private TextField departmentField = new TextField(By.id(departmentFieldLocator), "department field");

    private Button submitBtn = new Button(By.id(submitBtnLocator), "submit record button");
    private Button deleteBtn = new Button(By.id(deleteBtnLocator), "delete record button");

    private TextField firstNameOnTable = new TextField(
            By.xpath(firstNameOnTableLocator),
            "first name on web table");

    private TextField lastNameOnTable = new TextField(
            By.xpath(lastNameOnTableLocator),
            "last name on web table");

    private TextField ageOnTable = new TextField(
            By.xpath(ageOnTableLocator),
            "age on web table");

    private TextField emailOnTable = new TextField(
            By.xpath(emailOnTableLocator),
            "email on web table");

    private TextField salaryOnTable = new TextField(
            By.xpath(salaryOnTableLocator),
            "salary on web table");

    private TextField departmentOnTable = new TextField(
            By.xpath(departmentOnTableLocator),
            "department on web table");

    private static final TextField tablesPageUniqueElement = new TextField(By.id(tablesPageUniqueElementLocator),
            "Tables Page unique element");

    public TablesPage() {
        super(tablesPageUniqueElement);
    }

    public void clickonElementsBtn() {
        elementsBtn.waitAndJsClick();
    }

    public void clickOnWebTablesBtn() {
        webTablesButton.waitAndJsClick();
    }

    public void clickOnAddNewRecordBtn() {
        addNewRecordBtn.click();
    }

    public void enterRegistrationData(String firstName, String lastName, String email, String age, String salary,
            String department) {
        firstNameField.waitAndSendKeys(firstName);
        lastNameField.waitAndSendKeys(lastName);
        emailField.waitAndSendKeys(email);
        ageField.waitAndSendKeys(age);
        salaryField.waitAndSendKeys(salary);
        departmentField.waitAndSendKeys(department);
        submitBtn.click();
    }

    public String getFirstNameOnTable() {
        return firstNameOnTable.getText();
    }

    public String getLastNameOnTable() {
        return lastNameOnTable.getText();
    }

    public String getEmailOnTable() {
        return emailOnTable.getText();
    }

    public String getAgeOnTable() {
        return ageOnTable.getText();
    }

    public String getSalaryOnTable() {
        return salaryOnTable.getText();
    }

    public String getDepartmentOnTable() {
        return departmentOnTable.getText();
    }

    public void deleteRegistrationFromTable() {
        deleteBtn.waitAndClick();
    }

}
