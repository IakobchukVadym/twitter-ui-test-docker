package com.qa.twitter.utils;

public class Properties {
    private static final String BROWSER = System.getProperty("browser");
    private static final String BROWSER_VERSION = System.getProperty("browser.version");
    private static final String BASE_URL = System.getProperty("baseUrl");
    private static final String RUN_TYPE = System.getProperty("runType");

    private Properties() {
    }

    public static String getBrowser() {
        return BROWSER.toLowerCase();
    }

    public static String getBrowserVersion() {
        return BROWSER_VERSION;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getRunType() {
        return RUN_TYPE;
    }
}
