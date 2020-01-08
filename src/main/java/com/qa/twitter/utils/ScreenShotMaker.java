package com.qa.twitter.utils;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.io.IOException;

public class ScreenShotMaker implements AfterTestExecutionCallback {

    @Attachment(value = "failed test screenshot", type = "image/png")
    private byte[] makeScreenshotOnFailure() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws IOException {
        if (extensionContext.getExecutionException().isPresent()) {
            makeScreenshotOnFailure();
        }
    }
}
