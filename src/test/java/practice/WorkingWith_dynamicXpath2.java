package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWith_dynamicXpath2 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.partialLinkText("Digital downloads")).click();
		List<WebElement> allAddtocart = driver.findElements(By.xpath("//input[@value='Add to cart']"));
		for(WebElement allTocart : allAddtocart)
		{
			allTocart.click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		List<WebElement> allRemoveCb = driver.findElements(By.xpath("//table[@class=\"cart\"]//input[@type=\"checkbox\"]"));
		for(WebElement removeCB : allRemoveCb)
		{
			removeCB.click();
		}
		driver.findElement(By.name("updatecart")).click();
	}

}
