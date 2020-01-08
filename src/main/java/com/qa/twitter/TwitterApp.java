package com.qa.twitter;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.qa.twitter.pages.AuthorizationPage;
import com.qa.twitter.pages.LoginPage;
import com.qa.twitter.utils.ScreenShotMaker;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;
import static com.qa.twitter.utils.Properties.getBaseUrl;
import static com.qa.twitter.utils.Properties.getBrowser;
import static com.qa.twitter.utils.Properties.getBrowserVersion;
import static com.qa.twitter.utils.Properties.getRunType;
import static org.openqa.selenium.logging.LogType.BROWSER;

@Log4j2
@ExtendWith(ScreenShotMaker.class)
public abstract class TwitterApp {

    @BeforeAll
    static void setUp() {
        Configuration.browser = getBrowser();
        Configuration.baseUrl = getBaseUrl();
        Configuration.screenshots = false;

        if ("local".equals(getRunType())) {
            Configuration.browserSize = "1366x768";
        } else if ("docker".equals(getRunType())) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            DesiredCapabilities browser = new DesiredCapabilities();
            browser.setBrowserName(BROWSER);
            browser.setVersion(getBrowserVersion());
            browser.setCapability("enableVNC", true);
            browser.setCapability("enableVideo", false);
            Configuration.browserCapabilities = browser;
        }

        log.info("Testing started with: " +
                "\nRun Type: " + getRunType() +
                "\nBrowser: " + getBrowser() +
                "\nBase Url: " + getBaseUrl());
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    protected LoginPage loadTwitterLoginPage() {
        open("");
        return new AuthorizationPage().getLoginPage();
    }
}
