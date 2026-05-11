package com.ventoux.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ventoux.qa.base.testbase;
import com.ventoux.qa.pages.HomePage;
import com.ventoux.qa.pages.IdentityAppPortal;
import com.ventoux.qa.pages.IdentityLogin;
import com.ventoux.qa.pages.TocSelectionPage;
import com.ventoux.qa.util.TabManager;
import com.ventoux.qa.util.WindowHandler;

public class TocSelectionPageTest extends testbase{
	
	 IdentityLogin IDlogin;
	 IdentityAppPortal IDappPortal;
	 TocSelectionPage tocselection;
	 HomePage homepage;
	 WindowHandler WindowHandles;
	 TabManager tabmanager;
	 
	
	public TocSelectionPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 IDlogin = new IdentityLogin();
		 IDappPortal = new IdentityAppPortal();
		 tocselection = new TocSelectionPage();
		 homepage = new HomePage();
		 WindowHandles = new WindowHandler();
		// tabmanager = new TabManager(driver);
	}
	
	@Test
	public void TocPage() throws InterruptedException {
		IDappPortal = IDlogin.login(prop.getProperty("username"), prop.getProperty("password"));
		// Refresh tab list AFTER the new tab is opened
		IDappPortal.ClicktoDevApp();
		WindowHandler.waitForAndSwitchToNewWindow(driver, 2, 10000);
		// Perform action		
		tocselection.clicktoclist();
		tocselection.clickgwr();
		
		//tabmanager.refreshTabHandles();

		// Debug tab count
		//System.out.println("Tabs open: " + tabmanager.getTabCount());
		
		//tabmanager.switchToTab(1);
		//System.out.println("Switched to ToC Tab: " + tabmanager.getCurrentTabTitle());


		//tabmanager.switchToTab(2);
		
	}
	
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}

	
}
