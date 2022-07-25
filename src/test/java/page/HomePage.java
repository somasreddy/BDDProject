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

public class HomePage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[.='Student Login']")
	public WebElement studenLoginLink;
	
	@FindBy(how = How.NAME,using = "username")
	public WebElement userNameTextBx;
	
	public HomePage(WebDriver driver)
	{
		HomePage.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,20);
	}
	
	public void openHomePage()
	{
		driver.get("https://www.softest-training.com/index.php");
	}
	
	
	public void clickStudentLogin() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(studenLoginLink));
		studenLoginLink.click();		
		Reporter.log(driver.getCurrentUrl(),true);
	}
	
	public void VerifyLoginPage() {
		   boolean logout = false;
			 try {
				 logout=userNameTextBx.isDisplayed();
				 Reporter.log("LoginPage is displayed", true);
			 }
			 catch(Exception e) {
				 Reporter.log("LoginPage  is not displayed", true);
			 }
			 Assert.assertEquals(logout, true);
				
		  }
	
}
