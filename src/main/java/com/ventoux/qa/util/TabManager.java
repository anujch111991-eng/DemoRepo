package com.ventoux.qa.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.ventoux.qa.base.testbase;

public class TabManager extends testbase{
	
	private WebDriver driver;
    private List<String> tabs;

    public TabManager(WebDriver driver) {
        this.driver = driver;
        refreshTabHandles();
    }

    // Refresh list of current tabs
    public void refreshTabHandles() {
        this.tabs = new ArrayList<>(driver.getWindowHandles());
    }

    // Switch to tab by index
    public void switchToTab(int index) {
        refreshTabHandles();
        if (index >= 0 && index < tabs.size()) {
            driver.switchTo().window(tabs.get(index));
        } else {
            throw new IllegalArgumentException("Invalid tab index: " + index);
        }
    }

    // Close current tab
    public void closeCurrentTab() {
        driver.close();
        refreshTabHandles();
    }

    // Get number of open tabs
    public int getTabCount() {
        refreshTabHandles();
        return tabs.size();
    }

    // Get current tab title
    public String getCurrentTabTitle() {
        return driver.getTitle();
    }

    // Switch to last tab
    public void switchToLastTab() {
        refreshTabHandles();
        switchToTab(tabs.size() - 1);
    }

}
