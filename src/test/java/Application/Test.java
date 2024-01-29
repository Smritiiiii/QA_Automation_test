package Application;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import java.time.Duration;

import PageObject.*;

import static com.codeborne.selenide.Selenide.*;


public class Test {

    public LoginFile loginPage;

    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginFile();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        WebDriverRunner.setWebDriver(driver);
    }

    public void goToSauce(){
        System.out.print("Redirected");
    }

    public void enterCredential(String username, String password){
        loginPage.enterUsername().should(Condition.appear, Duration.ofSeconds(30)).sendKeys(username);
        loginPage.enterPassword().sendKeys(password);
    }

    public void clickLoginButton(){

        loginPage.loginButton().should(Condition.appear, Duration.ofSeconds(5)).click();
    }

    public static void closeBrowser(){

        closeWindow();
    }

    public void dashboardOpen(){

        loginPage.goToDashboard().isDisplayed();
    }

public void displayError(){

        SelenideElement errorMessageElement = loginPage.errorMessage();

        if (errorMessageElement.exists()) {
            String errorMessageText = errorMessageElement.getText();
            System.out.println("Error Message: " + errorMessageText);
        } else {
            System.out.println("No error message found.");
        }
    }


    public void addToCart(String itemName) {

        SelenideElement item = $x("//div[@class='inventory_item']");
        item.$("btn btn_primary btn_small btn_inventory").click();
    }


    public boolean isItemInCart() {
        open("https://www.saucedemo.com/cart.html");

        String itemId = "";
        return $("#item_4_title_link" + itemId).exists();
    }
    public void removeFromCart(String itemName) {
        open("https://www.saucedemo.com/cart.html");

        SelenideElement removeButton = $x("//div[@class='cart_item']//*[text()='" + itemName + "']/ancestor::div[@class='cart_item']")
                .$("button.btn_secondary.cart_button");

        if (removeButton.exists()) {
            removeButton.click();
        } else {
            throw new AssertionError("Item not found in the cart: " + itemName);
        }
    }



}
