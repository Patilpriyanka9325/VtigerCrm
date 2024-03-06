package vtigerCRM;

import java.io.IOException;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.ListenerImplementation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

//Assignment:-
//1.Launch http://localhost:8888
//2.Enter Username---admin
//3.Enter Password---admin
//4.click on login button
//5.clickon orgnization---(+)syambol
//6.click on createorgnization
//7.Enter orgnization name(company name)
//8.In assigned to ---click on group(radio button)
//9.select support group from dropdown


@Listeners(ListenerImplementation.class)
public class Orgnization
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
	   public void OrgnizationTest() throws IOException, InterruptedException
	   {
		   WebDriver driver = new ChromeDriver();//here we craete obj of chromedriver class and upcasted to the webdriver
		   wutil.manage(driver);
		   wutil.Implicitwait(driver);
		  
		 
		   //To Read data from property file
		   String URL= putil.getDataFromPropertyFile("Url");
	       String Username= putil.getDataFromPropertyFile("Username");
	       String Password= putil.getDataFromPropertyFile("Password");
	     
	       
	       String ORGNINAME = eutil.getDataFromExcel("Orgnizations", 0, 1);
	       String GROUP = eutil.getDataFromExcel("Orgnizations", 1, 1);
	       
	       //To launch the application
		   driver.get(URL);
	   
	      driver.findElement(By.name("user_name")).sendKeys(Username);
	      driver.findElement(By.name("user_password")).sendKeys(Password);
	      driver.findElement(By.id("submitButton")).click();
	      
	      //click on orgnizations
	      driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	      driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	      driver.findElement(By.name("accountname")).sendKeys(ORGNINAME+jutil.getRandomNumber());
	      
	      driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	      
	      driver.findElement(By.name("assigned_group_id")).click();
	      
	      WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	      wutil.handledropdown(dropdown, GROUP);
	      
	      //click on save button
	      driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
	      
	      Thread.sleep(2000);
	      //Mousehover on image
	      WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	       wutil.mousehover(driver, image);
	       
	       //click on signout
	       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	       
	      
	     
	}
}
