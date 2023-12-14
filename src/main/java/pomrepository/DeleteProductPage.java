package pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {
	public DeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//a[text()='Products'])[1]")
	private WebElement deleteprd;
	//@FindBy(xpath="//a[text()='"+prdName+"']/../preceding-sibling::td/input")
	//private WebElement prdname;
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteprddata;
	@FindBy(xpath ="(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]")
	public WebElement validateproduct;

	public WebElement getValidateproduct() {
		return validateproduct;
	}
	public WebElement getDeleteprddata() {
		return deleteprddata;
	}
	public WebElement getDeleteprd() {
		return deleteprd;
	}
	public void Deleteprd() {
		deleteprd.click();
	}
	public void Deleteprddata() {
		deleteprddata.click();
	}
	
}
