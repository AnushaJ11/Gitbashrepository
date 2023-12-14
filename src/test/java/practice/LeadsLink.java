package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeadsLink {

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
		String lastname = "Jetti";
		String companyname = "Gitam";
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sweety");
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Jetti");
		driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("Gitam");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String leadlink = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(leadlink.contains(lastname)) {
			System.out.println("Last name is assigned");
		}
		else
		{
			System.out.println("Last name is not assigned");
		}
		if(leadlink.contains(companyname)) {
			System.out.println("Comapany name is assigned");
		}
		else
		{
			System.out.println("Company name is not assigned");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
