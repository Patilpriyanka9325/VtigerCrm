package pom_ObjectRepository;

import CommonUtils.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage 
{
    WebDriverUtil wutil = new WebDriverUtil();
	
	
	//Identify Organization name
	@FindBy(name="accountname")
	private WebElement organizationnametf;
	
	
	//Identify group radio button
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement groupbtn;
	
	//Identify the dropdown
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
	
	//Identify Save button
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebtn;
	
	
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getGroupbtn() {
		return groupbtn;
	}

	public WebElement getOrganizationnametf() {
		return organizationnametf;
	}
	
	//Create a Constructor 
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Create a Method
	public void OrganizationInformation(String Orgnamedata,String groupdata) {
		
		//Enter Organizationname
		organizationnametf.sendKeys(Orgnamedata);
		//Click on group radio button
		groupbtn.click();
		//Select support group in the dropdown
		wutil.handledropdown(dropdown, groupdata);
		//Click on Save button	
		savebtn.click();
	}
	
	
	
}
