package SmokeTestSuite.steps;

import SmokeTestSuite.pages.HomePage;
import SmokeTestSuite.pages.SubCategoryGoodsListPage;
import SmokeTestSuite.pages.SubCategoryPage;
import com.google.inject.Inject;
import org.testng.annotations.Guice;

@Guice
public class SearchSideBarSteps {

    @Inject
    HomePage homePage;
    @Inject
    SubCategoryPage subCategoryPage;
    @Inject
    SubCategoryGoodsListPage subCategoryGoodsListPage;

    public void selectProductCategory(String categoryName) {
        homePage.clickCategoryOption(categoryName);
    }

    public void selectProductSubCategory(String categoryName, String subCategoryName) {
        subCategoryPage.waitForPageLoad(categoryName);
        subCategoryGoodsListPage.clickConfirmAgeBtn();
        subCategoryPage.clickSubCategoryOption(subCategoryName);
    }

    public String getSubcategoryName(String subCategoryName) {
        subCategoryGoodsListPage.waitForPageLoad(subCategoryName);
        return subCategoryGoodsListPage.getSearchedProductSubCategory();
    }
}
