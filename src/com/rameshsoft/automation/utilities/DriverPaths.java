package com.rameshsoft.automation.utilities;

import java.io.File;

public final class DriverPaths {

    private DriverPaths() {
        // Prevent instantiation
    }

    public static final String ieKey = "webdriver.ie.driver";
    public static final String ieValue = getDriverPath("IEDriverServer.exe");

    public static final String chromeKey = "webdriver.chrome.driver";
    public static final String chromeValue = getDriverPath("chromedriver.exe");

    public static final String firefoxKey = "webdriver.gecko.driver";
    public static final String firefoxValue = getDriverPath("geckodriver.exe");

    public static final String edgeKey = "webdriver.edge.driver";
    public static final String edgeValue = getDriverPath("msedgedriver.exe");

    private static String getDriverPath(String driverFileName) {
        return System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + driverFileName;
    }
}
