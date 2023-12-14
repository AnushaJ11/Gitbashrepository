package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWith_AbsoluteXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/anush/Downloads/Locators%20demo.html");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[1]")).sendKeys("Anusha");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[2]")).sendKeys("Jetti");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[4]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/form/input[6]")).sendKeys("4Anush");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[7]")).sendKeys("4Anush");
		driver.findElement(By.xpath("/html/body/div[2]/form/button[1]")).click();
	}

}
