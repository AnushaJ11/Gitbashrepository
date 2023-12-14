package pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.Webdriver_Utility;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText= "More")
	private WebElement moreLink;
	
	@FindBy(linkText= "Campaigns")
	private WebElement CampaignsLink;

	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;
	@FindBy(linkText="Products")
	private WebElement ProductLink;
	//LOgOut
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminisatorSign;
		
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	@FindBy(xpath="//img[@alt='Select']")	
	private WebElement Select;
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrg;
	public WebElement getCreateOrg() {
		return createOrg;
	}



	public WebElement getSelect() {
		return Select;
	}

	

	public WebElement getAdminisatorSign() {
		return AdminisatorSign;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getProductLink() {
		return ProductLink;
	}
	
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}
	public void clickonMorelink() {
		moreLink.click();
	}
	public void clickonCampaigns() {
		CampaignsLink.click();
	}
	public void clickonOrganizations()
	{
		OrganizationsLink.click();
	}
	public void clickonProduct()
	{
		ProductLink.click();
	}
	public void Logout(WebDriver driver)
	{
		 //Actions act = new Actions(driver);
		// act.moveToElement(AdminisatorSign);
		// signOutLink.click();
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.Actionsmoveelement(driver, AdminisatorSign);
		signOutLink.click();
	}
	public void Select() {
		Select.click();
	}
	public void CreateOrganization()
	{
		createOrg.click();
	}
}
