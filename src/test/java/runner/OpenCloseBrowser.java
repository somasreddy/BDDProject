package runner;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCloseBrowser
{
	public static WebDriver driver;
	public static String fn;
	
	
	@Parameters("browser")
	@BeforeTest
	public void OpenBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("ff"))
		{
			WebDriverManager.firefoxdriver().setup();			
			driver=new FirefoxDriver();			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();		
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();			
			driver=new ChromeDriver();  
		}
		else
		{
			Reporter.log("No browser defined",true);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@AfterTest
	public void CloseBrowser()
	{
		//driver.close();
		driver.quit();
	}
	public void OpenHomePage(String url)	{
		driver.get(url);
		Reporter.log("Home Title : " + driver.getTitle(),true);
	}
}
