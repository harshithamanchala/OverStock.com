package titles;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CheckingTheTitle 
{
	WebDriver wd;
  @Test
  public void f() 
  {
	  String Actual = wd.getTitle();
      String Expected = "Overstock.com | The Best Deals Online: Furniture, Bedding, Jewelry & More";   //--Exact title
    //  String Expected = "Overstock.com | Online: Furniture, Bedding, Jewelry & More";					//wrong title

      if (Actual.equals(Expected)) {
                 System.out.println("Test Passed!");
      }
     
      else {
                 System.out.println("Test Failed");
      }
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
