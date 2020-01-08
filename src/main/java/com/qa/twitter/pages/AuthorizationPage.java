package com.qa.twitter.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizationPage {
    private static final By LOGIN_BUTTON = By.cssSelector("[data-testid='loginButton']");

    public LoginPage getLoginPage() {
        $(LOGIN_BUTTON).click();
        return page(LoginPage.class);
    }
}
