package SmokeTestSuite.steps;

import SmokeTestSuite.pages.HomePage;
import SmokeTestSuite.pages.ProductPage;
import com.google.inject.Inject;
import org.testng.annotations.Guice;

@Guice
public class BasketSteps {

    @Inject
    HomePage homePage;
    @Inject
    ProductPage productPage;

    public void findProduct(String product) {
        homePage.inputSearchRequest(product);
        homePage.clickSearchBtn();
        productPage.waitForPageLoad(product);
    }

}
