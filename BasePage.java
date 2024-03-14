package BasicPom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;
import pom_ObjectRepository.*;
import pom_ObjectRepository.*;
import pom_ObjectRepository.*;
import pom_ObjectRepository.*;

public class BasePage
{
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Object creation
		PropertyFileUtil util = new PropertyFileUtil();
		ExcelUtil eutil = new ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		JavaUtil jutil = new JavaUtil();
		
		//To read data from property file
		String BROWSER = util.getDataFromPropertyFile("Browser");
		String URL = util.getDataFromPropertyFile("Url");
		String USERNAME = util.getDataFromPropertyFile("Username");
		String PASSWORD = util.getDataFromPropertyFile("Password");
		
		//To read data from Excel file
		String ORGNAME = eutil.getDataFromExcel("Orgnizations", 0, 1);
		String GROUP = eutil.getDataFromExcel("Orgnizations", 1, 1);
		
		
		//To launch the browser
		
		if(BROWSER.equals("Chrome")) {
		driver = new ChromeDriver();	
		}else if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		//To maximize the browser window
		driver.manage().window().maximize();
		//To Launch the application
		driver.get(URL);
		
		//Create Object of LoginPage
		//Login to the application
		LoginPage lp = new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		
	    //Create Object of HomePage
		HomePage hp = new HomePage(driver);
		hp.Home();
		
	
	   //Create Object of OrganizationsPage
		OrgnizationsPage op =new OrgnizationsPage(driver);
		op.Organizations();
		
		
	   //Create Object of OrganizationInformationPage
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
        oip.OrganizationInformation(ORGNAME+jutil.getRandomNumber(), GROUP);
	
	   Thread.sleep(2000);
	
	  hp.Home(driver);
	

	
	}

}
