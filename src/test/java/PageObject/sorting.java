package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class sorting {

    public SelenideElement sortProductsByNameAtoZ(){
        return $x("//div[@class='produtc_sort_container']");
    }
}
