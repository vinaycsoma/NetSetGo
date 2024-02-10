package com.netset.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {
	Properties pro;
	public configDataProvider() {
		
		File src=new File("./config/config.properties");
		try {
			FileInputStream fs=new FileInputStream(src);
			pro.load(fs);
		} catch (Exception e) {
			System.out.println("File not found..."+e.getMessage());
			
		} 
				
	}
	public String getDataFromConfig(String Key)
	{
	 return pro.getProperty(Key);	
	}
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	public String getUrl()
	{
		return pro.getProperty("uatUrl");
	}

}
