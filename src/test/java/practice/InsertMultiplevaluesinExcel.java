package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;



public class InsertMultiplevaluesinExcel {

	public static void main(String[] args) throws Throwable {
	
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		FileInputStream fes = new FileInputStream("C:\\Users\\anush\\OneDrive\\Desktop\\selenium\\MyExcelSheet.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Sheet1");
		driver.get("http://localhost:8888/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count = allLinks.size();
		System.out.println(count);;
		for(int i=0;i<count;i++){
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
			}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\anush\\OneDrive\\Desktop\\selenium\\MyExcelSheet.xlsx");
		book.write(fos);
		book.close();
		
	}

}
