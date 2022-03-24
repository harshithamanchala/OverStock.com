package careers;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class careers {
	WebDriver wd;
	@Test
	public void f() throws InterruptedException {
		Thread.sleep(5000);
		WebElement add=wd.findElement(By.xpath("//button[@class='cl-dialog-close']"));
		add.click();

		//Thread.sleep(2000);
		WebElement careers=wd.findElement(By.xpath("//body/div[@id='ft']/footer[1]/div[2]/div[1]/div[1]/div[3]/a[2]"));
		System.out.println("done1");

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,1600)");
		js.executeScript("arguments[0].scrollIntoView();",careers);
		Thread.sleep(9000);
		careers.click();
		Thread.sleep(9000);
		System.out.println("done2");
		WebElement viewopenpositions=wd.findElement(By.linkText("View Open Positions"));
		JavascriptExecutor js1 = (JavascriptExecutor) wd;
		js1.executeScript("window.scrollBy(0,270)");
		// js1.executeScript("arguments[0].scrollIntoView();",viewopenpositions);
		Thread.sleep(2000);
		viewopenpositions.click(); 
		System.out.println("done3");
		Thread.sleep(9000);

		for(String win1 : wd.getWindowHandles())
		{
			wd.switchTo().window(win1);			//  Switching to new window opened
		}

		Thread.sleep(9000);
		//WebElement SeniorSiteReliabilityDeveloper=wd.findElement(By.linkText("Senior Site Reliability Developer")); 
		WebElement SeniorSiteReliabilityDeveloper=wd.findElement(By.xpath("//a[contains(text(),'Senior Software Engineer - Ireland')]")); 
		SeniorSiteReliabilityDeveloper.click();
		System.out.println("done4");
		Thread.sleep(2000);
		WebElement applytojob=wd.findElement(By.linkText("Apply")); 
		applytojob.click();
		System.out.println("done5");
		Thread.sleep(2000);
		WebElement usemylastapplication=wd.findElement(By.linkText("Use My Last Application")); 
		usemylastapplication.click();
		Thread.sleep(2000);
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
