package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.LoginPage;
import page.studentPage;
import runner.firstTestRunner;


public class firstTest extends firstTestRunner {
	HomePage homepage= new HomePage(driver);
	LoginPage loginPage= new LoginPage(driver);
	studentPage studentPage= new studentPage(driver);
	
	@When("I enter pageUrl {string}")
	public void i_enter_page_url(String string) {
	    homepage.openHomePage();
	}

	@When("I click on StudentLogin Link")
	public void i_click_on_student_login_link() {
	    homepage.clickStudentLogin();

	}

	@Then("I should see Login page")
	public void i_should_see_login_page() {
	
	    homepage.VerifyLoginPage();
	}

	@When("I enter username {string}")
	public void i_enter_username(String username) {
	    
	    loginPage.enterUserName(username);
	}

	@When("I enter password  {string}")
	public void i_enter_password(String password) {
	    
	    loginPage.enterPassword(password);
	}

	@When("I click submit button")
	public void i_click_submit_button() {
	    
	    loginPage.clickSubmit();
	}

	@When("Credentials are wrong Error should be displayed")
	public void credentials_are_wrong_error_should_be_displayed() {
	  loginPage.VerifyErrorMessage();
	}

	@When("Credentials are correct student homepage to be displayed")
	public void credentials_are_correct_student_homepage_to_be_displayed() {
		loginPage.verifyStudentpage();
	}

	@When("I click on Logout link")
	public void i_click_on_logout_link() {
		studentPage.clicklogOut();
	}

	@Then("I should be in home page")
	public void i_should_be_in_home_page() {
	    studentPage.verifyHomePage();
	    
	}
}
