package filters;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Filters {
	WebDriver wd;
	@Test
	public void f() throws InterruptedException 
	{
		Thread.sleep(5000);
		WebElement add=wd.findElement(By.xpath("//button[@class='cl-dialog-close']"));
		add.click();
		Thread.sleep(5000);
		WebElement Furniture=wd.findElement(By.linkText("Furniture"));    //Furniture
		Furniture.click();
		Thread.sleep(5000);
		WebElement topratedcoffeetable=wd.findElement(By.xpath("//body/div[@id='__next']/div[@id='search-nav-page']/div[@id='bd']/main[@id='sn-wrapper']/section[1]/div[1]/a[1]/div[3]/span[1]/img[1]"));     //
		topratedcoffeetable.click();
		System.out.println("done1");

		Thread.sleep(3000);
		wd.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/main[1]/div[1]/div[2]/div[1]/nav[1]/div[2]/div[1]/div[1]/h2[1]/button[1]")).click();
		Thread.sleep(3000);
		WebElement endT= wd.findElement(By.id("types-EndTables"));
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("arguments[0].click();", endT);
		Thread.sleep(3000);
		System.out.println("done2");

		WebElement sidetable=wd.findElement(By.xpath("//body/div[@id='search-nav-page']/div[@id='bd']/div[@id='sn-wrapper']/main[1]/div[1]/div[2]/div[2]/div[1]/div[2]/article[1]/a[1]/div[1]"));
		sidetable.click();
		Thread.sleep(3000);
		for(String win1 : wd.getWindowHandles())
		{
			wd.switchTo().window(win1);			//  Switching to new window opened
		}
		System.out.println("done3");
		WebElement selectingcolour=wd.findElement(By.xpath("//body/div[@id='product-page']/div[@id='bd']/section[@id='mainContent']/section[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/button[1]/div[1]/img[1]")); 
		selectingcolour.click();
		System.out.println("done4");
		Thread.sleep(3000);
		WebElement AddToCart=wd.findElement(By.id("addCartMain_addCartButton"));
		AddToCart.click();
		System.out.println("done5");
		Thread.sleep(3000);
		WebElement checkout=wd.findElement(By.id("stationaryButtonDesktop"));
		checkout.click();
		Thread.sleep(3000);
		System.out.println("done6");




	}
	@BeforeTest
	public void beforeTest() throws InterruptedException 
	{

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

