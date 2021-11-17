package SmokeTestSuite.pages;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;

public class ProductPage extends BasePage {

    private static final String PRODUCT_NAME = "//h1[@class = 'product__title']";
    private static final String COMPARE_BTN = "//button[@class = 'compare-button ng-star-inserted']";
    private static final String PURCHASE_BTN = "//button[@aria-label = 'Купить']";

    public void waitForPageLoad(String searchRequest) {
        Objects.requireNonNull(title()).contains(searchRequest);
    }

    public void clickCompareBtn() {
        $x(COMPARE_BTN).click();
    }

    public String getProductName() {
        return $x(PRODUCT_NAME).getText();
    }

    public void clickPurchaseBtn() {
        $x(PURCHASE_BTN).click();
    }
}
