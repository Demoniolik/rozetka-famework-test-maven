package SmokeTestSuite.tests;

import SmokeTestSuite.steps.RegistrationOverlaySteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DisplayRegistrationOverlayTest extends BaseTest {

    @Inject
    RegistrationOverlaySteps registrationOverlaySteps;

    @Test
    public void accessRegistrationOverlay() {
        registrationOverlaySteps.openUserLoginForm();
        registrationOverlaySteps.goToRegistrationOverlay();
        String registrationOverlay = registrationOverlaySteps.verifyRegistrationOverlayDisplayed();
        assertThat(registrationOverlay).contains("submit");
    }

}
