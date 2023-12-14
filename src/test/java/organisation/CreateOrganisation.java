package organisation;

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
import Generic_Utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomrepository.HomePage;
import pomrepository.LoginPage;
import pomrepository.OrganizationPlusSign;

public class CreateOrganisation {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		File_Utility flib = new File_Utility();
		WebDriver driver;
		String BROWSER = flib.getkeyandValueData("browser");
	   if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
	else if(BROWSER.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		//WebDriver driver = new ChromeDriver();
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.maximizingWindow(driver);
		wlib.implicity_wait(driver);
		//File_Utility flib = new File_Utility();
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
		//Hardcoding
	/*
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		*/
		
		//Business logic
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		
		//driver.findElement(By.linkText("Organizations")).click();
		HomePage home = new HomePage(driver);
		home.clickonOrganizations();
		home.CreateOrganization();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		//Random ran = new Random();
		//int ranNum = ran.nextInt(1000);
		//FileInputStream fes = new FileInputStream("./src\\test\\resources\\Testcases.xlsx");
		//Workbook book = WorkbookFactory.create(fes);
		//Sheet sheet = book.getSheet("Organization");
		//Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		
		//String OrgName = cell.getStringCellValue()+ranNum;
		Excel_Utility elib = new Excel_Utility();
		//String OrgName = elib.getExcelData("Organization",0,0)+ranNum;
		String OrgName = elib.getDataFormatterdata("Organization",0,0)+ranNum;
		OrganizationPlusSign org = new OrganizationPlusSign(driver);
		org.accountname(OrgName);
		org.Clicksavebutton();
		//driver.findElement(By.name("accountname")).sendKeys(OrgName);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		String prdName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(prdName.contains(OrgName))
		{
			System.out.println("Organization Created");
		}
		else
		{
			System.out.println("Organization not Created");
		}
		System.out.println(OrgName);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		home.Logout(driver);
	}

}
