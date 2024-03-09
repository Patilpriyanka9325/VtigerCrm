package BasicPom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;
import pom_ObjectRepository.HomePage;
import pom_ObjectRepository.LoginPage;
import pom_ObjectRepository.OrgnizationInformationPage;
import pom_ObjectRepository.OrgnizationsPage;

public class BasePage
{
   public static  WebDriver driver;
   public static void main(String[] args) throws IOException, InterruptedException 
   {
	   
	
	 //Object creation
	 PropertyFileUtil util = new PropertyFileUtil();
	 ExcelUtil eutil = new ExcelUtil();
	 WebDriverUtil wutil = new WebDriverUtil();
	 JavaUtil jutil = new JavaUtil();
	 
	 //To read from propertyfile
	 String BROWSER = util.getDataFromPropertyFile("Browser");
	 String USERNAME = util.getDataFromPropertyFile("Username");
	 String PASSWORD = util.getDataFromPropertyFile("Password");
	 String URL = util.getDataFromPropertyFile("Url");
	 
	 //To read data from excel file
	 String ORGNAME   = eutil.getDataFromExcel("Orgnizations", 0, 1);
	 String GROUP     = eutil.getDataFromExcel("Orgnizations", 1, 1);
	 
	 
	 //To launch the browser
	 if (BROWSER.equals("Chrome")) 
	 {
		driver = new ChromeDriver();
	 } 
	 else if (BROWSER.equals("Edge"))
	 {
		driver = new EdgeDriver();
	 } 
	 else
	 {
		driver = new FirefoxDriver();
	 }
	 
	
		
	
	
	//To maximize the browser window
	driver.manage().window().maximize();
   
    //To launch the application
    driver.get(URL);
    
    //create object of LoginPage
    LoginPage lp = new LoginPage();
    
    //To initialize the webelement
    PageFactory.initElements(driver, lp);
    
    //Login to the application
    lp.getUsernametf().sendKeys(USERNAME);
    lp.getPasswordtf().sendKeys(PASSWORD);
    lp.getLoginbtn().click();
    
    
    //Create object of HomePage
    HomePage hp = new HomePage();
    
    //To initialize the webelement
    PageFactory.initElements(driver, hp);
    //click on orgnization
    hp.getOrgnization().click();
    
    //create obeject of orgnizationspage
    OrgnizationsPage op = new OrgnizationsPage();
    PageFactory.initElements(driver, op);
    //click on create orgnization(+)
    op.getCreateorgnization().click();
    
    //create object of orgnizationinformationpage
    OrgnizationInformationPage oip = new OrgnizationInformationPage();
    PageFactory.initElements(driver, oip);
    //enter orgnizationname
    oip.getOrgnizationnametf().sendKeys(ORGNAME+jutil.getRandomNumber());
    //click on group radio btn
    oip.getGroupbtn().click();
    
    //select support group in dropdown
    wutil.handledropdown(oip.getDropdown(), GROUP);
    
    //click on save button
    oip.getSavebtn().click();
    
    Thread.sleep(2000);
    //Mousehover on image
    wutil.mousehover(driver, hp.getImage());
    
    //click on signoutbtn
    hp.getSignoutbtn().click();
   
    
    }
}
