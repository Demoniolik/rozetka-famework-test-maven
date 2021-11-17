package SmokeTestSuite.steps;

import java.util.List;

public class SortByPriceDescSteps extends SearchSideBarSteps {

    public List<String> sortGoodsByPriceDesc(String subCategoryName) throws InterruptedException {
        subCategoryGoodsListPage.waitForPageLoad(subCategoryName);
        subCategoryGoodsListPage.clickSortingDropdownBtn();
        subCategoryGoodsListPage.selectPriceDescOption();
        Thread.sleep(2000);
        return subCategoryGoodsListPage.getPriceList();
    }
}
