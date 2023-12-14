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
import io.github.bonigarcia.wdm.WebDriverManager;
import pomrepository.CampaignPlusSignPage;
import pomrepository.CreateCampaignPage;
import pomrepository.HomePage;
import pomrepository.LoginPage;
import pomrepository.ValidationPage;

public class CreateCampaign {

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
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//getter method
		/*LoginPage login = new LoginPage(driver);
		login.getUserTextField().sendKeys(USERNAME);
		login.getPasswordTextField().sendKeys(PASSWORD);
		login.getLoginButton().click();*/
		
		//Business logic
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		
		/*driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		*/
		
		HomePage home = new HomePage(driver);
		home.clickonMorelink();
		home.clickonCampaigns();
		CampaignPlusSignPage plus = new CampaignPlusSignPage(driver);
		plus.clickCampaignPlus();
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
		String campName = cell.getStringCellValue()+ranNum;*/
		Excel_Utility elib = new Excel_Utility();
		//String campName = elib.getExcelData("Campaign",0,0)+ranNum;
		String campName = elib.getDataFormatterdata("Campaign",0,0)+ranNum;
		//driver.findElement(By.name("campaignname")).sendKeys(campName);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateCampaignPage campaign = new CreateCampaignPage(driver);
		campaign.campaignName(campName);
		campaign.clickOnSaveButton();
		
		Thread.sleep(2000);
		//String campaignName = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		ValidationPage campValidate = new ValidationPage(driver);
		String actData = campValidate.getValidateCampaign().getText();
		if(actData.contains(campName))
		{
			System.out.println("Campaign Created");
		}
		else
		{
			System.out.println("Campaign not created");
		}
		
		System.out.println(campName);
	   //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click()
		home.Logout(driver);
		}

}
