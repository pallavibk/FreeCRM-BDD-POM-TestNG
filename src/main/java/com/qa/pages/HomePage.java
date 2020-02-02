package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.qa.Base.Base;

public class HomePage extends Base {
	//define pagefactory
			@FindBy(xpath="//td[contains(text(),'Pallavi Kundagol')]")
			WebElement username;
					
			@FindBy(xpath="//a[contains(text(),'Contacts')]")
			WebElement contactLink;
			
			@FindBy(xpath="//a[contains(text(),'New Contacts')]")
			WebElement newcontactLink;
			
			
			
			public HomePage()
			{
				PageFactory.initElements(driver, this);
			}
			
			public String VerifyHomePageTitle()
			{
				return driver.getTitle();
			}
			public boolean VerifyUsernamedisplayed()
			{
				return username.isDisplayed();
				
			}
			
		public void  ClickOnNewContactsLink()
		{
			Actions action=new Actions(driver);
			action.moveToElement(contactLink).build().perform();
			newcontactLink.click();
			}
		
		

}
