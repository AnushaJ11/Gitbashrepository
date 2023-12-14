package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomrepository.CreateProductPage;
import pomrepository.DeleteProductPage;
import pomrepository.Deleteprooduct_Validation;
import pomrepository.HomePage;
import pomrepository.LoginPage;
import pomrepository.ProductPlusSign;

public class Createpro_deleteproduct {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
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
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		HomePage home = new HomePage(driver);
		home.clickonProduct();
		
		ProductPlusSign plus = new ProductPlusSign(driver);
		plus.clickProductPlus();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
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
		
		DeleteProductPage del = new DeleteProductPage(driver);
		del.Deleteprd();
	driver.findElement(By.xpath("//a[text()='"+prdName+"']/../preceding-sibling::td/input")).click();
	del.Deleteprddata();
	//driver.findElement(By.xpath("//input[@value='Delete']")).click();
	//Alert alt = driver.switchTo().alert();
	//alt.accept();
	Webdriver_Utility wlib = new Webdriver_Utility();
	wlib.Alertaccept(driver);
	Deleteprooduct_Validation page = new Deleteprooduct_Validation(driver);
	page.validateProduct(driver,prdName);
	Thread.sleep(2000);
	home.Logout(driver);
	}

}
