package com.netset.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.netset.pages.baseClass;
import com.netset.pages.cardCreation;
import com.netset.pages.deviceCreation;
import com.netset.pages.loginPage;
import com.netset.pages.portCreation;
import com.netset.pages.shelfCreation;

public class loginNetsetGo extends baseClass {

	@Test
	public void loginApp() throws InterruptedException {
        logger=report.createTest("Login to NetSetGo");
		loginPage login = PageFactory.initElements(driver, loginPage.class);
		logger.info("Lunching application");
		login.loginToNetset(ex.getStringData("login", 0, 0), ex.getStringData("login", 0, 1)); // login page
		logger.pass("Login success");
		
	}
	
	@Test(dependsOnMethods = "loginApp")
	public void deviceCreation() throws InterruptedException {
		 logger=report.createTest("Device creation");
		deviceCreation d = new deviceCreation(driver);
		 d.addDevice();
		 logger.pass("device created");
		
		}
	
	/*@Test(dependsOnMethods = "loginApp")
	public void deviceEdit() throws InterruptedException {
		
		 logger=report.createTest("edit device");
		deviceEdit ed = new deviceEdit(driver);
		ed.editDevice();
		 logger.pass("device edited successfully");
		
	}
	@Test(dependsOnMethods = "deviceCreation")
	public void createShelf() throws InterruptedException {
		
		 logger=report.createTest("create shelf");
		shelfCreation sh = new shelfCreation(driver);
		sh.addShelf();
		 logger.pass("shelf added successfully");
		
	}
	@Test(dependsOnMethods = "createShelf")
	public void createPort() throws InterruptedException {
		
		 logger=report.createTest("create port");
		portCreation port = new portCreation(driver);
		port.addPort();
		 logger.pass("port added successfully");
		
	}
	
	public void createCard() {
		 logger=report.createTest("create port");
			cardCreation card=new cardCreation(driver);
			card.addCard();
			logger.pass("card added successfully");
		
	}*/

}

