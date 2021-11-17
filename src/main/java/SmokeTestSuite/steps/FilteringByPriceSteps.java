package SmokeTestSuite.steps;

import SmokeTestSuite.pages.SubCategoryGoodsListPage;
import com.google.inject.Inject;

import java.util.List;

public class FilteringByPriceSteps extends SearchSideBarSteps {

    @Inject
    SubCategoryGoodsListPage subCategoryGoodsListPage;

    public List<String> filterGoodsByPriceRange(String subCategoryName, String lowestPrice, String highestPrice)
            throws InterruptedException {
        subCategoryGoodsListPage.waitForPageLoad(subCategoryName);
        subCategoryGoodsListPage.applyPriceFilter(lowestPrice, highestPrice);
        Thread.sleep(2000);
        return subCategoryGoodsListPage.getPriceList();
    }
}
