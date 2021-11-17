package SmokeTestSuite.steps;

public class AddToBasketSteps extends BasketSteps {

    public String addProductToBasket(String product) {
        productPage.clickPurchaseBtn();
        return homePage.getProductNameInBasket(product);
    }

}
