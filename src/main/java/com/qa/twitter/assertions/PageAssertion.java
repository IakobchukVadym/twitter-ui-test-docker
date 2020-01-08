package com.qa.twitter.assertions;

import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PageAssertion {

    public static void assertHomePageIsLoaded() {
        sleep(200);
        Assertions.assertThat(url())
                .as("Home Page is expected to be present")
                .isEqualTo("https://twitter.com/home");
    }

    public static void assertLoginPageIsLoaded() {
        Assertions.assertThat(url())
                .as("Home Page is expected to be present")
                .contains("https://twitter.com/logout");
    }
}
