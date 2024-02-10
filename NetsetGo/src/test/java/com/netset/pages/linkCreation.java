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

public class linkCreation {

	WebDriver driver;
	Actions act;
	excelDataProvider ex;

	public linkCreation(WebDriver d) {
		this.driver = d;
	}

	public void addPort() throws InterruptedException {
		ex = new excelDataProvider();
		driver.findElement(By.xpath("//div[contains(text(),'planning')]")).click();
		act = new Actions(driver);
		driver.findElement(By.xpath("//p[normalize-space()='Link']")).click();
		Thread.sleep(100);
		String cUrl = driver.getCurrentUrl();
		Assert.assertTrue(cUrl.contains("https://192.168.4.42/#/planning/list-items/Link/5"));
		driver.findElement(By.id("LinkName")).sendKeys(ex.getStringData("link", 1, 0));	//Link Name
		driver.findElement(By.xpath("//ng-select[@id='bind359']//input[@role='combobox']")).click();
		List<WebElement> dType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(dType, ex.getStringData("link", 1, 1)); //Link Type

		driver.findElement(By.xpath("//ng-select[@id='bind360']//input[@role='combobox']")).click();
		List<WebElement> ppName = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(ppName,ex.getStringData("link", 1, 2)); //BW
		
		driver.findElement(By.id("Description")).sendKeys(ex.getStringData("link", 1, 3));//Description
		
		
		driver.findElement(By.xpath("//ng-select[@id='bind401']//input[@role='combobox']")).click();
		List<WebElement> sLoc = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(sLoc, ex.getStringData("link", 1, 4));//Link Start Location
		
		driver.findElement(By.xpath("//ng-select[@id='bind402']//input[@role='combobox']")).click();
		List<WebElement> eLoc = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(eLoc, ex.getStringData("link", 1, 5));//Link end Location
		
		driver.findElement(By.xpath("//ng-select[@id='bind399']//input[@role='combobox']")).click();
		List<WebElement> sNe = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(sNe, ex.getStringData("link", 1, 6));//Link Start NE
		
		driver.findElement(By.xpath("//ng-select[@id='bind400']//input[@role='combobox']")).click();
		List<WebElement> eNe = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(eNe, ex.getStringData("link", 1, 7));//Link end NE
		
		driver.findElement(By.xpath("//ng-select[@id='bind361']//input[@role='combobox']")).click();
		List<WebElement> sPort = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(sPort, ex.getStringData("link", 1, 8));//Link Start Port
		
		driver.findElement(By.xpath("//ng-select[@id='bind362']//input[@role='combobox']")).click();
		List<WebElement> ePort = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(ePort, ex.getStringData("link", 1, 9));//Link end Port
		
	
		driver.findElement(By.xpath("//ng-select[@id='bind398']//input[@role='combobox']")).click();
		List<WebElement> oType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(oType, ex.getStringData("link", 1, 10)); //order id

		WebElement status = driver.findElement(By.xpath("//select[@id='bind403']"));
		Select sts = new Select(status);
		sts.selectByValue("5"); // status

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
