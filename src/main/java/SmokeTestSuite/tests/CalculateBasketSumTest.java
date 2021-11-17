package SmokeTestSuite.tests;

import SmokeTestSuite.resources.DataProvidersList;
import SmokeTestSuite.steps.CalculateBasketSumSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculateBasketSumTest extends BaseTest {

    @Inject
    private CalculateBasketSumSteps calculateBasketSumSteps;

    @Test(dataProvider = "productsSearchRequest", dataProviderClass = DataProvidersList.class)
    public void calculateBasketPrice(String firstProduct, String secondProduct, int productsTotalPrice) {
        List<String> searchedProducts = List.of(firstProduct, secondProduct);
        calculateBasketSumSteps.searchForProductsAndAddToBasket(searchedProducts);
        String overallPrice = calculateBasketSumSteps.getBasketSum();
        assertThat(Integer.parseInt(overallPrice)).isEqualTo(productsTotalPrice);
    }

}
