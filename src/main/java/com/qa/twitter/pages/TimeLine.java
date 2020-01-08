package com.qa.twitter.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.qa.twitter.pages.CommonSelectors.DELETED_TWEET_MESSAGE;
import static com.qa.twitter.pages.CommonSelectors.TWEET;
import static java.util.stream.Collectors.toList;

public interface TimeLine {

    @Step("Get tweets from timeline")
    default List<Tweet> getListOfTweets() {
        $(TWEET).shouldBe(Condition.visible);
        ElementsCollection tweets = $$(TWEET);
        return tweets.stream()
                .map(Tweet::new)
                .collect(toList());
    }

    default Tweet getFirstTweet() {
        return getListOfTweets().get(0);
    }

    default boolean deletedTweetMessageIsShown() {
        $(DELETED_TWEET_MESSAGE).shouldBe(Condition.visible);
        return $(DELETED_TWEET_MESSAGE).isDisplayed();
    }
}
