package com.netset.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {

	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "username")
	WebElement uname;
	@FindBy(id = "password")
	WebElement pasw;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;

	public void loginToNetset(String username, String password)

	{
		uname.sendKeys(username);
		pasw.sendKeys(password);
		login.click();
	}

}
