package com.netset.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.netset.utility.dDropDown;
import com.netset.utility.excelDataProvider;

public class childCardCreation {

	WebDriver driver;
	Actions act;
	excelDataProvider ex;
	
	  public childCardCreation(WebDriver d) {
	    	this.driver=d;
	    }
	
  
	public void addChildCard() throws InterruptedException {
		ex = new excelDataProvider();
		driver.findElement(By.xpath("//div[contains(text(),'planning')]")).click(); 
		act = new Actions(driver);
		driver.findElement(By.xpath("//p[normalize-space()='ChildCard']")).click();
		Thread.sleep(100);
		String cUrl = driver.getCurrentUrl();
		Assert.assertTrue(cUrl.contains("https://192.168.4.42/#/planning/list-items/ChildCard/58"));
		
		driver.findElement(By.xpath("//ng-select[@id='bind407']//input[@role='combobox']")).click();
		List<WebElement> dType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(dType, ex.getStringData("ccard", 1, 0)); //NE
		driver.findElement(By.xpath("//ng-select[@id='bind409']//input[@role='combobox']")).click();
		List<WebElement> ppName = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(ppName,ex.getStringData("ccard", 1, 1)); //Parent name
		driver.findElement(By.xpath("//ng-select[@id='bind406']//input[@role='combobox']")).click();
		List<WebElement> pType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(pType, ex.getStringData("ccard", 1, 2));//slot
		
		driver.findElement(By.xpath("//ng-select[@id='bind414']//input[@role='combobox']")).click();
		List<WebElement> cType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(cType, ex.getStringData("ccard", 1, 3));// card type

		driver.findElement(By.xpath("//ng-select[@id='bind408']//input[@role='combobox']")).click();
		List<WebElement> lType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(lType, ex.getStringData("ccard", 1, 4));// location
		
		driver.findElement(By.id("Description")).sendKeys(ex.getStringData("ccard", 1, 5));//Description
		driver.findElement(By.xpath("//ng-select[@id='bind412']//input[@role='combobox']")).click();
		List<WebElement> oType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(oType, ex.getStringData("port", 1, 6)); //order id

		WebElement status = driver.findElement(By.xpath("//select[@id='bind578']"));
		Select sts = new Select(status);
		sts.selectByValue("3"); // status

		driver.findElement(By.id("RollOutDate")).sendKeys("29-06-2023 15:55");
		Thread.sleep(100);
		act.sendKeys(Keys.ENTER).perform();

	 driver.findElement(By.cssSelector("button[type='submit']")).click();
	 String stat=driver.findElement(By.xpath("//p[@class='notifier__notification-message']")).getText();
	 System.out.print("stat");
	// Assert.assertTrue(stat.contains(""));
		Thread.sleep(1000);
	}
}


