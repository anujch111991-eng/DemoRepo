package com.ventoux.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ventoux.qa.base.testbase;
import com.ventoux.qa.pages.IdentityAppPortal;
import com.ventoux.qa.pages.IdentityLogin;
import com.ventoux.qa.pages.TocSelectionPage;

public class IdentityLoginTest extends testbase{
	
	 IdentityLogin IDlogin;
	 IdentityAppPortal IDappPortal;
	
	public IdentityLoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 IDlogin = new IdentityLogin();
		 IDappPortal = new IdentityAppPortal();
	}
	
	@Test
	public void IdentityLogin() throws InterruptedException {
		IDappPortal = IDlogin.login(prop.getProperty("username"), prop.getProperty("password"));
		
		IDappPortal.ClicktoDevApp();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}

}
