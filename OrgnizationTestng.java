package vtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class OrgnizationTestng extends BaseClass
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
			   String ORGNAME = eutil.getDataFromExcel("Orgnizations", 0, 1);
		       String GROUP = eutil.getDataFromExcel("Orgnizations", 1, 1);
		       
              //click on orgnizations
		      driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		      
		      //click on create orgnization
		      driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		      
		      //eNTER ORGNIZATION NAME
		      driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
		      
		      //IN assigned to click on group
		      driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		      
		      //
		      driver.findElement(By.name("assigned_group_id")).click();
		      
		      WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		      wutil.handledropdown(dropdown, GROUP);
		      
		      //click on save button
		      driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		      
		      

		       
		      
		     
		}
}
