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


public class LoginPage {
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	public LoginPage(WebDriver driver)
	{
		LoginPage.driver = driver;
		 PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,20);
	}
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "username")
	public WebElement userNameTextBx;
	
	@FindBy(how = How.NAME,using = "password")
    public WebElement pwdTxtBx;
	
	@FindBy(how = How.NAME,using = "btn_login")
	public WebElement submitBtn;
	
	@FindBy(how = How.XPATH,using = "//span[.='Failed to login']")
	public WebElement LoginError;
	
	@FindBy(how = How.XPATH,using = "//a[.='Sign Out']")
	public WebElement logoutLink;
	
	public LoginPage enterUserName(String userName)
	{		
		 userNameTextBx.sendKeys(userName);
		return this;		
	}
	 
	 public LoginPage enterPassword(String password)
		{		
		 pwdTxtBx.sendKeys(password);
			return this;		
		}
	 
	 public LoginPage clickSubmit()
		{		
		 wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
			submitBtn.click();
			return new LoginPage(driver);	
		}
	 
	  public void VerifyErrorMessage()
		{
		 boolean errorMsgDisplay = false;
		 try {
			 errorMsgDisplay=LoginError.isDisplayed();
			 Reporter.log("Error Message is displayed", true);
		 }
		 catch(Exception e) {
			 Reporter.log("Error Message is not displayed", true);
		 }
		 Assert.assertEquals(errorMsgDisplay, true);
			
		 }
	 
	   public void verifyStudentpage() {
		   boolean logout = false;
			 try {
				 logout=logoutLink.isDisplayed();
				 Reporter.log("studentPage is displayed", true);
			 }
			 catch(Exception e) {
				 Reporter.log("studentPage is not displayed", true);
			 }
			 Assert.assertEquals(logout, true);
				
		  }
}
