package org.webpagehandle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.*;


public class ExcelCreation {
	public static void main(String[] args) throws Exception {
		FileInputStream file= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\OneName\\Data\\Arun.xlsx");
		XSSFWorkbook book = new  XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("Anto");
		//XSSFSheet sheetAt = book.getSheetAt(0);
		int row = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i <row ; i++) {
			XSSFRow row2 = sheet.getRow(i);
		for (int j = 0; j <lastCellNum ; j++) {
			String cell = row2.getCell(j).toString();
			System.out.println(cell);
		}
		System.out.println();
		}
		{
			
		}
}}
