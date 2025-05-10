package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id="firstName")
    public WebElement firstNameLocator;

    @FindBy(id="middleName")
    public WebElement middleNameLocator;

    @FindBy(id="lastName")
    public WebElement lastNameLocator;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(xpath = "//a[text()='Personal Details']")
    public WebElement saveSuccess;

    @FindBy(xpath = "//span[contains(text(),'Required')]")
    public WebElement errorMsg;

    @FindBy(id = "employeeId")
    public WebElement getEmployeeId;

    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }
}
