package com.qa.twitter;

import com.qa.twitter.pages.HomePage;
import com.qa.twitter.pages.ProfilePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static com.qa.twitter.User.USER_PROD;

public class TweetTest extends TwitterApp {

    @Test
    void verifySuccessfulTweetCreation() {
        String text = RandomStringUtils.randomAlphabetic(10);
        HomePage homePage = sendTwit(text);

        Assertions.assertThat(homePage.getFirstTweet().getText())
                .as("First tweet in timeline should have the same text")
                .isEqualTo(text);
    }

    @Test
    void verifySuccessfulTweetDeletion() {
        String text = RandomStringUtils.randomAlphabetic(10);
        HomePage homePage = sendTwit(text);
        ProfilePage profilePage = homePage.clickOnProfileButton();

        profilePage.getFirstTweet().deleteTweet();
        String firstTweetTextAfterDeletion = profilePage.getFirstTweet().getText();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(text)
                .as("Tweets should be different")
                .isNotEqualTo(firstTweetTextAfterDeletion);

        softAssertions.assertThat(profilePage.deletedTweetMessageIsShown())
                .as("Deleted Tweet Message should be visible")
                .isTrue();
        softAssertions.assertAll();
    }

    private HomePage sendTwit(String text) {
        HomePage homePage = loadTwitterLoginPage().loginWithUser(USER_PROD);
        homePage.sendTweet(text);
        return homePage;
    }
}
