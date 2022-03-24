package seachingproduct;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Searching
{

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

		Thread.sleep(5000);
		WebElement username=wd.findElement(By.id("loginEmailInput"));
		username.sendKeys("manchalaharshitha@gmail.com");

		Thread.sleep(5000);
		WebElement password=wd.findElement(By.id("loginPasswordInput"));
		password.sendKeys("Abcd@123");

		Thread.sleep(5000);
		WebElement search=wd.findElement(By.xpath("//header/div[2]/div[2]/div[2]/form[1]/div[1]/input[1]"));
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		search.sendKeys("coffee table");
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement searchclick=wd.findElement(By.xpath("//header/div[2]/div[2]/div[2]/form[1]/button[2]"));
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		searchclick.click();
		System.out.println("Searching done");
		/*WebElement hide=wd.findElement(By.xpath("//p[contains(text(),'Hide')]"));
			hide.click();*/



	}
	@BeforeTest
	public void beforeTest() throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.overstock.com/");
		Thread.sleep(9000);
	}

	@AfterTest
	public void afterTest()
	{
		wd.quit();
	}

}
