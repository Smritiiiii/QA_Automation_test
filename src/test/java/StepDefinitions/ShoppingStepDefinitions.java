package StepDefinitions;

import Application.Test;
import PageObject.cart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;



public class ShoppingStepDefinitions {

    public cart shopping ;
    Test app;

    @Given("^User opens the website$")
    public void openBrowser() {
        app = new Test();
        app.openBrowser();
    }
    @When("^User opens the website$")
    public void goToSauce(){app.goToSauce();}


    @And("^User enters valid username (.*) and password (.*)$")
    public void enterCredential(String userName, String password) {
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

    @When("^User adds item with name (.*) to the cart$")
    public void addToCart(String itemName) {
        app.addToCart(itemName);
    }

    @Then("^User should see the item in the cart$")
    public void verifyItemInCart() {
        assertTrue(app.isItemInCart(), "Item is not found in the cart");
    }
}

