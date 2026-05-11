package com.ventoux.qa.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static List<WebElement> waitForElementsToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void waitAndClick(WebDriver driver, By locator, int timeoutInSeconds) {
        WebElement element = waitForElementToBeVisible(driver, locator, timeoutInSeconds);
        waitForElementToBeClickable(driver, element, timeoutInSeconds);
        element.click();
    }

    // overload when you already have WebElement
    public static void waitAndClick(WebDriver driver, WebElement element, int timeoutInSeconds) {
        waitForElementToBeVisible(driver, element, timeoutInSeconds);
        waitForElementToBeClickable(driver, element, timeoutInSeconds);
        element.click();
    }

	public static void until(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}
