package com.ventoux.qa.pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ventoux.qa.base.testbase;
import com.ventoux.qa.util.testutil;


public class HomePageChartsTitle_InfoIconText extends testbase{
		
	By Charts_Cards = By.xpath("(//div[@class='landingPage-dynamic-charts'])");
	
	By Icon_HoverOver = By.xpath("//div[@role='tooltip']//div[@class='tooltip-inner']");
	
	By ZoomInOut = By.xpath("//*[name()='g'][@class='recharts-layer recharts-bar-rectangle'][46]//*[name()='path'][@name='Services with PA']");
	
	@FindBy(xpath = "//h5[normalize-space()='Service Count']/ancestor::div[@class=\"landingPage-dynamic-charts\"]//*[name()='svg'][@class=\"zoom-icon icon-color\"]")
	WebElement ResetZoom;
	
	public HomePageChartsTitle_InfoIconText() {
		PageFactory.initElements(driver, this);
		
	}
	
	Actions actions = new Actions(driver);
	public void getChartDetails() {

	    List<WebElement> charts = driver.findElements(Charts_Cards);
	    
	    System.out.println("Total charts: " + charts.size());

	    for (int i = 1; i <= charts.size(); i++) {

	        WebElement chart = driver.findElement(By.xpath(
	                "(//div[@class='landingPage-dynamic-charts'])[" + i + "]"
	        	    ));

	        // Get title
	        String title = chart.findElement(By.xpath(
	                "(//div[@class='landingPage-dynamic-charts'])[" + i + "]//h5[contains(text(),'')]")).getText();

	        WebElement icon = chart.findElement(By.xpath(
	                "(//div[@class='landingPage-dynamic-charts'])["+ i +"]//*[name()='svg'][@class='info-button-icon icon-color']"));

	        // Move mouse away first (important)
	        actions.moveByOffset(0, 0).perform();

	        // Hover on info icon
	        actions.moveToElement(icon).pause(Duration.ofMillis(500)).perform();

	        // Wait for tooltip and ensure it's updated
	        WebElement tip = driver.findElement(Icon_HoverOver);

	        String tooltipText = tip.getText();

	     // Print Output
            System.out.println("----------------------------------");
            System.out.println("Chart Title   : " + title);
            System.out.println("Tooltip Text  : " + tooltipText);

	        // Move mouse away to reset tooltip
	        actions.moveByOffset(-100, -100).perform();
	        
	        
	        //WebElement draggableBar = testutil.waitForElementToBeVisible(driver, ZoomInOut, 30);
	        
	        WebElement draggableBar = chart.findElement(By.xpath(
	                "(//div[@class=\"landingPage-dynamic-charts\"])['+ i +']//*[name()='g'][@class='recharts-cartesian-grid']"));
	        testutil.waitForElementToBeVisible(driver, draggableBar, 30);

	    	
	        // Create Actions object for simulating mouse actions
	        Actions actions = new Actions(driver);
	        // Move the mouse to the starting point of the draggable element (the bar in the graph)
	        actions.moveToElement(draggableBar).clickAndHold();  // Click and hold at the starting point
	        actions.moveByOffset(100, 0);  // Move the mouse by 100 pixels to the right (adjust for your use case)
	        actions.release();  // Release the mouse button after dragging
	        // Perform the action
	        actions.build().perform();
	        
	        WebElement ResetZoom = chart.findElement(By.xpath(
	                "(//div[@class='landingPage-dynamic-charts'])["+ i +"]//*[name()='svg'][@class='zoom-icon icon-color']"));
	        testutil.waitForElementToBeVisible(driver, ResetZoom, 30);
	        ResetZoom.click();
	        
	        
	        

	        // Small wait to avoid same tooltip reuse
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	        }
	    }

		}
	//Drag the Mouse to the Bars and Check the Zoom In functionality
    public void VerifyZoomIn() {
    	WebElement draggableBar = testutil.waitForElementToBeVisible(driver, ZoomInOut, 30);
    	
        // Create Actions object for simulating mouse actions
        Actions actions = new Actions(driver);
        // Move the mouse to the starting point of the draggable element (the bar in the graph)
        actions.moveToElement(draggableBar).clickAndHold();  // Click and hold at the starting point
        actions.moveByOffset(100, 0);  // Move the mouse by 100 pixels to the right (adjust for your use case)
        actions.release();  // Release the mouse button after dragging
        // Perform the action
        actions.build().perform();
        }
    
    //Click Reset Button
    public void ClickResetButton() { 	
    	testutil.waitForElementToBeVisible(driver, ResetZoom, 30);    	
    	ResetZoom.click();
    }
}
