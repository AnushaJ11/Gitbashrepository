package product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomrepository.CreateProductPage;
import pomrepository.HomePage;
import pomrepository.LoginPage;
import pomrepository.ProductPlusSign;

public class ProductLink {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//WebDriver driver = new ChromeDriver();
		
		File_Utility flib = new File_Utility();
		WebDriver driver;
		String BROWSER = flib.getkeyandValueData("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		String URL = flib.getkeyandValueData("url");
		String USERNAME = flib.getkeyandValueData("username");
		String PASSWORD = flib.getkeyandValueData("password");
		/*FileInputStream fis = new FileInputStream("C:\\Users\\anush\\OneDrive\\Desktop\\selenium\\advsele.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		driver.get(URL);
		//hardcoding
		/*
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		*/
		//BusinessLogic
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		HomePage home = new HomePage(driver);
		home.clickonProduct();
		
		ProductPlusSign plus = new ProductPlusSign(driver);
		plus.clickProductPlus();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//Random ran = new Random();
		//int ranNum = ran.nextInt(1000);
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		/*FileInputStream fes = new FileInputStream("./src\\test\\resources\\Testcases.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String prdName = cell.getStringCellValue()+ranNum;*/
		Excel_Utility elib = new Excel_Utility();
		//String prdName = elib.getExcelData("Product",0,0)+ranNum;
		String prdName = elib.getDataFormatterdata("Product",0,0)+ranNum;
		CreateProductPage product = new CreateProductPage(driver);
		product.productName(prdName);
		product.clickOnSaveButton();
		//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prdName);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		String productdetails = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(productdetails.contains(prdName)) {
			System.out.println("productname is assigned");
		}
		else
		{
		
			System.out.println("Product name is not assigned");
		}
		System.out.println(prdName);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		home.Logout(driver);
	}

}
