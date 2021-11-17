package SmokeTestSuite.steps;

import java.util.List;

public class CalculateBasketSumSteps extends BasketSteps {

    public void addProductToBasket() {
        productPage.clickPurchaseBtn();
        homePage.closeBasket();
    }

    public void searchForProductsAndAddToBasket(List<String> searchedProducts) {
        for (String product : searchedProducts) {
            findProduct(product);
            addProductToBasket();
        }
    }

    public String getBasketSum() {
        homePage.clickBasketBtn();
        return homePage.getBasketTotalPrice();
    }
}
