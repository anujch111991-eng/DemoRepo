package com.ventoux.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ventoux.qa.base.testbase;
import com.ventoux.qa.util.testutil;

public class IdentityAppPortal extends testbase{
	
	@FindBy(xpath = "//h3[text()='Ventoux (Dev)']")
	WebElement clickdevbuild;
	
	public IdentityAppPortal() {
		PageFactory.initElements(driver, this);
	}
	
	public TocSelectionPage ClicktoDevApp() {
		// Capture existing handles
		testutil.waitForElementToBeClickable(driver, clickdevbuild, 10);
		clickdevbuild.click();
		//String newHandle = WindowHandler.waitForAndSwitchToNewWindow(driver, existing, waitTimeoutMillis);
		//return new TocSelectionPage();
		return new TocSelectionPage();
	}
}
