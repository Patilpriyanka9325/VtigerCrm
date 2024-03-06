package vtigerCRM;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.ListenerImplementation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

//Assignment2:Contacts
//1.Launch http://localhost:8888
//2.Enter Username---admin
//3.Enter Password---admin
//4.click on login button
//5.clickon Contacts--(+)syambol
//6.click on createorgnization
//7.click on first name
//8.click on last name
//9.In assigned to ---click on group(radio button)
//10.select team selling group from dropdown
//Enter the orgnization name
//step1:click on (+)-->it is in the parent window
//step2:Enter orgnization name-->it is in the child window
//stpe3:Click on search now button-->this is also in the child window
//step4:click on orgnization name-->child window
//save contact module
//logout contact module

@Listeners(ListenerImplementation.class)
public class Contacts 
{
	    //creating the object propertyfileutil
		PropertyFileUtil putil = new PropertyFileUtil();
		
		//creating the object of webdriverutil
		WebDriverUtil wutil = new WebDriverUtil();
		
		//creating obj of excelutil
		ExcelUtil eutil = new ExcelUtil();
			
		//crating obj of javautil
		JavaUtil jutil = new JavaUtil();
		
		@Test
		public void ContactTest() throws IOException, InterruptedException
		{
			//To launch empty browser
			WebDriver driver = new ChromeDriver();//here we craete obj of chromedriver class and upcasted to the webdriver
			
			//To maximize browser button
			wutil.manage(driver);
			//To Apply implicit wait for findelement
			wutil.Implicitwait(driver);
			  
			  //To Read data from property file
			  String URL= putil.getDataFromPropertyFile("Url");
		      String Username= putil.getDataFromPropertyFile("Username");
		      String Password= putil.getDataFromPropertyFile("Password");
		      
		      //To read data from excel file
		      String FIRSTNAME = eutil.getDataFromExcel("Contacts", 0, 1);
		      String LASTNAME = eutil.getDataFromExcel("Contacts", 1, 1);
		      String GROUP = eutil.getDataFromExcel("Contacts", 2, 1);
		      String ORGNAME = eutil.getDataFromExcel("Contacts", 3, 1);
		      
		      //To launch the application
			   driver.get(URL);
		   
			   //Login to the application
		      driver.findElement(By.name("user_name")).sendKeys(Username);
		      driver.findElement(By.name("user_password")).sendKeys(Password);
		      driver.findElement(By.id("submitButton")).click();
		      
		      //To click on contacts
		      driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		      
		      //to click on create contacts...(+)
		      driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		      
		      //To enter the firstname
		      driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		      driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		      
		      WebElement notifycheckbox = driver.findElement(By.name("notify_owner"));
		      //To fail the testscript
		      // Assert.assertTrue(notifycheckbox.isSelected());//using assrtTrue condition
		      //To failing the testscript we use here assertEquals method intentionally we add pune in url
		      String actualurl = driver.getCurrentUrl();
		      String expectedurl = "http://localhost:8888/pune/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		      Assert.assertEquals(actualurl, expectedurl);
		      
		      //Click on radio button
		      driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		      
		      //In dropdown select Team Seeling
		      WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		      wutil.handledropdown(dropdown, GROUP);
		      
		      //Click on select(+) in orgnization name text field
		      driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		      
		      //Transfer the control from parent to child 
		      wutil.switchwindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
              
		     //To enter the orgnization name in searchtf
		      driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		      
		      //To click on search now button
		      driver.findElement(By.name("search")).click();
		      
		      //click on orgnization name
		      driver.findElement(By.xpath("//a[text()='TCS9']")).click();
		      
		      //To transfer the control child window to parent
		      wutil.switchwindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		      
		      //click on save button
		      driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		      
		      Thread.sleep(2000);
		      //To take screenshot of contact
		     // wutil.screenshot(driver, "Contact");
		      
		      Thread.sleep(2000);
		      //Mousehover on image
		      WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		      wutil.mousehover(driver, image);
		       
		      //click on signout
		      driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		      
		      
		       
		      
		      
		      
		}
}
