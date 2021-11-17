package SmokeTestSuite.tests;

import SmokeTestSuite.resources.DataProvidersList;
import SmokeTestSuite.steps.SearchSideBarSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchSideBarTest extends BaseTest {

    @Inject
    SearchSideBarSteps searchSideBarSteps;

    @Test(dataProvider = "sideBarSearchRequest", dataProviderClass = DataProvidersList.class)
    public void searchUsingSideBar(String categoryName, String subCategoryName) {
        searchSideBarSteps.selectProductCategory(categoryName);
        searchSideBarSteps.selectProductSubCategory(categoryName, subCategoryName);
        String searchedSubCategory = searchSideBarSteps.getSubcategoryName(subCategoryName);
        assertThat(searchedSubCategory).contains(subCategoryName);
    }

}
