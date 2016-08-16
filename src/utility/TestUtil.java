package utility;

import datatable.XL_Reader;
import base.TestBase;

public class TestUtil extends TestBase{

	
	
	//Get the data from Excel
	
		public static Object[][] gettingData(String testSheetName){
			
			if(datatable == null){
			    datatable=new XL_Reader(System.getProperty("user.dir")+"\\src\\Config\\GmailData.xlsx");  
			}
			int rows=datatable.getRowCount(testSheetName)-1;
			if (rows<=0) {
				Object[][] testData=new Object[1][0];
				return testData;			
			}
			rows=datatable.getRowCount(testSheetName);
			int cols=datatable.getColCount(testSheetName);
			System.out.println("Test Sheet Name --"+testSheetName);
			System.out.println("Total Rows --"+rows);
			System.out.println("Total Cols --"+cols);
			Object data[][]=new Object[rows - 1][cols]; 
			
			for (int rowNum = 0; rowNum <=rows; rowNum++) {
				
				for (int colNum = 0; colNum <cols; colNum++) {
					data[rowNum][colNum]=datatable.gettingCellData(testSheetName, rowNum, colNum);
					System.out.println(data[rowNum][colNum]);
					
				}
				
			}
			return data;		
		}
		
		public static void settingCellValue(String testSheetName,String colName,int rowNum,String data){
			String path=System.getProperty("user.dir")+"\\src\\Config\\GmailData.xlsx";
			System.out.println("File Location is :::"+path); 
			
			if(datatable == null){
		          datatable=new XL_Reader(path);
			}
		
			datatable.settingCellData(testSheetName,colName,rowNum,data);				
			
		}
		
}
