package runner;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions
(
		plugin = {"pretty",
						"html:results/cucumber/cucumber.html",
						"json:results/cucumber/cucumber.json",
						"junit:results/cucumber/cucumber.xml"
						},
		features = {"src/test/resources/featureFiles"},
		glue = { "stepDefinition"},	tags = "@tagLoginFeature"
)

public class firstTestRunner extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	public static String fn;
	public static WebDriverWait wait;
	
	
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
		wait=new WebDriverWait(driver,20);
		
	}
	@AfterTest
	public void CloseBrowser()
	{
		//driver.close();
		driver.quit();
	}
	@Test
	public void myTest()
	{
		Reporter.log("Test for Cucumber",true);
	}
}
