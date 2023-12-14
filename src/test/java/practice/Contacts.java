package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Contacts {

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
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String firstname= "Jetti";
		String lastname = "Anusha";
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Jetti");
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Anusha");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		String contactdetails = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactdetails.contains(firstname)) {
			System.out.println("Firstname assigned");
		}
		else
		{
			System.out.println("Firstname not assigned");
		}
		Thread.sleep(2000);
		
	if(contactdetails.contains(lastname)) {
		System.out.println("Lastname assigned");
	}
	else
	{
		System.out.println("Lastname not assigned");
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}
	}

