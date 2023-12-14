package pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPlusSign {
	public OrganizationPlusSign(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement accname;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	public WebElement getAccname() {
		return accname;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public void accountname(String name)
	{
		accname.sendKeys(name);
	}
	public void Clicksavebutton()
	{
		saveButton.click();
	}
}
