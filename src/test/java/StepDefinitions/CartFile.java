package StepDefinitions;

import Application.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CartFile {
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

    @When("^User removes item with name (.*) from the cart$")
    public void removeFromCart(String itemName) {
        app.removeFromCart(itemName);
    }

    @Then("^User should not see the item in the cart$")
    public void verifyItemNotInCart() {
        String itemName ="";
        assertFalse(app.isItemInCart(), "Item is still found in the cart: " + itemName);
    }
}
