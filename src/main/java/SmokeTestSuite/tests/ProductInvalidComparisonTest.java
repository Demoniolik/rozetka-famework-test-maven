package SmokeTestSuite.tests;

import SmokeTestSuite.resources.DataProvidersList;
import SmokeTestSuite.steps.ProductInvalidComparisonSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductInvalidComparisonTest extends BaseTest {

    @Inject
    ProductInvalidComparisonSteps productInvalidComparisonSteps;

    @Test(dataProvider = "invalidProductComparison", dataProviderClass = DataProvidersList.class)
    public void invalidProductsComparison(String firstSubCategory, String secondSubCategory,
                                          String firstProduct, String secondProduct) {
        List<String> productsList = List.of(firstProduct, secondProduct);
        productInvalidComparisonSteps.findProductAndAddToCompareList(productsList);
        List<String> subCategoryList = productInvalidComparisonSteps.getCategoriesListForComparison(firstSubCategory,
                secondSubCategory);
        assertThat(subCategoryList.get(0)).contains(firstSubCategory);
        assertThat(subCategoryList.get(1)).contains(secondSubCategory);
    }

}
