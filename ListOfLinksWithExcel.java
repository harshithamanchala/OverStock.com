package listoflinks;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class ListOfLinksWithExcel 
{
  
	WebDriver wd;
	@Test
	public void write() throws IOException, InterruptedException 
	{
		Thread.sleep(5000);
		WebElement add=wd.findElement(By.xpath("//button[@class='cl-dialog-close']"));
		add.click();
		WebDriverWait wait1 = new WebDriverWait(wd, 90);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("a")));
		List<WebElement> links=wd.findElements(By.tagName("a"));

		int size=links.size();

		File f=new File("Data/ListOfLinks.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wk=new XSSFWorkbook(fis);
		XSSFSheet sh= wk.getSheet("Sheet1");
		FileOutputStream fos=new FileOutputStream(f);
		
		for (int i=0; i<size; i++)
		{

			String str=links.get(i).getText();
			sh.createRow(i).createCell(0).setCellValue(str);
		}


		wk.write(fos);
		fos.close();
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