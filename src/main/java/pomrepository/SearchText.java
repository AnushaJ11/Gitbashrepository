package pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchText {
	public SearchText(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement SearchText;
	@FindBy(xpath="//input[@name='search']")
	private WebElement Search;
	public WebElement getSearchText() {
		return SearchText;
	}
	public WebElement getSearch() {
		return Search;
	}
	public void SearchText(String Name)
	{
		SearchText.sendKeys(Name);
	}
	public void Search()
	{
		Search.click();
	}
}
