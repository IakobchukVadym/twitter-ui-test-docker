package com.qa.twitter.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class Tweet {
    private static final By TWEET_TEXT = By.cssSelector("div:nth-child(2) > div:nth-child(2) > span");
    private static final By OPTIONS_BUTTON = By.cssSelector("[data-testid='caret']");
    private static final By EXTRAOPTIONS = By.cssSelector("[role='menuitem']");

    private static final By DELETE_TWEET_BUTTON = By.cssSelector("[data-testid='confirmationSheetConfirm']");

    private SelenideElement tweetElement;

    public Tweet(SelenideElement tweetElement) {
        this.tweetElement = tweetElement;
    }

    public String getText() {
        return tweetElement.$(TWEET_TEXT).getText();
    }

    private void clickOnOptions() {
        tweetElement.$(OPTIONS_BUTTON).click();
    }

    @Step("Delete tweet")
    public void deleteTweet() {
        clickOnOptions();
        $$(EXTRAOPTIONS).get(0).click();
        $(DELETE_TWEET_BUTTON).click();
    }
}
