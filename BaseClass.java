package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	//driver is global variable
	public WebDriver driver; //here we make driver as global variable-->it is giving nullpointer exception
	
	//WebDriver driver = new ChromeDriver();

	//creating the object of webdriverutil
	WebDriverUtil wutil = new WebDriverUtil();
	
    //creating the object propertyfileutil
	PropertyFileUtil putil = new PropertyFileUtil();
	
   @BeforeSuite
   public void BS()
   {
	  System.out.println("Connect to Data Base"); 
   }
   @BeforeClass
   public void BC() throws IOException 
   {
	   //WebDriver driver = new ChromeDriver();
	   //@BeforeClass is used to launch application
	   //To Read data from property file
	   String BROWSER = putil.getDataFromPropertyFile("Browser");
	   String URL= putil.getDataFromPropertyFile("Url");
	   
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
	   
	   wutil.manage(driver);
	   wutil.Implicitwait(driver);
	   
	   //To launch the application
	   driver.get(URL);
   }
   @BeforeMethod
   public void BM() throws IOException
   {
	   //@BeforeMethod is used to login to the application
	   String Username= putil.getDataFromPropertyFile("Username");
	   String Password= putil.getDataFromPropertyFile("Password");
	   
	   //Login to the application
	   driver.findElement(By.name("user_name")).sendKeys(Username);
	   driver.findElement(By.name("user_password")).sendKeys(Password);
	   driver.findElement(By.id("submitButton")).click();
	   
   }
   @AfterClass
   public void AC()
   {
	  //@AfterClass is used to close the browser
	   
		   driver.quit();
	   
   }
   @AfterMethod
   public void AM() throws InterruptedException 
   {
	   Thread.sleep(2000);
	   //@AfterMethod is used to signout from the application
	   //Mousehover on image
	    WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	    wutil.mousehover(driver, image);
	       
	   //click on signout
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
   }
   @AfterSuite
   public void AS()
   {
	   System.out.println("Disconnect to Data base");
   }
   
}
