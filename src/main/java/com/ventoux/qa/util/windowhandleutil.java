package com.ventoux.qa.util;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.ventoux.qa.base.testbase;

public class windowhandleutil extends testbase{
	
	/**
     * Returns the current active window handle (working tab).
     */
    public static String getCurrentWindow(WebDriver driver) {
        return driver.getWindowHandle();
    }

    /*
     * Waits until a new tab/window opens after a known action (e.g., clicking a Doc button).
     */
    public static void waitForNewWindow(WebDriver driver, Set<String> existingHandles, int timeoutMillis) throws InterruptedException {
        int waited = 0;
        while (driver.getWindowHandles().size() <= existingHandles.size() && waited < timeoutMillis) {
            Thread.sleep(500);
            waited += 500;
        }
        if (driver.getWindowHandles().size() <= existingHandles.size()) {
            throw new RuntimeException("❌ New window/tab did not open within timeout.");
        }
    }

    /**
     * Returns the new window handle that wasn't in the original set.
     */
    public static String getNewWindowHandle(Set<String> originalHandles, Set<String> updatedHandles) {
        for (String handle : updatedHandles) {
            if (!originalHandles.contains(handle)) {
                return handle;
            }
        }
        throw new RuntimeException("❌ Could not find new window handle.");
    }

    /**
     * Full flow: Waits for new tab (e.g., Doc), switches to it, gets its URL, closes it,
     * then switches back to the working tab (Dev App).
     * @return The URL of the Doc tab before closing it
     */
    public static String handleDocTabAndReturn(WebDriver driver, String workingTabHandle) throws InterruptedException {
        Set<String> originalHandles = driver.getWindowHandles();

        // Wait for new window to appear
        waitForNewWindow(driver, originalHandles, 10000);

        Set<String> updatedHandles = driver.getWindowHandles();
        String docTabHandle = getNewWindowHandle(originalHandles, updatedHandles);

        // Switch to Doc tab
        driver.switchTo().window(docTabHandle);
        String docUrl = driver.getCurrentUrl();

        // Close Doc tab
        driver.close();

        // Switch back to Dev Application tab
        driver.switchTo().window(workingTabHandle);

        return docUrl;
    }

    /**
     * Returns how many windows/tabs are currently open.
     */
    public static int getWindowCount(WebDriver driver) {
        return driver.getWindowHandles().size();
    }

}
