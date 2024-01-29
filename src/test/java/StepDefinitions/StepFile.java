package StepDefinitions;

import Application.Test;
import PageObject.LoginFile;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.assertTrue;

public class StepFile {
    public LoginFile loginPage;
    Test app;

    @Given("^User have open the browser$")
    public  void openBrowser() {
        app=new Test();
        app.openBrowser();
    }

    @When("^User opens the website$")
    public void goToSauce(){app.goToSauce();}

    @And("^User enters valid username (.*) and password (.*)$")
    public void enterCredential(String userName,String password) {
        app.enterCredential(userName, password);
    }

    @And("^User clicks the login button$")
    public void clickLoginButton() {
        app.clickLoginButton();
    }

    @Then("^User should navigate to dashboard$")
    public void dashboardOpen() {
        app.dashboardOpen();
    }

    @And("User enters invalid username (.*) and password (.*)$")
    public void userEntersInvalidUsernameAndPassword( String userName , String password) {
        app.enterCredential(userName,password);
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {

        app.displayError( );

        loginPage.errorMessage().should(Condition.appear);
    }






}