package addtocart;

import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AddToCart {
	WebDriver wd;
	  @Test
public void ProductSearch() throws InterruptedException 
  {
		  	
		  Thread.sleep(5000);
			WebElement add=wd.findElement(By.xpath("//button[@class='cl-dialog-close']"));
			add.click();
		  	Thread.sleep(5000);
			WebElement account=wd.findElement(By.xpath("//div[@class='UserDropDowns_alertStabilizer_9d']"));
			account.click();
			
			WebElement username=wd.findElement(By.id("loginEmailInput"));
			username.sendKeys("manchalaharshitha@gmail.com");
			
			WebElement password=wd.findElement(By.id("loginPasswordInput"));
			password.sendKeys("Abcd@123");
			
			WebElement search=wd.findElement(By.xpath("//header/div[2]/div[2]/div[2]/form[1]/div[1]/input[1]"));
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			search.sendKeys("coffee table");
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			WebElement searchclick=wd.findElement(By.xpath("//header/div[2]/div[2]/div[2]/form[1]/button[2]"));
			wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			searchclick.click();
			 
			
			String win = wd.getWindowHandle();	// storing the current window handle
			WebElement productclick=wd.findElement(By.xpath("//body/div[@id='search-nav-page']/div[@id='bd']/div[@id='sn-wrapper']/main[1]/div[1]/div[2]/div[2]/div[1]/div[2]/article[1]/a[1]/div[1]/div[1]/div[2]/img[1]"));
			Thread.sleep(9000);
			productclick.click();
			System.out.println("done1");
			
			
			for(String win1 : wd.getWindowHandles())
			{
				wd.switchTo().window(win1);			//  Switching to new window opened
			}

			Thread.sleep(9000);
			//wd.findElement(By.cssSelector("img[alt='Off-White/Black']")).click();
			//wd.findElement(By.xpath("img[alt='Off-White/Black']//body/div[@id='product-page']/div[@id='bd']/section[@id='mainContent']/section[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/button[1]/div[1]/img[1]")).click();
			//wd.findElement(By.linkText("Black / White Faux Marble")).click();
			wd.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/section[1]/section[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/button[1]/div[1]/img[1]")).click();
			System.out.println("done2");
			
			WebElement addtocart=wd.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
			addtocart.click();
			System.out.println("done3");
			
			
	  
}
@BeforeTest
	public void beforeTest() throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.overstock.com/");
		
	}

	@AfterTest
	public void afterTest()
	{
		wd.quit();
	}

}
