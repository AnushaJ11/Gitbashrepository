package product;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomrepository.CreateProductPage;
import pomrepository.DeleteProductPage;
import pomrepository.HomePage;
import pomrepository.LoginPage;
import pomrepository.ProductPlusSign;

public class Createproduct_deleteproduct {

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

		//driver.get("http://localhost:8888/");
		
		String URL = flib.getkeyandValueData("url");
		String USERNAME = flib.getkeyandValueData("username");
		String PASSWORD = flib.getkeyandValueData("password");
		driver.get(URL);
		//Hardcoding
		/*
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		*/
		//BusinessLogic
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		HomePage home = new HomePage(driver);
		home.clickonProduct();
		
		ProductPlusSign plus = new ProductPlusSign(driver);
		plus.clickProductPlus();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
		//Random Approach To avoid Duplicates
	//Random ran = new Random();
//	int ranNum = ran.nextInt(1000);
		
	//String NAme = "Phone"+ranNum;
		//driver.findElement(By.name("productname")).sendKeys(NAme);
		//System.out.println(NAme);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getDataFormatterdata("Product",0,0)+ranNum;
		CreateProductPage product = new CreateProductPage(driver);
		product.productName(prdName);
		product.clickOnSaveButton();
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
		Thread.sleep(2000);
		
//driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
	DeleteProductPage del = new DeleteProductPage(driver);
	del.Deleteprd();
driver.findElement(By.xpath("//a[text()='"+prdName+"']/../preceding-sibling::td/input")).click();
del.Deleteprddata();
//driver.findElement(By.xpath("//input[@value='Delete']")).click();
//Alert alt = driver.switchTo().alert();
//alt.accept();
Webdriver_Utility wlib = new Webdriver_Utility();
wlib.Alertaccept(driver);
//validation
/*List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));

boolean flag=false;

for (WebElement prd : prdList)
{
	String actData = prd.getText();//phone456
	if(actData.contains(NAme))//phone360
	{
		flag=true;
		break;
	}
}*/
/*if(flag)
{
	System.out.println("product deleted");
}
else
{
	System.out.println("Product not deleted");
}*/
DeleteProductPage page = new DeleteProductPage(driver);

//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}
	}
