package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.qa.Base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class loginPageStepDefinition extends Base
{
	LoginPage loginPage;
	HomePage homePage;
	
	public loginPageStepDefinition()
	{
		super();
		
	}
	@Before
	 public void Beforehook()
	 {
		String broser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("broser");
		initialization(broser);
 		loginPage = new LoginPage();
	 }
	 
	
	@When("^user is already Logged in$")
	public void user_is_already_Logged_in() throws Throwable {
		System.out.println("user is logged in");
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
	 @After
	 public void Afterhook(Scenario scenario) throws IOException
	 {
		 System.out.println("I'm here in afterHook");
		 scenario.write("finished scenario");
		 if(scenario.isFailed())
		 {
			 System.out.println("afterHook:- Inside failure block");
			 byte[] ScreenshotBytes=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			 scenario.embed(ScreenshotBytes, "image/png");
//			 File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			 System.out.println("File path:- "+file.getAbsolutePath());
			 // file.createNewFile();
			 File file = new File("C:\\Users\\somapurshiva\\Pictures\\Screenshot-.png");
			 FileOutputStream fos = new FileOutputStream(file);
			 fos.write(ScreenshotBytes);
			 fos.close();
		}
		 if(driver!=null)
		 {
			 driver.quit();
		 }
	 }

		 	
 	
}

