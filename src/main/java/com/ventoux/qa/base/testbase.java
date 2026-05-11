package com.ventoux.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ventoux.qa.util.testutil;

public class testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public testbase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\selenium_workSpace\\DevVentoux\\src\\main\\java\\com\\ventoux\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(testutil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(testutil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
	}

}
