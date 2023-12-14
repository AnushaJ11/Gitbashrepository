package pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="campaignname")
	private WebElement createCampaign;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	public WebElement getCreateCampaign() {
		return createCampaign;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public void campaignName(String Name)
	{
		createCampaign.sendKeys(Name);
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
}
