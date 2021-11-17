package SmokeTestSuite.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class ComparisonPage extends BasePage {

    private static final String PRODUCT_NAME = "//a[contains (text(), '%s')]";

    public void waitForPageLoad(String subCategoryName) {
        Objects.requireNonNull(title()).contains(subCategoryName);
    }

    public List<String> getComparedProductNames(String firstProduct, String secondProduct) {
        List<String> productNames = new ArrayList<>();
        productNames.add($x(String.format(PRODUCT_NAME, firstProduct)).getText());
        productNames.add($x(String.format(PRODUCT_NAME, secondProduct)).getText());
        return productNames;
    }
}
