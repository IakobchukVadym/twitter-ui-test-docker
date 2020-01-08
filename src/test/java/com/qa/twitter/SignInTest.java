package com.qa.twitter;

import com.qa.twitter.pages.HomePage;
import com.qa.twitter.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.qa.twitter.User.USER_PROD;
import static com.qa.twitter.assertions.PageAssertion.assertHomePageIsLoaded;
import static com.qa.twitter.assertions.PageAssertion.assertLoginPageIsLoaded;

public class SignInTest extends TwitterApp {

    private static final String ERROR_MESSAGE = "The username and password you entered did not match our records. " +
            "Please double-check and try again.";

    @ParameterizedTest
    @EnumSource(value = User.class, names = {"USER_WITH_WRONG_LOGIN", "USER_WITH_WRONG_PASSWORD", "USER_WITH_EMPTY_PASSWORD"})
    void verifyErrorMessageAfterFailedLogin(User user) {
        LoginPage loginPage = loadTwitterLoginPage();
        loginPage.loginWithUserAndExpectError(user);

        Assertions.assertThat(loginPage.getPageSource())
                .as("Error message should be present")
                .contains(ERROR_MESSAGE);
    }

    @Test
    void verifySuccessfulLogin() {
        loadTwitterLoginPage().loginWithUser(USER_PROD);
        assertHomePageIsLoaded();
    }

    @Test
    void verifyLogout() {
        LoginPage loginPage = loadTwitterLoginPage();
        HomePage homePage = loginPage.loginWithUser(USER_PROD);
        homePage.clickOnMoreButton().logout().confirmLogout();

        assertLoginPageIsLoaded();
    }

    @Test
    void verifyLogoutCancellation() {
        LoginPage loginPage = loadTwitterLoginPage();
        HomePage homePage = loginPage.loginWithUser(USER_PROD);
        homePage.clickOnMoreButton().logout().cancelLogout();

        assertHomePageIsLoaded();
    }
}

