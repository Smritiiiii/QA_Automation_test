package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginFile {
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

    public SelenideElement errorMessage()
    {
        return $x("//div[@class='error-message-container']");
    }
}