package com.qa.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Silampur Girish 
 * Date 09-01-2010
 * class ExcellUtility
 */

public class ExcellUtility {

	/**
	 * @author Silampur Girish 
	 * Method to writeExcel 
	 * description it write the column wise data in the row 
	 * Date 09-01-2020
	 * para fileName;sheetName;Writedta
	 *  example [List<String> supplierNames = Arrays.asList("Girish","Shilpa","Cherry");]
	 */
	public void writeExcel(String fileName,String sheetName,List<String> Writedta) throws IOException{
		String filePath = (System.getProperty("user.dir")+".\\src\\main\\java\\com\\qa\\Resource\\AppdataExcell");
		File file =    new File(filePath+"\\"+fileName);		
		FileInputStream inputStream = new FileInputStream(file);
		Workbook TestdataWorkbook = null;		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));		
		if(fileExtensionName.equals(".xlsx")){

			TestdataWorkbook = new XSSFWorkbook(inputStream);
		}

		else if(fileExtensionName.equals(".xls")){

			TestdataWorkbook = new HSSFWorkbook(inputStream);
		}   	

		Sheet sheet = TestdataWorkbook.getSheet(sheetName);	

		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();		

		Row row = sheet.getRow(0);

		Row newRow = sheet.createRow(rowCount+1);


		for(int j = 0; j<row.getLastCellNum(); j++)
		{

			//Fills data in row by coul

			Cell cell = newRow.createCell(j);

			cell.setCellValue(Writedta.get(j));

		}
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		TestdataWorkbook.write(outputStream);		
		outputStream.close();

	}	
	
	/**
	 * @author Silampur Girish 
	 * Method to setExcelData 
	 * description it write data in row  wise 
	 * Date 09-01-2020
	 * para fileName;sheetName;rowNum;colNum;data	
	 */
	
	public void setExcelData(String fileName,String sheetName,int rowNum,int colNum,String data) throws InvalidFormatException, IOException{

		 FileInputStream inp = new FileInputStream(System.getProperty("user.dir")+".\\src\\main\\java\\com\\qa\\Resource\\AppdataExcell"+"\\"+fileName);
		 Workbook wb = WorkbookFactory.create(inp); 
		 Sheet sheet = wb.getSheet(sheetName); 
		//int lastRow = sheet.getLastRowNum();
		 Row row = sheet.createRow(rowNum);		 
		row.createCell(colNum).setCellValue(data);			 
		// Now this Write the output to a file 
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+".\\src\\main\\java\\com\\qa\\Resource\\AppdataExcell"+"\\"+fileName);
		wb.write(fos); 
		fos.close();  
	}
	
	
	/**
	 * @author Silampur Girish 
	 * Method to getExcelData 
	 * description it get data 
	 * Date 09-01-2020
	 * para fileName;sheetName;rowNum;colNum;data	 
	 */
	public String getExcelData(String fileName,String sheetName , int rowNum , int colNum) throws InvalidFormatException, IOException{
	      FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+".\\src\\main\\java\\com\\qa\\Resource\\AppdataExcell"+"\\"+fileName);
	      Workbook wb = WorkbookFactory.create(fis);
	      Sheet sh = wb.getSheet(sheetName);    
	      Row row = sh.getRow(rowNum);
	      String data = row.getCell(colNum).getStringCellValue();
	      return data;
	}
	
	/**
	 * @author Silampur Girish 
	 * Method to getRowCount 
	 * description gets RowCount
	 * Date 09-01-2020
	 * para fileName;sheetName	 
	 */

	public int getRowCount(String fileName,String sheetName) throws InvalidFormatException, IOException{    
	      FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+".\\src\\main\\java\\com\\qa\\Resource\\AppdataExcell"+"\\"+fileName);
	      Workbook wb = WorkbookFactory.create(fis);
	      Sheet sh = wb.getSheet(sheetName);
	      int rowCount = sh.getLastRowNum()+1;
	      return rowCount;
	}
	
	

	/**
	 * @author Silampur Girish 
	 * Method to getcellCount 
	 * description getcellCount
	 * Date 09-01-2020
	 * para fileName;sheetName;rowNum
	*/
	public int getcellCount(String fileName,String sheetName,int rowNum) throws InvalidFormatException, IOException{
	      FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+".\\src\\main\\java\\com\\qa\\Resource\\AppdataExcell"+"\\"+fileName);
	      Workbook wb = WorkbookFactory.create(fis);
	      Sheet sh = wb.getSheet(sheetName);    
	      Row row = sh.getRow(rowNum);
	     return row.getLastCellNum();     
	}

	
	

	
	
	
	



}
