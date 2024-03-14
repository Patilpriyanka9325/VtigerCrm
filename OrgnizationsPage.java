package pom_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationsPage
{
	   //Identify Create organization..(+)
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement createorganization;

		public WebElement getCreateorganization() {
			return createorganization;
		}
		
		//Create a Constructor
		public OrgnizationsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Create a Method
		public void Organizations() {
		//Click on Create organization..(+)
		createorganization.click();
			
		
		
}
		
}
