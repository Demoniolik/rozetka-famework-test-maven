package SmokeTestSuite.steps;

import SmokeTestSuite.pages.HomePage;
import com.google.inject.Inject;
import org.testng.annotations.Guice;

@Guice
public class SuccessfulLoginSteps {

    @Inject
    HomePage homePage;

    public void openUserLoginForm() {
        homePage.clickUserAccountBtn();
    }

    public void inputValidUserCredentials(String userLogin, String userPassword) {
        homePage.inputUserLogin(userLogin);
        homePage.inputUserPassword(userPassword);
    }

    public void loginToAccount() {
        homePage.clickLoginBtn();
    }

    public String verifyCaptchaDisplayed() {
        return homePage.getCaptchaId();
    }

}
