package com.netset.utility;

import java.util.List;

import org.openqa.selenium.WebElement;

public class dDropDown {
	public static void dropdown(List<WebElement> val,String s) {
		for(WebElement v:val)
		 {
			 
			 if(v.getText().equals(s))
			 {
				v.click();
				break;
				 }
		
		 }
		
	}

}
