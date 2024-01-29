package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class cart {

    public SelenideElement enterUsername(){
        return $x("//input[@id=\"user-name\"]");
    }

    public SelenideElement enterPassword(){
        return $x("//input[@id=\"password\"]");
    }

    public SelenideElement goToDashboard() {
        return $x("//*[@id='inventory_container']");
    }

    public SelenideElement loginButton()
    {
        return $x("//input[@id='login-button']");
    }

    public void addToCart(String itemName) {
        SelenideElement item = $x("//div[@class='inventory_item']");
        item.$("btn btn_primary btn_small btn_inventory").click();
    }

    public boolean isItemInCart() {
        open("https://www.saucedemo.com/cart.html");
        return !$$(".cart_item").isEmpty();

    }

}
