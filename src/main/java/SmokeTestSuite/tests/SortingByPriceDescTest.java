package SmokeTestSuite.tests;

import SmokeTestSuite.resources.DataProvidersList;
import SmokeTestSuite.steps.SortByPriceDescSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SortingByPriceDescTest extends BaseTest {

    @Inject
    SortByPriceDescSteps sortByPriceDescSteps;

    @Test(dataProvider = "sideBarSearchRequest", dataProviderClass = DataProvidersList.class)
    public void sortByPriceDesc(String categoryName, String subCategoryName) throws InterruptedException {
        sortByPriceDescSteps.selectProductCategory(categoryName);
        sortByPriceDescSteps.selectProductSubCategory(categoryName, subCategoryName);
        List<String> listOfPrices = sortByPriceDescSteps.sortGoodsByPriceDesc(subCategoryName);
        List<String> listOfExpectedPrices = listOfPrices;
        Collections.sort(listOfExpectedPrices);
        assertThat(listOfPrices).isEqualTo(listOfExpectedPrices);
    }

}
