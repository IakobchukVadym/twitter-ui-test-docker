package com.qa.twitter.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LogoutPage {
    private static By CONFIRM_BUTTON = By.cssSelector("[data-testid='confirmationSheetConfirm']");
    private static By CANCEL_BUTTON = By.cssSelector("[data-testid='confirmationSheetCancel']");

    public LoginPage confirmLogout() {
        $(CONFIRM_BUTTON).click();
        return page(LoginPage.class);
    }

    public HomePage cancelLogout() {
        $(CANCEL_BUTTON).click();
        return page(HomePage.class);
    }
}
