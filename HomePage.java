package pom_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class HomePage extends WebDriverUtil 
{
	//Identify Organization
		@FindBy(xpath="(//a[text()='Organizations'])[1]")
		private WebElement organizations;
		
		//Identify Contact
		@FindBy(xpath="//a[text()='Contacts']")
		private WebElement contacts;
		
		//Identify image
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement image;
		
		//Identify Signout
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement signoutbtn;

		public WebElement getOrganizations() {
			return organizations;
		}

		public WebElement getContacts() {
			return contacts;
		}

		public WebElement getImage() {
			return image;
		}

		public WebElement getSignoutbtn() {
			return signoutbtn;
		}
		
		//Create a comstructor
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Create a Method
		public void Home() {
			//Click on Organizations
			organizations.click();
		}
		
		public void Home(WebDriver driver) {
			//Mouse hover on image
			mousehover(driver, image);
			//Click on signout button
			signoutbtn.click();
		}
}
