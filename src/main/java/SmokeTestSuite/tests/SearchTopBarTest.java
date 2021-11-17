package SmokeTestSuite.tests;

import SmokeTestSuite.resources.DataProvidersList;
import SmokeTestSuite.steps.SearchTopBarSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTopBarTest extends BaseTest {

    @Inject
    SearchTopBarSteps searchTopBarSteps;

    @Test(dataProvider = "topBarSearchRequest", dataProviderClass = DataProvidersList.class)
    public void searchUsingTopBar(String searchRequest) {
        searchTopBarSteps.findBySearchRequest(searchRequest);
        String searchedProductName = searchTopBarSteps.getSearchedProductName(searchRequest);
        assertThat(searchedProductName).contains(searchRequest);
    }

}
