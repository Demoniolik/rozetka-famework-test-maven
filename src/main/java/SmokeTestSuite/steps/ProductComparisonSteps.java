package SmokeTestSuite.steps;

import SmokeTestSuite.pages.ComparisonPage;
import SmokeTestSuite.pages.SubCategoryGoodsListPage;
import SmokeTestSuite.pages.SubCategoryPage;
import com.google.inject.Inject;

import java.util.List;

public class ProductComparisonSteps extends ComparisonSteps {

    @Inject
    SubCategoryPage subCategoryPage;
    @Inject
    SubCategoryGoodsListPage subCategoryGoodsListPage;
    @Inject
    ComparisonPage comparisonPage;

    public void selectProductCategory(String categoryName) {
        homePage.clickCategoryOption(categoryName);
    }

    public void selectSubCategoryName(String categoryName, String subCategoryName) {
        subCategoryPage.waitForPageLoad(categoryName);
        subCategoryGoodsListPage.clickConfirmAgeBtn();
        subCategoryPage.clickSubCategoryOption(subCategoryName);
    }

    public void addProductsToCompare(String subCategoryName, String firstProduct, String secondProduct) {
        subCategoryGoodsListPage.waitForPageLoad(subCategoryName);
        subCategoryGoodsListPage.clickComparisonBtn(firstProduct);
        subCategoryGoodsListPage.clickComparisonBtn(secondProduct);
    }

    public List<String> verifyComparedProducts(String firstProduct, String secondProduct, String subCategoryName) {
        homePage.clickHeaderComparisonBtn();
        homePage.selectComparisonCategory(subCategoryName);
        comparisonPage.waitForPageLoad(subCategoryName);
        return comparisonPage.getComparedProductNames(firstProduct, secondProduct);
    }
}
