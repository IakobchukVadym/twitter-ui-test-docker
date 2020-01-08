package com.qa.twitter.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class HomePage implements SideBar, TimeLine {

    private static final By TWEET_FIELD = By.cssSelector(
            ".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr");
    private static final By TWEET_BUTTON = By.cssSelector("[data-testid='tweetButtonInline']");
    private static final By PROGRESS_BAR = By.cssSelector("[role='progressbar']");

    @Override
    public List<Tweet> getListOfTweets() {
        waitProgressBarToLoad();
        return TimeLine.super.getListOfTweets();
    }

    @Step("Send tweet {tweet}")
    public void sendTweet(String tweet) {
        $(TWEET_FIELD).sendKeys(tweet);
        $(TWEET_BUTTON).click();
        log.info("Sending tweet " + tweet);
    }

    private void waitProgressBarToLoad() {
        $(PROGRESS_BAR).shouldHave(attribute("aria-valuenow", "0"));
    }
}
