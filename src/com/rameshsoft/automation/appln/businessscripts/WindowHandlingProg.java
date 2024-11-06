package com.rameshsoft.automation.appln.businessscripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;

abstract public class WindowHandlingProg {
    public static void main(String[] args) throws InterruptedException {
        
        System.setProperty("webdriver.chrome.driver", "D:\\RameshSoft2directory\\Rameshsoft-PageObjectFramework\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Increased wait time
        
        driver.get("https://rameshsoft.com");
        
        // Click on the 'Videos' link
        driver.findElement(By.xpath("//a[text() = 'Videos']")).click();
        
        // Get the current window handle (parent window)
        String curWinName = driver.getWindowHandle();
        System.out.println("Current Window Handle: " + curWinName);
        
        // Get all window handles
        Set<String> windows = driver.getWindowHandles(); // Parent and new window
        
        for (String windowHandle : windows) {
            // Switch to the new window, skipping the current window
            if (!windowHandle.equals(curWinName)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to window: " + windowHandle);
            }
        }
        
        // Adding an explicit wait to ensure the element is available after switching
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
        try {
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='search-input']/input")));
            searchBox.sendKeys("RAMESHSOFT");
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException caught, retrying...");
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='search-input']/input")));
            searchBox.sendKeys("RAMESHSOFT");
        }

        Thread.sleep(5000); // Just to visually confirm actions, can be removed in production

        // Close the current window (child window)
        driver.close();

        // Switch back to the original (parent) window
        driver.switchTo().window(curWinName);

        // Optionally, perform further actions on the parent window

        // Close the parent window (optional, depending on your use case)
        driver.quit();
    }
}
