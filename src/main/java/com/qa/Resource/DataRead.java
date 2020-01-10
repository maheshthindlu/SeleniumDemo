package com.qa.Resource;

import org.testng.annotations.DataProvider;



public class DataRead {
	
	@DataProvider(name = "LoginDataXLS")
	public Object[][] ReadExcelXLS() throws Exception{
		
		String absolutepath=System.getProperty("user.dir");
		String fileName=absolutepath+"\\ExportExcel\\WriteData.xlsx";
		String sheetname="WriteExcelDemo";

	ReadExcel excel = new ReadExcel();
	Object[][] testObjArray = excel.getExcelData(fileName,sheetname);
	System.out.println(testObjArray);
	return testObjArray;

	}
	
	@DataProvider(name = "LoginDataXLSX")
    public Object[][] ReadExcelXLSX() throws Exception{
   	 
   	 String absolutepath=System.getProperty("user.dir");
   		String fileName=absolutepath+"\\ExportExcel\\WriteData.xlsx";
   		String sheetname="WriteExcelDemo";

   		ReadExcel excel = new ReadExcel();
	Object[][] testObjArray = excel.getExcelData(fileName,sheetname);
	System.out.println(testObjArray);
	return testObjArray;

	}	
	@DataProvider(name = "RowXLSX")
    public Object[][] ReadRow() throws Exception{
   	 
   	 String absolutepath=System.getProperty("user.dir");
   		String fileName=absolutepath+"\\ExportExcel\\WriteData.xlsx";
   		String sheetname="WriteExcelDemo";

   		ReadExcel excel = new ReadExcel();
	Object[][] testObjArray = excel.getExcelData(fileName,sheetname);
	System.out.println(testObjArray);
	return testObjArray;

	}	



}
