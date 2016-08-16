package datatable;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL_Reader {

	public String path;
	public FileInputStream fis=null;
    public FileOutputStream fos=null;
    public XSSFWorkbook wb=null;
    public XSSFSheet ws=null;
    public XSSFRow row=null;
    public XSSFCell cell=null;
    
public XL_Reader(String path){
	
	this.path=path;
	try {
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}    

public int getRowCount(String sheetName){
	ws=wb.getSheet(sheetName);
	int number=ws.getLastRowNum() +1;
	return number;
}	

public int getColCount(String sheetName){
	ws=wb.getSheet(sheetName);
	row=ws.getRow(0);
	return row.getLastCellNum();  
}	

public String gettingCellData(String sheetName,int rowNum,int colNum){
	try {
		
		ws=wb.getSheet(sheetName);
		row=ws.getRow(rowNum + 1);
		cell=row.getCell(colNum);
		if(cell == null)
			return " ";
		cell.setCellType(Cell.CELL_TYPE_STRING);
		return cell.getStringCellValue();
		
	} catch (Exception e) {
		e.printStackTrace();
		return "row "+rowNum+" or column "+colNum+" does not exist in xl";
	}
	
	
}
	
public boolean settingCellData(String sheetName,String colName,int rowNum,String data){
	
	try {
		
		fis=new FileInputStream(path);
		System.out.println(fis); 
		wb=new XSSFWorkbook(fis);
		
		if (rowNum <= 0)
			return false;
		
		ws=wb.getSheet(sheetName);
		int colNum=-1;
		row=ws.getRow(0);
		
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName)) 
			 colNum=i;			
		}
		
		ws.autoSizeColumn(colNum); 
		row=ws.getRow(rowNum-1);
		if(row == null)
			row=ws.createRow(rowNum - 1);
		
		cell=row.getCell(colNum);
		if(cell == null)
			cell=row.createCell(colNum);
		
		cell.setCellValue(data);
		
		
		fos=new FileOutputStream(path);
		
		wb.write(fos);
		
		fos.close();
		
	} catch (Exception e) {
		
		e.printStackTrace();
		return false;
	}
	
	return true;
}

}
