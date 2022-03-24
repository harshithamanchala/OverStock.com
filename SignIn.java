package account;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SignIn
{
	WebDriver wd;
	@Test
	
  public void signup() throws IOException, InterruptedException 
	
  {
		Thread.sleep(5000);
		WebElement add=wd.findElement(By.xpath("//button[@class='cl-dialog-close']"));
		add.click();
		Thread.sleep(5000);
		WebElement account=wd.findElement(By.xpath("//div[@class='UserDropDowns_alertStabilizer_9d']"));
		account.click();
		//for referring the file we want to open
		File f=new File("Data/SignupLoginData.xlsx");

		//for opening the file in read mode
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wk=new XSSFWorkbook(fis);
		//for referring the sheet we want to read
		XSSFSheet sh1= wk.getSheet("Sheet2");		
		
		int size1= sh1.getLastRowNum();	// last index of sheet 
		for (int i=0; i<=size1; i++)
		{
			String u=sh1.getRow(i).getCell(0).toString();
			String p=sh1.getRow(i).getCell(1).toString();
			String p1=sh1.getRow(i).getCell(2).toString();
			System.out.print(u + "      |       " +p+ "        |   "+p1+"    |     ");
			WebElement username=wd.findElement(By.id("createEmailInput"));
			username.clear();
			
			WebElement password=wd.findElement(By.id("createPasswordInput1"));
			password.clear();
			
			WebElement password1=wd.findElement(By.id("createPasswordInput2"));
			password1.clear();
			
			
			username.sendKeys(u);
			password.sendKeys(p);
			password1.sendKeys(p1);
			try
			{
				WebElement create=wd.findElement(By.xpath("//button[@class='os-btn btn-lg info']"));
				create.click();
			}
			catch(Exception e)
			{
				System.out.print(" ---------Invalid username/password");
			}
			System.out.println();	
				
		}
	 }
	@BeforeTest
	public void beforeTest() 
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
