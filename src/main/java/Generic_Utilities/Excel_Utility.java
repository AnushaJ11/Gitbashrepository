package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	public String getExcelData(String sheetname,int RowNum,int CellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src\\test\\resources\\Testcases.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(RowNum);
		Cell cell = row.getCell(CellNum);
		
		String Exceldata = cell.getStringCellValue();
		return Exceldata;
	}
	public String getDataFormatterdata(String sheetname,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src\\test\\resources\\Testcases.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String Exceldata = format.formatCellValue(cell);
	
		return Exceldata;
	}
}
