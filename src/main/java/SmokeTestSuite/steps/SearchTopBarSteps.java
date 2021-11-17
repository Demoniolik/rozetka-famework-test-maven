package SmokeTestSuite.steps;

import SmokeTestSuite.pages.HomePage;
import SmokeTestSuite.pages.ProductPage;
import com.google.inject.Inject;
import org.testng.annotations.Guice;

@Guice
public class SearchTopBarSteps {

    @Inject
    HomePage homePage;
    @Inject
    ProductPage productPage;

    public void findBySearchRequest(String searchRequest) {
        homePage.inputSearchRequest(searchRequest);
        homePage.clickSearchBtn();
    }

    public String getSearchedProductName(String searchRequest) {
        productPage.waitForPageLoad(searchRequest);
        return productPage.getProductName();
    }

}
