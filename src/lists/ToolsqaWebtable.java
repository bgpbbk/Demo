package lists;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToolsqaWebtable {

	WebDriver driver;

	@Test
	public void Webtable1() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ "//src//Config//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-table/#");

		@SuppressWarnings("unused")
		List<HeaderRow> Tabledata = getTabledata();
	}

	public List<HeaderRow> getTabledata() {

		List<WebElement> headerRow = new ArrayList<WebElement>();
		List<WebElement> headerColumn = new ArrayList<WebElement>();
		List<WebElement> tbodyRows = new ArrayList<WebElement>();
		List<WebElement> tbodyColumns = new ArrayList<WebElement>();
		List<WebElement> tbodyHead = new ArrayList<WebElement>();

		List<HeaderRow> headerlist = new ArrayList<ToolsqaWebtable.HeaderRow>();

		headerRow = driver.findElements(By
				.xpath(".//*[@id='content']/table/thead/tr"));
		System.out.println("HeaderRow \t" + headerRow.size());

		int rowNum = 0;

		for (WebElement hr : headerRow) {

			HeaderRow headerdata = new HeaderRow();

			headerColumn = hr.findElements(By.xpath("th"));
			System.out.println("HeaderColumn \t" + headerColumn.size());

			List<HeaderColumn> headercolumnlist = new ArrayList<ToolsqaWebtable.HeaderColumn>();

			int colNum = 0;

			for (WebElement hcolumndata : headerColumn) {

				System.out.println("HeaderColumn value is \t"
						+ hcolumndata.getText());
				HeaderColumn headercolumndata = new HeaderColumn();

				headercolumndata.ColumnName = "Column " + colNum;
				headercolumndata.ColumnValue = hcolumndata.getText();
				headercolumnlist.add(colNum, headercolumndata);
				colNum++;
			}

			List<TBodyRows> tbodylist = new ArrayList<ToolsqaWebtable.TBodyRows>();

			tbodyRows = driver.findElements(By
					.xpath(".//*[@id='content']/table/tbody/tr"));
			System.out.println("TBodyRows" + tbodyRows.size());

			int rowNum1 = 0;

			for (WebElement bodyRow : tbodyRows) {

				TBodyRows bodyRows = new TBodyRows();

				tbodyHead = bodyRow.findElements(By.xpath("th"));
				System.out.println("TBodyHead" + tbodyHead.size());

				List<TBodyHead> tbhlist = new ArrayList<ToolsqaWebtable.TBodyHead>();

				int colNum1 = 0;

				for (WebElement tbhdata : tbodyHead) {

					TBodyHead tbh1 = new TBodyHead();

					tbodyColumns = bodyRow.findElements(By.xpath("td"));
					System.out.println("TBodyColumns" + tbodyColumns.size());

					List<TBodyColumns> tbclist = new ArrayList<ToolsqaWebtable.TBodyColumns>();

					int colNum2 = 0;

					for (WebElement tbcdata : tbodyColumns) {

						TBodyColumns tbc1 = new TBodyColumns();
						System.out.println("Table Body Column Data is "
								+ tbcdata.getText());

						tbc1.TBodyColumnName = "TBodyColumnName is " + colNum2;
						tbc1.TBodyColumnValue = "TBodyColumnValue is "
								+ tbcdata.getText();
						tbclist.add(colNum2, tbc1);
						colNum2++;

					}

					tbh1.TBodyHeadName = "TBodyHeadName is " + colNum1;
					tbh1.TBodyHeadValue = "TBodyHeadValue is "
							+ tbhdata.getText();
					tbh1.TBodyColumnsData = tbclist;
					tbhlist.add(colNum1, tbh1);
					colNum1++;

				}

				bodyRows.TBodyname = "TBodyRow is " + rowNum1;
				bodyRows.TBodyHeadData = tbhlist;
				tbodylist.add(rowNum1, bodyRows);
				rowNum1++;

			}

			headerdata.HeaderName = "Header" + rowNum;
			headerdata.HeaderColumnsData = headercolumnlist;
			headerdata.TBodyRowsData = tbodylist;
			headerlist.add(rowNum, headerdata);
			rowNum++;
		}
		return headerlist;
	}

	public class HeaderRow {

		public String HeaderName;
		public List<HeaderColumn> HeaderColumnsData;
		public List<TBodyRows> TBodyRowsData;
	}

	public class HeaderColumn {

		public String ColumnName;
		public String ColumnValue;
	}

	public class TBodyRows {

		public String TBodyname;
		public List<TBodyHead> TBodyHeadData;
		// public List<TBodyColumns> TBodyColumnsData;
	}

	public class TBodyHead {

		public String TBodyHeadName;
		public String TBodyHeadValue;
		public List<TBodyColumns> TBodyColumnsData;
	}

	public class TBodyColumns {

		public String TBodyColumnName;
		public String TBodyColumnValue;
	}
}
