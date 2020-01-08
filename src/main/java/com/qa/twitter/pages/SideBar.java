package com.qa.twitter.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.qa.twitter.pages.CommonSelectors.BOOKMARKS_BUTTON;
import static com.qa.twitter.pages.CommonSelectors.EXPLORE_BUTTON;
import static com.qa.twitter.pages.CommonSelectors.HOME_BUTTON;
import static com.qa.twitter.pages.CommonSelectors.LISTS_BUTTON;
import static com.qa.twitter.pages.CommonSelectors.MESSAGES_BUTTON;
import static com.qa.twitter.pages.CommonSelectors.MORE_BUTTON;
import static com.qa.twitter.pages.CommonSelectors.NOTIFICATIONS_BUTTON;
import static com.qa.twitter.pages.CommonSelectors.PROFILE_BUTTON;

public interface SideBar {

    default HomePage clickOnHomeButton() {
        $(HOME_BUTTON).click();
        return page(HomePage.class);
    }

    default ExplorePage clickOnExploreButton() {
        $(EXPLORE_BUTTON).click();
        return page(ExplorePage.class);
    }

    default NotificationsPage clickOnNotifocationsButton() {
        $(NOTIFICATIONS_BUTTON).click();
        return page(NotificationsPage.class);
    }

    default MessagesPage clickOnMessagesButton() {
        $(MESSAGES_BUTTON).click();
        return page(MessagesPage.class);
    }

    default BookmarksPage clickOnBookmarksButton() {
        $(BOOKMARKS_BUTTON).click();
        return page(BookmarksPage.class);
    }

    default ListsPage clickOnListsButton() {
        $(LISTS_BUTTON).click();
        return page(ListsPage.class);
    }

    @Step("Navigate to Profile Page")
    default ProfilePage clickOnProfileButton() {
        $(PROFILE_BUTTON).click();
        return page(ProfilePage.class);
    }

    default MoreOptionsPage clickOnMoreButton() {
        $(MORE_BUTTON).click();
        return page(MoreOptionsPage.class);
    }
}
