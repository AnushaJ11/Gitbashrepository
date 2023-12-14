package campaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import pomrepository.CampaignPlusSignPage;
import pomrepository.CreateCampaignPage;
import pomrepository.CreateProductPage;
import pomrepository.HomePage;
import pomrepository.LoginPage;
import pomrepository.ProductPlusSign;
import pomrepository.SearchText;

public class CreateCampaignWithProduct {

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
		
		//Hardcoding
		/*
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		*/
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		
		
		HomePage home = new HomePage(driver);
		home.clickonProduct();
		ProductPlusSign plus = new ProductPlusSign(driver);
		plus.clickProductPlus();
		
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
		//Random Approach To avoid Duplicates
	//Random ran = new Random();
	//int ranNum = ran.nextInt(1000);
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
	/*FileInputStream fes = new FileInputStream("./src\\test\\resources\\Testcases.xlsx");	
	Workbook book = WorkbookFactory.create(fes);
	Sheet sheet = book.getSheet("Campaign");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String prdName = cell.getStringCellValue()+ranNum;*/
		Excel_Utility elib = new Excel_Utility();
		//String prdName = elib.getExcelData("Product",0,0)+ranNum;
		String prdName = elib.getDataFormatterdata("Product",0,0)+ranNum;
		
		CreateProductPage product = new CreateProductPage(driver);
		product.productName(prdName);
		product.clickOnSaveButton();
	//driver.findElement(By.name("productname")).sendKeys(prdName);
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	String prddetails = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	
	if(prddetails.contains(prdName))
	{
	System.out.println("Product Created");
	}
	else
	{
	System.out.println("Product not created");
	}
	System.out.println(prdName);
/*driver.findElement(By.linkText("More")).click();
driver.findElement(By.linkText("Campaigns")).click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();*/
	
	 HomePage home1 = new HomePage(driver);	
	 home1.clickonMorelink();
	 home1.clickonCampaigns();
	 CampaignPlusSignPage plus1 = new CampaignPlusSignPage(driver);
		plus1.clickCampaignPlus();
		home1.Select();
//driver.findElement(By.xpath("//img[@alt='Select']")).click();
Webdriver_Utility wlib = new Webdriver_Utility();
wlib.windowSwitching(driver,"Products&action");
//Set<String> allWin = driver.getWindowHandles();
//Iterator<String> win = allWin.iterator();
//
//while(win.hasNext())
//{
//	String winText = win.next();
//driver.switchTo().window(winText);
//String title = driver.getTitle();
//
//if(title.contains("Products&action"))
//{
//	break;
//}
//
//}
Thread.sleep(2000);
SearchText st = new SearchText(driver);
st.SearchText(prdName);
st.Search();
//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(prdName);
//driver.findElement(By.xpath("//input[@name='search']")).click();

//Dynamic Xpath
//driver.findElement(By.xpath("//a[text()='"+NAme+"']")).click();
driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
wlib.windowSwitching(driver,"Campaigns&action");
//Set<String> allWin1 = driver.getWindowHandles();
//Iterator<String> win1 = allWin1.iterator();
//
//while(win1.hasNext())
//{
//	String winText1 = win1.next();
//driver.switchTo().window(winText1);
//String title1 = driver.getTitle();
//
//if(title1.contains("Campaigns&action"))
//{
//	break;
//}
//
//}

String campName = elib.getDataFormatterdata("Campaign",0,0)+ranNum;
CreateCampaignPage campaign = new CreateCampaignPage(driver);
campaign.campaignName(campName);
//driver.findElement(By.name("campaignname")).sendKeys(campName);
	
//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//driver.findElement(By.linkText("Sign Out")).click();
home1.Logout(driver);
	}

	}


