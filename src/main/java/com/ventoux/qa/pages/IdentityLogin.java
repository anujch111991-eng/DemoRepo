package com.ventoux.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ventoux.qa.base.testbase;
import com.ventoux.qa.util.testutil;

public class IdentityLogin extends testbase{
	
	@FindBy(xpath = "//div[@class='panel panel-left-border col-md-6 col-lg-6']//input[@id='signInFormUsername']")
	WebElement username;
	
	@FindBy(xpath = "//div[@class='panel panel-left-border col-md-6 col-lg-6']//input[@id='signInFormPassword']")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='panel panel-left-border col-md-6 col-lg-6']//input[@name='signInSubmitButton']")
	WebElement loginbtn1;
	
	@FindBy(xpath = "//input[@value='SOFTWARE_TOKEN_MFA']")
	WebElement click_auth_app;
	
	@FindBy(xpath = "//input[@value='EMAIL_OTP']")
	WebElement email_otp;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement continueauth;
	
	@FindBy(xpath = "//form[@name='mfaform']//button[@id='signInButton']")
	WebElement signin_btn;
	
	@FindBy(xpath = "//div[@class='relative']//div[text()='Ventoux (Dev)']")
	WebElement clickdevbuild;
	
	
	// Now Initialize all above repository
	public IdentityLogin() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	
	public String validateloginpageURL() {
		return driver.getCurrentUrl();
	}
	
	public IdentityAppPortal login(String un, String ps) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(ps);
		loginbtn1.click();
		//Thread.sleep(5000);
		//testutil.waitForElementToBeClickable(driver, click_auth_app, 30);
		//click_auth_app.click();
		testutil.waitForElementToBeClickable(driver, email_otp, 30);
		email_otp.click();
		testutil.waitForElementToBeClickable(driver, continueauth, 30);
		continueauth.click();
		Thread.sleep(25000);
		signin_btn.click();
		//testutil.waitForElementToBeClickable(driver, clickdevbuild, 30);
		//clickdevbuild.click();
		
		return new IdentityAppPortal();
	}

}
