package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.ObjectInputFilter;
import java.rmi.ConnectIOException;

public class AddEmployee extends CommonMethods {
    private static final Logger log = LogManager.getLogger(AddEmployee.class);
    WebDriver driver;

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.username);
        sendText(ConfigReader.read("password"), loginPage.password);
        click(loginPage.loginButton);
    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        Assert.assertEquals("Welcome Admin", loginPage.dashboard.getText());

    }

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(loginPage.pimOption);
    }

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        click(loginPage.addEmpOption);
    }

    @Then("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        sendText("Rebecca",addEmployeePage.firstNameLocator);

        //WebElement empMiddleName=driver.findElement(By.id("middleName"));
        sendText("Marie",addEmployeePage.middleNameLocator);

        //WebElement empLastName=driver.findElement(By.id("lastName"));
        sendText("Smith", addEmployeePage.lastNameLocator);
    }

    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("system should generate unique employee ID")
    public void systemShouldGenerateUniqueEmployeeID() {
        String id=addEmployeePage.getEmployeeId.getText();
        System.out.println(id);
    }

    @Then("employee is added successfully")
    public void employeeIsAddedSuccessfully() {
        Assert.assertEquals("Personal Details", addEmployeePage.saveSuccess.getText());
    }

    @When("user attempts to login with empty fields or invalid employee information")
    public void userAttemptsToLoginWithEmptyFieldsOrInvalidEmployeeInformation() {
        sendText(" ",addEmployeePage.firstNameLocator);
        sendText(" ",addEmployeePage.lastNameLocator);
    }

    @Then("error message will be displayed for invalid credentials")
    public void errorMessageWillBeDisplayedForInvalidCredentials() {
        Assert.assertEquals("Required", addEmployeePage.errorMsg.getText());
    }

    @Then("user enters firstname and lastname")
    public void userEntersFirstnameAndLastname() {
        sendText("Arnold", addEmployeePage.firstNameLocator);
        sendText("Jenkins", addEmployeePage.lastNameLocator);
    }

    @Then("error message will be displayed")
    public void errorMessageWillBeDisplayed() {

    }

    @When("user enters {string} and {string} and {string}")
    public void userEntersAndAnd(String fn, String mn, String ln) {
        sendText(fn,addEmployeePage.firstNameLocator);
        sendText(mn,addEmployeePage.middleNameLocator);
        sendText(ln,addEmployeePage.lastNameLocator);
    }
}
