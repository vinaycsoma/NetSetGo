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

public class cardCreation {

	WebDriver driver;
	Actions act;
	excelDataProvider ex;

	public cardCreation(WebDriver d) {
		this.driver = d;
	}

	public void addPort() throws InterruptedException {
		ex = new excelDataProvider();
		act = new Actions(driver);
		driver.findElement(By.xpath("//p[normalize-space()='Card']")).click();
		Thread.sleep(100);
		String cUrl = driver.getCurrentUrl();
		Assert.assertTrue(cUrl.contains("https://192.168.4.42/#/planning/list-items/Card/4"));

		driver.findElement(By.xpath("//ng-select[@id='bind92']//input[@role='combobox']")).click();
		List<WebElement> dType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));

		dDropDown.dropdown(dType, ex.getStringData("card", 1, 0)); // NE
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ng-select[@id='bind93']//input[@role='combobox']")).click();
		List<WebElement> ppName = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(ppName, ex.getStringData("card", 1, 1)); // Slot

		driver.findElement(By.xpath("//ng-select[@id='bind91']//input[@role='combobox']")).click();
		List<WebElement> pType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(pType, ex.getStringData("card", 1, 2));// card type

		driver.findElement(By.xpath("//ng-select[@id='bind94']//input[@role='combobox']")).click();
		List<WebElement> lType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(lType, ex.getStringData("card", 1, 3));// location

		driver.findElement(By.id("Description")).sendKeys(ex.getStringData("card", 1, 4));// Description

		driver.findElement(By.xpath("//ng-select[@id='bind397']//input[@role='combobox']")).click();
		List<WebElement> oType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(oType, ex.getStringData("card", 1, 5)); // order id

		WebElement status = driver.findElement(By.xpath("//select[@id='bind582']"));
		Select sts = new Select(status);
		sts.selectByValue("2"); // status

		driver.findElement(By.id("RollOutDate")).sendKeys("29-06-2023 15:55");
		Thread.sleep(100);
		act.sendKeys(Keys.ENTER).perform();

		// driver.findElement(By.cssSelector("button[type='submit']")).click();
		String stat = driver.findElement(By.xpath("//p[@class='notifier__notification-message']")).getText();
		System.out.print("stat");
		Assert.assertTrue(stat.contains("[200]: Successful: Card Inserted Sucessfully"));
		Thread.sleep(1000);

	}
}
