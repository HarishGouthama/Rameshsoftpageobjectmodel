package com.rameshsoft.automation.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.rameshsoft.automation.base.BaseTest;

public interface ScrrenshotUtility {

    public static String takeScreenshot() throws IOException {
        WebDriver driver = BaseTest.getDriver();
        if (driver == null) {
            throw new NullPointerException("WebDriver is not initialized.");
        }

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File img = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String imagePath = BaseTest.getPath() + "\\Screenshots\\" + BaseTest.getTcName() + ".jpeg";
        FileUtils.copyFile(img, new File(imagePath));
        return imagePath;
    }

    public static String takeScreenshot(String tcName) throws IOException {
        WebDriver driver = BaseTest.getDriver();
        if (driver == null) {
            throw new NullPointerException("WebDriver is not initialized.");
        }

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File img = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String imagePath = BaseTest.getPath() + "\\Screenshots\\" + tcName + ".jpeg";
        FileUtils.copyFile(img, new File(imagePath));
        return imagePath;
    }
}
