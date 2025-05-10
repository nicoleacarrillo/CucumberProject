package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    //object repositories: find attribute from Selenium through ID
    @FindBy(id="txtUsername")
    public WebElement username;

    @FindBy(id="txtPassword")
    public WebElement password;

    @FindBy (id="btnLogin")
    public WebElement loginButton;

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmpOption;

    @FindBy(id= "welcome")
    public WebElement dashboard;

    @FindBy(id="spanMessage")
    public WebElement loginErrorMessage;

    public LoginPage(){
        //need to call pageFactory
        PageFactory.initElements(driver,this);
    }
}
