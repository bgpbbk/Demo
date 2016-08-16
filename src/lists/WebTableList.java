package lists;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class WebTableList {
	
	WebDriver driver;
	
	@Test
	public void loopWebTable(){
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//Config//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3.org/community/webed/wiki/HTML_tables"); 
		List<Row> rowsData = getTableData();
		
		}

	public List<Row> getTableData(){
		
		//Finding HTML Table
		
		List<WebElement> rows=new ArrayList<WebElement>();
		List<WebElement> columns=new ArrayList<WebElement>();
		
		List<Row> listrows=new ArrayList<Row>();
		
		rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/table[1]/tbody/tr"));
		System.out.println("Rows count \t" + rows.size());

		int rowNum = 0;
		
		for(WebElement row : rows){
			
			Row rowdata=new Row();
			
			columns=row.findElements(By.xpath("td")); 
			System.out.println("Column size \t" + columns.size());
			
			List<Column> listcloumns=new ArrayList<Column>();
			
			int colNumber=0;
			
			for(WebElement col : columns){
				
				System.out.println("Table cell value is +\t" + col.getText());
				Column coldata=new Column();
				
				coldata.ColumnName="Column" + colNumber;
				coldata.ColumnValue=col.getText();
				listcloumns.add(colNumber, coldata); 
				colNumber++;
			}
			
			rowdata.RowName="RowHeader"+rowNum;
			rowdata.Columns=listcloumns;
			listrows.add(rowNum, rowdata); 
			rowNum++;
		}		
		return listrows;		
	 }
	
	public class Row{
		
		public String RowName;
		public List<Column> Columns;
	}
	
	public class Column{
		
		public String ColumnName;
		public String ColumnValue;
	}
}
