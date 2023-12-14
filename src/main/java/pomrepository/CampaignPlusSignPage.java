package pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPlusSignPage {
	public CampaignPlusSignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt='Create Campaign...']")
			private WebElement campaignPlus;
	public WebElement getCampaignPlus() {
		return campaignPlus;
	}
	public void clickCampaignPlus()
	{
		campaignPlus.click();
	}
}
