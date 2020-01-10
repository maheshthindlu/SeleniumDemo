package com.qa.Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {

	public String[][] getExcelData(String fileName, String sheetName) throws EncryptedDocumentException, IOException {
		XSSFSheet ExcelWSheet;
		XSSFWorkbook ExcelWBook;
		String[][] arrayExcelData = null;
		// Reading Excel File
		FileInputStream ExcelFile = new FileInputStream(fileName);

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			int totalNoOfRows = ExcelWSheet.getLastRowNum();
			int totalNoOfCols_0 = ExcelWSheet.getRow(0).getLastCellNum();
			arrayExcelData = new String[totalNoOfRows][totalNoOfCols_0];
			for (int i = 0; i < totalNoOfRows; i++) {
				int totalNoOfCols = ExcelWSheet.getRow(i).getLastCellNum();
				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i][j] = ExcelWSheet.getRow(i + 1).getCell(j).getStringCellValue();
				}
			}
			System.out.println(arrayExcelData);
		}

		else if (fileExtensionName.equals(".xls")) {
			Workbook ExcelWBook1;
			Sheet ExcelWSheet1;
			ExcelWBook1 = WorkbookFactory.create(ExcelFile);
			ExcelWSheet1 = ExcelWBook1.getSheet(sheetName);
			int totalNoOfRows = ExcelWSheet1.getLastRowNum();
			int totalNoOfCols_0 = ExcelWSheet1.getRow(0).getLastCellNum();
			arrayExcelData = new String[totalNoOfRows][totalNoOfCols_0];
			for (int i = 0; i < totalNoOfRows; i++) {
				int totalNoOfCols = ExcelWSheet1.getRow(i).getLastCellNum();
				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i][j] = ExcelWSheet1.getRow(i + 1).getCell(j).getStringCellValue();
				}
			}
			System.out.println(arrayExcelData);
		}

		return arrayExcelData;
	}

	public ArrayList<String> getData(String testcaseName, String fileName) throws IOException {
		// fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("WriteExcelDemo")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify Testcases coloum by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase("Testcase")) {
						coloumn = k;

					}

					k++;
				}
				System.out.println(coloumn);

				//// once coloumn is identified then scan entire testcase coloum to identify
				//// purcjhase testcase row
				while (rows.hasNext()) {

					Row r = rows.next();

					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {

						//// after you grab purchase testcase row = pull all the data of that row and
						//// feed into test

						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellType() == CellType.STRING) {

								a.add(c.getStringCellValue());
							} else {

								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}
						}
					}

				}
			}

		}
		return a;
	}
	
	@Test
	public  void Single() throws IOException
	{
		ReadExcel read=new ReadExcel();
		ArrayList<String> arr=read.getData("TC_003",System.getProperty("user.dir")+"\\ExportExcel\\WriteData.xlsx");
		System.out.println(arr);
	}
}
