package SmokeTestSuite.tests;

import SmokeTestSuite.resources.DataProvidersList;
import SmokeTestSuite.steps.AddToBasketSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddProductToBasketTest extends BaseTest {

    @Inject
    private AddToBasketSteps addToBasketSteps;

    @Test(dataProvider = "productSearchRequest", dataProviderClass = DataProvidersList.class)
    public void addToBasket(String product) {
        addToBasketSteps.findProduct(product);
        String productInBasket = addToBasketSteps.addProductToBasket(product);
        assertThat(productInBasket).contains(product);
    }

}
