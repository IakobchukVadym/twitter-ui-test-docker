package com.qa.twitter.pages;

import org.openqa.selenium.By;

public class CommonSelectors {
    static final By HOME_BUTTON = By.cssSelector("[data-testid='AppTabBar_Home_Link']");
    static final By EXPLORE_BUTTON = By.cssSelector("[data-testid='AppTabBar_Explore_Link']");
    static final By NOTIFICATIONS_BUTTON = By.cssSelector("[data-testid='AppTabBar_Notifications_Link']");
    static final By MESSAGES_BUTTON = By.cssSelector("[data-testid='AppTabBar_DirectMessage_Link']");
    static final By BOOKMARKS_BUTTON = By.cssSelector("[href='/i/bookmarks]']");
    static final By LISTS_BUTTON = By.cssSelector("[aria-label='Lists']");
    static final By PROFILE_BUTTON = By.cssSelector("[aria-label='Profile']");
    static final By MORE_BUTTON = By.cssSelector("[aria-label='More menu items']");
    static final By TWEET = By.cssSelector("[data-testid='tweet']");
    static final By DELETED_TWEET_MESSAGE = By.cssSelector("[data-testid='toast']");

    private CommonSelectors() {
    }
}
