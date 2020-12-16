package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement productGrid = $("#product_grid");

    public MainPage selectColor(Color color) {
        $(color.getLocator()).click();
        return this;
    }

    public MainPage filter() {
        $("#filterBtn").scrollIntoView(true).click();
        return this;
    }

    public MainPage selectProduct(String productName) {
        $(byText(productName)).click();
        return this;
    }

    public enum Color {
        BLACK("#colors__Black");

        private final String locator;

        Color(String locator) {
            this.locator = locator;
        }

        public String getLocator() {
            return this.locator;
        }
    }
}
