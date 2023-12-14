package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fetachthenumber_Usingfirstapproach {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		FileInputStream fes = new FileInputStream("C:\\Users\\anush\\OneDrive\\Desktop\\selenium\\Book1.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cell);
		System.out.println(data);
	}

}
