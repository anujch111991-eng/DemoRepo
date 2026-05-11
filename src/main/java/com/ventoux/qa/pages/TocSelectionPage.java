package com.ventoux.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ventoux.qa.base.testbase;
import com.ventoux.qa.util.testutil;

public class TocSelectionPage extends testbase{
	
	By tocnames = By.xpath("//button[normalize-space()]");
	
	@FindBy(xpath = "//div[@class=\"css-1xc3v61-indicatorContainer\"]")
	WebElement click_TOC_List;
	
	@FindBy(xpath = "//div[@class='css-1shug0c-menu']//div[text()='GWR']")
	WebElement clickGWR;
	
	public TocSelectionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<String> getTocsList() {
    	List<WebElement> nameTocs = driver.findElements(tocnames);
        List<String> names = new ArrayList<>();
        
        for (WebElement NameTocs : nameTocs) {
            names.add(NameTocs.getText());
        }

        return names;
    }
	
	public TocSelectionPage clicktoclist() {
		testutil.waitForElementToBeVisible(driver, click_TOC_List, 30);
		click_TOC_List.click();
		return new TocSelectionPage();
	}
	
	public TocSelectionPage clickgwr() {
		testutil.waitForElementToBeClickable(driver, clickGWR, 60);
		clickGWR.click();
		return new TocSelectionPage();
	}

}
