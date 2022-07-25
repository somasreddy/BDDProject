package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class studentPage extends LoginPage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	public studentPage(WebDriver driver)
	{
		super(driver);
		studentPage.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,20);
	}
	
	@CacheLookup
	@FindBy(how = How.XPATH,using = "//a[.='Home ']")
	public WebElement homePage;
	
	public studentPage clicklogOut()
	{		
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
		logoutLink.click();
	 return new studentPage(driver);	
	}
	
	public void verifyHomePage() {
		   boolean homeLink = false;
			 try {
				 homeLink=homePage.isDisplayed();
				 Reporter.log("Home page is displayed", true);
			 }
			 catch(Exception e) {
				 Reporter.log("Home page is not displayed", true);
			 }
			 Assert.assertEquals(homeLink, true);
				
		  }
	
}
