package pomrepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPlusSign {
	public ProductPlusSign(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement productplus;
	public WebElement getProductplus() {
		return productplus;
	}
	public void clickProductPlus()
	{
		productplus.click();
	}
}
