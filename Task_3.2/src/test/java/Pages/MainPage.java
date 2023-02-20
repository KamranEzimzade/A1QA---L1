package Pages;

import org.openqa.selenium.By;

import Base.BaseForm;
import Base.ChildElements.Button;

public class MainPage extends BaseForm {

    private static String mainPageUniqueElementLocator = "//h5[text()='Book Store Application']";

    private static final Button mainPageUniqueElement = new Button(By.xpath(mainPageUniqueElementLocator),
            "Main Page unique element");

            
    public MainPage() {
        super(mainPageUniqueElement);
    }

}
