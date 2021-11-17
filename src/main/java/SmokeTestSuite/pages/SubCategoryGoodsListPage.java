package SmokeTestSuite.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class SubCategoryGoodsListPage extends BasePage {

    private static final String PRODUCT_SUBCATEGORY_NAME = "//h1[@class]";
    private static final String CONFIRM_AGE_BTN = "//a[contains (text(), 'Да, исполнилось')]";
    private static final String COMPARISON_PRODUCT = "//span[contains (text(), '%s')]/../../div/" +
            "app-compare-button/button";
    private static final String SORTING_DROPDOWN_BTN = "//select";
    private static final String PRICE_DESC_OPTION = "//option[contains (text(), 'От дорогих к дешевым')]";
    private static final String PRODUCT_PRICE = "//span[@class = 'goods-tile__price-value']";
    private static final String FILTER_PRICE_LOWEST = "//div[@class = 'slider-filter__inner']/input[1]";
    private static final String FILTER_PRICE_HIGHEST = "//div[@class = 'slider-filter__inner']/input[2]";
    private static final String FILTER_PRICE_OK_BTN = "//div[@class = 'slider-filter__inner']/button";

    public void waitForPageLoad(String subCategoryName) {
        Objects.requireNonNull(title()).contains(subCategoryName);
    }

    public void clickConfirmAgeBtn() {
        $x(CONFIRM_AGE_BTN).click();
    }

    public String getSearchedProductSubCategory() {
        return $x(PRODUCT_SUBCATEGORY_NAME).getText();
    }

    public void clickComparisonBtn(String productForComparison) {
        $x(String.format(COMPARISON_PRODUCT, productForComparison)).click();
    }

    public void clickSortingDropdownBtn() {
        $x(SORTING_DROPDOWN_BTN).click();
    }

    public void selectPriceDescOption() {
        $x(PRICE_DESC_OPTION).click();
    }

    public List<String> getPriceList() {
        ElementsCollection prices = $$x(PRODUCT_PRICE);
        List<String> sortedTextPrices = new ArrayList<>();
        for (WebElement price : prices) {
            sortedTextPrices.add(price.getText());
        }
        return sortedTextPrices;
    }

    public void applyPriceFilter(String lowestPrice, String highestPrice) {
        $x(FILTER_PRICE_LOWEST).clear();
        $x(FILTER_PRICE_LOWEST).setValue(lowestPrice);
        $x(FILTER_PRICE_HIGHEST).clear();
        $x(FILTER_PRICE_HIGHEST).setValue(highestPrice);
        $x(FILTER_PRICE_OK_BTN).click();
    }
}
