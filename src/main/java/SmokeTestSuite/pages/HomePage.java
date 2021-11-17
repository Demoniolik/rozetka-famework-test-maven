package SmokeTestSuite.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class HomePage extends BasePage {

    private static final String USER_ACCOUNT_BTN = "//rz-user";
    private static final String COMPARE_HEADER_BTN = "//rz-comparison";
    private static final String USER_LOGIN_INPUT = "//input[@formcontrolname = 'login']";
    private static final String USER_PASSWORD_INPUT = "//input[@formcontrolname = 'password']";
    private static final String LOGIN_BTN = "//button[contains (text(), 'Войти')]";
    private static final String REGISTRATION_BTN = "//a[contains (text(), 'Зарегистрироваться')]";
    private static final String REGISTRATION_SUBMIT_BTN = "//button[@type = 'submit']";
    private static final String CAPTCHA_FRAME = "//iframe[@title = 'reCAPTCHA']";
    private static final String CAPTCHA_MODAL = "//div[@id = 'rc-anchor-container']";
    private static final String TOP_SEARCH_BAR = "//input[@name = 'search']";
    private static final String SEARCH_BTN = "//button[contains (text(), 'Найти')]";
    private static final String BASKET_BTN = "//rz-cart";
    private static final String CLOSE_BASKET_BTN = "//button[@aria-label = 'Закрыть модальное окно']";
    private static final String BASKET_TOTAL_PRICE = "//div[@class = 'cart-receipt__sum-price']/span";
    private static final String SUBCATEGORY_NAME = "//ul/li/a[contains (text(), '%s')]";
    private static final String PRODUCT_NAME_IN_BASKET = "//div[@class = 'cart-product__main']/" +
            "a[contains (text(), '%s')]";
    private static final String SIDEMENU_CATEGORY_OPTION = "//sidebar-fat-menu/div/ul/li/" +
            "a[contains (text(), '%s')]";
    private static final String COMPARISON_CATEGORY = "//a[contains (text(), '%s')]";

    public void clickUserAccountBtn() {
        $x(USER_ACCOUNT_BTN).click();
    }

    public void inputUserLogin(String userLogin) {
        $x(USER_LOGIN_INPUT).setValue(userLogin);
    }

    public void inputUserPassword(String userPassword) {
        $x(USER_PASSWORD_INPUT).setValue(userPassword);
    }

    public void clickLoginBtn() {
        $x(LOGIN_BTN).click();
    }

    public void clickRegistrationBtn() {
        $x(REGISTRATION_BTN).click();
    }

    public void inputSearchRequest(String searchRequest) {
        $x(TOP_SEARCH_BAR).setValue(searchRequest);
    }

    public void clickSearchBtn() {
        $x(SEARCH_BTN).click();
    }

    public void clickCategoryOption(String searchCategory) {
        $x(String.format(SIDEMENU_CATEGORY_OPTION, searchCategory)).click();
    }

    public void clickHeaderComparisonBtn() {
        $x(COMPARE_HEADER_BTN).click();
    }

    public void selectComparisonCategory(String subCategoryName) {
        $x(String.format(COMPARISON_CATEGORY, subCategoryName)).click();
    }

    public void closeBasket() {
        $x(CLOSE_BASKET_BTN).click();
    }

    public void clickBasketBtn() {
        $x(BASKET_BTN).click();
    }

    public String getRegistrationButtonSubmitType() {
        return $x(REGISTRATION_SUBMIT_BTN).attr("type");
    }

    public String getCaptchaId() {
        String captchaFrameName = $x(CAPTCHA_FRAME).attr("name");
        switchTo().frame(Objects.requireNonNull(captchaFrameName));
        return $x(CAPTCHA_MODAL).attr("id");
    }

    public List<String> getComparisonSubCategories(String firstSubCategory, String secondSubCategory) {
        List<String> subCategoriesList = new ArrayList<>();
        subCategoriesList.add($x(String.format(SUBCATEGORY_NAME,
                firstSubCategory)).getText());
        subCategoriesList.add($x(String.format(SUBCATEGORY_NAME,
                secondSubCategory)).getText());
        return subCategoriesList;
    }

    public String getProductNameInBasket(String product) {
        return $x(String.format(PRODUCT_NAME_IN_BASKET, product)).getText();
    }

    public String getBasketTotalPrice() {
        return $x(BASKET_TOTAL_PRICE).getText();
    }
}
