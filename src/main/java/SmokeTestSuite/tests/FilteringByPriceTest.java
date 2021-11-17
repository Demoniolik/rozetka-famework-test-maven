package SmokeTestSuite.tests;

import SmokeTestSuite.resources.DataProvidersList;
import SmokeTestSuite.steps.FilteringByPriceSteps;
import SmokeTestSuite.steps.RegistrationOverlaySteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FilteringByPriceTest extends BaseTest {

    @Inject
    FilteringByPriceSteps filteringByPriceSteps;

    @Test(dataProvider = "filteringByPrice", dataProviderClass = DataProvidersList.class)
    public void filterByPrice(String categoryName, String subCategoryName, String lowestPrice, String highestPrice)
            throws InterruptedException {
        filteringByPriceSteps.selectProductCategory(categoryName);
        filteringByPriceSteps.selectProductSubCategory(categoryName, subCategoryName);
        List<String> listOfFilteredPrices = filteringByPriceSteps.filterGoodsByPriceRange(subCategoryName,
                lowestPrice, highestPrice);
        for (String price : listOfFilteredPrices) {
            assertThat(Integer.parseInt(price)).isBetween(Integer.parseInt(lowestPrice),
                    Integer.parseInt(highestPrice));
        }
    }

}
