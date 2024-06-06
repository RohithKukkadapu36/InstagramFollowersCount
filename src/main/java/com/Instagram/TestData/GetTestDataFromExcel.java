package com.Instagram.TestData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetTestDataFromExcel {

	public static String getData(String keyName) throws Exception {
		
		String value = null;
		String fileLocation = System.getProperty("user.dir")+"\\src\\Resources\\TestData.xlsx";
		File filePath = new File(fileLocation);
		FileInputStream fis = new FileInputStream(filePath);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		
		int rowCount = sh.getPhysicalNumberOfRows();
		for(int i=0;i<rowCount;i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			if(key.equalsIgnoreCase(keyName)) {
				value = sh.getRow(i).getCell(i).getStringCellValue();
			}
		}
		
		wb.close();
		fis.close();
		return value;
	}
	
}
