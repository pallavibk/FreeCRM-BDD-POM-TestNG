package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import com.qa.util.CustomListners;
import com.qa.Base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;


public class loginPageStepDefinition extends Base
{
	LoginPage loginPage;
	HomePage homePage;
	
	public loginPageStepDefinition()
	{
		super();
		
	}
	@When("^user is already Logged in$")
	public void user_is_already_Logged_in() throws Throwable {
		initialization();
 		loginPage = new LoginPage();
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() throws Throwable {
		String title =loginPage.validateLoginPageTitle();
 		assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.."); 
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navbar navbar-default navbar-fixed-top skrollable skrollable-between']/div/div[@class='col-sm-4 col-md-4 pull-right']/form[@class='navbar-form']/div/div[@class='input-group-btn']/input")));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); 
	}

		 	
 	
}

