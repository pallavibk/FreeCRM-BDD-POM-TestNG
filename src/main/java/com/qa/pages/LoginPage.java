package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.HomePage;
import com.qa.Base.Base;

public class LoginPage extends Base {
	//define pagefactory
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@class='btn btn-small']")
		WebElement loginBtn;
		
		@FindBy(xpath="//a[contains(text(),'Sign Up')]")
		WebElement SignUpBtn;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		WebElement crmLogo;
		
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//define all the required methods
		
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean validateCRMImage()
		{
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un,String pwd)
		{
			username.sendKeys("kpallavi");
			password.sendKeys("kpallavi");
			loginBtn.click();
			
			return new HomePage();
			}
		
}
