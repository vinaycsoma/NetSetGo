package com.netset.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataProvider {
	
	XSSFWorkbook wb;
	public excelDataProvider() {
		File src=new File("./TestData/data.xlsx");
		
		try {
			FileInputStream fs=new FileInputStream(src);
			wb=new XSSFWorkbook(fs);
		} catch (Exception e) {
			System.out.println("File not found."+e.getMessage());
		} 
	}
	public String getStringData(String sheetName,int row,int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	public double getNumericData(String sheetName,int row,int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}

}
