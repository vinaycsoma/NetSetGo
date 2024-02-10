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

public class portCreation {
	WebDriver driver;
	Actions act;
	excelDataProvider ex;

	public portCreation(WebDriver d) {
		this.driver = d;
	}

	public void addPort() throws InterruptedException {
		ex = new excelDataProvider();
		driver.findElement(By.xpath("//div[contains(text(),'planning')]")).click();
		act = new Actions(driver);
		driver.findElement(By.xpath("//p[normalize-space()='Port']")).click();
		Thread.sleep(100);
		String cUrl = driver.getCurrentUrl();
		Assert.assertTrue(cUrl.contains("https://192.168.4.42/#/planning/list-items/Port/3"));
		driver.findElement(By.xpath("//ng-select[@id='bind405']//input[@role='combobox']")).click();
		List<WebElement> dType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(dType, ex.getStringData("port", 1, 0)); //NE
		driver.findElement(By.xpath("//ng-select[@id='bind42']//input[@role='combobox']")).click();
		List<WebElement> ppName = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(ppName,ex.getStringData("port", 1, 1)); //PP name
		driver.findElement(By.xpath("//ng-select[@id='bind713']//input[@role='combobox']")).click();
		List<WebElement> pType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(pType, ex.getStringData("port", 1, 2));//port type
		driver.findElement(By.id("portName")).sendKeys(ex.getStringData("port", 1, 3));//portname
		driver.findElement(By.id("portNumber")).sendKeys(ex.getStringData("port", 1, 4));//port number
		driver.findElement(By.xpath("//ng-select[@id='bind396']//input[@role='combobox']")).click();
		List<WebElement> oType = driver
				.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div"));
		dDropDown.dropdown(oType, ex.getStringData("port", 1, 5)); //order id

		WebElement status = driver.findElement(By.xpath("//select[@id='bind578']"));
		Select sts = new Select(status);
		sts.selectByValue("5"); // status

		driver.findElement(By.id("RollOutDate")).sendKeys("29-06-2023 15:55");
		Thread.sleep(100);
		act.sendKeys(Keys.ENTER).perform();

	 driver.findElement(By.cssSelector("button[type='submit']")).click();
	 String stat=driver.findElement(By.xpath("//p[@class='notifier__notification-message']")).getText();
	 System.out.print("stat");
	 Assert.assertTrue(stat.contains("[200]: Successful: Port Inserted Sucessfully"));
		Thread.sleep(1000);

	}
}
