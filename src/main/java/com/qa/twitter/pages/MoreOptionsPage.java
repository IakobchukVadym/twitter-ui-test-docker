package com.qa.twitter.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MoreOptionsPage {
    private static By LOGOUT_BUTTON = By.cssSelector("[data-testid='logout']");

    public LogoutPage logout() {
        $(LOGOUT_BUTTON).click();
        return page(LogoutPage.class);
    }
}
