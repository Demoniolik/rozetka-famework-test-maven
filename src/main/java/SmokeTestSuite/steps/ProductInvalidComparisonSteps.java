package SmokeTestSuite.steps;

import SmokeTestSuite.pages.ProductPage;
import com.google.inject.Inject;

import java.util.List;

public class ProductInvalidComparisonSteps extends ComparisonSteps {

    @Inject
    ProductPage productPage;

    public void findProduct(String searchedProduct) {
        homePage.inputSearchRequest(searchedProduct);
        homePage.clickSearchBtn();
    }

    public void addProductsToCompare(String searchedProduct) {
        productPage.waitForPageLoad(searchedProduct);
        productPage.clickCompareBtn();
    }

    public void findProductAndAddToCompareList(List<String> productsList) {
        for (String product : productsList) {
            findProduct(product);
            addProductsToCompare(product);
        }
    }

    public List<String> getCategoriesListForComparison(String firstSubCategory, String secondSubCategory) {
        homePage.clickHeaderComparisonBtn();
        return homePage.getComparisonSubCategories(firstSubCategory, secondSubCategory);
    }
}
