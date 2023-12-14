package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility {
	public void maximizingWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizingWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void implicity_wait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void explicity_wait(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait ( driver , Duration.ofSeconds ( 10 ) );
	}
	public void Fluent_Wait(WebDriver driver)
	{
		FluentWait fw = new FluentWait(driver);
		fw.pollingEvery(Duration.ofSeconds(1));
		fw.ignoring(TimeoutException.class);
		fw.withTimeout(Duration.ofSeconds(10));
		fw.until(ExpectedConditions.alertIsPresent());
	}
	public static void clickonOkAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public static void selectDropDownByVisibleText(WebElement dropDown,String visibleText)
	{
		Select s = new Select(dropDown);
		s.selectByVisibleText(visibleText);
	}
	public static void selectDropDownByValue(WebElement dropDown,String value)
	{
		Select s = new Select(dropDown);
		s.selectByValue(value);
	}
	public static void selectDropdownByIndex(WebElement dropDown,int Index)
	{
		Select s = new Select(dropDown);
		s.selectByIndex(Index);
	}
	public void windowSwitching(WebDriver driver,String partialVisibleTest)
	{
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> win = allWin.iterator();
		while(win.hasNext())
		{
			String winText = win.next();
			driver.switchTo().window(winText);
			String title = driver.getTitle();
			if(title.contains(partialVisibleTest))
			{
				break;
			}
		}
	}
	
	public static String getTextFromAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		String altText=alt.getText();
		return altText;
	}
	public void Actionsmoveelement(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	public void JavaScriptExecutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	public void Alertaccept(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public void Alertdismiss(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	
}
