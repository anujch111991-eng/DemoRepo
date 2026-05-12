/*
 *  Anuj GIT Repo
 * */
 

package com.ventoux.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ventoux.qa.base.testbase;
import com.ventoux.qa.util.testutil;


public class HomePageChartsTitle_InfoIconText extends testbase{
	
	@FindBy(xpath = "//h5[normalize-space()='Service Count']/ancestor::div[@class=\"landingPage-dynamic-charts\"]//*[name()='svg'][@class=\"zoom-icon icon-color\"]")
	WebElement ResetZoom;
	
	By ChartLegends = By.xpath("//h5[normalize-space()='Service Count']/ancestor::div[@class='landingPage-dynamic-charts']"
			+ "//li//span[@class='recharts-legend-item-text']");
	
	By ServiceCount_title = By.xpath("//h5[text()='Service Count']");
	
	By infoIcon = By.xpath("//h5[text()='Service Count']/ancestor::div[@class='landingPage-dynamic-charts']//*[name()='svg'][@class='info-button-icon icon-color']");
		
	By Charts_Cards = By.xpath("(//div[@class='landingPage-dynamic-charts'])");
	
	By Icon_HoverOver = By.xpath("//div[@role='tooltip']//div[@class='tooltip-inner']");
	
	By ZoomInOut = By.xpath("//*[name()='g'][@class='recharts-layer recharts-bar-rectangle'][46]//*[name()='path'][@name='Services with PA']");

	By opt_serviceInfoIcon = By.xpath("//h5[text()='Optimised Services - Batch']/ancestor::div[@class='landingPage-dynamic-charts']//*[name()='svg'][@class='info-button-icon icon-color']");
	
	public HomePageChartsTitle_InfoIconText() {
		PageFactory.initElements(driver, this);
		
	}
	
	Actions actions = new Actions(driver);
	
	//*********************Verify Service Count Chart************************	
	public void InfoIconDetails() {		
		List<WebElement> infoicon = testutil.waitForElementsToBeVisible(driver, infoIcon, 30);
    	// Use WaitUtil to wait for the element to be visible
		for(WebElement e: infoicon)
		{
			actions.moveToElement(e).perform();
			List<WebElement> text1List = testutil.waitForElementsToBeVisible(driver, Icon_HoverOver, 30);
		    if (!text1List.isEmpty()) {
		        String text1 = text1List.get(0).getText();  // Get text from the first matching element
		        System.out.println(text1);
		    } else {
		        System.out.println("No text found for TextXpath1.");
		    } 		    
		 // Move mouse away from the info icon to make the tooltip disappear
	        WebElement bodyElement = driver.findElement(ServiceCount_title); // You can use a different element if needed
	        actions.moveToElement(bodyElement).perform();		    
		}		
    }
	
	//The code for the title of the chart
	public String GetChartTitle() {
		WebElement titleElement = testutil.waitForElementToBeVisible(driver, ServiceCount_title, 30);
        return titleElement.getText();		
	}
	
    // Get legend items
    public void printLegends() {
        List<WebElement> legends = driver.findElements(ChartLegends);
        System.out.println("Legends:");
        for (WebElement legend : legends) {
            System.out.println(legend.getText());
        }
    }
    
  //Drag the Mouse to the Bars and Check the Zoom In functionality
    public void VerifyZoomIn() {
    	WebElement draggableBar = testutil.waitForElementToBeVisible(driver, ZoomInOut, 30);    	
        // Create Actions object for simulating mouse actions
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

	//*********************Verify Optimised Services - Batch************************	
	public void InfoIconDetails_Opt_Services() {		
		List<WebElement> infoicon = testutil.waitForElementsToBeVisible(driver, opt_serviceInfoIcon, 30);
    	// Use WaitUtil to wait for the element to be visible
		for(WebElement e: infoicon)
		{
			actions.moveToElement(e).perform();
			List<WebElement> text1List = testutil.waitForElementsToBeVisible(driver, Icon_HoverOver, 30);
		    if (!text1List.isEmpty()) {
		        String text1 = text1List.get(0).getText();  // Get text from the first matching element
		        System.out.println(text1);
		    } else {
		        System.out.println("No text found for TextXpath1.");
		    } 		    
		 // Move mouse away from the info icon to make the tooltip disappear
	        WebElement bodyElement = driver.findElement(ServiceCount_title); // You can use a different element if needed
	        actions.moveToElement(bodyElement).perform();		    
		}		
    }
		/*
	    List<WebElement> charts = driver.findElements(Charts_Cards);  
	    //System.out.println("Total charts: " + charts.size());

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
    */
	} 

