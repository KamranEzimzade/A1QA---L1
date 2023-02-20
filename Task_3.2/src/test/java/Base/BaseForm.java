package Base;

public abstract class BaseForm {

    private BaseElement uniqueElement;


    public BaseForm(BaseElement element) {
        uniqueElement = element;
    }

    public boolean isFormOpen() {
        return uniqueElement.isDisplayed();
    }

}
