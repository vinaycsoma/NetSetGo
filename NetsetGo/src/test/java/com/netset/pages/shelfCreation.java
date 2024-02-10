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

public class shelfCreation {
	WebDriver driver;
	Actions act;
	excelDataProvider ex;
	public shelfCreation(WebDriver d) {
	this.driver=d;
	}

	public void addShelf() throws InterruptedException {
		ex=new excelDataProvider();
		//driver.findElement(By.xpath("//div[contains(text(),'planning')]")).click();
		act = new Actions(driver);
		driver.findElement(By.xpath("//img[@src='../../../assets/menu-icon-Shelf.png']")).click();
		Thread.sleep(1000);
		String cUrl = driver.getCurrentUrl();
		System.out.println(cUrl);
		Assert.assertTrue(cUrl.contains("https://192.168.4.42/#/planning/list-items/Shelf/2"));
		
		driver.findElement(By.xpath("//ng-select[@id='bind21']//input[@role='combobox']")).click();
		
		List<WebElement> dType=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(dType,ex.getStringData("shelf", 1, 0));
		
		 driver.findElement(By.xpath("//ng-select[@id='bind22']//input[@role='combobox']")).click();
		 List<WebElement> sType=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		 dDropDown.dropdown(sType,ex.getStringData("shelf", 1, 1));
		 
		 driver.findElement(By.id("shelfName")).sendKeys(ex.getStringData("shelf", 1, 2));
		 driver.findElement(By.id("shelfNumber")).sendKeys(ex.getStringData("shelf", 1, 3));
		 
		 driver.findElement(By.xpath("//ng-select[@id='bind25']//input[@role='combobox']")).click();
		 List<WebElement> lType=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		 dDropDown.dropdown(lType,ex.getStringData("shelf", 1, 4));
		 
		 driver.findElement(By.id("Description")).sendKeys(ex.getStringData("shelf", 1, 5));
		 driver.findElement(By.xpath("//ng-select[@id='bind395']//input[@role='combobox']")).click();
		 List<WebElement> oType=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		 dDropDown.dropdown(oType,ex.getStringData("shelf", 1, 6));
		
			WebElement status = driver.findElement(By.xpath("//select[@id='bind580']"));
			Select sts = new Select(status);
			sts.selectByValue("3");
		 
		driver.findElement(By.id("RollOutDate")).sendKeys("29-06-2023 15:55");
		Thread.sleep(100);
		act.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.cssSelector("button[type='submit']")).click();
		 String stat=driver.findElement(By.xpath("//p[@class='notifier__notification-message']")).getText();
		 System.out.print("stat");
		Assert.assertTrue(stat.contains("[200]: Successful: Shelf Creation Sucessfully"));
			Thread.sleep(1000);
			
		 
		
		
	}
}
