package addtofavorites;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AddToFavorites {
	WebDriver wd;
	@Test
	public void f() throws InterruptedException 
	{
		Thread.sleep(5000);
		WebElement add=wd.findElement(By.xpath("//button[@class='cl-dialog-close']"));
		add.click();
		WebElement rugs=wd.findElement(By.linkText("Rugs"));
		rugs.click();
		System.out.println("done1");
		
		WebElement arearugs=wd.findElement(By.linkText("Area Rugs"));
		arearugs.click();
		System.out.println("done2");
		
		WebElement sizeofrugs=wd.findElement(By.xpath("//div[contains(text(),\"5' x 8'\")]"));
		sizeofrugs.click();
		System.out.println("done3");
		
		WebElement selectedrug=wd.findElement(By.xpath("//body/div[@id='search-nav-page']/div[@id='bd']/div[@id='sn-wrapper']/main[1]/div[1]/div[2]/div[2]/div[1]/div[2]/article[1]/a[1]/div[1]/div[2]"));
		selectedrug.click();
		System.out.println("done4");
		
		WebElement addtofav=wd.findElement(By.xpath("//body/div[@id='search-nav-page']/div[@id='bd']/div[@id='sn-wrapper']/main[1]/div[1]/div[2]/div[2]/div[1]/div[2]/article[1]/div[1]/div[1]"));
		addtofav.click();
		System.out.println("done4");
		
		
		
		
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
