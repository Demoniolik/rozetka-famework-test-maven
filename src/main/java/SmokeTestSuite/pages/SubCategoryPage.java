package SmokeTestSuite.pages;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;

public class SubCategoryPage extends BasePage {

    private static final String SUBCATEGORY_NAME = "//a[contains (text(), '%s')]";

    public void waitForPageLoad(String categoryName) {
        Objects.requireNonNull(title()).contains(categoryName);
    }

    public void clickSubCategoryOption(String subCategoryName) {
        $x(String.format(SUBCATEGORY_NAME, subCategoryName)).click();
    }
}
