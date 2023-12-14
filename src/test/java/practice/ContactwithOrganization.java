package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactwithOrganization {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("C:\\Users\\anush\\OneDrive\\Desktop\\selenium\\propertiesfile.txt");
		Properties pobj = new Properties();
		pobj.load(fis);
		System.out.println(pobj.getProperty("url"));
		System.out.println(pobj.getProperty("un"));
		System.out.println(pobj.getProperty("pwd"));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		String Name="qspiders1109" + ranNum;
		driver.findElement(By.name("accountname")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	}

}
