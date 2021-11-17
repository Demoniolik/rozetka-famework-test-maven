package SmokeTestSuite.resources;

import org.testng.annotations.DataProvider;

public class DataProvidersList {

    @DataProvider(name = "productSearchRequest")
    public static Object[][] getSearchRequest() {
        return new Object[][] {
                {"Drambuie"}
        };
    }

    @DataProvider(name = "productsSearchRequest")
    public static Object[][] getSearchRequestBasket() {
        return new Object[][] {
                {"Drambuie", "Proper № Twelve", 2295}
        };
    }

    @DataProvider(name = "productComparison")
    public static Object[][] getProductData() {
        return new Object[][] {
                {"Алкогольные напитки и продукты", "Ликеры и аперитивы", "Jägermeister", "Aperol"}
        };
    }

    @DataProvider(name = "invalidProductComparison")
    public static Object[][] getProductDataInvalidComparison() {
        return new Object[][] {
                {"Виски", "Ликеры и аперитивы", "Proper № Twelve", "Drambuie"}
        };
    }

    @DataProvider(name = "sideBarSearchRequest")
    public static Object[][] getSearchRequestSideBar() {
        return new Object[][]{
                {"Алкогольные напитки и продукты", "Ликеры и аперитивы"}
        };
    }

    @DataProvider(name = "filteringByPrice")
    public static Object[][] getGoodsFilteredByPrice() {
        return new Object[][]{
                {"Алкогольные напитки и продукты", "Ликеры и аперитивы", "500", "900"}
        };
    }

    @DataProvider(name = "topBarSearchRequest")
    public static Object[][] getSearchRequestTopBar() {
        return new Object[][] {
                {"Drambuie"}
        };
    }

    @DataProvider(name = "LoginCredentials")
    public static Object[][] getLoginCredentials() {
        return new Object[][] {
                {"testemail@gmail.com", "Password123!"}
        };
    }

}
