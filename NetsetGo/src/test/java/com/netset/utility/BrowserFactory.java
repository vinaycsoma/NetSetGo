package com.netset.utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	@SuppressWarnings("deprecation")
	public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl) {
		if (browserName.equals("Chrome")) {
			
			  ChromeOptions opt = new ChromeOptions(); 
			  opt.setAcceptInsecureCerts(true);
			  WebDriverManager.chromedriver().setup(); 
			  driver = new ChromeDriver(opt);
			
		} else if (browserName.endsWith("FireFox")) {
			System.out.println("Browser not yet implimented");
		} else if(browserName.equals("Edge")) { 
			
			EdgeOptions opt=new EdgeOptions();
			opt.setAcceptInsecureCerts(true);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(opt);
		}
		
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

	public static void quitBrowser(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
