package SmokeTestSuite.tests;

import SmokeTestSuite.resources.DataProvidersList;
import SmokeTestSuite.steps.ProductComparisonSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductComparisonTest extends BaseTest {

    @Inject
    ProductComparisonSteps productComparisonSteps;

    @Test(dataProvider = "productComparison", dataProviderClass = DataProvidersList.class)
    public void productsComparison(String categoryName, String subCategoryName,
                                   String firstProduct, String secondProduct) {
        productComparisonSteps.selectProductCategory(categoryName);
        productComparisonSteps.selectSubCategoryName(categoryName, subCategoryName);
        productComparisonSteps.addProductsToCompare(subCategoryName, firstProduct, secondProduct);
        List<String> productNames = productComparisonSteps.verifyComparedProducts(firstProduct, secondProduct,
                subCategoryName);
        assertThat(productNames.get(0)).contains(firstProduct);
        assertThat(productNames.get(1)).contains(secondProduct);
    }

}
