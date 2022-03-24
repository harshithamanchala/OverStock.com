package listoflinks;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.testng.annotations.BeforeTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ListOfLinks {
	
		WebDriver wd;
		@Test
		public void ListOfLinks() throws InterruptedException
		{
			Thread.sleep(5000);
			WebElement add=wd.findElement(By.xpath("//button[@class='cl-dialog-close']"));
			add.click();
			Thread.sleep(3000);
			List<WebElement> links=wd.findElements(By.tagName("a"));
			
			int size=links.size();
			System.out.println("No.of links are " +size);
			for (int i=0; i<size; i++)
			{
				System.out.println(links.get(i).getText());

			}
		}
		@BeforeTest
		public void beforeTest() 
		{
			WebDriverManager.chromedriver().setup();
			wd=new ChromeDriver();
			wd.manage().window().maximize();
			wd.get("https://www.overstock.com/");
		}

		@AfterTest
		public void afterTest() 
		{
			wd.close();
		}

	}
