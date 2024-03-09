package BasicPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://demoapp.skillrary.com/");
        
        //click on login
        driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
        
        //enter admin in email textfield
         WebElement emailtf = driver.findElement(By.id("email"));
		 emailtf.sendKeys("admin");
      	 emailtf.clear();
		 
		 //Enter user in emailtf
		 emailtf.sendKeys("user");
		 
		
		 
		

	}

}
