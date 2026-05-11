package com.ventoux.qa.util;


import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.ventoux.qa.base.testbase;

public class WindowHandler extends testbase {
	
	/**
     * Returns the current active window handle.
     */
    public static String getCurrentWindow(WebDriver driver) {
        return driver.getWindowHandle();
    }

    /**
     * Waits for a new tab/window to open.
     */
    public static void waitForNewWindow(WebDriver driver, int expectedWindowCount, int timeoutMillis) throws InterruptedException {
        int waited = 0;
        while (driver.getWindowHandles().size() < expectedWindowCount && waited < timeoutMillis) {
            Thread.sleep(500);
            waited += 500;
        }
        if (driver.getWindowHandles().size() < expectedWindowCount) {
            throw new RuntimeException("❌ Expected new window/tab did not open within timeout.");
        }
    }

    /**
     * Switches to the newest window that is not the original one.
     */
    public static String switchToNewWindow(WebDriver driver, String originalWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                return window;
            }
        }
        throw new RuntimeException("❌ No new window found to switch.");
    }

    /**
     * Closes the current tab and switches back to a given window handle.
     */
    public static void closeCurrentWindowAndSwitchBack(WebDriver driver, String returnToWindow) {
        driver.close();
        driver.switchTo().window(returnToWindow);
    }

    /**
     * Get number of open tabs/windows.
     */
    public static int getWindowCount(WebDriver driver) {
        return driver.getWindowHandles().size();
    }
    
    public static String waitForAndSwitchToNewWindow(WebDriver driver, int expectedWindowCount, int timeoutMillis) throws InterruptedException {
        String original = driver.getWindowHandle();
        waitForNewWindow(driver, expectedWindowCount, timeoutMillis);
        return switchToNewWindow(driver, original);
    }

}
