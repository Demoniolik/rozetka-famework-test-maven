package SmokeTestSuite.tests;

import SmokeTestSuite.resources.DataProvidersList;
import SmokeTestSuite.steps.SuccessfulLoginSteps;
import com.google.inject.Inject;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SuccessfulLoginTest extends BaseTest {

    private static final String CAPTCHA_MODAL = "rc-anchor-container";

    @Inject
    SuccessfulLoginSteps successfulLoginSteps;

    @Test(dataProvider = "LoginCredentials", dataProviderClass = DataProvidersList.class)
    public void loginToAccount(String userLogin, String userPassword) {
        successfulLoginSteps.openUserLoginForm();
        successfulLoginSteps.inputValidUserCredentials(userLogin, userPassword);
        successfulLoginSteps.loginToAccount();
        String captchaModal = successfulLoginSteps.verifyCaptchaDisplayed();
        assertThat(captchaModal).contains(CAPTCHA_MODAL);
    }

}
