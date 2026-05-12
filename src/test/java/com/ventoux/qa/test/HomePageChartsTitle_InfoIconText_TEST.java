package com.ventoux.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ventoux.qa.base.testbase;
import com.ventoux.qa.pages.HomePageChartsTitle_InfoIconText;
import com.ventoux.qa.pages.IdentityAppPortal;
import com.ventoux.qa.pages.IdentityLogin;
import com.ventoux.qa.pages.TocSelectionPage;
import com.ventoux.qa.util.WindowHandler;

public class HomePageChartsTitle_InfoIconText_TEST extends testbase {

	IdentityLogin IDlogin;
	IdentityAppPortal IDappPortal;
	TocSelectionPage tocselection;
	WindowHandler WindowHandles;
	HomePageChartsTitle_InfoIconText ChartDetails;

	public HomePageChartsTitle_InfoIconText_TEST() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		IDlogin = new IdentityLogin();
		IDappPortal = new IdentityAppPortal();
		tocselection = new TocSelectionPage();
		WindowHandles = new WindowHandler();
		ChartDetails = new HomePageChartsTitle_InfoIconText();
		IDappPortal = IDlogin.login(prop.getProperty("username"), prop.getProperty("password"));
		// Refresh tab list AFTER the new tab is opened
		IDappPortal.ClicktoDevApp();
		WindowHandler.waitForAndSwitchToNewWindow(driver, 2, 10000);
		// Perform action
		tocselection.clicktoclist();
		tocselection.clickgwr();
	}

	@Test(priority = 1)
	public void printAllChartsInfo() {
		// IDappPortal = IDlogin.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		// Refresh tab list AFTER the new tab is opened
		// IDappPortal.ClicktoDevApp();
		// WindowHandler.waitForAndSwitchToNewWindow(driver, 2, 10000);
		// Perform action
		// tocselection.clicktoclist();
		// tocselection.clickgwr();

		ChartDetails.InfoIconDetails();
		String chartTitle = ChartDetails.GetChartTitle();
		System.out.println("Chart Title: " + chartTitle);
		ChartDetails.printLegends();
		ChartDetails.VerifyZoomIn();
		ChartDetails.ClickResetButton();
		ChartDetails.InfoIconDetails_Opt_Services();
		
	}

	/*
	 * @Test(priority = 2) public void ChartZoomInZoomOut() throws
	 * InterruptedException {
	 * 
	 * IDappPortal = IDlogin.login(prop.getProperty("username"),
	 * prop.getProperty("password")); // Refresh tab list AFTER the new tab is
	 * opened IDappPortal.ClicktoDevApp();
	 * WindowHandler.waitForAndSwitchToNewWindow(driver, 2, 10000); // Perform
	 * action tocselection.clicktoclist(); tocselection.clickgwr();
	 * 
	 * 
	 * ChartTitle_InfoIcon.VerifyZoomIn(); ChartTitle_InfoIcon.ClickResetButton(); }
	 */

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
