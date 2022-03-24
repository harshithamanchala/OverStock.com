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

public class Login 
{
	WebDriver wd;
	@Test
	public void login() throws IOException, InterruptedException 
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
		//XSSFSheet sh1= wk.getSheet("Sheet1");		// mobile no.
		XSSFSheet sh2= wk.getSheet("Sheet1");		//email ids
		int size1= sh2.getLastRowNum();	
		for (int i=0; i<=size1; i++)
		{
			String u=sh2.getRow(i).getCell(0).toString();
			String p=sh2.getRow(i).getCell(1).toString();
			WebElement username=wd.findElement(By.id("loginEmailInput"));
			//WebElement username=wd.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[4]/div[2]/form[1]/div[1]/input[1]"));
			username.clear();

			WebElement password=wd.findElement(By.id("loginPasswordInput"));
			//WebElement password=wd.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[4]/div[2]/form[1]/div[2]/input[1]"));
			password.clear();

			username.sendKeys(u);
			password.sendKeys(p);

			try
			{
				WebElement login=wd.findElement(By.xpath("//body/div[@id='login-page']/div[@id='bd']/div[1]/div[4]/div[2]/form[1]/div[3]/button[1]"));
				login.click();
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
