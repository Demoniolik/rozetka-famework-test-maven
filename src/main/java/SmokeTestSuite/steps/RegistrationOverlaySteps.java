package SmokeTestSuite.steps;

import SmokeTestSuite.pages.HomePage;
import com.google.inject.Inject;
import org.testng.annotations.Guice;

@Guice
public class RegistrationOverlaySteps {

    @Inject
    HomePage homePage;

    public void openUserLoginForm() {
        homePage.clickUserAccountBtn();
    }

    public void goToRegistrationOverlay() {
        homePage.clickRegistrationBtn();
    }

    public String verifyRegistrationOverlayDisplayed() {
        return homePage.getRegistrationButtonSubmitType();
    }

}
