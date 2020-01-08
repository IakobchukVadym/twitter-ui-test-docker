package com.qa.twitter.pages;

import com.qa.twitter.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.source;

public class LoginPage {
    private static final By LOGIN_FIELD = By.cssSelector("input[name='session[username_or_email]'][dir='auto']");
    private static final By PASSWORD_FIELD = By.cssSelector("input[name='session[password]'][dir='auto']");
    private static final By LOGIN_BUTTON = By.cssSelector("[data-testid='LoginForm_Login_Button']");

    public HomePage loginWithUser(User user) {
        login(user);
        return page(HomePage.class);
    }

    public void loginWithUserAndExpectError(User user) {
        login(user);
    }

    @Step("Login with {user.name}")
    private void login(User user) {
        $(LOGIN_FIELD).sendKeys(user.getLogin());
        $(PASSWORD_FIELD).sendKeys(user.getPassword());
        $(LOGIN_BUTTON).click();
    }

    public String getPageSource() {
        return source();
    }
}
