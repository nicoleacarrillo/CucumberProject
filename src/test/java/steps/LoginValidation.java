package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginValidation extends CommonMethods {

    LoginPage loginPage=new LoginPage();

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        openBrowserAndLaunchApplication();
    }

    @When("user attempts to login with an empty username field")
    public void user_attempts_to_login_with_an_empty_username_field() {
        sendText(ConfigReader.read("password"), loginPage.password);
        sendText("", loginPage.username);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }

    @Then("username error message will be displayed")
    public void error_message_will_be_displayed() {
        Assert.assertEquals("Username cannot be empty",loginPage.loginErrorMessage.getText());
    }

    @When("user attempts to login with an empty password field")
    public void user_attempts_to_login_with_an_empty_password_field() {
        sendText(ConfigReader.read("userName"), loginPage.username);
        sendText("", loginPage.password);
    }

    @Then("password error message will be displayed")
    public void password_error_message_will_be_displayed() {
        Assert.assertEquals("Username cannot be empty",loginPage.loginErrorMessage.getText());
    }

    @When("user enters incorrect login username or password")
    public void userEntersIncorrectLoginUsernameOrPassword() {
        sendText(("joshuaGomez"),loginPage.username);
        sendText(("293jg!@"),loginPage.password);
    }

    @And("user can attempt to log back in again")
    public void userCanAttemptToLogBackInAgain() {
        sendText(ConfigReader.read("userName"),loginPage.username);
        sendText(ConfigReader.read("password"), loginPage.password);
    }

    @Then("user will see dashboard page")
    public void userWillSeeDashboardPage() {
        Assert.assertEquals("Welcome Admin",loginPage.dashboard.getText());
    }

    @Then("invalid error message will be displayed")
    public void loginErrorMessageWillBeDisplayed() {
        Assert.assertEquals("Username cannot be empty",loginPage.loginErrorMessage.getText());
    }

    @Then("error message will be displayed")
    public void errorMessageWillBeDisplayed() {
        Assert.assertEquals("Username cannot be empty",loginPage.loginErrorMessage.getText());
    }
}
