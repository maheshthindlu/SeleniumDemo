package com.qa.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteExcel {
	
	public boolean writeExcel1(String excelfilePath, String WfileName, String sheetName, String[] dataToWrite)
			throws IOException {

		boolean isWriteSucess;
		try {
			// Create an object of File class to open xlsx file

			File file = new File(excelfilePath + "\\" + WfileName);

			// Create an object of FileInputStream class to read excel file

			FileInputStream inputStream = new FileInputStream(file);

			Workbook WriteExcelWorkbook = null;

			// Find the file extension by splitting file name in substring and getting only
			// extension name

			String fileExtensionName = WfileName.substring(WfileName.indexOf("."));

			// Check condition if the file is xlsx file

			if (fileExtensionName.equals(".xlsx")) {

				// If it is xlsx file then create object of XSSFWorkbook class

				WriteExcelWorkbook = new XSSFWorkbook(inputStream);

			}

			// Check condition if the file is xls file

			else if (fileExtensionName.equals(".xls")) {

				// If it is xls file then create object of XSSFWorkbook class

				WriteExcelWorkbook = new HSSFWorkbook(inputStream);

			}

			// Read excel sheet by sheet name

			Sheet sheet = WriteExcelWorkbook.getSheet(sheetName);

			// Get the current count of rows in excel file

			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			// Get the first row from the sheet

			Row row = sheet.getRow(0);

			// Create a new row and append it at last of sheet

			Row newRow = sheet.createRow(rowCount + 1);

			// Create a loop over the cell of newly created Row

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Fill data in row

				Cell cell = newRow.createCell(j);

				cell.setCellValue(dataToWrite[j]);

			}

			// Close input stream

			inputStream.close();

			// Create an object of FileOutputStream class to create write data in excel file

			FileOutputStream outputStream = new FileOutputStream(file);

			// write data in the excel file

			WriteExcelWorkbook.write(outputStream);

			// close output stream

			outputStream.close();
			isWriteSucess = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			isWriteSucess = false;
		}

		return isWriteSucess;

	}

	// Call the data by passing sheetname,values and it return true if writting data
	// in to the excel is successfull and returns false if it is not succssfull

	public static boolean WriteData(String sheetName, String value1, String value2) throws IOException {

		// Create an array with the data in the same order in which you expect to be
		// filled in excel file

		String[] valueToWrite = { value1, value2 };

		// Create an object of current class

		WriteExcel objExcelFile = new WriteExcel();

		// Write the file using file name, sheet name and the data to be filled

		boolean iswriteSuccessfull = objExcelFile.writeExcel1(System.getProperty("user.dir") + "\\ExportExcel","WriteData.xlsx", sheetName, valueToWrite);

		return iswriteSuccessfull;

	}

	
	
	
	

}
