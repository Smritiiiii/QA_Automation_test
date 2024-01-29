package StepDefinitions;

import Application.Test;
import PageObject.sorting;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Sorting {
    public Sorting sort;

    Test app;
    @Given("^User have open the browser$")
    public  void openBrowser() {
        app = new Test();
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


    public void sortProductsByNameAtoZ() {

        SelenideElement sortDropdown = $("#product_sort_cointaner");

        sortDropdown.selectOption("Name (A to Z)");
        ElementsCollection productNames = $$x("//div[@class='inventory_item']//div[@class='inventory_item_name']");
        assertProductsSortedAtoZ(productNames);
    }

    private void assertProductsSortedAtoZ(ElementsCollection productNames) {
        for (int i = 0; i < productNames.size() - 1; i++) {
            String currentName = productNames.get(i).text();
            String nextName = productNames.get(i + 1).text();
            assertTrue(currentName.compareTo(nextName) <= 0, "Products are not sorted by name (A to Z)");
        }
    }

}
