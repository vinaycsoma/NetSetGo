package com.netset.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	public static void captureScreenShot(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String ScreenShotPath=System.getProperty("./ScreenShots/failed"+getCurrentDate()+".png");
		
		try {
			FileHandler.copy(src,new File("./ScreenShots/failed"+getCurrentDate()+".png"));
		} catch (Exception e) {
			System.out.println("Unable to capture screenshot.."+e.getMessage());
		}
		
	}
	public static String getCurrentDate() {
		DateFormat format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return format.format(currentDate);
	}

}
